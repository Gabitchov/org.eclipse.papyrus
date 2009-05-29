/**
 * 
 */
package org.eclipse.papyrus.core.dicontentprovider;

import java.io.File;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.papyrus.di.Diagram;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;

import junit.framework.TestCase;


/**
 * @author dumoulin
 */
public class EMFSashModelTest extends TestCase {

	
	protected DiSashModelMngr emfSashModel;
	protected Resource diResource;
	
	/**
	 * Constructor.
	 * @param name
	 */
	public EMFSashModelTest(String name) {
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
		
		emfSashModel = new DiSashModelMngr(diResource);
	}

	/**
	 * {@inheritDoc}
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	
	/**
	 * Test method for {@link org.eclipse.papyrus.core.dicontentprovider.DiSashModelMngr#EMFSashModel(Resource)}.
	 */
	public void testDefaultConstructor() {
		Object root = emfSashModel.getRootPanel();
		assertNotNull("root is set", root);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.core.dicontentprovider.DiSashModelMngr#getRootPanel()}.
	 */
	public void testGetRootPanel() {
		
		Object root = emfSashModel.getRootPanel();
		
		assertNotNull("root is set", root);
		assertTrue("root typed PanelModel", emfSashModel.isPanelModel(root) );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.core.dicontentprovider.DiSashModelMngr#isRootModel(java.lang.Object)}.
	 */
	public void testIsRootModel() {
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.core.dicontentprovider.DiSashModelMngr#isTabFolderModel(java.lang.Object)}.
	 */
	public void testIsTabFolderModel() {
		Diagram node = emfSashModel.createTabFolderNode();
		assertNotNull("node created", node);
		assertTrue("right type", emfSashModel.isTabFolderModel(node) );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.core.dicontentprovider.DiSashModelMngr#isSashPanelModel(java.lang.Object)}.
	 */
	public void testIsSashPanelModel() {
		Diagram node = emfSashModel.createVerticalSashPanelNode();
		assertNotNull("node created", node);
		assertTrue("right type", emfSashModel.isVerticalSashPanelModel(node) );
		assertTrue("right type", emfSashModel.isPanelModel(node) );
		
		node = emfSashModel.createHorizontalSashPanelNode();
		assertNotNull("node created", node);
		assertTrue("right type", emfSashModel.isHorizontalSashPanelModel(node) );
		assertTrue("right type", emfSashModel.isPanelModel(node) );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.core.dicontentprovider.DiSashModelMngr#isEditorModel()}.
	 */
	public void testIsEditorModel() {
		Diagram node = emfSashModel.createEditorNode();
		assertNotNull("node created", node);
		assertTrue("right type", emfSashModel.isEditorModel(node) );
		assertTrue("right type", emfSashModel.isPageModel(node) );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.core.dicontentprovider.DiSashModelMngr#isComponentModel()}.
	 */
	public void testIsComponentModel() {
		Diagram node = emfSashModel.createComponentNode();
		assertNotNull("node created", node);
		assertTrue("right type", emfSashModel.isComponentModel(node) );
		assertTrue("right type", emfSashModel.isPageModel(node) );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.core.dicontentprovider.DiSashModelMngr#getTabFolderNodeChildren(java.lang.Object)}.
	 */
	public void testGetTabFolderNodeChildren() {
		Diagram editor1 = emfSashModel.createEditorNode();
		Diagram editor2 = emfSashModel.createEditorNode();
		
		Diagram tabFolder = (Diagram)emfSashModel.getRootPanel();
		emfSashModel.addPageNodeToTabFolder(tabFolder, 0, editor1);
		emfSashModel.addPageNodeToTabFolder(tabFolder, 1, editor2);
		
		// Retrieve childs by appropriate method.
		List<?> list = emfSashModel.getTabFolderNodeChildren(tabFolder);
		assertEquals("editor1", editor1, list.get(0));
		assertEquals("editor2", editor2, list.get(1));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.core.dicontentprovider.DiSashModelMngr#addPageNodeToTabFolder(java.lang.Object, int, java.lang.Object)}.
	 */
	public void testAddPageNodeToTabFolder() {
		
		Diagram editor1 = emfSashModel.createEditorNode();
		Diagram editor2 = emfSashModel.createEditorNode();
		
		Diagram tabFolder = (Diagram)emfSashModel.getRootPanel();
		emfSashModel.addPageNodeToTabFolder(tabFolder, 0, editor1);
		emfSashModel.addPageNodeToTabFolder(tabFolder, 1, editor2);
		
		List<?> list = tabFolder.getContained();
		assertEquals("editor1", editor1, list.get(0));
		assertEquals("editor2", editor2, list.get(1));
	}

}
