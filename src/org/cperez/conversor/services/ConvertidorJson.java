package org.cperez.conversor.services;

import org.cperez.conversor.models.ConversionRecord;

import com.google.gson.Gson;

public class ConvertidorJson {

    public static ConversionRecord convertirDeJson(String json) {
        return new Gson().fromJson(json, ConversionRecord.class);
    }
}
