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
package org.eclipse.papyrus.uml.diagram.common.sheet;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
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
 * A specific property source for Papyrus. It replaces the combo used to choose
 * a single reference by a {@link ElementListSelectionDialog}
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
	 * @see
	 * org.eclipse.emf.edit.ui.provider.PropertySource#createPropertyDescriptor
	 * (org.eclipse.emf.edit.provider.IItemPropertyDescriptor)
	 */
	@Override
	protected IPropertyDescriptor createPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor) {
		return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
	}

	/**
	 * A custom property descriptor. It replaces the Combo by the {@link ElementListSelectionDialog}
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
			final Object genericFeature = itemPropertyDescriptor.getFeature(object);

			// If it is a single reference
			if(genericFeature instanceof EReference && !((EReference)genericFeature).isMany()) {
				final ILabelProvider editLabelProvider = getEditLabelProvider();
				result = new ExtendedDialogCellEditor(composite, editLabelProvider) {

					@Override
					protected Object openDialogBox(Control cellEditorWindow) {
						ElementListSelectionDialog dialog = new ElementListSelectionDialog(cellEditorWindow.getShell(), editLabelProvider);

						dialog.setTitle("Element Selection");
						dialog.setMessage("Select a String (* = any string, ? = any char):");

						LinkedList<Object> result = new LinkedList<Object>();
						Collection<?> collection = itemPropertyDescriptor.getChoiceOfValues(object);
						result.add("");		// TODO: why is there an empty string ?
						if ((genericFeature instanceof ENamedElement) && ((ENamedElement) genericFeature).getName().equals("classifierBehavior")) {
							// filter in case of classifierBehavior, see bug 343123
							// TODO: this rather generic function is probably not the right place to do the filtering. Also need to support filtering for other
							//       relationships
							Collection<?> all = itemPropertyDescriptor.getChoiceOfValues(object);
							result.addAll(filterOwned(object, collection));
						}
						else {
							result.addAll(collection);
						}
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

	/**
	 * Filter available choice: only show owned elements which are owned by the passed parent
	 * See bug 343123
	 * 
	 * @param parent a parent
	 * @param in a collection of elements
	 * @return a filtered collection containing only owned elements
	 */
	public static Collection<?> filterOwned(Object parent, Collection<?> in) {
		EList<EObject> list = new BasicEList<EObject>();
		for (Object obj : in) {
			if (obj instanceof EObject) {
				if (isOwned(parent, (EObject) obj)) {
					list.add((EObject) obj);
				}
			}
		}
		return list;
	}
	
	/**
	 * Check whether a child belongs to the given parent, i.e. is owned by it.
	 * @param parent a parent
	 * @param child a child
	 * @return true, if owned
	 */
	public static boolean isOwned (Object parent, EObject child) {
		child = child.eContainer();
		while (child != null) {
			if (child == parent) return true;
			child = child.eContainer();
		}
		return false;
	}
}
