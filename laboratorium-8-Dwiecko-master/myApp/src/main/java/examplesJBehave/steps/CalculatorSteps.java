package examplesJBehave.steps;
import examplesJBehave.steps.Calculator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.*;
public class CalculatorSteps{
    
    private Calculator calc;
    private boolean logicalResult;
    private int result;

    @BeforeScenario(uponType = ScenarioType.EXAMPLE)
    public void buildUp(){
        result = 0;
        logicalResult = false;
    }

@AfterScenario(uponOutcome=AfterScenario.Outcome.SUCCESS, uponType = ScenarioType.EXAMPLE)
    public void success() {
        System.out.println("SUCCESS!");
    }
    @AfterScenario(uponOutcome=AfterScenario.Outcome.FAILURE, uponType = ScenarioType.EXAMPLE)
    public void fail() {
        System.out.println("FAIL!");
    }

	@Given("new calculator")
	public void givennewcalculator(){
        calc = new Calculator();
	}
    
    @When("I add 4 and 10")
	public void whenIadd4and10(){
      result = calc.add(4, 10);
    }
	@Then("I receive 14")
	public void thenIreceive14(){
		 assertEquals(14, result);
    }

    @When("I sub 4 and 4")
	public void whenIsub4and10(){
        result = calc.sub(4, 4);
    }
    @Then("the result is 0")
    @Alias("the result becomes 0")
	public void thenTheResultIs0(){
		 assertEquals(0, result);
    }

    @When("I div 4 and 4")
	public void whenIdiv4and4(){
      result = calc.div(4, 4);
    }
    @Then("I receive 1")
	public void thenIreceive1(){
		 assertEquals(1, result);
    }

    @When("I multiply 1 and 5")
	public void whenImultiply1and5(){
      result = calc.multi(1,5);
    }
    @Then("I receive 5")
	public void thenIreceive5(){
		 assertEquals(5, result);
    }

    @When("I pass 4 and 4")
	public void whenIpass4and4(){
        logicalResult = calc.equality(4, 4);
    }   
    @Then("I receive true for 4 and 4")
	public void thenIreceivetruefor4and4(){
		 assertTrue(logicalResult);
    }

    @When("I pass 1 and 4")
	public void whenIpass1and4(){
        logicalResult = calc.equality(4, 4);
    }   
    @Then("I receive true for 1 and 4")
	public void thenIreceivetruefor1and4(){
		 assertTrue(logicalResult);
    }

    @When("I pass for less $firstnumber $secondnumber")
    public void whenIpassforless(@Named("firstnumber") int firstnumber,
                                 @Named("secondnumber")int secondnumber){
        
        logicalResult = calc.less(firstnumber, secondnumber);
    }
    @Then("I receive true")
    public void thenIreceivetrue(){
		 assertTrue(logicalResult);
    }

    @When("I add $firsttoaddnumber $secondtoaddnumber")
    public void whenIadd(@Named("firsttoaddnumber") int firsttoaddnumber,
                          @Named("secondtoaddnumber")int secondtoaddnumber){
        
        result = calc.add(firsttoaddnumber, secondtoaddnumber);
    }
    @Then("What I receive is $result")
    public void thenWhatIreceiveis(@Named("result") int resultFromTable){
		 assertEquals(result, resultFromTable);
    }

    
    
}