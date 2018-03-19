// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team2515;

import org.usfirst.frc.team2515.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2515.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton joystickCloseClawButton;
    public JoystickButton joystickOpenClawButton;
    public JoystickButton joystickLiftTopButton;
    public JoystickButton joystickLiftMiddleButton;
    public JoystickButton joystickLiftBottomButton;
    public JoystickButton joystickRaiseLiftButton;
    public JoystickButton joystickLowerLiftButton;
    public JoystickButton joystickClimbUpButton;
    public JoystickButton joystickOpenClawSlowButton;
    public JoystickButton joystickClimbDownButton;
    public JoystickButton joystickLiftToRung;
    public Joystick joystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public double accelerateMultiplier;

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystick = new Joystick(0);
        
        joystickLiftToRung = new JoystickButton(joystick, 10);
        joystickLiftToRung.whenPressed(new pidLiftAuto(3300));
        joystickClimbDownButton = new JoystickButton(joystick, 5);
        joystickClimbDownButton.whileHeld(new climbDown());
        joystickOpenClawSlowButton = new JoystickButton(joystick, 8);
        joystickOpenClawSlowButton.whileHeld(new openClaw(0.3));
        joystickClimbUpButton = new JoystickButton(joystick, 6);
        joystickClimbUpButton.whileHeld(new climbUp());
        joystickLowerLiftButton = new JoystickButton(joystick, 3);
        joystickLowerLiftButton.whileHeld(new pidLiftManual(-25));
        joystickRaiseLiftButton = new JoystickButton(joystick, 4);
        joystickRaiseLiftButton.whileHeld(new pidLiftManual(25));
        joystickLiftBottomButton = new JoystickButton(joystick, 11);
        joystickLiftBottomButton.whenPressed(new pidLiftAuto(0));
        joystickLiftMiddleButton = new JoystickButton(joystick, 9);
        joystickLiftMiddleButton.whenPressed(new pidLiftAuto(2400));
        joystickLiftTopButton = new JoystickButton(joystick, 7);
        joystickLiftTopButton.whenPressed(new pidLiftAuto(5000));
        joystickOpenClawButton = new JoystickButton(joystick, 2);
        joystickOpenClawButton.whileHeld(new openClaw(1.0));
        joystickCloseClawButton = new JoystickButton(joystick, 1);
        joystickCloseClawButton.whenPressed(new closeClaw());


        // SmartDashboard Buttons
        SmartDashboard.putData("teleopDrive", new teleopDrive());
        SmartDashboard.putData("openClaw: normal", new openClaw(1.0));
        SmartDashboard.putData("openClaw: slow", new openClaw(0.3));
        SmartDashboard.putData("closeClaw", new closeClaw());
        SmartDashboard.putData("climbUp", new climbUp());
        SmartDashboard.putData("pidLiftAuto: top3", new pidLiftAuto(5000));
        SmartDashboard.putData("pidLiftAuto: middle", new pidLiftAuto(2400));
        SmartDashboard.putData("pidLiftAuto: bottom", new pidLiftAuto(0));
        SmartDashboard.putData("pidLiftAuto: rung", new pidLiftAuto(3300));
        SmartDashboard.putData("pidLiftManual: up", new pidLiftManual(25));
        SmartDashboard.putData("pidLiftManual: down", new pidLiftManual(-25));
        SmartDashboard.putData("climbDown", new climbDown());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        //joystick.getRawAxis(4); // Trottle slider on joystick
        //joystick.getRawAxis(5); // HAT swtich Y axis on top of joystick
        //joystick.getRawAxis(6); // HAT swtich X axis on top of joystick
        
        // Use use joystick 4th axis values -1 to 1 to create 50%-100% multiplier for acceleration/speed
       
        //SmartDashboard.putData("Accelerate Multiplier",joystick.getRawAxis(4) + 3)*.25);
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick() {
        return joystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public double getAccelerateMultiplier() {
		double accelerateMultiplier = ((joystick.getRawAxis(3) + 3)*.25);
		SmartDashboard.putNumber("Acceleration Drag (Raw)", joystick.getRawAxis(3));
		SmartDashboard.putNumber("Acceleration Drag (Real)",accelerateMultiplier);
		return accelerateMultiplier;
    }
}

