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
implements Comparable<DomCard>
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
	
	public int
	compareTo(
		DomCard other)
	{
		int others1 = other.getS1();
		int others2 = other.getS2();

		return (others1 == _s1 || others1 == _s2 ||
			others2 == _s1 || others2 == _s2) ? 0 : 1;
	}
}
