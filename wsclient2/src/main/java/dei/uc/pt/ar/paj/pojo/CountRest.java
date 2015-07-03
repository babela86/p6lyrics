package dei.uc.pt.ar.paj.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="contador")
public class CountRest {
	private String contador;

	public CountRest() {
	}
	
	public CountRest(int contador) {
		super();
		this.contador = ""+contador;
	}
	
	public CountRest(long contador) {
		super();
		this.contador = ""+contador;
	}
	
	public CountRest(String contador) {
		super();
		this.contador = contador;
	}

	
	public String getContador() {
		return contador;
	}
	public void setContador(String contador) {
		this.contador = contador;
	}

	
	@Override
	public String toString() {
		return "[ Total = " + contador + " ]";
	}
	
	
}
