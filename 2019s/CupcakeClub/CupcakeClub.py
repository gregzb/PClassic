missing = []

def solve(mesg1, mesg2):
    global missing
    missing = missingLetters(mesg1, mesg2)
    return solve2(mesg1, mesg2, 0, 0)

def missingLetters(mesg1, mesg2):
    myList = [letter for letter in mesg2]
    return myList
    
def solve2(mesg1, mesg2, steps, currentPos):
    #print("yikes", steps, currentPos, mesg1, mesg2)

    if mesg1 == mesg2:
        #print ("yikesish", steps, mesg1, mesg2)
        return steps

    minSteps = 999999999

    if currentPos >= len(mesg1):
        return minSteps

    if (len(mesg1) != len(mesg2)):

        if (len(mesg1) < len(mesg2)):
            for i in range(len(mesg1) + 1):
                for letter in missing:
                    minSteps = min(minSteps, solve2(mesg1[:i] + letter + mesg1[i:], mesg2, steps + 1, currentPos))
        if (len(mesg1) > 0):
            for i in range(len(mesg1)):
                minSteps = min(minSteps, solve2(mesg1[:i] + mesg1[i+1:], mesg2, steps + 1, currentPos))
    else:
        numDiff = 0
        for i in range(len(mesg1)):
            if mesg1[i] != mesg2[i]:
                numDiff+=1
        return steps + numDiff
        # if mesg1[currentPos] == mesg2[currentPos]:
        #     minSteps = min(minSteps, solve2(mesg1, mesg2, steps, currentPos + 1))
        # else:
        #     for letter in missing:
        #         minSteps = min(minSteps, solve2(mesg1[:currentPos] + letter + mesg1[currentPos+1:], mesg2, steps + 1, currentPos+1))
    return minSteps

#Do not modify below this line
if __name__ == '__main__':
    with open('CupcakeClubIN.txt', 'r') as f:
        while True:
            s = f.readline().strip()
            if s == '':
                break
            for i in range(int(s)):
                sa = f.readline().strip().split(" ")
                print(solve(sa[0], sa[1]))
