
newtype FIFO a = FIFO [a] deriving Show

isEmpty :: FIFO a -> Bool
isEmpty (FIFO []) = True
isEmpty _ = False

add :: FIFO a -> a -> FIFO a
add (FIFO file) x = FIFO (x:file)

haed:: FIFO a -> Maybe a
haed (FIFO []) = Nothing
haed (FIFO (x:xs)) = Just x

remove :: FIFO a -> FIFO a
remove (FIFO []) = FIFO []
remove (FIFO (x:xs)) = (FIFO (xs))


main = do
  print(isEmpty (FIFO []))
  print(isEmpty (FIFO [1,2,3]))
  print(isEmpty (add (FIFO []) 4))
  print(isEmpty (remove (FIFO [5])))
  print(haed (FIFO [6,7,8]))
