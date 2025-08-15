package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ExampleSubsystem;

public class RobotContainer {
      private final CommandXboxController joystick = new CommandXboxController(Constants.CONTROLLER_PORT);

      private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

    public RobotContainer() {
        joystick.a().whileTrue(m_exampleSubsystem.startMotorCommand());
        m_exampleSubsystem.setDefaultCommand(m_exampleSubsystem.stopMotorCommand());
    }


}
