def longest_path(grid):
    N = len(grid)
    ans = 0
    #STUBIFY
    lookup = dict()
    dp = [0 for i in range(N * N)]
    for j in range(N):
        for i in range(N):
            lookup[grid[i][j]] = (i, j)
    delta = [(1, 0, 1), (0, 1, N), (-1, 0, -1), (0, -1, -N)]
    for i in range(N*N):
        x, y = lookup[i + 1]
        c = y * N + x
        dp[c] = 1
        for (dx,dy,dc) in delta:
            nx, ny = x + dx, y + dy
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            dp[c] = max(dp[c], dp[c + dc] + 1)

    ans = max(dp)
    #ENDSTUBIFY
    return ans

import time

if __name__ == "__main__":
    start = time.time()
    with open("GetawayPathIN.txt", "r") as f:
        while True:
            s = f.readline()
            if s == "":
                break
            N = int(s)
            grid = []
            for i in range(N):
                row = f.readline()
                grid.append([int(x) for x in row.split(" ")])
            print(longest_path(grid))
    end = time.time()
    print("took " + str(end-start) + "s")
