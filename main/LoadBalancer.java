package main;

import java.util.List;

enum ALGORITHMS {
  ROUND_ROBIN,
  WEIGHTED_ROUND_ROBIN
}

public class LoadBalancer {

  private List<Server> servers;
  private ALGORITHMS algorithm = ALGORITHMS.ROUND_ROBIN;

  private int roundRobinTracker = 0;

  LoadBalancer(List<Server> servers, ALGORITHMS algorithm) {
    this.servers = servers;
    this.algorithm = algorithm;
  }

  private void roundRobin(Request request) {
    this.servers.get(roundRobinTracker).serve(request);
    roundRobinTracker = (roundRobinTracker + 1) % servers.size();
  }

  public void assign(Request request) {
    if (this.algorithm == ALGORITHMS.ROUND_ROBIN) {
      roundRobin(request);
    }
  }
}
