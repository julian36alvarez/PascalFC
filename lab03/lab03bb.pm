Pascal-FC post-mortem report on lab03bb
- Pascal-FC for IBM PC compatibles - 
- GNU Interpreter Version P5.3.1.5

G L Davies  &  A Burns, University of York
G Ospina, Escuela Colombiana de Ingenieria Julio Garavito


Abnormal halt in process locales[1] with pc = 92
Reason:   deadlock


----------
Main program

Status:  awaiting process termination


----------
Process pvector

Status:  active
pc = 24

Process suspended on:

canaliz[3] (channel)


----------
Process locales[1]

Status:  active
pc = 92

Process suspended on:

canaliz[1] (channel)


----------
Process locales[2]

Status:  active
pc = 92

Process suspended on:

canaliz[2] (channel)


----------
Process mglobal

Status:  active
pc = 109

Process suspended on:

cander[1] (channel)



==========
Global variables

procesos   = 2
longitud   = 4
j          = 2
