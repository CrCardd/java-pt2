clear

 # Se a bin não existir, a cria
$binCount = ls | ? { $_.Name -eq "bin" } | measure | % { $_.Count }
if ($binCount -eq "0")
{
    "Criando pasta bin..."
    mkdir bin
}

# Para cada arquivo na pasta que terminal com .fxml, copia para bin
ls | ? { $_.Name.EndsWith(".fxml") } | % { cp $_.Name .\bin\ }

# Para cada arquivo na pasta que contém Controller no nome, copia para bin
ls | ? { $_.Name.Contains("Controller") } | % { javac -d bin $_.Name}

# Compila e executa o App.java
javac App.java -d bin
cd bin
java App
cd ..