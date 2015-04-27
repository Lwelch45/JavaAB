package ab.update;

/**
 * Created by laurence on 4/25/15.
 */
public class AverageStrategy implements IStrat {
  @Override
  public double update(int numCounts, double value, double reward) {
    return ((numCounts -1)/ (double) numCounts) * value +  ( 1 / (double) numCounts) * reward;
  }
}
