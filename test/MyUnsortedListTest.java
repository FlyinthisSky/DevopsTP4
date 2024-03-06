package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import datastruct.EmptyListException;
import datastruct.MyUnsortedList;
import datastruct.UnsortedList;


public class MyUnsortedListTest {
	
	@Test
    public void testToString(){
        UnsortedList<Integer> integers = MyUnsortedList.of(122, 213, 456);
        assertEquals("Test toString", "MyUnsortedList { size = 3, [122, 213, 456] }", integers.toString());
    }
	   
	 @Test
	    public void testEquals(){
	        UnsortedList<Integer> integers = MyUnsortedList.of(122, 213, 456);
	        UnsortedList<Integer> integers2 = MyUnsortedList.of(122, 213, 456);
	        assertTrue("les deux listes sont identiques",integers.equals(integers2));
	        UnsortedList<Integer> integers3 = MyUnsortedList.of(122, 213, 4);
	        assertFalse("les deux listes sont différentes",integers.equals(integers3));
	    }

	
    @Test
    public void testIsEmpty() {
       UnsortedList<Integer> integers = MyUnsortedList.of(122, 213, 456);
       assertFalse("new list", integers.isEmpty());
        UnsortedList<Integer> integers2 = MyUnsortedList.of();
        assertTrue("new list", integers2.isEmpty());
    }
    @Test
    public void testSize() {
        UnsortedList<Integer> integers = MyUnsortedList.of(122, 213, 456);
        assertEquals("new list", 3, integers.size());
        UnsortedList<Integer> integers2 = MyUnsortedList.of();
        assertEquals("new list", 0, integers2.size());
    }
    @Test
    public void testAdd() {
        UnsortedList<Integer> integers = MyUnsortedList.of(122, 213, 456);
        integers.append(0);
        assertEquals("add element à la fin", 4, integers.size());
        assertEquals("Test toString", "MyUnsortedList { size = 4, [122, 213, 456, 0] }", integers.toString());
    }
    @Test
    public void testPrepend(){
        UnsortedList<Integer> integers = MyUnsortedList.of(122, 213, 456);
        integers.prepend(0);
        assertEquals("add element au début ", 4, integers.size());
        assertEquals("Test toString", "MyUnsortedList { size = 4, [0, 122, 213, 456] }", integers.toString());
    }
    @Test
    public void testInsert (){
        UnsortedList<Integer> integers = MyUnsortedList.of(122, 213, 456);
        integers.insert(666, 2);
        assertEquals("insertion", 4, integers.size());
        assertEquals("Test toString", "MyUnsortedList { size = 4, [122, 213, 666, 456] }", integers.toString());
        integers.insert(111, 0);
        assertEquals("insertion", 5, integers.size());
        assertEquals("Test toString", "MyUnsortedList { size = 5, [111, 122, 213, 666, 456] }", integers.toString());
        integers.insert(222, 5);
        assertEquals("insertion", 6, integers.size());
        assertEquals("Test toString", "MyUnsortedList { size = 6, [111, 122, 213, 666, 456, 222] }", integers.toString());

    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertExcept() {
        UnsortedList<Integer> integers3 = MyUnsortedList.of(123,215);
        integers3.insert(153,10);
    }

    @Test
    public void testPop(){
        UnsortedList<Integer> integers = MyUnsortedList.of(122, 213, 456);
        UnsortedList<Integer> integers2 = MyUnsortedList.of(1);
        integers2.append(integers.pop());
        assertEquals("taille premiere list apres pop ", 2, integers.size());
        //assertEquals("taille deuxieme list apres pop", 2, integers2.size());
        int k = integers2.pop();
        UnsortedList<Integer> integers3 = MyUnsortedList.of(k);
        UnsortedList<Integer> integers4 = MyUnsortedList.of(1);
        assertTrue("bon element pop", integers3.equals(integers4));
        assertEquals("elem bien enlevé", "MyUnsortedList { size = 1, [122] }", integers2.toString());
        
       
        

    }

    @Test(expected = EmptyListException.class)
    public void testPopExcept() {
        UnsortedList<Integer> integers3 = MyUnsortedList.of();
        integers3.pop();
    }

    @Test
    public void testPopLast(){
        UnsortedList<Integer> integers = MyUnsortedList.of(122, 213, 456);
        int k = integers.popLast();
        assertEquals("taille premiere list apres pop ", 2, integers.size());
        
        assertTrue("bon element popLast", k==456);
        assertEquals("elem bien enlevé", "MyUnsortedList { size = 2, [122, 213] }", integers.toString());
    }

    @Test(expected = EmptyListException.class)
    public void testPopLastExcept() {
        UnsortedList<Integer> integers3 = MyUnsortedList.of();
        integers3.popLast();
    }

    @Test
    public void testRemove(){
        UnsortedList<Integer> integers = MyUnsortedList.of(122, 213, 456);
        int k = integers.remove(2);
        assertTrue("bon element popLast", k==456);
        assertEquals("taille de la liste",2,integers.size());
        int k2 = integers.remove(0);
        assertTrue("bon element popLast", k2==122);
        assertEquals("taille de la liste",1,integers.size());
        assertEquals("elem bien enlevé", "MyUnsortedList { size = 1, [213] }", integers.toString());
        
        
    }

   
    
}