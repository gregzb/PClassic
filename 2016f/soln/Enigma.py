def is_first_random(s1, s2):
    ans = True
    #STUBIFY
    import math

    SUB = 6

    def log_fact(n):
        ret = 0.0
        for i in range(n):
            ret += math.log(i + 1)
        return ret

    def log_likelihood(dist):
        s = sum(dist)
        l = len(dist)
        ll = 0.0
        ll += log_fact(s)
        for i in dist:
            ll -= log_fact(i)
        ll -= s * math.log(l) / math.log(2)
        return ll

    def calc_count(line):
        count = [0 for i in range(2 ** SUB)]
        for s in [line[i:i+SUB] for i in range(0, len(line) - 1, SUB)]:
            idx = int(s, 2)
            if idx < 2 ** SUB and idx >= 0:
                count[idx] += 1
        return count

    ans = log_likelihood(calc_count(s1)) > log_likelihood(calc_count(s2))
    #ENDSTUBIFY
    if ans:
        return "random"
    else:
        return "nonrandom"

if __name__ == "__main__":
    with open("EnigmaIN.txt", "r") as f:
        while True:
            s1 = f.readline()
            if s1 == '':
                break
            s2 = f.readline()
            s1 = s1[:-1]
            s2 = s2[:-1]
            print(is_first_random(s1, s2))
