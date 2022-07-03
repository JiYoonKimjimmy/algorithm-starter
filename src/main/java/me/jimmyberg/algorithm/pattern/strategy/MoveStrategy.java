package me.jimmyberg.algorithm.pattern.strategy;

public interface MoveStrategy {
    void move();
}

class MoveByRoad implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("Move by road.");
    }
}

class MoveByRail implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("Move by rail.");
    }
}

class Movable {
    private MoveStrategy moveStrategy;

    public void move() {
        moveStrategy.move();
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }
}

class Bus extends Movable { }
class Train extends Movable { }

class Client {
    public static void main(String[] args) {
        Bus bus = new Bus();
        Train train = new Train();

        bus.setMoveStrategy(new MoveByRoad());
        train.setMoveStrategy(new MoveByRail());
        bus.move();
        train.move();

        // change strategy of bus
        bus.setMoveStrategy(new MoveByRail());
        bus.move();
    }
}