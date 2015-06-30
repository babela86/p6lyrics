package pt.uc.dei.ar.paj.wsclient;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="collection")
public class UserCollection {
	
	@XmlElement(name="utilizador")
	private List<UserRest> userList;
	
	//Getter e Setter para userList
	public List<UserRest> getUserList() {
		return userList;
	}
	public void setUserList(List<UserRest> userList) {
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