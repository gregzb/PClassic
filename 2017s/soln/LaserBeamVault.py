def count_parallelograms(xcoords, ycoords):
    n = len(xcoords)
    midpoints = dict()
    count = 0
    for i in range(n):
        for j in range(i+1, n):
            mid = (xcoords[i] + xcoords[j], ycoords[i] + ycoords[j])
            print(mid)
            if mid in midpoints:
                prevcount = midpoints[mid]
                count = count + prevcount
                midpoints[mid] = prevcount + 1
            else:
                midpoints[mid] = 1
    return count
            

if __name__ == "__main__":
    with open("LaserBeamVaultIN.txt", "r") as f:
        while True:
            s = f.readline()
            if s == "":
                break
            s = s.split(" ")
            N = int(s[0])
            xcoords = []
            ycoords = []
            for i in range(N):
                s = f.readline()
                s = s.split(" ")
                xcoords.append(int(s[0]))
                ycoords.append(int(s[1]))
            print(count_parallelograms(xcoords, ycoords))
