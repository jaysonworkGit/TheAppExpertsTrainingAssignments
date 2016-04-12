package samples.exoguru.materialtabs.Services;

import dagger.Component;
import samples.exoguru.materialtabs.MenMenu;
import samples.exoguru.materialtabs.Modules.APIModule;

/**
 * Created by Jayson on 05/04/2016.
 */

    @UserScope
    @Component(dependencies = NetComponent.class, modules = APIModule.class)
    public interface APIComponents {

    // changed this interface from needing the main to fragment.

    void injectMenMenu(MenMenu activity);


    }

