
import sys, os
# python3 wcp.py /etc/passwd /etc/group /etc/service
# python3 wcp.py /etc/passwd /etc/group

forkList = []
numberError = 0

for arg in sys.argv[1:]:
    pid = os.fork()
    if pid == 0:
        os._exit(0)
    else:
        if os.system("wc "+str(arg)) != 0:
            numberError += 1
        forkList.append(pid)

while True:

    if len(sys.argv[1:]) == len(forkList):
        print(numberError , "error.s")
        sys.exit(0)

    pass
