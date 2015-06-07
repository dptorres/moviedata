package movie.strat.com.moviedata.utils;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Danah Torres on 6/7/2015.
 */
public class JsonParser {

    private static InputStream inputStream;
    private static JSONObject jsonObject;
    private static String jsonString;

    public static void getJsonFromURL(final String movieUrl) {
        new AsyncTask<String, String, JSONObject>() {

            @Override
            protected JSONObject doInBackground(String... strings) {
                try {
                    URL url = new URL(movieUrl);
                    URLConnection urlConnection = url.openConnection();
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());

                } catch (UnsupportedEncodingException e) {
                    // TODO create error dialog
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO create error dialog
                    e.printStackTrace();
                }

                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(
                            inputStream, "UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    inputStream.close();
                    jsonString = sb.toString();
                } catch (Exception e) {
                    Log.e("Buffer Error", "Error converting result " + e.toString());
                }

                try {
                    jsonObject = new JSONObject(jsonString);
                } catch (JSONException e) {
                    Log.e("JSON Parser", "Error parsing data " + e.toString());
                }
                // return JSON String
                return jsonObject;
            }

            @Override
            protected void onPostExecute(JSONObject jsonObject) {
                super.onPostExecute(jsonObject);
                Log.i("json", jsonObject.toString());
            }

        }.execute();

    }

}
