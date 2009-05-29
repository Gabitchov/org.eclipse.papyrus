/**
 * 
 */
package org.eclipse.papyrus.core.dicontentprovider;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;

import junit.framework.TestCase;


/**
 * @author dumoulin
 */
public class DiContentProviderTest extends TestCase {

	
	protected ISashWindowsContentProvider contentProvider;
	protected DiContentProvider diContentProvider;
	protected Resource diResource;
	
	/**
	 * Constructor.
	 * @param name
	 */
	public DiContentProviderTest(String name) {
		super(name);
		
		// Create di resource
		ResourceSet resourceSet = new ResourceSetImpl();
		
		// Register the default resource factory -- only needed for stand-alone!
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(new File("tempfile.di").getAbsolutePath());

		diResource = resourceSet.createResource(fileURI); 

	}

	/**
	 * {@inheritDoc}
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		diResource.getContents().clear();
		
		diContentProvider = new DiContentProvider(diResource, null, null);
		contentProvider = diContentProvider;
	}

	/**
	 * {@inheritDoc}
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.core.dicontentprovider.DiContentProvider#getRootPanel()}.
	 */
	public void testGetRootPanel() {
		
		Object root = contentProvider.getRootModel();
		
		assertNotNull("root is set", root);
	}


	
}
