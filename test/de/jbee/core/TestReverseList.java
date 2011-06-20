package de.jbee.core;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.jbee.core.list.CoreListTransition;
import de.jbee.core.list.List;
import de.jbee.core.list.ListTransition;

public class TestReverseList {

	@Test
	public void testAppend() {
		List<Integer> l = List.reverse.from( List.with.<Integer> noElements() );
		for ( int i = 1; i < 100; i++ ) {
			l = l.append( i );
			assertThat( i, is( l.size() ) );
			for ( int j = 0; j < i; j++ ) {
				assertThat( j + 1, is( l.at( j ) ) );
			}
		}
	}

	@Test
	public void testReverseTransition() {
		List<Integer> expected = List.with.elements( 4, 3, 2, 1 );
		List<Integer> actual = List.reverse.from( List.with.elements( 1, 2, 3, 4 ) );
		for ( int i = 0; i < expected.size(); i++ ) {
			assertThat( actual.at( i ), is( expected.at( i ) ) );
		}
	}

	@Test
	public void testConcatTransition() {
		List<Integer> expected = List.with.elements( 3, 2, 1 );
		ListTransition reverseTail = CoreListTransition.concat( List.reverse, List.tail );
		List<Integer> actual = reverseTail.from( List.with.elements( 1, 2, 3, 4 ) );
		for ( int i = 0; i < expected.size(); i++ ) {
			assertThat( actual.at( i ), is( expected.at( i ) ) );
		}
	}
}