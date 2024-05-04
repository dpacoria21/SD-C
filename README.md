## Repositorio para el trabajo de Sistemas Distribuidos laboratorio

### Integrantes:
 - Henry Isaias Galvez Quilla - 20201828 - hgalvezq@unsa.edu.pe
 - Franco Luchiano Cardenas Martinez - fcardenasm@unsa.edu.pe
 - Diego Ivan Pacori Anccasi - dpacoria@unsa.edu.pe

### Metodología de trabajo:
 1. Cada integrante debera crear su propia rama con el nombre de su correo:  

    * `git branch -b dpacoria `

 2. El trabajo sera divido cada uno en sus respectivas tareas de manera que al hacer merge evitemos en su mayoría los conflictos  

    * `git branch ` -> para poder ver las otras ramas  
    * `git branch -b <name>` -> para crear e ir de inmediato a esa nueva rama  
    * `git checkout <name> ` -> para poder ir a otras ramas  

 3. Para una mejor visualizacion del ` git log ` utilizar el siguiente alias  

    * `git config --global alias.lg "log --graph --abbrev-commit --decorate --format=format:'%C(bold blue)%h%C(reset) - %C(bold green)(%ar)%C(reset) %C(white)%s%C(reset) %C(dim white)- %an%C(reset)%C(bold yellow)%d%C(reset)' --all"`

 4. Recuerden siempre al entrar al repositorio codear  
 
    * ` git pull origin main` -> esto para actualizar su rama con la rama main
