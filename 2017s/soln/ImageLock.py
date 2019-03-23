def isCat(img):
    numagrees = 0
    W = len(img)
    H = len(img[0])
    for x in range(1,(W-1)//2):
        for y in range(1,(H-1)//2):
            c = 0
            for (i, j) in [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]:
                if abs(img[x][y] - img[x+i][y+j]) < 5:
                    c = c + 1
            if c >= 4:
                numagrees = numagrees + 1
    return numagrees/float(W*H//4) > 0.01 




if __name__ == "__main__":
    with open("ImageLockIN.txt", "r") as f:
        while True:
            s = f.readline()
            if s == "":
                break
            s = s.split(" ")
            W = int(s[0])
            H = int(s[1])
            img = [ [ 0 for i in range(H) ] for j in range(W) ]
            for y in range(H):
                s = f.readline()
                s = s.split(" ")
                for x in range(W):
                    img[x][y] = int(s[x])

            if isCat(img):
                print('cat')
            else:
                print('random')



