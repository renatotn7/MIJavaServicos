package br.com.mercadointeligente.MercadoInteligenteNF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import java.util.List;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;

@Configuration	
@EnableCassandraRepositories

public class CassandraConfiguration extends AbstractCassandraConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(CassandraConfiguration.class);

    @Override
    public SchemaAction getSchemaAction() {
      return SchemaAction.CREATE_IF_NOT_EXISTS;
    }
    @Autowired
    private Environment environment;

    @Bean
    public CassandraClusterFactoryBean cluster() {
    	System.out.println("oi");
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();

	//	 cluster.setUsername(environment.getProperty("cassandra.username"));
		//   cluster.setPassword(environment.getProperty("cassandra.password"));
		  // cluster.setContactPoints(environment.getProperty("cassandra.contactpoints"));
		   //cluster.setPort(Integer.parseInt(environment.getProperty("cassandra.port")));
		   cluster.setUsername("cassandra");
		   cluster.setPassword("cassandra");
		   cluster.setContactPoints("192.168.99.100");
		   cluster.setPort(9042);
        return cluster;
    }

    @Override
    protected String getKeyspaceName() {
        return "mikeyspace";
    }
	 /*@Override
  protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
    final CreateKeyspaceSpecification specification =
        CreateKeyspaceSpecification.createKeyspace("mikeyspace")
            .ifNotExists()
            .with(KeyspaceOption.DURABLE_WRITES, true)
            .withSimpleReplication();
    return List.of(specification);
  }*/
    @Override
    public String[] getEntityBasePackages() {
        return new String[] { "br.com.mercadointeligente.MercadoInteligenteNF.entity" };
      }
}