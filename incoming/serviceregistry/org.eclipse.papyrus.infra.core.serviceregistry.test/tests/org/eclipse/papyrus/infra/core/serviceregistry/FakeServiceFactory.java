package org.eclipse.papyrus.infra.core.serviceregistry;



/**
 * Fake service factory for testing purpose.
 * 
 * @author cedric dumoulin
 * 
 */
public class FakeServiceFactory extends FakeService implements IServiceFactory {


	/**
	 * 
	 * Constructor.
	 * 
	 */
	public FakeServiceFactory() {

		super("factoryName" + count++);
	}

	/**
	 * Constructor.
	 * 
	 * @param name
	 */
	public FakeServiceFactory(String name) {
		super(name);
	}


	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Create the service
	 * 
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.IServiceFactory#createServiceInstance()
	 * 
	 * @return
	 */
	public Object createServiceInstance() {
		trace.addTrace(getName(), "createInstance");
		return new FakeCreatedService();
	}

	/**
	 * Pseudo service created by the factory.
	 * 
	 * @author dumoulin
	 * 
	 */
	public class FakeCreatedService {

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
	}
}
