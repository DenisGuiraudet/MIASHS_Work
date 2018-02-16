from grille import Grille
import bateau
from nose.tools import eq_, with_setup

# Ici, on utilise une classe pour pouvoir partager les variables
# définies dans le setup entre toutes les fonctions de test

class Tests:

    def setup(self):
        self.b1 = bateau.Croiseur(1, 1, True)
        self.b2 = bateau.Escorteur(2, 5, False)
        self.b3 = bateau.SousMarin(4, 2, False)  # Sous-Marin en plongée

        self.g1 = Grille(7, 9)

        # On ajoute 3 bateaux...
        self.g1 += self.b1
        self.g1 += self.b2
        self.g1 += self.b3

    @with_setup(setup)
    def test_init(self):
        eq_(str(self.g1), 'Croiseur Escorteur Sous-marin ')

    @with_setup(setup)
    def test_est_touche(self):
        eq_(self.b1.est_touche(1, 1), 2)   # Première case touchée
        eq_(self.b1.est_touche(1, 1), 1)   # Case déjà touchée
        eq_(self.b1.est_touche(1, 2), 1)   # Croiseur déjà touché
        eq_(self.b1.est_touche(1, 3), 3)   # Croiseur coulé
        eq_(self.b3.est_touche(4, 2), 0)   # Sous-marin en plongée...

    @with_setup(setup)
    def test_coup(self):
        eq_(self.g1.coup(2, 5), 2)  # Première touche
        eq_(self.g1.coup(2, 5), 1)  # Déjà Touché
        eq_(self.g1.coup(3, 5), 3)  # Escorteur Coulé
        eq_(self.g1.coup(1, 4), 0)  # Dans l'eau
        eq_(str(self.g1), "Croiseur Sous-marin ")
