def minimum_stops(M, ships, start, end):
    stops = 0
    #STUBIFY
    V = M + len(ships)
    edges = dict((i, []) for i in range(V))
    for i, route in enumerate(ships):
        for j in route:
            edges[M + i].append(j)
            edges[j].append(M + i)
    from Queue import Queue
    q = Queue()
    dists = [-1 for i in range(V)]

    dists[start] = 0
    q.put(start)
    while not q.empty():
        u = q.get()
        newdist = dists[u] + 1
        for v in edges[u]:
            if dists[v] == -1:
                dists[v] = newdist
                q.put(v)
    if dists[end] == -1:
        return -1
    stops = int(dists[end] / 2 - 1)
    #EMDSTUBIFY
    return stops

if __name__ == "__main__":
    with open("MinimizingIN.txt", "r") as f:
        while True:
            s = f.readline()
            if s == '':
                break
            N, M, S, E = [int(x) for x in s.split()]
            ships = []
            for i in range(N):
                ships.append([int(x) for x in f.readline().split()])
            print(minimum_stops(M, ships, S, E))
