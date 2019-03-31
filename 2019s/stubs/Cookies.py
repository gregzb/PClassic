def solve(expr):
    pass
 
#Do not modify below this line
if __name__ == '__main__':
    with open('CookiesIN.txt', 'r') as f:
        T = int(f.readline().strip())
        for t in range(T):
            print(solve(f.readline().strip()))