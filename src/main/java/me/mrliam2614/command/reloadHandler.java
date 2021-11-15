package me.mrliam2614.command;

import me.mrliam2614.CustomHelpMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class reloadHandler implements CommandExecutor {
    private final CustomHelpMessage plugin;

    public reloadHandler(CustomHelpMessage plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("helpmsg.reload")){
            plugin.reloadConfig();
            sender.sendMessage(plugin.getFacilitisAPI().strUtils.colored("&aHelp message reloaded"));
        }
        return false;
    }
}
