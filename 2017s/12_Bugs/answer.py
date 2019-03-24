def bugs(numAccounts, transactions):
    accounts = [[] for x in range(numAcounts)]
    return

with open('BugsIN.txt', 'r') as f:
    lines = list(map(lambda x: tuple(map(int, x.strip().split(' '))), f.readlines()))

    data = []

    i = 0
    while i < len(lines):
        numAcounts = lines[i][0]
        numTransactions = lines[i][1]

        newData = lines[i + 1:i + numTransactions + 1]
        data.append((numAcounts, newData))

        i += numTransactions + 1

    print(data[0])

    for dat in data[:]:
        bugs(dat[0], dat[1])
