package samples.exoguru.materialtabs.Models.Observables;

import retrofit.http.GET;
import rx.Observable;
import samples.exoguru.materialtabs.Constants.Constants;
import samples.exoguru.materialtabs.Models.ShopModel;

/**
 * Created by kalpesh on 22/12/2015.
 */
public interface Shop_API {
    @GET(Constants.CAT_WOMEN_URL)
    Observable<ShopModel> getWomenCat();

    @GET(Constants.CAT_MEN_URL)
    Observable<ShopModel> getMenCat();




    @GET(Constants.PRODUCT_BY_CAT_AT+""+Constants.URL )
    Observable<ShopModel> getProductByCatAt();

    @GET(Constants.PRODUCT_BY_DETAILS_AT+""+Constants.URL)
    Observable<ShopModel> getProductByDetailsAt();
}
