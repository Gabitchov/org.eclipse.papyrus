/**
 * 
 */
package org.eclipse.papyrus.sasheditor.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.jface.action.MenuManager;
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
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;


/**
 * Run as normal test.
 * 
 * Can't be run as plugin test.
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
		

	}

	/**
	 * 
	 * @return
	 */
	protected Shell createShell() {
		
		Shell shell;
		
		try {
			// Initialize display from the workbench if we are started as plugin
			// This is not enough, because we aren't in the right thread :-(.
			// As a consequence, this doesn't work.
			display = PlatformUI.getWorkbench().getDisplay();
			
		} catch (Exception e) {
			// create a display if we are started as java code
			display = new Display();
		}
		
		shell = new Shell(display);
		return shell;

	}
	
	/**
	 * @see junit.framework.TestCase#tearDown()
	 * @throws java.lang.Exception
	 * 
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		if( display != null)
		  display.dispose();
	}

	/**
	 * Create a {@link SashWindowsContainer} to test. Initialize it with provided {@link ISashWindowsContentProvider}.
	 * 
	 * @param contentProvider
	 * @return
	 */
	protected SashWindowsContainer createSashWindowsContainer(ISashWindowsContentProvider contentProvider) {
		Shell shell = createShell();
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
		Collection<Object> results = pageVisitor.collected;
		assertEquals("list are of same size", models.size(), results.size());
		for(Object model : models) {
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
	public void testlookupModelPage() {
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
	
	/**
	 * Test method for {@link SashWindowsContainer#setFolderTabMenuManager(MenuManager)}
	 */
	public void testSetFolderTabMenuManager_MenuManager() {
		// Create 
		SimpleSashWindowsContentProvider contentProvider = new SimpleSashWindowsContentProvider();

		// Create pages and add them to the default folder
		List<IPageModel> models = new ArrayList<IPageModel>();
		for(int i = 0; i < 2; i++) {
			IPageModel newModel = new MessagePartModel("model" + i);
			contentProvider.addPage(newModel);
			models.add(newModel);
		}

		// Create new folders
		ITabFolderModel referenceFolder = contentProvider.getCurrentTabFolder();
		ITabFolderModel folder1 = contentProvider.createFolder(referenceFolder, SWT.TOP);
		ITabFolderModel folder2 = contentProvider.createFolder(referenceFolder, SWT.DOWN);
		ITabFolderModel folder3 = contentProvider.createFolder(referenceFolder, SWT.LEFT);

		// Create SashWindowsContainer
		SashWindowsContainer container = createSashWindowsContainer(contentProvider);
		// Set a MenuManager
		MenuManager menuManager = new MenuManager();
		container.setFolderTabMenuManager(menuManager);
		
		// Test if the menu has been set in already created folders.
		TabFolderPart folderPart = lookupTabFolderPart(container, referenceFolder);
		assertNotNull("menu exist", folderPart.getControl().getMenu() );;
		
		folderPart = lookupTabFolderPart(container, folder1);
		assertNotNull("menu exist", folderPart.getControl().getMenu() );;
		
		folderPart = lookupTabFolderPart(container, folder2);
		assertNotNull("menu exist", folderPart.getControl().getMenu() );;
		
		folderPart = lookupTabFolderPart(container, folder3);
		assertNotNull("menu exist", folderPart.getControl().getMenu() );;
		

		// Now create another tab, refresh the container in order that the part is created,
		// ant test it
		ITabFolderModel folder4 = contentProvider.createFolder(referenceFolder, SWT.RIGHT);
		container.refreshTabs();
		
		folderPart = lookupTabFolderPart(container, folder4);
		assertNotNull("menu exist", folderPart.getControl().getMenu() );;
		
	}

	protected TabFolderPart lookupTabFolderPart(SashWindowsContainer container, Object rawModel) {

		LookupFolderPartByRawModelVisitor visitor = new LookupFolderPartByRawModelVisitor(rawModel);
		container.visit(visitor);
		return visitor.result();
	}
}
