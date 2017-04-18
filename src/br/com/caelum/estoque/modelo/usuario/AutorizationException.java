package br.com.caelum.estoque.modelo.usuario;

import java.util.Date;

import javax.xml.ws.WebFault;

@WebFault(name="AutorizacaoFault")
public class AutorizationException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public AutorizationException(String mensagem ){
		super(mensagem);
		
	}
	
	public InfoFault getFaultInfo(){
		return new InfoFault("Token invalido" , new Date());
	}

}
