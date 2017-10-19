package br.com.oslourencos.repository;

import java.time.LocalDateTime;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.oslourencos.entity.ResponsavelEntity;
import br.com.oslourencos.model.ResponsavelModel;
import br.com.oslourencos.uteis.Uteis;

public class ResponsavelRepository {
	
	@Inject
	ResponsavelEntity responsavelEntity;
	
	EntityManager entityManager;
	
	public void addResponsavel(ResponsavelModel responsavelModel){
		entityManager = Uteis.JpaEntityManager();
		
		responsavelEntity = new ResponsavelEntity();
		
		responsavelEntity.setDataCadastro(LocalDateTime.now());
		responsavelEntity.setEmail(responsavelModel.getEmail());
		responsavelEntity.setTelefone(responsavelModel.getTelefone());
		responsavelEntity.setNome(responsavelModel.getNome());
		responsavelEntity.setSexo(responsavelModel.getSexo());
		responsavelEntity.setEndereco(responsavelModel.getEndereco());
		responsavelEntity.setOrigemCadastro(responsavelModel.getOrigemCadastro());
		
		
		
	}

}
