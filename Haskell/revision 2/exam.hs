--1 Elimination de la concaténation--
truc :: Int -> [Int]
truc 1 = [1]
truc n = foldr (:) [] [1..n]

--2 Ensembles--

--question 1--
--Contrainte : les éléments de l'ensemble doivent être du même type ainsi que Eq pour pouvoir les comparer.--

--question 2--
--a--
newtype Ensemble e = Ensemble[e] deriving Show

card :: Ensemble e -> Int
card (Ensemble []) = 0
card (Ensemble (x:xs)) = _card 0 (x:xs)
  where _card n [] = n
        _card n (x:xs) = _card (n + 1) xs

ajouter :: Eq e => e -> Ensemble e -> Ensemble e
ajouter n (Ensemble []) = Ensemble [n]
ajouter n (Ensemble (x:xs))
  | (appartient n (Ensemble (x:xs))) == False = Ensemble (n:x:xs)
  | otherwise = Ensemble (x:xs)

appartient :: Eq e => e -> Ensemble e -> Bool
appartient n (Ensemble []) = False
appartient n (Ensemble (x:xs))
  | n == x = True
  | otherwise = appartient n (Ensemble xs)

oter_recursivite :: Eq e => e -> Ensemble e -> Ensemble e
oter_recursivite elt (Ensemble []) = Ensemble []
oter_recursivite elt (Ensemble (x:xs))
  | elt == x = (Ensemble xs)
  | otherwise = ajouter x (oter_recursivite elt (Ensemble xs))

oter_intension :: Eq e => e -> Ensemble e -> Ensemble e
oter_intension elt (Ensemble []) = Ensemble []
oter_intension elt (Ensemble (x:xs)) = (Ensemble [x | x <- (x:xs), elt /= x])

oter_fonctionnelle :: Eq e => e -> Ensemble e -> Ensemble e
oter_fonctionnelle elt (Ensemble []) = Ensemble []
oter_fonctionnelle elt (Ensemble ys) = Ensemble (foldr (\x xs -> if x /= elt then x:xs else xs) [] ys)


--b--
inclus :: Eq e => Ensemble e -> Ensemble e -> Bool
inclus (Ensemble (xs)) (Ensemble []) = True
inclus (Ensemble []) (Ensemble (xs)) = True
inclus (Ensemble (x:xs)) (Ensemble (y:ys))
  | (card (Ensemble (x:xs))) <= (card (Ensemble (y:ys))) = _inclus (Ensemble (x:xs)) (Ensemble (y:ys))
  | otherwise = False

_inclus (Ensemble (xs)) (Ensemble []) = True
_inclus (Ensemble []) (Ensemble (xs)) = True
_inclus (Ensemble (x:xs)) (Ensemble (y:ys))
  | (appartient x (Ensemble (y:ys))) = _inclus (Ensemble (xs)) (Ensemble (y:ys))
  | otherwise = False

egal :: Eq e => Ensemble e -> Ensemble e -> Bool
egal (Ensemble []) (Ensemble liste) = False
egal (Ensemble liste) (Ensemble []) = False
egal (Ensemble (x:xs)) (Ensemble (y:ys))
  | (card (Ensemble (x:xs))) == (card (Ensemble (y:ys))) = _egal (Ensemble (x:xs)) (Ensemble (y:ys))
  | otherwise = False

_egal (Ensemble []) (Ensemble _) = True
_egal (Ensemble (x:xs)) (Ensemble (y:ys))
  | (appartient x (Ensemble (y:ys))) = _egal (Ensemble xs) (Ensemble (y:ys))
  | otherwise = False


--c--
intersection_recursivite :: Eq e => Ensemble e -> Ensemble e -> Ensemble e
intersection_recursivite (Ensemble []) (Ensemble []) = Ensemble []
intersection_recursivite (Ensemble []) (Ensemble ys) = Ensemble []
intersection_recursivite (Ensemble xs) (Ensemble []) = Ensemble []
intersection_recursivite (Ensemble (x:xs)) (Ensemble (y:ys)) = _intersection_recursivite (Ensemble (x:xs)) (Ensemble (y:ys)) (Ensemble [])
  where _intersection_recursivite (Ensemble []) (Ensemble (y:ys)) (Ensemble liste) = Ensemble liste
        _intersection_recursivite (Ensemble (x:xs)) (Ensemble (y:ys)) (Ensemble liste)
          | appartient x (Ensemble (y:ys)) = _intersection_recursivite (Ensemble xs) (Ensemble (y:ys)) (ajouter x (Ensemble liste))
          | otherwise = _intersection_recursivite (Ensemble xs) (Ensemble (y:ys)) (Ensemble liste)

