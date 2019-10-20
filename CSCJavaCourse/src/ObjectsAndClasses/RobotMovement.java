package ObjectsAndClasses;

public class RobotMovement {
    public static void main(String[] args) {
        Robot robot = new Robot(12, -1, Direction.RIGHT);
        moveRobot(robot, -15, 25);
        System.out.println(robot.getX() + " " + robot.getY());
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot(int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {
            return dir;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void turnLeft() {
            if (dir == Direction.UP) {
                dir = Direction.LEFT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.DOWN;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.UP;
            }
        }

        public void turnRight() {
            if (dir == Direction.UP) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.LEFT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.UP;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.DOWN;
            }
        }

        public void stepForward() {
            if (dir == Direction.UP) {
                y++;
            }
            if (dir == Direction.DOWN) {
                y--;
            }
            if (dir == Direction.LEFT) {
                x--;
            }
            if (dir == Direction.RIGHT) {
                x++;
            }
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        while (robot.getX() < toX) {
            while (robot.getDirection().ordinal() != 3) {
                robot.turnLeft();
            }
            robot.stepForward();
        }
        while (robot.getX() > toX) {
            while (robot.getDirection().ordinal() != 2) {
                robot.turnLeft();
            }
            robot.stepForward();
        }
        while (robot.getY() < toY) {
            while (robot.getDirection().ordinal() != 0) {
                robot.turnLeft();
            }
            robot.stepForward();
        }
        while (robot.getY() > toY) {
            while (robot.getDirection().ordinal() != 1) {
                robot.turnLeft();
            }
            robot.stepForward();
        }
    }
}
