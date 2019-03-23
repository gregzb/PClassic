def clockwiseOrder(points):

    H = len(points)
    W = len(points[0])

    dir = [0, 1]
    pos = [0, 0]
    visited = []
    order = ""
    while True:
        visited.append((pos[0], pos[1]))
        order += str(points[pos[0]][pos[1]]) + " "
        pos[0] += dir[0]
        pos[1] += dir[1]

        if ((pos[0] == 0 or pos[0] == W-1) and (pos[1] == 0 or pos[1] == H-1)) or (pos[0] + dir[0], pos[1] + dir[1]) in visited:
            dir[0], dir[1] = dir[1], -dir[0]

        if len(visited) == W * H:
            break
    return order

with open('input.txt', 'r') as f:
    lines = list(map(lambda x: list(map(int, x.strip().split(' '))), f.readlines()))

    data = []

    i = 0
    while i < len(lines):
        height = lines[i][0]

        newData = lines[i + 1:i + height + 1]
        data.append(newData)

        i += height + 1

    for dat in data:
        print(clockwiseOrder(dat))
