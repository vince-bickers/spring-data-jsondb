# spring-data-jsondb
Enables Spring Data support for JsonDB

# Installation
- Install this project to your local maven repository

      git clone https://github.com/vince-bickers/spring-data-jsondb.git
      cd spring-data-jsondb
      mvn clean install
      
# Usage
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

- JsonDB Person (note: this example uses Lombok)

      @Data
      @Document(collection = "people", schemaVersion = "1.0")
      @JsonInclude(JsonInclude.Include.NON_NULL)
      public class Person {

          private @Id String name;
          private List<Person> friends = new ArrayList<Person>();

      }

- Spring Data Repository

      public interface PersonRepository extends PagingAndSortingRepository<Person, String> {}

- Bootstrap some data...

      @Component
      public class Bootstrapper implements CommandLineRunner {

          private final PersonRepository repository;

          @Autowired
          public Bootstrapper(PersonRepository repository) {
              this.repository = repository;
          }

          @Override
          public void run(String... strings) throws Exception {
                  
              Person john = new Person();
              Person mary = new Person();
              
              john.setName("john");
              mary.setName("mary");
              john.setFriends(Arrays.asList(mary));
              
              this.repository.save(john);
          }
      }

