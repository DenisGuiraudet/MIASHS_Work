-- :r POUR RECHARGER LE FICHIER !!!!
newtype FileAttente a = FileAttente [a] deriving Show


estVide :: FileAttente a -> Bool
estVide (FileAttente []) = True
estVide _ = False

ajouter :: a -> FileAttente a -> FileAttente a
ajouter x (FileAttente file) = FileAttente (x:file)

tete :: FileAttente a -> Maybe a
tete (FileAttente []) = Nothing
tete (FileAttente (x:xs)) = Just x

oter :: FileAttente a -> FileAttente a
oter (FileAttente []) = FileAttente []
oter (FileAttente (x:xs)) = (FileAttente (xs))


main = do
  print("bleur")
