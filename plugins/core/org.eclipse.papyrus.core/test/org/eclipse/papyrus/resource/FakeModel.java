/**
 * 
 */
package org.eclipse.papyrus.resource;

import org.eclipse.emf.ecore.resource.Resource;


/**
 * @author dumoulin
 *
 */
public class FakeModel extends AbstractBaseModel {

	private String identifier;
	
	public FakeModel(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * @see org.eclipse.papyrus.resource.AbstractBaseModel#getIdentifier()
	 *
	 * @return
	 */
	@Override
	public Object getIdentifier() {
		// TODO Auto-generated method stub
		return identifier;
	}

	/**
	 * @see org.eclipse.papyrus.resource.AbstractBaseModel#getModelFileExtension()
	 *
	 * @return
	 */
	@Override
	protected String getModelFileExtension() {
		// TODO Auto-generated method stub
		return identifier;
	}

	/**
	 * Get the associted resource.
	 * @return
	 */
	public Resource getResouce() {
		return resource;
	}
}
