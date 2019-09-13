package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senac.domain.Chave;
import br.com.senac.repository.ChaveRepository;
import javassist.tools.rmi.ObjectNotFoundException;

public class ChaveService {
	
	@Autowired
	ChaveRepository repository;
	
	public Chave search(Integer id) throws ObjectNotFoundException{
		Optional<Chave> chave = repository.findById(id);
		
		return chave.orElseThrow(() -> new ObjectNotFoundException ("não encontrado. id:" +id+ ", Tipo!" + Chave.class.getName()));
		
	}
	
	public List<Chave> searchAll(){
		return repository.findAll();
	}
	
	public Chave save (Chave chave) {
		return repository.save(chave);
	}
	
	public List<Chave> saveAll(List<Chave> chaves){
		return repository.saveAll(chaves);
	}
	
	public Chave edit (Chave chave)throws ObjectNotFoundException{
		Chave chaveAntiga = search(chave.getId());
		
		chaveAntiga.setId(chave.getId());
		//chaveAntiga.setModelo(chave.getModelo());
		return save(chaveAntiga);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}


}
