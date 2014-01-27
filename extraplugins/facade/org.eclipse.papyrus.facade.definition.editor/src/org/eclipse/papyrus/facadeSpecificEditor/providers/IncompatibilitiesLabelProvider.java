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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.Combination;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator;
import org.eclipse.papyrus.facadeSpecificEditor.FacadeSpecificEditor;
import org.eclipse.papyrus.facadeSpecificEditor.utils.ProfileUtils;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Stereotype;

import com.swtdesigner.ResourceManager;

public class IncompatibilitiesLabelProvider implements ITableLabelProvider, IFontProvider {

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
			if(element instanceof Combination) {
				return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/combinaison.png"); //$NON-NLS-1$
			}
			break;
		case 1:
			if(element instanceof Combination) {
				ISelection selection = FacadeSpecificEditor.getExtensionDefintionTreeViewer().getSelection();
				if(selection instanceof IStructuredSelection) {
					Object first = ((IStructuredSelection)selection).getFirstElement();

					if(first instanceof BaseMetaclass) {
						EList<Combination> incompatibleStereotypes = ((BaseMetaclass)first).getIncompatibleStereotypes();
						if(incompatibleStereotypes.contains(element)) {
							return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/unchecked.gif"); //$NON-NLS-1$
						} else {
							return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/checked.gif"); //$NON-NLS-1$
						}
					}
				}

			}
			break;

		default:
			break;
		}

		return null;
	}

	/**
	 * Produce sibling list.
	 * 
	 * @param stereotype
	 *        the stereotype
	 * @return the string
	 */
	protected String produceSiblingList(Stereotype stereotype) {
		String output = ""; //$NON-NLS-1$
		HashSet<Stereotype> siblings = ProfileUtils.getSiblings(stereotype);
		List<Classifier> siblingsList = new ArrayList<Classifier>(siblings);
		if(siblingsList.size() > 1) {
			output += "["; //$NON-NLS-1$
		}

		if(!siblingsList.isEmpty()) {
			output += siblingsList.get(0).getQualifiedName();

			if(siblingsList.size() > 1) {
				for(int i = 1; i < siblingsList.size(); i++) {
					output += ", "; //$NON-NLS-1$
					output += siblingsList.get(i).getQualifiedName();
				}
			}
		}

		if(siblings.size() > 1) {
			output += "]"; //$NON-NLS-1$
		}
		return output;
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
			String name = ""; //$NON-NLS-1$
			if(element instanceof Combination) {

				Combination combination = (Combination)element;
				if(!combination.getMembers().isEmpty()) {
					name += combination.getMembers().get(0).getExtensionDefinition().getStereotype().getName();
					if(((Combination)element).getMembers().size() > 1) {
						for(int i = 1; i < combination.getMembers().size(); i++) {
							name += ", "; //$NON-NLS-1$
							name += combination.getMembers().get(i).getExtensionDefinition().getStereotype().getName();
						}
					}

					return name;
				}

			}

			break;
		case 1:
			break;

		default:
			break;
		}

		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.IFontProvider#getFont(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */

	public Font getFont(Object element) {
		if(element instanceof ExtensionDefinition) {
			if(((ExtensionDefinition)element).getStereotype().isAbstract()) {
				return JFaceResources.getFontRegistry().getItalic(JFaceResources.DEFAULT_FONT);
			}
		}

		return JFaceResources.getFontRegistry().get(JFaceResources.DEFAULT_FONT);
	}

}
