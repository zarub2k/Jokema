package com.cloudskol.jokema;

import android.os.AsyncTask;
import android.widget.Toast;

import com.cloudskol.jokema.jokemacloud.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * @author tham
 *
 * Async task to fetch jokes from Google Cloud Platform
 */
public class JokeAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi jokeApiCloud = null;
    private MainActivity activity;

    public JokeAsyncTask(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (jokeApiCloud == null) {
            final MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
//                    .setRootUrl("http://10.0.2.2:8080/_ah/api")
                    .setRootUrl("https://jokema-1275.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            jokeApiCloud = builder.build();
        }

        String summary = null;
        try {
            summary = jokeApiCloud.joke().execute().getSummary();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return summary;
    }

    @Override
    protected void onPostExecute(String data) {
        Toast.makeText(activity, "Data from cloud: " + data, Toast.LENGTH_SHORT).show();
        activity.onJokeFetched(data);
    }
}
