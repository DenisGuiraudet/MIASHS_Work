

class Grille:

    def __init__(self, nb_lig, nb_col):
        self.ships = []
        self.nb_lig_max = nb_lig
        self.nb_col_max = nb_col

    def coup(self, lig, col):
        for ship in self.ships:
            tempN = ship.est_touche(lig, col)
            if tempN != 0:
                return tempN
        return 0

    def __iadd__(self, ship): # +=
        # check if ship can be added (in range)
        self.ships.append(ship)
        return self

    def __str__(self):
        temp_str = ""
        for ship in self.ships:
            temp_str = temp_str + ship.__str__() + " "
        return temp_str

    def printAll(self):
        for ship in self.ships:
            print(ship.__str__())
            for case in ship.cases:
                print(case.lig, case.col, case.est_touche)
