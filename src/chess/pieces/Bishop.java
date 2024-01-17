package chess.pieces;

import boargame.Board;
import boargame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {
    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position piece = new Position(0, 0);

        //region nw
        piece.setValues(position.getRow() - 1, position.getColumn() - 1);
        while (getBoard().positionExists(piece) && !getBoard().thereIsAPiece(piece)) {
            mat[piece.getRow()][piece.getColumn()] = true;
            piece.setValues(piece.getRow() - 1, piece.getColumn() - 1);
        }
        if (getBoard().positionExists(piece) && isThereOpponentPiece(piece))
            mat[piece.getRow()][piece.getColumn()] = true;
        //endregion

        //region ne
        piece.setValues(position.getRow() - 1, position.getColumn() + 1);
        while (getBoard().positionExists(piece) && !getBoard().thereIsAPiece(piece)) {
            mat[piece.getRow()][piece.getColumn()] = true;
            piece.setValues(piece.getRow() - 1,piece.getColumn() + 1);
        }
        if (getBoard().positionExists(piece) && isThereOpponentPiece(piece))
            mat[piece.getRow()][piece.getColumn()] = true;
        //endregion

        //region sw
        piece.setValues(position.getRow() + 1, position.getColumn() - 1);
        while (getBoard().positionExists(piece) && !getBoard().thereIsAPiece(piece)) {
            mat[piece.getRow()][piece.getColumn()] = true;
            piece.setValues( piece.getRow() + 1,piece.getColumn() - 1);
        }
        if (getBoard().positionExists(piece) && isThereOpponentPiece(piece))
            mat[piece.getRow()][piece.getColumn()] = true;
        //endregion

        //region se
        piece.setValues(position.getRow() + 1, position.getColumn() + 1);
        while (getBoard().positionExists(piece) && !getBoard().thereIsAPiece(piece)) {
            mat[piece.getRow()][piece.getColumn()] = true;
            piece.setValues(piece.getRow() + 1,piece.getColumn() + 1);
        }
        if (getBoard().positionExists(piece) && isThereOpponentPiece(piece))
            mat[piece.getRow()][piece.getColumn()] = true;
        //endregion

        return mat;
    }

    @Override
    public String toString() {
        return "B";
    }
}
