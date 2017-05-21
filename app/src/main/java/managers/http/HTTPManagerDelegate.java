package managers.http;

/**
 * Created by andrew on 5/21/17.
 */

public interface HTTPManagerDelegate<T> {
  void onHTTPStart();
  void onHTTPSuccess(HTTPManagerResponse<T> response);
  void onHTTPFailure(HTTPManagerResponse<T> response);
  void onHTTPRetry(int retryNumber);
}
