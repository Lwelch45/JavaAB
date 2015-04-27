package ab.algorithm.bandit.impl;

import ab.algorithm.bandit.BanditBase;

/**
 * Created by laurence on 4/25/15.
 */
public class UCB1 extends BanditBase {

  public UCB1(int numArms) {
    super(numArms);
  }

  @Override
  public int selectArm() {
    int totalCount = 0;
    for (int i = 0; i < counts.length; i++) {
      int count = counts[i];
      if (count == 0) {
        return i;
      }
      totalCount += count;
    }

    double[] ucbValues = new double[numArms];
    for (int i = 0; i < numArms; i++) {
      double bonus = Math.sqrt((2 * Math.log(totalCount)) / counts[i]);
      ucbValues[i] = values[i] + bonus;
    }

    int maxIndex = 0;
    for (int i = 1; i < ucbValues.length; i++) {
      double newValue = ucbValues[i];
      if (newValue > ucbValues[maxIndex]) {
        maxIndex = i;
      }
    }
    return maxIndex;
  }

}
