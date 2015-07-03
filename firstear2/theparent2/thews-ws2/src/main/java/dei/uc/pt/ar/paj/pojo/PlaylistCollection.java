package dei.uc.pt.ar.paj.pojo;

import java.util.ArrayList;
import java.util.List;

//import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import dei.uc.pt.ar.Playlist;

@XmlRootElement()
public class PlaylistCollection {
	
	//@XmlElement(name="playlist")
	private List<PlaylistRest> listaPlaylist;
	
	//construtor sem parametros
	public PlaylistCollection() {
	}
	
	//construtor a partir de uma lista de playlists
	public PlaylistCollection(List<Playlist> lista) {
		super();
		this.listaPlaylist = new ArrayList<PlaylistRest>();
		for (Playlist m: lista) {
			this.listaPlaylist.add(new PlaylistRest(m));
		}
	}
	
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