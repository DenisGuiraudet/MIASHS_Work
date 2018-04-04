
### 1.1 ###

#x<-read.csv2("D:/Download/R/films.csv")
#plot(table(x$Nombre.de.films),xlab="Nb films",ylab="effectif")

#x=1:12
#x[2]
#x[3:6]
#x[c(5,8,10)]
#x[(x<3)]
#x[(x<3)|(x>10)]

### 1.2 ###

#x = c(2.3,3.5,6,14,12)
#y = c(3.2,5,0.7,1,3.5)

#x[(y<3.4)]
#x = 1:12
#x[5] = 2
#x[x>=10] = 3
#x[c(4,9)] = 1

### 1.3 ###

#x = c(1,2,4,1,6,3,2,1,2,0,1,2,2,1,3,0,3,2,1,2,2,3,2,3)

#sum(x)
#unique(x, incomparables = FALSE)
#table(x)
#sort(table(x))
#(table(x) / length(x)) * 100

### 1.4 ###

#plot(table(x))
#plot((table(x) / length(x)) * 100)
#plot(ecdf(x))
#boxplot(x)
#x # Je suis un commentaire
#mean(x)
#range(x)
#median(x)
#quantile(x)
#var(x)
#sd(x)

### 1.5 ###

#x = c(1,2)
#y = c(2,3)
#z = c(x,y)
#z::::

### 1.6 ###

#iris
#summary(iris$Sepal.Length)
#sd(iris$Sepal.Length)
#hist(iris$Sepal.Length, breaks=c(4,4.5,5.5,6.5,7,8), freq=FALSE)
#par(mfrow=c(1,2))

### 1.8 ###

#homme <- c(rep(1,11),rep(4,40),rep(8,49),rep(15,80),rep(25,100),rep(35,70),rep(45,60))
#femme <- c(rep(1,10),rep(4,39),rep(8,48),rep(15,75),rep(25,95),rep(35,70),rep(45,65))

### 2.1 ###

#x <- matrix(c(36,99,96,24,121,24), nrow = 2, ncol = 3, byrow = TRUE)
#rownames(x)=c("oui","non")
#colnames(x)=c("Jeunes","Adultes","Anciens")

#sum(x)

#barplot(x)
#barplot(x,legend=rownames(x),beside=T)

#margin.table(x,1)
#margin.table(x,2)

#freqtab1 = x/sum(x)*100
#freqtab1

#sum(freqtab1)

#freqtab1 = round(x/sum(x)*100,2)
#freqtab1

#x/as.vector(margin.table(x,1))
#margin.table(x/as.vector(margin.table(x,1)),1)

#t(margin.table(x, 1))

### 2.4 ###

### 3.1 ###

x = c(20,24,28,22,32,28,32,36,41,41)
y = c(16,18,23,24,28,29,26,31,32,34)

df = data.frame(x, y, row.names = NULL, check.rows = FALSE, check.names = TRUE, stringsAsFactors = default.stringsAsFactors())
df

#plot(df)

### 4.1 ###

