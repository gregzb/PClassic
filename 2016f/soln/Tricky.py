from math import floor


def pythagorean_triples(c):
    """

    :param c: the length of the aqueduct you want to construct.
    :return: a list containing all possible configurations of the other two
             sides that are of positive integer length. Output each
             configuration as a separate element in a list in the format a b
             where a is in ascending order and b is in descending order in
             respect to the other configurations.
    """

    output = []

    c_squared = c**2
    for a in xrange(1, c):
        a_squared = a * a
        b_squared = c_squared - a_squared
        b = b_squared**0.5
        if b == floor(b):
            b = int(b)
            output.append(a)
            output.append(b)
    return output


def parse_file_and_call_function():
    with open("TrickyIN.txt", "r") as f:
        for line in f:
            print list(pythagorean_triples(int(line)))


if __name__ == "__main__":
    parse_file_and_call_function()
