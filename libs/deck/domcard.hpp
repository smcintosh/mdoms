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

#ifndef DOMCARD_HPP
#define DOMCARD_HPP

#define NUM_SIDES	(2)

class DomCard {
public:
	DomCard(unsigned short []); 
	~DomCard();

	bool operator==(DomCard &);
	unsigned short operator[](int);
	unsigned short getSide(int);
	void markPlayed();
	void unmarkPlayed();
	bool isPlayed();

private:
	unsigned short *_sides;
	bool _played;
};

#endif // DOMCARD_HPP
