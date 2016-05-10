package company.tothepoint.repository;

import company.tothepoint.domain.User;
import company.tothepoint.model.CerberusUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String userName);
}

