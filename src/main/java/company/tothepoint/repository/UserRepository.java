package company.tothepoint.repository;

import company.tothepoint.model.CerberusUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<CerberusUser, String> {
    public CerberusUser findByUsername(String userName);
}

