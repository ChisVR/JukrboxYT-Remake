package uk.co.chisdealhd.JukeboxYT;

 import net.mcjukebox.plugin.bukkit.api.JukeboxAPI;
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandExecutor;
 import org.bukkit.command.CommandSender;
 import org.bukkit.entity.Player;
 
 public class CMD_Silence implements CommandExecutor {
   public static String prefix = CMD_Youtube.prefix;
   private Player player;
   
   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
     if (sender instanceof Player) {
       Player player = (Player)sender;
       
       if (args.length == 0) {
         if (player.hasPermission("JukeboxYT.silence.self"))
         {
           JukeboxAPI.stopMusic(player);
         }
       }
       else if (args.length == 1) {
         
         if (player.hasPermission("JukeboxYT.silence.others"))
         {
           Player targetPlayer = player.getServer().getPlayer(args[0]);
           
           JukeboxAPI.stopMusic(targetPlayer);
         }
         else
         {
           player.sendMessage(String.valueOf(prefix) + "You don't have permission to use this!");
         }
       
       } 
     } else {
       
       Player targetPlayer = this.player.getServer().getPlayer(args[0]);
       JukeboxAPI.stopMusic(targetPlayer);
     } 
     
     return false;
   }
 }
