from ast import literal_eval

def in_perimeter(points, new_point):
    pass
 
#Do not modify below this line
if __name__ == '__main__':
    with open('ExoticOrchardIN.txt', 'r') as f:
        T = int(f.readline().strip())
        for t in range(T):
            new_point = literal_eval(f.readline().strip())
            num_points = int(f.readline().strip())
            existing_points = []
            for i in range(num_points):
                existing_points.append(literal_eval(f.readline().strip()))
            print('1' if in_perimeter(existing_points, new_point) else '0')