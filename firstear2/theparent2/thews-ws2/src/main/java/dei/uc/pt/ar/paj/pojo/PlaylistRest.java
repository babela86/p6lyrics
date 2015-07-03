package dei.uc.pt.ar.paj.pojo;

import javax.xml.bind.annotation.XmlRootElement;

import dei.uc.pt.ar.Playlist;

@XmlRootElement(name="playlist")
public class PlaylistRest {
	private String name;
	private int idPlaylist;
	
	//construtor sem parametros
	public PlaylistRest() {
		super();
	}
	
	//construtor
	public PlaylistRest(String name, int idPlaylist) {
		super();
		this.name = name;
		this.idPlaylist = idPlaylist;
	}
	
	//construtor
	public PlaylistRest(Playlist pl) {
		super();
		this.name = pl.getName();
		this.idPlaylist = pl.getIdPlaylist();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getIdPlaylist() {
		return idPlaylist;
	}
	public void setIdPlaylist(int idPlaylist) {
		this.idPlaylist = idPlaylist;
	}
	
	@Override
	public String toString() {
		return "[idPlaylist=" + idPlaylist + ", name=" + name + "]\n";
	}
}
