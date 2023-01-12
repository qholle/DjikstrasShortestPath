import java.util.Scanner;

public class MapFrontEnd {


  private Djikstra<String> graph;

  public void createGraph() {

    graph = new Djikstra<>();
    graph.insertVertex("Union South");
    graph.insertVertex("Memorial Union");
    graph.insertVertex("Van Vleck Hall");
    graph.insertVertex("Van Hise Hall");
    graph.insertVertex("Kohl Center");
    graph.insertVertex("Camp Randall");
    graph.insertEdge("Union South", "Memorial Union", 6);
    graph.insertEdge("Union South", "Van Vleck Hall", 2);
    graph.insertEdge("Union South", "Van Hise Hall", 5);
    graph.insertEdge("Memorial Union", "Kohl Center", 1);
    graph.insertEdge("Memorial Union", "Van Vleck Hall", 2);
    graph.insertEdge("Van Vleck Hall", "Memorial Union", 3);
    graph.insertEdge("Van Vleck Hall", "Camp Randall", 1);
    graph.insertEdge("Van Hise Hall", "Kohl Center", 3);
    graph.insertEdge("Kohl Center", "Union South", 4);
    graph.insertEdge("Camp Randall", "Union South", 1);
    graph.insertEdge("Camp Randall", "Van Hise Hall", 1);
  }

  public void start() {

    System.out.println("Select your option:");
    System.out.println("1. List Available Stops");
    System.out.println("2. Find Shortest Path Between Two Points of Interest");
    System.out.println("3. Quit");
    createGraph();
    Scanner scan = new Scanner(System.in);
    String menuSelect = scan.next();
    if (menuSelect.equals("1")) {
      System.out.println("List of Locations:" + "\n" + graph.toString() + "\n");
      start();
    }
    if (menuSelect.equals("2")) {
      System.out
          .println("\nEnter in which two locations you want to find the fastest routes between.");
      System.out.print("\nEnter in your starting location: ");
      String location = scan.next().toString() + scan.nextLine().toString();
      
      String location1 = location;
      
      System.out.print("Please enter your destination: ");
      location = scan.next().toString() + scan.nextLine().toString();
      
      String location2 = location;
      
      System.out.println("\nRouting fastest path from " + location1 + " to " + location2);

      if (!graph.containsVertex(location1.toString()) || !graph.containsVertex(location1.toString())) {
        System.out.println("No route between " + location1 + " and " + location2 + " could be found. ");
      }
      else {
        System.out.println("The fastest route found is: " + graph.shortestPath(location1, location2).toString());
      }
      start();
    }
    if (menuSelect.equals("3")) {
      scan.close();
      System.out.println("\nThank you for using our service. See you next time!");
    }
  }

  public void run() {
    start();
  }



  public static void main(String[] args) {
    MapFrontEnd frontEndRunner = new MapFrontEnd();

    frontEndRunner.run();
  }

}
