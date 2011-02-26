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
	private ArrayList<DomMove> _moves;
	private int _left;
	private int _right;
	private String _curPlayer;
	
	public
	DomGame()
	{
		_theDeck = new DomDeck();
		_handNum = 0;
		_moves = new ArrayList<DomMove>();
		_left = -1;
		_right = -1;
	}

	public ArrayList<DomCard>
	draw()
	{
		ArrayList<DomCard> drawnCards = null;
		if (_handNum >= 0 && _handNum < 4) {
			drawnCards = new ArrayList<DomCard>();
			int startPos = _handNum++*(_theDeck.getBiggest()+1);

			for (int i=startPos; i<startPos+_theDeck.getBiggest()+1; ++i) {
				drawnCards.add(_theDeck.elementAt(i));
			}
		}

		return drawnCards;
	}

	public boolean
	isValidMove(
		DomCard card)
	{
		return (_left == -1 && _right == -1) ||
			(card.hasSideMatching(_left) != -1) ||
			(card.hasSideMatching(_right) != -1);
	}

	public boolean
	makeMove(
		String name,
		DomCard card)
	{
		int newSide = -1;
		boolean rtn = false;

		if (isValidMove(card)) {
			rtn = true;
			if (_left == -1 && _right == -1) {
				_left = card.getS1();
				_right = card.getS2();
				_moves.add(new DomMove(name, card, "f"));
			} else if (
				(newSide=card.hasSideMatching(_left)) != -1) {

				_left = newSide;
				_moves.add(new DomMove(name, card, "l"));
			} else if (
				(newSide=card.hasSideMatching(_right)) != -1) {

				_right = newSide;
				_moves.add(new DomMove(name, card, "r"));
			} else {
				System.err.println("Unexpected move case");
				rtn = false;
			}
		} else if (card.isPass()) {
			rtn = true;
			_moves.add(new DomMove(name, card, "p"));
		}
		
		return rtn;
	}

	public void
	printMoves()
	{
		for (DomMove move : _moves) {
			move.print();
			System.out.println();
		}
	}
}
