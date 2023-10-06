package de.harrisblog.entityremover.events;

import de.harrisblog.entityremover.EntityRemover;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EntitySpawnEvent implements Listener {

    @EventHandler
    public void onEntitySpawn(org.bukkit.event.entity.EntitySpawnEvent e){
        EntityType entityType = e.getEntityType();
        if(EntityRemover.getEntityListController().getEntityList().containsValue(entityType)) {
            e.setCancelled(true);
        }
    }

}
