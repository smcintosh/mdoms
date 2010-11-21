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

#include <stdio.h>
#include "mdoms/domcard.hpp"

DomCard::DomCard(
	unsigned short sides[])
{
	int i;

	_sides = new unsigned short[NUM_SIDES];

	for (i=0; i<NUM_SIDES; ++i) {
		_sides[i] = sides[i];
	}

	_played = false;
}

DomCard::~DomCard()
{
	delete _sides;
}

bool
DomCard::operator==(
	DomCard &dc)
{
	int i;
	bool rtn = true;

	for (i=0; i<NUM_SIDES; ++i) {
		if (dc[i] != _sides[i]) {
			rtn = false;
			break;
		}
	}

	return (rtn);
}

unsigned short
DomCard::operator[](
	int n)
{
	return _sides[n];
}

unsigned short
DomCard::getSide(
	int n)
{
	if (n < 0 || n >= NUM_SIDES) {
		// TODO: throw AOOBE
	}

	return (_sides[n]);
}

void
DomCard::markPlayed()
{
	_played = true;
}

void
DomCard::unmarkPlayed()
{
	_played = false;
}

bool
DomCard::isPlayed()
{
	return _played;
}
