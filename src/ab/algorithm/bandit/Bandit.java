package ab.algorithm.bandit;

/**
 * Created by laurence on 4/25/15.
 */
public interface Bandit {
  public int selectArm();
  public void update(int arm, double reward);
  public void reset();
}
