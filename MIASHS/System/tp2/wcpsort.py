
import sys, os
# python3 wcpsort.py 1 /etc/group /etc/passwd

forkList = []
numberError = 0

for arg in sys.argv[2:]:
    pid = os.fork()
    if pid == 0:
        os._exit(0)
    else:
        if os.system("wc "+str(arg)+" sort -k "+sys.argv[1]) != 0:
            numberError += 1
        forkList.append(pid)

while True:

    if len(sys.argv[2:]) == len(forkList):
        print(numberError , "error.s")
        sys.exit(0)

    pass
