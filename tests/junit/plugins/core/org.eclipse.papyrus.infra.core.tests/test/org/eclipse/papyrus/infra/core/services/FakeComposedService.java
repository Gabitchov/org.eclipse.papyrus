/**
 * 
 */
package org.eclipse.papyrus.infra.core.services;




/**
 * A fake composed service for testing purpose.
 * 
 * @author cedric dumoulin
 *
 */
public class FakeComposedService extends ComposedService<FakeComposedServicePart> {

	/**
	 * Call the same method on all associated service parts.
	 */
	public void walkService() {
		
		for( FakeComposedServicePart servicePart : serviceParts )
		{
			servicePart.walkService();
		}
	}

	@Override
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startService() throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disposeService() throws ServiceException {
		// TODO Auto-generated method stub
		
	}
	
}
