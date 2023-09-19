import java.util.List;

public class DFS {

    public static boolean searchPath(int[][] maze, List<Integer> path, int curX, int curY) {
        if(maze[curX][curY] == 9) {
            path.add(curX);
            path.add(curY);
            return true;
        }

        if(maze[curX][curY]==0) {
            maze[curX][curY]=2;
            int dx,dy;

            dx=0;
            dy=-1;
            if(searchPath(maze,path,curX+dx,curY+dy)) {
                path.add(curX);
                path.add(curY);
                return true;
            }

            dx=0;
            dy=1;
            if(searchPath(maze,path,curX+dx,curY+dy)) {
                path.add(curX);
                path.add(curY);
                return true;
            }

            dx=-1;
            dy=0;
            if(searchPath(maze,path,curX+dx,curY+dy)) {
                path.add(curX);
                path.add(curY);
                return true;
            }

            dx=1;
            dy=0;

            //getSearchPath(maze,path,curX,curY,dx,dy);
            if(searchPath(maze,path,curX+dx,curY+dy)) {
                path.add(curX);
                path.add(curY);
                return true;
            }
        }
        return false;
    }

    private static boolean getSearchPath(int[][] maze, List<Integer> path, int curX, int curY, int dx, int dy) {
        if(searchPath(maze,path,curX+dx,curY+dy)) {
            path.add(curX);
            path.add(curY);
            return true;
        }
        return false;
    }
}
