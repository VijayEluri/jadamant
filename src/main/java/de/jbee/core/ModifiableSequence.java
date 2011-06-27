package de.jbee.core;

public interface ModifiableSequence<E> {

	ModifiableSequence<E> deleteAt( int index );

	ModifiableSequence<E> drop( int count );

	ModifiableSequence<E> insertAt( int index, E e );

	ModifiableSequence<E> replaceAt( int index, E e );

	ModifiableSequence<E> take( int count );

}
