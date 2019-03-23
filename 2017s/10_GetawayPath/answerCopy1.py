memo = {}

def getMaxRooms(points):
    global memo
    memo.clear()
    W = len(points[0])
    H = len(points)

    maxPaths = 0

    for x in range(W):
        for y in range(H):
            maxPaths = max(maxPaths, getMaxPaths(points, [x,y], 1))

    return maxPaths

dirs = [(1, 0), (0, 1), (-1, 0), (0, -1)]


def getMaxPaths(points, currentPos, pathLength):
    global memo
    tuplePos = (currentPos[0], currentPos[1])
    if tuplePos in memo:
        print()
        print("current pos:", currentPos)
        print("path, memo:", pathLength, memo[tuplePos])
        return max(pathLength, memo[tuplePos])

    W = len(points[0])
    H = len(points)
    currentVal = points[currentPos[1]][currentPos[0]]

    maxPath = pathLength

    #print(maxPath)

    for direction in dirs:
        newPos = [currentPos[0] + direction[0], currentPos[1] + direction[1]]
        if newPos[0] < 0 or newPos[0] > W-1 or newPos[1] < 0 or newPos[1] > H-1:
            continue
        if points[newPos[1]][newPos[0]] < currentVal:
            maxPath = max(maxPath, getMaxPaths(points, newPos, pathLength+1))

    memo[tuplePos] = maxPath

    return maxPath

with open('input.txt', 'r') as f:
    lines = list(map(lambda x: list(map(int, x.strip().split(' '))), f.readlines()))

    data = []

    i = 0
    while i < len(lines):
        height = lines[i][0]

        newData = lines[i + 1:i + height + 1]
        data.append(newData)

        i += height + 1

    for dat in data[1:2]:
        print(getMaxRooms(dat))

