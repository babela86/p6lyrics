package dei.uc.pt.ar;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "letras")
public class Lyric implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idLyric;

	@Column(name = "lyric", length = 3500, nullable = true)
	private String lyric;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_util")
	private Utilizador utilizador;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_music")
	private Musica musica;

	public Lyric() {
		super();
	}

	public Lyric(String lyric, Utilizador utilizador, Musica musica) {
		super();
		this.lyric = lyric;
		this.utilizador = utilizador;
		this.musica = musica;
	}

	public int getIdLyric() {
		return idLyric;
	}

	public void setIdLyric(int idLyric) {
		this.idLyric = idLyric;
	}

	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}

	public Utilizador getUtilizador() {
		return utilizador;
	}

	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}

}
