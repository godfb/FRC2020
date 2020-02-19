package frc.robot.subsystems;


import frc.robot.commands.*;
import frc.robot.OI;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;

public class DumpMech extends Subsystem {

    private OI interf = new OI();
    private PWMVictorSPX dumpMechspeedController10;


    public DumpMech() {
        dumpMechspeedController10 = new PWMVictorSPX(7);
        addChild("Dump Mech Speed Controller 10",dumpMechspeedController10);
        dumpMechspeedController10.setInverted(false);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }

    @Override
    public void periodic() {
        if (interf.joystick1.getRawButton(7)){
            dumpMechspeedController10.set(1);
        }
        else {
            dumpMechspeedController10.set(0);
        }

    }


}

