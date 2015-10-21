/*
 * To change this license header, choose License Headers in Project Properties;
 * To change this template file, choose Tools | Templates
 * and open the template in the editor;
 */
package movingrobotlab;

import java.awt.Color;

/**
 *
 * @author DSTIGANT
 */
public class MovingRobot
{
    // Declare instance variables here
    private String name;
    private int w;
    private int h;
    private Color torsoColor;
    private Color legColor;
    private boolean leftUp;
    private boolean rightUp;
    private double rightArmAngle;
    private double leftArmAngle;
    private int[] measures = new int[10];
    
    // Constructor: creates a robot with a name, w, h, and two colors
    // inputs: String name, int w, int h, Color torsoColor, Color legColor
    public MovingRobot(String name, int width, int height, Color torsoColor, Color legColor)
    {
        this.name = name;
        this.w = width;
        this.h = height;
        this.torsoColor = torsoColor;
        this.legColor = legColor;
        
        rightArmAngle = 0;
        leftArmAngle = 0;
        leftUp = false;
        rightUp = false;
        
        measures[0] = (4*h)/10;  //leg & torso height
        measures[1] = h/10;      //pelvis and head height
        measures[2] = (7*w)/10;  //shoulder width
        measures[3] = (7*w)/20;  //waist width
        measures[4] = (3*w)/20;  //arm width
        measures[5] = h/2;       //arm height
        measures[6] = (35*w)/300;//leg width
        measures[7] = (3*w) / 10;//head width
        measures[8] = (7*w)/30;  //name tag width
        measures[9] = h/20;      //name tag height
                
    }   
    
    // getters -
    // provide a getter for each of the 5 supplied fields and each of the 4 other fields
    public String getName()         { return name; }
    public int getWidth()           { return w; }
    public int getHeight()          { return h; }
    public Color getTorsoColor()    { return torsoColor; }
    public Color getLegColor()      { return legColor; }
    
    public boolean isLeftUp()       { return leftUp; }
    public boolean isRightUp()      { return rightUp; }
    public double getRightArmAngle(){ return rightArmAngle; }
    public double getLeftArmAngle() { return leftArmAngle; }
    
    // THE GETTERSBURG ADDRESS
    // provide several other getters for convenience (there are 12 functions here)
    public int[] getMeasures()      { return measures; }
    
    // THE SETTERS OF PLYMOUTH
    // raise/lower arms/legs functions
    public void raiseRightArm() 
    {
        if(rightArmAngle<180)
            rightArmAngle++;
    }
    public void raiseLeftArm() 
    {
        if(leftArmAngle<180)
            leftArmAngle++;
    }
    public void lowerRightArm() 
    {
        if(rightArmAngle>0)
            rightArmAngle--;
    }
    public void lowerLeftArm() 
    {
        if(leftArmAngle>0)
            leftArmAngle--;
    }
    
    public void raiseRightLeg() 
    {
        if(!leftUp)
            rightUp = true;
    }
    public void raiseLeftLeg()
    {
        if(!rightUp)
            leftUp = true;
    }
    public void lowerRightLeg() 
    {
        rightUp = false;
    }
    public void lowerLeftLeg()
    {
        leftUp = false;
    }
}
