package dei.uc.pt.ar.paj.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import dei.uc.pt.ar.Utilizador;

@XmlRootElement(name="utilizador")
public class UserRest {
	private int idUtilizador;
	private String email;
	private String name;
	private String password;
	private Date birthdate;
	
	public UserRest() {
	}
	
	public UserRest(int idUtilizador, String email, String name,
			String password, Date birthdate) {
		super();
		this.idUtilizador = idUtilizador;
		this.email = email;
		this.name = name;
		this.password = password;
		this.birthdate = birthdate;
	}

	public UserRest(Utilizador u) {
		super();
		this.idUtilizador = u.getIdUtilizador();
		this.email = u.getEmail();
		this.name = u.getName();
		this.password = u.getPassword();
		this.birthdate = u.getBirthdate();
	}

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
