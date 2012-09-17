/**
 * 
 */
package org.eclipse.papyrus.infra.core.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;


/**
 * @author dumoulin
 *
 */
public class FakeModelWithSharedResource<T extends EObject> extends AbstractModelWithSharedResource<T> {

	private String identifier;
	private String fileExtension;
	private Class<T> expectedType;
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param kind
	 * @param identifier
	 * @param fileExtension
	 * @param expectedType
	 */
	public FakeModelWithSharedResource(ModelKind kind, String identifier, String fileExtension, Class<T> expectedType) {
        super(kind);
		this.identifier = identifier;
		this.expectedType = expectedType;
		this.fileExtension = fileExtension;
	}
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param kind
	 * @param identifier
	 * @param expectedType
	 */
	public FakeModelWithSharedResource(ModelKind kind, String identifier, Class<T> expectedType) {
		this(kind, identifier, "di", expectedType);
	}
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param identifier
	 * @param expectedType
	 */
	public FakeModelWithSharedResource(String identifier, Class<T> expectedType) {
		this(ModelKind.slave, identifier, expectedType);
	}
	
	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource#isModelRoot(org.eclipse.emf.ecore.EObject)
	 *
	 * @param object
	 * @return
	 */
	@Override
	protected boolean isModelRoot(EObject object) {
		return expectedType.isInstance(object);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#getIdentifier()
	 *
	 * @return
	 */
	@Override
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#getModelFileExtension()
	 *
	 * @return
	 */
	@Override
	protected String getModelFileExtension() {
		return fileExtension;
	}

	/**
	 * Get the associated resource.
	 * @return
	 */
	public Resource getResouce() {
		return resource;
	}
}
