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
	{
		_game = new DomGame();
		_svrSock = new ServerSocket(CommConstants.SOCK_PORT);
	}

	public void
	listen()
	{
		Socket aSocket = null;

		while (true) {
			try {
				aSocket = _svrSock.accept();
				if (didHandshake(aSocket)) {
				} else {
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
		Socket sock)
	{
		HandshakeMsg msg = new HandshakeMsg(
			new MooseInputStream(s.getInputStream()));

		return msg.isValidHandshake();
	}
}
