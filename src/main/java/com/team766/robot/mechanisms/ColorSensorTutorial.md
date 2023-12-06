
# Color Sensor Tutorial

## Prerequisites 
After creating a `ColorSensor.java` file in the mechanisms folder, copy and paste the following code into the file:

`import com.revrobotics.ColorSensorV3;`\
`import com.revrobotics.ColorMatchResult;`\
`import com.revrobotics.ColorMatch;`\
`import com.team766.framework.Mechanism;`\
`import edu.wpi.first.wpilibj.I2C;`\
`import edu.wpi.first.wpilibj.util.Color`;

## Helpful Links
- [Documentation](https://codedocs.revrobotics.com/java/com/revrobotics/package-summary.html)
- [Example Code](https://github.com/REVrobotics/Color-Sensor-v3-Examples/tree/master/Java) (Your code won't look exactly like this!)


## Classes
You will need to use the following classes in your `ColorSensor` code:

- [Color](https://github.wpilib.org/allwpilib/docs/release/java/edu/wpi/first/wpilibj/util/Color.html)

- [ColorMatch](https://codedocs.revrobotics.com/java/com/revrobotics/colormatch)\
	Important Methods:

	* `addColorMatch(Color color)`\
	You will need to use this method to add any color you want your code to recognize

	* `matchClosestColor(Color color)`\
	Returns the closest match to the inputted color out of the possible matches created using `addColorMatch(Color color)`.

- [ColorSensorV3](https://codedocs.revrobotics.com/java/com/revrobotics/colorsensorv3) - Represents the sensor itself