# riak-db
_____

### Pakiety
Zadania 1-10, zapytania `curl` i odpowiedzi znajdują sie w folderze `src/java/main`
Odpowiedz na zadanie 11 jest programem napisanym w jezyku Java. Wykorzystuje API klient Riak'a.

### Instalacja

Aplikacje można uruchomic klonując repozytorium i uruchamiajac klasa z metoda `main` w IDE (program napisany w Intellij IDEA)
Klasa z metoda `main` znajduje sie w folderze: `src/java/main/Riak.java`

Alternatywnie mozna projekt uruchomic uzywajac wrappera do gradle poprzez komende w terminalu otwartym w folderze projektu:
UNIX: `sh gradlew run`
WINDOWS: `gradlew run`

Alternatywnie 2: uruchomic komende `sh gradlew assemble` i uruchomic skrypt zawarty w `riak-db/build/distributions/riak-db-1.0-SNAPSHOT/bin/riak-db` 
(potrzebny bedzie program do rozpakowania archiwum!)
