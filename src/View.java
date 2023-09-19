import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class View extends JFrame {

    private int [][] maze =
            { {1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,0,1,0,1,0,1,0,0,0,0,0,1},
                {1,0,1,0,0,0,1,0,1,1,1,0,1},
                {1,0,0,0,1,1,1,0,0,0,0,0,1},
                {1,0,1,0,0,0,0,0,1,1,1,0,1},
                {1,0,1,0,1,1,1,0,1,0,0,0,1},
                {1,0,1,0,1,0,0,0,1,1,1,0,1},
                {1,0,1,0,1,1,1,0,1,0,1,0,1},
                {1,0,0,0,0,9,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1}
            };

    private final List<Integer> path = new ArrayList<Integer>();
    public View()
    {
        setTitle("Simple Maze Solver");
        setSize(480, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        DFS.searchPath(maze,path,1,1);
        System.out.println(path);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //shift the maze in the ui
        g.translate(50,50);
        //start coloring the maze
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                Color color;
                switch (maze[row][col])
                {
                    case 1: color=Color.BLACK; break;
                    case 9: color=Color.RED; break;
                    default : color = Color.WHITE;

                }
                //delay before drawing each cell in the whole maze
                makeDelay(10);
                g.setColor(color);
                g.fillRect(30*col,30*row,30,30);
                //fill the boarder of each rectangle with GRAY color
                g.setColor(Color.GRAY);
                g.drawRect(30*col,30*row,30,30);
            }
        }
        Collections.reverse(path);
        for(int p=0;p<path.size();p+=2) {
            makeDelay(200);
            int pathX = path.get(p);
            int pathY = path.get(p+1);
            g.setColor(Color.GREEN);
            g.fillRect(pathX*30,pathY*30,30,30);
        }
        //this commented code starting from the end point(11,8) to the start point(1,1)
        /*for(int p=path.size()-1;p>=0;p-=2) {
            makeDelay(200);
            int pathX = path.get(p-1);
            int pathY = path.get(p);
            g.setColor(Color.YELLOW);
            g.fillRect(pathX*30,pathY*30,30,30);
        }*/

    }

    public static void makeDelay(int delay) {
        try {
            Thread.sleep(delay);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                View view = new View();
                view.setVisible(true);
            }
        });
    }

}