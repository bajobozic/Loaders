package com.example.bajob.loaders;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<IpResponse> {
    private static final int LOADER_ID = 1;
    private TextView textView;
    private Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.country_text);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportLoaderManager().restartLoader(LOADER_ID, null, MainActivity.this);
            }
        });
        getSupportLoaderManager().initLoader(LOADER_ID, null, this);
    }

    @NonNull
    @Override
    public Loader<IpResponse> onCreateLoader(int id, Bundle args) {
        return new CustomLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<IpResponse> loader, @Nullable IpResponse data) {
        if (data == null) {
            Throwable throwable = ((CustomLoader) loader).getRetrofitError();
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this).setTitle("Error").setMessage(throwable.getMessage()).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.create().show();
        } else {
            textView.setText(data.getRestResponse().getResult().getCity());
        }
    }

    @Override
    public void onLoaderReset(Loader<IpResponse> loader) {
        textView.setText("");
    }
}
