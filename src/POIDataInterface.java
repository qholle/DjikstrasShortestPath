public interface POIDataInterface {
  public void setName(String name) throws IllegalArgumentException;

  public String getName();

  public void addTarget(String in);

  public String getTarget(int i);

  public void addWeight(String in);

  public int getWeight(int i);
}
