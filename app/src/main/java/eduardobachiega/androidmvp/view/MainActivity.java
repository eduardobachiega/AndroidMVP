package eduardobachiega.androidmvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import eduardobachiega.androidmvp.Interfaces;
import eduardobachiega.androidmvp.R;
import eduardobachiega.androidmvp.presenter.Presenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements Interfaces.ViewImpl {
    @BindView(R.id.etData)
    EditText etData;

    @BindView(R.id.tvResult)
    TextView tvResult;

    Interfaces.PresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (presenter == null)
            presenter = new Presenter();
    }

    @OnClick(R.id.btnSave)
    public void btnSaveClick() {
        String result = presenter.saveData(etData.getText().toString(), MainActivity.this);
        tvResult.setText(getString(R.string.saved, result));
    }

    @OnClick(R.id.btnRetrieve)
    public void btnRetrieveClick() {
        tvResult.setText(getString(R.string.data_retrieved, presenter.getData(MainActivity.this)));
    }
}
