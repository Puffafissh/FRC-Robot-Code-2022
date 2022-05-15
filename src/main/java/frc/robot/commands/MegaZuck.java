// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Conveyer;
import frc.robot.subsystems.Gun;
import frc.robot.subsystems.Transfer;

/** An example command that uses an example subsystem. */
public class MegaZuck extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Intake m_intake;
  private final Conveyer m_conveyer;
  private final Gun m_gun;
  private final Transfer m_transfer;


  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public MegaZuck(Intake intake, Gun gun, Transfer transfer, Conveyer conveyer) {
    m_intake = intake;
    m_conveyer = conveyer;
    m_gun = gun;
    m_transfer = transfer;
    

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_intake);
    addRequirements(m_transfer);
    addRequirements(m_gun);
    addRequirements(m_conveyer);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

m_intake.setRaw(-1);
m_transfer.setRaw(1);
m_gun.setRaw(-1,1);
m_conveyer.setRaw(-1);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intake.setRaw(0);
    m_transfer.setRaw(0);
    m_gun.setRaw(0,0);
    m_conveyer.setRaw(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
