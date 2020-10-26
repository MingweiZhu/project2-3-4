# project2-3-4
Practical interview Project
Project 2: in the project2, i make the programmer that can check the input String is Palindrome or not. it ignore the special sign like:!@#$%^.. and Ignore case
Test case: "Hello, world" return false; "Hello, world.dlrowolleH" return true;

Project 3: in the project3, i make the programmer that can find all unique combinations in input array where the array numbers sum to 10. Each number in array  only be used once in the combination. and the answer not contain duplicate combinations.
Test case: int[] array = {10,1,2,7,6,1,5}  return [[1, 1, 2, 6], [1, 2, 7], [10]]; 

Project 4: in the project4, i make the programmer that implement different methods for the different type of chese move rule and can check the king and rook are in the correct positions for castling.
Test case: {
                        {"black rook", "black knight", "black bishop", "black queue", "black king", "", "black knight", "black rook"},
                        {"black pawn", "black pawn", "black pawn", "black pawn", "black pawn", "black pawn", "black pawn", "black pawn"},
                        {"","","","","","","",""},
                        {"","","","","","","",""},
                        {"","","","","","","",""},
                        {"","","","","","","","black bishop"},
                        {"white pawn", "white pawn", "white pawn", "white pawn", "white pawn", "white rook", "", "white pawn"},
                        {"white rook", "", "", "", "white king", "", "", "white rook"}
                };
                return bishop can cut7 5; false
                
                {
                        {"black rook", "black knight", "black bishop", "black queue", "black king", "black bishop", "black knight", "black rook"},
                        {"black pawn", "black pawn", "black pawn", "black pawn", "black pawn", "black pawn", "black pawn", "black pawn"},
                        {"","","","","","","",""},
                        {"","","","","","","",""},
                        {"","","","","","","",""},
                        {"","","","","","","",""},
                        {"white pawn", "white pawn", "white pawn", "white pawn", "white pawn", "white rook", "", "white pawn"},
                        {"white rook", "", "", "", "white king", "", "", "white rook"}
                };
                return true;
                
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
                return false;
