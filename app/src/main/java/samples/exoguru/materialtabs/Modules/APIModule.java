package samples.exoguru.materialtabs.Modules;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import samples.exoguru.materialtabs.Models.Observables.Shop_API;
import samples.exoguru.materialtabs.Services.UserScope;

/**
 * Created by Jayson on 06/04/2016.
 */
@Module
public class APIModule {


    @Provides
    @UserScope
    public Shop_API providesIContactsInterface(RestAdapter retrofit){
        return retrofit.create(Shop_API.class);
    }
}
