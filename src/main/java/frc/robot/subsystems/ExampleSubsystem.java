// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ExampleSubsystem extends SubsystemBase {
  private final TalonFX m_motor = new TalonFX(Constants.MOTOR_ID);
  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {}

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }


  public void setVoltage(double value) {
      // value = MathUtil.clamp(value, -, 8);
      m_motor.setControl(new VoltageOut(value));
      SmartDashboard.putBoolean("motor/is-running", true);
  }
  public void motorOff() {
      m_motor.stopMotor();
      SmartDashboard.putBoolean("motor/is-running", false);
  }

  public Command startMotorCommand() {
    return new RunCommand(
      () -> setVoltage(Constants.MOTOR_VOLTAGE), 
      this
    ).withName("setMotorVoltage");
  }

  public Command stopMotorCommand() {
    return new InstantCommand(
      () -> motorOff(),
      this
    ).withName("stopMotor");
  }
}
