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
 * This is a utility class that provides some simple implementations of stats
 * and math calculators
 */
public class
MooseMath
{
	public static int
	factorial(
		int n)
	{
		assert(n>=0);

		int rtn = n;
		if (n == 0) {
			rtn = 1;
		} else {
			while (n > 1) {
				rtn *= --n;
			}
		}

		return rtn;
	}

	public static int
	combination(
		int n,
		int r)
	{
		assert(n > r);

		return (factorial(n) / (factorial(r) * factorial(n-r));
	}

	public static int
	permutation(
		int n,
		int r)
	{
		assert(n > r);

		return (factorial(n) / factorial(n-r));
	}
}
