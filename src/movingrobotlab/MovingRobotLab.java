/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingrobotlab;

import apcscvm.CVMProgram;
import java.awt.Color;

/**
 *
 * @author DSTIGANT
 */
public class MovingRobotLab
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
//        launchSingleRobot();
        launchMultiRobot();
    }
    
    public static void launchSingleRobot()
    {
        MovingRobot mr = new MovingRobot( "Dave", 200, 400, Color.BLUE, Color.RED );
        MovingRobotView cv = new MovingRobotView();
        new CVMProgram( "Moving Robot", 800, 600, cv, cv, mr ).start();
    }
    
    public static void launchMultiRobot()
    {
        MovingRobot [] marr = new MovingRobot[3];
        marr[0] = new MovingRobot( "Al", 100, 200, Color.PINK, Color.ORANGE );
        marr[1] = new MovingRobot( "Beth", 200, 400, Color.GREEN, Color.GRAY );
        marr[2] = new MovingRobot( "Cam", 290, 200, Color.YELLOW, Color.MAGENTA );
        
        MovingRobotsView cv = new MovingRobotsView();
        new CVMProgram( "Moving Robots", 900, 600, cv, cv, marr ).start();
    }
    
}
