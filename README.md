# spring-data-jsondb
Enables Spring Data support for JsonDB

# Usage
- Download and install this project

      git clone https://github.com/vince-bickers/spring-data-jsondb
      
- Declare the dependency in your pom

        <dependency>
            <groupId>org.mambofish</groupId>
            <artifactId>spring-data-jsondb</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>

- Enable Spring Data/Spring Boot support for JsonDB, using `@EnableJsonDBRepositories`

      @SpringBootApplication
      @EnableJsonDBRepositories(basePackages = ".....")
      public class Application {

          @Value("${json.db.files.location}")
          private String dbFilesLocation;

          @Value("${json.db.scan.package}")
          private String dbScanPackage;

          @Bean
          public JsonDBTemplate jsonDBTemplate() {
              return new JsonDBTemplate(dbFilesLocation, dbScanPackage);
          }

          public static void main(String[] args) {
              SpringApplication.run(Application.class, args);
          }
      }
