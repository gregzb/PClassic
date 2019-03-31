def minDishes(num_islands, bridges):
    pass

#Do not modify below this line
if __name__ == '__main__':
    with open('PicnicDayIN.txt', 'r') as f:
        cases = int(f.readline().strip())
        for case in range(cases):
            num_islands = int(f.readline().strip())
            bridges = []
            for i in range(num_islands - 1):
                bridges.append(f.readline().strip().split())
            bridges = [[int(a), int(b)] for [a,b] in bridges]
            print(minDishes(num_islands, bridges))
