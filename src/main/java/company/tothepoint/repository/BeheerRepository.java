package company.tothepoint.repository;

import company.tothepoint.model.beheerder.Beheerder;
import company.tothepoint.model.businessunit.BusinessUnit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BeheerRepository extends MongoRepository<Beheerder, String>{
}
