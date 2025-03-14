package jab.module;

import java.awt.event.InputEvent;

import robocode.Event;

/**
 * Movement
 * 
 * @author jab
 */
public class Movement extends Part {

	public Module bot;

	public Movement(Module bot) {
		this.bot = bot;
	}

	public void move() {
		bot.setAhead(0.008);
	}

	public void listenInput(InputEvent e) {
	}

	public void listen(Event e) {
	}

}
