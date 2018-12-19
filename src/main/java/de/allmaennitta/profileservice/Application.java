package de.allmaennitta.profileservice;

import de.allmaennitta.profileservice.domain.DomainRepository;
import de.allmaennitta.profileservice.domain.StaticDomainRepository;
import de.allmaennitta.profileservice.skill.JpaSkillRepository;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.hibernate.dialect.Oracle10gDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableJpaRepositories("de.allmaennitta.profileservice")
//@EnableTransactionManagement
@Import({ModelConfiguration.class})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public DomainRepository domainRepository() {
    return new StaticDomainRepository();
  }

//  @Bean
//  @Primary
//  @ConfigurationProperties(prefix = "spring.datasource")
//  public DataSource dataSource() {
//    return DataSourceBuilder.create().build();
//  }

//  @Bean
//  @Primary
//  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//    JpaTransactionManager txManager = new JpaTransactionManager();
//    txManager.setEntityManagerFactory(entityManagerFactory);
//    return txManager;
//  }
//
//  @Bean
//  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//    vendorAdapter.setGenerateDdl(true);
//    vendorAdapter.setShowSql(true);
//    vendorAdapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
//    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//    factory.setJpaVendorAdapter(vendorAdapter);
//    factory.setPackagesToScan("de.allmaennitta.profileservice.model");
//    factory.setDataSource(dataSource());
//    return factory;
//  }


//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//        };
//    }
}