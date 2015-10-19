/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingrobotlab;

import apcscvm.DefaultControl;
import apcscvm.GraphicsUtilityFunctions;
import apcscvm.View;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 *
 * @author DSTIGANT
 */
public class MovingRobotView extends DefaultControl<MovingRobot> implements View<MovingRobot>
{

    @Override
    public void paint(MovingRobot m, Graphics g, int w, int h)
    {
        
        paintHead( m, g, w, h );
        paintTorso( m, g, w, h );
        paintPelvis( m, g, w, h );
        paintArms( m, g, w, h );
        paintLegs( m, g, w, h );
        paintNameTag( m, g, w, h );
                
    }
    
    // paints the head
    private void paintHead( MovingRobot mr, Graphics g, int w, int h )
    {
        
    }
    
    // paints the torso
    private void paintTorso( MovingRobot mr, Graphics g, int w, int h )
    {
        
    }
    
    // paints the pelvis
    private void paintPelvis( MovingRobot mr, Graphics g, int w, int h )
    {
        
    }
    
    // paints the arms
    private void paintArms( MovingRobot mr, Graphics g, int w, int h )
    {
        
    }
    
    // paints the legs
    private void paintLegs( MovingRobot mr, Graphics g, int w, int h )
    {
        
    }
    
    // paints the name tag
    private void paintNameTag( MovingRobot mr, Graphics g, int w, int h )
    {
        
    }
    
    // paints a rotated rectangle outlined in black
    // g - the Graphics object
    // c - the color to fill the rectangle
    // ULCx, ULCy - the upper left corner of the unrotated rectangle
    // width, height - the dimensions of the rectangle
    // cOffX, cOffY - the offset of the point of rotation (relative to the ULC)
    // angle - the angle, in radians to rotate the rectangle.
    private static void paintRotatedRectangle( Graphics g, Color c, int ULCx, int ULCy, int width, int height, int cOffX, int cOffY, double angle )
    {
        
        
    }
    
    // handles keyboard input.
    public void handleKeyPress( MovingRobot mr, int ea, KeyEvent ke )
    {
        
    }
}