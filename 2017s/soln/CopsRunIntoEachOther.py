def countEvenArrays(matrix):
	input_arr = []

	print(matrix)

	for i in range(len(matrix) + 1):
		input_arr.append([])
		for j in range(len(matrix[0]) + 1):
			input_arr[i].append(0)

	print(input_arr)

	for i in range(1, len(input_arr)):
		for j in range(1, len(input_arr[0])):
			input_arr[i][j] = (input_arr[i-1][j] + input_arr[i][j-1] + input_arr[i-1][j-1] + matrix[i-1][j-1]) % 2

	print(input_arr)

	count = 0

	if len(input_arr) < len(input_arr[0]):
		for i in range(len(input_arr)):
			for j in range(i):
				c1 = 0
				c2 = 0
				for k in range(len(input_arr[0])):
					if input_arr[i][k] == input_arr[j][k]:
						c1 = c1 + 1
					else:
						c2 = c2 + 1
				count = count + (c1 * (c1 - 1)) / 2 + (c2 * (c2 - 1)) / 2
	else:
		for i in range(len(input_arr[0])):
			for j in range(i):
				c1 = 0
				c2 = 0
				for k in range(len(input_arr)):
					if input_arr[k][i] == input_arr[k][j]:
						c1 = c1 + 1
					else:
						c2 = c2 + 1
				count = count + (c1 * (c1 - 1)) / 2 + (c2 * (c2 - 1)) / 2
	return count


with open("CopsRunIntoEachOtherIN.txt") as f:
	p = 0
	lines = f.read().split("\n")
	
	while p < len(lines):
		if lines[p] == '':
			break
		nums = lines[p].split(" ")
		p = p + 1
		m, n = int(nums[0]), int(nums[1])
		matrix = []

		for i in range(m):
			matrix.append([])
			for j in range(n):
				matrix[i].append(0)

		for i in range(m):
			for j in range(n):
				if lines[p] == '':
					continue
				matrix[i][j] = int(lines[p])
				p = p + 1

		print (countEvenArrays(matrix))
		break
	