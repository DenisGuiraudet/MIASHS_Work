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

-- 2 2 b

inclus :: Eq e => Ensemble e -> Ensemble e -> Bool
inclus (Ensemble (xs)) (Ensemble []) = True
inclus (Ensemble []) (Ensemble (xs)) = True
inclus (Ensemble (x:xs)) (Ensemble (y:ys))
  | (card (Ensemble (x:xs))) <= (card (Ensemble (y:ys))) = _inclus (Ensemble (x:xs)) (Ensemble (y:ys))
  | otherwise = False

egal :: Eq e => Ensemble e -> Ensemble e -> Bool
egal (Ensemble []) (Ensemble liste) = False
egal (Ensemble liste) (Ensemble []) = False
egal (Ensemble (x:xs)) (Ensemble (y:ys))
  | (card (Ensemble (x:xs))) == (card (Ensemble (y:ys))) = _egal (Ensemble (x:xs)) (Ensemble (y:ys))
  | otherwise = False
