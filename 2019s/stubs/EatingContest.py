def winner(scores):
    pass

#Do not modify below this line
if __name__ == '__main__':
    with open('EatingContestIN.txt', 'r') as f:
        while True:
            input = f.readline().strip() # read input
            if input == '':
                break
            scores = [int(x) for x in input.split(' ')] # parse to int
            print(winner(scores))
