def getSolutionA(board):
    return getSolution(board.copy(), (0, 0))

def getSolution(board, currentPos):

    nums = []
    for row in board:
        for val in row:
            nums.append(val)

    if 0 not in nums:
        return board

    if board[currentPos[1]][currentPos[0]] != 0:
        newPos = (currentPos[0], currentPos[1]+1)
        if newPos[1] > 8:
            newPos = (newPos[0]+1, 0)
        if newPos[0] < 9:
            sol = getSolution(board.copy(), newPos)
            if sol is not None:
                return sol

    else:
        valid = validNums(board, currentPos)
        for num in [1,2,3,4,5,6,7,8,9]:
            newBoard = [rip.copy() for rip in board]
            newBoard[currentPos[1]][currentPos[0]] = num
            if verifyRow(newBoard, currentPos) and verifyColumn(newBoard, currentPos):
                sol = getSolution(newBoard, currentPos)
                if sol is not None:
                    return sol

def validNums(board, position):
    zeroed = (position[0] - (position[0]%3), position[1] - (position[1]%3))

    miniBoard = []

    for row in board[zeroed[1] : zeroed[1] + 3]:
        miniBoard.append(row[zeroed[0]:zeroed[0] + 3])

    nums = [1,2,3,4,5,6,7,8,9]

    for row in miniBoard:
        for val in row:
            if val != 0:
                nums.remove(val)

    return nums

def verifyRow(board, position):
    nums = []
    for val in board[position[1]]:
        if val in nums:
            return False
        else:
            if val != 0:
                nums.append(val)
    return True

def verifyColumn(board, position):
    nums = []
    for row in board:
        val = row[position[0]]
        if val in nums:
            return False
        else:
            if val != 0:
                nums.append(val)
    return True


with open('SudokuSolverIN.txt') as f:
    lines = list(map(lambda x: x.strip().split(' '), f.readlines()))

    boards = []

    tempBoard = []

    for line in lines:
        if line != ['']:
            tempBoard.append(list(map(int, line)))
        else:
            boards.append(tempBoard.copy())
            tempBoard.clear()
    #
    # for row in tempBoard.copy():
    #     print(row)
    #
    # print ('yeeet')

    boards.append(tempBoard.copy())
    tempBoard.clear()

    for board in boards:
        sol = getSolutionA(board)
        if sol is None:
            print(sol)
        else:
            for row in sol:
                print (row)

        print()
