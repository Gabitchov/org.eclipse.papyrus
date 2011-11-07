/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.table.widget.celleditors.editors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.facet.widgets.celleditors.IModelCellEditHandler;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;


public class LiteralUnlimitedNaturalCellEditor extends IntCellEditor {

	/** the original value */
	private Object originalValue;

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.table.widget.celleditors.editors.IntCellEditor#activateCell(org.eclipse.swt.widgets.Composite, java.lang.Object,
	 *      org.eclipse.emf.facet.widgets.celleditors.IModelCellEditHandler, org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EObject)
	 * 
	 * @param parent
	 * @param originalValue
	 * @param editHandler
	 * @param feature
	 * @param source
	 * @return
	 */
	@Override
	public Control activateCell(Composite parent, Object originalValue, IModelCellEditHandler editHandler, EStructuralFeature feature, EObject source) {
		this.originalValue = originalValue;
		return super.activateCell(parent, originalValue, editHandler, feature, source);
	}
	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.celleditors.IModelCellEditor#getValue()
	 * 
	 * @return
	 */
	@Override
	public Object getValue() {
		if(this.composite != null) {
			Object value = this.composite.getValue();
			if(value instanceof Integer) {
				Integer integer = (Integer)value;
				if(integer.intValue() >= -1) {
					return integer;
				}
			}
		}
		return this.originalValue;
	}

}
