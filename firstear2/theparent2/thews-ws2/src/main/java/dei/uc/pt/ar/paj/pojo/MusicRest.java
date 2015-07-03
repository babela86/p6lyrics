package dei.uc.pt.ar.paj.pojo;

import javax.xml.bind.annotation.XmlRootElement;

import dei.uc.pt.ar.Musica;


@XmlRootElement(name="musica")
public class MusicRest {
	private int idMusic;
	private String title;
	private String artist;
	private String album;
	private String year;
	private String path;

	public MusicRest() {
		super();
	}
	
	public MusicRest(int idMusic, String title, String artist, String album,
			String year, String path) {
		super();
		this.idMusic = idMusic;
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.year = year;
		this.path = path;
	}
	
	public MusicRest(Musica m) {
		super();
		this.idMusic = m.getIdMusic();
		this.title = m.getTitle();
		this.artist = m.getArtist();
		this.album = m.getAlbum();
		this.year = m.getYear();
		this.path = m.getPath();
	}
	
	public int getIdMusic() {
		return idMusic;
	}
	public void setIdMusic(int idMusic) {
		this.idMusic = idMusic;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "[idMusic=" + idMusic + 
			   ", title=" + title + 
			   ", artist=" + artist + 
			   ", album=" + album + 
			   ", year=" + year + 
			   ", path=" + path + "]\n";
	}
}