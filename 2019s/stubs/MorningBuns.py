def message_reveal(matrix):
    pass

#Do not modify below this line
if __name__ == '__main__':
    with open('MorningBunsIN.txt', 'r') as f:
        num_test_cases = int(f.readline().strip())
        for i in range(num_test_cases):
            side_length = int(f.readline().strip())
            matrix = []
            for j in range(side_length):
                matrix.append(list(f.readline().strip()))
            print(message_reveal(matrix))
