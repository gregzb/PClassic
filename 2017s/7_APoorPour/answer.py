inputFile = open('input.txt')
lines = list(map(lambda x: list(map(int, x.strip().split(' '))), inputFile.readlines()))
inputFile.close()

def getBound(line, index):
    before = max(line[:index]) if len(line[:index]) > 0 else 0
    after = max(line[index:]) if len(line[index:]) > 0 else 0

    return min(before, after)

#print(getBound(lines[0], 1))

for line in lines:
    total = 0
    for index in range(1, len(line)):
        total += (5 * getBound(line, index))
        extra = (getBound(line, index) - line[index])
        extra = max(extra, 0)
        if index != (len(line) - 1):
            total += extra
    print(total)