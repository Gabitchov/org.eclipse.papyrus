/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.providers;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusElement;
import org.eclipse.swt.graphics.Image;

/**
 * This is the PapyrusElementLabelProvider type. Enjoy.
 */
public class PapyrusElementLabelProvider
		extends LabelProvider {

	@Override
	public Image getImage(Object element) {
		return (element instanceof IPapyrusElement)
			? ((IPapyrusElement) element).getImage()
			: null;
	}

	@Override
	public String getText(Object element) {
		return (element instanceof IPapyrusElement)
			? ((IPapyrusElement) element).getText()
			: null;
	}
}