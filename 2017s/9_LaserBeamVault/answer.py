import itertools

inputFile = open('input.txt')
lines = list(map(lambda x: list(map(int, x.strip().split(' '))), inputFile.readlines()))
inputFile.close()

data = []

i=0
while i < len(lines):
    height = lines[i][0]

    newData = lines[i+1:i+height]
    data.append(newData)

    i += height + 1

for dat in data:
    slopes = []
    for i, point1 in enumerate(dat[:-1]):
        for point2 in dat[i+1:]:
            val = 0
            if point2[0]-point1[0] == 0:
                val = None
            else:
                val = (point2[1]-point1[1])/(point2[0]-point1[0])
            slopes.append(val)
    #print (slopes)