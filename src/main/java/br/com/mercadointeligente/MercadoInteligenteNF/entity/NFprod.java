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
	
	public class NFprod {

	  @PrimaryKey
	  private String id_produto;
	  private String id_empresa , id_notafiscal , codigo_produto , ncm , cest , ean ;
	  private Double valor;
	  private Long data;
	  

	}

