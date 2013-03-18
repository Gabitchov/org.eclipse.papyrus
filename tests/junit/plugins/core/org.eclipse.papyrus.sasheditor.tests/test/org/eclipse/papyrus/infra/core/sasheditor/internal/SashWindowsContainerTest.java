/*****************************************************************************
 * Copyright (c) 2009-2013 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.sasheditor.internal;

import static org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.SashPagesModelFactory.folder;
import static org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.SashPagesModelFactory.page;
import static org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.SashPagesModelFactory.vSash;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowContentProviderUtils;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IComponentPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IEditorPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPageVisitor;
import org.eclipse.papyrus.infra.core.sasheditor.editor.MessagePartModel;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.IModelExp;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.PagesModelException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Run as normal test.
 * 
 * @author cedric dumoulin
 * 
 */
public class SashWindowsContainerTest {


	protected Display display;

	/**
	 * Constructor.
	 * 
	 * @param name
	 */
	public SashWindowsContainerTest() {
	}

	/**
	 * @see junit.framework.TestCase#setUp()
	 * @throws java.lang.Exception
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		display = Display.getCurrent();
		if(display == null) {
			display = new Display();
		}

	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 * @throws java.lang.Exception
	 * 
	 */
	@After
	public void tearDown() throws Exception {
		//display.dispose();
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
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.internal.SashWindowsContainer#getActiveEditor()}.
	 */
	@Test
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
	 * Test the method on a model with several folders and page.
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.internal.SashWindowsContainer#getActiveEditor()}.
	 * Use new implementation to populate contentProvider
	 * @throws PagesModelException 
	 */
	@Test
	public void testGetActiveEditor2() throws PagesModelException {

		// Create populated content provider
		SimpleSashWindowsContentProvider contentProvider = new SimpleSashWindowsContentProvider();
		SimpleSashWindowContentProviderUtils helper = new SimpleSashWindowContentProviderUtils(contentProvider);
		
		// define how to populate contentProvider
		IModelExp expr = vSash( folder( "f1", page("p11"), page("p12")), folder( "f2", page("p21")));
		// Try to create the model
		helper.createModel(expr);

		
		// Get the active editor
		SashWindowsContainer container = createSashWindowsContainer(contentProvider);
		IPage page = container.getActiveSashWindowsPage();
		assertNotNull("Page exist", page);
	}

	/**
	 * Test the method on a model with several folders and page.
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.internal.SashWindowsContainer#getActiveEditor()}.
	 */
	@Test
	public void testGetVisiblePages() {
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
		// Add pages
		List<IPageModel> modelsInFolder2 = new ArrayList<IPageModel>();
		for(int i = 0; i < 2; i++) {
			IPageModel newModel = new MessagePartModel("modelInFolder2" + i);
			contentProvider.addPage(newModel);
			modelsInFolder2.add(newModel);
		}

		// Build a list of expected visible models
		List<IPageModel> expectedVisibleModel = new ArrayList<IPageModel>();
		expectedVisibleModel.add(models.get(models.size() - 1));
		expectedVisibleModel.add(modelsInFolder2.get(models.size() - 1));

		// Get the active editor
		SashWindowsContainer container = createSashWindowsContainer(contentProvider);
		List<IPage> pages = container.getVisiblePages();

		assertEquals("2 pages visible", 2, pages.size());
		assertTrue("contains active from folder 1", expectedVisibleModel.contains(pages.get(0).getRawModel()));
		assertTrue("contains active from folder 1", expectedVisibleModel.contains(pages.get(1).getRawModel()));
		//		assertNotNull("Page exist", page);
	}

	/**
	 * Test the method on a model with several folders and page.
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.internal.SashWindowsContainer#getActiveEditor()}.
	 * Use new implementation to populate contentProvider
	 * @throws PagesModelException 
	 */
	@Test
	public void testGetVisiblePages2() throws PagesModelException {
		// Create populated content provider
		SimpleSashWindowsContentProvider contentProvider = new SimpleSashWindowsContentProvider();
		SimpleSashWindowContentProviderUtils helper = new SimpleSashWindowContentProviderUtils(contentProvider);
		
		// define how to populate contentProvider
		IModelExp expr = vSash( folder( "f1", page("p11"), page("p12")), folder( "f2", page("p21"), page("p22")));
		// Try to create the model
		helper.createModel(expr);
		// Get the references
		Map<String, Object> models = helper.queryModel(expr);


		// Create the container
		SashWindowsContainer container = createSashWindowsContainer(contentProvider);
		// Get visible pages
		List<IPage> pages = container.getVisiblePages();
		// Build a list of raw models
		List<Object> visibleModels = new ArrayList<Object>();
		for( IPage page : pages) {
			visibleModels.add(page.getRawModel());
		}
		
		assertEquals("2 pages visible", 2, pages.size());
		assertTrue("contains active page from folder 1", visibleModels.contains(models.get("p11")));
		assertTrue("contains active page from folder 2", visibleModels.contains(models.get("p22")));
		
		// Check orders
		assertEquals(models.get("p11"), pages.get(0).getRawModel());
		assertEquals(models.get("p22"), pages.get(1).getRawModel());
	}

	/**
	 * Test the method on a model with only one folder.
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.internal.SashWindowsContainer#getActiveEditor()}.
	 * Use new implementation to populate contentProvider
	 * @throws PagesModelException 
	 */
	@Test
	public void testGetVisiblePagesOneFoler() throws PagesModelException {
		// Create populated content provider
		SimpleSashWindowsContentProvider contentProvider = new SimpleSashWindowsContentProvider();
		SimpleSashWindowContentProviderUtils helper = new SimpleSashWindowContentProviderUtils(contentProvider);
		
		// define how to populate contentProvider
		IModelExp expr = folder( "f1", page("p11"), page("p12"), page("p13"));
		// Try to create the model
		helper.createModel(expr);
		// Get the references
		Map<String, Object> models = helper.queryModel(expr);


		// Create the container
		SashWindowsContainer container = createSashWindowsContainer(contentProvider);
		// Get visible pages
		List<IPage> pages = container.getVisiblePages();
		// Build a list of raw models
		List<Object> visibleModels = new ArrayList<Object>();
		for( IPage page : pages) {
			visibleModels.add(page.getRawModel());
		}
		
		assertEquals("1 pages visible", 1, pages.size());
		assertTrue("contains active page from folder 1", visibleModels.contains(models.get("p11")));
		
		// Check orders
		assertEquals(models.get("p11"), pages.get(0).getRawModel());
	}

	/**
	 * Test the method on a model with no pages.
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.internal.SashWindowsContainer#getActiveEditor()}.
	 */
	@Test
	public void testGetActiveEditorNoPage() {
		// Create 
		SimpleSashWindowsContentProvider contentProvider = new SimpleSashWindowsContentProvider();


		// Get the active editor
		SashWindowsContainer container = createSashWindowsContainer(contentProvider);
		IPage page = container.getActiveSashWindowsPage();
		assertNull("No Page exist", page);
	}

	/**
	 * Test the method on a model with several folders and page.
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.internal.SashWindowsContainer#selectPage(IPage)}.
	 * Use new implementation to populate contentProvider
	 * @throws PagesModelException 
	 */
	@Test
	public void testSelectPage() throws PagesModelException {
		// Create populated content provider
		SimpleSashWindowsContentProvider contentProvider = new SimpleSashWindowsContentProvider();
		SimpleSashWindowContentProviderUtils helper = new SimpleSashWindowContentProviderUtils(contentProvider);
		
		// define how to populate contentProvider
		IModelExp expr = vSash( folder( "f1", page("p11"), page("p12"), page("p13"), page("p14")), folder( "f2", page("p21"), page("p22")));
		// Try to create the model
		helper.createModel(expr);
		// Get the references
		Map<String, Object> models = helper.queryModel(expr);


		// Create the container
		SashWindowsContainer container = createSashWindowsContainer(contentProvider);
		
		// Check if we have an active page
		assertNotNull("active page set", container.getActiveSashWindowsPage());
		
		// Try to set active page
		IPage p12 = container.lookupModelPage(models.get("p12")); 
		container.selectPage(p12);		
		assertEquals("page selected", p12, container.getActiveSashWindowsPage() );

		// Try to set active page
		IPage p22 = container.lookupModelPage(models.get("p22")); 
		container.selectPage(p22);		
		assertEquals("page selected", p22, container.getActiveSashWindowsPage() );

		// Try to set active page
		IPage p11 = container.lookupModelPage(models.get("p11")); 
		container.selectPage(p11);		
		assertEquals("page selected", p11, container.getActiveSashWindowsPage() );
}


	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.internal.SashWindowsContainer#refreshTabs()}.
	 */
	@Test
	public void testRefreshTabs() {

		ISashWindowsContentProvider contentProvider = createContentProvider();
		SashWindowsContainer container = createSashWindowsContainer(contentProvider);

		container.refreshTabs();
		assertNotNull("container is set", container);

	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.internal.SashWindowsContainer#refreshTabs()}.
	 */
	@Test
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
	 * Test method for {@link SashWindowsContainer#visit(org.eclipse.papyrus.infra.core.sasheditor.editor.IPageVisitor)}
	 */
	@Test
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
	@Test
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
	@Test
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
		assertNotNull("menu exist", folderPart.getControl().getMenu());

		folderPart = lookupTabFolderPart(container, folder1);
		assertNotNull("menu exist", folderPart.getControl().getMenu());

		folderPart = lookupTabFolderPart(container, folder2);
		assertNotNull("menu exist", folderPart.getControl().getMenu());

		folderPart = lookupTabFolderPart(container, folder3);
		assertNotNull("menu exist", folderPart.getControl().getMenu());


		// Now create another tab, refresh the container in order that the part is created,
		// ant test it
		ITabFolderModel folder4 = contentProvider.createFolder(referenceFolder, SWT.RIGHT);
		container.refreshTabs();

		folderPart = lookupTabFolderPart(container, folder4);
		assertNotNull("menu exist", folderPart.getControl().getMenu());

	}

	@Test
	public void testSelectPagePageId() {
		
	}
	
	protected TabFolderPart lookupTabFolderPart(SashWindowsContainer container, Object rawModel) {

		LookupFolderPartByRawModelVisitor visitor = new LookupFolderPartByRawModelVisitor(rawModel);
		container.visit(visitor);
		return visitor.result();
	}
}
