--implémentation extrait partiel Haskell de Guilhem SUSA

concat' :: Int -> [Int]
concat' 1 = [1]
concat' n = foldr (:) [] [1..n]

newtype Ensemble a = Ensemble [a] deriving Show

card :: (Eq a) => Ensemble a -> Int
card (Ensemble []) = 0
card (Ensemble l) = compterEns l 0
	where 
		compterEns (x:xs) cpt 
			| xs == [] = (cpt + 1)
			| otherwise = compterEns xs (cpt + 1)

appartient :: (Eq a) => a -> Ensemble a -> Bool
appartient e (Ensemble []) = False
appartient e (Ensemble l) = isIn e l
	where
		isIn e (x:xs)
			| e == x = True
			| otherwise = appartient e (Ensemble xs)
			

ajouter :: (Eq a) =>  a -> Ensemble a -> Ensemble a
ajouter e (Ensemble []) = (Ensemble [e])
ajouter e (Ensemble xs) =
	if appartient e (Ensemble xs) then (Ensemble xs)
	else (Ensemble (e:xs))
				
oter :: (Eq a) =>  a -> Ensemble a -> Ensemble a
oter e (Ensemble l) = Ensemble (foldr (\x xs -> if x /= e then x:xs else xs) [] l)

inclus :: (Eq a) => Ensemble a -> Ensemble a -> Bool
inclus (Ensemble []) (Ensemble _) = True
inclus (Ensemble _) (Ensemble []) = True
inclus (Ensemble e1) (Ensemble e2) =
	if card (Ensemble e1) <= card (Ensemble e2) then isInclude (Ensemble e1) (Ensemble e2)
	else False

isInclude :: (Eq a) => Ensemble a -> Ensemble a -> Bool
isInclude (Ensemble (x:xs)) (Ensemble ys)
	| appartient x (Ensemble ys) && xs == [] = True
	| appartient x (Ensemble ys) = isInclude (Ensemble xs) (Ensemble ys)
	| otherwise = False
	
egal :: (Eq a) => Ensemble a -> Ensemble a -> Bool
egal (Ensemble e1) (Ensemble e2) =
	if card (Ensemble e1) == card (Ensemble e2) then isEquals (Ensemble e1) (Ensemble e2)
	else False

isEquals :: (Eq a) => Ensemble a -> Ensemble a -> Bool
isEquals (Ensemble []) (Ensemble []) = True
isEquals (Ensemble (x:xs)) (Ensemble (y:ys))
	| appartient x (Ensemble ys) && appartient y (Ensemble xs) = isEquals (oter y (Ensemble xs)) (oter x (Ensemble ys))
	| otherwise = False

intersection :: (Eq a) => Ensemble a -> Ensemble a -> Ensemble a
intersection (Ensemble []) (Ensemble e) = (Ensemble []) 
intersection (Ensemble e) (Ensemble []) = (Ensemble e) 
intersection (Ensemble e1) (Ensemble e2) = Ensemble (foldr (\x xs -> if appartient x (Ensemble e1) then ens2Liste(ajouter x (liste2Ens xs)) else xs) [] e2)

union :: (Eq a) => Ensemble a -> Ensemble a -> Ensemble a
union (Ensemble []) (Ensemble e) = (Ensemble e) 
union (Ensemble e) (Ensemble []) = (Ensemble e) 
union (Ensemble e1) (Ensemble e2)  = Ensemble (foldr (\x xs -> if appartient x (Ensemble e1) then xs else x:xs) e1 e2)

difference :: (Eq a) => Ensemble a -> Ensemble a -> Ensemble a
difference (Ensemble []) (Ensemble e) = (Ensemble []) 
difference (Ensemble e) (Ensemble []) = (Ensemble e) 
difference (Ensemble e1) (Ensemble e2) = Ensemble (foldr (\x xs -> if appartient x (Ensemble e1) then ens2Liste(oter x (liste2Ens xs)) else xs) e1 e2)

liste2Ens :: (Eq a) =>  [a] -> Ensemble a
liste2Ens [] = Ensemble []
liste2Ens (x:xs) = ajouter x (liste2Ens xs)

ens2Liste :: (Eq a) => Ensemble a  -> [a]
ens2Liste (Ensemble []) = []
ens2Liste (Ensemble (x:xs)) = x:(ens2Liste (Ensemble xs))

