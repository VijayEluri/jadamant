package de.jbee.core.list;

import org.junit.BeforeClass;

import de.jbee.core.Core;

public class TestStackLister
		extends TestLister {

	@BeforeClass
	public static void setUp() {
		Core.setUp( InitList.LISTER_FACTORY );
	}
}
