def has_odd_cycle(N, M, edges):
    ans = False
    #STUBIFY
    graph = dict((i, []) for i in range(N))
    revgraph = dict((i, []) for i in range(N))
    for (u, v) in edges:
        graph[u].append(v)
        revgraph[v].append(u)

    component = [-1 for i in range(N)]
    color = [-1 for i in range(N)]
    stack = []

    def dfs(x):
        component[x] = -2
        for i in graph[x]:
            if component[i] == -1:
                dfs(i)
        stack.append(x)
        return

    def dfs2(x, c):
        component[x] = c
        for i in revgraph[x]:
            if component[i] == -2:
                dfs2(i, c)
        return

    def dfs3(x, c, col):
        color[x] = col
        for i in graph[x]:
            if component[i] != c:
                continue
            elif color[i] == -1:
                if dfs3(i, c, 1 - col):
                    return True
            elif color[i] == col:
                return True
        return False

    for i in range(N):
        if component[i] == -1:
            dfs(i)

    for i in reversed(stack):
        if component[i] == -2:
            dfs2(i, i)

    for i in range(N):
        if component[i] == i:
            if dfs3(i, i, 0):
                return True

    #ENDSTUBIFY
    return ans

if __name__ == "__main__":
    with open("BugsIN.txt", "r") as f:
        while True:
            s = f.readline()
            if s == "":
                break
            s = s.split(" ")
            N = int(s[0])
            M = int(s[1])
            edges = []
            for i in range(M):
                edge = f.readline().split(" ")
                edges.append((int(edge[0]), int(edge[1])))
            print("true" if has_odd_cycle(N, M, edges) else "false")
