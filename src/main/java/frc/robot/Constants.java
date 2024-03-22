package frc.robot;

import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;

public class Constants {
    public static class DriveConstants {
        // Motor IDs
        public static final int flDriveID = 1;
        public static final int flTurnID  = 2;
        public static final int frDriveID = 3;
        public static final int frTurnID  = 4;
        public static final int blDriveID = 5;
        public static final int blTurnID  = 6;
        public static final int brDriveID = 7;
        public static final int brTurnID  = 8;

        // Sensor IDs
        public static final int flCancoderID = 1;
        public static final int frCancoderID = 2;
        public static final int blCancoderID = 3;
        public static final int brCancoderID = 4;
        public static final int gyroID       = 0;

        // Encoder offsets
        public static final double flOffset = 0;
        public static final double frOffset = 0;
        public static final double blOffset = 0;
        public static final double brOffset = 0;

        // Kinematics
        public static final Translation2d flTranslation = new Translation2d(-DriveConstants.width / 2,  DriveConstants.length / 2);
        public static final Translation2d frTranslation = new Translation2d( DriveConstants.width / 2,  DriveConstants.length / 2);
        public static final Translation2d blTranslation = new Translation2d(-DriveConstants.width / 2, -DriveConstants.length / 2);
        public static final Translation2d brTranslation = new Translation2d( DriveConstants.width / 2, -DriveConstants.length / 2);

        // Max Speeds
        public static final int maxDriveSpeed = 1; // Meters / Second
        public static final int maxTurnSpeed  = 1; // Radians / Second

        // Robot Measurements
        public static final double width = Units.inchesToMeters(20); // Meters
        public static final double length = Units.inchesToMeters(20); // Meters
        public static final double wheelRadius = Units.inchesToMeters(4); // Meters
        public static final double wheelCircumference = 2 * Math.PI * wheelRadius; // Meters
        public static final double driveRatio = 6.75; // Gear Ratio
        public static final double turnRatio = 150/7; // Gear Ratio

        // Drive PID Values
        public static final double driveP = 0.01;
        public static final double driveI = 0;
        public static final double driveD = 0;

        // Turn PID Values
        public static final double turnP = 0.01;
        public static final double turnI = 0;
        public static final double turnD = 0;

        // FeedForward Values
        public static final double kS = 0.00; // give the dt a minimal voltage until it moves.  That voltage value is kS.
        public static final double kV = 2.54;
        public static final double kA = 0.22;
    }

    public class ShooterConstants {
        // Motor IDs
        public static final int lShooterID = 11;
        public static final int rShooterID = 12;
        public static final int feedRollerID = 13;
        public static final int alignID = 14;

        // Robot Measurements
        public static final double gearRatio = 4.5;

        // PID Values
        public static final double kP = 0.0001;
        public static final double kI = 0;
        public static final double kD = 0;
        public static final double kFF = 0.001;

        // Max speeds
        public static final double maxShootSpeed = 1;   // Duty Cycle
        public static final double maxFeedSpeed = 1;    // Duty Cycle
        public static final double maxAlignSpeed = 0.5; // Duty Cycle
    }

    public class TowerConstants {
        // Motor IDs
        public static final int lTowerID = 21;
        public static final int rTowerID = 22;
    }

    public class VisionConstants {
        // Camera Poses
        public static final Translation3d frontCamTranslation = new Translation3d();
        public static final Translation3d backCamTranslation = new Translation3d();
        public static final Rotation3d frontCamRotation = new Rotation3d();
        public static final Rotation3d backCamRotation = new Rotation3d();
        public static final Transform3d frontCamTransform = new Transform3d(frontCamTranslation, frontCamRotation);
        public static final Transform3d backCamTransform = new Transform3d(backCamTranslation, backCamRotation);
    }
}