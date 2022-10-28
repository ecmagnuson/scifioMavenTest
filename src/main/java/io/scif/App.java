package io.scif;

import org.scijava.plugin.Plugin;
import org.scijava.service.AbstractService;
import org.scijava.service.Service;

@Plugin(type = Service.class)
public class App extends AbstractService {

    public int square(int num) {
	return num * num;
    }

    // TODO create a method that gets all plugins of a particular Class (look at type
    // hierarchy of ScijavaPlugin)
    //A service is a type of rich plugin
    //hierarchy:
    //SciJavaPlugin -> RichPlugin --> Service --> AbstractService
    
    /**
     * 
     * create another class that is a plugin but not a service 
     * in App.java create a method that uses the plugin service to create 
     * instances of this new plugin and return them
     * add a new test that calls this method twice and asserts different plugin
     * instances returned each time
     */

    public String toString() {
	return super.toString();
    }

    // this.getContext().getPluginIndex().getPlugins(null);

}
