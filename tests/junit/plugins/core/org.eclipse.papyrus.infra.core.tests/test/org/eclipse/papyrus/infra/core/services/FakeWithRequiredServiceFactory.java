package org.eclipse.papyrus.infra.core.services;



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
	 * @see org.eclipse.papyrus.infra.core.services.FakeService#init(org.eclipse.papyrus.infra.core.services.ServicesRegistry)
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
