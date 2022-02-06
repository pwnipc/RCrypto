package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ethereum {

    @SerializedName("usd")
    @Expose
    private float usd;

    /**
     * No args constructor for use in serialization
     *
     */
    public Ethereum() {
    }

    /**
     *
     * @param usd
     */
    public Ethereum(float usd) {
        super();
        this.usd = usd;
    }

    public float getUsd() {
        return usd;
    }

    public void setUsd(float usd) {
        this.usd = usd;
    }

}