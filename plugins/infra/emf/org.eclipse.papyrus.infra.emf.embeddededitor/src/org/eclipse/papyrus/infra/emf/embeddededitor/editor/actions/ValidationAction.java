/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.embeddededitor.editor.actions;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.embeddededitor.util.ActionUtil;

/**
 * An adapter for the EMF "Validate" Action, compatible with the
 * MoDisco customizable content provider.
 * 
 * @author Camille Letavernier
 */
public class ValidationAction extends ValidateAction {

	public ValidationAction(EditingDomain domain) {
		this.domain = domain;
	}

	@Override
	public boolean updateSelection(IStructuredSelection selection) {
		return super.updateSelection((IStructuredSelection)ActionUtil.getAdaptedSelection(selection));
	}
}
