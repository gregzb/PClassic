def poor_pour(arr):
    left = []
    right = []
    sum = 0

    lastValue = arr[0]
    left.append(0)

    for x in range(1, len(arr)):
        left.append(lastValue)

        if arr[x] > lastValue:
            lastValue = arr[x]

        left.append(lastValue - arr[x])

    lastValue = arr[len(arr) - 1]
    right.append(0)

    for x in range(1, len(arr)):
        right.append(lastValue)

        if arr[len(arr) - 1 - x] > lastValue:
            lastValue = arr[len(arr) - 1 - x]

        right.append(lastValue - arr[len(arr) - 1 - x])

    for x in range(0, len(left)):
        if x % 2 == 0:
            #print min(left[x], right[len(right) - 1 - x])
            sum = sum + min(left[x], right[len(right) - 1 - x])
        else:
            #print 5*min(left[x], right[len(right) - 1 - x])
            sum = sum + 5*min(left[x], right[len(right) - 1 - x])

    return sum

"""FILE PARSING - DO NOT MODIFY"""



def parse_file_and_call_function():
    with open("PoorPourIN.txt", "r") as f:
        while True:
            s = f.readline()
            if s == "":
                break
            s = s.strip()
            sArr = s.split(" ")
            input = []

            for x in range(0, len(sArr)):
                input.append(int(sArr[x]))

            print poor_pour(input)

if __name__ == "__main__":
    parse_file_and_call_function()