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

#ifndef DOMHAND_HPP
#define DOMHAND_HPP

#include <vector>
#include "domcard.hpp"

class DomHand {
public:
	DomHand();
	~DomHand();
	bool addCard(DomCard *);
	bool playCard(int);
	bool isFinished();

private:
	std::vector<DomCard *> *_hand;
};

#endif // DOMHAND_HPP