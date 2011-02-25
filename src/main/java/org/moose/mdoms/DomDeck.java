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
import java.util.Random;

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
	DomDeck()
	{
		this(6);
	}

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

	/**
	 * For testing purposes only.
	 */
	public DomCard
	elementAt(
		int idx)
	{
		return _dominoes.get(idx);
	}

	/**
	 * Shuffle the deck!
	 */
	private void
	shuffle()
	{
		Random rng = new Random();
		int numShuffles = _dominoes.size() * 3;

		while (--numShuffles > 0) {
			int idx1 = rng.nextInt(_dominoes.size());
			int idx2 = rng.nextInt(_dominoes.size());

			DomCard tmp = _dominoes.get(idx1);
			_dominoes.set(idx1, _dominoes.get(idx2));
			_dominoes.set(idx2, tmp);
		}
	}
}
