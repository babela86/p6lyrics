package dei.uc.pt.ar;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserLoged {
	private HashMap<Utilizador,Integer> hashlistalogados;

	public UserLoged() {
		hashlistalogados = new HashMap<Utilizador,Integer>();
	}
	

	
	public void add(Utilizador u){
		//Se existir utilizador incrementa o numero
		if ( hashlistalogados.keySet().contains(u) ) {
			hashlistalogados.put(u, hashlistalogados.get(u) + 1);
		} 
		// caso contrario adiciona utilizador com numero de sessoes 1
		else {
			hashlistalogados.put(u, 1);
		}
	}
	
	public void remove(Utilizador u){
		//Se existir utilizador decrementa o numero
		if ( hashlistalogados.keySet().contains(u) ) {
			hashlistalogados.put(u, hashlistalogados.get(u) - 1);
			//se for o ultimo
			if ( hashlistalogados.get(u) <= 0 ) {
				hashlistalogados.remove(u);
			}
		} 
	}
	
	public ArrayList<Utilizador> listLogedUsers() {
		ArrayList<Utilizador> listalogados = new ArrayList<Utilizador>();
		for (Utilizador u: hashlistalogados.keySet()) {
			listalogados.add(u);
		}
		return listalogados;
	}
	
	public int numberLogedUsers() {
		return listLogedUsers().size();
	}
}
