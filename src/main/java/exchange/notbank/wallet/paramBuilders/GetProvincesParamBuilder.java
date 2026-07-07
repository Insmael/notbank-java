package exchange.notbank.wallet.paramBuilders;

import java.util.HashMap;
import java.util.Map;

import exchange.notbank.core.HttpConfiguration;
import exchange.notbank.core.ParamBuilder;

public class GetProvincesParamBuilder implements ParamBuilder {
  protected final Map<String, Object> params;
  protected HttpConfiguration httpConfiguration;

  public GetProvincesParamBuilder(String country) {
    this.httpConfiguration = new HttpConfiguration();
    this.params = new HashMap<>();
    this.params.put("country", country);
  }

  public Map<String, Object> getParams() {
    return params;
  }

  public HttpConfiguration getHttpConfiguration() {
    return httpConfiguration;
  }

  public GetProvincesParamBuilder setHttpConfiguration(HttpConfiguration httpConfiguration) {
    this.httpConfiguration = httpConfiguration;
    return this;
  }
}
