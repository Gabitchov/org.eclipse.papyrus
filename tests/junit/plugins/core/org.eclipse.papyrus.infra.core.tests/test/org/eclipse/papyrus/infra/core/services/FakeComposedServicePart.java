/**
 * 
 */
package org.eclipse.papyrus.infra.core.services;



/**
 * A fake composed service part for testing purpose.
 * @author cedric dumoulin
 *
 */
public class FakeComposedServicePart extends ComposedServicePart<FakeComposedService> {

	
	public FakeComposedServicePart() {
		super(FakeComposedService.class);
	}

	/**
	 * A common method.
	 */
	public void walkService() {
		// TODO Auto-generated method stub
		
	}
}
