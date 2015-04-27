package ab.scorer.impl;

import ab.scorer.Scorer;

/**
 * Created by laurence on 4/25/15.
 */
public class CumlativeReward implements Scorer {
  private double accumulatedScore = 0;

  @Override
  public double score(int draw, int chosenArm, double reward) {
    accumulatedScore += reward;
    return accumulatedScore;
  }
}
