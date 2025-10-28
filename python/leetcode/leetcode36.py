from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for i in range(9):
            seen = set()
            for j in range(9):
                if board[i][j] == '.':
                    continue
                if board[i][j] in seen:
                    return False
                else:
                    seen.add(board[i][j])

        for i in range(9):
            seen = set()
            for j in range(9):
                if board[j][i] == '.':
                    continue
                if board[j][i] in seen:
                    return False
                else:
                    seen.add(board[j][i])

        for i in range(9):
            seen = set()
            for x in range(3):
                for y in range(3):
                    ax = (i // 3) * 3 + x
                    ay = (i % 3) * 3 + y
                    if board[ax][ay] == '.':
                        continue
                    if board[ax][ay] in seen:
                        return False
                    else:
                        seen.add(board[ax][ay])
        return True

    # bitmask
    def isValidSudoku2(self, board: List[List[str]]) -> bool:
        rows = [0] * 9
        cols = [0] * 9
        squares = [0] * 9

        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    continue
                val = int(board[i][j]) - 1
                if (1<<val) & rows[i]:
                    return False
                if (1<<val) & cols[j]:
                    return False
                if (1<<val) & squares[(i//3) * 3 + (j//3)]:
                    return False

                rows[i] |= (1<<val)
                cols[j] |= (1<<val)
                squares[(i//3) * 3 + (j//3)] |= (1<<val)

            return True


if __name__ == "__main__":
    s = Solution()
    print(s.isValidSudoku([["5","3",".",".","7",".",".",".","."]
                              ,["6",".",".","1","9","5",".",".","."]
                              ,[".","9","8",".",".",".",".","6","."]
                              ,["8",".",".",".","6",".",".",".","3"]
                              ,["4",".",".","8",".","3",".",".","1"]
                              ,["7",".",".",".","2",".",".",".","6"]
                              ,[".","6",".",".",".",".","2","8","."]
                              ,[".",".",".","4","1","9",".",".","5"]
                              ,[".",".",".",".","8",".",".","7","9"]]))
