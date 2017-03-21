package org.usfirst.frc.team5493.robot;

import org.usfirst.frc.team5493.robot.commands.CaptureRope;
import org.usfirst.frc.team5493.robot.commands.ClimbRope;
import org.usfirst.frc.team5493.robot.commands.ReleaseGear;
import org.usfirst.frc.team5493.robot.commands.UnCaptureRope;
import org.usfirst.frc.team5493.robot.commands.CloseGear;
import org.usfirst.frc.team5493.robot.commands.PrintDistance;
import org.usfirst.frc.team5493.robot.commands.UnClimb;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    private Joystick driveJoystick = new Joystick(RobotMap.DRIVE_JOYSTICK_PORT);
    private Joystick joy2 = new Joystick(RobotMap.JOYSTICK2_PORT);
    DriverStation ds = DriverStation.getInstance();
 
   
    public Joystick getDriveJoystick(){
    	return driveJoystick;
    }
    
    public Joystick getJoystick2(){
    	return joy2;
    }
    
    public OI(){
    	JoystickButton climbRope = new JoystickButton(joy2, RobotMap.JOY2BTN_Y);
    	JoystickButton climbRope2 = new JoystickButton(joy2, RobotMap.JOYBTN_LEFT_AXIS_CLICK);
    	JoystickButton unClimb = new JoystickButton(joy2, RobotMap.JOY2BTN_A);
    	JoystickButton captureRope = new JoystickButton(joy2, RobotMap.JOY2BTN_B);
    	JoystickButton captureRopeDriver = new JoystickButton(driveJoystick, RobotMap.JOY_DRIVEBTN_B);
    	JoystickButton unCaptureRope = new JoystickButton(joy2, RobotMap.JOY2BTN_X);
    	JoystickButton releaseGear = new JoystickButton(joy2, RobotMap.JOYBTN_RB);
    	JoystickButton closeGear = new JoystickButton(joy2, RobotMap.JOYBTN_LB);
    	
    	JoystickButton printDist = new JoystickButton(driveJoystick, RobotMap.JOY_DRIVEBTN_A);
    	
    	//if(climbRope.get() && climbRope2.get())
    		//climbRope.whileHeld(new ClimbRope());
    	
    	climbRope.whileHeld(new ClimbRope());
    	
    	unClimb.whileHeld(new UnClimb());
    	captureRope.whenPressed(new CaptureRope());
    	captureRopeDriver.whenPressed(new CaptureRope());
    	unCaptureRope.whenPressed(new UnCaptureRope());
    	releaseGear.whenPressed(new ReleaseGear());
    	closeGear.whenPressed(new CloseGear());
    	printDist.whenPressed(new PrintDistance());
       
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    	
    }
    
}

