
# Color Sensor Tutorial

## Prerequisites 
After creating a `ColorSensor.java` file in the mechanisms folder, copy and paste the following code into the file:

`import com.revrobotics.ColorSensorV3;`\
`import com.revrobotics.ColorMatchResult;`\
`import com.revrobotics.ColorMatch;`\
`import com.team766.framework.Mechanism;`\
`import edu.wpi.first.wpilibj.I2C;`\
`import edu.wpi.first.wpilibj.util.Color`;

## Classes
You will need to use the following classes in your `ColorSensor` code:

Color

ColorMatch\
Important Methods:

* `addColorMatch(Color color)`\
	You will need to use this method to add any color you want your code to recognize

* `matchClosestColor(Color color)`\
	Returns the closest match to the inputted color out of the possible matches created using `addColorMatch(Color color)`