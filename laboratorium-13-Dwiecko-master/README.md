# Testowanie aplikacji JAVA 2017-2018
## Laboratorium 13 (Selenium WebDriver + JBehave)

-------------------------------------------

Wszystkie zadania mają być zapisane w **tym samym** utworzonym projekcie MAVEN!!!

-------------------------------------------

**Zadanie 1** (0.5 pkt)

Napisz testy akceptacyjne (co najmniej trzy) dotyczące dowolnej strony, która zawiera panel logowania. Testy akceptacyjne powinny znajdować się w dwóch różnych plikach o rozszerzeniu .story. 

Zapisz zadanie w plikach: **GoodLogin.story**, **BadLogin.story**, **LoginStories.java**, **LoginSteps.java**.

**Wskazówka**: Do ładowania historyjek można użyć głównego katalogu o nazwie **stories**: 

```
protected List<String> storyPaths(){
  return new StoryFinder().findPaths(codeLocationFromPath("/sciezka_do_historyjek/"), "/wzorzec_historyjek_np:*.story/", "");
}

```

-------------------------

**Zadanie 2** (0.5 pkt)

Wykorzystując testy parametryczne napisz testy akceptacyjne dla dowolnej strony, która posiada pole wyszukiwania (search). 

Zapisz zadanie w plikach: **Search.story**, **SearchStories.java**, **SearchSteps.java**. 

-------------------

**Zadanie 3** (1 pkt)

Na wielu stronach internetowych istnieją linki, które pobierają jakieś pliki na dysk komputera. Napisz testy akceptacyjne, weryfikujące tę funkcjonalność. 

Zapisz zadanie w plikach: **Download.story**, **DownloadStories.java**, **DownloadSteps.java**.

**Uwaga:** Do tego zadania najlepiej używać przeglądarki, która nie będzie pytać się o potwierdzenie pobrania pliku (tak jak to ma miejsce w przypadku przeglądarki **MozillaFirefox**. 

--------------------

**Zadania dodatkowe:**

**Zadanie 4** (0.5 pkt)

Przerób projekt tak, aby uruchamiały się testy integracyjne (mvn integration-test). 

------------------

**Zadanie 5** (0.5 pkt)

Przerób projekt na **JUnit5** oraz tak, żeby działały na przeglądarkach bezinterfejsowych (HtmlUnit lub PhantomJS). 

Zadanie zapisz w plikach: **HtmlUnitStories.java** oraz **PhantomJSStories.java**.

-------------------

**Zadanie 6** (1 pkt) 

Przerób zadanie 3, używając przeglądarki **MozillaFirefox**. 

Zadanie zapisz w pliku o nazwie: **FirefoxDownloadStories.java**.

**Wskazówka:** Można wyłączyć pytanie się o potwierdzenie pobrania pliku lub skorzystać z klasy **Robot** i kliknąć na przycisk **Zapisz jako**.

