package dei.uc.pt.ar.adomain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
		@NamedQuery(name = "SimpleUser.findAll", query = "SELECT user FROM SimpleUser user"),
		@NamedQuery(name = "SimpleUser.findByName", query = "SELECT user FROM SimpleUser user WHERE user.username = :username"),
		@NamedQuery(name = "SimpleUser.findById", query = "SELECT user FROM SimpleUser user WHERE user.id = :id") })
@XmlRootElement
public class SimpleUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
	private Long id;

	@Column
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return id + " " + username;

	}
}