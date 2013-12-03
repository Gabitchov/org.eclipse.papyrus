/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.diagramtemplate.editor.provider;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.papyrus.diagramtemplate.AbstractSelection;
import org.eclipse.papyrus.diagramtemplate.Selection;
import org.eclipse.papyrus.diagramtemplate.SelectionKind;
import org.eclipse.papyrus.diagramtemplate.SelectionRef;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.NamedElement;

import com.swtdesigner.ResourceManager;

/**
 * 
 * Label provider for the For selection
 * 
 */
public class ForLabelProvider implements ITableLabelProvider {

	/**
	 * {@inheritDoc}
	 */
	public Image getColumnImage(Object element, int columnIndex) {
		switch(columnIndex) {
		case 0:
			if(element instanceof SelectionRef) {

				if(((SelectionRef)element).getKind() == SelectionKind.FOR_ALL) {
					return ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/forAllRef.png");
				} else if(((SelectionRef)element).getKind() == SelectionKind.SPECIFIC) {
					return ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/specificRef.gif");
				}
			} else {
				if(((Selection)element).getKind() == SelectionKind.FOR_ALL) {
					return ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/forAll.png");
				} else if(((Selection)element).getKind() == SelectionKind.SPECIFIC) {
					return ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/specific.gif");
				}
			}
			break;

		case 1:
			if(element instanceof Selection) {
				if(((Selection)element).getKind() == SelectionKind.FOR_ALL) {
					if(((Selection)element).isRecursively()) {
						return ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/checked.gif");
					} else {
						return ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/unchecked.gif");
					}
				}
			}
			break;

		case 2:
			if(element instanceof AbstractSelection) {
				if(((AbstractSelection)element).getKind() == SelectionKind.FOR_ALL) {
					if(((AbstractSelection)element).isSubTypes()) {
						return ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/checked.gif");
					} else {
						return ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/unchecked.gif");
					}
				}
			}
			break;
		case 3:

			break;

		default:
			break;
		}


		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getColumnText(Object element, int columnIndex) {
		switch(columnIndex) {
		case 0:
			if(element instanceof SelectionRef) {
				EObject rootType = ((SelectionRef)element).getElement();
				if(rootType instanceof EClass) {
					return ((EClass)rootType).getName() + " - " + ((EReference)((SelectionRef)element).getEReference()).getName();
				} else if(rootType instanceof NamedElement) {
					return ((NamedElement)rootType).getName() + " (" + rootType.eClass().getName() + ") - " + ((EReference)((SelectionRef)element).getEReference()).getName();
				}
			} else if(element instanceof Selection) {
				EObject rootType = ((Selection)element).getElement();
				if(rootType instanceof EClass) {
					return ((EClass)rootType).getName();
				} else if(rootType instanceof NamedElement) {
					return ((NamedElement)rootType).getName() + " (" + rootType.eClass().getName() + ")";
				}
			}

			break;
		case 1:

			break;
		case 2:

			break;
		case 3:
			if(element instanceof AbstractSelection) {
				if(((AbstractSelection)element).getKind() == SelectionKind.FOR_ALL) {
					return ((AbstractSelection)element).getStereotypedBy();
				}
			}
			break;

		default:
			break;
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}
}
