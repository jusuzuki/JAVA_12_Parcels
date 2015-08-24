public class Parcels{
  private Integer mHeight;
  private Integer mLength;
  private Integer mWidth;

  public Parcels(Integer height, Integer length, Integer width){
    mLength = length;
    mWidth = width;
    mHeight = height;
  }

  public int getHeight() {
    return mHeight;
  }

  public int getLength() {
    return mLength;
  }

  public int getWidth() {
    return mWidth;
  }

  public int volume(){
    int calculation = mHeight * mLength * mWidth;
    return calculation;
  }

  public Integer calculateVolumePrice(Integer volume){

    Integer volumePrice;
    if (volume <= 240) {
      volumePrice = 2;
    } else if (volume <= 500) {
      volumePrice = 5;
    } else {
      volumePrice = 10;
    }
    return volumePrice;
  }

}
