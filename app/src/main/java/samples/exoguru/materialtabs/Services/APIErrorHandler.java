package samples.exoguru.materialtabs.Services;

import android.accounts.NetworkErrorException;

import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;

/**
 * Created by Jayson on 04/04/2016.
 */
public class APIErrorHandler implements ErrorHandler {
    @Override
    public Throwable handleError(RetrofitError cause) {

        if (cause.getKind() == RetrofitError.Kind.NETWORK) {
            if (cause.getCause() instanceof SocketTimeoutException) {
                return new NetworkErrorException();
            } else {
                return new TimeoutException();
            }
        }

        return cause;
    }
}
