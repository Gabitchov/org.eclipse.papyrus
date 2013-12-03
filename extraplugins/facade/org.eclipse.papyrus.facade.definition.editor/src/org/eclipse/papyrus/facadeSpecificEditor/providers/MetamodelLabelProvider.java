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
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualDatatype;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualEnum;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass;
import org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator;
import org.eclipse.papyrus.facadeSpecificEditor.Messages;
import org.eclipse.papyrus.facadeSpecificEditor.metamodel.MetamodelUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.NamedElement;

import com.swtdesigner.ResourceManager;

// TODO: Auto-generated Javadoc
/**
 * The Class MetamodelLabelProvider.
 */
public class MetamodelLabelProvider implements ITableLabelProvider, ILabelProvider, IFontProvider, IColorProvider {

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
			if(element instanceof VirtualMetaclass) {
				if(((VirtualMetaclass)element).isStereotypeInterface()) {
					return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/virtualmetamodel/StereotypeInterface.gif"); //$NON-NLS-1$
				} else {
					return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/virtualmetamodel/VirtualMetaclass.gif"); //$NON-NLS-1$
				}
			} else if(element instanceof VirtualDatatype) {
				return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/virtualmetamodel/VirtualDatatype.gif"); //$NON-NLS-1$
			} else if(element instanceof VirtualEnum) {
				return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/virtualmetamodel/VirtualEnum.gif"); //$NON-NLS-1$
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
			if(element instanceof VirtualMetaclass) {
				if(MetamodelUtils.canBeAbstract((VirtualMetaclass)element)) {
					if(((VirtualMetaclass)element).isAbstract()) {
						return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/checked.gif"); //$NON-NLS-1$
					} else {
						return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/unchecked.gif"); //$NON-NLS-1$
					}
				}
			}
			break;

		case 4:
			if(element instanceof VirtualElement) {

				if(((VirtualElement)element).isUseRepresented()) {
					return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/checked.gif"); //$NON-NLS-1$
				} else {
					return ResourceManager.getPluginImage(FacadeDefinitionEditorActivator.getDefault(), "icons/unchecked.gif"); //$NON-NLS-1$
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
			String result = Messages.MetamodelLabelProvider_8;
			if(element instanceof VirtualElement) {
				if(((VirtualElement)element).getRepresentedElement() instanceof ENamedElement) {
					result = ((ENamedElement)((VirtualElement)element).getRepresentedElement()).getName();
				} else if(((VirtualElement)element).getRepresentedElement() instanceof NamedElement) {
					result = ((NamedElement)((VirtualElement)element).getRepresentedElement()).getName();
				}

				if(element instanceof VirtualMetaclass) {
					if(!((VirtualMetaclass)element).getAppliedStereotypes().isEmpty()) {
						result += " ("; //$NON-NLS-1$
						result += ((VirtualMetaclass)element).getAppliedStereotypes().get(0).getExtensionDefinition().getStereotype().getName();

						if(((VirtualMetaclass)element).getAppliedStereotypes().size() > 1) {
							for(int i = 1; i < ((VirtualMetaclass)element).getAppliedStereotypes().size(); i++) {
								result += ", "; //$NON-NLS-1$
								result += ((VirtualMetaclass)element).getAppliedStereotypes().get(i).getExtensionDefinition().getStereotype().getName();
							}

						}
						result += ")"; //$NON-NLS-1$
					}
				}
			}

			return result;

		case 1:
			break;

		case 2:
			if(element instanceof VirtualElement) {
				return ((VirtualElement)element).getAliasName();
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
		return getColumnText(element, 0) + getColumnText(element, 2);

	}

	/**
	 * @see org.eclipse.jface.viewers.IFontProvider#getFont(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */

	public Font getFont(Object element) {
		if(element instanceof VirtualMetaclass) {

			if(((VirtualMetaclass)element).isAbstract()) {
				return JFaceResources.getFontRegistry().getItalic(JFaceResources.DEFAULT_FONT);
			}
		}

		return JFaceResources.getFontRegistry().get(JFaceResources.DEFAULT_FONT);
	}

	/**
	 * @see org.eclipse.jface.viewers.IColorProvider#getForeground(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */

	public Color getForeground(Object element) {
		if(element instanceof VirtualElement) {
			if(!((VirtualElement)element).isKept()) {
				return Display.getDefault().getSystemColor(SWT.COLOR_GRAY);
			}
		}
		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.IColorProvider#getBackground(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */

	public Color getBackground(Object element) {

		return null;
	}

}
