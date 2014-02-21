/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 339554 - org.eclipse.papyrus.emf.facet.widgets.celleditors API cleaning
 *  Nicolas Bros (Mia-Software) - Bug 339855 - ModelCellEditor class should not be exposed
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.widgets.celleditors;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.internal.CellEditorsRegistry;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor;

/** Registry for the "celleditors" extension point */
public interface ICellEditorsRegistry {

	static ICellEditorsRegistry INSTANCE = new CellEditorsRegistry();

	List<IModelCellEditorContainer<? extends AbstractModelCellEditor>> getAllCellEditors();

	/**
	 * Returns a cell editor to edit a single value of the given type, or <code>null</code> if none
	 * was found. Custom cell editors override the default ones (from
	 * "org.eclipse.papyrus.emf.facet.widgets.celleditors").
	 * 
	 * @param type
	 *            the type for which to get a cell editor
	 * @return the cell editor or <code>null</code> if none was found for the given type
	 */
	IModelCellEditor getCellEditorFor(EClassifier type);

	/**
	 * Returns a cell editor to edit a list of values of the given type, or <code>null</code> if
	 * none was found. Custom cell editors override the default ones (from
	 * "org.eclipse.papyrus.emf.facet.widgets.celleditors").
	 * 
	 * @param type
	 *            the type for which to get a cell editor
	 * @return the cell editor or <code>null</code> if none was found for the given type
	 */
	INaryFeatureCellEditor getNaryCellEditorFor(EClassifier type);

	/**
	 * Returns a cell editor to edit a single value of the given type, or <code>null</code> if none
	 * was found. Custom cell editors override the default ones (from
	 * "org.eclipse.papyrus.emf.facet.widgets.celleditors").
	 * 
	 * @param type
	 *            the type for which to get a cell editor
	 * @param preferredCellEditors
	 *            the cell editors that should be chosen in case of conflicts (several cell editors
	 *            defined for the same type)
	 * @return the cell editor or <code>null</code> if none was found for the given type
	 */
	IModelCellEditor getCellEditorFor(EClassifier type,
			List<AbstractModelCellEditor> preferredCellEditors);

	/**
	 * Returns a cell editor to edit a list of values of the given type, or <code>null</code> if
	 * none was found. Custom cell editors override the default ones (from
	 * "org.eclipse.papyrus.emf.facet.widgets.celleditors").
	 * 
	 * @param type
	 *            the type for which to get a cell editor
	 * @param preferredCellEditors
	 *            the cell editors that should be chosen in case of conflicts (several cell editors
	 *            defined for the same type)
	 * @return the cell editor or <code>null</code> if none was found for the given type
	 */
	INaryFeatureCellEditor getNaryCellEditorFor(EClassifier type,
			List<AbstractModelCellEditor> preferredCellEditors);

}