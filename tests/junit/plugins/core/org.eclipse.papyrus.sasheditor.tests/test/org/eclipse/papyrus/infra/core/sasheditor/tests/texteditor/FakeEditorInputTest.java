/*****************************************************************************
 * Copyright (c) 2012 Cedric Dumoulin.
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

package org.eclipse.papyrus.infra.core.sasheditor.tests.texteditor;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowsContentProvider;
import org.eclipse.ui.IEditorInput;
import org.junit.Assert;
import org.junit.Test;


/**
 * @author dumoulin
 *
 */
public class FakeEditorInputTest {

	/**
	 * Test method for {@link org.eclipse.ui.part.FileEditorInput#equals(java.lang.Object)}.
	 */
	@Test
	//@Ignore
	public void testEquals() {


		ISashWindowsContentProvider contentProvider = new SimpleSashWindowsContentProvider();
		IEditorInput input1 = new FakeEditorInput(contentProvider);

		IEditorInput input2 = new FakeEditorInput(contentProvider);

		Assert.assertNotEquals("input are different", input1, input2);
	}

}
