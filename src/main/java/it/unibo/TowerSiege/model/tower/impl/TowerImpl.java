package it.unibo.TowerSiege.model.tower.impl;

import it.unibo.TowerSiege.model.enemy.api.Enemy;
import it.unibo.TowerSiege.model.tower.TowerType;
import it.unibo.TowerSiege.model.tower.api.Tower;
import it.unibo.TowerSiege.model.projectile.api.Projectile;
import it.unibo.TowerSIege.model.progecyile.impl.ProjectileImpl;




public class TowerImpl implements Tower{
    
    private final TowerType type;
    private double pixelX;
    private double pixelY;
    private int level;
    private boolean alive;
    private int cooldownTicks; 


    public TowerImpl(TowerType type) {  
        this.type=type;
        this.level=1;  
        this.alive=true;
        this.cooldownTicks=0; 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPosition(double x, double y){
        this.pixelX=x;
        this.pixelY=y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void tick(){  
        if(cooldownTicks > 0){
            cooldownTicks--;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEnemyInRange(Enemy enemy){
        double dx= enemy.getPixelX()-pixelX;
        double dy= enemy.getPixelY() - pixelY;
        double distSq= dx*dx + dy*dy;
        double rangePx= type.getRange() * 40;
        return distSq <= (rangePx * rangePx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void upgrade(){
        this.level++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TowerType getType(){
        return type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getPixelX(){
        return pixelX;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public double getPixelY(){
        return pixelY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getLevel(){
        return level;
    }
ù/**
     * {@inheritDoc}
     */
    @Override
    public boolean isAlive(){
        return alive;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRange(){
        return type.getRange();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
     public int getDamage(){
        return type.getDamage() + (level -1)*2;
     }
    




}
