# Testowanie aplikacji JAVA 2017-2018
## Laboratorium 9 (Testy parametryczne w JBehave)

-------------------------------------------

Wszystkie zadania mają być zapisane w **tym samym** utworzonym projekcie MAVEN!!!

-------------------------------------------

**Zadanie 1** (1 pkt)

Do pokazanego przykładu dokończ metodę **thenPowersAndSizeIssizepowers(ExamplesTable table)** uzupełniając ją o odpowiednią asercję. Następnie dopisz kolejny wiersz do pokazanego przykładowego scenariusza i dokonaj zmian w metodach tak, aby scenariusz ten przeszedł pozytywnie. 

**Zadanie 2** (0.75 pkt) 

Jednym z innych sposobów przeprowadzania testów parametrycznych w **JBehave** jest tworzenie tabeli przykładów (przy użyciu słowa kluczowego **Examples:**) w scenariuszu. Przykład takiego scenariusza wygląda następująco: 

```
Given Mając własny kalkulator liczb całkowitych
When dodam zmienne <a> i <b>
Then otrzymam następujący <wynik> 

Examples: 
|a|b|wynik|
|2|-2|0|
|2|2|4|
|1|5|6|
```

Wzorując się na pokazanym przykładzie powyżej napisz conajmniej **dwa** scenariusze (w innym, osobnym pliku), do dowolnego zadania z poprzednich laboratoriów (oprócz kalkulatora), w której wykorzystasz testy paramatryczne pokazane powyżej. Zastanów się czy w przypadku zmiennych typu **double** potrzebne będzie podanie parametru delta.

**Zadanie 3** (0.25 pkt) 

Napisz scenariusz (w osobnym pliku), który będzie uruchamiał jednocześnie scenariusze z zadania pierwszego oraz drugiego. 

**Wskazówka:** Poszukaj informacji o **Given Stories** w  **JBehave**.
