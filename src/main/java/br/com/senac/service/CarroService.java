package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Carro;
import br.com.senac.repository.CarroRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CarroService {
	
	@Autowired
	CarroRepository repository;
	
	public Carro search(Integer id) throws ObjectNotFoundException{
		Optional<Carro> carro = repository.findById(id);
		
		return carro.orElseThrow(() -> new ObjectNotFoundException ("não encontrado. id:" +id+ ", Tipo!" + Carro.class.getName()));
		
	}
	
	public List<Carro> searchAll(){
		return repository.findAll();
	}
	
	public Carro save (Carro carro) {
		return repository.save(carro);
	}
	
	public List<Carro> saveAll(List<Carro> carros){
		return repository.saveAll(carros);
	}
	
	public Carro edit (Carro carro)throws ObjectNotFoundException{
		Carro carroAntigo = search(carro.getId());
		
		carroAntigo.setId(carro.getId());
		carroAntigo.setModelo(carro.getModelo());
		carroAntigo.setChave(carro.getChave());
		return save(carroAntigo);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
