package io.scif;

import org.scijava.Context;
import org.scijava.display.AbstractDisplay;
import org.scijava.display.Display;
import org.scijava.plugin.DefaultPluginService;
import org.scijava.plugin.Plugin;
import org.scijava.service.AbstractService;
import org.scijava.service.Service;
//Context root
//Service connected to Context
@Plugin(type = Service.class)
//making a plugin here. it exists within a Context
public class DemoService extends AbstractService {

	public int square(int num) {
		return num * num;
	}

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
	
	public DisplayPlugin createDisplayInstance() {
		
		//get plugin service from Context
		Context ctx;
		ctx = getContext();
		/*
		 * look at other Plugin. See how they declare dependancies on services.
		 * 
		 * And then use this method of dependency declaration to add a dependancy on 
		 * PluginService and replace the following code. to replace next 2 lines 
		 * 
		 * would need to make instance of DisplayPlugin
		 * but not with new DisplayPlugin() beacuse it doesnt connect to a Context
		 * //Context root
			//Service connected to Context
			 * Context also connected to Service
			 * 
			 * Summarize:
			 * Add a dependanc on PluginService then use PluginSerivce to create
			 * the instance of the DisplayPlugin
		 */
		
		DefaultPluginService d = new DefaultPluginService();
		
		DefaultPluginService dps = d.createInstance(null);
		//dps.createInstance(new App);
		//dps.createInstance(this);
		return dps;
	}
}

/**
 * Overall:
 * create another class that is a Plugin but not a Service 
 * 
 * in App.java create a method that uses the PluginService to create instances of this new plugin
 * and return them 
 * 
 * add a new test that calls this method twice and asserts
 * different plugin instances returned each time
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
