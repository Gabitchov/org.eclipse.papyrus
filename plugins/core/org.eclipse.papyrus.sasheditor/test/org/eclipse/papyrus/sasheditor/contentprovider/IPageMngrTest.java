/**
 * 
 */
package org.eclipse.papyrus.sasheditor.contentprovider;

import org.eclipse.papyrus.sasheditor.editor.ISashWindowsContainer;

import junit.framework.TestCase;


/**
 * Base class for testing real implementation of ContentProvider.
 * Real implementation should subclass this class, and implement the create method.
 * 
 * @author cedric dumoulin
 *
 */
public abstract class IPageMngrTest extends TestCase {

	/**
	 * The public API allowing to access to the implementation.
	 */
	protected ISashWindowsContentProvider contentProvider;
	
	/**
	 * The public API allowing to access to the implementation.
	 */
//	protected IPageMngr pageMngr;
	
	/**
	 * Setup the test.
	 * @see junit.framework.TestCase#setUp()
	 *
	 * @throws Exception
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}
	
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
	
	/**
	 * Test that the pageIdentifier passed to addPAge() is provided back from 
	 * {@link ISashWindowsContainer#getActiveEditor()()} 
	 */
	public void testAddPage() {
		
	}
}
