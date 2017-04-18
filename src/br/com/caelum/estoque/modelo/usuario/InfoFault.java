package br.com.caelum.estoque.modelo.usuario;

import java.util.Date;

public class InfoFault {

	private Date dataErro;
    private String mensagem;

    public InfoFault(String mensagem, Date dataErro) {
        this.mensagem = mensagem;
        this.dataErro = dataErro;
    }

    //JAX-B precisa
    InfoFault() {
    }

}
