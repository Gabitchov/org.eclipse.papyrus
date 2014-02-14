/*******************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Guyomar (Mia-Software) - Bug 342451 - To be able to edit derived facet attributes and derived facet references in a table
 *******************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public interface INaryEReferenceCellEditor<T extends EObject> {

	/**
	 * Initialize a cell for edition of a n-ary feature. This method must create
	 * a control inside the given parent to let the user edit the value.
	 * 
	 * @param parent
	 *            the SWT control that must contain the cell editor
	 * @param values
	 * 			  the actual values of the reference
	 * @param availableValues
	 * 			  the available value for the reference
	 * @param feature
	 * 			  the feature 
	 * @param eObject
	 * 			  the {@link EObject} being currently edited.
	 * @param editHandler
	 * @return the SWT {@link Control} to be used for capturing the new cell
	 *         value
	 */
	Control activateCell(Composite parent, List<T> values, List<T> availableValues, IModelCellEditHandler editHandler, EObject eObject, EStructuralFeature feature);

	/*
	 * Both lists are given here because in some case, we cannot calculate the the available
	 * element, for instance when editing FacetReference, we need to have the FacetContext deal with
	 * it.
	 * 
	 * The EStructuralFeature is given here so that in the dialog we can know whether it is a
	 * containment one, which has an impact on the edition. It is also needed to instantiate new
	 * element, because we need to know its eType.
	 * 
	 * The EObject is only here for dialog customization for instance. Do not modify it in the
	 * dialog, the dialog has to return the new values.
	 */
	
	/**
	 * @return the value currently in the control. This is the value that will
	 *         be set on the model element when
	 *         {@link IModelCellEditHandler#commit()} is called.
	 */
	List<T> getValue();
}
