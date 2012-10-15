/**
 * 
 */
package org.eclipse.papyrus.infra.core.sasheditor.contentprovider;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;


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
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * 
	 * @throws Exception
	 */
	@Before
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}

	@After
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}

	/**
	 * Test that the pageIdentifier passed to addPAge() is provided back from {@link ISashWindowsContainer#getActiveEditor()()}
	 */
	public void testAddPage() {

	}
}