intersection_intension :: Eq e => Ensemble e -> Ensemble e -> Ensemble e
intersection_intension (Ensemble []) (Ensemble []) = Ensemble []
intersection_intension (Ensemble []) (Ensemble ys) = Ensemble []
intersection_intension (Ensemble xs) (Ensemble []) = Ensemble []
intersection_intension (Ensemble (x:xs)) (Ensemble (y:ys)) = (Ensemble [x | x <- (x:xs), appartient x (Ensemble (y:ys))])

intersection_fonctionnelle :: Eq e => Ensemble e -> Ensemble e -> Ensemble e
intersection_fonctionnelle (Ensemble []) (Ensemble []) = Ensemble []
intersection_fonctionnelle (Ensemble []) (Ensemble ys) = Ensemble []
intersection_fonctionnelle (Ensemble xs) (Ensemble []) = Ensemble []
intersection_fonctionnelle (Ensemble xs) (Ensemble ys) = Ensemble (foldr (\x accu -> if (appartient x (Ensemble ys)) then x:accu else accu) [] xs)

union :: Eq e => Ensemble e -> Ensemble e -> Ensemble e
union (Ensemble []) (Ensemble []) = Ensemble []
union (Ensemble xs) (Ensemble []) = Ensemble xs
union (Ensemble []) (Ensemble ys) = Ensemble ys
union (Ensemble (x:xs)) (Ensemble (y:ys))
  | appartient x (Ensemble (y:ys)) = union (Ensemble xs) (Ensemble (y:ys))
  | otherwise = union (Ensemble xs) (ajouter x (Ensemble (y:ys)))

difference :: Eq e => Ensemble e -> Ensemble e -> Ensemble e
difference (Ensemble []) (Ensemble []) = Ensemble []
difference (Ensemble xs) (Ensemble []) = Ensemble xs
difference (Ensemble []) (Ensemble ys) = Ensemble []
difference (Ensemble (x:xs)) (Ensemble (y:ys)) = _difference (Ensemble (x:xs)) (Ensemble (y:ys)) (Ensemble [])
  where _difference (Ensemble []) (Ensemble ys) (Ensemble liste) = Ensemble liste
        _difference (Ensemble (x:xs)) (Ensemble (y:ys)) (Ensemble liste)
          | appartient x (Ensemble (y:ys)) = _difference (Ensemble xs) (Ensemble (y:ys)) (Ensemble liste)
          | otherwise = _difference (Ensemble xs) (Ensemble (y:ys)) (ajouter x (Ensemble liste))

--d--
liste2Ens :: Eq e => [e] -> Ensemble e
liste2Ens [] = Ensemble []
liste2Ens liste = Ensemble liste

ens2Liste :: Eq e => Ensemble e -> [e]
ens2Liste (Ensemble []) = []
ens2Liste (Ensemble liste) = liste

--question 3--
data Ensemble2 a = Vide | Ensemble2 a (Ensemble2 a) deriving Show

appartient2 :: Eq a => a -> Ensemble2 a -> Bool
appartient2 elt Vide = False
appartient2 elt (Ensemble2 x xs)
  | elt == x = True
  | otherwise = appartient2 elt xs

intersection :: Eq a => Ensemble2 a -> Ensemble2 a -> Ensemble2 a
intersection Vide (Ensemble2 y ys) = Ensemble2 y ys
intersection (Ensemble2 x xs) Vide = Ensemble2 x xs
intersection (Ensemble2 x xs) (Ensemble2 y ys) = _intersection (Ensemble2 x xs) (Ensemble2 y ys) Vide
  where _intersection Vide (Ensemble2 y ys) ens = ens
        _intersection (Ensemble2 x xs) (Ensemble2 y ys) ens
          | appartient2 x (Ensemble2 y ys) = _intersection xs (Ensemble2 y ys) (Ensemble2 x ens)
          | otherwise = _intersection xs (Ensemble2 y ys) ens
