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
package org.eclipse.papyrus.emf.facet.widgets.celleditors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public interface INaryFeatureCellEditor {

	/**
	 * Initialize a cell for edition of a n-ary feature. This method must create
	 * a control inside the given parent to let the user edit the value.
	 * 
	 * @param parent
	 *            the SWT control that must contain the cell editor
	 * @param feature
	 *            the model feature for which the value is edited
	 * @param source
	 *            the object containing the attribute or reference
	 * @param editingDomain
	 *            the source {@link EObject} must be edited only through this
	 *            {@link EditingDomain}
	 * 
	 * @return the SWT {@link Control} to be used for capturing the new cell
	 *         value
	 */
	Control activateCell(Composite parent, EStructuralFeature feature, EObject source,
			EditingDomain editingDomain);
}
