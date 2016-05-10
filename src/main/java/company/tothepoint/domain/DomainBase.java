package company.tothepoint.domain;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * Created by butrint on 10/05/16.
 */
public class DomainBase implements Serializable {
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
