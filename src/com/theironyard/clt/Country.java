package com.theironyard.clt;

/**
 * Created by Ultramar on 4/12/16.
 */
public class Country {
    String abbr;
    String name;

    public Country(String abbr, String name) {
        this.abbr = abbr;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s | %s \n", abbr, name);
    }


}
