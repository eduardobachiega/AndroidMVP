package eduardobachiega.androidmvp;

import android.content.Context;

public interface Interfaces {
    interface ModelImpl {
        void saveData(String data, Context context);

        String getData(Context context);
    }

    interface PresenterImpl {
        String saveData(String data, Context context);

        String getData(Context context);
    }

    interface ViewImpl {

    }
}
