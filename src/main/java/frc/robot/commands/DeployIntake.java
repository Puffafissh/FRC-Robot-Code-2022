// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeDeploy;

public class DeployIntake extends CommandBase 
{
  private final IntakeDeploy m_IntakeDeploy;
  private XboxController INTAKEDRIVER;
  /** Creates a new DeployIntake. */

  public DeployIntake(IntakeDeploy intakeDeploy, XboxController xController) {

    this.m_IntakeDeploy = intakeDeploy;
    INTAKEDRIVER = xController;
    addRequirements(m_IntakeDeploy);
    


    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    this.m_IntakeDeploy.setRaw(0.75);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    double y = INTAKEDRIVER.getRawAxis(1)*-0.5;
    m_IntakeDeploy.setRaw(y);
    // double Y = INTAKEDRIVER.getLeftY()*-0.5;
    // myLoggger.message = Y;
    // boolean top = INTAKEDRIVER.();
//   }

// if(top==true)
// {
  // m_IntakeDeploy.setRaw(0, -1*);
}


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
      m_IntakeDeploy.setRaw(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
