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
package org.eclipse.papyrus.cdo.internal.ui.decorators;

import org.eclipse.emf.cdo.dawn.appearance.DawnElementStylizer;
import org.eclipse.emf.cdo.dawn.appearance.IDawnElementStylizerFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;

/**
 * This is the PapyrusElementStylizerFactory type. Enjoy.
 */
public class PapyrusElementStylizerFactory
		implements IDawnElementStylizerFactory {

	public PapyrusElementStylizerFactory() {
		super();
	}

	public DawnElementStylizer getElementStylizer(Object object) {
		DawnElementStylizer result = null;

		if (isPapyrusEditPart(object)) {
			if (object instanceof ConnectionEditPart) {
				result = new PapyrusConnectionEditPartStylizer();
			} else {
				result = new PapyrusNodeEditPartStylizer();
			}
		} else if (object instanceof EObject) {
			result = new PapyrusElementStylizer();
		}

		return result;
	}

	protected boolean isPapyrusEditPart(Object object) {
		boolean result = object instanceof IPapyrusEditPart;

		if (!result && (object instanceof EditPart)) {
			EditPart editPart = ((EditPart) object).getRoot().getContents();
			Object model = editPart.getModel();

			if (model instanceof EObject) {
				result = CDOUtils.getResourceSet((EObject) model) instanceof ModelSet;
			}
		}

		return result;
	}
}
