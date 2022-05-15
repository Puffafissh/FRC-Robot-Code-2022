// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.subcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;
import edu.wpi.first.wpilibj.Timer;

public class ClimbRetract extends CommandBase 
{
    private final Climber m_climb;
  /** Creates a new ClimbRetract. */
  public ClimbRetract(Climber climb) 
  {
    this.m_climb = climb;
    addRequirements(m_climb);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
      this.m_climb.setRaw(-0.75,0.75);

      Timer.delay(0.5);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      m_climb.setRaw(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
