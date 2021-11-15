package me.mrliam2614;

import me.mrliam2614.command.commandHandler;
import me.mrliam2614.command.reloadHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomHelpMessage extends JavaPlugin {
    private FacilitisAPI facilitisAPI;

    @Override
    public void onEnable() {
        facilitisAPI = FacilitisAPI.getInstance();
        facilitisAPI.messages.EnableMessage(this);
        saveDefaultConfig();
        commandRegister();
    }

    @Override
    public void onDisable() {
        facilitisAPI.messages.DisableMessage(this);
    }

    private void commandRegister() {
        getCommand("help").setExecutor(new commandHandler(this));
        getCommand("helpreload").setExecutor(new reloadHandler(this));
    }

    public FacilitisAPI getFacilitisAPI() {
        return facilitisAPI;
    }
}
