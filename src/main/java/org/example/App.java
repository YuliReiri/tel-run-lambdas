package org.example;
import java.util.*;
import java.util.function.Consumer;
/**
 * Hello world!
 *
 */
public class App 
{
    
    static PlayerSingletone playersPool = PlayerSingletone.getInstance();

    public static void sumatorPlayerExample(Player p1, Player p2, Player p3) {

        // summator wich increase player rank
        PlayerSumator<Integer> increaseRankX1 = new PlayerSumator< Integer >() {
            public Player sum( Player p1, Integer rank ) {
                p1.rank = (p1.rank + rank);
                return p1;
            }
        };
        // summator wich increase player rank  multiplies it 2 
        PlayerSumator<Integer> increaseRankX2 = new PlayerSumator< Integer >() {
            public Player sum( Player p1, Integer rank ) {
                p1.rank = p1.rank + rank*2;
                return p1;
            }
        };
        // summator wich increase player rank  multiplies it 5
        PlayerSumator<Integer> increaseRankX5 = new PlayerSumator< Integer >() {
            public Player sum( Player p1, Integer rank ) {
                p1.rank = p1.rank + rank*5;
                return p1;
            }
        };
        playersPool.incPlayerRank(increaseRankX1, p3);
        playersPool.incPlayerRank(increaseRankX5, p2);
        playersPool.incPlayerRank(increaseRankX2, p1);

        System.out.println( "Player 1 rank: " + p1.rank );
        System.out.println( "Player 2 rank: " + p2.rank );
        System.out.println( "Player 3 rank: " + p3.rank );



    }

    public static void comparatorExample() {
        // this is comparator class which compares Player's objects by name 
        class CompareByNameAndState implements Comparator< Player > {
            public int compare( Player p1, Player p2 ) {
                int res = p1.compareTo(p2);
                return res == 0 ? p1.playerName.compareTo(p2.playerName) : res;
            }
        }

        // this is comparator class compares Player's objects by yPos variable
        class CompareByPosY implements Comparator< Player > {
            public int compare( Player p1, Player p2 ) {
                return p1.yPos - p2.yPos;
            }
        }
        System.out.println( "players sorted by their states: ");
        // Sorting players by "nature" ordering
        List<Player> players = playersPool.sort();
        players.forEach( new Consumer<Player>() {
            public void accept( Player p ) {
                System.out.println(
                    String.format("%s : %b ", p.playerName, p.isActive) );            }
        });

        System.out.println("\nplayers sorted by name and state:");
        players = playersPool.sort(new CompareByNameAndState());
        players.forEach( new Consumer<Player>() {
            public void accept( Player p ) {
                System.out.println(
                    String.format("%s : %b ", p.playerName, p.isActive) );
            }
        });

        System.out.println("\nplayers sorted by Y position: ");
        players = playersPool.sort(new CompareByPosY());
        players.forEach( new Consumer<Player>() {
            public void accept( Player p ) {
                System.out.println(String.format("%s : %d ", p.playerName, p.yPos));
            }
        });
    }

    public static void main( String[] args )
    {
  
        Player p1 = playersPool.cteatePlayer("Ahiva", true, 10, 10);
        Player p2 = playersPool.cteatePlayer( "Sub Zero ", false, 10, 40);
        Player p3 = playersPool.cteatePlayer( "Ninja ", true, 10, 13);
        Player p4 = playersPool.cteatePlayer( "Aldero ", false, 10, 23);
        Player p5 = playersPool.cteatePlayer( "Sonya ",true, 10, 87);

      
       // comparatorExample();
       sumatorPlayerExample(p1, p2, p3);

      /*   Player bot1 = new Player("bot1", true, 2, 2) {
            public boolean equals( Player obj ) {
                return super.equals(obj) && this.isActive == obj.isActive;
            }
        };
        players.add(bot1);*/
       
    }

    public static void sumatorExample() {
        Sumator< Integer > s = (i1, i2) -> i1 + i2;     
        Sumator< Integer > sX2 = (i1, i2) -> (i1 + i2)*2;     
        Sumator< Integer > sX5 = (i1, i2) -> (i1 + i2)*5;     

        int res1 = s.sum( 1, 1 );
        int res2 = sX2.sum(2, 2);
        int res3 = sX5.sum(2, 2);
        
        System.out.println( "result for summator 1: "  + res1 );
        System.out.println( "result for summator 2: "  + res2 );
        System.out.println( "result for summator 3: "  + res3 );

    }

}
