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
		// Limit our speed
		bot.setMaxVelocity(6);

		// Continue in the current move direction
		bot.setAhead(moveDirection * 20);

		// Track distance traveled
		distanceTraveled += Math.abs((int) bot.getVelocity());

		// If we've gone far enough, change direction
		if (distanceTraveled >= zigzagDistance) {
			turnDirection *= -1;
			bot.setTurnRight(45 * turnDirection);
			distanceTraveled = 0;
		}
	}

	public void listenInput(InputEvent e) {
	}

	public void listen(Event e) {
		if (e instanceof robocode.HitWallEvent) {
			// Reverse direction and turn away from wall
			moveDirection *= -1;
			turnDirection *= -1;
			bot.setTurnRight(90 * turnDirection);
			distanceTraveled = 0;
		}
	}

	int moveDirection = 1;
	int turnDirection = 1;
	int zigzagDistance = 2;
	int distanceTraveled = 0;

}
