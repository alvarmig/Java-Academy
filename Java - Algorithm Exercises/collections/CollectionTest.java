package com.company.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
/*
* Collection interface demonstrated via an ArrayList object
* The program places two Color arrays in ArrayLists and
* uses an Iterator to remove elements in the second ArrayList collection from the first.
 */
public class CollectionTest {

    public static void main(String[] args) {
        // add elements in colors array to list
        String [] colors = {"MAGENTA", "RED", "WHITE", "BLUE", "CYAN"};
        List<String> list = new ArrayList<String>();

        for(String color : colors) {
            list.add(color);
        }

        // add elements in removeColors array to removeList
        String[] removeColors = {"RED", "WHITE", "BLUE"};
        List<String> removeList = new ArrayList<String>();

        for(String color: removeColors) {
            removeList.add(color);
        }

        System.out.println( "ArrayList: " );
        for ( int count = 0; count < list.size(); count++ )
            System.out.printf( "%s ", list.get( count ));

        removeColors( list, removeList );

        System.out.println( "\n\nArrayList after calling removeColors: " );

        for ( String color : list )
            System.out.printf( "%s ", color );
    }

    private static void removeColors(Collection<String> collection1, Collection<String> collection2) {
        Iterator<String> iterator = collection1.iterator();

        while(iterator.hasNext()){
            if(collection2.contains(iterator.next()))
                    iterator.remove();
        }
    }
}
