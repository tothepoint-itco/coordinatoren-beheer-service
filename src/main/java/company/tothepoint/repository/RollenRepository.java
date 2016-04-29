package company.tothepoint.repository;

import company.tothepoint.model.rol.Rol;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by butrint on 25/04/16.
 */
public interface RollenRepository extends MongoRepository<Rol, String> {
}
