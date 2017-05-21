package managers.http.json;

import org.json.JSONException;
import org.json.JSONObject;

import managers.http.HTTPParseException;
import managers.http.HTTPResponseParser;

/**
 * Created by andrew on 5/21/17.
 */

public final class JSONResponseParser
  extends HTTPResponseParser<JSONObject> {

  @Override
  public JSONObject parseResponse(byte[] response)
    throws HTTPParseException {
    try {
      return new JSONObject(new String(response));
    } catch (JSONException e) {
      throw new HTTPParseException(e);
    }
  }
}
