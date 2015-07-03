package dei.uc.pt.ar.paj.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import dei.uc.pt.ar.Musica;

@XmlRootElement
public class MusicCollection {
	
	private ArrayList<MusicRest> musicList;
	
	//construtor sem parametros
	public MusicCollection() {
	}
	
	//construtor a partir de uma lista de musicas
	public MusicCollection(List<Musica> lista) {
		this.musicList = new ArrayList<MusicRest>();
		for (Musica m: lista) {
			this.musicList.add(new MusicRest(m));
		}
	}
	
	//Getter e Setter para musicList
	public ArrayList<MusicRest> getMusicList() {
		return musicList;
	}
	public void setMusicList(ArrayList<MusicRest> musiclist) {
		this.musicList = musiclist;
	}

	@Override
	public String toString() {
		return  "---------------------------\n" +
				"    Listagem de m�sicas:\n" + 
				"---------------------------\n" +
				musicList + "\n";
	}
}
