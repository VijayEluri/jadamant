package de.jbee.lang.seq;

import static de.jbee.lang.seq.ListMatcher.hasEqualElementsAsIn;
import static de.jbee.lang.seq.ListMatcher.hasNoElements;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.jbee.lang.Fulfills;
import de.jbee.lang.List;
import de.jbee.lang.Operator;
import de.jbee.lang.Order;
import de.jbee.lang.Predicate;
import de.jbee.lang.Set;

public class TestUtileListTranstion {

	@Test
	public void testInit() {
		List<Integer> l = List.with.elements( 7, 9 );
		assertThat( List.which.init.from( l ), hasEqualElementsAsIn( 7 ) );
	}

	@Test
	public void testTail() {
		assertThat( List.which.tail.from( List.with.<Integer> noElements() ),
				hasNoElements( Integer.class ) );
		assertThat( List.which.tail.from( List.with.elements( 7 ) ), hasNoElements( Integer.class ) );
		assertThat( List.which.tail.from( List.with.elements( 7, 9 ) ), hasEqualElementsAsIn( 9 ) );
		assertThat( List.which.tail.from( List.with.elements( 7, 9, 2 ) ), hasEqualElementsAsIn( 9,
				2 ) );
	}

	@Test
	public void testDropsLast() {
		List<Integer> l = List.with.elements( 7, 9, 3, 1, 5 );
		assertThat( List.which.dropsLast( -1 ).from( l ), hasEqualElementsAsIn( 7, 9, 3, 1, 5 ) );
		assertThat( List.which.dropsLast( 0 ).from( l ), hasEqualElementsAsIn( 7, 9, 3, 1, 5 ) );
		assertThat( List.which.dropsLast( 1 ).from( l ), hasEqualElementsAsIn( 7, 9, 3, 1 ) );
		assertThat( List.which.dropsLast( 2 ).from( l ), hasEqualElementsAsIn( 7, 9, 3 ) );
		assertThat( List.which.dropsLast( 3 ).from( l ), hasEqualElementsAsIn( 7, 9 ) );
		assertThat( List.which.dropsLast( 4 ).from( l ), hasEqualElementsAsIn( 7 ) );
		assertThat( List.which.dropsLast( 5 ).from( l ), hasNoElements( Integer.class ) );
		assertThat( List.which.dropsLast( 6 ).from( l ), hasNoElements( Integer.class ) );
	}

	@Test
	public void testTakesFirst() {
		List<Integer> l = List.with.elements( 7, 9, 3, 1, 5 );
		assertThat( List.which.takesFirst( -1 ).from( l ), hasNoElements( Integer.class ) );
		assertThat( List.which.takesFirst( 0 ).from( l ), hasNoElements( Integer.class ) );
		assertThat( List.which.takesFirst( 1 ).from( l ), hasEqualElementsAsIn( 7 ) );
		assertThat( List.which.takesFirst( 2 ).from( l ), hasEqualElementsAsIn( 7, 9 ) );
		assertThat( List.which.takesFirst( 3 ).from( l ), hasEqualElementsAsIn( 7, 9, 3 ) );
		assertThat( List.which.takesFirst( 4 ).from( l ), hasEqualElementsAsIn( 7, 9, 3, 1 ) );
		assertThat( List.which.takesFirst( 5 ).from( l ), hasEqualElementsAsIn( 7, 9, 3, 1, 5 ) );
		assertThat( List.which.takesFirst( 6 ).from( l ), hasEqualElementsAsIn( 7, 9, 3, 1, 5 ) );
	}

	@Test
	public void testDropsFirst() {
		List<Integer> l = List.with.elements( 7, 9, 3, 1, 5 );
		assertThat( List.which.dropsFirst( -1 ).from( l ), hasEqualElementsAsIn( 7, 9, 3, 1, 5 ) );
		assertThat( List.which.dropsFirst( 0 ).from( l ), hasEqualElementsAsIn( 7, 9, 3, 1, 5 ) );
		assertThat( List.which.dropsFirst( 1 ).from( l ), hasEqualElementsAsIn( 9, 3, 1, 5 ) );
		assertThat( List.which.dropsFirst( 2 ).from( l ), hasEqualElementsAsIn( 3, 1, 5 ) );
		assertThat( List.which.dropsFirst( 3 ).from( l ), hasEqualElementsAsIn( 1, 5 ) );
		assertThat( List.which.dropsFirst( 4 ).from( l ), hasEqualElementsAsIn( 5 ) );
		assertThat( List.which.dropsFirst( 5 ).from( l ), hasNoElements( Integer.class ) );
		assertThat( List.which.dropsFirst( 6 ).from( l ), hasNoElements( Integer.class ) );
	}

	@Test
	public void testTakesLast() {
		List<Integer> l = List.with.elements( 7, 9, 3, 1, 5 );
		assertThat( List.which.takesLast( -1 ).from( l ), hasNoElements( Integer.class ) );
		assertThat( List.which.takesLast( 0 ).from( l ), hasNoElements( Integer.class ) );
		assertThat( List.which.takesLast( 1 ).from( l ), hasEqualElementsAsIn( 5 ) );
		assertThat( List.which.takesLast( 2 ).from( l ), hasEqualElementsAsIn( 1, 5 ) );
		assertThat( List.which.takesLast( 3 ).from( l ), hasEqualElementsAsIn( 3, 1, 5 ) );
		assertThat( List.which.takesLast( 4 ).from( l ), hasEqualElementsAsIn( 9, 3, 1, 5 ) );
		assertThat( List.which.takesLast( 5 ).from( l ), hasEqualElementsAsIn( 7, 9, 3, 1, 5 ) );
		assertThat( List.which.takesLast( 6 ).from( l ), hasEqualElementsAsIn( 7, 9, 3, 1, 5 ) );
	}

