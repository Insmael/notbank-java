package exchange.notbank.wallet.responses;


public class WithdrawalConfigurationStatus {
  public final Boolean enabled;

  public WithdrawalConfigurationStatus(Boolean twoFactorAuthenticationStatus) {
    this.enabled = twoFactorAuthenticationStatus;
  }
}
