package de.allmaennitta.profileservice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.allmaennitta.profileservice.model.ProfileSchema;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration(exclude = {
    HibernateJpaAutoConfiguration.class,
    DataSourceAutoConfiguration.class})
@Import({ModelConfiguration.class})
public class JsonSchemaGenerator {

  @Autowired
  ObjectMapper objectMapper;

  public static void main(String[] args) {
    SpringApplication application = new SpringApplication(Application.class);
    application.setWebApplicationType(WebApplicationType.NONE);
    application.run(args);
  }

  //@Bean
  public CommandLineRunner schemaGenerator(ApplicationContext ctx) {
    return args -> {
      com.kjetland.jackson.jsonSchema.JsonSchemaGenerator jsonSchemaGenerator = new com.kjetland.jackson.jsonSchema.JsonSchemaGenerator(objectMapper);
      JsonNode jsonSchema = jsonSchemaGenerator.generateJsonSchema(ProfileSchema.class);
      String path = this.getClass().getClassLoader().getResource(".").getFile()+
          "/profile.new.schema.json";
      File file = new File(path);
      file.createNewFile();
      objectMapper.writeValue(file,jsonSchema);
      System.out.println(file.getAbsolutePath());
    };
  }
}
