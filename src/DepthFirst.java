import java.util.List;

public class DepthFirst {
    public static boolean searchpath(int [][] maze, int x, int y, List<Integer> path) {
        if (maze[y][x] == 9) {
            path.add(x);
            path.add(y);
            return true;
            
        }

        if (maze[y][x] == 0) {
            maze[y][x] = 2;

            //search in upward direction
            if (searchpath(maze, x-1, y, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            //search in downward direction

            if (searchpath(maze, x+1, y, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            //search in rigth direction
            if(searchpath(maze, x, y+1, path)){
                path.add(x);
                path.add(y);
                return true;
            }

            //search in left direction
            if (searchpath(maze, x, y-1, path)) {
                path.add(x);
                path.add(y);
                return true;
            }
        }
        return false;
    }
}
