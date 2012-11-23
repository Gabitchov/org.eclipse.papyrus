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
package org.eclipse.papyrus.infra.services.labelprovider.tests.providers;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.tests.LabelProviderServiceTest;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * A basic LabelProvider for testing the TEST_EMF_CONTEXT
 * 
 * @author Camille Letavernier
 * 
 */
public class EMFLabelProviderTest extends LabelProvider implements IFilteredLabelProvider {

	public boolean accept(Object element) {
		return true;
	}

	@Override
	public String getText(Object element) {
		return LabelProviderServiceTest.EXPECTED_EMF_VALUE;
	}

	@Override
	public Image getImage(Object element) {
		return null;
	}

}
