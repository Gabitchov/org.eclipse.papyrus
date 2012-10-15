/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
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
package org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel;
import org.eclipse.swt.SWT;
import org.junit.Before;


/**
 * @author dumoulin
 */
public class SimpleSashWindowsContentProviderTest extends TestCase {

	protected SimpleSashWindowsContentProvider contentProvider;

	/**
	 * Initialize the tree {@inheritDoc}
	 */
	@Before
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		createContentProvider();
	}

	/**
	 * Create a tree
	 */
	private void createContentProvider() {
		contentProvider = new SimpleSashWindowsContentProvider();
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowsContentProvider#addPage(org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel)}
	 * .
	 */
	public void testAddTabIPageModel() {
		IPageModel newModel = new FakePageModel();
		contentProvider.addPage(newModel);

		assertTrue("Folder contains added item", contentProvider.getCurrentTabFolder().getChildren().contains(newModel));
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowsContentProvider#movePage(org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel, int, int)}
	 * .
	 */
	//	public void testMoveTabITabFolderModelIntInt() {
	//		fail("Not yet implemented");
	//	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowsContentProvider#movePage(org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel, int, org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel, int)}
	 * .
	 */
	//	public void testMoveTabITabFolderModelIntITabFolderModelInt() {
	//		fail("Not yet implemented");
	//	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowsContentProvider#createFolder(org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel, int, org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel, int)}
	 * .
	 */
	public void testCreateFolder() {

		// Create pages and add them to the default folder
		List<IPageModel> models = new ArrayList<IPageModel>();
		for(int i = 0; i < 8; i++) {
			IPageModel newModel = new FakePageModel("model" + i);
			contentProvider.addPage(newModel);
			models.add(newModel);
		}

		ITabFolderModel folder = contentProvider.getCurrentTabFolder();

		//		// Do move tab 0 to right
		//		ITabFolderModel newFolder = contentProvider.createFolder(folder, 0, folder, SWT.RIGHT);
		//		// Check creation
		//		assertNotNull("Folder created", newFolder);
		//		// Check if correctly attached and reachable
		//		assertEquals("Tab 2 added in correct folder", folder, contentProvider.getParentFolder(newModel2));
		//		assertEquals("Tab 1 added in correct folder", newFolder, contentProvider.getParentFolder(newModel1));
		//		
		////		assertNotNull("folder attached", contentProvider.getParentFolder(newModel1));
		////		assertNotNull("folder attached", contentProvider.getParentFolder(newModel1));
		//		
		//		assertTrue("Folder contains added item", newFolder.getChildren().contains(newModel1));
		//		assertTrue("Folder contains added item", folder.getChildren().contains(newModel2));


		// 
		// Create another folder
		int index = 0;
		IPageModel movedTab = models.get(index++);
		assertEquals("moved tab is the first in tab", movedTab, folder.getChildren().get(0));
		contentProvider.createFolder(folder, 0, folder, SWT.UP);
		// Find created folder
		ITabFolderModel newFolder2 = contentProvider.getParentFolder(movedTab);
		assertFolderCreated(folder, newFolder2, movedTab);

		movedTab = models.get(index++);
		assertEquals("moved tab is the first in tab", movedTab, folder.getChildren().get(0));
		contentProvider.createFolder(folder, 0, newFolder2, SWT.UP);
		ITabFolderModel newFolder3 = contentProvider.getParentFolder(movedTab);
		assertFolderCreated(folder, newFolder3, movedTab);

		movedTab = models.get(index++);
		assertEquals("moved tab is the first in tab", movedTab, folder.getChildren().get(0));
		contentProvider.createFolder(folder, 0, newFolder2, SWT.DOWN);
		ITabFolderModel newFolder4 = contentProvider.getParentFolder(movedTab);
		assertFolderCreated(folder, newFolder4, movedTab);

		movedTab = models.get(index++);
		assertEquals("moved tab is the first in tab", movedTab, folder.getChildren().get(0));
		contentProvider.createFolder(folder, 0, folder, SWT.LEFT);
		ITabFolderModel newFolder5 = contentProvider.getParentFolder(movedTab);
		assertFolderCreated(folder, newFolder5, movedTab);

	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowsContentProvider#createFolder(org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel, int, org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel, int)}
	 * .
	 */
	public void testCreateFolder_ITabFolderModel_int() {

		// Create pages and add them to the default folder
		List<IPageModel> models = new ArrayList<IPageModel>();
		for(int i = 0; i < 8; i++) {
			IPageModel newModel = new FakePageModel("model" + i);
			contentProvider.addPage(newModel);
			models.add(newModel);
		}

		ITabFolderModel referenceFolder = contentProvider.getCurrentTabFolder();

		assertNotNull("referenceFolder exist", referenceFolder);

		// Create a new folder.
		ITabFolderModel createdFolder = contentProvider.createFolder(referenceFolder, SWT.TOP);

		assertNotNull("folder created", createdFolder);

	}

	/**
	 * Assert folder is correctly created
	 * 
	 * @param srcFolder
	 * @param newFolder
	 * @param movedTab
	 */
	protected void assertFolderCreated(ITabFolderModel srcFolder, ITabFolderModel newFolder, IPageModel movedTab) {
		// Check creation
		assertNotNull("Folder exist", newFolder);

		// Check if it is really a new folder
		assertNotSame("Old folder and new folder are differents", srcFolder, newFolder);

		// Check removed from source
		assertFalse("item removed from source folder", srcFolder.getChildren().contains(movedTab));
		// Check contained in created folder
		assertTrue("Folder contains added item", newFolder.getChildren().contains(movedTab));
	}
	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowsContentProvider#removePage(int)}.
	 */
	//	public void testRemoveTabInt() {
	//		fail("Not yet implemented");
	//	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowsContentProvider#removePage(org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel)}
	 * .
	 */
	//	public void testRemoveTabIPageModel() {
	//		fail("Not yet implemented");
	//	}

}
