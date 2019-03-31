def helpRordan(n, m, shift, edges, s, d):
  pass

if __name__ == '__main__':
  with open('HellsImmigrationIN.txt', 'r') as f:
    num_test_cases = int(f.readline().strip())
    for i in range(num_test_cases):
      n, m = f.readline().strip().split()
      n, m = int(n), int(m)
      shift = []
      edges = []
      for i in range(0, n):
        first, second = f.readline().strip().split()
        first, second = int(first), int(second)
        shift.append((first, second))
        
      
      for i in range(0, m):
        b, e, w = f.readline().strip().split()
        b, e, w = int(b), int(e), int(w)
        edges.append((b,e,w))
        
      
      s, d = f.readline().strip().split()
      s, d = int(s), int(d)
      print(helpRordan(n, m, shift, edges, s, d))
      