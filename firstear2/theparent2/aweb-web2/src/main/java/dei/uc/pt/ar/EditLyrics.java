package dei.uc.pt.ar;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SessionScoped
@Named
public class EditLyrics implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(EditLyrics.class
			.getName());

	private FacesMessage msg = null;

	@Inject
	private SearchMusicsServer sms;

	@Inject
	private UserInput ui;

	@Inject
	private MusicDAO md;

	@Inject
	private UserDAO ud;

	@Inject
	private SaveLyric sl;

	private int idMusica = 0;
	private int idUserActivo = 0;
	private String lyricEdited = null;
	private String artistTitle = null;

	public String lyricToEdit() {

		this.idMusica = sms.getIdMusica();
		this.idUserActivo = ui.getActiveUser().getIdUtilizador();
		this.lyricEdited = sms.getLyricResult();
		this.artistTitle = sms.getArtistTitle();
		return "editLyrics.xhtml?redirect=true";
	}

	public void saveLyric() {
		try {
			Utilizador utilizador = ud.findUserById(this.idUserActivo);
			Musica musica = md.getMusic(idMusica);
			Lyric l = new Lyric(this.lyricEdited, utilizador, musica);
			msg = new FacesMessage(sl.saveL(l), "ERROR MSG");
			if (FacesContext.getCurrentInstance() != null)
				FacesContext.getCurrentInstance().addMessage(null, msg);
			log.info("Edited Lyric saved");
		} catch (Exception e) {
			// System.out.println(e);
			log.error("An error ocurred when saving edited lyrics: "
					+ e.getMessage());
		}
	}

	public int getIdMusica() {
		return idMusica;
	}

	public void setIdMusica(int idMusica) {
		this.idMusica = idMusica;
	}

	public int getIdUserActivo() {
		return idUserActivo;
	}

	public void setIdUserActivo(int idUserActivo) {
		this.idUserActivo = idUserActivo;
	}

	public String getLyricEdited() {
		return lyricEdited;
	}

	public void setLyricEdited(String lyricEdit) {
		this.lyricEdited = lyricEdit;
	}

	public String getArtistTitle() {
		return artistTitle;
	}

	public void setArtistTitle(String artistTitle) {
		this.artistTitle = artistTitle;
	}

}
