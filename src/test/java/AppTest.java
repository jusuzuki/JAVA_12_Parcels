import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {

  @Test
  public void newApp_calculateDistancePrice() {
    App testApp = new App();
    Integer result = 2;
    assertEquals(result, testApp.calculateDistancePrice("972"));
  }

  @Test
  public void newApp_setWeightPrice() {
    App testApp = new App();
    Integer result = 20;
    assertEquals(result, testApp.calculateWeightPrice(10));
  }

  @Test
  public void newApp_setFinalPrice() {
    App testApp = new App();
    Integer result = 32;
    assertEquals(result, testApp.calculateFinalPrice(2, 20, 10));
  }
}
