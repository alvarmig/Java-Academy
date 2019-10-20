package com.company.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*
* The program creates two
* LinkedLists of Strings. The elements of one List are added to the other. Then all the
* Strings are converted to uppercase, and a range of elements is deleted.
*/
public class ListTest {
    public static void main( String[] args ) {
        // add colors elements to list1
        String[] colors = { "black", "yellow", "green", "blue", "violet", "silver" };
        List< String > list1 = new LinkedList< String >();

        for ( String color : colors )
            list1.add(color);

        // add colors2 elements to list2
        String[] colors2 = { "gold", "white", "brown", "blue", "gray", "silver" };
        List< String > list2 = new LinkedList< String >();

        for ( String color : colors2 )
            list2.add(color);

        list1.addAll(list2);
        list2 = null; // release resources
        printList( list1 ); // print list1 elements

        convertToUppercaseStrings( list1 ); // convert to uppercase string
        printList( list1 ); // print list1 elements

        System.out.print( "\nDeleting elements 4 to 6..." );
        removeItems( list1, 4, 7 ); // remove items 4-6 from list
        printList( list1 ); // print list1 elements
        printReversedList( list1 ); // print list in reverse order

        convertToLowercaseStrings(list1);

    } // end main

    private static void printList( List<String> list) {
        System.out.println( "\nlist: " );

       for ( String color : list )
           System.out.printf( "%s ", color );

       System.out.println();
    } // end method printList

    // locate String objects and convert to uppercase
    private static void convertToUppercaseStrings( List< String > list ){
        ListIterator< String > iterator = list.listIterator();

        while(iterator.hasNext()){
            String color = iterator.next();
            iterator.set(color.toUpperCase());
        }
    }

    private static void removeItems(List<String> list, int start, int end) {
        list.subList(start, end).clear();
    }

    private static void printReversedList(List<String> list) {
        ListIterator<String> iterator = list.listIterator(list.size());

        System.out.println( "\nReversed List:" );

        while(iterator.hasPrevious())
            System.out.printf( "%s ", iterator.previous());
    }

    private static void convertToLowercaseStrings( List< String > list ){

        for(int i=0; i < list.size(); i++){
            System.out.println(list.get(i).toLowerCase());
        }
    }
}
