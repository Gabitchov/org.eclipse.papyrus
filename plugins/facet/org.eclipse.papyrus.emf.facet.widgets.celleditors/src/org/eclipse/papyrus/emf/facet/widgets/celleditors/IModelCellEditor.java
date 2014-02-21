/*******************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public interface IModelCellEditor {

	/**
	 * Initialize a cell for edition. This method must create a control inside
	 * the given parent to let the user edit the value.
	 * 
	 * @param parent
	 *            the SWT control that must contain the cell editor
	 * @param originalValue
	 *            the original value of the cell being edited (that should be
	 *            displayed in the control initially)
	 * @param editHandler
	 *            call {@link IModelCellEditHandler#commit()} when the user
	 *            "commits" the value (for example by hitting enter in a text
	 *            cell editor)
	 * @param feature
	 *            the model feature for which the value is edited
	 * @param source
	 *            the object containing the attribute or reference
	 * 
	 * @return the SWT {@link Control} to be used for capturing the new cell
	 *         value
	 */
	Control activateCell(Composite parent, Object originalValue, IModelCellEditHandler editHandler,
			EStructuralFeature feature, EObject source);

	/**
	 * @return the value currently in the control. This is the value that will
	 *         be set on the model element when
	 *         {@link IModelCellEditHandler#commit()} is called.
	 */
	Object getValue();
}
