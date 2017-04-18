package br.com.caelum.estoque.servico;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ListaItens;
import br.com.caelum.estoque.modelo.usuario.AutorizationException;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;
import br.com.caelum.estoque.modelo.usuario.Usuario;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	/**
	 * @WebMethod - renomear nomenclatura do nosso serviço.
	 * @WebResult - forma da nomenclaturo do retorno.
	 * @ResponseWrapper(localName="itens") - nomenclatura raiz do metodo pra
	 *                                     resposta do serviço
	 * @RequestWrapper(localName="listaItens") - nomenclatura raiz do metodo pra
	 *                                         Requisicao do serviço
	 * @return
	 */
	@WebMethod(operationName = "todosOsItens")
	@WebResult(name = "item")
	public ListaItens getItens(@WebParam(name = "filtros") Filtros filtros) {

		System.out.println("Chamando getItens");
		List<Filtro> lista = filtros.getLista();
		List<Item> result = dao.todosItens(lista);
		return new ListaItens(result);
	}

	/**
	 * Pensando na Auditoria ou segurança... de quem esta consumindo nosso
	 * serviço
	 * 
	 * @WebParam(name = "tokenUsuario", header=true) - parametro recebido no
	 *                header
	 * 
	 * @param item
	 * @return
	 * @throws AutorizationException
	 */
	@WebMethod(operationName = "CadastroItem")
	@WebResult(name = "item")
	public Item cadastrarItem(
			@WebParam(name = "tokenUsuario", header = true) TokenUsuario token,
			@WebParam(name = "item") Item item) throws AutorizationException {

		System.out.println("Cadastrando " + item + ", " + token);

		if (!new TokenDao().ehValido(token)) {
			throw new AutorizationException("Autorizacao falhou");
		}

		this.dao.cadastrar(item);
		return item;
	}

}