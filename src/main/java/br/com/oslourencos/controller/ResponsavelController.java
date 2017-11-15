package br.com.oslourencos.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.oslourencos.model.ResponsavelModel;
import br.com.oslourencos.repository.ResponsavelRepository;
import br.com.oslourencos.uteis.Uteis;

@Named(value="cadastrarResponsavelController")
@RequestScoped
public class ResponsavelController {

	@Inject
	ResponsavelModel responsavelModel;

	@Inject
	UsuarioController usuarioController;

	@Inject
	ResponsavelRepository responsavelRepository;

	public ResponsavelModel getResponsavelModel(){
		return this.responsavelModel;
	}

	public void setResponsavelModel(ResponsavelModel responsavelModel){
		this.responsavelModel = responsavelModel;
	}

	public void addNovoResponsavel(){
		responsavelModel.setUsuarioModel(this.usuarioController.GetUsuarioSession());
		
		// origem do dados - atraves dos inputs
		responsavelModel.setOrigemCadastro("I");
		
		responsavelRepository.addResponsavel(this.responsavelModel);
		
		this.responsavelModel = null;
		
		Uteis.MensagemInfo("Registro cadastrado com sucesso !!");
		
	}
}
