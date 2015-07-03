package dei.uc.pt.ar.paj.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="contador")
public class StringRest {
	private String text2transfer;
	
	//Construtor
	public StringRest() {
	}
	
	public StringRest(String contador) {
		super();
		this.text2transfer = ""+contador;
	}

	//Getters e Setters
	public String getText2transfer() {
		return text2transfer;
	}
	public void setText2transfer(String text2transfer) {
		this.text2transfer = text2transfer;
	}


	@Override
	public String toString() {
		return "[Texto transferido = " + text2transfer + " ]";
	}
	
	
}
