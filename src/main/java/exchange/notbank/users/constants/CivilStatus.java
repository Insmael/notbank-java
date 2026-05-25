package exchange.notbank.users.constants;

public enum CivilStatus {
  SINGLE("soltero"),
  MARRIED("casado"),
  COHABITING("conviviente"),
  DIVORCED("divorciado"),
  WIDOWED("viudo");

  public final String value;

  CivilStatus(String value) {
    this.value = value;
  }
}
