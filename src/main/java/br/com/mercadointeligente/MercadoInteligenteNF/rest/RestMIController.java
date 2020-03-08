package br.com.mercadointeligente.MercadoInteligenteNF.rest;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
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
import br.com.mercadointeligente.MercadoInteligenteNF.entity.NFiscal;
import br.com.mercadointeligente.MercadoInteligenteNF.entity.NFprod;
import br.com.mercadointeligente.MercadoInteligenteNF.entity.NFprodHist;
import br.com.mercadointeligente.MercadoInteligenteNF.entity.Person;
import br.com.mercadointeligente.MercadoInteligenteNF.repository.EmpresaRepository;
import br.com.mercadointeligente.MercadoInteligenteNF.repository.NFProdHistRepository;
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
	 @Autowired 
	 public NFProdHistRepository repositoryNFPH;
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
	
	
	@CrossOrigin(origins = "*")
	@PostMapping(path="/empresaIn",consumes = "application/json")
	
	@ResponseBody  
	  public String empresaIn(@RequestBody Empresa emp) {
	  System.out.println("oiemp");
	  String sha256hex = DigestUtils.sha256Hex(emp.getCnpj()+"|"+emp.getUf()+"|"+emp.getMunicipio()+"|"+emp.getRua()+"|"+emp.getNumero());
	  emp.setId_empresa(sha256hex);
	  Empresa jonDoe = this.repositoryE.save(emp);
	  return sha256hex;
	    
	   // System.out.println(repository.findById(jonDoe.getId()).get().getId());

	 
	  }

	@CrossOrigin(origins = "*")
	@PostMapping(path="/nfIn",consumes = "application/json")

	@ResponseBody  
	  public String nfIn(@RequestBody NFiscal nf) {
	  System.out.println("oinf");
	  String sha256hex = DigestUtils.sha256Hex(nf.getCodigoAcesso()+"|"+nf.getNumero()+"|"+nf.getSerie()+"|"+nf.getModelo());

	  nf.setId_nf(sha256hex);
	
	  NFiscal nfiscal = this.repositoryNF.save(nf);
	   return   sha256hex;
	

	 
	  }
	
	
	@CrossOrigin(origins = "*")
	@PostMapping(path="/nfProdIn",consumes = "application/json")

	@ResponseBody  
	  public String nfProdIn(@RequestBody NFprod nfp) {
	  System.out.println("oiprod");
	  String sha256hex = DigestUtils.sha256Hex(nfp.getId_empresa()+"|"+nfp.getId_notafiscal()+"|"+nfp.getCodigo_produto());

	  nfp.setCodigo_produto(sha256hex);
	
	  NFprod nfprod = this.repositoryNFP.save(nfp);
	   return   sha256hex;
	

	 
	  }
	
	@CrossOrigin(origins = "*")
	@PostMapping(path="/nfProdHistIn",consumes = "application/json")

	@ResponseBody  
	  public String nfProdHistIn(@RequestBody NFprodHist nfp) {
	  System.out.println("oiprod");
	  String sha256hex = DigestUtils.sha256Hex(nfp.getId_empresa()+"|"+nfp.getId_notafiscal()+"|"+nfp.getCodigo_produto()+"|"+nfp.getData());

	  nfp.setCodigo_produto(sha256hex);
	
	  NFprodHist nfprod = this.repositoryNFPH.save(nfp);
	   return   sha256hex;
	

	 
	  }
	
	
	
	
}
