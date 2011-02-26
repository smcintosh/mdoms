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

/**
 * A single domino
 */
public class
DomCard
{
	/**
	 * The first side
	 */
	private int _s1;

	/**
	 * The second side
	 */
	private int _s2;

	public
	DomCard(
		int s1,
		int s2)
	{
		_s1 = s1;
		_s2 = s2;
	}

	public int
	getS1()
	{ return _s1; }

	public int
	getS2()
	{ return _s2; }

	public boolean
	equals(
		Object o)
	{
		boolean rtn = false;

		if (o instanceof DomCard) {
			DomCard other = (DomCard)o;

			rtn = (other.getS1() == _s1 && other.getS2() == _s2) ||
				(other.getS1() == _s2 && other.getS2() == _s1);
		}

		return rtn;
	}

	/**
	 * Test to see if this card has a side matching the given value.
	 * @param num 	The number to test against.
	 * @return	The value of the side not matching if there is a match,
	 * 		-1 otherwise
	 */
	public int
	hasSideMatching(
		int num)
	{
		int rtn = -1;

		if (_s1 == num) {
			rtn = _s2;
		} else if (_s2 == num) {
			rtn = _s1;
		}

		return rtn;
	}

	public boolean
	isPass()
	{
		return _s1 == Integer.MIN_VALUE && _s2 == Integer.MIN_VALUE;
	}
}
