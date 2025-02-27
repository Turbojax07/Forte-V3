// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import frc.robot.Drivetrain.Commands.*;
import frc.robot.Drivetrain.Drivetrain;
import frc.robot.Climb.Commands.*;
import frc.robot.Climb.Climb;
import frc.robot.Intake.Commands.*;
import frc.robot.Intake.Intake;
import frc.robot.Shooter.Commands.*;
import frc.robot.Vision.Vision;
import frc.robot.Shooter.Shooter;

public class RobotContainer {
    // Initializing the subsystems
    Drivetrain drivetrain = Drivetrain.getInstance();
    Shooter shooter = Shooter.getInstance();
    Intake intake = Intake.getInstance();
    Climb climb = Climb.getInstance();
    Vision vision = Vision.getInstance();

    // Creating the controllers
    CommandXboxController joystick = new CommandXboxController(0);

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {
        /*  All operator controls. -- See Controls.png for visual reference.
            A: Runs the feed forward
            B: Runs the intake forward
            X: Runs the launcher in reverse
            Y: Toggles running the launcher
            Left Bumper: Moves the shooter up.
            Left Trigger: Moves the shooter down.
            Right Bumper: Moves the tower up.
            Right Trigger: Moves the tower down.
            Back: Runs the intake in reverse.
            D-Pad Up: Stows the intake.
            D-Pad Down: Extends the intake.
            Left Joystick: Move up/down/left/right
            Right Joystick: Turn left/right
        */
        joystick.a().whileTrue(new SetFeedSpeed(1));
        joystick.b().whileTrue(new SetIntakeSpeed(1));
        joystick.x().whileTrue(new SetLauncherSpeed(-1));
        joystick.y().toggleOnTrue(new SetLauncherSpeed(1));
        joystick.leftBumper().whileTrue(new SetShooterAngle(Shooter.Positions.UP));
        joystick.leftTrigger().whileTrue(new SetShooterAngle(Shooter.Positions.DOWN));
        joystick.rightBumper().whileTrue(new SetClimbSpeed(1));
        joystick.rightTrigger().whileTrue(new SetClimbSpeed(-0.5));
        joystick.back().whileTrue(new SetIntakeSpeed(-0.5));
        joystick.povUp().whileTrue(new SetIntakeAngle(Intake.States.UP));
        joystick.povDown().whileTrue(new SetIntakeAngle(Intake.States.DOWN));
        joystick.povLeft().onTrue(new PlayMusic("jingle_bells.chrp"));
        joystick.povRight().whileTrue(new ResetGyro());
    }

    public Command getAutonomousCommand() {
        return new PrintCommand("No auto lol");
    }

    public Command getTeleopCommand() {
        return new SwerveDrive(() -> joystick.getLeftX(), () -> joystick.getLeftY(), () -> joystick.getRightX());
    }
}
