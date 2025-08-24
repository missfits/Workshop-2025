package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ExampleSubsystem;

public class RobotContainer {
    private final ExampleSubsystem robotMotor = new ExampleSubsystem();
    private final CommandXboxController joystick = new CommandXboxController(Constants.JOYSTICK_PORT);
    public RobotContainer() {
        joystick.a().whileTrue(robotMotor.runMotorCommand());
        robotMotor.setDefaultCommand(robotMotor.stopMotorCommand());

    }
}
