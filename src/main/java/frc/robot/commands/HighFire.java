// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Conveyer;
import frc.robot.subsystems.Gun;
import frc.robot.subsystems.Transfer;

/** An example command that uses an example subsystem. */
public class HighFire extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Conveyer m_conveyer;
  private final Transfer m_transfer;
  private final Gun m_gun;


  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public HighFire(Conveyer conveyer, Transfer transfer, Gun gun) {
    m_conveyer = conveyer;
    m_gun = gun;
    m_transfer = transfer; 

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_conveyer);
    addRequirements(m_gun);
    addRequirements(m_transfer);
  }




// Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_gun.setRaw(1);

    Timer.delay(2);

    m_conveyer.setRaw(1);
m_transfer.setRaw(1);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_conveyer.setRaw(0);
    m_gun.setRaw(0);
    m_transfer.setRaw(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
