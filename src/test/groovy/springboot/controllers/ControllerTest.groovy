package springboot.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.http.HttpStatus
import spock.lang.Specification
import springboot.controllers.database.SomeEntity
import springboot.controllers.database.SomeEntityRepository

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = [TestController.class])
@EnableAutoConfiguration(exclude = [SecurityAutoConfiguration.class])
@EntityScan("springboot")
@EnableJpaRepositories("springboot")
class ControllerTest extends Specification {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private SomeEntityRepository repository;

    def "get entity"() {
        given:
        def uuid = UUID.randomUUID()
        def entity = new SomeEntity()
        entity.mykey = uuid
        entity.text = "test"
        repository.save(entity)

        when:
        def responseEntity = restTemplate.getForEntity("/v1/test/${uuid}", String.class)

        then:
        responseEntity.getStatusCode() == HttpStatus.OK
    }
}
