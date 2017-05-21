package managers.http;

import cz.msebera.android.httpclient.Header;

/**
 * Created by andrew on 5/21/17.
 */

public class HTTPManagerResponse<T> {
  private int _code;
  private Header[] _headers;
  private byte[] _responseBytes;
  private T _response;
  private Throwable _error;

  public HTTPManagerResponse(int code,
                             Header[] headers,
                             byte[] responseBytes,
                             T response,
                             Throwable error) {
    _code = code;
    _headers = headers;
    _response = response;
    _responseBytes = responseBytes;
    _error = error;
  }

  public int getCode() {
    return _code;
  }

  public Header[] getHeaders() {
    return _headers;
  }

  public byte[] getResponseBytes() {
    return _responseBytes;
  }

  public T getResponse() {
    return _response;
  }

  public Throwable getError() {
    return _error;
  }
}
