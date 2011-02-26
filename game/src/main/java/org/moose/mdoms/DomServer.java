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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * The server for a dominoes game
 */
public class
DomServer
{
	private DomGame _game;
	private ArrayList<DomHandle> _players;
	private ServerSocket _svrSock;
	
	public
	DomServer()
	throws IOException
	{
		_game = new DomGame();
		_svrSock = new ServerSocket(CommConstants.SOCK_PORT);
	}

	public void
	listen()
	{
		Socket aSocket = null;
		DomHandle h = null;

		while (true) {
			try {
				aSocket = _svrSock.accept();
				if (didHandshake(aSocket)) {
					h = new DomHandle(aSocket);
					h.start();
					_players.add(h);
				} else {
					throw new IOException(
						"Invalid handshake detected");
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
				break;
			}
		}

		cleanup();
	}

	private void
	cleanup()
	{
		for (DomHandle playerConn : _players) {
			playerConn.cleanup();
		}

		try {
			_svrSock.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private boolean
	didHandshake(
		Socket s)
	throws IOException
	{
		HandshakeMsg msg = new HandshakeMsg(
			new MooseInputStream(s.getInputStream()));

		return msg.isValidHandshake();
	}
}
