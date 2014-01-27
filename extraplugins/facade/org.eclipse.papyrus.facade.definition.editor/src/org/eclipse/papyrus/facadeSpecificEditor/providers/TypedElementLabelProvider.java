/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facadeSpecificEditor.providers;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualLiteral;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualOperation;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualParameter;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualTypedElement;
import org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.NamedElement;

import com.swtdesigner.ResourceManager;

public class TypedElementLabelProvider implements ITableLabelProvider {

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 * 
	 * @param listener
	 */

	public void addListener(ILabelProviderListener listener) {

	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 * 
	 */
	public void dispose() {

	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 * 
	 * @param element
	 * @param property
	 * @return
	 */

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 * 
	 * @param listener
	 */

	public void removeListener(ILabelProviderListener listener) {

	}

	/**
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 * 
	 * @param element
	 * @param columnIndex
	 * @return
	 */

	public Image getColumnImage(Object element, int columnIndex) {
		switch(columnIndex) {
		case 0:
			if(element instanceof VirtualProperty) {
				return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/virtualmetamodel/VirtualReference.gif"); //$NON-NLS-1$

			} else if(element instanceof VirtualOperation) {
				return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/virtualmetamodel/VirtualOperation.gif"); //$NON-NLS-1$

			} else if(element instanceof VirtualLiteral) {
				return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/virtualmetamodel/VirtualLiteral.gif"); //$NON-NLS-1$

			} else if(element instanceof VirtualParameter) {
				return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/virtualmetamodel/VirtualParameter.gif"); //$NON-NLS-1$

			}
			break;
		case 1:
			if(element instanceof VirtualElement) {
				if(((VirtualElement)element).isKept()) {
					return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/checked.gif"); //$NON-NLS-1$
				} else {
					return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/unchecked.gif"); //$NON-NLS-1$
				}
			}
			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		default:
			break;
		}

		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 * 
	 * @param element
	 * @param columnIndex
	 * @return
	 */

	public String getColumnText(Object element, int columnIndex) {
		switch(columnIndex) {
		case 0:
			if(element instanceof VirtualElement) {

				String name = ""; //$NON-NLS-1$
				if(((VirtualElement)element).getRepresentedElement() instanceof ENamedElement) {
					name += ((ENamedElement)((VirtualElement)element).getRepresentedElement()).getName();
				} else if(((VirtualElement)element).getRepresentedElement() instanceof NamedElement) {
					name += ((NamedElement)((VirtualElement)element).getRepresentedElement()).getName();
				}

				if(element instanceof VirtualTypedElement) {
					if(((VirtualTypedElement)element).getType() != null) {
						name += " (" + ((VirtualTypedElement)element).getType().getAliasName() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
					}
				}

				return name;
			}
			break;
		case 1:

			break;
		case 2:
			if(element instanceof VirtualElement) {
				return ((VirtualElement)element).getAliasName();
			}
			break;
		case 3:
			if(element instanceof VirtualTypedElement) {
				return ((VirtualTypedElement)element).getLower() + ""; //$NON-NLS-1$
			}
			break;
		case 4:
			if(element instanceof VirtualTypedElement) {
				return ((VirtualTypedElement)element).getUpper() + ""; //$NON-NLS-1$
			}
			break;
		default:
			break;
		}

		return null;
	}
}
