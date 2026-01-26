
// Implemented Strategy Design Pattern using Robot behavior system

// - Designed interchangeable behavior strategies for walking, talking, and flying
// - Applied composition over inheritance to make robot behaviors dynamic
// - Created abstract Robot base class delegating actions to behavior interfaces
// - Implemented concrete robot types: CompanionRobot and WorkerRobot
// - Demonstrated runtime behavior configuration using different strategy combinations

// Note:
// Current design shows practical use of Strategy pattern but also highlights areas where SOLID principles can be improved, such as:
// - SRP (Robot handling projection/display responsibility)
// - OCP (Robot must be modified to add new abilities)
// - ISP (robots forced to include unused capabilities via NoWalk/NoFly)
// These tradeoffs are kept intentionally for learning and demonstration purposes.



// strategy interface for walkableRobot

interface WalkableRobot{
    void walk();
}

// concrete strategy for normal walk 

class NormalWalk implements WalkableRobot{
    public void walk(){
        System.out.println("Normal walk");
    }
}

class NoWalk implements WalkableRobot{
    public void walk(){
        System.out.println("No walk");
    
    }
}


// strategy interface for TalkableRobot

interface TalkableRobot{
    void talk();
}

class NormalTalk implements TalkableRobot{
    public void talk(){
        System.out.println("Normal Tal");
    }
}


class NoTalk implements TalkableRobot{
    public void talk(){
        System.out.println("No Talk");
    }
}

// --- Strategy Interface for Fly ---
interface FlyableRobot {
    void fly();
}

class NormalFly implements FlyableRobot {
    public void fly() {
        System.out.println("Flying normally...");
    }
}

class NoFly implements FlyableRobot {
    public void fly() {
        System.out.println("Cannot fly.");
    }
}


// --- Robot Base Class ---
abstract class Robot {
    protected WalkableRobot walkBehavior;
    protected TalkableRobot talkBehavior;
    protected FlyableRobot flyBehavior;

    public Robot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        this.walkBehavior = w;
        this.talkBehavior = t;
        this.flyBehavior = f;
    }

    public void walk() {
        walkBehavior.walk();
    }

    public void talk() {
        talkBehavior.talk();
    }

    public void fly() {
        flyBehavior.fly();
    }

    public abstract void projection(); // Abstract method for subclasses
}

// --- Concrete Robot Types ---
class CompanionRobot extends Robot {
    public CompanionRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    public void projection() {
        System.out.println("Displaying friendly companion features...");
    }
}

class WorkerRobot extends Robot {
    public WorkerRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    public void projection() {
        System.out.println("Displaying worker efficiency stats...");
    }
}

public class StrategyDesignPattern {
     public static void main(String[] args) {
        Robot robot1 = new CompanionRobot(new NormalWalk(), new NormalTalk(), new NoFly());
        robot1.walk();
        robot1.talk();
        robot1.fly();
        robot1.projection();

        Robot robot2 = new WorkerRobot(new NoWalk(), new NoTalk(), new NormalFly());
        robot2.walk();
        robot2.talk();
        robot2.fly();
        robot2.projection();
     }
}
