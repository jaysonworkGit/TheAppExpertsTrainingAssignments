package samples.exoguru.materialtabs;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.okhttp.OkHttpClient;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import samples.exoguru.materialtabs.Adapter.MenuAdapter;
import samples.exoguru.materialtabs.Models.Observables.Shop_API;
import samples.exoguru.materialtabs.Models.ShopModel;
import samples.exoguru.materialtabs.Services.MyApp;
import samples.exoguru.materialtabs.Services.RxUtils;

/**
 * Created by Edwin on 15/02/2015.
 */
public class MenMenu extends Fragment {


    @Inject
    Shop_API mShopSearch_API;


    @Inject
    SharedPreferences mSharedPreferences;

    @Inject
    OkHttpClient mOkHttpClient;

    ShopModel shopModel;

    private RecyclerView mRecyclerView;
    //Controller
    private MenuAdapter mAdapter;

    private ProgressDialog pDialog;

    private CompositeSubscription _subscriptions = new CompositeSubscription();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final  View v =inflater.inflate(R.layout.men_menu,container,false);

        //  _api= Services._createCakehubApi();
        ((MyApp) getActivity().getApplication()).getApiComponent().injectMenMenu(this);

        pattern();
        pDialog = new ProgressDialog(getContext());
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();
        mRecyclerView = (RecyclerView)v.findViewById(R.id.list_men_menu);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        return v;
    }


    @Override
    public void onResume() {
        super.onResume();
        _subscriptions = RxUtils.getNewCompositeSubIfUnsubscribed(_subscriptions);
    }
    @Override
    public void onPause(){
        super.onPause();
        RxUtils.unsubscribeIfNotNull(_subscriptions);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    public void pattern(){


        _subscriptions.add(mShopSearch_API.getMenCat()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                      //  .timeout(5000, TimeUnit.MILLISECONDS)
                        //.retry()
                        //.distinct()
                        .subscribe(new Observer<ShopModel>() {
                            @Override
                            public void onCompleted() {
                                Log.i("Retrofit", "onCompleted");
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.i("Retrofit", "onCompleted");
                            }

                            @Override
                            public void onNext(ShopModel shopModel) {
                                Log.i("Retrofit", "onNext");

                                if (shopModel.getListing().size() > 0 && mRecyclerView != null) {
                                    mAdapter = new MenuAdapter(shopModel, R.layout.view_tile_layout,getActivity());
                                    mRecyclerView.setAdapter(mAdapter);
                                    hidePDialog();
                                }
                            }
                        })
        );


    }

}
