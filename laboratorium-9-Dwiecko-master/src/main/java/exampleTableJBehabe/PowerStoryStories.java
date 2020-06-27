package exampleTableJBehabe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromURL;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import exampleTableJBehabe.steps.TabularSteps;

public class PowerStoryStories extends JUnitStories {
	
	 	public PowerStoryStories() {
	        EmbedderControls useStoryTimeoutInSecs = configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(true)
	                .doIgnoreFailureInView(true).useThreads(2).useStoryTimeoutInSecs(60);
	    }
	 	
	 	@Override
		public Configuration configuration(){
			return new MostUsefulConfiguration().useStoryReporterBuilder(getReporter()).
					useStoryLoader(new LoadFromURL());
		}
		
		@Override
		protected List<String> storyPaths() {
			String path = "**/resources/exampleTableJBehabe/stories/*.story";
			return new StoryFinder().findPaths(CodeLocations.codeLocationFromPath("").getFile(),
					Collections.singletonList(path),
					new ArrayList<String>(), "file:");
		}

		@Override 
		public InjectableStepsFactory stepsFactory(){
			return new InstanceStepsFactory(configuration(), new TabularSteps());
		}
		
		private StoryReporterBuilder getReporter(){
			return new StoryReporterBuilder().withPathResolver(new FilePrintStreamFactory.ResolveToSimpleName()
					).withDefaultFormats().withFormats(Format.CONSOLE, Format.HTML);
		}

//	    @Override
//	    public Configuration configuration() {
//	        Class<? extends Embeddable> embeddableClass = this.getClass();
//	        // Start from default ParameterConverters instance
//	        ParameterConverters parameterConverters = new ParameterConverters();
//	        // factory to allow parameter conversion and loading from external resources (used by StoryParser too)
//	        ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(), new LoadFromClasspath(embeddableClass), parameterConverters, null, new TableTransformers());
//	        // add custom converters
//	        parameterConverters.addConverters(new DateConverter(new SimpleDateFormat("yyyy-MM-dd")),
//	                new ExamplesTableConverter(examplesTableFactory));
//	        return new MostUsefulConfiguration()
//	            .useStoryLoader(new LoadFromClasspath(embeddableClass))
//	            .useStoryParser(new RegexStoryParser(examplesTableFactory)) 
//	            .useStoryReporterBuilder(new StoryReporterBuilder()
//	                .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
//	                .withDefaultFormats()
//	                .withFormats(CONSOLE, TXT, HTML, XML))
//	            .useParameterConverters(parameterConverters);
//	    }
//
//	    @Override
//	    public InjectableStepsFactory stepsFactory() {
//	        return new InstanceStepsFactory(configuration(), new TabularSteps());
//	    }
//
//	    @Override
//	    protected List<String> storyPaths() {
//	        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/*.story", "**/excluded*.story");
//	                
//	    }
	 	
	
}
