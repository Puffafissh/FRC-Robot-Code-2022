// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Conveyer extends SubsystemBase {

  private Spark conveyermotor;
 
 public Conveyer() {
conveyermotor = new Spark(5);
conveyermotor.setSafetyEnabled(false);
  }

  public void setRaw(double conveyervalue) {
		conveyermotor.set(conveyervalue);
		
  }

  @Override
  public void periodic() {
    
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
