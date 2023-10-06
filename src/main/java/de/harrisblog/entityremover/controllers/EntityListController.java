package de.harrisblog.entityremover.controllers;

import de.harrisblog.entityremover.EntityRemover;
import org.bukkit.entity.EntityType;

import java.util.HashMap;

public class EntityListController {

    HashMap<String, EntityType> entityList;

    public EntityListController(){
        entityList = new HashMap<>();
        loadEntities();
    }

    public void loadEntities(){
        for(String entityString : EntityRemover.getPlugin().getConfig().getStringList(".entities")){
            EntityType entityType = EntityType.fromName(entityString);
            entityList.put(entityString, entityType);
        }
    }

    public EntityType getEntityTypeFromEntityString(String s){
        return entityList.get(s);
    }

    public HashMap<String, EntityType> getEntityList(){
        return entityList;
    }


}
