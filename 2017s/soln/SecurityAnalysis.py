def longest_common_substring (letter, s1, s2):
	max = 0
	lcs = ""
	for idx1 in range(1, len(s1) + 1):
		for idx2 in range(len(s1) + 1 - idx1):
			s = s1[idx2: idx2 + idx1]
			if s in s2:
				if s[0] == letter and max < len(s):
					max = len(s)
					lcs = s
	return lcs

def parse_file_and_call_function():
	with open ("SecurityAnalysisIN.txt", "r") as f:
		while True:
			letter = f.readline().strip()
			s1 = f.readline().strip()
			s2 = f.readline().strip()
			if letter == '' or s1 == '' or s2 == '':
				break
			print longest_common_substring(letter, s1, s2)

if __name__ == '__main__':
    parse_file_and_call_function()