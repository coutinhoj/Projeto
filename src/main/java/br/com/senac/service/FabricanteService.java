package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Fabricante;
import br.com.senac.repository.FabricanteRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class FabricanteService {
	
    @Autowired
	FabricanteRepository repository;
    
    public Fabricante search(Integer id) throws ObjectNotFoundException{
    	 Optional<Fabricante> fabricante = repository.findById(id);
    	 
    	 return fabricante.orElseThrow(() -> new ObjectNotFoundException(" não encontrado. id:" +id+", Tipo!" +Fabricante.class.getName()));
    }
    
    public List<Fabricante> serchAll(){
    	return repository.findAll();
    }
    
    public Fabricante save(Fabricante fabricante) {
    	return repository.save(fabricante);
    }
    
    
    public List<Fabricante> saveAll(List<Fabricante> fabricantes){
    	return repository.saveAll(fabricantes);
    }
    
    
    public Fabricante edit (Fabricante fabricante) throws ObjectNotFoundException{
    	Fabricante FabricanteAntigo = search(fabricante.getId());
    	
    	FabricanteAntigo.setId(fabricante.getId());
    	
    	return save(FabricanteAntigo);
    }
    
    
    public void delete(Integer id) {
    	repository.deleteById(id);
    }
	
}
