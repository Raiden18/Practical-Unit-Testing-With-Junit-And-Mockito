package com.raiden.learningunittest.chapter6.operatingsystem;

public class OperatingSystem {
    int nbOfBits;
    String name;
    int version;
    int releaseYear;

    public int getNbOfBits() {
        return nbOfBits;
    }

    public void setNbOfBits(int nbOfBits) {
        this.nbOfBits = nbOfBits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
