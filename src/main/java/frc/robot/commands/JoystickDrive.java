// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;


/** An example command that uses an example subsystem. */
public class JoystickDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivebase m_Drivebase;
  private Joystick driverController;
  
 
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public JoystickDrive(Drivebase drivebase, Joystick joystick) {

    m_Drivebase = drivebase;
    driverController = joystick;
  

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivebase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double y = driverController.getY()*-0.5;
    double x = driverController.getX()*0.5;
    double throttle = driverController.getRawAxis(3)*-0.5+0.5;
    boolean top = driverController.getTop();


if(top==true) {
		m_Drivebase.setRaw(-1*(y*throttle+x*throttle),-1*(y*throttle-x*throttle));
	}
	else{
		m_Drivebase.setRaw((y*throttle+x*throttle),(y*throttle-x*throttle));

  }
        }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
