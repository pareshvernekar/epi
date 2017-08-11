// Given a 2D board and a word, find if the word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

// For example,
// Given board =

// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.
package revision.graphs;

import java.util.*;

public class TwoDWordSearch {
	
	public boolean wordExists(String input, char[][] board) {

		Boolean found = Boolean.FALSE;
		if (input==null || input.isEmpty())
			return Boolean.FALSE;

		if (board==null || board.length==0)
			return Boolean.FALSE;
		for (int i=0;i<board.length;i++) {
			for (int j=0;j<board[0].length;j++) {
				found=helper(input, 0,i,j,board, new ArrayList<Character>());
				if (found)
					break;
			}
			if (found)
				break;
		}
		return found;
		
	}

	public boolean helper(String word, int pos, int rowPos, int colPos, char[][] board, List<Character> charList) {

		int rowLen = board.length;
		int colLen = board[0].length;
		boolean found = Boolean.FALSE;
		if (charList.size()==word.length())
			return Boolean.TRUE;
		if (rowPos < 0 || rowPos >= rowLen ||
			colPos < 0 || colPos >= colLen || board[rowPos][colPos] != word.charAt(pos)) {
			return Boolean.FALSE;
		}
		if (board[rowPos][colPos] == word.charAt(pos)) {
			charList.add(board[rowPos][colPos]);
			board[rowPos][colPos]=(char)(256+board[rowPos][colPos]);	//don't evaluate the same position again
			found=helper(word, pos+1,rowPos-1,colPos,board,charList) |
				helper(word, pos+1,rowPos+1,colPos,board,charList) |
				helper(word, pos+1,rowPos,colPos-1,board,charList) |
				helper(word, pos+1,rowPos,colPos+1,board,charList);
				board[rowPos][colPos]=(char)(board[rowPos][colPos]-256);	

		}

		return found;

	}

	public static void main(String[] argv) {

		char[][] board = {
							{'A','B','C', 'E'},
							{'S','F','C', 'S'},
							{'A','D','E', 'E'},
						};

		TwoDWordSearch s = new TwoDWordSearch();
		System.out.println(s.wordExists("ABCCED",board));
		System.out.println(s.wordExists("SEE",board));
		System.out.println(s.wordExists("ABCB",board));
	}
}