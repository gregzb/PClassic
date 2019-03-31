def makeCircle(points):
    pass

#Do not modify below this line
if __name__ == '__main__':
    with open('GatherTheBananasIN.txt', 'r') as f:
        while True:
            s = f.readline().strip()
            if s == '':
                break
            A = []
            for i in range(int(s)):
                t = f.readline().strip()
                x, y = t.strip('()').split(',')
                A.append((float(x), float(y)))
            c = makeCircle(A)
            cNew = (round(c[0], 3), round(c[1], 3), round(c[2], 3))
            print(cNew)
