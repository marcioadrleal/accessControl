package br.com.controle.acesso.service.person;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controle.acesso.database.domain.person.Telephone;
import br.com.controle.acesso.database.domain.person.TelephoneType;
import br.com.controle.acesso.database.repositories.person.TelephoneRepository;
import br.com.controle.acesso.database.repositories.person.TelephoneTypeRepository;
import br.com.controle.acesso.exception.DataSaveException;
import br.com.controle.acesso.exception.ObjectNotFoundException;

@Service
public class TelephoneService {

	@Autowired
	private TelephoneRepository repo;

	@Autowired
	private TelephoneTypeRepository repoTelephoneType;

	public Telephone insert(Telephone telephone) {

		if (telephone.getPhoneType() == null) {
			throw new ObjectNotFoundException("Obrigatório informar o Tipo de telefone");
		}

		try {
			Optional<TelephoneType> tel = repoTelephoneType.findById(telephone.getPhoneType().getId());
			telephone.setPhoneType(
					tel.orElseThrow(() -> new ObjectNotFoundException("Tipo de Telefone não cadastrado.")));
			repo.save(telephone);
		} catch (Exception e) {
			throw new DataSaveException(e.getMessage());
		}

		return null;

	}

}
