package fragments;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andrew.testapplication.R;

import org.json.JSONObject;

import managers.http.HTTPManager;
import managers.http.HTTPManagerDelegate;
import managers.http.HTTPManagerResponse;
import managers.http.json.JSONResponseParser;

/**
 * Created by andrew on 5/21/17.
 */

public final class WeatherFragment extends BaseFragment
implements HTTPManagerDelegate<JSONObject> {
    private TextView _textView;
    private ImageView _imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
      _layoutResourceID = R.layout.fragment_weather;

      super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
      _textView = (TextView)getView().findViewById(R.id.weatherLabel);
      _imageView = (ImageView)getView().findViewById(R.id.weatherImageView);

      new HTTPManager(this, new JSONResponseParser())
        .get("http://www.yahoo.com");

      super.onResume();
    }

    // IMPLEMENTATION: HTTPManagerDelegate<JSONObject>

  public void onHTTPStart() {

  }
  public void onHTTPSuccess(HTTPManagerResponse<JSONObject> response) {
    if (null == response.getResponse()) {
      _textView.setText("Cannot get weather");
    } else{
      _textView.setText("Success!");
    }
  }
  public void onHTTPFailure(HTTPManagerResponse<JSONObject> response) {

  }
  public void onHTTPRetry(int retryNumber) {

  }

    // End HTTPManagerDelegate
}
