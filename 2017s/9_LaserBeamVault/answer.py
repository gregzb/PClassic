import itertools

inputFile = open('input.txt')
lines = list(map(lambda x: list(map(int, x.strip().split(' '))), inputFile.readlines()))
inputFile.close()

data = []

i=0
while i < len(lines):
    height = lines[i][0]

    newData = lines[i+1:i+height+1]
    data.append(newData)

    i += height + 1

for dat in data:
    diagonals = {}
    parallelograms = 0
    for i, point1 in enumerate(dat):
        for point2 in dat[i+1:]:
            added = (point1[0] + point2[0], point1[1] + point2[1])
            if added in diagonals:
                parallelograms += diagonals[added]
                diagonals[added] += 1
            else:
                diagonals[added] = 1
    print(parallelograms)
