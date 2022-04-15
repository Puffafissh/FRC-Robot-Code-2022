// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.Set;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.commands.subcommands.ClimbButton;
import frc.robot.subsystems.Climber;

public final class ClimbSequence implements Command {
  /** Creates a new ClimbSequence. */
  public ClimbSequence() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

public ClimbSequence(Climber m_Climber) {
  }

public Command getStep1(Climber climber)
{
    return new ClimbButton(climber);
}

public Command getStep2(Climber climber)
{
    return new ClimbExtend(climber);
}

@Override
public Set<Subsystem> getRequirements() {
  // TODO Auto-generated method stub
  return null;
}
}
