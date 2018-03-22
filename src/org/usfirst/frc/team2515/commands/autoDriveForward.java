// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team2515.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2515.Robot;

/**
 *
 */
public class autoDriveForward extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_time;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double startingDistance;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public autoDriveForward(double time) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_time = time;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveSystem);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        setTimeout(m_time);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
		startingDistance = Robot.sonarSystem.getDistance();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	driveStraight(Robot.driveSystem.getGyro(),Robot.sonarSystem.getDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
		//return isTimedOut();
		if (isTimedOut()) {
			// if Timeout is reached return true
    			return true;
		}    
		if (Robot.sonarSystem.getDistance() < 10.0) {
			return true;
		}
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
    
    public void driveStraight(double gyroAngle, double sonarDistance) {
    	double angleAdjust = 1; //the amount to adjust when the gyro gets off. 
    	//ramp the angleAdjust up if robot still gets off course; knock it down if robot 
    	//Calculate values for drive system based on gyro angle and sonar distance.
    	double y = forwardSpeed(sonarDistance);//something with distance
    	double z = -angleAdjust * gyroAngle/180.0;//something with gyro
    	Robot.driveSystem.drive(0,y,z,0);
    }
    public double forwardSpeed(double currentDistance) //a function that controls the speed based on distance
    {
    	double speed = 0; //the return variable
    	double maxSpeed = .75; // this is the maximum possible speed
    	double fullSpeedDistance = .9 * startingDistance;//the distance by which the robot should have reached full speed.
    	double slowDownDistance = .1 * startingDistance; //the distance where the robot needs to slow down
    	if(currentDistance > fullSpeedDistance)
    	{
    		speed = maxSpeed * Math.max(Math.sqrt((startingDistance - currentDistance) / (startingDistance - fullSpeedDistance))+.9,1); 
    	}
    	else if(currentDistance > slowDownDistance)
    	{
    		speed = maxSpeed;
    	}
    	else if(currentDistance < slowDownDistance)
    	{
    		speed = maxSpeed * Math.sqrt(currentDistance/slowDownDistance);
    	}
    	return 1;
    }
}
