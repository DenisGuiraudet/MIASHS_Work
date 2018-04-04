
import Data.Char

estPremier :: Int -> Bool
estPremier n = null [ x | x <- [2..n `div` 2],
                          n `rem` x  == 0]

tousPremier :: Int -> [Int]
tousPremier n = filter estPremier [0..n]

sommeFacteurs :: Int -> Int
sommeFacteurs n = sum [ x | x <- [1..n],
                            n `mod` x == 0,
                            x /= n]

estParfait :: Int -> Bool
estParfait n = (n == sommeFacteurs n)

tousParfait :: Int -> [Int]
tousParfait n = filter estParfait [0..n]

estAmi :: Int -> Int -> Bool
estAmi n m = (n == sommeFacteurs m) && (m == sommeFacteurs n)

amis :: Int -> [(Int, Int)]
amis n = [ (i, j) | i <- [1..n],
                        j <- [1..n],
                        estAmi i j]

noDoublons :: Eq a => [a] -> [a]
noDoublons [] = []
noDoublons [x] = [x]
noDoublons (x:y:xs)
 | x == y = noDoublons(y:xs)
 | otherwise = x:noDoublons(y:xs)

appartient :: Eq a => a -> [a] -> Bool
appartient _ [] = False
appartient n (x:xs)
 | n == x = True
 | otherwise = appartient n xs

estVoyelle :: Char -> Bool
estVoyelle c = appartient c ['A', 'E', 'I', 'O', 'U', 'Y']

estConsonne :: Char -> Bool
estConsonne c = estVoyelle c == False

super :: [Int] -> Int
super [x] = x
super (x:y:xs)
 | x >= y = super (x:xs)
 | otherwise = super (y:xs)

conc :: Eq a => [a] -> [a] -> [a]
conc [] y = y
conc (x:xs) y = x:conc xs y

tresse :: Eq a => Eq b => Eq c => [a] -> [b] -> [c] -> [(a, b, c)]
tresse [] _ _ = []
tresse _ [] _ = []
tresse _ _ [] = []
tresse (x:xs) (y:ys) (z:zs) = (x,y,z) : tresse xs ys zs

detresse :: Eq a => Eq b => Eq c => [(a, b, c)] -> ([a], [b], [c])
detresse = foldr (\(x, y, z) ~(xs, ys, zs) -> (x:xs, y:ys, z:zs))
 ([], [], [])

applatir :: Eq a => [[a]] -> [a]
applatir x = foldr (++) [] x

inserer :: Int -> [Int] -> [Int]
inserer x [] = [x]
inserer n (x:xs)
 | n < x = n:x:xs
 | otherwise = x:inserer n xs

compter :: Eq a => (a -> Bool) -> [a] -> Int
compter prop [] = 0
compter prop (x:xs)
 | prop x = 1 + compter prop xs
 | otherwise = compter prop xs

filtrer :: Eq a => (a -> Bool) -> [a] -> [a]
filtrer prop [] = []
filtrer prop (x:xs)
 | prop x = x:filtrer prop xs
 | otherwise = filtrer prop xs

find :: Eq a => (a -> Bool) -> [a] -> a
find prop (x:xs)
 | prop x = x
 | otherwise = find prop xs

firstToN :: String -> Int
firstToN ch =
  horner $ map (\x -> ord(x) - ord('0')) (reverse ch)
  where horner :: [Int] -> Int
        horner = foldr (\x acc -> x + 2 * acc) 0
