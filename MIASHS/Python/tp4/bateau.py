
class Element:

    def __init__(self, lig, col):
        self.est_touche = False
        self.lig = lig
        self.col = col

    def __str__(self):
        if self.est_touche:
            return "X"
        else:
            return ""

    def toucher(self):
        self.est_touche = True

class Bateau:

    def __init__(self, lig, col, isHorizontal, size):
        self.cases = []
        if isHorizontal:
            for i in range(size):
                self.cases.append(Element(lig, (col + i)))
        else:
            for i in range(size):
                self.cases.append(Element((lig + i), col))

    def est_touche(self, lig, col):
        nbTouche = 0
        firstTouche = False
        for case in self.cases:
            if case.est_touche: # deja touche
                nbTouche += 1
            else:
                if case.lig == lig and case.col == col: # premiere touche
                    case.toucher()
                    nbTouche += 1
                    firstTouche = True
        if nbTouche == len(self.cases): # deja coule
            return 3
        elif nbTouche >= 1: # touche
            if firstTouche: # premiere touche
                return 2
            else: # deja touche
                return 1
        else: # pas touche
            return 0

class Escorteur(Bateau):

    def __init__(self, lig, col, isHorizontal):
        Bateau.__init__(self, lig, col, isHorizontal, 2)

    def __str__(self):
        return "Escorteur"

class Croiseur(Bateau):

    def __init__(self, lig, col, isHorizontal):
        Bateau.__init__(self, lig, col, isHorizontal, 3)

    def __str__(self):
        return "Croiseur"

class SousMarin(Bateau):

    def __init__(self, lig, col, isPlonge):
        Bateau.__init__(self, lig, col, True, 1)
        self.isPlonge = isPlonge

    def est_touche(self, lig, col):
        if self.isPlonge:
            return 0
        else:
            return Bateau.est_touche(self, lig, col)

    def __str__(self):
        return "SousMarin"
