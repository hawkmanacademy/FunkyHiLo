package com.funkygames.funkyhilo.model;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.funkygames.funkyhilo.constants.Rank;
import com.funkygames.funkyhilo.constants.Suit;

public class CardTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void givenAValidRankAndSuitWhenCardIsCreatedThenGettersShouldMatchInputs() {
		Rank rank = Rank.DEUCE;
		Suit suit = Suit.CLUBS;
		
		Card card = new Card(rank,suit);
		
		Assert.assertEquals(rank, card.getRank());
		Assert.assertEquals(suit, card.getSuit());
	}

}
