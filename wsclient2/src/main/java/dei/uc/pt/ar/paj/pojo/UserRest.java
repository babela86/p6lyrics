package dei.uc.pt.ar.paj.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="utilizador")
public class UserRest {
	private int idUtilizador;
	private String email;
	private String name;
	private String password;
	private Date birthdate;

	public int getIdUtilizador() {
		return idUtilizador;
	}
	public void setIdUtilizador(int idUtilizador) {
		this.idUtilizador = idUtilizador;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	@Override
	public String toString() {
		return "[idUtilizador=" + idUtilizador + ", email="
				+ email + ", name=" + name + ", password=" + password
				+ ", birthdate=" + birthdate + "]\n";
	}

}
