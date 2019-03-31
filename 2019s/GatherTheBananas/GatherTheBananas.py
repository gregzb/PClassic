def makeCircle(points):
    minX = points[0][0]
    minY = points[0][1]
    maxX = points[0][0]
    maxY = points[0][1]

    for point in points:
        minX = min(minX, point[0])
        minY = min(minY, point[1])
        maxX = max(maxX, point[0])
        maxY = max(maxY, point[1])

    midpoint = ((minX + maxX) / 2, (minY + maxY) / 2)

    maxSqrDist = 0

    for point in points:
        maxSqrDist = max(maxSqrDist, (point[0] - midpoint[0]) ** 2 + (point[1] - midpoint[1]) ** 2)

    return (midpoint[0], midpoint[1], maxSqrDist ** (1/2))

#Do not modify below this line
if __name__ == '__main__':
    with open('GatherTheBananasIN.txt', 'r') as f:
        while True:
            s = f.readline().strip()
            if s == '':
                break
            A = []
            for i in range(int(s)):
                t = f.readline().strip()
                x, y = t.strip('()').split(',')
                A.append((float(x), float(y)))
            c = makeCircle(A)
            cNew = (round(c[0], 3), round(c[1], 3), round(c[2], 3))
            print(cNew)
