package dei.uc.pt.ar.paj.pojo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserCollection {
	
	//@XmlElement(name="utilizador")
	private ArrayList<UserRest> userList;
	
	
	
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