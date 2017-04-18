package br.com.caelum.estoque.modelo.item;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**Utilizando o Jax-B para criar a nomenclatura correta
 * 
 * @XmlRootElement - aplicando o modelo para um xml
 * @XmlAccessorType(XmlAccessType.FIELD) - para que eles acessem pelos atributos e não pelos qets
 * 
 * @author tapower
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaItens {

	@XmlElement(name="item")// redefinir nome do elemento 
	private List<Item> itens;

	public ListaItens(List<Item> itens) {
		this.itens = itens;
	}

	ListaItens() {
	}
	
	public List<Item> getItens() {
		return itens;
	}
	
}
