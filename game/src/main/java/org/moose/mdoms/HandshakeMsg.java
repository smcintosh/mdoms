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

import java.io.IOException;

/**
 * The msg to send
 */
public class
HandshakeMsg
{
	private String _msg;

	public
	HandshakeMsg(
		String msg)
	{
		_msg = msg;
	}

	public
	HandshakeMsg(
		MooseInputStream mis)
	throws IOException
	{
		_msg = mis.readString();
	}

	public void
	write(
		MooseOutputStream mos)
	throws IOException
	{
		mos.writeString(_msg);
	}

	public String
	getMessage()
	{
		return _msg;
	}

	public boolean
	isValidHandshake()
	{
		return (_msg.equals(CommConstants.HANDSHAKE_MSG));
	}
}
