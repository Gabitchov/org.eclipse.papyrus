package org.eclipse.papyrus.modelexplorer.test;

import org.eclipse.core.runtime.Assert;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public abstract class AbstractHandlerTest {

	@Before
	public void initTest() {
		int d = 0;
		d++;
	}

	@After
	public void endOfTests() {
		// So that the Workbench can be closed.
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(false);
	}
}
