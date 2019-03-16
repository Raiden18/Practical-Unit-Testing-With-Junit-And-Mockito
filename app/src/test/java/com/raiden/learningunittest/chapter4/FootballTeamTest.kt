package com.raiden.learningunittest.chapter4

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class FootballTeamTest {
    fun numbersOfWonGames() = arrayOf(0, 1, 2, 3, 4)

    @Test
    @Parameters(method = "numbersOfWonGames")
    fun `Constructor should set games won`(gamesWon: Int) {
        val team = FootballTeam(gamesWon)
        assertEquals(
            "$gamesWon games passed to the constructor but ${team.gamesWon} were return",
            gamesWon,
            team.gamesWon
        )
    }

    fun illegalNumberOfWonGames() = arrayOf(-1, -2, -3, -4, -5)

    @Test(expected = IllegalArgumentException::class)
    @Parameters(method = "illegalNumberOfWonGames")
    fun `Constructor should throw exception for wrong state exception`(gamesWon: Int) {
        FootballTeam(gamesWon)
    }

    @Test
    fun `Team with more matches won must be greater`() {
        val team1 = FootballTeam(1)
        val team2 = FootballTeam(3)
        assertTrue(
            " Team with ${team1.gamesWon} games won must be ranked before the team with ${team2.gamesWon}",
            team2 > team1
        )
    }

    @Test
    fun `Team with less matches won must be lesser`() {
        val team1 = FootballTeam(1)
        val team2 = FootballTeam(3)
        assertTrue(
            "Team with ${team1.gamesWon} games won must be ranked after the team with ${team2.gamesWon}",
            team1 < team2
        )
    }

    @Test
    fun `Team with the same number of matches won must be equal`() {
        val team1 = FootballTeam(1)
        val team2 = FootballTeam(1)
        assertTrue(
            "Team with ${team1.gamesWon} games won must be equal the team with ${team2.gamesWon}",
            team1 == team2
        )
    }
}