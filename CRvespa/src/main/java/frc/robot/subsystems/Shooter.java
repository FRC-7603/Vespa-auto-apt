package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.FuelConstants;

public class Shooter extends SubsystemBase {

    // Singleton
    private static Shooter singleInst;
    public static Shooter getInst() {
        if (singleInst == null) singleInst = new Shooter();
        return singleInst;
    }

    // Motor
    private final SparkMax fuelMotor;

    // Speeds
    private final double fuelInSpeed = 0.4;
    private final double fuelOutSpeed = -0.4;

    private Shooter() {
        fuelMotor = new SparkMax(FuelConstants.INTAKE_LAUNCHER_MOTOR_ID, MotorType.kBrushed);
    }

    public void fuelIn() {
        fuelMotor.set(fuelInSpeed);
    }

    public void fuelOut() {
        fuelMotor.set(fuelOutSpeed);
    }

    public void stop() {
        fuelMotor.set(0);
    }

    @Override
    public void periodic() {
        // runs every 20ms
    }

    public Command fuelInCommand() {
        return run(() -> {
            System.out.println("Fuel In");
            fuelIn();
        });
    }

    public Command fuelOutCommand() {
        return run(this::fuelOut);
    }

    public Command fuelStopCommand() {
        return run(this::stop);
    }
}