// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Climber extends SubsystemBase {

  private CANSparkMax climbmotor1;
  private CANSparkMax climbmotor2;
  /** Creates a new Climber. */
  public Climber() {
    
  climbmotor1 = new CANSparkMax(Constants.CLIMBER_MOTOR_ID_1, MotorType.kBrushless);
  climbmotor2 = new CANSparkMax(Constants.CLIMBER_MOTOR_ID_2, MotorType.kBrushless);

  }
  public void Shooter() {
  
    climbmotor1.restoreFactoryDefaults(false);
    climbmotor2.restoreFactoryDefaults(false);
      }
    
  public void setRaw(double climbvalueLeft, double climbvalueRight) {
    climbmotor1.set(climbvalueLeft);
    climbmotor2.set(climbvalueRight);
    
      }
  
		
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
