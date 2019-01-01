package de.allmaennitta.profileservice.configuration;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

//@Configuration
public class EclipseLinkJpaConfiguration extends JpaBaseConfiguration {

  @Autowired
  DataSource dataSource;

  protected EclipseLinkJpaConfiguration(
      DataSource dataSource,
      JpaProperties properties,
      ObjectProvider<JtaTransactionManager> jtaTransactionManager,
      ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers) {
    super(dataSource, properties, jtaTransactionManager, transactionManagerCustomizers);
  }

  @Override
  protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
    return new EclipseLinkJpaVendorAdapter();
  }

  @Override
  protected Map<String, Object> getVendorProperties() {
    HashMap<String, Object> map = new HashMap<>();
    map.put(PersistenceUnitProperties.WEAVING, true);
    map.put(PersistenceUnitProperties.DDL_GENERATION, "drop-and-create-tables");
    return map;
  }

  private String detectWeavingMode() {
    return InstrumentationLoadTimeWeaver.isInstrumentationAvailable() ? "true" : "static";
  }
}
