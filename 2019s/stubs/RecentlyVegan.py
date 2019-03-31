def solve(n, A):
    pass

#Do not modify below this line
if __name__ == '__main__':
    with open('RecentlyVeganIN.txt', 'r') as f:
        while True:
            s = f.readline().strip()
            if s == '':
                break
            t = f.readline().strip().split(", ")
            print(solve(int(s), t))
