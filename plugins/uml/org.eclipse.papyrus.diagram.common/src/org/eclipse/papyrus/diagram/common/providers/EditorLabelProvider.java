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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Modification
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.EditPartService;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.core.editorsfactory.PageIconsRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.Messages;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * The Class EditorLabelProvider.
 * This class provides Label and Image for UML Element
 * 
 */
public class EditorLabelProvider implements ILabelProvider {

	/**
	 * We store the next index for the UML Element, which are not NamedElement
	 * Key is a String representing the type of Element
	 */
	private Map<String, Integer> index = new HashMap<String, Integer>();


	/** the plugin where owning the icons for the UML Element */
	public static final String pluginID = "org.eclipse.uml2.uml.edit"; //$NON-NLS-1$

	/** folder where are the UML Icon */
	public static final String imageFolder = "/icons/full/obj16/"; //$NON-NLS-1$

	/** Image returned when the image was not found */
	public static final Image imageNotFound = Activator.getPluginIconImage(pluginID, "notFound.gif");

	/** icon for metaclass */
	public static final String ICON_METACLASS = "/icons/Metaclass.gif";//$NON-NLS-1$ 

	/** icon for a compartment */
	public static final String ICON_COMPARTMENT = "/icons/none_comp_vis.gif"; //$NON-NLS-1$


	/**
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 * 
	 * @param listener
	 */
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 * 
	 */
	public void dispose() {
		// TODO Auto-generated method stub
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 * 
	 * @param element
	 * @param property
	 * @return
	 */
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 * 
	 * @param listener
	 */
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 *         <ul>
	 *         <li>if stereotypes are applied on the elements : return the image corresponding to the first applied stereotype</li>
	 *         <li>if the element is a MetaClass return the image representing a metaclass</li>
	 *         <li>if the element is a {@link DecorationNode}, returns the image corresponding to a compartment</li>
	 *         <li> <code>null</code> if no image was found</li>
	 *         </ul>
	 */
	public Image getImage(Object element) {
		if(element instanceof EditPart) {
			element = ((View)((EditPart)element).getModel()).getElement();
		}

		//test for Metaclass
		if(element instanceof Class) {
			if(org.eclipse.papyrus.diagram.common.util.Util.isMetaclass((Type)element)) {
				return Activator.getPluginIconImage(Activator.ID, ICON_METACLASS);
			}
		}

		//test for other UML Elements
		if(element instanceof Element) {
			//return the stereotype image if a stereotype is applied on the element
			Image im = Activator.getIconElement((Element)element);
			String imagePath = new String(imageFolder);
			if(im == null) {
				imagePath += element.getClass().getSimpleName() + ".gif"; //$NON-NLS-1$
				imagePath = imagePath.replace("Impl", ""); //$NON-NLS-1$ //$NON-NLS-2$
				im = Activator.getPluginIconImage(pluginID, imagePath);
			}
			if(im.equals(imageNotFound)) {
				return null;
			}
			return im;
		}

		//if the element is a compartment
		if(element instanceof BasicCompartment || element instanceof DecorationNode) {
			return Activator.getPluginIconImage(Activator.ID, ICON_COMPARTMENT);
		} else if(element instanceof Diagram) {
			IPageIconsRegistry registry = null;
			try {
				registry = ServiceUtilsForActionHandlers.getInstance().getServiceRegistry().getService(IPageIconsRegistry.class);
			} catch (ServiceException e) {
				//nothing to do
			}
			if(registry == null) {
				registry = new PageIconsRegistry();
			}
			return registry.getEditorIcon(element);
		}

		//Standard EMF image
		if(element instanceof EObject) {
			EObject eObject = (EObject)element;
			//
			IItemLabelProvider itemLabelProvider = null;
			if(eObject != null) {
				String uri = eObject.eClass().getEPackage().getNsURI();
				AdapterFactory adapterFactory = null;
				IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.emf.edit.itemProviderAdapterFactories"); //$NON-NLS-1$
				for(IConfigurationElement e : extensions) {
					if(uri.equals(e.getAttribute("uri"))) { //$NON-NLS-1$
						try {
							adapterFactory = (AdapterFactory)e.createExecutableExtension("class"); //$NON-NLS-1$
						} catch (CoreException ex) {
							Activator.log.error(ex);
						}
						if(adapterFactory != null) {
							break;
						}
					}
				}
				if(adapterFactory != null) {
					itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(eObject, IItemLabelProvider.class);
				}
			}
			Object imageObject = itemLabelProvider.getImage(eObject);
			return ExtendedImageRegistry.getInstance().getImage(imageObject);
		}

		return null;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 *         <ul>
	 *         <li>if element is a {@link NamedElement}, we return its name</li>
	 *         <li>else if element is a {@link Element}, we return its type + a index</li>
	 *         <li>else return {@link Messages#EditorLabelProvider_No_name}</li>
	 *         </ul>
	 */
	public String getText(Object element) {
		if(element instanceof EditPart) {
			element = ((View)((EditPart)element).getModel()).getElement();
		}

		if(element instanceof EObject && UMLUtil.getBaseElement((EObject)element) != null) { //Stereotype Application
			return getText(UMLUtil.getBaseElement((EObject)element));
		} else if(element instanceof NamedElement) {
			return ((NamedElement)element).getName();
		} else if(element instanceof Element) {
			//when the element is not a NamedElement, we return its Type + a index
			String className = element.getClass().getName();
			int i = className.lastIndexOf(".");
			className = className.substring(i + 1);
			className = className.replace("Impl", "");
			Integer number = index.get(className);
			if(number == null) {
				number = 0;
			}

			index.put(className, number + 1);
			return className + " " + number;
		} else if(element instanceof Diagram) {
			return ((Diagram)element).getName();
		} else if(element instanceof View) { //maybe it is a view of a compartment
			EditPart dummyEP = EditPartService.getInstance().createGraphicEditPart((View)element);
			if(dummyEP instanceof ResizableCompartmentEditPart) {
				return ((ResizableCompartmentEditPart)dummyEP).getCompartmentName();
			}
		}

		return Messages.EditorLabelProvider_No_name;
	}
}
