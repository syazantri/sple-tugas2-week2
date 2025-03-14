package jab.module;

/**
 * Select enemy
 * 
 * @author jabier.martinez
 */
public class SelectEnemy extends Part {

	public Module bot;

	public SelectEnemy(Module bot) {
		this.bot = bot;
	}

	public void select() {
		if (bot.botsInfo.isEmpty()) {
			bot.enemy = null;
			return;
		}

		Object[] enemies = bot.botsInfo.values().toArray();

		int randomIndex = random.nextInt(enemies.length);
		bot.enemy = (BotInfo) enemies[randomIndex];
	}

	java.util.Random random = new java.util.Random();

}
