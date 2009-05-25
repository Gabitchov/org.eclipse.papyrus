package org.eclipse.papyrus.sasheditor.contentprovider.di.internal;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import org.eclipse.papyrus.sasheditor.contentprovider.IAbstractPanelModel;
import org.eclipse.papyrus.sasheditor.contentprovider.IContentChangedListener;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashPanelModel;
import org.eclipse.papyrus.sasheditor.contentprovider.ITabFolderModel;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageModelFactory;
import org.eclipse.papyrus.sashwindows.di.AbstractPanel;
import org.eclipse.papyrus.sashwindows.di.SashModel;
import org.eclipse.papyrus.sashwindows.di.TabFolder;
import org.eclipse.papyrus.sashwindows.di.util.DiUtils;

import junit.framework.TestCase;


/**
 * 
 * @author cedric dumoulin
 */
public class DiContentProviderTest extends TestCase {

	/**
	 * The {@link DiContentProvider} under test.
	 */
	protected DiContentProvider contentProvider;
	
	/** The FolderModel of the first TabFolder */
	protected ITabFolderModel folderModel;
	
	/**
	 * Constructor.
	 * @param name
	 */
	public DiContentProviderTest(String name) {
		super(name);
	}

	/*
	 * 
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
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
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Lookup for a folder in the SashModel. Return the first folder found.
	 * @return
	 */
	private ITabFolderModel lookupFolderModel() {
		if (contentProvider == null)
			return null;
		
		Object rawModel = contentProvider.getRootModel();
		IAbstractPanelModel panelModel = contentProvider.createChildSashModel(rawModel);
		
		return lookupFolderModel(panelModel);
	}

	/**
	 * Recursively search in sash models for a FolderModel.
	 * Return the first encountered folder.
	 * @param panelModel
	 * @return
	 */
	private ITabFolderModel lookupFolderModel(IAbstractPanelModel panelModel) {
		
		if(panelModel instanceof ITabFolderModel)
			return (ITabFolderModel)panelModel;
		else
		{
			ISashPanelModel sashModel = (ISashPanelModel)panelModel;
			// Iterate on children
			for(Object child : sashModel.getChildren() )
			{
				IAbstractPanelModel childModel = contentProvider.createChildSashModel(child);
				ITabFolderModel res = lookupFolderModel(childModel);
				if(res != null)
					return res;
			}
		}
		// Not found
		return null;
	}
	

	/**
	 * 
	 */
	public void testLifeCycle() {

		// A listener on change event.
		ContentChangeListener changeListener = new ContentChangeListener();
		
		// Set change listener
		contentProvider.addContentChangedListener(changeListener);
		
		// Add identifiers
		// Use Object as identifiers.
		List<Object> identifiers = new ArrayList<Object>();
		// Add 10 folders
		for(int i=0; i<10; i++)
		{
			// reset change count
			changeListener.reset();
			// Add Editor
			Object id = new Object();
			identifiers.add(id);
			contentProvider.addPage(id);
			
			// Check fired events
			assertEquals("One event fired", 1, changeListener.getChangeCount());
		}

		// Test moving a page
		changeListener.reset();
		contentProvider.movePage(folderModel, 3, 8);
		// Check fired events
		assertEquals("One event fired", 1, changeListener.getChangeCount());
		
	}
	

	
	/**
	 * Test type of the root model.
	 * Actually, it should be subtype of AbstractPanel
	 * {@link DiContentProvider#getRootModel()}
	 */
	public  void testGetRootModel() {
		
		assertTrue("subtype of AbstractPanel", AbstractPanel.class.isInstance(contentProvider.getRootModel()) );
	}
	
	/**
	 * Listener on ContentChange.
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
			changeCount=0;
		}
	}
}
