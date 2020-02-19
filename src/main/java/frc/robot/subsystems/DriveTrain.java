package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.OI;


public class DriveTrain extends Subsystem {

    private PWMVictorSPX speedController1;
    private Spark speedController2;
    private SpeedControllerGroup leftSpeedControllerGroup1;
    private PWMVictorSPX speedController3;
    private Spark speedController4;
    private SpeedControllerGroup rightSpeedControllerGroup2;
    private DifferentialDrive differentialDrive1;
    private AnalogGyro analogGyro1;
    private Servo leftServo1;
    private Servo rightServo2;
    private int servoAngle = 0;
    private boolean shiftIssued = false;
    private boolean shifting = false;
    private Encoder leftQuadratureEncoder1;
    private Encoder rightQuadratureEncoder1;
    public OI interf = new OI();
    private Timer shiftTimer = new Timer();

    public DriveTrain() {

        /*
            List of which motors are where
            0 speedController3
            1 speedController1
            2 speedController4
            3 speedController2
        */

        // Everything below here is setup for motors and such

        speedController1 = new PWMVictorSPX(1);
        addChild("Speed Controller 1",speedController1);
        speedController1.setInverted(false);
                
        speedController2 = new Spark(3);
        addChild("Speed Controller 2",speedController2);
        speedController2.setInverted(false);
                
        leftSpeedControllerGroup1 = new SpeedControllerGroup(speedController1, speedController2  );
        addChild("Left Speed Controller Group 1",leftSpeedControllerGroup1);

                
        speedController3 = new PWMVictorSPX(0);
        addChild("Speed Controller 3",speedController3);
        speedController3.setInverted(true);
                
        speedController4 = new Spark(2);
        addChild("Speed Controller 4",speedController4);
        speedController4.setInverted(true);
                
        rightSpeedControllerGroup2 = new SpeedControllerGroup(speedController3, speedController4  );
        addChild("Right Speed Controller Group 2",rightSpeedControllerGroup2);

                
        differentialDrive1 = new DifferentialDrive(leftSpeedControllerGroup1, rightSpeedControllerGroup2);
        addChild("Differential Drive 1",differentialDrive1);
        differentialDrive1.setSafetyEnabled(false);
        differentialDrive1.setExpiration(0.1);
        differentialDrive1.setMaxOutput(1.0);

                
        analogGyro1 = new AnalogGyro(0);
        addChild("AnalogGyro 1",analogGyro1);
        analogGyro1.setSensitivity(0.007);
                
        leftServo1 = new Servo(5);
        addChild("Left Servo 1",leftServo1);

                
        rightServo2 = new Servo(4);
        addChild("Right Servo 2",rightServo2);

                
        leftQuadratureEncoder1 = new Encoder(1, 3, false, EncodingType.k1X);
        addChild("Left Quadrature Encoder 1",leftQuadratureEncoder1);
        leftQuadratureEncoder1.setDistancePerPulse(1.0);
        leftQuadratureEncoder1.setPIDSourceType(PIDSourceType.kRate);
                
        rightQuadratureEncoder1 = new Encoder(0, 2, false, EncodingType.k1X);
        addChild("Right Quadrature Encoder 1",rightQuadratureEncoder1);
        rightQuadratureEncoder1.setDistancePerPulse(1.0);
        rightQuadratureEncoder1.setPIDSourceType(PIDSourceType.kRate);
        
    }

    @Override
    public void initDefaultCommand() {
    }

    // This is where auto code is to be placed (Called once in 'autonomousInit' in 'Robot.java')
    // A periodic autonomous function can also be created, but currently isn't.
    public void auto(){
        speedController1.set(.1);
        speedController2.set(.1);
        speedController3.set(.1);
        speedController4.set(.1);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        
            e.printStackTrace();
        }
        speedController1.set(0);
        speedController2.set(0);
        speedController3.set(0);
        speedController4.set(0);

    }

    // Called every tick
    @Override
    public void periodic() {
        // Gets stick axis 
        double leftSpeed = interf.joystick1.getRawAxis(3);
        double rightSpeed = interf.joystick1.getRawAxis(1);
        
        double deadZone = 0; // ALlows us to add "dead zone" to the stick
        double exponentFactor = 1; // Allows us to put expoential controls on the bot (Only use odd integers here, even requires extra work)
        double turboFactor = 2; // Sets the max speed of the motor to MAXSPEED/turboFactor

        // Sets the turbo factor to 1, effectively unlocking the full speed of the motor
        if (interf.joystick1.getRawButton(8)){
            turboFactor=1;
        }
        
        // Checks for dead zone compliance
        if (Math.abs(rightSpeed) > deadZone){
            // Sets the right motor speed to be the thumbstick, set to the exponent and then checks for turbo
            speedController3.set(Math.pow(rightSpeed, exponentFactor)/turboFactor);
            speedController4.set(Math.pow(rightSpeed, exponentFactor)/turboFactor);
        }
        // Sets the right motor to 0 speed if the sticks are within the deadzone
        else{
            speedController3.set(0);
            speedController4.set(0);
        }

        // Checks for dead zone compliance
        if (Math.abs(leftSpeed) > deadZone){
            // Sets the left motor speed to be the thumbstick, set to the exponent and then checks for turbo
            speedController1.set(Math.pow(leftSpeed, exponentFactor)/turboFactor);
            speedController2.set(Math.pow(leftSpeed, exponentFactor)/turboFactor);
        }
        // Sets the right motor to 0 speed if the sticks are within the deadzone
        else{
            speedController1.set(0);
            speedController2.set(0);
        }
    }
}

