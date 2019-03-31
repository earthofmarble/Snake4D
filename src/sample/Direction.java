package sample;

enum Direction {

    NORTH(-1,0),
    WEST(0,-1),
    SOUTH(1,0),
    EAST(0,1),

    NONE(0,0);  //от волков и зайцев осталось, пускай будет


    private final int xSteps;
    private final int ySteps;

    Direction(int xSteps, int ySteps) {
        this.xSteps = xSteps;
        this.ySteps = ySteps;
    }

    public int getNewXId(int currentXId)  {
        return  (currentXId + getXSteps());
    }
    public int getNewYId(int currentYId)  {
        return  (currentYId + getYSteps());
    }

    public int getXSteps()  {
        return  xSteps;
    }
    public int getYSteps()  {
        return  ySteps;
    }

}