package ab.algorithm.bandit.impl;

import ab.algorithm.bandit.BanditBase;

import java.util.Random;

/**
 * Created by laurence on 4/25/15.
 */
public class Softmax extends BanditBase {

  private final Random random = new Random();
  private final double temperature;

  public Softmax(int numArms, double temperature) {
    super(numArms);

    assert(temperature >= 0 && temperature <= 1);
    this.temperature = temperature;
  }

  @Override
  public int selectArm() {
    double z = 0;
    for (double value : values) {
      z += Math.exp(value / temperature);
    }

    double[] probabilities = new double[numArms];
    for (int i = 0; i < values.length; i++) {
      double value = values[i];
      probabilities[i] = Math.exp(value / temperature) / z;
    }
    return categoricalDraw(probabilities);
  }

  private int categoricalDraw(double[] probabilities) {
    double rand = random.nextDouble();
    double cumulativeProbability = 0;
    for (int i = 0; i < probabilities.length; i++) {
      double probability = probabilities[i];
      cumulativeProbability += probability;
      if (cumulativeProbability > rand) {
        return i;
      }
    }
    return probabilities.length - 1;
  }

}
