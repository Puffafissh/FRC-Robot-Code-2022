// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

import frc.robot.commands.Auto;
import frc.robot.commands.HighFire;
import frc.robot.commands.JoystickDrive;
import frc.robot.commands.LowFire;
import frc.robot.commands.MedFire;
import frc.robot.commands.Suck;
import frc.robot.commands.Zuck;
import frc.robot.commands.MegaZuck;
import frc.robot.commands.ClimbExtend;
import frc.robot.commands.DeployIntake;

import frc.robot.subsystems.Conveyer;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Gun;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Transfer;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.IntakeDeploy;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Intake m_Intake = new Intake();
  private final IntakeDeploy m_IntakeDeploy = new IntakeDeploy();
  private final Conveyer m_Conveyer = new Conveyer();
  private final Gun m_Gun = new Gun();
  private final Drivebase m_Drivebase = new Drivebase();
  private final Transfer m_Transfer = new Transfer();
  private final Climber m_Climber = new Climber();
  
 private final Auto m_autoCommand = new Auto(m_Drivebase);
 
/* Shooter */
 private final HighFire m_highFire = new HighFire(m_Conveyer, m_Transfer, m_Gun);
 private final MedFire m_medFire = new MedFire(m_Conveyer, m_Transfer, m_Gun);
 private final LowFire m_lowFire = new LowFire(m_Conveyer, m_Transfer, m_Gun);
 private final Suck m_suck = new Suck(m_Intake, m_Conveyer, m_Transfer);

 /*Climb*/
 private final ClimbExtend m_Climb = new ClimbExtend(m_Climber);

 /*Drive*/
 private final XboxController xboxController = new XboxController(Constants.XBOXCONTROLLER);
 private final Joystick driverController = new Joystick(Constants.DRIVER_CONTROLLER);

public double GetDriverRawAxis(int axis){
   return driverController.getRawAxis(axis);
 }

 //private final JoystickDrive DRIVE = new JoystickDrive(m_Drivebase, DRIVE);

  // Low Fire 
JoystickButton GAButton = new JoystickButton(xboxController, Constants.LOW_FIRE_VALUE);
  /* Medium Fire */
JoystickButton GBButton = new JoystickButton(xboxController, Constants.MEDIUM_FIRE_VALUE);
  /* High Fire */
JoystickButton GYButton = new JoystickButton(xboxController, Constants.HIGH_FIRE_VALUE);
  /* Suck */
JoystickButton GLeftBumper = new JoystickButton(xboxController,Constants.SUCK_VALUE);
  /* Zuck */
JoystickButton GStart = new JoystickButton(xboxController, Constants.ZUCK_VALUE);
  /* Mega Zuck */
JoystickButton Gback = new JoystickButton(xboxController, Constants.MEGA_ZUCK_VALUE);
  /* Climb Extend*/
JoystickButton GXButton = new JoystickButton(xboxController, Constants.CLIMB_EXTEND);


  /** The container for the robot. Contains subsystems, OI devices, and commands. 
   * @return */
  public RobotContainer() {
    // Configure the button bindings
   
 m_Drivebase.setDefaultCommand(new JoystickDrive(m_Drivebase, driverController));
 m_IntakeDeploy.setDefaultCommand(new DeployIntake(m_IntakeDeploy, xboxController));

configureButtonBindings();
    
  }
 
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

GLeftBumper.whileHeld(new Suck(m_Intake, m_Conveyer, m_Transfer));
GYButton.whileHeld(new HighFire (m_Conveyer, m_Transfer, m_Gun));
GBButton.whileHeld(new MedFire(m_Conveyer, m_Transfer, m_Gun));
GAButton.whileHeld(new LowFire(m_Conveyer, m_Transfer, m_Gun));
GStart.whileHeld(new Zuck(m_Intake));
Gback.whileHeld(new MegaZuck(m_Intake, m_Gun, m_Transfer, m_Conveyer));
GXButton.toggleWhenPressed(new ClimbExtend(m_Climber));


  }
  
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
