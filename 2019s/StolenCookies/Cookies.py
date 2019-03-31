stack = []

def evaluate(subExpr):
    pass

def solve(expr):
    for letter in expr:
        if letter == '(':
            stack.append([])
        elif letter == ')':
            val = evaluate(stack[-1])
            stack.pop()
            stack.append(val)
        elif letter in '0123456789':
            stack.append(int(letter))
        elif letter == 'T':
            stack.append(True)
        elif letter == 'F':
            stack.append(False)
        elif letter in '<>=':
            stack.append(letter)
        elif letter == ':':
            stack.append(letter)
        elif letter == '?':
            stack.append(letter)



#Do not modify below this line
if __name__ == '__main__':
    with open('CookiesIN.txt', 'r') as f:
        T = int(f.readline().strip())
        for t in range(T):
            print(solve(f.readline().strip()))