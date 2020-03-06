package br.com.mercadointeligente.MercadoInteligenteNF.entity;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

	

	@Table
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@ToString
	
	public class Person {

	  @PrimaryKey
	  private String id;

	  private  String name;
	  private  int age;

	}

