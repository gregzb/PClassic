input = open('input.txt')
lines = input.readlines()
lines = list(map(lambda x: list(map(int, x.strip().split(' '))), lines))
input.close()

for i in range(0, len(lines), 2):
    toDistrib = lines[i][0]
    values = lines[i+1]

    distribs = []

    def distribute(possibleDistrib):
        if sum(possibleDistrib) == toDistrib:
            distribs.append(possibleDistrib.copy())
        elif sum(possibleDistrib) < toDistrib:
            for val in values:
                newList = possibleDistrib.copy();
                newList.append(val)
                distribute(newList)

    distribute([])
    #distribs = set(distribs)

    noDupes = []

    for distrib in distribs:
        if sorted(distrib) not in noDupes:
            noDupes.append(sorted(distrib))

    print (len(noDupes))