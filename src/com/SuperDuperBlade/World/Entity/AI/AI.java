package com.SuperDuperBlade.World.Entity.AI;

import com.SuperDuperBlade.World.Entity.Entity;

public abstract class AI {

    public Entity selectedEntity;




    public AI(Entity inheritedEntity){
        this.selectedEntity = inheritedEntity;
    }


    public abstract void update(double deltaTime);
}
