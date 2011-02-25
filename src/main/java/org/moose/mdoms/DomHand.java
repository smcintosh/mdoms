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
 * A domino hand
 */
public class
DomHand
{
	private ArrayList<DomCard> _doms;
	private ArrayList<Boolean> _played;

	private DomGame _theGame;

	public
	DomHand(
		DomGame game)
	{
		ArrayList<DomCard> draw = null;

		_theGame = game;
		draw = _theGame.draw();

		// Deep copy the drawn hand
		_doms = new ArrayList<DomCard>();

		for (DomCard card : draw) {
			_doms.add(new DomCard(card.getS1(), card.getS2()));
			_played.add(new Boolean(false));
		}
	}

	public void
	playCard(
		int idx)
	{
		_played.set(idx, new Boolean(true));
	}

	public boolean
	isFinished()
	{
		return (!_played.contains(new Boolean(false)));
	}
}
