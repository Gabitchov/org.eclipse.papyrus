package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IAbstractPanelModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IContentChangedListener;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashPanelModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IPageModelFactory;
import org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPanel;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;
import org.eclipse.papyrus.infra.core.sashwindows.di.util.DiUtils;
import org.eclipse.papyrus.junit.utils.classification.NotImplemented;
import org.eclipse.papyrus.junit.utils.tests.AbstractPapyrusTest;
import org.eclipse.swt.SWT;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author cedric dumoulin
 */
public class DiContentProviderTest extends AbstractPapyrusTest {

	/**
	 * The {@link DiContentProvider} under test.
	 */
	protected DiContentProvider contentProvider;

	/** The FolderModel of the first TabFolder */
	protected ITabFolderModel folderModel;

	@Before
	public void setUp() throws Exception {
		IPageModelFactory pageModelFactory = new FakePageModelFactory();
		SashModel diSashModel = DiUtils.createDefaultSashModel();
		contentProvider = new DiContentProvider(diSashModel, pageModelFactory);
		folderModel = lookupFolderModel();
	}

	/**
	 *
	 * @see junit.framework.TestCase#tearDown()
	 *
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {

	}

	/**
	 * Lookup for a folder in the SashModel. Return the first folder found.
	 *
	 * @return
	 */
	private ITabFolderModel lookupFolderModel() {
		if(contentProvider == null) {
			return null;
		}

		Object rawModel = contentProvider.getRootModel();
		IAbstractPanelModel panelModel = contentProvider.createChildSashModel(rawModel);

		return lookupFolderModel(panelModel);
	}

	/**
	 * Recursively search in sash models for a FolderModel.
	 * Return the first encountered folder.
	 *
	 * @param panelModel
	 * @return
	 */
	private ITabFolderModel lookupFolderModel(IAbstractPanelModel panelModel) {

		if(panelModel instanceof ITabFolderModel) {
			return (ITabFolderModel)panelModel;
		} else {
			ISashPanelModel sashModel = (ISashPanelModel)panelModel;
			// Iterate on children
			for(Object child : sashModel.getChildren()) {
				IAbstractPanelModel childModel = contentProvider.createChildSashModel(child);
				ITabFolderModel res = lookupFolderModel(childModel);
				if(res != null) {
					return res;
				}
			}
		}
		// Not found
		return null;
	}


	/**
	 * Test a typical life cycle on contentProvider:
	 * creation, add change listener, add pages, move page
	 */
	@Test
	public void testLifeCycle() {

		// A listener on change event.
		ContentChangeListener changeListener = new ContentChangeListener();

		// Set change listener
		contentProvider.getContentChangedEventProvider().addListener(changeListener);

		// Add identifiers
		// Use Object as identifiers.
		List<Object> identifiers = new ArrayList<Object>();
		// Add 10 folders
		for(int i = 0; i < 10; i++) {
			// reset change count
			changeListener.reset();
			// Add Editor
			Object id = new Object();
			identifiers.add(id);
			contentProvider.addPage(id);

			// Check fired events
			Assert.assertEquals("One event fired", 1, changeListener.getChangeCount());
		}

		// Test moving a page
		changeListener.reset();
		contentProvider.movePage(folderModel, 3, 8);
		// Check fired events
		Assert.assertEquals("One event fired", 1, changeListener.getChangeCount());

	}



	/**
	 * Test type of the root model.
	 * Actually, it should be subtype of AbstractPanel {@link DiContentProvider#getRootModel()}
	 */
	@Test
	public void testGetRootModel() {

		Assert.assertTrue("subtype of AbstractPanel", AbstractPanel.class.isInstance(contentProvider.getRootModel()));
	}


