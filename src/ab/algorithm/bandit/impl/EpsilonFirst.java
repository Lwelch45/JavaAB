package ab.algorithm.bandit.impl;

import ab.algorithm.bandit.BanditBase;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by laurence on 4/25/15.
 */
public class EpsilonFirst extends BanditBase {

  private final Random random= new Random();
  private int epsilon;
  private int currentDraw = 0;

  public EpsilonFirst(int numArms, int epsilon){
    super(numArms);
    assert(epsilon >= 0);

    this.epsilon = epsilon;
  }

  @Override
  public int selectArm() {
    currentDraw++;

    if (currentDraw <= epsilon) {
      return random.nextInt(counts.length);
    }

    return getArmWithHigherValue();
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
