package com.bambeyandroid.myimageapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by cscharff.
 */

public class ImageDownloader extends AsyncTask<String, Integer, Bitmap> {


    private Activity activity;

    /*public ImageDownloader(FragmentActivity myActivity) {
        activity = myActivity;
    }*/

    @Override
    protected Bitmap doInBackground(String... strings) {
        Log.i("ASYNCTASKIMAGEDOWNLOAD", "In doInBackGround");
        publishProgress(1);
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new Exception("Failed to connect");
            }
            InputStream is = con.getInputStream();
            publishProgress(0);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            is.close();
            return bitmap;
        } catch (Exception e) {
            Log.e("Image", "Failed to load image", e);
            Log.e("error", e.getMessage());
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

    }

    @Override
    protected void onPostExecute(Bitmap img) {
        Log.i("hello4", "hello4");
        ImageView iv = (ImageView) activity.findViewById(R.id.remote_image);
        Log.i("hello5", "hello5");
        if (iv != null && img != null) {
            Log.i("hello6", "hello6");
            iv.setImageBitmap(img);
        }

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
