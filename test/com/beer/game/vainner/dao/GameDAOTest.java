package com.beer.game.vainner.dao;


import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;

import com.beer.game.vainner.model.Game;

public class GameDAOTest {

	
	@Test
	public void testS()
	{
		GameDAO dao = new GameDAO();
		Game game = new Game();
		game.setGameTitle("hello");
		game.setStartTime(new Timestamp(System.currentTimeMillis()));
		game.setEndTime(new Timestamp(System.currentTimeMillis()));
		dao.save(game);
		
		List<?> list =  dao.findAll();
		for (int i = 0 ; i < list.size() ; i++)
			System.out.println(((Game)list.get(i)).getGameId());
	}
}
