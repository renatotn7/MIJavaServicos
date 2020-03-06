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
	
	public class Empresa {

	  @PrimaryKey
	  String id_empresa;
	  String cnpj;
	  String razaoSocial;
	  String ie;
	  String rua; 
	  String numero;
	  String complemento;
	  String bairro;
	  String municipio;
	  String uf;


	}

