
import yaml
import bisect

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

    # New exo

    def __add__(self, item): # +=
        # self.add(item[0], item[1])
        bisect.insort(self.list, item)
        return self

    def __contains__(self, item):
        return self.contains(item)

    def __iter__(self):
        for e in self.list:
            yield e

    def __len__(self):
        return self.length

    def __getitem__(self, key):
        return self.at(key)

    def __delitem__(self, key):
        self.delete(key)

    def __copy__(self):
        tempSelf = type(self)()
        for e in self:
            tempSelf += e
        return tempSelf # ou copy.deepcopy(self)

    def dump(self, path):
        stream = open(path, 'w')
        yaml.dump(self, stream)

    def load(path):
        stream = open(path, 'r')
        return yaml.load(stream)
