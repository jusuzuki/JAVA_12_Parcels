import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/home.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/results", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int height = Integer.parseInt(request.queryParams("height"));
      int width = Integer.parseInt(request.queryParams("width"));
      int length = Integer.parseInt(request.queryParams("length"));
      String zipcode = (request.queryParams("zipcode"));
      int weight = Integer.parseInt(request.queryParams("weight"));

      Parcels myParcel  = new Parcels(length, width, height);
      Integer volume = myParcel.volume();
      Integer weightPrice = calculateWeightPrice(weight);
      Integer distancePrice = calculateDistancePrice(zipcode);
      Integer volumePrice = myParcel.calculateVolumePrice(volume);
      Integer finalPrice = calculateFinalPrice(weightPrice, distancePrice, volumePrice);

      model.put("finalPrice", finalPrice);

      model.put("template", "templates/results.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static Integer calculateWeightPrice(Integer weight) {
    Integer weightPrice = weight * 2;
    return weightPrice;
  }

  public static Integer calculateDistancePrice(String zipCode) {
    char[] zipCodeArray = zipCode.toCharArray();
    Integer distancePrice;

    // if zipcode is in Portland
    if (zipCodeArray[0] == '9' && zipCodeArray[1] == '7' && zipCodeArray[2] == '2'){
      distancePrice = 2;
    // if zipcode is in Oregon
  } else if (zipCodeArray[0] == '9' && zipCodeArray[1] == '7' && zipCodeArray[2] !='2') {
      distancePrice = 5;
    // if zipcode is outside of Oregon
    } else {
      distancePrice = 10;
    }
    return distancePrice;
  }

  public static Integer calculateFinalPrice(Integer weightPrice, Integer distancePrice, Integer volumePrice){
    return weightPrice + distancePrice + volumePrice;
  }
}
