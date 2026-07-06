package exchange.notbank.quote;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import exchange.notbank.CredentialsLoader.UserCredentials;
import exchange.notbank.NotbankClient;
import exchange.notbank.TestHelper;
import exchange.notbank.quote.constants.QuoteMode;
import exchange.notbank.quote.constants.QuoteOperation;
import exchange.notbank.quote.paramBuilders.CreateDirectQuoteParamBuilder;
import exchange.notbank.quote.paramBuilders.CreateInverseQuoteParamBuilder;
import exchange.notbank.quote.paramBuilders.ExecuteQuoteParamBuilder;
import exchange.notbank.quote.paramBuilders.GetQuoteParamBuilder;
import exchange.notbank.quote.paramBuilders.GetQuotesParamBuilder;

public class QuoteServiceTest {
  private static NotbankClient client;
  private static UserCredentials credentials;

  @BeforeAll
  public static void beforeAll() throws InterruptedException, ExecutionException {
    client = TestHelper.newRestClient();
    credentials = TestHelper.getUserCredentials();
    client.authenticate(credentials.userId, credentials.apiPublicKey, credentials.apiSecretKey).get();
  }

  @Test
  public void getQuotes() {
    var futureResponse = client.getQuoteService().getQuotes(new GetQuotesParamBuilder().mode(QuoteMode.DIRECT));
    TestHelper.checkNoError(futureResponse);
  }

  @Test
  public void createDirectQuote() {
    var futureResponse = client.getQuoteService().createDirectQuote(new CreateDirectQuoteParamBuilder(
        credentials.accountId,
        "CLP",
        new BigDecimal("22000"),
        "USDT",
        QuoteOperation.BUY));
    TestHelper.checkNoError(futureResponse);
  }

  @Test
  public void createInverseQuote() {
    var futureResponse = client.getQuoteService().createInverseQuote(new CreateInverseQuoteParamBuilder(
        credentials.accountId,
        "USDT",
        new BigDecimal("10000"),
        "CLP"));
    TestHelper.checkNoError(futureResponse);
  }


    @Test
  public void getQuote() {
    var futureResponse = client.getQuoteService().getQuote(new GetQuoteParamBuilder(UUID.fromString("58b173ff-0886-42ae-a2d3-772ceb8b9e8b")));
    TestHelper.checkNoError(futureResponse);
  }


    @Test
  public void executeQuote() {
    var futureResponse = client.getQuoteService().executeQuote(new ExecuteQuoteParamBuilder(UUID.fromString("58b173ff-0886-42ae-a2d3-772ceb8b9e8b")));
    TestHelper.checkNoError(futureResponse);
  }

}
