/**
 * 
 */
package org.eclipse.papyrus.sasheditor.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.sasheditor.contentprovider.ITabFolderModel;
import org.eclipse.papyrus.sasheditor.contentprovider.simple.SimpleSashWindowsContentProvider;
import org.eclipse.papyrus.sasheditor.editor.IComponentPage;
import org.eclipse.papyrus.sasheditor.editor.IEditorPage;
import org.eclipse.papyrus.sasheditor.editor.IPage;
import org.eclipse.papyrus.sasheditor.editor.IPageVisitor;
import org.eclipse.papyrus.sasheditor.editor.MessagePartModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


/**
 * Run as normal test.
 * 
 * @author dumoulin
 * 
 */
public class SashWindowsContainerTest extends TestCase {


	protected Display display;

	/**
	 * Constructor.
	 * 
	 * @param name
	 */
	public SashWindowsContainerTest(String name) {
		super(name);
	}

	/**
	 * @see junit.framework.TestCase#setUp()
	 * @throws java.lang.Exception
	 * 
	 */
	protected void setUp() throws Exception {
		super.setUp();
		display = new Display();

	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 * @throws java.lang.Exception
	 * 
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		display.dispose();
	}

	/**
	 * Create a {@link SashWindowsContainer} to test. Initialize it with provided {@link ISashWindowsContentProvider}.
	 * 
	 * @param contentProvider
	 * @return
	 */
	protected SashWindowsContainer createSashWindowsContainer(ISashWindowsContentProvider contentProvider) {
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());

		//
		//new ShellEditor(shell);
		SashWindowsContainer sashWindowContainer = new SashWindowsContainer();

		sashWindowContainer.setContentProvider(contentProvider);

