package com.team766.robot.mechanisms;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import java.util.ArrayList;
import com.revrobotics.ColorMatch;
import com.team766.framework.Mechanism;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;

public class ColorSensor {
	
	// this is the port for the sensor
	private final I2C.Port i2cPort = I2C.Port.kOnboard;

	// this is the actual sensor ( i think i dont actaully know)
	// i stole all of this code
	private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

	// from what i understand - color match is a 
	private final ColorMatch m_colorMatcher = new ColorMatch();

	// what define what these colors actually are
	public Color blueTargetColor = new Color(0.143, 0.427, 0.429);
	public Color greenTargetColor = new Color(0.197, 0.561, 0.240);
	public Color redTargetColor = new Color(0.561, 0.232, 0.114);
	public Color yellowTargetColor = new Color(0.361, 0.524, 0.113);
	public ArrayList<Color> colorList = new ArrayList<>(4);

	public ColorSensor() {
		colorList.add(redTargetColor);
		colorList.add(yellowTargetColor);
		colorList.add(greenTargetColor);
		colorList.add(blueTargetColor);
	}
	// make sure the computers can recognize these colors
	public void robotInit() {
		m_colorMatcher.addColorMatch(colorList.get(0));
		m_colorMatcher.addColorMatch(colorList.get(1));
		m_colorMatcher.addColorMatch(colorList.get(2));
		m_colorMatcher.addColorMatch(colorList.get(3));
	}

	public String nameOfColor() {
		// gets the normalized data of the color (ex: 0.1, 0.4, 0.5)
		Color detectedColor = m_colorSensor.getColor();

		// chooses what color (of the previously defined ones) the sensor sees
		ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
		if (colorList.contains(detectedColor)) {
			if (match.color == colorList.get(0)) {
				return "red";
			} else if (match.color == colorList.get(1)) {
				return "yellow";
			} else if (match.color == colorList.get(2)) {
				return "green";
			} else if (match.color == colorList.get(3)) {
				return "blue";
			} 
		}		
		return "uh oh, code broken :( -- no color :(";
	}
}
