package com.nbastats;

/**
 * Created by kevin_maussion on 12/04/2016.
 */
public class DBStats {
    private long id;
    private int trois_Points;
    private int deux_Points;
    private int dunks;
    private int fautes;

    public DBStats(long id, int trois_Points, int deux_Points, int dunks, int fautes){
        super();
        this.id = id;
        this.trois_Points = trois_Points;
        this.deux_Points = deux_Points;
        this.dunks = dunks;
        this.fautes = fautes;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public int getTrois_Points() {
        return this.trois_Points;
    }

    public void setTrois_Points( int trois_Points){
        this.trois_Points = trois_Points;
    }

    public int getDeux_Points(){
        return this.deux_Points;
    }

    public void setDeux_Points(int deux_Points){
        this.deux_Points = deux_Points;
    }

    public int getDunks(){
        return this.dunks;
    }

    public void setDunks(int dunks) {
        this.dunks = dunks;
    }

    public int getFautes(){
        return this.fautes;
    }

    public void setFautes(int fautes){
        this.fautes = fautes;
    }

}
