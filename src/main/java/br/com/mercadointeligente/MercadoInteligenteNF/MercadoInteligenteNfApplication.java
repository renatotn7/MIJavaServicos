package br.com.mercadointeligente.MercadoInteligenteNF;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.Query;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

@SpringBootApplication(
scanBasePackages={
"br.com.mercadointeligente.entity", "br.com.mercadointeligente.MercadoInteligenteNF"})
public class MercadoInteligenteNfApplication{
	
	
	public static void main(String[] args) {
	
		SpringApplication.run(MercadoInteligenteNfApplication.class, args);
	}
	  
	}


