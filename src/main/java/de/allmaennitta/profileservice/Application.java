package de.allmaennitta.profileservice;

import de.allmaennitta.profileservice.configuration.ModelConfiguration;

import de.allmaennitta.profileservice.domain.DomainRepository;
import de.allmaennitta.profileservice.domain.StaticDomainRepository;
import de.allmaennitta.profileservice.model.Datapoint;
import de.allmaennitta.profileservice.model.Skill;
import de.allmaennitta.profileservice.skill.JpaSkillRepository;
import java.sql.SQLException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
@Import({ModelConfiguration.class}) //, EclipseLinkJpaConfiguration.class
@Slf4j
public class Application {

  public static void main(String[] args) throws SQLException {
    ApplicationContext ctx = new SpringApplicationBuilder(Application.class)
        .web(WebApplicationType.SERVLET) // .REACTIVE, .SERVLET
        .run(args);

    log.info("DATASOURCE: " +
        ((DataSource) ctx.getBean(DataSource.class)).getConnection().getMetaData().getURL());
  }


  @Bean
  public DomainRepository domainRepository() {
    return new StaticDomainRepository();
  }
}

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

//  @Bean
//  DataSource oracleDataSource() throws SQLException {
//
//    OracleDataSource dataSource = new OracleDataSource();
//    dataSource.setUser(username);
//    dataSource.setPassword(password);
//    dataSource.setURL(url);
//    dataSource.setImplicitCachingEnabled(true);
//    dataSource.setFastConnectionFailoverEnabled(true);
//    return dataSource;
//  }
