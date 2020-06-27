package JBehaveDemo;



import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

import java.util.List;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.SilentStepMonitor;
import org.jbehave.web.selenium.ContextView;
import org.jbehave.web.selenium.LocalFrameContextView;
import org.jbehave.web.selenium.PerStoryWebDriverSteps;
import org.jbehave.web.selenium.PropertyWebDriverProvider;
import org.jbehave.web.selenium.SeleniumConfiguration;
import org.jbehave.web.selenium.SeleniumContext;
import org.jbehave.web.selenium.SeleniumStepMonitor;
import org.jbehave.web.selenium.WebDriverProvider;
import org.jbehave.web.selenium.WebDriverScreenshotOnFailure;
import org.jbehave.web.selenium.WebDriverSteps;

public class GoogleTest extends JUnitStories {

	private WebDriverProvider driverProvider = new PropertyWebDriverProvider(); // Pusty dla FirefoxDriver 
	// Istnieją różne metody tworzenia WebDriverProvider: 
	// new PropertyWebDriverProvider()
	// new TypeWebDriverProvider()
	// new RemoteWebDriverProvider()
	// Oczywiście nie trzeba z tego korzystac -> mozna korzystac z WebDriver
	
	// PerStoryWebDriverSteps -> odpal WebDriver dla kazdej historii lub raz
    private WebDriverSteps lifecycleSteps = new PerStoryWebDriverSteps(driverProvider); // or PerStoryWebDriverSteps(driverProvider)
    // SeleniumContext odpowiada za pobieranie aktualnego scenariusza
    private SeleniumContext context = new SeleniumContext();
    // ContextView w tym przypadku mowi o rozmiarach ramki z przebiegiem scenariusza
    private ContextView contextView = new LocalFrameContextView().sized(500, 100);

    public GoogleTest() {
    	System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
    	System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
	}

	@Override
    public Configuration configuration() {
        Class<? extends Embeddable> embeddableClass = this.getClass();
        return new SeleniumConfiguration()
                .useSeleniumContext(context)
                .useWebDriverProvider(driverProvider)
                .useStepMonitor(new SeleniumStepMonitor(contextView, context, new SilentStepMonitor()))
                .useStoryLoader(new LoadFromClasspath(embeddableClass))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                    .withCodeLocation(codeLocationFromClass(embeddableClass))
                    .withDefaultFormats()
                    .withFormats(Format.CONSOLE, Format.TXT));
    }
 
    @Override
    public InjectableStepsFactory stepsFactory() {
        Configuration configuration = configuration();
        return new InstanceStepsFactory(configuration, 
                new GoogleSteps(driverProvider),
                lifecycleSteps,
                new WebDriverScreenshotOnFailure(driverProvider, configuration.storyReporterBuilder()));
    }
	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(
				codeLocationFromClass(this.getClass()).getFile(),
				asList("**/*.story"), null);
	}

	

}
