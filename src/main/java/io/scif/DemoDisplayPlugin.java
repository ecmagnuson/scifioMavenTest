package io.scif;

import org.scijava.display.AbstractDisplay;
import org.scijava.display.Display;
import org.scijava.plugin.Plugin;

/**
 * Overall: create another class that is a Plugin but not a Service
 * 
 * in DemoService.java create a method that uses the PluginService to create instances
 * of this new plugin and return them
 * 
 * add a new test that calls this method twice and asserts different plugin
 * instances returned each time
 */
@Plugin(type = Display.class)
//making a plugin here. it exists within a Context not a Service
class DemoDisplayPlugin extends AbstractDisplay<Integer> {

	//when making a Plugin need 0 param constructor so framework can
	//create Plugin instance
	
	public DemoDisplayPlugin() {
		super(Integer.class);
	}

  // Dont extend AbstractService because that is a Service
  // The type of object the display can visualize.
}
