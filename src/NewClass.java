import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class NewClass extends JFrame {
    private int [][] maze =
     {{1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,1,1,1,1,1,0,0,0,0,0,1},
        {1,0,0,1,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
        
    };

    //to store the desired path
    public List<Integer> path  = new ArrayList<>();

    //constructor
    public NewClass(){
        //set the title of the window
        setTitle("Maze Solver");
        
        //set th size of the window
        setSize(640,480);

        //operation on the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //calling the function
        DepthFirst.searchpath(maze,1,1,path);

    }

    //override the function
    @Override
    public void paint(Graphics g){
        g.translate(70, 70);

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                Color color;
                switch (maze[i][j]) {
                    case 1:
                        color = Color.GREEN;
                        break;

                    case 9:
                        color = Color.CYAN;
                        break;
                
                    default:
                        color = Color.WHITE;
                        break;
                }

                g.setColor(color);
                g.fillRect(30*j, 30*i, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(30*j, 30*i, 30, 30);

                
            }
            
        }

        for (int i = 0; i < path.size(); i+=2) {
            int pathx = path.get(i);
            int pathy = path.get(i+1);

            g.setColor(Color.pink);
            g.fillRect(30*pathx, 30*pathy, 20, 20);
        }
    }

    public static void main(String[] args) {
        NewClass view = new NewClass();
        view.setVisible(true);
    }
}
