package exchange.notbank.wallet.responses;

public class Province {
  public final Integer code;
  public final String name;

  public Province(Integer code, String name) {
    this.code = code;
    this.name = name;
  }

  @Override
  public String toString() {
    return "Province [code=" + code + ", name=" + name + "]";
  }
}
