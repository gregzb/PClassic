# @param matrix, a list of lists of integers
# @return a list of integers
def spiralOrder(matrix):
    solution = []
    # STUBIFY
    if len(matrix)==0:
        return solution
    minRow = 0
    maxRow = len(matrix)-1
    minCol = 0 
    maxCol = len(matrix[0])-1
    row = 0
    col = 0
    state = 1
    if col == maxCol:
        state = 2
    while len(solution)<len(matrix) * len(matrix[0]):
        solution.append(matrix[row][col])
        if state == 1:
            col += 1
            if col == maxCol:
                state = 2
                minRow += 1
        elif state ==2:
            row += 1
            if row == maxRow:
                state = 3
                maxCol -= 1
        elif state ==3:
            col -= 1
            if col == minCol:
                state = 4
                maxRow -=1
        else:
            row -= 1
            if row == minRow:
                state = 1
                minCol += 1
    # ENDSTUBIFY
    return solution

## DO NOT MODIFY THIS FUNCTION
with open('UnlockAllSafesIN.txt', 'r') as f:
    p = 0
    lines = f.read().split("\n")
    while p < len(lines):
        if lines[p] == '':
            break
        n = int(lines[p])
        a = []
        p = p + 1
        for i in range(n):
            a.append(map(lambda x: int(x), lines[p].split(" ")))
            p = p + 1
        ans = spiralOrder(a)
        print (' '.join(map(lambda x: str(x), ans)))

