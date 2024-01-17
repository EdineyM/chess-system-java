package chess.pieces;

import boargame.Board;
import boargame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    private boolean testRookCastling(Position position) {
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        return  piece != null && piece instanceof Rook && piece.getColor() == getColor() && piece.getMoveCount() == 0;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece piece = (ChessPiece)getBoard().piece(position);
        return piece == null || piece.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position piecePosition = new Position(0, 0);

        //above
        piecePosition.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition))
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;

        //below
        piecePosition.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition))
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;

        //left
        piecePosition.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition))
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;

        //right
        piecePosition.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition))
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;

        //nw
        piecePosition.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition))
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;

        //ne
        piecePosition.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition))
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;

        //sw
        piecePosition.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition))
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;

        //se
        piecePosition.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition))
            mat[piecePosition.getRow()][piecePosition.getColumn()] = true;

        // SpecialMove Castling
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            // Castling kingside rook
            Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(posT1)) {
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null)
                    mat[position.getRow()][position.getColumn() + 2]  = true;
            }
        }
        // Castling queenside rook
        Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
        if (testRookCastling(posT2)) {
            Position p1 = new Position(position.getRow(), position.getColumn() - 1);
            Position p2 = new Position(position.getRow(), position.getColumn() - 2);
            Position p3 = new Position(position.getRow(), position.getColumn() - 3);
            if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null)
                mat[position.getRow()][position.getColumn() - 2]  = true;
        }

        return mat;
    }
}
