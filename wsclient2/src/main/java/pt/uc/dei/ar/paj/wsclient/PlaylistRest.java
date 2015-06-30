package pt.uc.dei.ar.paj.wsclient;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="playlist")
public class PlaylistRest {
	private String name;
	private int idPlaylist;


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
