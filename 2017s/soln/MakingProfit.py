def max_profit(matrix):
    result = 0
    max = 0
    for x in range(0, 7):
        currSum = 0
        for y in range(0, len(matrix[x])):
            currSum = currSum + matrix[x][y]
        if currSum > max:
            max = currSum
            result = x

    if result == 0:
        return "Monday"
    elif result == 1:
        return "Tuesday"
    elif result == 2:
        return "Wednesday"
    elif result == 3:
        return "Thursday"
    elif result == 4:
        return "Friday"
    elif result == 5:
        return "Saturday"
    elif result == 6:
        return "Sunday"


"""FILE PARSING - DO NOT MODIFY"""


def parse_file_and_call_function():
    with open("MakingProfitIN.txt", "r") as f:
        while True:
            n = f.readline()
            if n == "":
                break
            m = f.readline()
            arr = []
            for x in range(0, 7):
                s = f.readline()
                s = s.strip()
                sArr = s.split(" ")
                input = []
                for y in range(0, len(sArr)):
                    input.append(int(sArr[y]))
                arr.append(input)
            print max_profit(arr)


if __name__ == "__main__":
    parse_file_and_call_function()