package com.putya.plantstore20.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IndoorPlant {

    @SerializedName("Recommended")
    @Expose
    private List<Recommended> recommended = null;

    @SerializedName("pots")
    @Expose
    private List<Pot> pots = null;

    public List<Recommended> getRecommended() {
        return recommended;
    }

    public void setRecommended(List<Recommended> recommended) {
        this.recommended = recommended;
    }

    public List<Pot> getPots() {
        return pots;
    }

    public void setPots(List<Pot> pots) {
        this.pots = pots;
    }
}
