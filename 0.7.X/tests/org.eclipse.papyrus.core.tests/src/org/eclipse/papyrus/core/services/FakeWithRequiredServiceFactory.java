package org.eclipse.papyrus.core.services;

import org.eclipse.papyrus.core.services.IServiceFactory;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;


/**
 * Fake service factory for testing purpose.
 * This service require the 
 * 
 * @author cedric dumoulin
 *
 */
public class FakeWithRequiredServiceFactory extends FakeServiceFactory implements IServiceFactory {


	/**
	 * 
	 * Constructor.
	 *
	 */
	public FakeWithRequiredServiceFactory() {

		super( "factoryName" + count++ );
	}
	
	/**
	 * Constructor.
	 *
	 * @param name
	 */
	public FakeWithRequiredServiceFactory(String name) {
		super(name);
	}

	
	/**
	 * 
	 * @see org.eclipse.papyrus.core.services.FakeService#init(org.eclipse.papyrus.core.services.ServicesRegistry)
	 *
	 * @param servicesRegistry
	 */
	@Override
	public void init(ServicesRegistry servicesRegistry) {
		
		trace.addTrace(name, "init");
		Object foundService = null;
		try {
			foundService = servicesRegistry.getService("C");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		trace.addTrace(name, "initEnd", foundService);
	}
}
