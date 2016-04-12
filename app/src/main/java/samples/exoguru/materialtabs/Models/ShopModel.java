package samples.exoguru.materialtabs.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jayson on 09/04/2016.
 */

public class ShopModel {

    @SerializedName("Description")
    @Expose
    private String Description;
    @SerializedName("Listing")
    @Expose
    private List<Listing> Listing = new ArrayList<Listing>();
    @SerializedName("SortType")
    @Expose
    private String SortType;

    /**
     *
     * @return
     * The Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     *
     * @param Description
     * The Description
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     *
     * @return
     * The Listing
     */
    public List<Listing> getListing() {
        return Listing;
    }

    /**
     *
     * @param Listing
     * The Listing
     */
    public void setListing(List<Listing> Listing) {
        this.Listing = Listing;
    }

    /**
     *
     * @return
     * The SortType
     */
    public String getSortType() {
        return SortType;
    }

    /**
     *
     * @param SortType
     * The SortType
     */
    public void setSortType(String SortType) {
        this.SortType = SortType;
    }

}
