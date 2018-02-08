
import copy
import yaml
from listepriorite import ListePriorite

daltons = ListePriorite()
print(daltons.empty)        # True
print(f"priorité min = {daltons.prio_min}, priorité max = {daltons.prio_max}")

daltons += (5, "Joe")
daltons += (1, "Jack")
daltons = daltons + (3, "Averell")
daltons += (4, "William")
daltons += (1, "Ma")
daltons += (10, "Jack")

print("Lucky Luke" in daltons)   # False
print("Averell" in daltons)      # True

print(daltons.priorities_of("Jack"))  # [1, 10]

daltons.pop()                # Supprime le dernier élément (10, "Jack")

print(daltons)               # [(1, 'Jack'), (1, 'Ma'), (3, 'Averell'),
                             #  (4, 'William'), (5, 'Joe')]

print(f"priorité min = {daltons.prio_min}, priorité max = {daltons.prio_max}")

for elt in daltons:
    print(elt, end=", ")     # ((1, 'Jack'), (1, 'Ma'), (3, 'Averell'),
                             #  (4, 'William'), (5, 'Joe'),
print()

for elt in daltons.items():
    print(elt, end=", ")     # (1, 'Jack'), (1, 'Ma'), (3, 'Averell'),
                             # (4, 'William'), (5, 'Joe'),
print()

for val in daltons.vals():
    print(val, end=", ")     # Jack, Ma, Averell, William, Joe,
print()

print(len(daltons))          # 5

print(daltons[0])            # (1, "Jack")'document.yaml'

del(daltons[1])
print(daltons)               # [(1, 'Jack'), (3, 'Averell'), (4, 'William'),
                             # (5, 'Joe')]

val = daltons.pop()
print(daltons)               # [(1, 'Jack'), (3, 'Averell'), (4, 'William')]
print(val)                   # (5, 'Joe')

print(f"priorité min = {daltons.prio_min}, priorité max = {daltons.prio_max}")

outlaws = copy.copy(daltons)
del daltons[0]
print(daltons)                # [(3, 'Averell'), (4, 'William')]
print(outlaws)                # [(1, 'Jack'), (3, 'Averell'),
                              #  (4, 'William')]

daltons.dump("daltons.yaml")  # Sérialisation YAML dans un fichier
bandits = ListePriorite.load("daltons.yaml")
print(bandits)                # [(3, 'Averell'), (4, 'William')]
