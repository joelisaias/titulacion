#ERP v1.0.0
Para contribuir con el proyecto deben de descargar e instalar git en su maquina, pueden descargarlo  [AQUI](https://git-scm.com/downloads "git")

Una vez instalado ir a la carpeta donde se van a descargar el proyecto y dar clic derecho y en el menu contextual seleccionar ___Git Bash___ o ___Git Bash Here___ , se mostrara una consola, es la consola de git basada en linux, una vez en la consola se ejecutaran los siguientes comandos cuando se configure por primera vez:

`$ git config --global user.name "Nombre completo"`<br/> 
`$ git config --global user.email email@example.com`

Luego se procedera a configurar la conexion con el repositorio con los siguientes comandos:

`$ git remote add origin https://github.com/joelisaias/titulacion.git`


Despues se procedera a clonar el repositorio ejecutando los siguientes comandos:

`$ git clone https://github.com/joelisaias/titulacion.git`


Luego procederan a crear su branche(rama) en la cual realizaran sus cambios para ello lo realizaran con los siguientes comandos:

`$ git checkout -b nombredebranche`

Por ejemplo

`$ git checkout -b jalvarado`

si al ejecutar este comando les produce un error como el siguiente:  

> fatal: A branch named 'jalvarado' already exists.

es porque el branch que tratan de crear ya existe, si ese es el caso y no necesitamos crearlo simplemente nos posicionamos en el omitiendo el parametro -b de la siguiente manera:

`$ git checkout nombredebranche`

Por ejemplo

`$ git checkout jalvarado`

