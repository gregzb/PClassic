
## This is for you to fill out. 
def get_solution(num):
	count = 0
	for a in range(1, n + 1):
		for b in range(1, n + 1):
			for c in range(1, n + 1):
				for d in range(1, n + 1):
					if a*b - c*d == 1:
						count = count + 1
	return count


with open('CardinalConfusionIN.txt') as f:
	nums = f.read().split("\n")
	for num in nums:
		if num != '':
			n = int(num)
			count = get_solution(n)
			print (count)
