
from socket import *
import sys
import datetime

if len(sys.argv) != 2:
    print(f"Usage: {sys.argv[0]} <port>", file=sys.stderr)
    sys.exit(1)

TAILLE_TAMPON = 256

sock = socket(AF_INET, SOCK_DGRAM)
print(f"{str(datetime.datetime.now().strftime('%Y/%m/%d %H:%M:%S'))} Server started", file=sys.stderr)

# Liaison de la socket à toutes les IP possibles de la machine
sock.bind(("", int(sys.argv[1])))
print(f"{str(datetime.datetime.now().strftime('%Y/%m/%d %H:%M:%S'))} Listen on :" + sys.argv[1], file=sys.stderr)

while True:
    try:
        # Récupération de la requête du client
        requete = sock.recvfrom(TAILLE_TAMPON)

        # Extraction du message et de l’adresse sur le client
        (mess, adr_client) = requete
        ip_client, port_client = adr_client

        print(f"{datetime.datetime.now().strftime('%Y/%m/%d %H:%M:%S')} Received {mess.decode()} from {ip_client}", file=sys.stderr)

        # Construction de la réponse
        reponse = mess.decode().upper()

        if (reponse == "DATE"):
            reponse = datetime.datetime.now().strftime('%d/%m/%y')
        elif (reponse == "JOUR"):
            reponse = datetime.datetime.now().strftime('%A')
        elif (reponse == "MOIS"):
            reponse = datetime.datetime.now().strftime('%B')
        elif (reponse == "HEURE"):
            reponse = datetime.datetime.now().strftime('%H:%M:%S')
        elif (reponse == "PAQUES"):
            reponse = "PAQUES"
        elif (reponse == "ASCENSION"):
            reponse = "ASCENSION"
        elif (reponse == "HELP"):
            reponse = "\r\n-DATE\r\n-JOUR\r\n-MOIS\r\n-HEURE\r\n-PAQUES\r\n-ASCENSION\r\n-HELP\r\n-QUIT"
        elif (reponse == "QUIT"):
            reponse = "QUIT"
        else:
            reponse = "Don't exist"

        # Envoi de la réponse au client
        sock.sendto(reponse.encode(), adr_client)

    except KeyboardInterrupt: break

sock.close()
print(f"{str(datetime.datetime.now().strftime('%Y/%m/%d %H:%M:%S'))} Server stopped...", file=sys.stderr)
sys.exit(0)
