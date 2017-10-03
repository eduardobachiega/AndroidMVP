package eduardobachiega.androidmvp.model;

import android.content.Context;
import android.content.SharedPreferences;

import eduardobachiega.androidmvp.Interfaces;

public class Model implements Interfaces.ModelImpl {
    @Override
    public void saveData(String data, Context context) {
        SharedPreferences preferences = context.getSharedPreferences("DATA", Context.MODE_PRIVATE);
        preferences.edit().putString("string", data).apply();
    }

    @Override
    public String getData(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("DATA", Context.MODE_PRIVATE);
        return preferences.getString("string", "default");
    }
}