	@Test
	public void testTakeFirstDropLast() {
		List<Integer> l = List.with.elements( 1, 2, 3, 4, 5 );
		assertThat( List.which.takesFirst( 3 ).dropsLast( 1 ).from( l ),
				hasEqualElementsAsIn( 1, 2 ) );
	}

	@Test
	public void testTrims() {
		List<Integer> l = List.with.elements( 1, 2, 3, 4, 5 );
		assertThat( List.which.trims( 1 ).from( l ), hasEqualElementsAsIn( 2, 3, 4 ) );
		assertThat( List.which.trims( 2 ).from( l ), hasEqualElementsAsIn( 3 ) );
		assertThat( List.which.trims( 3 ).from( l ), hasNoElements( Integer.class ) );
	}

	@Test
	public void testSorts() {
		List<Integer> l = List.with.elements( 4, 5, 7, 3, 1, 8 );
		assertThat( List.which.sorts().from( l ), hasEqualElementsAsIn( 1, 3, 4, 5, 7, 8 ) );
	}

	@Test
	public void testShuffle() {
		List<Integer> l = List.with.elements( 4, 5, 7, 3, 1, 8 );
		assertThat( List.which.shuffle.from( l ), not( hasEqualElementsAsIn( 4, 5, 7, 3, 1, 8 ) ) );
	}

	@Test
	public void testNubs() {
		List<Integer> l = List.with.elements( 4, 5, 4, 6, 5, 7, 4 );
		assertThat( List.which.nubs().from( l ), hasEqualElementsAsIn( 4, 5, 6, 7 ) );
	}

	@Test
	public void testSwapsAscending() {
		List<Integer> l = List.with.elements( 1, 2, 3, 4 );
		Integer[] swap01 = { 2, 1, 3, 4 };
		assertThat( List.which.swaps( 0, 1 ).from( l ), hasEqualElementsAsIn( swap01 ) );
		assertThat( List.which.swaps( 1, 0 ).from( l ), hasEqualElementsAsIn( swap01 ) );
	}

	@Test
	public void testSwapsRandom() {
		List<Integer> l = List.with.elements( 9, 5, 2, 8 );
		Integer[] swap01 = { 5, 9, 2, 8 };
		assertThat( List.which.swaps( 0, 1 ).from( l ), hasEqualElementsAsIn( swap01 ) );
		assertThat( List.which.swaps( 1, 0 ).from( l ), hasEqualElementsAsIn( swap01 ) );
		Integer[] swap02 = { 2, 5, 9, 8 };
		assertThat( List.which.swaps( 0, 2 ).from( l ), hasEqualElementsAsIn( swap02 ) );
		assertThat( List.which.swaps( 2, 0 ).from( l ), hasEqualElementsAsIn( swap02 ) );
		Integer[] swap03 = { 8, 5, 2, 9 };
		assertThat( List.which.swaps( 0, 3 ).from( l ), hasEqualElementsAsIn( swap03 ) );
		assertThat( List.which.swaps( 3, 0 ).from( l ), hasEqualElementsAsIn( swap03 ) );
		Integer[] swap23 = { 9, 5, 8, 2 };
		assertThat( List.which.swaps( 2, 3 ).from( l ), hasEqualElementsAsIn( swap23 ) );
		assertThat( List.which.swaps( 3, 2 ).from( l ), hasEqualElementsAsIn( swap23 ) );
	}

	@Test
	public void testSublists() {
		Integer[] larr = { 3, 6, 1, 0, 9, 5, 2, 8 };
		List<Integer> l = List.with.elements( 3, 6, 1, 0, 9, 5, 2, 8 );
		assertThat( List.which.sublists( 0, l.length() ).from( l ), hasEqualElementsAsIn( larr ) );
		assertThat( List.which.sublists( 1, 3 ).from( l ), hasEqualElementsAsIn( 6, 1, 0 ) );
	}

	@Test
	public void testTakeWhile() {
		Integer[] larr = { 2, 4, 7, 9, 1, 4 };
		List<Integer> l = List.with.elements( larr );
		assertThat( List.which.takesWhile( Fulfills.always() ).from( l ),
				hasEqualElementsAsIn( larr ) );
		Predicate<Object> le7 = Operator.apply( 7, Operator.leBy( Order.inherent ) );
		assertThat( List.which.takesWhile( le7 ).from( l ), hasEqualElementsAsIn( 2, 4, 7 ) );
		Predicate<Object> lt9 = Operator.apply( 9, Operator.ltBy( Order.inherent ) );
		assertThat( List.which.takesWhile( lt9 ).from( l ), hasEqualElementsAsIn( 2, 4, 7 ) );
		Predicate<Object> gt1 = Operator.apply( 1, Operator.gtBy( Order.inherent ) );
		assertThat( List.which.takesWhile( gt1 ).from( l ), hasEqualElementsAsIn( 2, 4, 7, 9 ) );
	}

	@Test
	public void testRestrictsToSet() {
		Set<Integer> s = List.which.restrictsToSet().from( List.with.elements( 1, 2, 3, 4, 2, 5 ) );
		assertThat( s, hasEqualElementsAsIn( 1, 2, 3, 4, 5 ) );
	}
}
