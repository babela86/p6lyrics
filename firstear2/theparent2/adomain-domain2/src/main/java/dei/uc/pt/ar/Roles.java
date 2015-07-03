package dei.uc.pt.ar;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRoleUtilizador;
	
	@Column(name = "role_name", nullable = false, unique = false)
	private String role;

	// uma Role pode ter varios utilizadores
	//
	//@ManyToMany
	//@JoinColumn(name = "id_util")
	//private List<Utilizador> utilizador;

	@ManyToOne
	@JoinColumn(name = "id_util", nullable = false, unique = false)
	private Utilizador utilizador;
	
	public Roles() {
	}
	
	public Roles(String role, Utilizador utilizador) {
		super();
		this.utilizador = utilizador;
		this.role = role;
	}

	public int getIdRoleUtilizador() {
		return idRoleUtilizador;
	}

	public void setIdRoleUtilizador(int idRoleUtilizador) {
		this.idRoleUtilizador = idRoleUtilizador;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
