package de.harrisblog.entityremover;

import de.harrisblog.entityremover.commands.MainCommand;
import de.harrisblog.entityremover.controllers.EntityListController;
import de.harrisblog.entityremover.events.EntitySpawnEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class EntityRemover extends JavaPlugin {

    private static Plugin plugin;
    private static EntityListController entityListController;

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        plugin = this;
        entityListController = new EntityListController();
        getCommand("entityremover").setExecutor(new MainCommand());
        Bukkit.getServer().getPluginManager().registerEvents(new EntitySpawnEvent(), this);
        Bukkit.getScheduler().runTaskLater(this, EntityRemover::removeAllEntities, 20L);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public static Plugin getPlugin() {
        return plugin;
    }

    public static EntityListController getEntityListController() {
        return entityListController;
    }

    public static void removeAllEntities(){
        for(EntityType entityType : entityListController.getEntityList().values()){
            String s = entityType.name().toLowerCase();
            String command = "kill @e[type=" + s + "]";
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), command);

        }
    }



}
