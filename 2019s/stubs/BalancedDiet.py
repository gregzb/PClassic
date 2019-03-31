def is_balanced(str):
    pass

#Do not modify below this line
if __name__ == '__main__':
    with open('BalancedDietIN.txt', 'r') as f:
        n = int(f.readline().strip())
        while True:
            str = f.readline().strip() # read input
            if str == '':
                break
            print(is_balanced(str))
