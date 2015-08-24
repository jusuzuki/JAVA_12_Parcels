import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppIntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Parcel Calculator");
  }

  @Test
  public void calculateSmallPackagetoPortland() {
    goTo("http://localhost:4567/");
    fill("#height").with("2");
    fill("#width").with("2");
    fill("#length").with("2");
    fill("#weight").with("3");
    fill("#zipcode").with("972");
    submit(".btn");
    assertThat(pageSource()).contains("Your shipping cost would be 10 .");
  }

}
