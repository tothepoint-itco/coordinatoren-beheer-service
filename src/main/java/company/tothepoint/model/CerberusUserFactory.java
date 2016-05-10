package company.tothepoint.model;

import company.tothepoint.domain.User;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by butrint on 10/05/16.
 */
public class CerberusUserFactory {
    public static CerberusUser create(User user) {
        return new CerberusUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getLastPasswordReset(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(user.getAuthorities())
        );
    }
}
