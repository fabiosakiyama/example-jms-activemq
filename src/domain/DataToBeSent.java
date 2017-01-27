package domain;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DataToBeSent {

	private int numberData;

	private String stringData;
	
	private Double doubleData;
	
	
	private Set<Item> itens = new HashSet<>();

	public int getNumberData() {
		return this.numberData;
	}

	public void setNumberData(int numberData) {
		this.numberData = numberData;
	}

	public String getStringData() {
		return this.stringData;
	}

	public void setStringData(String stringData) {
		this.stringData = stringData;
	}

	public Double getDoubleData() {
		return this.doubleData;
	}

	public void setDoubleData(Double doubleData) {
		this.doubleData = doubleData;
	}

	@XmlElementWrapper(name = "itens")
	@XmlElement(name = "item")
	public Set<Item> getItens() {
		return this.itens;
	}

	public void setItens(Set<Item> itens) {
		this.itens = itens;
	}

	public void defaultData() {
		this.numberData = 5;
		this.stringData = "Product Name";
		this.doubleData = 249.2;
		Set<Item> itens = new HashSet<>();
		itens.add(new Item("Banana", 5));
		itens.add(new Item("Apple", 51));
		this.itens = itens;
		
	}
}
