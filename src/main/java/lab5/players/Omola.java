package lab5.players;

import lab5.game.Board;
import lab5.game.Position;
import lab5.game.PlayerToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Omola extends Player {
    public Omola(String name) {
        super(name);
    }

    @Override
    public Position pickNextMove(Board currentBoard) {
        List<Position> emptyCells = currentBoard.getEmptyCells();
        PlayerToken myToken = currentBoard.getNextTurnToken();
        PlayerToken opponentToken = myToken.opponent();

        List<Position> winningMoves = findWinningMoves(currentBoard, myToken);
        if (!winningMoves.isEmpty()) {
            return getRandomPosition(winningMoves);
        }

        List<Position> blockingMoves = findWinningMoves(currentBoard, opponentToken);
        if (!blockingMoves.isEmpty()) {
            return getRandomPosition(blockingMoves);
        }
        

        return getRandomPosition(emptyCells);
    }
    
    private List<Position> findWinningMoves(Board currentBoard, PlayerToken token) {
        List<Position> winningMoves = new ArrayList<>();
        

        for (Position pos : currentBoard.getEmptyCells()) {

            Board boardCopy = new Board(currentBoard);
            

            boardCopy.placeNextToken(pos);
            if (token.equals(boardCopy.getWinner())) {
                winningMoves.add(pos);
            }
        }
        
        return winningMoves;
    }
    
    private Position getRandomPosition(List<Position> positions) {
        Random rand = new Random();
        return positions.get(rand.nextInt(positions.size()));
    }
}