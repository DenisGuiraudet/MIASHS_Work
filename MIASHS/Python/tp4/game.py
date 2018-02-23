from grille import Grille
import bateau

def affiche(code):
    if code == 0:
        print("Dans l'eau..")
    elif code == 1 or code == 2:
        print("Touché..")
    elif code == 3:
        print("Touché Coulé !")
    else:
        print("Coup non valide")


b1 = bateau.Croiseur(1, 1, True)      # True => horizontal
b2 = bateau.Escorteur(2, 5, False)    # False => vertical
b3 = bateau.SousMarin(4, 2, True)     # True => en surface

g1 = Grille(7, 9)
g1 += b1
g1 += b2
g1 += b3

print(g1)                            # Affiche "Croiseur Escorteur Sous-Marin"
affiche(g1.coup(1, 1))               # Affiche "Touché"
affiche(g1.coup(1, 2))               # Affiche "Touché"
affiche(g1.coup(1, 3))               # Affiche "Touché Coulé !"
print(g1)                            # Affiche "Escorteur Sous-Marin"
