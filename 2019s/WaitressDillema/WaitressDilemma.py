def minBridges(n, xs, ys, xd, yd):
  pass

if __name__ == '__main__':
  with open('WaitressDilemmaIN.txt', 'r') as f:
    num_test_cases = int(f.readline().strip())
    for i in range(num_test_cases):
      n = f.readline().strip()
      s = f.readline().strip().split()
      xs, ys = s[0], s[1]
      d = f.readline().strip().split()
      xd, yd = d[0], d[1]
      print(minBridges(int(n), int(xs), int(ys), int(xd), int(yd)))