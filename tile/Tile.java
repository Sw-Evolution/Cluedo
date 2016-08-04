package tile;

import game.GameError;

/**
 * This class represents a single tile on Cluedo game board (tiles that are out of rooms).
 * 
 * @author Hector
 *
 */
public class Tile extends Position {

    // the coordinates of this tile
    public final int x, y;

    /**
     * 
     * @param x
     * @param y
     */
    public Tile(int x, int y) {
        super();
        if (x < 0 || x > 23 || y < 0 || y > 24) {
            throw new GameError("Invalid Coordinates");
        }

        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + " , " + y + "]";
    }

    public String toStringOnBoard() {
        return "0";
    }

    @Override
    public String optionString(Position destination) {
        if (destination instanceof Tile) {
            Tile destinationTile = (Tile) destination;
            if (destinationTile.x - this.x == 1) {
                return "Move east.";
            } else if (destinationTile.x - this.x == -1) {
                return "Move west.";
            } else if (destinationTile.y - this.y == 1) {
                return "Move south.";
            } else if (destinationTile.y - this.y == -1) {
                return "Move north.";
            } else {
                throw new GameError("Shouldn't move two tiles away once");
            }
        } else {
            throw new GameError("Shouldn't move from a tile to a room");
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tile other = (Tile) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

}
