def tripleBears(arr):
    pass

#Do not modify below this line
if __name__ == '__main__':
    with open('TripleBearsIN.txt', 'r') as f:
        cases = int(f.readline().strip())
        for case in range(cases):
            arr = [int(i) for i in f.readline().strip().split()]
            print(tripleBears(arr))
