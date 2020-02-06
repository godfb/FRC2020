package frc.robot;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import frc.robot.subsystems.*;

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


    public JoystickButton turboButton8;
    public JoystickButton lowGearButton7;
    public JoystickButton elevatorUpButton6;
    public JoystickButton elevatorLowerButton5;
    public JoystickButton dumpButton3;
    public JoystickButton pickUpButton2;
    public Joystick joystick1;


    public OI() {
        joystick1 = new Joystick(0);

        pickUpButton2 = new JoystickButton(joystick1, 2);
        pickUpButton2.whileHeld(new PickUp());
        dumpButton3 = new JoystickButton(joystick1, 3);
        dumpButton3.whileHeld(new Dump());
        elevatorLowerButton5 = new JoystickButton(joystick1, 5);
        elevatorLowerButton5.whileHeld(new LowerElevator());
        elevatorUpButton6 = new JoystickButton(joystick1, 6);
        elevatorUpButton6.whileHeld(new LiftElevator());
        lowGearButton7 = new JoystickButton(joystick1, 7);
        lowGearButton7.whileHeld(new LowGear());
        turboButton8 = new JoystickButton(joystick1, 8);
        turboButton8.whileHeld(new Turbo());


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("Lift Elevator", new LiftElevator());
        SmartDashboard.putData("Lower Elevator", new LowerElevator());
        SmartDashboard.putData("Dump", new Dump());
        SmartDashboard.putData("Pick Up", new PickUp());
        SmartDashboard.putData("Turbo", new Turbo());
        SmartDashboard.putData("Low Gear", new LowGear());

    }
    public Joystick getJoystick1() {
        return joystick1;
    }
}