		sashWindowContainer.createPartControl(shell);
		//		shell.open();
		return sashWindowContainer;
	}

	/**
	 * Create a contentProvider.
	 * 
	 * @return
	 */
	protected ISashWindowsContentProvider createContentProvider() {
		SimpleSashWindowsContentProvider contentProvider = new SimpleSashWindowsContentProvider();

		// Create pages and add them to the default folder
		List<IPageModel> models = new ArrayList<IPageModel>();
		for(int i = 0; i < 8; i++) {
			IPageModel newModel = new MessagePartModel("model" + i);
			contentProvider.addPage(newModel);
			models.add(newModel);
		}

		return contentProvider;
	}

	/**
	 * Test the method on a model with several folders and page.
	 * Test method for {@link org.eclipse.papyrus.sasheditor.internal.SashWindowsContainer#getActiveEditor()}.
	 */
	public void testGetActiveEditor() {
		// Create 
		SimpleSashWindowsContentProvider contentProvider = new SimpleSashWindowsContentProvider();

		// Create pages and add them to the default folder
		List<IPageModel> models = new ArrayList<IPageModel>();
		for(int i = 0; i < 2; i++) {
			IPageModel newModel = new MessagePartModel("model" + i);
			contentProvider.addPage(newModel);
			models.add(newModel);
		}

		// Create new folder
		ITabFolderModel folder = contentProvider.getCurrentTabFolder();
		contentProvider.createFolder(folder, 1, folder, SWT.TOP);

		// Get the active editor
		SashWindowsContainer container = createSashWindowsContainer(contentProvider);
		IPage page = container.getActiveSashWindowsPage();
		assertNotNull("Page exist", page);
	}

	/**
	 * Test the method on a model with no pages.
	 * Test method for {@link org.eclipse.papyrus.sasheditor.internal.SashWindowsContainer#getActiveEditor()}.
	 */
	public void testGetActiveEditorNoPage() {
		// Create 
		SimpleSashWindowsContentProvider contentProvider = new SimpleSashWindowsContentProvider();


		// Get the active editor
		SashWindowsContainer container = createSashWindowsContainer(contentProvider);
		IPage page = container.getActiveSashWindowsPage();
		assertNull("No Page exist", page);
	}


	/**
	 * Test method for {@link org.eclipse.papyrus.sasheditor.internal.SashWindowsContainer#refreshTabs()}.
	 */
	public void testRefreshTabs() {

		ISashWindowsContentProvider contentProvider = createContentProvider();
		SashWindowsContainer container = createSashWindowsContainer(contentProvider);

		container.refreshTabs();
		assertNotNull("container is set", container);

	}

	/**
	 * Test method for {@link org.eclipse.papyrus.sasheditor.internal.SashWindowsContainer#refreshTabs()}.
	 */
	public void testRefreshTabs2() {

		// Test 2 folders, one tab each. Then supress one tabs.
		// 1 folder with one tab should remain. 
		SimpleSashWindowsContentProvider contentProvider = new SimpleSashWindowsContentProvider();

		// Create pages and add them to the default folder
		List<IPageModel> models = new ArrayList<IPageModel>();
		for(int i = 0; i < 2; i++) {
			IPageModel newModel = new MessagePartModel("model" + i);
			contentProvider.addPage(newModel);
			models.add(newModel);
		}

		// Create new folder
		ITabFolderModel folder = contentProvider.getCurrentTabFolder();
		contentProvider.createFolder(folder, 1, folder, SWT.TOP);

		// Create the container
		SashWindowsContainer container = createSashWindowsContainer(contentProvider);
		container.refreshTabs();
		assertNotNull("container is set", container);

	}

	/**
	 * Test method for {@link SashWindowsContainer#visit(org.eclipse.papyrus.sasheditor.editor.IPageVisitor)}
	 */
	public void testVisit() {
		// Create 
		SimpleSashWindowsContentProvider contentProvider = new SimpleSashWindowsContentProvider();

		// Create pages and add them to the default folder
		List<IPageModel> models = new ArrayList<IPageModel>();
		for(int i = 0; i < 2; i++) {
			IPageModel newModel = new MessagePartModel("model" + i);
			contentProvider.addPage(newModel);
			models.add(newModel);
		}

		// Create new folder
		ITabFolderModel folder = contentProvider.getCurrentTabFolder();
		contentProvider.createFolder(folder, 1, folder, SWT.TOP);

		// Get the active editor
		SashWindowsContainer container = createSashWindowsContainer(contentProvider);
		
		CollectRawModelVisitor pageVisitor = new CollectRawModelVisitor();
		container.visit(pageVisitor);
		
		// Check each elements
		Collection results = pageVisitor.collected;
		assertEquals("list are of same size", models.size(), results.size());
		for( Object model : models)
		{
			assertTrue("model is in the collected list", results.contains(model));
		}
	}
	
	protected class CollectRawModelVisitor implements IPageVisitor {

		Collection<Object> collected = new ArrayList<Object>();
		
		public void accept(IComponentPage page) {
			collected.add(page.getRawModel());			
		}

		public void accept(IEditorPage page) {
			collected.add(page.getRawModel());			
		}
	}
	
	/**
	 * Test the lookup of a page by its raw model
	 * Test method for {@link SashWindowsContainer#lookupModelPage(Object)}
	 */
	public void testlookupModelPage()
	{
		// Create 
		SimpleSashWindowsContentProvider contentProvider = new SimpleSashWindowsContentProvider();

		// Create pages and add them to the default folder
		List<IPageModel> models = new ArrayList<IPageModel>();
		for(int i = 0; i < 2; i++) {
			IPageModel newModel = new MessagePartModel("model" + i);
			contentProvider.addPage(newModel);
			models.add(newModel);
		}

		// Create new folder
		ITabFolderModel folder = contentProvider.getCurrentTabFolder();
		contentProvider.createFolder(folder, 1, folder, SWT.TOP);

		// Get the active editor
		SashWindowsContainer container = createSashWindowsContainer(contentProvider);

		Object model = models.get(1);
		IPage foundPage = container.lookupModelPage(model);
		assertEquals("Corresponding page is found", foundPage.getRawModel(), model);
	}
}
