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

import java.io.InputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * A data input stream that provides functionality for reading and writing
 * strings
 */
public class
MooseInputStream
extends DataInputStream
{
	/**
	 * Construct a RobotInputStream
	 */
	public MooseInputStream(
		InputStream is)
	{
		super(is);
	}

	/**
	 * Read a string from the wire
	 * @return The string read 
	 * @throws IOException If things have gone bad
	 */
	public String readString()
	throws IOException
	{
		String rtn = "";
		int sz = readInt();

		if (sz < 0) {
			throw new IOException("String size is invalid");
		}

		for (int i=0; i<sz; ++i) {
			rtn += readChar();
		}

		return rtn;
	}
}
