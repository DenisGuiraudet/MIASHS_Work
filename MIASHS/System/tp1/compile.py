
import sys, os
# python3 compile.py toto.c titi.c tata.c tutu.c monprog

argstr = ""
forkList = []

for arg in sys.argv[1:-1]:
    print (str(arg))
    argstr = argstr + str(arg) + " "
    pid = os.fork()
    print(pid)
    if pid == 0:
        os._exit(0)
    else:
        os.system("c99 -c "+str(arg))
        forkList.append(pid)
        print(forkList)

while True:

    if len(sys.argv[1:-1]) == len(forkList):
        os.system("c99 "+argstr+"-o "+sys.argv[-1:][0])
        os.system("./"+sys.argv[-1:][0])
        print("OK")
        sys.exit(0)

    pass
