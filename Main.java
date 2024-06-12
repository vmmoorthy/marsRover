import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter Grid Width");
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        System.out.println("Please enter Grid Height");
        int height = scanner.nextInt();
        Grid grid = new Grid(width, height);

        System.out.println("Enter number of obstacles:");
        int numObstacles = scanner.nextInt();
        for (int i = 1; i <= numObstacles; i++) {
            System.out.println("Enter " + i + " Obstacles x:");
            int x = scanner.nextInt();
            System.out.println("Enter " + i + " Obstacles y:");
            int y = scanner.nextInt();
            grid.addObstacle(x, y);
        }

        System.out.println("Enter Rovers initial x:");
        int roverX = scanner.nextInt();
        System.out.println("Enter Rovers initial Y:");
        int roverY = scanner.nextInt();

        Direction roverDirection = null;
        while (roverDirection == null) {
            System.out.println("Enter Rovers initial direction <N|E|S|W>:");
            char directionLetter = scanner.next().charAt(0);
            switch (directionLetter) {
                case 'N':
                    roverDirection = new Direction(DirectionENUM.N);
                    break;
                case 'E':
                    roverDirection = new Direction(DirectionENUM.E);
                    break;
                case 'S':
                    roverDirection = new Direction(DirectionENUM.S);
                    break;
                case 'W':
                    roverDirection = new Direction(DirectionENUM.W);
                    break;
                default:
                    System.out.println("Please enter Correct direction");
            }
        }
        Rover rover = new Rover(roverX, roverY, roverDirection, grid);

        CommandInvoker commands = new CommandInvoker();

        char commanderInput = ' ';
        while (commanderInput != 'E') {
            System.out.println("Enter rover command <M-MoveForward|L-LeftTurn|R-RightTurn|E-Exit|S-Get status>:");
            commanderInput = scanner.next().charAt(0);
            switch (commanderInput) {
                case 'M':
                    commands.addCommand(new MoveCommand());
                    break;
                case 'L':
                    commands.addCommand(new TurnLeftCommand());
                    break;
                case 'R':
                    commands.addCommand(new TurnRightCommand());
                    break;
                case 'S':
                    commands.executeCommands(rover);
                    commands = new CommandInvoker();
                    System.out.println(rover.getStatus());
                    break;
                case 'E':
                    commands.executeCommands(rover);
                    System.out.println(rover.getStatus());
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Please enter valid input");
            }
        }
        scanner.close();
    }
}
