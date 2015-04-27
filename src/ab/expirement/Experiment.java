package ab.expirement;

import ab.algorithm.bandit.Bandit;
import ab.algorithm.bandit.arm.Arm;
import ab.scorer.Scorer;
import ab.update.IStrat;

import java.util.List;

/**
 * Created by laurence on 4/25/15.
 */
public abstract class Experiment<T> {

  private boolean started = false;

  List<Arm<T>> arms;

  private Bandit algorithm;
  private IStrat updateStrategy;
  private Scorer scorer;


  public Experiment(List<Arm<T>> arms, Bandit algorithm, IStrat updateStrategy, Scorer scorer){
    this.arms = arms;
    this.algorithm = algorithm;
    this.updateStrategy = updateStrategy;
    this.scorer = scorer;
  }

  public T observe(){
    int arm = algorithm.selectArm();
    return arms.get(arm).draw();
  }

  public void feedback(int arm, double reward){
    algorithm.update(arm, reward);
  }

  public void reset(){
    algorithm.reset();
  }

  public String stats(){
    return "";
  }

}
