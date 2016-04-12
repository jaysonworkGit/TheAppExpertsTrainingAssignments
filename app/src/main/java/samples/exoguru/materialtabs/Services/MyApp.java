package samples.exoguru.materialtabs.Services;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import samples.exoguru.materialtabs.Constants.Constants;
import samples.exoguru.materialtabs.Modules.APIModule;
import samples.exoguru.materialtabs.Modules.AppModule;
import samples.exoguru.materialtabs.Modules.NetModule;

/**
 * Created by Jayson on 05/04/2016.
 */
public class MyApp extends Application {

    private NetComponent mNetComponent;
    private APIComponents mApiComponents;
    @Override
    public void onCreate() {
        super.onCreate();

        LeakCanary.install(this);

        mNetComponent= DaggerNetComponent.builder()
                .netModule(new NetModule(Constants.BASE_URL))
                .appModule(new AppModule(this))
                .build();

        mApiComponents= DaggerAPIComponents.builder()
                .netComponent(mNetComponent)
                .aPIModule(new APIModule())
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

    public APIComponents getApiComponent() {
        return mApiComponents;
    }

}
