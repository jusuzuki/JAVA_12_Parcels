import org.junit.*;
import static org.junit.Assert.*;

public class ParcelsTest {

  @Test
    public void newParcels_instatiatesCorrectly() {
    Parcels testParcels = new Parcels(2,2,2);
    assertEquals(true, testParcels instanceof Parcels);
  }

  @Test
  public void newParcels_setsHeight() {
    Parcels testParcels = new Parcels(2,2,2);
    assertEquals(2, 2, testParcels.getHeight());
  }

  @Test
  public void newParcels_setsWidth() {
    Parcels testParcels = new Parcels(2,2,1);
    assertEquals(2, 2, testParcels.getWidth());
  }

  @Test
  public void newParcels_setsLength() {
    Parcels testParcels = new Parcels(2,2,3);
    assertEquals(2, 2, testParcels.getLength());
  }

  @Test
  public void newParcels_volume() {
    Parcels testParcels = new Parcels(10,35,234);
    assertEquals(81900, testParcels.volume());
  }

  @Test
  public void newApp_setVolumePrice() {
    Parcels testParcels = new Parcels(2,2,2);
    Integer result = 2;
    assertEquals(result, testParcels.calculateVolumePrice(8));
  }


}
