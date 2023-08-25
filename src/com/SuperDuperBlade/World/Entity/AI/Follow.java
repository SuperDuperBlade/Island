package com.SuperDuperBlade.World.Entity.AI;

import com.SuperDuperBlade.Utils.Position;
import com.SuperDuperBlade.Utils.Util;
import com.SuperDuperBlade.World.Entity.Entity;

public class Follow extends AI{

    private Entity entityToFollow;

    public Follow(Entity inheritedEntity , Entity entityToFollow) {
        super(inheritedEntity);

        if (inheritedEntity == entityToFollow){
            throw new RuntimeException("AI cannot select it's self");
        }

        this.entityToFollow = entityToFollow;
    }


    @Override
    public void update(double deltaTime) {


        Position selectedEntityPos = selectedEntity.getPosition();
        Position entityToFollowPos = entityToFollow.getPosition();
        double motion = Util.calculateSpeedDif(deltaTime,selectedEntity.getMovementSpeed());

        if (selectedEntityPos.getPosX() > entityToFollowPos.getPosX()){
            selectedEntity.getPosition().addToPosX(-motion);
        }else if (selectedEntityPos.getPosX() < entityToFollowPos.getPosX()){
            selectedEntity.getPosition().addToPosX(motion);
        }

        if (selectedEntityPos.getPosY() > entityToFollowPos.getPosY()){
            selectedEntity.getPosition().addToPosY(-motion);
        }else if (selectedEntityPos.getPosY() < entityToFollowPos.getPosY()){
            selectedEntity.getPosition().addToPosY(motion);
        }


    }
}
