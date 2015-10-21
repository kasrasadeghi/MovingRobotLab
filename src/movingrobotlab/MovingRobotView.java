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
import java.awt.Font;
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
        int[] m = mr.getMeasures();
        int cx = w/2;
        int cy = h/2;
        
        g.setColor(mr.getLegColor());
        g.fillRect(cx - m[7]/2, cy-m[0]-m[1], m[7], m[1]);
        g.setColor(Color.BLACK);
        g.drawRect(cx - m[7]/2, cy-m[0]-m[1], m[7], m[1]);
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
        g.setColor(Color.BLACK);
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
        g.setColor(Color.BLACK);
        g.drawRect(cx - m[3]/2, cy, m[3], m[1]);
    }
    
    // paints the arms
    private void paintArms( MovingRobot mr, Graphics g, int w, int h )
    {
        int [] m = mr.getMeasures();
        int tlxr = w/2 + m[2]/2;
        int tlxl = w/2 - m[2]/2 - m[4];
        int tly = h/2 - m[0];
        //paint right arm
        paintRotatedRectangle(g, mr.getTorsoColor(), tlxr, tly, m[4], m[5], 0, m[4]/2, Math.PI*mr.getRightArmAngle()/180);
        //paint left arm
        paintRotatedRectangle(g, mr.getTorsoColor(), tlxl, tly, m[4], m[5], m[4], m[4]/2, -Math.PI*mr.getLeftArmAngle()/180);
    }
    
    // paints the legs
    private void paintLegs( MovingRobot mr, Graphics g, int w, int h )
    {
        int[] m = mr.getMeasures();
        int cx = w/2;
        int cy = h/2;
        
        if(!mr.isRightUp()){
            g.setColor(mr.getLegColor());
            g.fillRect(cx + m[6]/2, cy + m[1], m[6], m[0]);
            g.setColor(Color.BLACK);
            g.drawRect(cx + m[6]/2, cy + m[1], m[6], m[0]);
        } else {
            g.setColor(mr.getLegColor());
            g.fillRect(cx + m[6]/2, cy + m[1], m[0]/2, m[6]);
            g.setColor(Color.BLACK);
            g.drawRect(cx + m[6]/2, cy + m[1], m[0]/2, m[6]);
            g.setColor(mr.getLegColor());
            g.fillRect(cx + m[6]/2 + m[0]/2 - m[6], cy + m[1] + m[6], m[6], m[0]/2);
            g.setColor(Color.BLACK);
            g.drawRect(cx + m[6]/2 + m[0]/2 - m[6], cy + m[1] + m[6], m[6], m[0]/2);
        }
        if(!mr.isLeftUp()){
            g.setColor(mr.getLegColor());
            g.fillRect(cx - 3 * m[6]/2, cy + m[1], m[6], m[0]);
            g.setColor(Color.BLACK);
            g.drawRect(cx - 3 * m[6]/2, cy + m[1], m[6], m[0]);
        } else {
            g.setColor(mr.getLegColor());
            g.fillRect(cx - 3 * m[6]/2 - m[0]/2 + m[6], cy + m[1], m[0]/2, m[6]);
            g.setColor(Color.BLACK);
            g.drawRect(cx - 3 * m[6]/2 - m[0]/2 + m[6], cy + m[1], m[0]/2, m[6]);
            g.setColor(mr.getLegColor());
            g.fillRect(cx + m[6]/2 - m[0]/2 - m[6], cy + m[1] + m[6], m[6], m[0]/2);
            g.setColor(Color.BLACK);
            g.drawRect(cx + m[6]/2 - m[0]/2 - m[6], cy + m[1] + m[6], m[6], m[0]/2);
        }
    }
    
    // paints the name tag
    private void paintNameTag( MovingRobot mr, Graphics g, int w, int h )
    {
        int[] m = mr.getMeasures();
        int cx = w/2;
        int cy = h/2-m[0]+m[9];
        
        g.setColor(Color.WHITE);
        g.fillRect(cx, cy, m[8], m[9]);
        g.setColor(Color.BLACK);
        g.drawRect(cx, cy, m[8], m[9]);
        Font font = GraphicsUtilityFunctions.getFont(m[9]);
        GraphicsUtilityFunctions.drawStringWithFontInRectangle(g, mr.getName(), font, cx, cy, m[8], m[9]);
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
    @Override
    public void handleKeyPress( MovingRobot mr, int ea, KeyEvent ke )
    {
        if (ke.getKeyCode() == KeyEvent.VK_I)
            mr.raiseRightArm();
        if (ke.getKeyCode() == KeyEvent.VK_K)
            mr.lowerRightArm();
        if (ke.getKeyCode() == KeyEvent.VK_W)
            mr.raiseLeftArm();
        if (ke.getKeyCode() == KeyEvent.VK_S)
            mr.lowerLeftArm();
        if (ke.getKeyCode() == KeyEvent.VK_U)
            mr.raiseRightLeg();
        if (ke.getKeyCode() == KeyEvent.VK_J)
            mr.lowerRightLeg();
        if (ke.getKeyCode() == KeyEvent.VK_Q)
            mr.raiseLeftLeg();
        if (ke.getKeyCode() == KeyEvent.VK_A)
            mr.lowerLeftLeg();
    }
}
