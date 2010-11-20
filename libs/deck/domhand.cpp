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

#include "domhand.hpp"

DomHand::DomHand()
{
	_hand = new std::vector<DomCard *>();
}

DomHand::~DomHand()
{
	int i = 0;

	for (; i<_hand->size(); ++i) {
		delete _hand->at(i);
	}
	delete _hand;
}

bool
DomHand::addCard(
	DomCard *card)
{
	_hand->push_back(card);
}

bool
DomHand::playCard(
	int idx)
{
	_hand->at(idx)->markPlayed();
}

bool
DomHand::isFinished()
{
	int i=0;
	bool rtn = true;

	for (; i<_hand->size(); ++i) {
		if (!_hand->at(i)->isPlayed()) {
			rtn = false;
			break;
		}
	}

	return rtn;
}