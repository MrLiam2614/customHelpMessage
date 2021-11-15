package me.mrliam2614.command;

import me.mrliam2614.CustomHelpMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class commandHandler implements CommandExecutor {
    private final CustomHelpMessage plugin;

    public commandHandler(CustomHelpMessage plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        List<String> helpMessage = new ArrayList<>();
        List<String> getMsg = new ArrayList<>();
        helpMessage.add(plugin.getConfig().getString("helpMessage.header"));

        ConfigurationSection configurationSection = plugin.getConfig().getConfigurationSection("helpMessage.list");
        Set<String> listIndex = configurationSection.getKeys(false);


        for (String set : listIndex) {
            if (sender.hasPermission(plugin.getConfig().getString("helpMessage.list." + set + ".permission"))) {
                getMsg = plugin.getConfig().getStringList("helpMessage.list." + set + ".messages");
                for (String message : getMsg) {
                    helpMessage.add(plugin.getFacilitisAPI().strUtils.colored(message));
                }
            }
        }

        helpMessage.add(plugin.getConfig().getString("helpMessage.footer"));
        for (String helpMsg : helpMessage) {
            sender.sendMessage(plugin.getFacilitisAPI().strUtils.colored(helpMsg));
        }
        return false;
    }
}
