def anagram_tester(word_list):
    """

    :param word_list: list of words
    :return: largest set of words that are all anagrams in alphabetical order
    """

    sorted_to_anagrams = {}  # sorted word -> set of words

    for word in word_list:
        sorted_word = ''.join(sorted(list(word)))
        if sorted_word not in sorted_to_anagrams:
            sorted_to_anagrams[sorted_word] = set()
        sorted_to_anagrams[sorted_word].add(word)

    max_length_list = max(sorted_to_anagrams.values(), key=lambda v: len(v))
    return sorted(max_length_list)


def parse_file_and_call_function():
    with open("TreasonsIN.txt", "r") as f:
        line = f.readline()
        test_cases = line.split('|')
        for test_case in test_cases:
            test_case = [s for s in test_case.split(' ') if len(s.strip()) > 0]
            if len(test_case) > 0:
                ans = anagram_tester(test_case)
                print '[{}]'.format(', '.join(ans))


if __name__ == "__main__":
    parse_file_and_call_function()
