package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bitcoin {

    @SerializedName("usd")
    @Expose
    private Integer usd;

    /**
     * No args constructor for use in serialization
     *
     */
    public Bitcoin() {
    }

    /**
     *
     * @param usd
     */
    public Bitcoin(Integer usd) {
        super();
        this.usd = usd;
    }

    public Integer getUsd() {
        return usd;
    }

    public void setUsd(Integer usd) {
        this.usd = usd;
    }

}