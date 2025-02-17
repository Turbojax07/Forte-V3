// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import frc.robot.Constants.BuildConstants;
import org.littletonrobotics.junction.LoggedRobot;
import org.littletonrobotics.junction.Logger;
import org.littletonrobotics.junction.networktables.NT4Publisher;
import org.littletonrobotics.junction.wpilog.WPILOGReader;
import org.littletonrobotics.junction.wpilog.WPILOGWriter;

public class Robot extends LoggedRobot {
    private Command autoCommand;
    private Command teleopCommand;

    @Override
    public void robotInit() {
        // I like NetworkTables and will never not use it!
        Logger.addDataReceiver(new NT4Publisher());

        // Adding metadata to the project
        Logger.recordMetadata("Project Name", BuildConstants.projectName);
        Logger.recordMetadata("Git Branch", BuildConstants.gitBranch);
        Logger.recordMetadata("Project URL", BuildConstants.projectUrl);

        if (isReal()) {
            Logger.addDataReceiver(new WPILOGWriter("/U/logs/"));
        }

        // Creating the RobotContainer
        RobotContainer robotContainer = new RobotContainer(isReal());

        // Getting the auto and telop commands from RobotContainer.
        autoCommand = robotContainer.getAutonomousCommand();
        teleopCommand = robotContainer.getTeleopCommand();

        // Assigning default values to the commands in case they are null.
        if (autoCommand == null) autoCommand = new PrintCommand("No auto lol");
        if (teleopCommand == null) teleopCommand = new PrintCommand("No teleop lol");
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void simulationInit() {
        Logger.addDataReceiver(new WPILOGWriter("sim-log.wpilog"));

        if (Constants.isReplay) {
            Logger.setReplaySource(new WPILOGReader("replay.wpilog"));
        }
    }

    @Override
    public void disabledInit() {}

    @Override
    public void disabledPeriodic() {}

    @Override
    public void disabledExit() {}

    @Override
    public void autonomousInit() {
        autoCommand.schedule();
    }

    @Override
    public void autonomousPeriodic() {}

    @Override
    public void autonomousExit() {
        autoCommand.cancel();
    }

    @Override
    public void teleopInit() {
        teleopCommand.schedule();
    }

    @Override
    public void teleopPeriodic() {}

    @Override
    public void teleopExit() {
        teleopCommand.cancel();
    }

    @Override
    public void testInit() {
        CommandScheduler.getInstance().cancelAll();
    }

    @Override
    public void testPeriodic() {}

    @Override
    public void testExit() {}
}