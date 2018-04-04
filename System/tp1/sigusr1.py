
import os, signal, sys

def handler_pas_ok(num_sig, frame):
    print("NO CHEAT !")

def handler_ok(num_sig, frame):
    print("OK")
    sys.exit(0)

print("My PID is :", os.getpid())

signal.signal(signal.SIGTERM, handler_pas_ok)
signal.signal(signal.SIGINT, handler_pas_ok)
signal.signal(signal.SIGUSR1, handler_ok)

while True:
    pass
