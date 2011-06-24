/**
 * 
 */
package org.eclipse.papyrus.resource;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.resource.AbstractBaseModel;
import org.eclipse.papyrus.resource.ModelSet;


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
	public String getIdentifier() {
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

}
