package br.com.alura.forum.config.validation;

public class ErroDeFormularioDto {
	
	private String campo;
	private String erro;
	
	public String getCampo() {
		return campo;
	}
	public String getErro() {
		return erro;
	}
	public ErroDeFormularioDto(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}

}
