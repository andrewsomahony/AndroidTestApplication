package managers.http;

import com.loopj.android.http.*;

import cz.msebera.android.httpclient.Header;
import managers.BaseManager;

/**
 * Created by andrew on 5/21/17.
 */

public class HTTPManager<T> extends BaseManager {
  private AsyncHttpClient _client = new AsyncHttpClient();
  private HTTPManagerDelegate<T> _delegate = null;
  private HTTPResponseParser<T> _responseParser = null;

  public HTTPManager(HTTPManagerDelegate<T> delegate,
                         HTTPResponseParser<T> parser) {
    super();
    _delegate = delegate;
    _responseParser = parser;
  }

  public void get(String url) {
    assert null != _delegate;
    assert null != _responseParser;

    _client.get(url, new AsyncHttpResponseHandler() {
      @Override
      public void onStart() {
        _delegate.onHTTPStart();
      }

      @Override
      public void onSuccess(int statusCode,
                            Header[] headers,
                            byte[] responseBody) {
        T response = null;
        Throwable failureError = null;

        try {
          response = _responseParser.parseResponse(responseBody);
        } catch (HTTPParseException e) {
          failureError = e;
        }

        _delegate.onHTTPSuccess(
          new HTTPManagerResponse(statusCode,
                                     headers,
                                     responseBody,
                                     response,
                                     failureError));
      }

      @Override
      public void onFailure(int statusCode,
                            Header[] headers,
                            byte[] responseBody,
                            Throwable error) {
        T response = null;
        Throwable failureError = error;

        if (null == failureError) {
          try {
            response = _responseParser.parseResponse(responseBody);
          } catch (HTTPParseException e) {
            failureError = e;
          }
        }

        _delegate.onHTTPFailure(
          new HTTPManagerResponse(statusCode,
                                  headers,
                                  responseBody,
                                  response,
                                  failureError));
      }

      @Override
      public void onRetry(int retryNumber) {
        _delegate.onHTTPRetry(retryNumber);
      }
    });
  }
}
