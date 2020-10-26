public class Project4 {
    int BOARDSIZE=8;
//    String[][] board = new String[8][8];
    boolean white0rookMoved
            ,white7rookMoved
            ,black0rookMoved
            ,black7rookMoved
            ,whitekingMoved
            ,blackkingMoved;
//    public void init(String[][] board)
//    {
//        for(int i = 0; i < BOARDSIZE; i++)
//        {
//            board[0][i] = "white";
//            board[1][i] = "white";
//            board[1][i] += ",pawn";
//            board[6][i] = "black";
//            board[7][i] = "black";
//            board[6][i] += "pawn";
//        }
//        board[0][0] += " rook";
//        board[0][7] += " rook";
//        board[7][0] += " rook";
//        board[7][7] += " rook";
//        board[0][1] += " knight";
//        board[0][6] += " knight";
//        board[7][1] += " knight";
//        board[7][6] += " knight";
//        board[0][2] += " bishop";
//        board[0][5] += " bishop";
//        board[7][2] += " bishop";
//        board[7][5] += " bishop";
//        board[0][3] += " queen";
//        board[7][3] += " queen";
//        board[0][4] += " king";
//        board[7][4] += " king";
//        whitecastled = false;
//        blackcastled = false;
//        white0rookMoved = false;
//        white7rookMoved = false;
//        black0rookMoved = false;
//        black7rookMoved = false;
//        whitekingMoved = false;
//        blackkingMoved = false;
//    }
    public boolean OutOfBoard(int x, int y)
    {
        if(x < 0 || y < 0) return true;
        if(x > BOARDSIZE || y > BOARDSIZE) return true;
        return false;
    }
    public boolean CanMove(String[][] board, int x, int y, int x2, int y2, String side)
    {
        if(OutOfBoard(x,y) || OutOfBoard(x2,y2)) return false;
        if(board[x][y] == null) return false;
        if(!board[x][y].contains("white") && !board[x][y].contains("black")) return false;
        if(board[x][y].contains("pawn"))
        {
            if(CanMovePawn(board, x,y, x2, y2, side))
            {
                System.out.println("pawn can cut" + x2 + " " + y2);
                return true;
            }
            return false;
        }
        if(board[x][y].contains("king"))
        {
            if(CanMoveKing(board, x,y, x2, y2))
            {
                if(board[x][y].contains("white")) whitekingMoved = true;
                if(board[x][y].contains("black")) blackkingMoved = true;
                return true;
            }
            return false;
        }
        if(board[x][y].contains("queue"))
        {
            if(CanMoveQueue(board, x,y, x2, y2, side))
            {
                System.out.println("queue can cut" + x2 + " " + y2);
                return true;
            }
            return false;
        }
        if(board[x][y].contains("rook"))
        {
            if(CanMoveRook(board, x,y, x2, y2, side))
            {
                if(side == "white")
                {
                    if(x == 7)
                    {
                        if(y == 0) white0rookMoved = true;
                        if(y == 7) white7rookMoved = true;
                    }
                }else
                {
                    if(x == 0)
                    {
                        if(y == 0) black0rookMoved = true;
                        if(y == 7) black7rookMoved = true;
                    }
                }
                System.out.println("rook can cut" + x2 + " " + y2);
                return true;
            }else return false;
        }
        if(board[x][y].contains("bishop"))
        {
            if(CanMoveBishop(board, x,y, x2, y2, side))
            {
                System.out.println("bishop can cut" + x2 + " " + y2);
                return true;
            }
            return false;
        }
        if(board[x][y].contains("knight"))
        {
            if(CanMoveKnight(board, x,y, x2, y2, side))
            {
                System.out.println("knight can cut" + x2 + " " + y2);
                return true;
            }
            return false;
        }
        return false;
    }
    public boolean CanMovePawn(String[][] board, int x, int y, int x2, int y2, String side)
    {
        if(y == 7 && side == "white")
        {
            if(x2 == x && (y2 == 5 || y2 == 6))
            {
                for(int i = y2; i < y; i++)
                {
                    if(board[x][i] != null) return false;
                }
                return true;
            }
            return PawnEatLegal(board, x, y, x2, y2, side);
        }
        if(y == 2 && side == "black")
        {
            if(x2 == x && (y2 == 3 || y2 == 4))
            {
                for(int i = y2; i > y; i--)
                {
                    if(board[x][i] != null) return false;
                }
                return true;
            }
            return PawnEatLegal(board, x, y, x2, y2, side);
        }else
        {
            if(x == x2)
            {
                if(side == "white") return (y - y2 == 1 && board[x2][y2] == null);
                else return (y2 - y == 1 && board[x2][y2] == null);
            }else
            {
                return PawnEatLegal(board, x, y, x2, y2, side);
            }
        }
    }
    public boolean PawnEatLegal(String board[][], int x, int y, int x2, int y2, String side)
    {
        if(side == "white")
        {
            if(y - y2 == 1 && Math.abs(x - x2) == 1)
            {
                if(board[x2][y2] != null) return board[x2][y2].contains("black");
            }
            return false;
        }
        if(side == "black")
        {
            if(y - y2 == 1 && Math.abs(x - x2) == 1)
            {
                if(board[x2][y2] != null) return board[x2][y2].contains("white");
            }
            return false;
        }
        return false;
    }
    public boolean CanMoveKing(String[][] board, int x, int y, int x2, int y2)
    {
        return (Math.abs(x - x2) <= 1 && Math.abs(y - y2) <= 1);
    }
    public boolean CanMoveRook(String[][] board, int x, int y, int x2, int y2, String side)
    {
        //get the max and min value in the start value and end value
       int row1 = Math.min(x, x2);
       int row2 = Math.max(x, x2);
       int col1 = Math.min(y, y2);
       int col2 = Math.max(y, y2);
       //pieces can't don't move
       if(x == x2 && y == y2) return false;
       //in the same row
       if(x == x2)
       {
           for(int i = col1; i <= col2; i++)
           {
               //should not include the start place
               if(board[x][i] != board[x][y])
               {
                   //if end place have a piece check which side
                   if(board[x][i] == board[x2][y2] && board[x2][y2] != null)
                   {
                       // same side should not move
                       if(board[x2][y2].contains(side)) return false;
                   }
                   // in the path has pieces
                   else if(board[x][i] != null) return false;
               }
           }
           return true;
       }
       //check in the same col
       if(y == y2)
       {
           for(int i = row1; i <= row2; i++)
           {
               if(board[i][y] != board[x][y])
               {
                   if(board[i][y] == board[x2][y2] && board[x2][y2] != null)
                   {
                       if(board[x2][y2].contains(side)) return false;
                   }
                   else if(board[x][i] != null) return false;
               }
           }
           return true;
       }
       // if two place don't in the same row or col, return false;
       return false;
    }
    public boolean CanMoveBishop(String[][] board, int x, int y, int x2, int y2, String side)
    {
        int row1=Math.min(x, x2);
        int row2=Math.max(x, x2);
        int col1=Math.min(y, y2);
        int col2=Math.max(y, y2);
        // check in the same diagonal
        if(Math.abs(x - x2) != Math.abs(y - y2)) return false;
        // can't in the same place
        if(row1 == row2 && col1 == col2) return false;
        for(int i = row1; i <= row2; i++)
        {
            for(int j = col1; j <= col2; j++)
            {
                //check not in the start place and in the same diagonal
                if(board[i][j] != board[x][y] && (Math.abs(i - x) == Math.abs(j - y)))
                {
                    //check the end piece is the same same or not
                    if(board[i][j] == board[x2][y2] && board[x2][y2] != null)
                    {
                        if(board[x2][y2].contains(side)) return false;
                    //check in the path has piece or not
                    }else if (board[i][j] != null)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean CanMoveQueue(String[][] board, int x, int y, int x2, int y2, String side)
    {
        return CanMoveRook(board, x, y, x2, y2, side) || CanMoveBishop(board, x, y, x2, y2, side);
    }
    public boolean CanMoveKnight(String[][] board, int x, int y, int x2, int y2, String side)
    {
        //the different between row and col
        int row = Math.abs(x-x2);
        int col = Math.abs(y-y2);
        //check move is fine or not
        if((row == 1 && col == 2) || (row == 2 && col == 1))
        {
            // check end place piece is which side
            if(board[x2][y2] != null) return !board[x2][y2].contains(side);
            return true;
        }
        return false;
    }
//    public void MarkRookMove(String[][] board, int x, int y)
//    {
//
//    }
//    public void ChessMove(String[][] board, int x, int y, int x2, int y2)
//    {
//        board[x2][y2] = board[x][y];
//        board[x][y] = null;
//    }
//    public void MakeMove(String[][] board)
//    {
//
//    }
    public boolean GridBeAttack(String[][] board, int x, int y, String side)
    {
        for(int i = 0; i < BOARDSIZE; i++)
        {
            for(int j = 0; j < BOARDSIZE; j++)
            {
                if(board[i][j].contains(side) && CanMove(board, i, j, x, y, side))
                    return true;
            }
        }
        return false;
    }
    public boolean CanCastle(String[][] board, String side, String flag)
    {
        String side2 = "";
        if(side == "white") side2 = "black";
        else side2 = "white";

        if(side == "white")
        {
            if(whitekingMoved == true
                    || board[7][4] == null
                    ||(board[7][4] != null && !board[7][4].contains("white king"))) return false;
            if(flag == "short" &&
                    (white7rookMoved == true || board[7][7] == null ||
                            (board[7][7] != null && !board[7][7].contains("white rook")))) return false;
            if(flag == "long" &&
                    (white0rookMoved == true || board[7][0] == null ||
                            (board[7][0] != null && !board[7][0].contains("white rook")))) return false;
        }else if(side == "black")
        {
            if(blackkingMoved == true
                    || board[0][4] == null
                    ||(board[0][4] != null && !board[0][4].contains("black king"))) return false;
            if(flag == "short" && (black7rookMoved == true || board[0][7] == null ||
                    (board[0][7] != null && !board[0][7].contains("black rook")))) return false;
            if(flag == "long" && (black7rookMoved == true || board[0][0] == null ||
                    (board[0][0] != null && !board[0][0].contains("black rook")))) return false;
        }else return false;

        int row;
        if(side == "white") row = 7;
        else row = 0;

        if(flag == "long")
        {
            for(int i = 1; i < 4; i++)
            {
                if(board[row][i] != "") return false;
            }
            for(int i = 0; i < 5; i++)
            {
                if(GridBeAttack(board, row, i, side2)) return false;
            }
        }else
        {
            for(int i = 5; i < BOARDSIZE - 1; i++)
            {
                if(board[row][i] != "") return false;
            }
            for(int i = 4; i < BOARDSIZE; i++)
            {
                if(GridBeAttack(board, row, i, side2)) return false;
            }
        }
        return true;
    }
}
