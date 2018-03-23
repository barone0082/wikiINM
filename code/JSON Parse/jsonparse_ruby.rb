#   <h1>Json Parse</h1>
#		Leitura de arquivo Json e armazenagem em um objeto.


#	 	Autor: Felipe Cipriano
require 'json'

json = File.read('input.json')
obj = JSON.parse(json)

p obj



