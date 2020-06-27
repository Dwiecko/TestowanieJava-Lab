# Testowanie aplikacji JAVA 2017-2018
## Laboratorium 8 (Wprowadzenie do BDD - JBehave)

-------------------------------------------

Wszystkie zadania mają być zapisane w utworzonym projekcie MAVEN!!!

-------------------------------------------

**Zadanie 1** (1 pkt)

Utwórz projekt MAVEN korzystając ze szablonu jbehave-quickstart (patrz prezentacja). Następnie skopiuj tutaj 
dowolne zadanie z poprzednich laboratoriów oraz napisz testy akceptacyjne (minimum po 6 testów), które mają: 

- Znajdować się w katalogu **Stories**.
- Mają odpalać się poprzez nazwy klas. 

Testy mają odpalać się przy pomocy polecenia **mvn integration-test** (w przypadku nazw klas). Spójrz jak wygląda wynikowy raport z użycia JBehave.

**WSKAZÓWKA:** Patrz przykład pokazany z laboratorium. Zwróć uwagę na linię (ona źle generuje się przez szablon): 

```
ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(), new LoadFromClasspath(embeddableClass), parameterConverters, null, new TableTransformers());
```

------------------------------------

**Zadanie 3** (0.25 pkt)

Napisz dwa testy akceptacyjne, które będą poprzez scenariusze przekazywały do metod tak zwane parametry.

-----------------------------

**Zadanie 3** (0.5 pkt)

Dopisz scenariusz, który będzie używał preambuły **@BeforeScenario** oraz **@AfterScenario**. 
Następnie napisz przy pomocy słowa kluczowego **@AfterScenario** dwie funkcje **fail()** oraz **success()**, które
będą obsługiwać ten sam scenariusz testowy, a ponadto: 

- fail() wyświetli komunikat w konsoli, że test się nie powiódł.
- success() wyświetli komunikat o pomyślnym zakończeniu testu.

------------------------------------------

**Zadanie 4** (0.5 pkt) 

Do dowolnego zadania napisz **dwa** scenariusze testowe, które będą obsługiwać ten sam kod w języku JAVA, ale
zawartość scenariusza będzie nieznacznie się różniła. 

Na przykład dla scenariuszy: 

```
Scenario: First Scenario
Given a value x by 5
Given a value y by 10
Then sum of value x and y is 15

Scenario: Second Scenario
Given a value x by 5
Given a value y by 10
Then sum of value x and y becomes 15
```

Powinienen obsługiwany być ten sam kod.




