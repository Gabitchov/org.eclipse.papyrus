/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.sheet;

import java.util.LinkedList;

import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.views.properties.IPropertyDescriptor;


/**
 * A specific property source for Papyrus.
 * It replaces the combo used to choose a single reference by a {@link ElementListSelectionDialog}
 * 
 */
public class UMLPropertySource extends PropertySource {

	/**
	 * @param object
	 * @param ips
	 */
	public UMLPropertySource(Object object, IItemPropertySource ips) {
		super(object, ips);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.edit.ui.provider.PropertySource#createPropertyDescriptor(org.eclipse.emf.edit.provider.IItemPropertyDescriptor)
	 */
	@Override
	protected IPropertyDescriptor createPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor) {
		return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
	}

	/**
	 * A custom property descriptor.
	 * It replaces the Combo by the {@link ElementListSelectionDialog}
	 */
	private class CustomPropertyDescriptor extends PropertyDescriptor {

		public CustomPropertyDescriptor(Object object, IItemPropertyDescriptor itemPropertyDescriptor) {
			super(object, itemPropertyDescriptor);
		}

		@Override
		public CellEditor createPropertyEditor(Composite composite) {
			if(!itemPropertyDescriptor.canSetProperty(object)) {
				return null;
			}

			CellEditor result = null;
			Object genericFeature = itemPropertyDescriptor.getFeature(object);

			// If it is a single reference
			if(genericFeature instanceof EReference && !((EReference)genericFeature).isMany()) {
				final ILabelProvider editLabelProvider = getEditLabelProvider();
				result = new ExtendedDialogCellEditor(composite, editLabelProvider) {

					@Override
					protected Object openDialogBox(Control cellEditorWindow) {
						ElementListSelectionDialog dialog = new ElementListSelectionDialog(cellEditorWindow.getShell(),
								editLabelProvider);

						dialog.setTitle("Element Selection");
						dialog.setMessage("Select a String (* = any string, ? = any char):");

						LinkedList<Object> result = new LinkedList<Object>();
						result.add("");
						result.addAll(itemPropertyDescriptor.getChoiceOfValues(object));
						result.remove(null);

						dialog.setElements(result.toArray());

						Object toReturn = null;
						if(dialog.open() == Dialog.OK) {
							toReturn = dialog.getFirstResult();
							if("".equals(toReturn)) {
								toReturn = itemPropertyDescriptor.getPropertyValue(null);
							}
						} else {
							toReturn = itemPropertyDescriptor.getPropertyValue(object);
						}
						return toReturn;
					}
				};
			} else {
				result = super.createPropertyEditor(composite);
			}
			return result;
		}
	}

}
