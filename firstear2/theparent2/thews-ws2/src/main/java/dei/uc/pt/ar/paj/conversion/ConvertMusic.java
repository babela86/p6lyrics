package dei.uc.pt.ar.paj.conversion;

import java.util.ArrayList;
import java.util.List;

import dei.uc.pt.ar.Musica;
import dei.uc.pt.ar.paj.pojo.MusicRest;

public class ConvertMusic {
	//Converter List<Musica> para List<MusicRest>
	public List<MusicRest> ListMusicToListMusicRest(List<Musica> lista){
		List<MusicRest> returnList = new ArrayList<MusicRest>();
		for (Musica m: lista) {
			returnList.add( new MusicRest(m) );
		}
		return returnList;
	}
	
	
	
	
}
