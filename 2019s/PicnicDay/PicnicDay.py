def minDishes(num_islands, bridges):
    pass

#Do not modify below this line
if __name__ == '__main__':
    with open('PicnicDayIN.txt', 'r') as f:
        num_islands = f.readline().strip()
        bridges = []
        for i in range(num_islands - 1):
            bridges.append(f.readline().strip().split())
        print(minDishes(num_islands, bridges))
