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

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for DomGame.
 */
public class
DomGameTest 
extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public
	DomGameTest(
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
		return new TestSuite(DomGameTest.class);
	}

	/**
	 * A test
	 */
	public void
	testDomGameHands()
	{
		int idx = 0;
		DomGame game = new DomGame();

		ArrayList<DomCard> h1 = game.draw();
		ArrayList<DomCard> h2 = game.draw();
		ArrayList<DomCard> h3 = game.draw();
		ArrayList<DomCard> h4 = game.draw();

		// Hands should be of length 7
		assertTrue(h1.size() == 7);
		assertTrue(h2.size() == 7);
		assertTrue(h3.size() == 7);
		assertTrue(h4.size() == 7);
	
		assertTrue(h1.get(idx++).equals(new DomCard(0,0)));
		assertTrue(h1.get(idx++).equals(new DomCard(1,0)));
		assertTrue(h1.get(idx++).equals(new DomCard(0,2)));
		assertTrue(h1.get(idx++).equals(new DomCard(0,3)));
		assertTrue(h1.get(idx++).equals(new DomCard(4,0)));
		assertTrue(h1.get(idx++).equals(new DomCard(5,0)));
		assertTrue(h1.get(idx++).equals(new DomCard(0,6)));

		idx = 0;

		assertTrue(h2.get(idx++).equals(new DomCard(1,1)));
		assertTrue(h2.get(idx++).equals(new DomCard(2,1)));
		assertTrue(h2.get(idx++).equals(new DomCard(3,1)));
		assertTrue(h2.get(idx++).equals(new DomCard(1,4)));
		assertTrue(h2.get(idx++).equals(new DomCard(1,5)));
		assertTrue(h2.get(idx++).equals(new DomCard(1,6)));
		assertTrue(h2.get(idx++).equals(new DomCard(2,2)));

		idx = 0;

		assertTrue(h3.get(idx++).equals(new DomCard(2,3)));
		assertTrue(h3.get(idx++).equals(new DomCard(2,4)));
		assertTrue(h3.get(idx++).equals(new DomCard(2,5)));
		assertTrue(h3.get(idx++).equals(new DomCard(2,6)));
		assertTrue(h3.get(idx++).equals(new DomCard(3,3)));
		assertTrue(h3.get(idx++).equals(new DomCard(4,3)));
		assertTrue(h3.get(idx++).equals(new DomCard(5,3)));

		idx = 0;

		assertTrue(h4.get(idx++).equals(new DomCard(6,3)));
		assertTrue(h4.get(idx++).equals(new DomCard(4,4)));
		assertTrue(h4.get(idx++).equals(new DomCard(4,5)));
		assertTrue(h4.get(idx++).equals(new DomCard(6,4)));
		assertTrue(h4.get(idx++).equals(new DomCard(5,5)));
		assertTrue(h4.get(idx++).equals(new DomCard(6,5)));
		assertTrue(h4.get(idx++).equals(new DomCard(6,6)));
	}

	public void
	testDomGameInvalidNumHands()
	{
		DomGame game = new DomGame();

		assertFalse(game.draw() == null);
		assertFalse(game.draw() == null);
		assertFalse(game.draw() == null);
		assertFalse(game.draw() == null);
		assertTrue(game.draw() == null);
	}
}
