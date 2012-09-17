/**
 * 
 */
package org.eclipse.papyrus.infra.core.resource;



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
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#getIdentifier()
	 *
	 * @return
	 */
	@Override
	public String getIdentifier() {
		// TODO Auto-generated method stub
		return identifier;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#getModelFileExtension()
	 *
	 * @return
	 */
	@Override
	protected String getModelFileExtension() {
		// TODO Auto-generated method stub
		return identifier;
	}

}
