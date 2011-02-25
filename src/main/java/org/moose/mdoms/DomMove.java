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

/**
 * A move in a dominoes game
 */
public class
DomMove
{
	private String _name;
	private DomCard _card;
	private String _side;

	public
	DomMove(
		String name,
		DomCard card,
		String side)
	{
		_name = name;
		_card = card;
		_side = side;
	}

	public String
	getName()
	{ return _name; }

	public DomCard
	getCard()
	{ return _card; }

	public String
	getSide()
	{ return _side; }
}
