package dei.uc.pt.ar.paj.pojo;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class PlaylistCollection {
	
	//@XmlElement(name="playlist")
	private List<PlaylistRest> listaPlaylist;
	
	//Getter e Setter para listaPlaylist
	public List<PlaylistRest> getListaPlaylist() {
		return listaPlaylist;
	}
	public void setListaPlaylist(List<PlaylistRest> playlist) {
		this.listaPlaylist = playlist;
	}
	
	@Override
	public String toString() {
		return "Lista de playlists:\n" + listaPlaylist + "\n";
	}
}