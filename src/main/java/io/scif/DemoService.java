package io.scif;

import java.util.List;

import org.scijava.display.Display;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.plugin.PluginService;
import org.scijava.service.AbstractService;
import org.scijava.service.Service;

// 1. A Service is a type of Plugin
// 2. A Display is a type of Plugin
// 3. A Plugin is added functionality
// 4. SciJava provides many default plugins, but users can add their own
// 5. DefaultPluginFinder can find these plugins that have {@link Plugin} annotation
// 6. A Context finds/discovers all Plugins, only creates Services though. 

/* 7. So initializing my DisplayPlugin will raise an error, becuase a Display is a 
 *  Plugin but it is not a Service */
// 8. When creating your own Service, it's encouranged to extend AbstractService
// 9. Anything that has a Context is a Contextual 

/* 10.When I make the DemoService below, and give it the {@link Plugin} @Plugin(type = Service.class)
 *    then the PluginFinder will find it. The PluginFinder belongs to a Context and it will be
 *    findable as a Service
 */

@Plugin(type = Service.class)
//making a plugin of type Service here. It exists within a Context, with all other Services?
//SciJavaPlugin -> RichPlugin --> Service --> AbstractService
public class DemoService extends AbstractService {

    // PluginService not DefaultPluginService, raise to interface not concrete class
    // pluginService at runtime is a concrete class provided by the Context because
    // of @parameter

    // field with @parameter annotation is how to declare depenencies
    @Parameter
    private PluginService pluginService;

    // TODO think about this
    // this.getContext().getPluginIndex().getPlugins(null);

    // create a method that gets all plugins of a particular
    // Class (look at type hierarchy of ScijavaPlugin)
    // look at other Plugin. See how they declare dependancies on Service.
    // They do that via PluginService
    public List<Display> getDisplayPlugins() {

	// get PluginService from Context

	// null without Context or NPE
	// Context finds the Plugins so if no Context cant fine PluginService

	// empty list with Context

	// make instance of DisplayPlugin, using createInstanceOfType(),
	// will connect it to a Context
	// Add a dependency on PluginService then use PluginSerivce to create
	// the instance of the DisplayPlugin

	// So instead of createInstaneOfType(DemoDisplayPlugin) aka the concrete class
	// use the Plugin type
	List<Display> dp = pluginService.createInstancesOfType(Display.class);

	/// list should be coming back populated by plugin servies
	// pluginService didn't find any plugins, why?

	return dp;
    }

}