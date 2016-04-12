package samples.exoguru.materialtabs.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import samples.exoguru.materialtabs.Models.Listing;
import samples.exoguru.materialtabs.Models.ShopModel;
import samples.exoguru.materialtabs.R;
import samples.exoguru.materialtabs.Services.ItemClickListener;

/**
 * Created by Jayson on 06/04/2016.
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private ShopModel mMenus;
    private int mLayout;
    private Context mContext;
    private String mBindTypeByUrl;


    public MenuAdapter(ShopModel mMenus, int mLayout, Context mContext)
    {
        this.mMenus = mMenus;
        this.mLayout = mLayout;
        this.mContext = mContext;
       // this.mBindTypeByUrl = mBindTypeByUrl;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(mLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder,int i){
           //
           final Listing listing = mMenus.getListing().get(i);
           // final ShopModel listing = mMenus.get(i);
            viewHolder.menuTitle.setText(listing.getName());
    }

    @Override
    public int getItemCount() {

        return mMenus == null ? 0 : mMenus.getListing().size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        @Bind(R.id.name_view_tile_layout)        TextView menuTitle;

        private ItemClickListener clickListener;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getPosition(), false);
        }

        @Override
        public boolean onLongClick(View view) {
                        clickListener.onClick(view, getPosition(), true);
            return true;
        }


    }


}
