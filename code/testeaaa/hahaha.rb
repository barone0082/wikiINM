#   <h1>Json Parse</h1>
#		Metódo abre uma planilha xlsx que deve ser mapeada conforme exemplo
#	    em seguida ele varre toda a planilha xlsx e inputa o numero de linhas
#	    contidas na planilha
#
#	<h2>Imports</h2>
#	 - require 'roo'
#     <br>
#	 - Não Necessario
#     <br>
#	 - Não Necessario
#     <br>
#	 - Não Necessario
#     <br>
#	 - Não Necessario
#     
#	 <h4>Autor: Felipe Cipriano</h4>
class xlsParse
require 'roo'

def parseDeXls
workbook = Roo::Spreadsheet.open './exemplo/xlsx_50_rows.xlsx'

worksheets = workbook.sheets
puts "Found #{worksheets.count} worksheets"

worksheets.each do |worksheet|
  puts "Reading: #{worksheet}"
  num_rows = 0
  
  puts workbook.sheet(worksheet).a1
    

  puts workbook.sheet(worksheet).row(2)
  
  
  puts workbook.sheet(worksheet).column(3)

  workbook.sheet(worksheet).each_row_streaming do |row|
    row_cells = row.map { |cell| cell.value }
    num_rows += 1   	

  end
  puts "Read #{num_rows} rows"
end

puts 'Done'

end

end