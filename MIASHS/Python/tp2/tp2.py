
class ListePriorite:

    def __init__(self):
        self.list = []

    @property
    def length(self):
        return len(self.list)

    @property
    def empty(self):
        return True if self.length == 0 else False

    @property
    def prio_min(self):
        if self.length != 0:
            return self.list[0][0]
        else:
            return None

    @property
    def prio_max(self):
        if self.length != 0:
            return self.list[-1][0]
        else:
            return None

    def add(self, priorite, name):
        self.list.append((priorite, name))
        self.list.sort()

    def contains(self, name):
        for elem in self.list:
            if name == elem[1]:
                return True
        return False

    def priorities_of(self, name):
        temp_list = []
        for elem in self.list:
            if name == elem[1]:
                temp_list.append(elem[0])
        return temp_list

    def pop(self):
        temp_val = self.list.pop()
        return temp_val

    def items(self):
        return self.list

    def vals(self):
        temp_list = []
        for elem in self.list:
            temp_list.append(elem[1])
        return temp_list

    def at(self, index):
        return self.list[index]

    def delete(self, index):
        del self.list[index]

    def __str__(self):
        temp_str = "["
        for elem in self.list:
            temp_str += "("+str(elem[0])+", '"+elem[1]+"'), "
        temp_str = temp_str[:-2]+"]"
        return temp_str

    def __repr__(self):
        temp_str = "["
        for elem in self.list:
            temp_str += "("+str(elem[0])+", '"+elem[1]+"'), "
        temp_str = temp_str[:-2]+"]"
        return temp_str

### TEST ###

daltons = ListePriorite()
print(daltons.empty)  # True
print(f"priorité min = {daltons.prio_min}, priorité max = {daltons.prio_max}")  # None, None

daltons.add(5, "Joe")
daltons.add(1, "Jack")
daltons.add(3, "Averell")
daltons.add(4, "William")
daltons.add(1, "Ma")
daltons.add(10, "Jack")

print(daltons.contains("Lucky Luke"))  # False
print(daltons.contains("Averell"))  # True

print(daltons.priorities_of("Jack"))  # [1, 10]

daltons.pop()  # Supprime le dernier élément (10, "Jack")

print(daltons)  # [(1, 'Jack'), (1, 'Ma'), (3, 'Averell'),
#  (4, 'William'), (5, 'Joe')]

print(f"priorité min = {daltons.prio_min}, priorité max = {daltons.prio_max}")  # 1, 5

for elt in daltons.items():
    print(elt, end=", ")  # ((1, 'Jack'), (1, 'Ma'), (3, 'Averell'),
    #  (4, 'William'), (5, 'Joe'),
print()

for val in daltons.vals():
    print(val, end=", ")  # Jack, Ma, Averell, William, Joe,
print()

print(daltons.length)  # 5

print(daltons.at(0))  # (1, "Jack")

val = daltons.pop()
print(daltons)  # [(1, 'Jack'), (1, 'Ma'), (3, 'Averell'), (4, 'William')]
print(val)  # (5, 'Joe')

print(f"priorité min = {daltons.prio_min}, priorité max = {daltons.prio_max}")  # 1, 4

outlaws = copy.deepcopy(daltons)
daltons.delete(0)
print(daltons)    # [(1, 'Ma'), (3, 'Averell'), (4, 'William')]
print(outlaws)    # [(1, 'Jack'), (1, 'Ma'), (3, 'Averell'), (4, 'William')]
