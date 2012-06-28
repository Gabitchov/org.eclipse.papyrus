/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.tests.qvt;

import org.junit.Assert;
import org.junit.Test;


//Bug 383748: [Properties View] Customization & Generation do not work with a default Papyrus installation
//https://bugs.eclipse.org/bugs/show_bug.cgi?id=383748
public class TransformationsTests {

	@Test
	public void handleXWTFile() {
		Assert.fail("Not Supported: Testing XWT File transformations");
	}

	@Test
	public void generateEcoreContext() {
		Assert.fail("Not Supported: Testing Ecore Context transformation");
	}

	@Test
	public void generateProfileContext() {
		Assert.fail("Not Supported: Testing Profile Context transformation");
	}
}