	/**
	 * Test {@link DiContentProvider#createFolder(ITabFolderModel, int, ITabFolderModel, int)}
	 */
	@Test
	public void testCreateFolder() {

		// A listener on change event.
		ContentChangeListener changeListener = new ContentChangeListener();
		// Set change listener
		contentProvider.getContentChangedEventProvider().addListener(changeListener);

		// Add pages in the model
		// Use Object as identifiers.
		List<Object> identifiers = new ArrayList<Object>();
		// Add 10 pages
		for(int i = 0; i < 5; i++) {
			// reset change count
			changeListener.reset();
			// Add Editor
			Object id = new Object();
			identifiers.add(id);
			contentProvider.addPage(id);
		}

		// reset change count
		changeListener.reset();
		// create a folder
		contentProvider.createFolder(folderModel, 3, folderModel, SWT.RIGHT);
		Assert.assertEquals("One event fired", 1, changeListener.getChangeCount());

		// Check if pageIdentifier 3 have change of folder
		PageRef pageRef = contentProvider.getDiSashModel().lookupPage(identifiers.get(3));
		Assert.assertNotNull("Moved page have a parent", pageRef.getParent());
		Assert.assertNotSame("Moved page is in another parent", ((TabFolderModel)folderModel).getTabFolder(), pageRef.getParent());

		// reset change count
		changeListener.reset();
		// Test creating a third folder
		contentProvider.createFolder(folderModel, 2, folderModel, SWT.UP);
		Assert.assertEquals("One event fired", 1, changeListener.getChangeCount());
		// Check if pageIdentifier 2 have change of folder
		pageRef = contentProvider.getDiSashModel().lookupPage(identifiers.get(2));
		Assert.assertNotNull("Moved page have a parent", pageRef.getParent());
		Assert.assertNotSame("Moved page is in another parent", ((TabFolderModel)folderModel).getTabFolder(), pageRef.getParent());
	}

	/**
	 * Check if {@link DiContentProvider#setCurrentFolder(Object)}.
	 * Check if the method works and DO NO send any event.
	 */
	@Test
	@NotImplemented("This test is currently deprecated; current folder cannot be set programmatically")
	public void testSetCurrentFolder() {
		// A listener on change event.
		ContentChangeListener changeListener = new ContentChangeListener();
		// Set change listener
		contentProvider.getContentChangedEventProvider().addListener(changeListener);

		// Add pages in the model
		// Use Object as identifiers.
		List<Object> identifiers = new ArrayList<Object>();
		// Add 10 pages
		for(int i = 0; i < 5; i++) {
			// reset change count
			changeListener.reset();
			// Add Editor
			Object id = new Object();
			identifiers.add(id);
			contentProvider.addPage(id);
		}

		// reset change count
		changeListener.reset();
		// create a folder
		contentProvider.createFolder(folderModel, 3, folderModel, SWT.RIGHT);
		Assert.assertEquals("One event fired", 1, changeListener.getChangeCount());


		// Get the real di implementation of the first folder
		TabFolder firstFolder = ((TabFolderModel)folderModel).getTabFolder();
		TabFolder createdDiFolder = contentProvider.getDiSashModel().getCurrentSelection();

		// Check if the folder has changed
		Assert.assertNotSame("current folder has change", firstFolder, createdDiFolder);
		// Get the created folder

		// Try to change the current selection by setting the first folder again
		changeListener.reset();
		contentProvider.setCurrentFolder(firstFolder);
		// Check if really changed
		Assert.assertEquals("current folder set correctly", firstFolder, contentProvider.getDiSashModel().getCurrentSelection());
		Assert.assertEquals("No event fired", 0, changeListener.getChangeCount());
	}


	/**
	 * Listener on ContentChange.
	 *
	 * @author dumoulin
	 */
	public class ContentChangeListener implements IContentChangedListener {

		/** Count number of change event */
		private int changeCount = 0;


		/**
		 * @return the changeCount
		 */
		public int getChangeCount() {
			return changeCount;
		}

		public void contentChanged(ContentEvent event) {
			changeCount++;
		}

		public void reset() {
			changeCount = 0;
		}
	}
}
