package de.jbee.lang;

/**
 * A general unary operator interface.
 * 
 * @author Jan Bernitt (jan.bernitt@gmx.de)
 */
public interface UniOp<T> {

	T operate( T value );
}