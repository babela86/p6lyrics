package dei.uc.pt.ar.paj.pojo;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MusicCollection {
	
	private List<MusicRest> musicList;
	
	//Getter e Setter para musicList
	public List<MusicRest> getMusicList() {
		return musicList;
	}
	public void setMusicList(List<MusicRest> musiclist) {
		this.musicList = musiclist;
	}

	@Override
	public String toString() {
		return  "---------------------------\n" +
				"    Listagem de músicas:\n" + 
				"---------------------------\n" +
				musicList + "\n";
	}
}
