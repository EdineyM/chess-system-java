package boargame;

public class Piece {
    protected Position position;
    private  Board  board;

    public Piece(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public Piece[][] possibleMoves() {
        return null;
    }

    public boolean possibleMove(Position position) {
        return true;
    }

    public boolean isThereAnyPossibleMove() {
        return true;
    }
}
