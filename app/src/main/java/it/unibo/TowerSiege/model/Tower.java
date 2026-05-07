package it.unibo.TowerSiege.model;

public class Tower {
    
    private final TowerType type;
    private double pixelX;
    private double pixelY;
    private int level;
    private boolean alive;
    private int cooldownTicks; 

    public Tower(TowerType type) {  //constructor
        this.type=type;
        this.level=1;  //set the tower's level initially to 1
        this.alive=true;
        this.cooldownTicks=0; //cooldawnTick=0 means that the tower has the ability
    }

    public void setPosition(double x, double y){
        this.pixelX=x;
        this.pixelY=y;
    }

    public void tick(){  //decrease the countdown to get the ability
        if(cooldownTicks > 0){
            cooldownTicks--;
        }
    }

    




}
