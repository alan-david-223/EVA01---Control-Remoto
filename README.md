# EVA01---Control-Remoto
Primera Evaluacion 1er Cuatrimestre 2020 - Programación Básica

## About these files:
Hello! This is a simple program that I wrote on May 2020 for my first evaluation at College! There are 2 files here: Televisor.java (which works as the receptor of the signal) and Control Remoto.java which sends commands to Televisor.

## Assigment in Spanish: 
Desarrollá el software para las nuevas plaquetas de los televisores Acme Serie dorada.

- El televisor cuenta con 5 entradas (Televisión de aire, Televisión por cable, HDMI1, HDMI2 y USB). Por
norma los códigos de entrada para todos los televisores son los siguientes:

• ENTRADA_TELEVISION_DE_AIRE = ‘A’
• ENTRADA_TELEVISION_POR_CABLE = ‘C’
• ENTRADA_HDMI1 = ‘1’
• ENTRADA_HDMI2 = ‘2’
• ENTRADA_USB = ‘U’

- Es muy importante tener presente que los recursos hardware para este tipo de plaquetas son
limitados. En consecuencia, se debe ser extremadamente eficiente en el uso de la memoria disponible
para operar.

- También es importante garantizar la protección de la información, puesto que, si se almacena un valor
no esperado en cualquiera de los atributos del televisor, se puede dañar el hardware.

- Cada plaqueta tiene asociado un número de serie, que es un identificador único. Esta numeración se
definirá automáticamente en el momento de la creación. Sabiendo que esta plaqueta se podrá utilizar
para distintos modelos de televisores, incluso reconvertir televisores en desuso, se estima que a lo
largo del tiempo se podrán fabricar alrededor de tres mil millones de plaquetas (3.000.000.000).

- Las únicas dos entradas que permiten la visualización y modificación de canales son las de “Televisión
de aire” y “Televisión por cable”. Es importante señalar que la cantidad máxima de canales de la
televisión abierta es de 127 mientras que para la televisión por cable es de 32767 canales. Sin
embargo, al momento de la instanciación de un televisor determinado, se realiza el proceso de
sintonización. Esto consiste en determinar el máximo canal de aire y el máximo canal de cable.

- Opcionalmente se podrán incorporar otras variables al momento de la instanciación que se
mencionarán más adelante.

- El volumen va desde 0 a 100.

- Existen modelos que poseen un sistema de control parental, el cual establece un rango en el cual se
establece un contenido exclusivo para mayores (canalParaMayoresInicial y canalParaMayoresFinal).
Este rango sólo está definido para los canales de televisión por cable, no habiendo restricción alguna
para los canales de aire. Cuando el control parenteral esté activo, no se podrá sintonizar ningún canal
que se encuentre dentro de este rango. La clave para activar o desactivar el control parenteral se
establece al momento de la instalación y sólo se comparte con el propietario adulto del dispositivo.
Esta clave está compuesta de un valor numérico de 4 dígitos. De igual manera, los rangos de canales
exclusivos para mayores se establecen al momento de la creación del dispositivo, y exclusivamente
para aquellos modelos que tienen habilitada la funcionalidad

- Es importante saber que el control remoto trabaja en una frecuencia que sólo puede transmitir código
ASCII. Motivo por el cual, cuando una función de este requiera enviar un valor, el mismo debe ser recibido
en dicho código y eventualmente luego transformarlo al formato deseado (Esto significa que, salvo el
constructor de la clase, el resto de los métodos públicos sólo pueden recibir parámetros de tipo char.

### A continuación, se detalla todo el comportamiento que debe soportar la plaqueta (Entre corchetes se
indica desde que función del control remoto se acceden):

a. encenderOApagar [Botón Power]: Invierte el estado del televisor. Si se encuentra apagado, lo
enciende, caso contrario lo apaga.
b. toString [Botón Display]: Devuelvo la información con el estado actual del televisor.
c. seleccionarEntrada [Botón Input]: Selecciona la entrada deseada.
d. subirOBajarAnalogicamente [+ / - / < / >] Según lo que recibe de parámetro sube o baja el
volumen o de canal:
i. ‘+’ Sube el volumen
ii. ‘-‘ Baja el volumen
iii. ‘>’ Sube de canal
iv. ‘<’ Baja de canal
e. cambiarDeCanal: Disponible en varios formatos (Sólo disponible para las entradas de televisión
de aire o cable):
i. [0 – 9] Cambio digital un digito (recibe el canal deseado)
ii. [10+] Cambio digital dos dígitos (recibe la decena y la unidad. A partir de ahí construye
el canal deseado)
iii. [100 +] Cambio digital tres dígitos (recibe la centana, la decena y la unidad, a partir de
ahí construye el canal deseado)
iv. [1000 +] Cambio digital cuatro dígitos (recibe los cuatro dígitos que formarán el canal)
f. volverAlCanalAnterior [Prev.]: Retorna al último canal seleccionado.
g. silenciar [Mute]: Actualiza el valor del volumen en cero.
h. activarControlParenteral ⑱: Activa la función. Recibe una contraseña de cuatro dígitos.
i. Los gets que consideres absolutamente necesario para poder completar el desarrollo

Es responsabilidad de los programadores desarrollar la clase de prueba (con su correspondiente main)
que verifique el correcto funcionamiento de la clase de dominio definida. Por favor, te pedimos que lo
hagas. Tené en cuenta que luego, existirá un proceso de prueba automático, considerando el gran número de
plaquetas que se van a construir. Para esto, se requiere que la firma de los métodos a desarrollar
cumpla con el siguiente formato:

a. Televisor(canalMaximoTelevisionAbierta, canalMaximoTelevisionPorCable)
b. Televisor(canalMaximoTelevisionAbierta, canalMaximoTelevisionPorCable, claveControlParenteral,
canalParaMayoresInicial, canalParaMayoresFinal)
c. encenderOApagar()
d. toString()
e. seleccionarEntrada(entradaDeseada)
f. subirOBajarAnalogicamente(operación)
g. cambiarDeCanal(canalDeseado)
h. cambiarDeCanal(primerDigito, segundoDigito)
i. cambiarDeCanal(primerDigito, segundoDigito, tercerDigito)
j. cambiarDeCanal(primerDigito, segundoDigito, tercerDigito, cuartoDigito)
k. volverAlCanalAnterior()
l. silenciar()
m. activarControlParenterla(primerDigitoDeLaClave, segundoDigitoDeLaClave, tercerDigitoDeLaClave,
cuartoDigitoDeLaClave)
n. deactivarElControlParenteral(primerDigitoDeLaClave, segundoDigitoDeLaClave, tercerDigitoDeLaClave,
cuartoDigito)
o. getEntradaTelevisionDeAire()
p. getEntradaTelevisionPorCable()
q. getEntradaHdmi1()
r. getEntradaHdmi2()
s. getEntradaUsb()
t. getNumeroDeSerie()
u. isControlParenteralActivado()
v. isEncendido()
w. getVolumenActual()
x. getCanalActual()
y. getEntradaActual()

Adicionalmente te recomendamos que evalúes la posibilidad de incorporar los siguientes métodos privados en la
clase Televisor. Te resultarán de gran ayuda para optimizar el código y simplificarlo:
z. setCanal(short canalDeseado)
aa. convertirAShort(char)
bb. convertirAShort(char, char)
cc. convertirAShort(char, char, char)
dd. convertirAShort(char, char, char, char)
