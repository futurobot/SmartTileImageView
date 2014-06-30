package ru.futurobot.app;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Alexey on 30.06.14.
 */
public class ImageBrowser extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Uri uri = getIntent().getData();
        Toast.makeText(this, uri.toString(), Toast.LENGTH_SHORT).show();
    }
}
