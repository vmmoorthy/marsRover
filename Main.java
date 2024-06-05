
public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(10, 10);
        grid.addObstacle(2, 2);
        grid.addObstacle(3, 5);

        Rover rover = new Rover(0, 0, new Direction(DirectionENUM.N), grid);

        CommandInvoker commands = new CommandInvoker();

        commands.addCommand(new MoveCommand());
        commands.addCommand(new MoveCommand());
        commands.addCommand(new TurnRightCommand());
        commands.addCommand(new MoveCommand());
        commands.addCommand(new TurnLeftCommand());
        commands.addCommand(new MoveCommand());

        commands.executeCommands(rover);

        System.out.println(rover.getStatus());
    }
}
