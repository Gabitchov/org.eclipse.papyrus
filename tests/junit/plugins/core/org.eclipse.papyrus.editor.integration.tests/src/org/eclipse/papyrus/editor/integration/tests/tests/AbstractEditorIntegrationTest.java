/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.editor.integration.tests.tests;

import org.eclipse.papyrus.editor.integration.tests.Activator;
import org.eclipse.papyrus.junit.utils.tests.AbstractEditorTest;
import org.osgi.framework.Bundle;


public abstract class AbstractEditorIntegrationTest extends AbstractEditorTest {

	@Override
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

}
