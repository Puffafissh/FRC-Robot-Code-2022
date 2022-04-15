// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Drivebase extends SubsystemBase {

  private VictorSPX motorLeft1 = new VictorSPX(Constants.MOTOR_LEFT_1_ID);
  private VictorSPX motorLeft2 = new VictorSPX(Constants.MOTOR_LEFT_2_ID);
  private VictorSPX motorRight1 = new VictorSPX(Constants.MOTOR_RIGHT_1_ID);
  private VictorSPX motorRight2 = new VictorSPX(Constants.MOTOR_RIGHT_2_ID);
 
  //public void setLeftMotors(double speed){
   // motorLeft1.setInverted(true);
    //motorLeft1.set(ControlMode.PercentOutput, speed);
  //}

  // public void setRightMotors(double speed){
    // motorRight1.set(ControlMode.PercentOutput, speed);
    
  public void setRaw(double leftvalue, double rightvalue) {
	motorLeft1.set(ControlMode.PercentOutput, leftvalue);
  motorLeft2.set(ControlMode.PercentOutput, leftvalue);
	motorRight1.set(ControlMode.PercentOutput, rightvalue);
  motorRight2.set(ControlMode.PercentOutput, rightvalue);
 } 

  @Override
  public void periodic() {
    
  }

  

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }








  }



