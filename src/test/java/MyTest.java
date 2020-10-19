import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyTest {

	@Test
	void test() {
		JavaFXTemplate player = new JavaFXTemplate();
		assertEquals(0, player.scorings(0, 0), "Value not same, Failed test");
//		fail();
	}
	
	@Test
	void test1() {
		JavaFXTemplate player = new JavaFXTemplate();
		assertEquals(750, player.scorings(8, 7), "Value not same, Failed test1");
//		fail();
	}
	
	@Test
	void test2() {
		JavaFXTemplate player = new JavaFXTemplate();
		assertEquals(100000, player.scorings(10, 10), "Value not same, Failed test2");
//		fail();
	}
	
	@Test
	void test3() {
		JavaFXTemplate player = new JavaFXTemplate();
		assertEquals(5, player.scorings(10, 0), "Value not same, Failed test3");
	}
	
	@Test
	void test4() {
		JavaFXTemplate player = new JavaFXTemplate();
		assertEquals(0, player.scorings(4, 0), "Value not same, Failed test4");
//		fail();
	}
	
	@Test
	void test5() {
		JavaFXTemplate player = new JavaFXTemplate();
		Set<Integer> hash_Set = new HashSet<Integer>();
		hash_Set.add(1);
		hash_Set.add(2);
		Queue<String> q = new LinkedList<>();
		q.add("1");
		q.add("2");
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("1");
		arr.add("2");
		assertEquals(arr, player.matcher(hash_Set,q) ,"Lists not same in test5");
	}
	
	@Test
	void test6() {
		JavaFXTemplate player = new JavaFXTemplate();
		Set<Integer> hash_Set = new HashSet<Integer>();
		hash_Set.add(1);
		hash_Set.add(2);
		Queue<String> q = new LinkedList<>();
		q.add("1");
		q.add("2");
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("1");
		//arr.add("2");
		assertNotEquals(arr, player.matcher(hash_Set,q) ,"Lists not same in test6");
	}
	
	@Test
	void test7() {
		JavaFXTemplate player = new JavaFXTemplate();
		Set<Integer> hash_Set = new HashSet<Integer>();
		hash_Set.add(1);
		hash_Set.add(2);
		Queue<String> q = new LinkedList<>();
		q.add("1");
		q.add("2");
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("1");
		arr.add("2");
		arr.add("3");
		assertNotEquals(arr, player.matcher(hash_Set,q) ,"Lists not same in test7");
	}
	
	@Test
	void test8() {
		JavaFXTemplate player = new JavaFXTemplate();
		assertEquals(10000, player.scorings(8, 8), "Value not same, Failed test8");
	}
	
	@Test
	void test9() {
		JavaFXTemplate player = new JavaFXTemplate();
		assertNotEquals(5000, player.scorings(8, 8), "Value not same, Failed test9");
	}
	
	@Test
	void test10() {
		JavaFXTemplate player = new JavaFXTemplate();
		assertEquals(15, player.scorings(10, 6), "Value not same, Failed test10");
	}
	
	@Test
	void test11() {
		JavaFXTemplate player = new JavaFXTemplate();
		assertEquals(4250, player.scorings(10, 9), "Value not same, Failed test11");
	}
	
	@Test
	void test12() {
		JavaFXTemplate player = new JavaFXTemplate();
		assertEquals(0, player.scorings(9, 10), "Value not same, Failed test12");
	}
	
	@Test
	void test13() {
		JavaFXTemplate player = new JavaFXTemplate();
		Set<Integer> hash_Set = new HashSet<Integer>();
		hash_Set.add(1);
		hash_Set.add(2);
		hash_Set.add(3);
		Queue<String> q = new LinkedList<>();
		q.add("1");
		q.add("2");
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("1");
		arr.add("2");
		assertEquals(arr, player.matcher(hash_Set,q) ,"Lists not same in test13");
	}
	
	@Test
	void test14() {
		JavaFXTemplate player = new JavaFXTemplate();
		Set<Integer> hash_Set = new HashSet<Integer>();
		hash_Set.add(1);
		hash_Set.add(2);
		hash_Set.add(3);
		Queue<String> q = new LinkedList<>();
		q.add("1");
		q.add("2");
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("1");
		arr.add("2");
		arr.add("3");
		assertNotEquals(arr, player.matcher(hash_Set,q) ,"Lists not same in test14");
	}
	
	@Test
	void test15() {
		JavaFXTemplate player = new JavaFXTemplate();
		Set<Integer> hash_Set = new HashSet<Integer>();
		hash_Set.add(1);
		hash_Set.add(2);
		Queue<String> q = new LinkedList<>();
		q.add("1");
		q.add("2");
		q.add("3");
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("1");
		arr.add("2");
		arr.add("3");
		assertNotEquals(arr, player.matcher(hash_Set,q) ,"Lists not same in test15");
	}
	
	@Test
	void test16() {
		JavaFXTemplate player = new JavaFXTemplate();
		assertEquals(0, player.scorings(1, 5), "Value not same, Failed test16");
	}
	
	@Test
	void test17() {
		JavaFXTemplate player = new JavaFXTemplate();
		assertEquals(2, player.scorings(1, 1), "Value not same, Failed test17");
	}
	
	@Test
	void test18() {
		JavaFXTemplate player = new JavaFXTemplate();
		assertEquals(75, player.scorings(4, 4), "Value not same, Failed test18");
	}
	
	@Test
	void test19() {
		JavaFXTemplate player = new JavaFXTemplate();
		assertEquals(12, player.scorings(8, 5), "Value not same, Failed test19");
	}
	
	@Test
	void test20() {
		JavaFXTemplate player = new JavaFXTemplate();
		assertEquals(1, player.scorings(4, 2), "Value not same, Failed test20");
	}
	
	@Test
	void test21() {
		JavaFXTemplate player = new JavaFXTemplate();
		assertEquals(50, player.scorings(8, 6), "Value not same, Failed test21");
	}
	
	@Test
	void test22() {
		JavaFXTemplate player = new JavaFXTemplate();
		assertEquals(40, player.scorings(10, 7), "Value not same, Failed test22");
	}
	
	@Test
	void test23() {
		JavaFXTemplate player = new JavaFXTemplate();
		Set<Integer> hash_Set = new HashSet<Integer>();
		hash_Set.add(1);
		hash_Set.add(2);
		hash_Set.add(3);
		Queue<String> q = new LinkedList<>();
		q.add("1");
		q.add("2");
		q.add("4");
		q.add("3");
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("1");
		arr.add("2");
		arr.add("3");
		assertEquals(arr, player.matcher(hash_Set,q) ,"Lists not same in test23");
	}
	
	@Test
	void test24() {
		JavaFXTemplate player = new JavaFXTemplate();
		Set<Integer> hash_Set = new HashSet<Integer>();
		hash_Set.add(1);
		Queue<String> q = new LinkedList<>();
		q.add("1");
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("1");
		assertEquals(arr, player.matcher(hash_Set,q) ,"Lists not same in test24");
	}
	
	@Test
	void test25() {
		JavaFXTemplate player = new JavaFXTemplate();
		Set<Integer> hash_Set = new HashSet<Integer>();
		hash_Set.add(1);
		hash_Set.add(2);
		hash_Set.add(3);
		hash_Set.add(7);
		hash_Set.add(11);
		Queue<String> q = new LinkedList<>();
		q.add("1");
		q.add("2");
		q.add("11");
		q.add("7");
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("1");
		arr.add("2");
		arr.add("11");
		arr.add("7");
		assertEquals(arr, player.matcher(hash_Set,q) ,"Lists not same in test25");
	}
	
	
}
