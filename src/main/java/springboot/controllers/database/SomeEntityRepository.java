package springboot.controllers.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SomeEntityRepository extends CrudRepository<SomeEntity, UUID> {


}