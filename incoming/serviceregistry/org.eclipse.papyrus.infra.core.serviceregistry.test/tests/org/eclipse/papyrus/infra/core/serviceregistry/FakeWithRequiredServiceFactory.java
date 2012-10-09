package org.eclipse.papyrus.infra.core.serviceregistry;

import org.eclipse.papyrus.infra.core.serviceregistry.IServiceFactory;
import org.eclipse.papyrus.infra.core.serviceregistry.ServicesRegistry;


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
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.FakeService#init(org.eclipse.papyrus.infra.core.serviceregistry.ServicesRegistry)
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
