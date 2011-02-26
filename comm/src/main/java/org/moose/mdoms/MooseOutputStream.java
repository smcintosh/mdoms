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

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * A data output stream which provides functionality for writing strings
 */
public class MooseOutputStream
extends DataOutputStream
{
	/**
	 * Construct a RobotOutputStream
	 */
	public MooseOutputStream(
		OutputStream os)
	{
		super(os);
	}

	/**
	 * Write a string to the wire
	 * @param toWrite The string to write to the wire
	 * @throws IOException If things have gone bad
	 */
	public void writeString(
		String toWrite)
	throws IOException
	{
		int sz = toWrite.length();

		if (sz < 0) {
			throw new IOException("String size is invalid");
		}

		writeInt(sz);
		for (int i=0; i<sz; ++i) {
			writeChar(toWrite.charAt(i));
		}
		flush();
	}
}
