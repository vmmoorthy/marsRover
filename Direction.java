public class Direction {
    DirectionENUM dEnum;
    int xMove, yMove;

    public Direction(DirectionENUM dEnum) {
        this.dEnum = dEnum;
        setMoveValues();
    }

    public void turnRight() {
        dEnum = DirectionENUM.values()[(dEnum.ordinal() + 1) % 4];
        setMoveValues();
    }

    public void turnLeft() {
        dEnum = DirectionENUM.values()[(dEnum.ordinal() + 3) % 4];
        setMoveValues();
    }

    private void setMoveValues() {
        switch (dEnum.ordinal()) {
            case 0:
                // North direction
                xMove = 0;
                yMove = 1;
                break;
            case 1:
                // East direction
                xMove = 1;
                yMove = 0;
                break;
            case 2:
                // South direction
                xMove = 0;
                yMove = -1;
                break;
            case 3:
                // West direction
                xMove = -1;
                yMove = 0;
                break;
        }
    }

    public int getxMove() {
        return xMove;
    }

    public int getyMove() {
        return yMove;
    }

    @Override
    public String toString() {
        return dEnum + " direction";
    }
}
