package com.raiden.learningunittest.chapter4

data class FootballTeam(val gamesWon: Int) : Comparable<FootballTeam> {
    init {
        if (gamesWon < 0) throw IllegalArgumentException("Won games should be more than 0")
    }

    override fun compareTo(other: FootballTeam) = gamesWon - other.gamesWon
}