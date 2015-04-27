package ab.scorer;

/**
 * Created by laurence on 4/25/15.
 */
public interface Scorer {
  public double score(int draw, int chosenArm, double reward);
}
