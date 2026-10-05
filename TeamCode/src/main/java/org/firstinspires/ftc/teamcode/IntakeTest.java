package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Intake Test", group = "Test")
public class IntakeTest extends LinearOpMode {

    private final ElapsedTime runtime = new ElapsedTime();
    private DcMotor intakeMotor = null;

    @Override
    public void runOpMode() {

        intakeMotor = hardwareMap.get(DcMotor.class, "intake");

        telemetry.addData("Status:", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            intakeMotor.setPower(gamepad1.left_trigger);

            telemetry.addData("Status:", "Run Time: " + runtime.toString());
            telemetry.addData("Intake Power:", "%4.2f", intakeMotor.getPower());
            telemetry.update();
        }
    }
}
