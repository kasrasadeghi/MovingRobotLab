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
        int cx = w/2;
        int cy = h/2;
        int[] m = mr.getMeasures();
        g.setColor(mr.getTorsoColor());
        int[] xpoints = {cx - m[3]/2, cx + m[3]/2, cx + m[2]/2, cx + m[2]/2, cx - m[2]/2, cx - m[2]/2 };
        int[] ypoints = {cy         , cy         ,cy-m[0]+m[4], cy - m[0]  , cy - m[0]  , cy-m[0]+m[4]};
        g.fillPolygon(xpoints, ypoints, 6);
        g.drawPolygon(xpoints, ypoints, 6);
    }
    
    // paints the pelvis
    private void paintPelvis( MovingRobot mr, Graphics g, int w, int h )
    {
        g.setColor(mr.getLegColor());
        int[] m = mr.getMeasures();
        int cx = w/2;
        int cy = h/2;
        g.fillRect(cx - m[3]/2, cy, m[3], m[1]);
    }
    
    // paints the arms
    private void paintArms( MovingRobot mr, Graphics g, int w, int h )
    {
        
        int tlxr = w/2 - m[2]/2;
        int tlxl = w/2
        int tly
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
        BufferedImage bi = new BufferedImage( width + 1, height + 1, BufferedImage.TYPE_4BYTE_ABGR );
        Graphics g2 = bi.createGraphics();
        
        g2.setColor( c );
        g2.fillRect( 0, 0, width, height );
        g2.setColor( Color.BLACK );
        g2.drawRect( 0, 0, width, height );
        
        AffineTransform at = AffineTransform.getTranslateInstance( ULCx, ULCy);
        at.concatenate( AffineTransform.getRotateInstance( -angle, cOffX, cOffY ) );
        Graphics2D g2D = (Graphics2D)g;
        g2D.drawImage( bi, at, null );
    }
    
    // handles keyboard input.
    public void handleKeyPress( MovingRobot mr, int ea, KeyEvent ke )
    {
        
    }
}
