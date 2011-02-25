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
 * A game of dominoes
 */
public class
DomGame
{
	private DomDeck _theDeck;
	private int _handNum;
	
	public
	DomGame()
	{
		_theDeck = new DomDeck();
		_handNum = 0;
	}

	public ArrayList<DomCard>
	draw()
	{
		ArrayList<DomCard> drawnCards = new ArrayList<DomCard>();
		int startPos = _handNum++*(_theDeck.getBiggest()+1);

		for (int i=startPos; i<startPos+_theDeck.getBiggest()+1; ++i) {
			drawnCards.add(_theDeck.elementAt(i));
		}

		return drawnCards;
	}
}
