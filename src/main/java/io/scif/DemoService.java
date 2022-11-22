package io.scif;

import java.util.List;

import org.scijava.display.AbstractDisplay;
import org.scijava.display.Display;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.plugin.PluginService;
import org.scijava.service.AbstractService;
import org.scijava.service.Service;

//Context root
//Service connected to Context
@Plugin(type = Service.class)
//making a plugin here. it exists within a Context
public class DemoService extends AbstractService {

    // interface is used at type not the concrete class.
    // dont know what the concrete class will be
    // so PluginService not DefaultPluginService
    @Parameter
    private PluginService pluginService;

    // TODO create a method that gets all plugins of a particular Class (look at
    // type
    // hierarchy of ScijavaPlugin)
    // A service is a type of rich plugin
    // hierarchy:
    // SciJavaPlugin -> RichPlugin --> Service --> AbstractService

    public String toString() {
	return super.toString();
    }

    // this.getContext().getPluginIndex().getPlugins(null);

    /**
     * look at other plugins. See how they declare dependancies on services.
     * 
     * 
     */

    public List<DisplayPlugin> getDisplayPlugins() {

	// get plugin service from Context

	/*
	 * look at other Plugin. See how they declare dependancies on Service.
	 * 
	 * And then use this method of dependency declaration to add a dependancy on
	 * PluginService and replace the following code. to replace next 2 lines
	 * 
	 * would need to make instance of DisplayPlugin but not with new DisplayPlugin()
	 * beacuse it doesnt connect to a Context //Context root //Service connected to
	 * Context Context also connected to Service
	 * 
	 * Summarize: Add a dependanc on PluginService then use PluginSerivce to create
	 * the instance of the DisplayPlugin
	 */
	// pluginService at runtime is a concrete class provided by the Context because
	// of @parameter
	
	
	//this is null without context
	//it is an empty list with context
	List<DisplayPlugin> dp = pluginService.createInstancesOfType(DisplayPlugin.class);

	///list should be coming back populated by plugin servies
	//pluginService  didnt find any plugins, why?
	
	// dps.createInstance(new App);
	// dps.createInstance(this);
	return dp;
    }

}

/**
 * Overall: create another class that is a Plugin but not a Service
 * 
 * in App.java create a method that uses the PluginService to create instances
 * of this new plugin and return them
 * 
 * add a new test that calls this method twice and asserts different plugin
 * instances returned each time
 */

@Plugin(type = Display.class)
//making a plugin here. it exists within a Context
//not a Service
class DisplayPlugin extends AbstractDisplay<Integer> {

    public DisplayPlugin(Class<Integer> type) {
	super(type);
    }

    // Dont extend AbstractService because that is a Service
    // The type of object the display can visualize.
}
