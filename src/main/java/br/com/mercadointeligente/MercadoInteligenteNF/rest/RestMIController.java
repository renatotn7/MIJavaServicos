package br.com.mercadointeligente.MercadoInteligenteNF.rest;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadointeligente.MercadoInteligenteNF.entity.Empresa;
import br.com.mercadointeligente.MercadoInteligenteNF.entity.Person;
import br.com.mercadointeligente.MercadoInteligenteNF.repository.EmpresaRepository;
import br.com.mercadointeligente.MercadoInteligenteNF.repository.NFProdRepository;
import br.com.mercadointeligente.MercadoInteligenteNF.repository.NFiscalRepository;
import br.com.mercadointeligente.MercadoInteligenteNF.repository.PersonRepository;

@RestController
@RequestMapping("/teste")
public class RestMIController {
	 @Autowired 
	 public PersonRepository repository;
	 @Autowired 
	 public EmpresaRepository repositoryE;
	 
	 @Autowired 
	 public NFiscalRepository repositoryNF;
	 @Autowired 
	 public NFProdRepository repositoryNFP;
	  protected static Person newPerson(String name, int age) {
		    return newPerson(UUID.randomUUID().toString(), name, age);
		  }

		  protected static Person newPerson(String id, String name, int age) {
		    return new Person(id, name, age);
		  }
	@GetMapping(path="/teste")
	  public void teste() {
	  System.out.println("oi");
	  Person jonDoe = repository.save(newPerson("Jon Doe", 40));
	    
	    System.out.println(repository.findById(jonDoe.getId()).get().getId());

	 
	  }
	@GetMapping(path="/teste2")
	  public void teste2() {
	  System.out.println("oi");
	  Empresa jonDoe = this.repositoryE.save(new Empresa(UUID.randomUUID().toString(),"2333","asbc","id1","","","","","",""));
	    
	   // System.out.println(repository.findById(jonDoe.getId()).get().getId());

	 
	  }
	
	@CrossOrigin(origins = "*")
	@PostMapping(path="/empresaIn",consumes = "application/json")
	//String cvmbd, String cvmprop, String databd, String dataProp,String perbd, String perprop
	//http://localhost:8080/getRelatorioDiferencas?cvmbd=5258&cvmprop=5258&databd=122011&dataprop=122012&perbd=A&perprop=A
	@ResponseBody  
	  public void empresaIn(@RequestBody Empresa emp) {
	  System.out.println("oi");
	  emp.setId_empresa(UUID.randomUUID().toString());
	  Empresa jonDoe = this.repositoryE.save(emp);
	    
	   // System.out.println(repository.findById(jonDoe.getId()).get().getId());

	 
	  }
	
}
