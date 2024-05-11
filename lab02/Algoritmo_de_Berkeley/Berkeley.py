from tkinter import *
import time

def getHoraCliente1():
    horaUTC = time.localtime()
    desface = 20
    segundos = int(horaUTC[3])*3600 + int(horaUTC[4])*60 + int(horaUTC[5]) + desface * 60
    return list(time.gmtime(segundos))

def getHoraCliente2():
    horaUTC = time.localtime()
    desface = -10
    segundos = int(horaUTC[3])*3600 + int(horaUTC[4])*60 + int(horaUTC[5]) + desface * 60
    return list(time.gmtime(segundos))

def getHoraServer():
    horaUTC = time.localtime()
    return list(horaUTC)

def calcularDiferencias(horaCliente, horaServer):
    segundosCliente = int(horaCliente[3])*3600 + int(horaCliente[4])*60 + int(horaCliente[5])
    segundosServer = int(horaServer[3])*3600 + int(horaServer[4])*60 + int(horaServer[5])
    return segundosCliente - segundosServer

def calcularHoras(diferencias, *horas):
    promedio = sum(diferencias) / len(diferencias)
    nuevasDiferencias = [promedio - diferencia for diferencia in diferencias]
    nuevasHoras = []
    for i in range(len(horas)):
        segundos = int(horas[i][3])*3600 + int(horas[i][4])*60 + int(horas[i][5]) + nuevasDiferencias[i]
        nuevasHoras.append(list(time.gmtime(segundos)))
    return nuevasHoras

def formatoHora(hora):
    return "{:02d}:{:02d}:{:02d}:{:03d}".format(hora[3], hora[4], hora[5], hora[6]*10)

def obtenerHoraCliente():
    nombres = ["Servidor", "Cliente 1", "Cliente 2"]
    horas = [getHoraServer(), getHoraCliente1(), getHoraCliente2()]
    diferencias = [calcularDiferencias(hora, horas[0]) for hora in horas]
    nuevasHoras = calcularHoras(diferencias, *horas)
    for i in range(len(horas)):
        text.insert(END, nombres[i] + " (antes): " + formatoHora(horas[i]) + "\n")
    text.insert(END, "--------------------------------------------\n")
    for i in range(len(nuevasHoras)):
        text.insert(END, nombres[i] + " (después): " + formatoHora(nuevasHoras[i]) + "\n")
    text.insert(END, "========================\n")
    text.see(END)
    root.after(5000, obtenerHoraCliente)  

root = Tk()
root.geometry("300x450")
text = Text(root, font=('times', 12, 'bold'), bg='white')
text.pack(fill=BOTH, expand=YES)
scrollbar = Scrollbar(root)
scrollbar.pack(side=RIGHT, fill=Y)
text.config(yscrollcommand=scrollbar.set)
scrollbar.config(command=text.yview)
obtenerHoraCliente()
root.mainloop()