/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Guyomar (Mia-Software) - initial API and implementation
 *   Nicolas Bros (Mia-Software) - Bug 334539 - [celleditors] change listener
 *****************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors.ecore;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.emf.facet.widgets.celleditors.IListener;
import org.eclipse.emf.facet.widgets.celleditors.IModelCellEditHandler;
import org.eclipse.emf.facet.widgets.celleditors.IModelCellEditor;
import org.eclipse.emf.facet.widgets.celleditors.ecore.composite.ShortComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/** A cell editor for Short */
public class EShortCellEditor implements IModelCellEditor {

	private ShortComposite composite = null;

	public Control activateCell(final Composite parent, final Object originalValue,
			final IModelCellEditHandler editHandler, final EStructuralFeature feature,
			final EObject source) {
		this.composite = new ShortComposite(parent);
		if (originalValue != null) {
			if (originalValue instanceof Short) {
				this.composite.setValue((Short) originalValue);
			} else {
				Logger.logError("An instance of Short was expected", Activator.getDefault()); //$NON-NLS-1$
			}
		}
		this.composite.addCommitListener(new IListener() {
			public void handleEvent() {
				editHandler.commit();
			}
		});
		return this.composite;
	}

	public Object getValue() {
		return this.composite.getValue();
	}
}
