package br.com.mercadointeligente.MercadoInteligenteNF.entity;
import java.sql.Date;

import org.springframework.data.cassandra.core.mapping.Indexed;
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
	
	public class NFiscal {

	  @PrimaryKey
	  private String id_nf;
	  private String  numero, serie, modelo,	versao, codigoAcesso,qrcode;
	  private Long data;
	

	}

