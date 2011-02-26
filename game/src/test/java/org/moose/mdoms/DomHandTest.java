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
 * Unit test for DomHand
 */
public class
DomHandTest 
extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public
	DomHandTest(
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
		return new TestSuite(DomHandTest.class);
	}

	/**
	 * A test
	 */
	public void
	testDomHandFinished()
	{
		int i = 0;
		DomGame game = new DomGame();

		DomHand hand = new DomHand(game);

		for (; i<6; i++) {
			hand.playCard(i);
			assertTrue(hand.isPlayed(i));
			assertFalse(hand.isFinished());
		}
		hand.playCard(i);
		assertTrue(hand.isFinished());
	}
}