/*******************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Bros (Mia-Software) - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.widgets.celleditors;

/** Allows validating a cell editor's value before it is committed */
public interface IModelCellEditorValidator {
	/** @return whether the given value is valid for this cell editor */
	boolean isValid(Object newValue);
}
