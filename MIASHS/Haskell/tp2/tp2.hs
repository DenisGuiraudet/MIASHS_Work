
estPremier :: Int -> Bool
estPremier n = null [ x | x <- [2..n `div` 2], n `rem` x  == 0]

tousPremier :: Int -> [Int]
tousPremier
 | estPremier n =
tousPremier n = tousPremier n - 1

main = do
  print (estPremier 6)
  print (estPremier 7)
  print (estPremier 8)
