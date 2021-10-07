package uk.co.chisdealhd.JukeboxYT;

import net.mcjukebox.plugin.bukkit.api.JukeboxAPI;
import net.mcjukebox.plugin.bukkit.api.ResourceType;
import net.mcjukebox.plugin.bukkit.api.models.Media;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Youtube implements CommandExecutor
 {
   private static String url;
   private static int volume;
   private static ResourceType resourceType;
   static String prefix = ChatColor.GRAY + "[" + ChatColor.RED + "You" + ChatColor.WHITE + "Tube" + ChatColor.GRAY + "]" + ChatColor.WHITE + " ";
   
   private Player player;
   
   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
     if (sender instanceof Player) {
       Player player = (Player)sender;
 
       
       if (player.hasPermission("JukeboxYT.play")) {
         
         if (args.length == 0) {
 
           
           player.sendMessage(String.valueOf(prefix) + "Usage: /youtube <Video-ID:Video-Url> <volume> <type>");
         }
         else if (args.length == 1) {
           url = args[0];
           if (url.contains("youtube") || url.contains("http") || url.contains("https"))
           {
             
             send(url, 50, ResourceType.MUSIC, player, null);
           }
           else
           {
             String finalUrl = "http://www.youtube.com/watch?v=" + url;
             send(finalUrl, 50, ResourceType.MUSIC, player, null);
           }
         
         } else if (args.length == 2) {
           url = args[0];
           volume = Integer.parseInt(args[1]);
           
           if (url.contains("youtube") || url.contains("http") || url.contains("https")) {
             
             send(url, volume, ResourceType.MUSIC, player, null);
           } else {
             
             String finalUrl = "http://www.youtube.com/watch?v=" + url;
             send(finalUrl, volume, ResourceType.MUSIC, player, null);
           }
         
         } else if (args.length == 3) {
           url = args[0];
           volume = Integer.parseInt(args[1]);
           
           if (args[2].equalsIgnoreCase("music") || args[2].equalsIgnoreCase("play")) {
             
             resourceType = ResourceType.MUSIC;
           }
           else if (args[2].equalsIgnoreCase("sound") || args[2].equalsIgnoreCase("soundeffect")) {
             
             resourceType = ResourceType.SOUND_EFFECT;
           } 
 
 
           
           if (url.contains("http") || (url.contains("https") && url.contains("youtube")) || url.contains("youtu.be"))
           {
             send(url, volume, resourceType, player, null);
           
           }
           else
           {
             String finalUrl = "http://www.youtube.com/watch?v=" + url;
             send(finalUrl, volume, resourceType, player, null);
           }
         
         }
         else if (args.length == 4) {
           url = args[0];
           volume = Integer.parseInt(args[1]);
           
           if (args[2].equalsIgnoreCase("music") || args[2].equalsIgnoreCase("play")) {
             
             resourceType = ResourceType.MUSIC;
           }
           else if (args[2].equalsIgnoreCase("sound") || args[2].equalsIgnoreCase("soundeffect")) {
             
             resourceType = ResourceType.SOUND_EFFECT;
           } 
 
           
           if (url.contains("http") || (url.contains("https") && url.contains("youtube")) || url.contains("youtu.be"))
           {
             send(url, volume, resourceType, player, null);
           }
           else
           {
             String finalUrl = "http://www.youtube.com/watch?v=" + url;
             send(finalUrl, volume, resourceType, player, null);
           }
         
         } 
       } else {
         
         player.sendMessage(String.valueOf(prefix) + "You need don't have the required permission!");
       
       }
 
     
     }
     else if (args.length == 4) {
       url = args[0];
       volume = Integer.parseInt(args[1]);
       
       if (args[2].equalsIgnoreCase("music") || args[2].equalsIgnoreCase("play")) {
         
         resourceType = ResourceType.MUSIC;
       }
       else if (args[2].equalsIgnoreCase("sound") || args[2].equalsIgnoreCase("soundeffect")) {
         
         resourceType = ResourceType.SOUND_EFFECT;
       } 
 
       
       if (url.contains("http") || (url.contains("https") && url.contains("youtube")) || url.contains("youtu.be")) {
         
         send(url, volume, resourceType, this.player, null);
       }
       else {
         
         String finalUrl = "http://www.youtube.com/watch?v=" + url;
         send(finalUrl, volume, resourceType, this.player, null);
       } 
     } else {
       
       System.out.println("Command must have 4 parameters from console.");
     } 
 
 
     
     return false;
   }
 
 
 
 
 
   
   public static void send(String link, int vol, ResourceType type, Player player, String Listener) {
     String url = " https://ytdl1111.herokuapp.com/convert-1231b318921eb1298e21.php?query=" + link;
     Media song = new Media(type, url);
     System.out.println("Media URL sent: " + url);
     song.setVolume(vol);
 
     
     if (Listener != null) {
 
       
       Player user = Bukkit.getPlayer(Listener);
       JukeboxAPI.play(user, song);
     
     }
     else {
       
       for (Player players : Bukkit.getOnlinePlayers()) {
         JukeboxAPI.play(players, song);
       }
     } 
     
     if (player != null)
       player.sendMessage(String.valueOf(prefix) + "Sent the URL. It might take a few seconds before playing."); 
   }

}
