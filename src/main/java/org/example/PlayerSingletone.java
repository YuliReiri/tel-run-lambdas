package org.example;

import java.util.*;

public class PlayerSingletone {


    static PlayerSingletone st =null; 
    List< Player > allPlayers = new ArrayList<Player>(); 

    // create single instance of this class
    static public PlayerSingletone getInstance() {
        if (st == null )
            st = new PlayerSingletone();
        return st;
    }
    private PlayerSingletone() {

    }

    // delete players from the pool 
    boolean deletePlayers( String name ) {
    
        List<Player> toDelete = new ArrayList<Player>();
        allPlayers.forEach( p -> {
            if (p.playerName.equals(name))
                toDelete.add(p);
        });
      allPlayers.removeAll(toDelete);
      return toDelete.size() > 0;  
    }

    // creates player and store in players' pool 
    Player cteatePlayer( String name, Boolean isActive, Integer xPos, Integer yPos ) { 

        Player p1 = new Player( name, isActive, xPos, yPos );
        allPlayers.add(p1);
        return  p1;
    }
    // Increase player rank by 3
    void incPlayerRank( PlayerSumator<Integer> s, Player p  ) {
        s.sum(p, 3);
    }
    // sort players in natural order defined in Player class
    List<Player> sort() {
        List<Player> res = new ArrayList<Player>( allPlayers ) ;
        Collections.sort( res );
        return res;
    }
    // sort players with Comparator
    List<Player> sort(Comparator<Player> order ) {
        List<Player> res = new ArrayList<Player>( allPlayers ) ;
        Collections.sort( res, order );
        return res;
    }
}
