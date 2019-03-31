def solve(mesg1, mesg2):
    pass

#Do not modify below this line
if __name__ == '__main__':
    with open('CupcakeClubIN.txt', 'r') as f:
        while True:
            s = f.readline().strip()
            if s == '':
                break
            for i in range(int(s)):
                sa = f.readline().strip().split(" ")
                print(solve(sa[0], sa[1]))
