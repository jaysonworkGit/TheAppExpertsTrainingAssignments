package samples.exoguru.materialtabs.Services;

import android.content.SharedPreferences;

import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Component;
import retrofit.RestAdapter;
import samples.exoguru.materialtabs.Modules.AppModule;
import samples.exoguru.materialtabs.Modules.NetModule;

/**
 * Created by Jayson on 05/04/2016.
 */
@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface NetComponent {
    RestAdapter retrofit();
    OkHttpClient okHttpClient();
    SharedPreferences sharedPreferences();
}
