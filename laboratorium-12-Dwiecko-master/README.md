# Testowanie aplikacji JAVA 2017-2018
## Laboratorium 12 (Oczekiwania w Selenium WebDriver. Przeglądarki bezinterfejsowe)

-------------------------------------------

Wszystkie zadania mają być zapisane w **tym samym** utworzonym projekcie MAVEN!!!

-------------------------------------------

**Zadanie 1** (0.5 pkt)

Przerób któryś z poprzednich zadań, w którym używano technologii Selenium, tak aby była używana przeglądarka bezinterfejsowa PhantomJS oraz HtmlUnit.

-------------------------------------------

**Zadanie 2** (0.5 pkt). 

Napisz metodę **boolean isElementPresent(By by)**, która ma zwracać wartość true, jeśli znaleziono element, a false w przeciwnym przypadku. Przetestuj te metody w którymś z poprzednich zadań. 

Zadanie(implementacja wraz z testami) zapisz w pliku **ElementPresentTest.java**.

Wskazówka: Należy użyć metody **findElement(By by).**

------------------

**Zadanie 3** (0.5 pkt)

Jednym z najpopularniejszych używanych warunków w klasie **ExpectedCondition** są następujące metody: 

- ```elementToBeClicable(By locator)```
- ```elementToBeSelected(WebElement element)```
- ```presenceOfElementLocated(By locator)```
- ```textToBePresentInElement(By locator, java.lang.String text)```
- ```textToBePresentInElementValue(By locator, java.lang.String text)```
- ```titleContains(java.lang.String title)```

Napisz testy wykorzystując oczekiwanie jawne przy użyciu **wszystkich** powyżyszch warunków.

Testy zapisz w pliku o nazwie **ExpectedConditionTest.java**.

-----------------

**Zadanie 4** (0.5 pkt)

Oczekiwanie niejawne, oprócz znanej nam metody ```implicityWait()```, które zwleka do momenty pojawienia się elementu lub jego wyświetlenia przez ustalony okres przez użytkownika, zawiera również następujące metody: 

- ```pageLoadTimeout()```
- ```setScriptTimeout()```

Wyjaśnij w komentarzu znaczenia powyższych metod. Następnie napisz testy, które wykorzystują wyżej wymienione metody oczekiwania niejawnego. 

Zadanie zapisz w pliku **ImplicityWait.java**. 

----------------------

**Zadanie 5** (Dodatkowe - 0.5 pkt) 

Czasem synchronizacja jawna wymaga zastosowania niestandardowych oczekiwań (na przykład w przypadku aplikacji, które używają **Ajax**).

Przykład użycia takiego oczekiwania wygląda następująco: 

```
// Tutaj wejście na dowolną strone (driver.get())
try{
  driver.findElement(By.linkText("Text")).click();
  WebElement message = new WebDriverWait(driver, 5)
    .until(new ExpectedCondition<WebElement>(){
      @Override
      public WebElement apply(WebDriver d){
        return d.findElement(By.id("id"));
      }
    });
    //assercja, ktora korzysta z elementu message
} finally {
    driver.quit();
}
```

Napisz **trzy różne** testy, korzystając z powyższego schematu. 

**Wskazówka:** ```ExpectedCondition<WebElement>``` można zastąpić również jako ```ExpectedCondition<Boolean>```.

Zadanie zapisz w pliku **WaitCondition.java**.

-----------------------

**Zadanie 6** (Dodatkowe - 0.5 pkt) 

Schemat z zadania 5 możemy zastosować również do oczekiwania klasy ```FluentWait```. Napisz **jeden test**, używając podobnego schematu. 

Zadanie zapisz w pliku **FluentWaitCondition.java**.
