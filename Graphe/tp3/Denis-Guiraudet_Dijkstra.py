import sys

def dijkstra(graphe,s0):
    S = set(graphe.keys())
    T = set()
    L = {}
    P = {}
    # initialise la longueur de chaque chemin
    for s in S:
        L[s] = sys.float_info.max
    # initialise la longueur du chemin pour s0
    L[s0] = 0

    while T != S:
        lmin = min([L[s] for s in S - T ])
        s = [k for k in S - T if L[k] == lmin][0]
        T.add(s)
        for x in [v for v in graphe[s].keys() if v not in T]:
            v = L[s]+graphe[s][x]['l']
            if L[x] > v:
                L[x] = v
                P[x] = s
    return L,P

G1 = {'s1': {'s2': {'l':2}, 's3': {'l':4}},
  's2': {'s3': {'l':1}, 's4': {'l':10}},
  's3': {'s5': {'l':3}},
  's4': {'s6': {'l':11}},
  's5': {'s4': {'l':1}},
  's6': {}
}

print(dijkstra(G1,'s1'))

G2 = {   'A': {'B': {'l': 6}, 'D': {'l': 2}, 'F': {'l': 8}},
             'B': {'A': {'l': 6}, 'C': {'l': 4}, 'D': {'l': 1}, 'E': {'l': 2}, 'F': {'l': 2}},
             'C': {'B': {'l': 4}, 'E': {'l': 1}, 'G': {'l': 3}},
             'D': {'A': {'l': 2}, 'B': {'l': 1}, 'E': {'l': 1}},
             'E': {'B': {'l': 2}, 'C': {'l': 1}, 'D': {'l': 1}, 'F': {'l': 9}},
             'F': {'A': {'l': 8}, 'B': {'l': 2}, 'E': {'l': 9}, 'H': {'l': 2}},
             'G': {'C': {'l': 3}, 'H': {'l': 7}},
             'H': {'F': {'l': 2}, 'G': {'l': 7}}
}
print(dijkstra(G2,'A'))