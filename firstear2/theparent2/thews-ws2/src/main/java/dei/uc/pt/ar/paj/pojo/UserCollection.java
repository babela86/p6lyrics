package dei.uc.pt.ar.paj.pojo;

import java.util.ArrayList;
import java.util.List;

//import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import dei.uc.pt.ar.Utilizador;

@XmlRootElement
public class UserCollection {
	
	//@XmlElement(name="utilizador")
	private ArrayList<UserRest> userList;
	
	public UserCollection() {
	}
	
	public UserCollection(List<Utilizador> convUserList) {
		super();
		this.userList = new ArrayList<UserRest>();
		for (Utilizador u: convUserList) {
			this.userList.add(new UserRest(u));
		}
	}
	
	//Getter e Setter para userList
	public ArrayList<UserRest> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<UserRest> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return  "---------------------------\n" +
				" Listagem de utilizadores:\n" + 
				"---------------------------\n" +
				userList + "\n";
	}
}