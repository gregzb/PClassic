def get_crop_amounts(A_water, A_labor, B_water, B_labor, total_water, total_labor):
    A, B = 0, 0
    #STUBIFY
    det = A_water * B_labor - A_labor * B_water
    if det == 0:
        return -1, -1
    A = int((total_water * B_labor - total_labor * B_water) / det)
    B = int((- total_water * A_labor + total_labor * A_water) / det)
    if A < 0 or B < 0:
        return -1, -1
    #ENDSTUBIFY
    return A, B
    
if __name__ == "__main__":
    with open("FastidiousFarmingIN.txt", "r") as f:
        while True:
            s = f.readline()
            if s == '':
                break
            A_water, A_labor = [int(x) for x in s.split(" ")]
            B_water, B_labor = [int(x) for x in f.readline().split(" ")]
            total_water, total_labor = [int(x) for x in f.readline().split(" ")]
            A, B = get_crop_amounts(A_water, A_labor, B_water, B_labor, total_water, total_labor)
            print "%d %d" % (A, B)
