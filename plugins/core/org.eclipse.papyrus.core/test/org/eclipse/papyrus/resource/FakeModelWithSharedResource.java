/**
 * 
 */
package org.eclipse.papyrus.resource;

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
	
	public FakeModelWithSharedResource(ModelKind kind, String identifier, String fileExtension, Class<T> expectedType) {
        super(kind);
		this.identifier = identifier;
		this.expectedType = expectedType;
		this.fileExtension = fileExtension;
	}
	
	public FakeModelWithSharedResource(ModelKind kind, String identifier, Class<T> expectedType) {
		this(kind, identifier, "di", expectedType);
	}
	
	public FakeModelWithSharedResource(String identifier, Class<T> expectedType) {
		this(ModelKind.slave, identifier, expectedType);
	}
	
	@Override
	protected boolean isModelRoot(EObject object) {
		return expectedType.isInstance(object);
	}

	@Override
	public Object getIdentifier() {
		return identifier;
	}

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
