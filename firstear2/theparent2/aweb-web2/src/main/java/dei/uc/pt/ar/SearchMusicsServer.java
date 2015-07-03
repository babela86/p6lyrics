package dei.uc.pt.ar;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lyricsSearch.ChartLyricsRest;
import lyricsSearch.ChartLyricsSoap;
import lyricsSearch.LyricsWikiaRest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
@Named
public class SearchMusicsServer implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory
			.getLogger(SearchMusicsServer.class.getName());
	private String artist = null;
	private String title = null;
	private int idMusica = 0;
	private String lyric = null;
	private String lyricResult = null;
	private String artistTitle = null;
	private int idUserActivo = 0;
	private boolean onOff = false;

	@Inject
	private ChartLyricsSoap clsoap;
	@Inject
	private ChartLyricsRest clrest;
	@Inject
	private LyricsWikiaRest lwrest;

	@Inject
	private LyricDAO ld;

	@Inject
	private UserInput ui;

	public void renderOFF() {
		setOnOff(false);

	}

	// public void concatArtisTitle() {
	// setArtistTitle("Artist: \"" + artist + "\"  &  Song: \"" + title + "\"");
	// }

	public void searchLyrics(String artist, String title, int idMusica) {
		setLyricResult(null);
		setArtist(artist);
		setTitle(title);
		setIdMusica(idMusica);
		setIdUserActivo(ui.getActiveUser().getIdUtilizador());
		setArtistTitle("Artist: \"" + this.artist + "\"  &  Song: \""
				+ this.title + "\"");

		List<Lyric> list = ld.findLyricsByUser(idUserActivo);
		// System.out.println(list.size());
		try {
			if (list.isEmpty()) {
				searchL(artist, title);
				// System.out.println("entre1");
			} else {
				for (Lyric l : list) {
					if ((l.getUtilizador().getIdUtilizador() == this.idUserActivo)
							&& (l.getMusica().getIdMusic() == this.idMusica)) {
						setLyricResult(l.getLyric());
						log.info("Music founded in DB.");
					}
				}
				if (lyricResult == null) {
					searchL(artist, title);
					// System.out.println("entre2");
				}
			}

			setOnOff(true);
		} catch (Exception e) {

			log.error("An error ocurred in the search: " + e.getMessage());
		}

	}

	public void searchL(String artist, String title) {
		try {
			lyric = clsoap.searchLyrics(artist, title);
			if (lyric != null && !lyric.isEmpty()
					&& !lyric.equalsIgnoreCase("NOT FOUND")) {
				setLyricResult(lyric);
				log.info("Lyric found in the service Soap by ChartLyrics");
			} else {
				lyric = clrest.searchLyrics(artist, title);
				if (lyric != null && !lyric.isEmpty()
						&& !lyric.equalsIgnoreCase("NOT FOUND")) {
					setLyricResult(lyric);
					log.info("Lyric found in the service Rest by ChartLyrics");
				} else {
					lyric = lwrest.searchLyrics(artist, title);
					if (lyric != null && !lyric.isEmpty()
							&& !lyric.equalsIgnoreCase("NOT FOUND")) {
						setLyricResult(lyric);
						log.info("Lyric found in de service Rest by WikiaLyrics");
					} else {

						setLyricResult("Não foi encontrada a letra em nenhum dos servidores");
						log.info("Lyric not found");
					}
				}
			}
		} catch (Exception e) {
			if (e.getMessage() == null) {
				setLyricResult("Não foi encontrada a letra em nenhum dos servidores");
				log.info("Lyric not found");
			} else {
				log.error("An error ocurred in the search: " + e.getMessage());
			}
		}
	}

	public String getLyricResult() {
		return lyricResult;
	}

	public void setLyricResult(String lyricResult) {
		this.lyricResult = lyricResult;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getIdMusica() {
		return idMusica;
	}

	public void setIdMusica(int idMusica) {
		this.idMusica = idMusica;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}

	public boolean isOnOff() {
		return onOff;
	}

	public void setOnOff(boolean onOff) {
		this.onOff = onOff;
	}

	public String getArtistTitle() {
		return artistTitle;
	}

	public void setArtistTitle(String artistTitle) {
		this.artistTitle = artistTitle;
	}

	public int getIdUserActivo() {
		return idUserActivo;
	}

	public void setIdUserActivo(int idUserActivo) {
		this.idUserActivo = idUserActivo;
	}

}
