package br.com.mercadointeligente.MercadoInteligenteNF.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.mercadointeligente.MercadoInteligenteNF.entity.NFiscal;
import br.com.mercadointeligente.MercadoInteligenteNF.entity.Person;
@Repository
public interface NFiscalRepository extends CassandraRepository<NFiscal, String> {

	  // additional custom finder methods go here
	}