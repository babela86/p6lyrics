package dei.uc.pt.ar;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lyricsSearch.ChartLyricsRest;
import lyricsSearch.ChartLyricsSoap;
import lyricsSearch.LyricsWikiaRest;

@RequestScoped
@Named
public class SearchMusicsServer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String artist;
	private String title;
	private int idMusica;
	private String lyric = null;
	private String lyricResult = null;

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

	private int idUserActivo;
	private boolean onOff;

	// private void (int idMusica) {
	//
	// this.artist = artist;
	// this.title = title;
	//
	// }

	// falta ver se o user ja tem esta letra guardada

	public void renderOFF() {
		setOnOff(false);

	}

	public void searchLyrics(String artist, String title, int idMusica) {
		this.idUserActivo = ui.getActiveUser().getIdUtilizador();
		this.idMusica = idMusica;
		this.artist = artist;
		this.title = title;

		List<Lyric> list = ld.findLyricsByUser(idUserActivo);
		if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getUtilizador().getIdUtilizador() == idUserActivo
						&& list.get(i).getMusica().getIdMusic() == idMusica) {
					setLyricResult(list.get(i).getLyric());
				} else {
					searchL(artist, title);
				}
			}
		} else {
			searchL(artist, title);
		}

		// System.out.println(getLyricResult());

		setOnOff(true);

	}

	public void searchL(String artist, String title) {

		lyric = clsoap.searchLyrics(artist, title);
		if (lyric != null) {
			setLyricResult(lyric);
		} else {
			// setLyricResult("Não foi encontrada a letra no soap do chart");
			lyric = clrest.searchLyrics(artist, title);
			if (lyric != null) {
				setLyricResult(lyric);
			} else {
				// setLyricResult("Não foi encontrada a letra no rest d chart");
				lyric = lwrest.searchLyrics(artist, title);
				if (lyric != null) {
					setLyricResult(lyric);
				} else {
					setLyricResult("Não foi encontrada a letra em nenhum dos servidores");
				}
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

}
