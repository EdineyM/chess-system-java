package chess.pieces;

import boargame.Board;
import boargame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {
    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        //region above
        Position piecePosition = new Position(0, 0);
        piecePosition.setValues(position.getRow() - 1, position.getColumn());
        while (getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition)) {
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;
            piecePosition.setRow(piecePosition.getRow() - 1);
        }
        if (getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition))
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;
        //endregion

        //region left
        piecePosition.setValues(position.getRow(), position.getColumn() - 1);
        while (getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition)) {
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;
            piecePosition.setColumn(piecePosition.getColumn() - 1);
        }
        if (getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition))
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;
        //endregion

        //region right
        piecePosition.setValues(position.getRow(), position.getColumn() + 1);
        while (getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition)) {
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;
            piecePosition.setColumn(piecePosition.getColumn() + 1);
        }
        if (getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition))
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;
        //endregion

        //region below
        piecePosition.setValues(position.getRow() + 1, position.getColumn());
        while (getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition)) {
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;
            piecePosition.setRow(piecePosition.getRow() + 1);
        }
        if (getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition))
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;
        //endregion

        return mat;
    }
}
