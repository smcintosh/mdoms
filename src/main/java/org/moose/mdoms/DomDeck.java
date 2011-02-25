/*
 * MDomS - A dominoes game backend server
 * Copyright (C) 2010 Shane McIntosh
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

/**
 * A deck of dominoes
 */
public class
DomDeck
{
	
	/**
	 * The list of dominoes
	 */
	private ArrayList<DomCard> _dominoes;

	/**
	 * The top domino dot count
	 */
	private int _biggest;

	public
	DomDeck(
		int biggest)
	{
		DomCard theCard = null;

		_dominoes = new ArrayList<DomCard>();
		_biggest = 6;

		if (biggestIsValid(biggest)) {
			_biggest = biggest;
		} else {
			System.err.println("Size is invalid. Using 6.");
		}
			
		for (int i=0; i<_biggest+1; ++i) {
			for (int j=i; j<_biggest+1; ++j) {
				theCard = new DomCard(i,j);
				_dominoes.add(theCard);
			}
		}
	}

	/**
	 * Test the value to make sure that it is an acceptable size
	 */
	private boolean
	biggestIsValid(
		int val)
	{
		return (val == 6);
	}

	public int
	getBiggest()
	{ return _biggest; }
}
