package sub1;

import org.springframework.beans.factory.annotation.Autowired;

public class LgTV {
	@Autowired
	private Speaker spk;

	public void powerOn() {
		System.out.println("LgTV powerOn...");
	}

	public void powerOff() {
		System.out.println("LgTV powerOff...");
	}

	public void soundUp() {
		spk.soundUp();
	}

	public void soundDown() {
		spk.sounDown();
	}
}