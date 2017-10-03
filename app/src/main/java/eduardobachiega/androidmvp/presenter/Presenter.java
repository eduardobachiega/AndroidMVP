package eduardobachiega.androidmvp.presenter;

import android.content.Context;
import android.util.Base64;
import android.util.Log;

import eduardobachiega.androidmvp.Interfaces;
import eduardobachiega.androidmvp.model.Model;

public class Presenter implements Interfaces.PresenterImpl {
    private Interfaces.ModelImpl model;

    public Presenter() {
        model = new Model();
    }

    @Override
    public String saveData(String data, Context context) {
        try {
            byte[] dataBytes = data.getBytes("UTF-8");
            String base64 = Base64.encodeToString(dataBytes, Base64.DEFAULT);
            model.saveData(base64, context);
            return base64;
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @Override
    public String getData(Context context) {
        String retrieved = model.getData(context);
        Log.e("RETRIEVED", retrieved);
        byte[] data = Base64.decode(retrieved, Base64.DEFAULT);
        try {
            return new String(data, "UTF-8");
        } catch (Exception e) {
            return "default";
        }
    }
}
