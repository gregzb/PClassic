from ast import literal_eval

def getNext(points, index):
    index += 1
    index %= len(points)
    return points[index]

def xOf(point):
    return point[0]

def yOf(point):
    return point[1]

def in_perimeter(points, new_point):
    numIntersects = 0
    for i, point in enumerate(points):
        nextPoint = getNext(points, i)
        minXPoint, maxXPoint = (point, nextPoint) if xOf(point) < xOf(nextPoint) else (nextPoint, point)

        if (yOf(point) > yOf(new_point) and yOf(nextPoint) > yOf(new_point) or yOf(point) < yOf(new_point) and yOf(nextPoint) < yOf(new_point)):
            continue
        elif yOf(point) == yOf(new_point) == yOf(new_point) and xOf(minXPoint) < xOf(new_point) < xOf(maxXPoint):
            numIntersects += 1
            continue
        elif new_point == nextPoint or new_point == point:
            numIntersects += 1
            continue
        else:
            # slope = (yOf(maxXPoint)-yOf(minXPoint))/(xOf(maxXPoint) - xOf(minXPoint))
            # xDiff = xOf(point) - xOf(minXPoint)
            # newY = (slope*xDiff) +
            yDiff = yOf(new_point) - yOf(minXPoint)
            totalYDiff = yOf(maxXPoint) - yOf(minXPoint)
            totalXDiff = xOf(maxXPoint) - xOf(minXPoint)
            newX = xOf(minXPoint) + (yDiff / totalYDiff) * totalXDiff

            #print (newX)
            print (str(minXPoint) + " : " + str(maxXPoint))
            print (str(xOf(minXPoint)) + ", " + str(yDiff / totalYDiff) + ", " + str(totalXDiff))

            if newX < xOf(new_point):
                numIntersects += 1

    return numIntersects % 2 == 1

 
#Do not modify below this line
if __name__ == '__main__':
    with open('ExoticOrchardIN.txt', 'r') as f:
        T = int(f.readline().strip())
        for t in range(T):
            new_point = literal_eval(f.readline().strip())
            num_points = int(f.readline().strip())
            existing_points = []
            for i in range(num_points):
                existing_points.append(literal_eval(f.readline().strip()))
            print(existing_points)
            print('1' if in_perimeter(existing_points, new_point) else '0')