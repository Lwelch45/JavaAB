package ab.algorithm.bandit;

import ab.update.AverageStrategy;
import ab.update.IStrat;

/**
 * Created by laurence on 4/25/15.
 */
public abstract class BanditBase implements Bandit {

  protected int numArms;
  protected int[] counts;
  protected double[] values;
  protected IStrat updateStrategy;

  public BanditBase(int numArms) {
    this.numArms = numArms;
    this.counts = new int[numArms];
    this.values = new double[numArms];
    this.updateStrategy = new AverageStrategy();
  }

  @Override
  public void update(int arm, double reward) {
    counts[arm]++;
    values[arm] = updateStrategy.update(counts[arm], values[arm], reward);
  }

  @Override
  public void reset() {
    for (int i = 0; i < counts.length; i++) {
      counts[i] = 0;
      values[i] = 0;
    }
  }

  public void setUpdateStrategy(IStrat updateStrategy){
    this.updateStrategy = updateStrategy;
  }

}
