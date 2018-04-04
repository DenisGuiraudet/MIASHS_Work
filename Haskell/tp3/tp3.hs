
import Data.List

rangsImpairs :: Eq a => [a] -> [a]
rangsImpairs [] = []
rangsImpairs (x:xs)
 | odd (length (x:xs)) = x:rangsImpairs xs
 | otherwise = rangsImpairs xs

rangsPairs :: Eq a => [a] -> [a]
rangsPairs [] = []
rangsPairs (x:xs)
 | even (length (x:xs)) = x:rangsPairs xs
 | otherwise = rangsPairs xs

fusionGen :: Eq a => (a -> a -> Bool) -> [a] -> [a] -> [a]
fusionGen prop x [] = x
fusionGen prop [] y = y
fusionGen prop (x:xs) (y:ys)
 | prop x y = x:fusionGen prop xs (y:ys)
 | otherwise = y:fusionGen prop ys (x:xs)

splits :: Eq a => [a] -> ([a],[a])
splits x = splitAt (((length x) + 1) `div` 2) x

triFusionGen :: Ord a => (a -> a -> Bool) -> [a] -> [a]
triFusionGen prop [] = []
triFusionGen prop [x] = [x]
triFusionGen prop x = fusionGen prop (triFusionGen prop gauche) (triFusionGen prop droite)
  where (gauche, droite) = splits x

triAsc :: Ord a => [a] -> [a]
triAsc x = triFusionGen (<) x

triDesc :: Ord a => [a] -> [a]
triDesc x = triFusionGen (>) x

concR :: Eq a => [a] -> [a] -> [a]
concR [] y = y
concR x [] = x
concR x y = foldr (:) y x

concL :: Eq a => [a] -> [a] -> [a]
concL [] y = y
concL x [] = x
concL x y = foldl (flip (:)) (reverse y) x

main = do
  print ("!!! rangsImpairs !!!")
  print (rangsImpairs [2, 5, 6, 8])
  print ("!!! rangsPairs !!!")
  print (rangsPairs [2, 5, 6, 8])
  print ("!!! fusionGen !!!")
  print (fusionGen (<) [2, 5, 6, 8] [1, 2, 7])
  print (fusionGen (>) [8, 6, 5, 2] [7, 2, 1])
  print ("!!! triFusionGen !!!")
  print (triFusionGen (\x y -> length x < length y) ["jules", "cesar", "cleopatre", "auguste"])
  print ("!!! triAsc !!!")
  print (triAsc ["jules", "cesar", "cleopatre", "auguste"])
  print ("!!! triDesc !!!")
  print (triDesc [2, 5, 6, 8])
  print ("!!! conc !!!")
  print (concR [2, 5, 6, 8] [1, 2, 7])
  print (concL [2, 5, 6, 8] [1, 2, 7])
  print ("end")
