package managers.http;

/**
 * Created by andrew on 5/21/17.
 */

public abstract class HTTPResponseParser<T> {
  abstract public T parseResponse(byte[] response)
      throws HTTPParseException;
}
