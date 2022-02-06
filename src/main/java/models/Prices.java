package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Prices {

    @SerializedName("bitcoin")
    @Expose
    private Bitcoin bitcoin;
    @SerializedName("ethereum")
    @Expose
    private Ethereum ethereum;

    private int id;

    /**
     * No args constructor for use in serialization
     *
     */
    public Prices() {
    }

    /**
     *
     * @param ethereum
     * @param bitcoin
     */
    public Prices(Bitcoin bitcoin, Ethereum ethereum) {
        super();
        this.bitcoin = bitcoin;
        this.ethereum = ethereum;
    }

    public Bitcoin getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(Bitcoin bitcoin) {
        this.bitcoin = bitcoin;
    }

    public Ethereum getEthereum() {
        return ethereum;
    }

    public void setEthereum(Ethereum ethereum) {
        this.ethereum = ethereum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}