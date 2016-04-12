package samples.exoguru.materialtabs.Services;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Jayson on 05/04/2016.
 */
@Scope
@Retention(RUNTIME)
public @interface UserScope {
}
