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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind;
import org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator;
import org.eclipse.papyrus.facadeSpecificEditor.Messages;
import org.eclipse.papyrus.facadeSpecificEditor.utils.StereotypeUtils;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

import com.swtdesigner.ResourceManager;

public class ExtensionDefintionLabelProvider implements ITableLabelProvider, ILabelProvider, IFontProvider {

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

			break;
		case 1:
			if(element instanceof ExtensionDefinition) {
				if(((ExtensionDefinition)element).getKind() == ExtensionDefinitionKind.ASSOCIATION) {
					if(((ExtensionDefinition)element).getExtension().isRequired()) {
						return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/associationRequired.png"); //$NON-NLS-1$
					} else {
						return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/association.png"); //$NON-NLS-1$
					}
				} else if(((ExtensionDefinition)element).getKind() == ExtensionDefinitionKind.GENERALIZATION) {
					if(((ExtensionDefinition)element).getExtension().isRequired()) {
						return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/generalizationRequired.png"); //$NON-NLS-1$
					} else {
						return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/generalization.png"); //$NON-NLS-1$
					}

				} else if(((ExtensionDefinition)element).getKind() == ExtensionDefinitionKind.MULTI_GENERALIZATION) {
					if(((ExtensionDefinition)element).getExtension().isRequired()) {
						return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/multigeneralizationRequired.png"); //$NON-NLS-1$
					} else {
						return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/multigeneralization.png"); //$NON-NLS-1$
					}

				} else if(((ExtensionDefinition)element).getKind() == ExtensionDefinitionKind.FUSION) {
					if(((ExtensionDefinition)element).getExtension().isRequired()) {
						return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/fusionRequired.png"); //$NON-NLS-1$
					} else {
						return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/fusion.png"); //$NON-NLS-1$
					}

				}

			}
			break;
		case 2:
			if(element instanceof BaseMetaclass) {
				if(!((BaseMetaclass)element).getExtensionDefinition().getExtension().isRequired()) {
					if(((BaseMetaclass)element).isPossible()) {
						return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/checked.gif"); //$NON-NLS-1$
					} else {
						return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/unchecked.gif"); //$NON-NLS-1$
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
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 * 
	 * @param element
	 * @param columnIndex
	 * @return
	 */

	public String getColumnText(Object element, int columnIndex) {
		switch(columnIndex) {
		case 0:
			if(element instanceof ExtensionDefinition) {

				String name = ((ExtensionDefinition)element).getStereotype().getQualifiedName();
				if(!((ExtensionDefinition)element).getStereotype().getGenerals().isEmpty()) {
					name += " [-> "; //$NON-NLS-1$
					name += ((ExtensionDefinition)element).getStereotype().getGenerals().get(0).getQualifiedName();
					if(((ExtensionDefinition)element).getStereotype().getGenerals().size() > 1) {
						for(int i = 1; i < ((ExtensionDefinition)element).getStereotype().getGenerals().size(); i++) {
							name += ", " + ((ExtensionDefinition)element).getStereotype().getGenerals().get(i).getQualifiedName(); //$NON-NLS-1$
						}
					}
					name += "]"; //$NON-NLS-1$
				}
				name += Messages.ExtensionDefintionLabelProvider_13;
				if(((ExtensionDefinition)element).getKind() != ExtensionDefinitionKind.MULTI_GENERALIZATION) {
					if(StereotypeUtils.findBase((ExtensionDefinition)element) != null) {
						name += " " + StereotypeUtils.findBase((ExtensionDefinition)element).getName(); //$NON-NLS-1$
					}
				}
				return name;

			} else if(element instanceof BaseMetaclass) {
				if(((BaseMetaclass)element).getBase() instanceof EClass) {

					String name = ((EClass)((BaseMetaclass)element).getBase()).getName();
					return name;
				}
			}

			break;
		case 1:
			if(element instanceof ExtensionDefinition) {
				return ((ExtensionDefinition)element).getKind().getName();
			}
			break;
		case 2:

			break;

		default:
			break;
		}

		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */

	public Image getImage(Object element) {
		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */

	public String getText(Object element) {
		return getColumnText(element, 0);
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
