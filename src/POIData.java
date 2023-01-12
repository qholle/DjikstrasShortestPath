import java.util.LinkedList;

class POIData implements POIDataInterface {

  public String name = "";
  public LinkedList<String> edgeTargets = new LinkedList<String>();
  public LinkedList<Integer> edgeWeights = new LinkedList<Integer>();

  @Override
  public void setName(String in) {
    if (in == null)
      throw new IllegalArgumentException("Cannot set name to be null.");
    char[] data = in.toCharArray();
    name = "";
    if (data[0] == '"') {
      data[0] = ' ';
      data[data.length - 1] = ' ';
    }
    for (int i = 0; i < data.length; i++)
      name = name + data[i];
    this.name = name.trim();
  }

  @Override
  public String getName() {
    return this.name; // return the name of this POI object
  }

  @Override
  public void addTarget(String in) {
    if (in == null)
      throw new IllegalArgumentException("Cannot set name to be null.");
    char[] data = in.toCharArray();
    String target = "";
    if (data[0] == '"') {
      data[0] = ' ';
      data[data.length - 1] = ' ';
    }
    for (int i = 0; i < data.length; i++)
      target = target + data[i];
    this.edgeTargets.add(target.trim());
  }

  @Override
  public String getTarget(int i) {
    return this.edgeTargets.get(i);
  }

  @Override
  public void addWeight(String in) {
    this.edgeWeights.add(Integer.parseInt(in));
  }

  @Override
  public int getWeight(int i) {
    return this.edgeWeights.get(i);
  }


}
