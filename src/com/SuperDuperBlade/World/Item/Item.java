package com.SuperDuperBlade.World.Item;

public class Item {
    public String name;
    public int damage;
    public int strength;
    public int range;
    public int staminaDuration;

    public Item(String name, int damage, int strength,int range,int staminaDuration) {
        this.name = name;
        this.damage = damage;
        this.strength = strength;
        this.range = range;
        this.staminaDuration = staminaDuration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getStaminaDuration() {
        return staminaDuration;
    }

    public void setStaminaDuration(int staminaDuration) {
        this.staminaDuration = staminaDuration;
    }
}
