import math

def target_angle(layers, target_x):
    angle = 0.0
    #STUBIFY
    l = math.pi * 0.5
    r = 0.0
    EPSILON = 1e-9
    while math.fabs(l - r) > EPSILON:
        angle = 0.5 * (l + r)
        incidence_angle = 0.5 * math.pi - angle
        prev_refractive_index = layers[0][1]
        x = math.tan(incidence_angle) * layers[0][0]
        other_condition = False
        for height, refractive_index in layers[1:]:
            sin_angle = math.sin(incidence_angle) * prev_refractive_index / refractive_index
            if sin_angle > 1 or sin_angle < 0:
                r = angle
                other_condition = True
                break
            incidence_angle = math.asin(sin_angle)
            prev_refractive_index = refractive_index
            x += math.tan(incidence_angle) * height
        if not other_condition:
            if x > target_x:
                r = angle
            else:
                l = angle
    angle = angle * (180.0 / math.pi)
    #ENDSTUBIFY
    return round(angle, 4)

if __name__ == "__main__":
    with open("NewtonsNightmareIN.txt", "r") as f:
        while True:
            s = f.readline()
            if s == '':
                break
            N, X = [int(x) for x in s.split()]
            layers = []
            for i in range(N):
                s = f.readline().split()
                layers.append((float(s[0]), float(s[1])))
            print("%.4f" % target_angle(layers, X))
