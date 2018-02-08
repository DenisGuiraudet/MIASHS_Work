
import Prelude

plus :: Int -> Int -> Int
plus x 0 = x
plus x y
  | y > 0 = plus (succ x) (pred y) -- Incrémente x y fois

moins :: Int -> Int -> Int
moins x 0 = x
moins x y
  | y > 0 = moins (pred x) (pred y) -- Incrémente x y fois
  | y < 0 = moins (succ x) (succ y) -- Décrémente x y fois

mult :: Int -> Int -> Int
mult x 1 = x
mult x 0 = 0
mult x y
 | y > 1 = plus x ((mult x) (pred y))
 | otherwise = oppose(mult x (oppose y))

oppose :: Int -> Int
oppose x = moins 0 x

quotient :: Int -> Int -> Int
quotient x 0 = 0
quotient x 1 = x
quotient x y
  | y > x = 0
  | y > 1 = succ (quotient (moins x y) y)

reste :: Int -> Int -> Int
reste x y = moins x (mult (quotient x y) y)

pair :: Int -> Bool
pair x
  | reste x 2 == 0 = True
  | otherwise = False

impair :: Int -> Bool
impair x = not(pair x)

cnk :: Int -> Int -> Int
cnk n k = n^k`div`k^k where n^k=foldr(*)1[n-k+1..n]

fact :: Int -> Int
fact x
 | x == 0 = 1
 | otherwise = mult (fact (pred x)) x

triangle :: Int -> String
triangle n
 | n >=1 = triangle (pred n) ++ "\n" ++ ligneTriangle (n) (n)
 | n == 0 = "[1]"

ligneTriangle :: Int -> Int -> String
ligneTriangle n p
 | p == 0 = "[1]"
 | p == n =  ligneTriangle n (pred p) ++ "[1]"
 | p >= 1 = ligneTriangle n (pred p) ++ "[" ++ show (cnk n p) ++ "]"


printTriangle :: Int -> IO()
printTriangle n = putStr $ triangle (pred n)

main = do
  print (plus 2 1)
  print (moins 4 2)
  print (mult 2 4)
  print (quotient 4 2)
  print (reste 4 2)
  print (pair 40)
  print (impair 40)
  print (fact 5)
  print (cnk 86 40)
  printTriangle 6
