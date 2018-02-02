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
    public JoystickButton joystickClimeUpButton;
    public Joystick joystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystick = new Joystick(0);
        
        joystickClimeUpButton = new JoystickButton(joystick, 6);
        joystickClimeUpButton.whileHeld(new climbUp());
        joystickLowerLiftButton = new JoystickButton(joystick, 3);
        joystickLowerLiftButton.whileHeld(new liftLowerManually());
        joystickRaiseLiftButton = new JoystickButton(joystick, 4);
        joystickRaiseLiftButton.whileHeld(new liftRaiseManually());
        joystickLiftBottomButton = new JoystickButton(joystick, 11);
        joystickLiftBottomButton.whenPressed(new controlLift(0));
        joystickLiftMiddleButton = new JoystickButton(joystick, 9);
        joystickLiftMiddleButton.whenPressed(new lfitMoveToMiddle(50));
        joystickLiftTopButton = new JoystickButton(joystick, 7);
        joystickLiftTopButton.whenPressed(new liftMoveToTop(100));
        joystickOpenClawButton = new JoystickButton(joystick, 2);
        joystickOpenClawButton.whenPressed(new openClaw());
        joystickCloseClawButton = new JoystickButton(joystick, 1);
        joystickCloseClawButton.whenPressed(new closeClaw());


        // SmartDashboard Buttons
        SmartDashboard.putData("teleopDrive", new teleopDrive());
        SmartDashboard.putData("openClaw", new openClaw());
        SmartDashboard.putData("closeClaw", new closeClaw());
        SmartDashboard.putData("controlLift: Bottom", new controlLift(0));
        SmartDashboard.putData("controlLift: Middle", new controlLift(30));
        SmartDashboard.putData("controlLift: Top", new controlLift(99));
        SmartDashboard.putData("pidControlLift: bottom", new pidControlLift(0));
        SmartDashboard.putData("pidControlLift: middle", new pidControlLift(0));
        SmartDashboard.putData("pidControlLift: top", new pidControlLift(0));
        SmartDashboard.putData("liftMoveToTop: position", new liftMoveToTop(100));
        SmartDashboard.putData("lfitMoveToMiddle: position", new lfitMoveToMiddle(50));
        SmartDashboard.putData("liftMoveToBottom: position", new liftMoveToBottom(0));
        SmartDashboard.putData("liftRaiseManually", new liftRaiseManually());
        SmartDashboard.putData("liftLowerManually", new liftLowerManually());
        SmartDashboard.putData("climbUp", new climbUp());
        SmartDashboard.putData("autoDriveForward", new autoDriveForward());
        SmartDashboard.putData("autoDriveBackward", new autoDriveBackward());
        SmartDashboard.putData("autoSlideLeft", new autoSlideLeft());
        SmartDashboard.putData("autoSlideRight", new autoSlideRight());
        SmartDashboard.putData("autoTurnLeft", new autoTurnLeft());
        SmartDashboard.putData("autoTurnRight", new autoTurnRight());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        //joystick.getRawAxis(5); // Trottle slider on joystick
        //joystick.getRawAxis(6); // HAT swtich on top of joystick
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick() {
        return joystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

