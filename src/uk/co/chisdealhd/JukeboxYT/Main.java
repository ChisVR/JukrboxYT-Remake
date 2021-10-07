package uk.co.chisdealhd.JukeboxYT;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public final Logger logger = Logger.getLogger("Minecraft");
	
	public void onEnable() {
		this.logger.info("Youtube for MCJukebox has Been Enabled!");
		
		getCommand("youtube").setExecutor(new CMD_Youtube());
	    getCommand("yt").setExecutor(new CMD_Youtube());
		getCommand("silence").setExecutor(new CMD_Silence());
	}

	public void onDisable() {
		this.logger.info("Youtube for MCJukebox has Been Disabled!");
	}
}
