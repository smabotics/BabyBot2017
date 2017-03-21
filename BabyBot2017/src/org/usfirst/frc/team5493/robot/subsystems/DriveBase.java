package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.RobotMap;
import org.usfirst.frc.team5493.robot.commands.JoystickDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveBase extends Subsystem {

	public SpeedController leftBackMotor;
	public SpeedController rightBackMotor;
	public SpeedController leftFrontMotor;
	public SpeedController rightFrontMotor;
	private RobotDrive drive;

	public DriveBase() {
		super();

		leftFrontMotor = RobotMap.SpeedController(RobotMap.leftFront, RobotMap.USE_PWM_TALON);
		rightFrontMotor = RobotMap.SpeedController(RobotMap.rightFront, RobotMap.USE_PWM_VICTOR);
		leftBackMotor = RobotMap.SpeedController(RobotMap.leftBack, RobotMap.USE_PWM_VICTOR);
		rightBackMotor = RobotMap.SpeedController(RobotMap.rightBack, RobotMap.USE_PWM_VICTOR);
		//rightFrontMotor.setInverted(true);
		//rightBackMotor.setInverted(true);
		leftFrontMotor.setInverted(true);
		leftBackMotor.setInverted(true);

		drive = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);
		drive.setExpiration(0.1);
		//LiveWindow.addActuator(DRIVE_SYSTEM, LEFT_FRONT, (LiveWindowSendable) leftFrontMotor);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());
	}

	public void drive(Joystick j) {
		//drive(j.getX(), j.getY(), j.getTwist(), 0);
		drive(j.getX(), j.getZ() * -1, j.getY() * -1, 0);
	}

	public void drive(double x, double y, double twist, double gyro) {
		drive.mecanumDrive_Cartesian(x, y, twist, gyro);
	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void log() {

		SmartDashboard.putNumber("Left Back Motor Speed", this.leftBackMotor.get());
		SmartDashboard.putNumber("Right Back Motor Speed", this.rightBackMotor.get());
		SmartDashboard.putNumber("Left Front Motor Speed", this.leftFrontMotor.get());
		SmartDashboard.putNumber("Right Front Motor Speed", this.rightFrontMotor.get());
	}

	public void stop() {
		drive(0.0, 0.0, 0.0, 0.0);
	}
}
