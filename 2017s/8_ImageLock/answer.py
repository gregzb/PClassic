inputFile = open('ImageLockIN.txt')
lines = list(map(lambda x: list(map(int, x.strip().split(' '))), inputFile.readlines()))
inputFile.close()

data = []

i = 0
while i < len(lines):
    height = lines[i][1]

    newData = lines[i+1:i+height+1]
    data.append(newData)

    i += height + 1

for dat in data:
    totalCells = len(dat) * len(dat[0])
    greaterThanX = 0
    for row, v1 in enumerate(dat[:-1]):
        for column, v2 in enumerate(v1[:-1]):
            diff = abs(dat[row][column] - dat[row + 1][column + 1])
            #diffs.append(diff)
            #total += diff
            greaterThanX += 1 if diff > 30 else 0
    print('cat' if greaterThanX/totalCells < 0.3 else 'random')