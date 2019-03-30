def draw_dot_matrix_letter(N):
    letter = ""
    #STUBIFY
    for i in range(N):
        if i == 0 or i == int(N / 2):
            letter += "X" * (N - 1)
        elif i < N / 2:
            letter += "X" + ("_" * (N - 3)) + "X"
        else:
            letter += "X" + ("_" * (N - 2))
        letter += "\n"
    #ENDSTUBIFY
    return letter

if __name__ == "__main__":
    with open("DotMatrixCheckerIN.txt", "r") as f:
        while True:
            s = f.readline()
            if s == '':
                break
            N = int(s)
            print(draw_dot_matrix_letter(N))
