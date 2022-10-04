package io.scif;

import org.scijava.plugin.Plugin;
import org.scijava.service.AbstractService;
import org.scijava.service.Service;

@Plugin(type = Service.class)
public class App extends AbstractService {
    
    public int square(int num) {
	return num * num;
    }
    
    

}
