package de.jbee.lang;

/**
 * A {@linkplain ListModification} is a {@link ListTransition} just working for lists whose element
 * type is a special type used as the generic of this interface. A modification is bound to specific
 * type of elements.
 * 
 * A common example is to insert a whole list into the argument list of the {@link #from(List)}
 * method. This can just work fine as long as both lists consist of the same type of elements.
 * 
 * @author Jan Bernitt (jan.bernitt@gmx.de)
 * 
 * @param <E>
 *            The type of the list's elements.
 */
public interface ListModification<E> {

	List<E> from( List<E> list );
}
