package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;

public class PickupMech extends Subsystem {

    private PWMVictorSPX pickUpMechspeedController11;

    public PickupMech() {
        // pickUpMechspeedController11 = new PWMVictorSPX(8);
        // addChild("Pick Up Mech Speed Controller 11",pickUpMechspeedController11);
        // pickUpMechspeedController11.setInverted(false);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }
}
