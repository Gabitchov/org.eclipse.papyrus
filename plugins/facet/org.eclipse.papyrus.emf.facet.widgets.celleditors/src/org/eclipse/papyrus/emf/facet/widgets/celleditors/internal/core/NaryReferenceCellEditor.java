/*******************************************************************************
 * Copyright (c) 2010, 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Bros (Mia-Software) - initial API and implementation
 *   Nicolas Bros (Mia-Software) - Bug 339664 - org.eclipse.papyrus.emf.facet.widgets.celleditors API cleaning
 *   Nicolas Guyomar (Mia-Software) - Bug 342451 - To be able to edit derived facet attributes and derived facet references in a table
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.widgets.celleditors.internal.core;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.IModelCellEditHandler;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.INaryEReferenceCellEditor;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.internal.ui.NaryReferenceEditingDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class NaryReferenceCellEditor<T extends EObject> implements INaryEReferenceCellEditor<T> {

	private NaryReferenceEditingDialog<T> naryReferenceEditingDialog;

	public Control activateCell(final Composite parent, final List<T> values,
			final List<T> availableValues, final IModelCellEditHandler editHandler,
			final EObject eObject, final EStructuralFeature feature) {
		final Composite placeholderComposite = new Composite(parent, SWT.NONE);
		this.naryReferenceEditingDialog = new NaryReferenceEditingDialog<T>(parent.getShell(),
				values, availableValues, editHandler, eObject, feature) {
			@Override
			public boolean close() {
				placeholderComposite.dispose();
				return super.close();
			}
		};
		this.naryReferenceEditingDialog.open();

		return placeholderComposite;
	}

	public List<T> getValue() {
		if (this.naryReferenceEditingDialog != null) {
			return this.naryReferenceEditingDialog.getValue();
		}
		return null;
	}

}
