
-- 1

truc :: Int -> [Int]
truc 1 = [1]
truc n = foldr (:) [] [1..n]

-- 2 1

-- Pour pouvoir comparer il faut deux meme type et utiliser Eq

-- 2 2 a

newtype Ensemble e = Ensemble [e] deriving Show

card :: (Eq e) => Ensemble e -> Int
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

oter_recursive :: Eq e => e -> Ensemble e -> Ensemble e
oter_recursive elt (Ensemble []) = Ensemble []
oter_recursive elt (Ensemble (x:xs))
  | elt == x = (Ensemble xs)
  | otherwise = ajouter x (oter_recursive elt (Ensemble xs))

oter_intension :: Eq e => e -> Ensemble e -> Ensemble e
oter_intension elt (Ensemble []) = Ensemble []
oter_intension elt (Ensemble (x:xs)) = (Ensemble [x | x <- (x:xs), elt /= x])

oter_fonctionnelle :: Eq e => e -> Ensemble e -> Ensemble e
oter_fonctionnelle elt (Ensemble []) = Ensemble []
oter_fonctionnelle elt (Ensemble ys) = Ensemble (foldr (\x xs -> if x /= elt then x:xs else xs) [] ys)

-- 2 2 b

inclus :: Eq e => Ensemble e -> Ensemble e -> Bool
inclus (Ensemble (xs)) (Ensemble []) = True
inclus (Ensemble []) (Ensemble (xs)) = True
inclus (Ensemble (x:xs)) (Ensemble (y:ys))
  | (card (Ensemble (x:xs))) <= (card (Ensemble (y:ys))) = isInclus (Ensemble (x:xs)) (Ensemble (y:ys))
  | otherwise = False

isInclus :: (Eq e) => Ensemble e -> Ensemble e -> Bool
isInclus (Ensemble (x:xs)) (Ensemble ys)
  | appartient x (Ensemble ys) && xs == [] = True
  | appartient x (Ensemble ys) = isInclus (Ensemble xs) (Ensemble ys)
  | otherwise = False

egal :: Eq e => Ensemble e -> Ensemble e -> Bool
egal (Ensemble []) (Ensemble liste) = False
egal (Ensemble liste) (Ensemble []) = False
egal (Ensemble (x:xs)) (Ensemble (y:ys))
  | (card (Ensemble (x:xs))) == (card (Ensemble (y:ys))) = isEgal (Ensemble (x:xs)) (Ensemble (y:ys))
  | otherwise = False

isEgal :: (Eq e) => Ensemble e -> Ensemble e -> Bool
isEgal (Ensemble []) (Ensemble []) = True
isEgal (Ensemble (x:xs)) (Ensemble (y:ys))
  | appartient x (Ensemble ys) && appartient y (Ensemble xs) = isEgal (oter_recursive y (Ensemble xs)) (oter_recursive x (Ensemble ys))
  | otherwise = False

-- 2 2 c

intersection_recursive :: Eq e => Ensemble e -> Ensemble e -> Ensemble e
intersection_recursive (Ensemble []) (Ensemble []) = Ensemble []
intersection_recursive (Ensemble []) (Ensemble ys) = Ensemble []
intersection_recursive (Ensemble xs) (Ensemble []) = Ensemble []
intersection_recursive (Ensemble (x:xs)) (Ensemble (y:ys)) = _intersection_recursivite (Ensemble (x:xs)) (Ensemble (y:ys)) (Ensemble [])
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

union :: (Eq e) => Ensemble e -> Ensemble e -> Ensemble e
union (Ensemble []) (Ensemble e) = (Ensemble e)
union (Ensemble e) (Ensemble []) = (Ensemble e)
union (Ensemble e1) (Ensemble e2)  = Ensemble (foldr (\x xs -> if appartient x (Ensemble e1) then xs else x:xs) e1 e2)

difference :: (Eq e) => Ensemble e -> Ensemble e -> Ensemble e
difference (Ensemble []) (Ensemble e) = (Ensemble [])
difference (Ensemble e) (Ensemble []) = (Ensemble e)
difference (Ensemble e1) (Ensemble e2) = Ensemble (foldr (\x xs -> if appartient x (Ensemble e1) then ens2Liste(oter_recursive x (liste2Ens xs)) else xs) e1 e2)

-- 2 2 d

liste2Ens :: Eq e => [e] -> Ensemble e
liste2Ens [] = Ensemble []
liste2Ens liste = Ensemble liste

ens2Liste :: Eq e => Ensemble e -> [e]
ens2Liste (Ensemble []) = []
ens2Liste (Ensemble liste) = liste

-- 2 3

data EnsembleAb e = Vide | EnsembleAb e (EnsembleAb e) deriving Show

appartientAb :: Eq e => e -> EnsembleAb e -> Bool
appartientAb elt Vide = False
appartientAb elt (EnsembleAb x xs)
  | elt == x = True
  | otherwise = appartientAb elt xs

intersectionAb :: Eq e => EnsembleAb e -> EnsembleAb e -> EnsembleAb e
intersectionAb Vide (EnsembleAb y ys) = EnsembleAb y ys
intersectionAb (EnsembleAb x xs) Vide = EnsembleAb x xs
intersectionAb (EnsembleAb x xs) (EnsembleAb y ys) = _intersection (EnsembleAb x xs) (EnsembleAb y ys) Vide
  where _intersection Vide (EnsembleAb y ys) ens = ens
        _intersection (EnsembleAb x xs) (EnsembleAb y ys) ens
          | appartientAb x (EnsembleAb y ys) = _intersection xs (EnsembleAb y ys) (EnsembleAb x ens)
          | otherwise = _intersection xs (EnsembleAb y ys) ens
