/*
 * MDomS - A dominoes game backend server
 * Copyright (C) 2010-2011 Shane McIntosh
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.moose.mdoms;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for DomDeck.
 */
public class
DomDeckTest 
extends TestCase
{
	/**
	 * Create the test case.
	 *
	 * @param testName name of the test case
	 */
	public
	DomDeckTest(
		String testName)
	{
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( DomDeckTest.class );
	}

	/**
	 * When you specify a valid top value, it should take.
	 */
	public void testValidBiggest()
	{
		int big = 6;

		DomDeck theDeck = new DomDeck(big);
		assertTrue(theDeck.getBiggest() == big);
	}

	/**
	 * When you specify an invalid top value, it should print a warning
	 * and set it to the default size (6).
	 */
	public void testInvalidBiggest()
	{
		int big = -1;
		
		DomDeck theDeck = new DomDeck(big);
		assertTrue(theDeck.getBiggest() != big);
		assertTrue(theDeck.getBiggest() == 6);
	}
}
