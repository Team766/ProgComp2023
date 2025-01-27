package com.team766.simulator.elements;

import com.team766.simulator.interfaces.PneumaticDevice;

public class AirReservoir implements PneumaticDevice {

	private double volume;

	public AirReservoir(final double volume_) {
		this.volume = volume_;
	}

	@Override
	public PneumaticDevice.Output step(final PneumaticDevice.Input input) {
		return new PneumaticDevice.Output(0, volume);
	}
}
