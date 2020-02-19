package frc.robot;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import frc.robot.subsystems.*;

public class OI {

    public JoystickButton turboButton8;
    public JoystickButton lowGearButton7;
    public JoystickButton elevatorUpButton6;
    public JoystickButton elevatorLowerButton5;
    public JoystickButton dumpButton3;
    public JoystickButton pickUpButton2;
    public Joystick joystick1;

    // This code seemed to break everything, I didn't have time to explore it so I just commented it out.
    // It probably is the "right" place to place all controller code, but that's not currently how it works.
    // Everything there was automatically generated
    public OI() {
        joystick1 = new Joystick(0);

        // pickUpButton2 = new JoystickButton(joystick1, 2);
        // pickUpButton2.whileHeld(new PickUp());
        // dumpButton3 = new JoystickButton(joystick1, 3);
        // dumpButton3.whileHeld(new Dump());
        // elevatorLowerButton5 = new JoystickButton(joystick1, 5);
        // elevatorLowerButton5.whileHeld(new LowerElevator());
        // elevatorUpButton6 = new JoystickButton(joystick1, 6);
        // elevatorUpButton6.whileHeld(new LiftElevator());
        // lowGearButton7 = new JoystickButton(joystick1, 7);
        // lowGearButton7.whileHeld(new LowGear());
        // turboButton8 = new JoystickButton(joystick1, 8);
        // turboButton8.whileHeld(new Turbo());


        // // SmartDashboard Buttons
        // SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        // SmartDashboard.putData("Lift Elevator", new LiftElevator());
        // SmartDashboard.putData("Lower Elevator", new LowerElevator());
        // SmartDashboard.putData("Dump", new Dump());
        // SmartDashboard.putData("Pick Up", new PickUp());
        // SmartDashboard.putData("Turbo", new Turbo());
        // SmartDashboard.putData("Low Gear", new LowGear());

    }
    public Joystick getJoystick1() {
        return joystick1;
    }
}

