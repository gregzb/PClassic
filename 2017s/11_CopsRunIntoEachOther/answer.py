def getEvenSubarrays(blocks):
    W = len(blocks[0])
    H = len(blocks)

    print(W, H)
    for row in blocks:
        print(row)

    total = 0

    combos = 0

    for y in range(H):
        for x in range(W):
            maxWidth = W - x
            maxHeight = H - y
            #print(x, y)
            for w1 in range(1, maxWidth + 1):
                for h1 in range(1, maxHeight + 1):
                    # x, y, w, h
                    total += 1 if sumIsEven(blocks, x, y, w1, h1) else 0
                    combos += 1
    print("combos:", combos)
    return total


def sumIsEven(blocks, x, y, w, h):
    total = 0
    for x1 in range(x, x + w):
        for y1 in range(y, y + h):
            total += blocks[y1][x1]

    #print(x, y, w, h, ":", total)
    return total % 2 == 0

with open('input.txt', 'r') as f:
    lines = list(map(lambda x: list(map(int, x.strip().split(' '))), f.readlines()))


    data = []

    i = 0
    while i < len(lines[:107107]):
        width = lines[i][0]
        height = lines[i][1]

        newData = [[lines[y * width + x + i + 1][0] for x in range(width)] for y in range(height)]
        data.append(newData)

        i += width * height + 1

    # count = 0
    #
    # for y in range(3):
    #     for x in range(2):
    #         for h in range(1,3-y+1):
    #             for w in range(1, 2-x+1):
    #                 print(x, y, w, h)
    #                 count += 1
    #
    # print (count)

    for dat in data[4:5]:
        print(getEvenSubarrays(dat))
