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

#include <iostream>
#include "domdeck.hpp"

DomDeck::DomDeck(
	enum decktype_t type)
{
	unsigned short i;
	unsigned short j;
	unsigned short max_card = 0;
	unsigned short *vals = new unsigned short[2];

	switch (type) {
	case STD_DECK:
		max_card = 6;
		break;
	case NINE_DECK:
		max_card = 9;
		break;
	default:
		// TODO: error handling
		std::cerr << "ERROR: unsupported type (" << type << ")" << std::endl;
	}


	for (i=0; i<=max_card; ++i) {
		for(j=i; j<=max_card; ++j) {
			vals[0] = i;
			vals[1] = j;
			_cards->push_back(new DomCard(vals));
		}
	}

	delete vals;
}

#define NUM_PLAYERS	4
bool
DomDeck::getHands(
	std::vector<DomHand *> *hands)
{
	int i = 0;
	int j = 0;
	int cardsPerHand = _cards->size() / NUM_PLAYERS;
	DomHand *hand;

	shuffle();
	
	for (; i<NUM_PLAYERS; ++i) {
		hand = new DomHand();

		for (; j<cardsPerHand; ++j) {
			hand->addCard(_cards->at(i*cardsPerHand+j));
		}

		hands->push_back(hand);
	}

	return true;
}

void
DomDeck::shuffle()
{
	return;
}

DomDeck::~DomDeck()
{
	while( _cards->size() > 0 ) {
		delete _cards->back();
		_cards->pop_back();
	}

	delete _cards;
}
