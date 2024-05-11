import time

def getHoraCliente1():
    horaUTC = time.localtime()
    desface = 20
    segundos = int(horaUTC[3])*3600 + int(horaUTC[4])*60 + int(horaUTC[5]) + desface * 60
    return list(time.gmtime(segundos))[3:6]

def getHoraCliente2():
    horaUTC = time.localtime()
    desface = -10
    segundos = int(horaUTC[3])*3600 + int(horaUTC[4])*60 + int(horaUTC[5]) + desface * 60
    return list(time.gmtime(segundos))[3:6]

def getHoraServer():
    horaUTC = time.localtime()
    return list(horaUTC)[3:6]

def calcularDiferencias(horaCliente, horaServer):
    segundosCliente = int(horaCliente[0])*3600 + int(horaCliente[1])*60 + int(horaCliente[2])
    segundosServer = int(horaServer[0])*3600 + int(horaServer[1])*60 + int(horaServer[2])
    return segundosCliente - segundosServer