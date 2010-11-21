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

#ifndef DOMDECK_HPP
#define DOMDECK_HPP

#include <vector>
#include "mdoms/domcard.hpp"
#include "mdoms/domhand.hpp"

enum decktype_t {
	STD_DECK = 0,
	NINE_DECK = 1
};

class DomDeck {
public:
	DomDeck(enum decktype_t);
	~DomDeck();
	bool getHands(std::vector<DomHand *> *);

private:
	std::vector<DomCard *> *_cards;

	void shuffle(void);
};

#endif // DOMDECK_HPP
