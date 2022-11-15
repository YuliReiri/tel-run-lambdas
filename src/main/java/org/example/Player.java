package org.example;

public class Player implements Comparable<Player> {
    
    public Integer xPos;
    public Integer yPos;
    public Boolean isActive;
    public String playerName;
    public Integer rank = 0;
 

    public Player( String name,  Boolean isActive, Integer xPos, Integer yPos ) {
        
        this.playerName = name;
        this.isActive = isActive;

        this.xPos = xPos;
        this.yPos = yPos;
    }
    public boolean equals( Player obj ) {
        return playerName.equals(obj.playerName );
    }
    // comparing by "nature" order. In our case, it's just only the state of the player
    public int compareTo( Player obj ) {
        if ( isActive == true && obj.isActive == false )
            return 1;
        if ( isActive == false && obj.isActive == true )
            return -1;
        return 0;
    }



}