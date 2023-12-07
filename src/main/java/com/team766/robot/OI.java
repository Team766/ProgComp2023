package com.team766.robot;

import com.team766.framework.Procedure;
import com.team766.framework.Context;
import com.team766.hal.JoystickReader;
import com.team766.hal.RobotProvider;
import com.team766.logging.Category;
import com.team766.robot.procedures.*;
import edu.wpi.first.wpilibj.DriverStation;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the code that allow control of the robot.
 */
public class OI extends Procedure {
	private JoystickReader joystick0;
	private JoystickReader joystick1;
	private JoystickReader joystick2;

	public OI() {
		loggerCategory = Category.OPERATOR_INTERFACE;

		joystick0 = RobotProvider.instance.getJoystick(0);
		joystick1 = RobotProvider.instance.getJoystick(1);
		joystick2 = RobotProvider.instance.getJoystick(2);
	}

	public void run(final Context context) {
		context.takeOwnership(Robot.drive);
		while (true) {
			// wait for driver station data (and refresh it using the WPILib APIs)

			Robot.drive.setArcadeDrivePower(joystick0.getAxis(1), joystick1.getAxis(1));

			context.waitFor(() -> RobotProvider.instance.hasNewDriverStationData());
			RobotProvider.instance.refreshDriverStationData();

			// Add driver controls here - make sure to take/release ownership
			// of mechanisms when appropriate.

			log("J0 A0: " + joystick0.getAxis(0) +
			    "  J0 A1: " + joystick0.getAxis(1) +
			    "  J1 A0: " + joystick1.getAxis(0) +
			    "  J1 A1: " + joystick1.getAxis(1) +
			    "  J0 B1: " + joystick0.getButton(1) +
			    "  J0 B2: " + joystick0.getButton(2) +
			    "  J0 B3: " + joystick0.getButton(3));


			context.waitFor(() -> RobotProvider.instance.hasNewDriverStationData());
		}
	}
}
