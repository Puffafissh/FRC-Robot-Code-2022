// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeDeploy extends SubsystemBase {
  private Spark intakedeploymotor;
  /** Creates a new IntakeDeploy. */
  public IntakeDeploy() 
  {
    intakedeploymotor = new Spark(7);
    intakedeploymotor.setSafetyEnabled(false);
  }

    public void setRaw(double intakedeployvalue)
    {
      intakedeploymotor.set(intakedeployvalue);
    }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
