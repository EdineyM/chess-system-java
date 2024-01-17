package chess.pieces;

import boargame.Board;
import boargame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {
    public Knight(Board board, Color color) {
        super(board, color);
    }

    private boolean canMove(Position position) {
        ChessPiece piece = (ChessPiece)getBoard().piece(position);
        return piece == null || piece.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position piecePosition = new Position(0, 0);

        piecePosition.setValues(position.getRow() - 1, position.getColumn() - 2);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition))
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;

        piecePosition.setValues(position.getRow() - 2, position.getColumn() - 1);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition))
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;

        piecePosition.setValues(position.getRow() - 2, position.getColumn() + 1);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition))
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;

        piecePosition.setValues(position.getRow() - 1, position.getColumn() + 2);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition))
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;

        piecePosition.setValues(position.getRow() + 1, position.getColumn() + 2);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition))
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;

        piecePosition.setValues(position.getRow() + 2, position.getColumn() + 1);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition))
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;

        piecePosition.setValues(position.getRow() + 2, position.getColumn() - 1);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition))
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;

        piecePosition.setValues(position.getRow() + 1, position.getColumn() - 2);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition))
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;

        return mat;
    }

    @Override
    public String toString() {
        return "N";
    }
}
