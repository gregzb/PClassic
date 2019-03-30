def eniac_accumulating(a):
    """

    :param a: list of length n + 1, which represents an n digit 0-padded positive integer
    :return: a, incremented by 1
    """

    carry = 1
    for i in xrange(1, len(a) + 1):
        add = a[-i] + carry
        a[-i] = add % 10
        carry = add / 10

    return a


def parse_file_and_call_function():
    with open("ENIACAccumulatingIN.txt", "r") as f:
        for line in f:
            a = [int(digit) for digit in line.split(',')]
            print ','.join([str(digit) for digit in eniac_accumulating(a)])


if __name__ == "__main__":
    parse_file_and_call_function()
