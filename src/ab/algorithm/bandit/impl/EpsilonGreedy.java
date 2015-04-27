package ab.algorithm.bandit.impl;

import ab.algorithm.bandit.BanditBase;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by laurence on 4/25/15.
 */
public class EpsilonGreedy extends BanditBase {
  private final double epsilon;
  private final Random random = new Random();

  public EpsilonGreedy(int numArms, double epsilon) {
    super(numArms);

    assert(epsilon >= 0 && epsilon <= 1);
    this.epsilon = epsilon;
  }

  @Override
  public int selectArm() {
    if (random.nextDouble() > epsilon) {
      return getArmWithHigherValue();
    }

    return random.nextInt(counts.length);
  }

  private int getArmWithHigherValue() {
    ArrayList<Integer> bestArms = new ArrayList(values.length);
    bestArms.add(0);

    double maxValue = values[0];
    for (int i = 1; i < values.length; i++) {
      double value = values[i];
      if (value > maxValue) {
        bestArms.clear();
        bestArms.add(i);
        maxValue = value;
      } else if (value == maxValue) {
        bestArms.add(i);
      }
    }

    return bestArms.get(random.nextInt(bestArms.size()));
  }


}
