package de.allmaennitta.profileservice;

import de.allmaennitta.profileservice.domain.DomainRepository;
import de.allmaennitta.profileservice.domain.StaticDomainRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.devtools.autoconfigure.DevToolsDataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration(exclude = {
  DevToolsDataSourceAutoConfiguration.class,
  HibernateJpaAutoConfiguration.class,
  DataSourceAutoConfiguration.class})
@Import({ModelConfiguration.class})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public DomainRepository domainRepository() {
    return new StaticDomainRepository();
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
}