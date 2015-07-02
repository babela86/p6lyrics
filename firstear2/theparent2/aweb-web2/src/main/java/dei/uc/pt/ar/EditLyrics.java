package dei.uc.pt.ar;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class EditLyrics implements Serializable {

	private static final long serialVersionUID = 1L;

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

	private int idMusica;
	private int idUserActivo;
	private String lyricEdited;

	public String lyricToEdit() {

		this.idMusica = sms.getIdMusica();
		this.idUserActivo = ui.getActiveUser().getIdUtilizador();
		this.lyricEdited = sms.getLyricResult();

		return "editLyrics.xhtml?redirect=true";
	}

	public void saveLyric() {
		try {
			Utilizador utilizador = ud.findUserById(this.idUserActivo);
			Musica musica = md.getMusic(idMusica);
			Lyric l = new Lyric(this.lyricEdited, utilizador, musica);
			sl.saveL(l);
		} catch (Exception e) {
			System.out.println(e);
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

}
