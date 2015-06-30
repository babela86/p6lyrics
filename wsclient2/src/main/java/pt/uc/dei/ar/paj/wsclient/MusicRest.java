package pt.uc.dei.ar.paj.wsclient;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="musica")
public class MusicRest {
	private int idMusic;
	private String title;
	private String artist;
	private String album;
	private String year;
	private String path;

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