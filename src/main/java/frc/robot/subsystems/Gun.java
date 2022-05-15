// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Gun extends SubsystemBase {

  private CANSparkMax ShooterMotorLeft = new CANSparkMax(Constants.SHOOTER_MOTOR_ID_LEFT, MotorType.kBrushless);
  private CANSparkMax ShooterMotorRight = new CANSparkMax(Constants.SHOOTER_MOTOR_ID_Right, MotorType.kBrushless);


public void Shooter() {
  
ShooterMotorLeft.restoreFactoryDefaults(false);
ShooterMotorRight.restoreFactoryDefaults(false);
  }

  public void setRaw(double shootvalueLeft, double shootvalueRight) {
    ShooterMotorLeft.set(shootvalueLeft);
	  ShooterMotorRight.set(shootvalueRight);
		
  }

  @Override
  public void periodic() {
    
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
