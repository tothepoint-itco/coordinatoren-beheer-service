package company.tothepoint.model;

/**
 * Created by butrint on 10/05/16.
 */

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;

public class ModelBase implements Serializable {

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
