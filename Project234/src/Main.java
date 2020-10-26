public class Main {
    public static void main(String[] args) {
//        Project2 project2 = new Project2();
//        String test = "Hello, world";
//        String test2 = "Hello, world.dlrowolleH";
//        System.out.println(project2.isPalindrome(test));
//        System.out.println(project2.isPalindrome(test2));
//        Project3 project3 = new Project3();
//        int[] array = {10,1,2,7,6,1,5};
//        System.out.println(project3.solution(array));

        Project4 project4 = new Project4();
        String[][] board = new String[][]
                {
                        {"black rook", "black knight", "black bishop", "black queue", "black king", "black bishop", "black knight", "black rook"},
                        {"black pawn", "black pawn", "black pawn", "black pawn", "black pawn", "black pawn", "black pawn", "black pawn"},
                        {"","","","","","","",""},
                        {"","","","","","","",""},
                        {"","","","","","","",""},
                        {"","","","","","","",""},
                        {"white pawn", "white pawn", "white pawn", "white pawn", "white pawn", "white rook", "", "white pawn"},
                        {"white rook", "", "", "", "white king", "", "white pawn", "white rook"}
                };
        // side(piece color): black or white; flag(long castling or short castling): long or short
        System.out.println(project4.CanCastle(board, "white", "short"));
    }
}
