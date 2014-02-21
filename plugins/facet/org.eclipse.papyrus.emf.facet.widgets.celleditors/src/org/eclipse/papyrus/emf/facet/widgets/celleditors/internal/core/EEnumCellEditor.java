/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Gregoire Dupe (Mia-Software) - initial API and implementation
 *   Nicolas Bros (Mia-Software) - Bug 339664 - org.eclipse.emf.facet.widgets.celleditors API cleaning
 *   Nicolas Bros (Mia-Software) - Bug 334539 - [celleditors] change listener
 *   Gregoire Dupe (Mia-Software) - Bug 344563 - NPE with Enum Editor
 *****************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors.internal.core;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.facet.widgets.celleditors.IListener;
import org.eclipse.emf.facet.widgets.celleditors.IModelCellEditHandler;
import org.eclipse.emf.facet.widgets.celleditors.IModelCellEditor;
import org.eclipse.emf.facet.widgets.celleditors.internal.core.composite.EnumeratorComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * This is a enum value editor
 * 
 * @author Gregoire Dupe (Mia-Software)
 * 
 */
public class EEnumCellEditor implements IModelCellEditor {

	private EnumeratorComposite<Enumerator> composite = null;

	public Control activateCell(final Composite parent, final Object originalValue,
			final IModelCellEditHandler editHandler, final EStructuralFeature feature,
			final EObject source) {
		if (!(feature.getEType() instanceof EEnum)) {
			throw new IllegalArgumentException("EEnum feature type"); //$NON-NLS-1$
		}
		this.composite = new EnumeratorComposite<Enumerator>(parent);
		this.composite.setEEnum((EEnum) feature.getEType());

		this.composite.setValue((Enumerator) originalValue);

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
