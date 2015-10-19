/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package movingrobotlab;

import apcscvm.DefaultControl;
import apcscvm.View;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author DSTIGANT
 */
public class MovingRobotsView extends DefaultControl<MovingRobot[]> implements View<MovingRobot[]>
{
    private int whichBot = 0;
    
    @Override
    public void paint(MovingRobot[] m, Graphics g, int w, int h) 
    {
        for ( int i = 0; i < m.length; i++ )
        {
            BufferedImage bi = new BufferedImage( w/m.length, h, BufferedImage.TYPE_4BYTE_ABGR );
            Graphics gi = bi.createGraphics();
            new MovingRobotView().paint( m[i], gi, w/m.length, h );
            g.drawImage( bi, i*w/m.length, 0, null );
        }
    }
    
    public void handleKeyPress( MovingRobot[] marr, int ea, KeyEvent ke )
    {
        if ( ke.getKeyCode() == KeyEvent.VK_1 )
        {
            whichBot = 0;
        }
        else if ( ke.getKeyCode() == KeyEvent.VK_2 )
        {
            whichBot = 1;
        }
        else if ( ke.getKeyCode() == KeyEvent.VK_3 )
        {
            whichBot = 2;
        }
        else
        {
            new MovingRobotView().handleKeyPress( marr[whichBot], ea, ke );
        }
    }
    
}
