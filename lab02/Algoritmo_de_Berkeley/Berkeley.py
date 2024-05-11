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