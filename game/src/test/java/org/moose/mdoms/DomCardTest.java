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
 * Unit test for DomCard.
 */
public class
DomCardTest 
extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public
	DomCardTest(
		String testName)
	{
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test
	suite()
	{
		return new TestSuite( DomCardTest.class );
	}

	/**
	 * Test to make sure a card is created correctly
	 */
	public void
	testDomCardCreate()
	{
		DomCard card = new DomCard(1,2);

		assertTrue(card.getS1() == 1);
		assertTrue(card.getS2() == 2);
	}

	/**
	 * Test the equals checker
	 */
	public void
	testDomCardEquals()
	{
		DomCard c1 = new DomCard(1,1);
		DomCard c2 = new DomCard(6,1);
		DomCard c3 = new DomCard(1,6);
		DomCard c4 = c1;

		assertTrue(c1.equals(c4) && c4.equals(c1));
		assertTrue(c2.equals(c3) && c3.equals(c2));
		assertFalse(c1.equals(c2) || c2.equals(c1));
		assertFalse(c1.equals(c3) || c3.equals(c1));
	}
}
