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
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.providers;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.Messages;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;


/**
 * The Class EditorLabelProvider.
 * This class provides Label and Image for some UML Element
 */
public class EditorLabelProvider implements ILabelProvider {

	/** icon for metaclass */
	public static final String ICON_METACLASS = "/icons/Metaclass.gif";//$NON-NLS-1$

	/** icon for a class */
	public static final String ICON_CLASS = "/icons/Class.gif"; //$NON-NLS-1$

	/** icon for a datatype */
	public static final String ICON_DATATYPE = "/icons/DataType.gif"; //$NON-NLS-1$

	/** icon for a stereotype */
	public static final String ICON_STEREOTYPE = "/icons/Stereotype.gif"; //$NON-NLS-1$

	/** icon for a profile */
	public static final String ICON_PROFILE = "/icons/Profile.gif"; //$NON-NLS-1$

	/** icon for a model */
	public static final String ICON_MODEL = "/icons/obj16/Model.gif"; //$NON-NLS-1$

	/** icon for a package */
	public static final String ICON_PACKAGE = "/icons/Package.gif"; //$NON-NLS-1$

	/** icon for a string */
	public static final String ICON_STRING = "icons/obj16/LiteralString.gif"; //$NON-NLS-1$

	/** icon for a compartment */
	public static final String ICON_COMPARTMENT = "/icons/none_comp_vis.gif"; //$NON-NLS-1$

	/** icon for an operation */
	public static final String ICON_OPERATION = "/icons/Operation.gif"; //$NON-NLS-1$

	/** icon for a property */
	public static final String ICON_PROPERTY = "/icons/Property.gif"; //$NON-NLS-1$

	/** icon for an interface */
	public static final String ICON_INTERFACE = "/icons/Interface.gif"; //$NON-NLS-1$

	/** icon for an interface */
	public static final String ICON_RECEPTION = "/icons/obj16/Reception.gif"; //$NON-NLS-1$

	/** icon for a port */
	public static final String ICON_PORT = "/icons/Port.gif"; //$NON-NLS-1$

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
	 */
	public Image getImage(Object element) {
		if(element instanceof EditPart) {
			element = ((View)((EditPart)element).getModel()).getElement();
		}

		if(element instanceof Stereotype) {
			return Activator.getPluginIconImage(Activator.ID, ICON_STEREOTYPE);
		} else if(element instanceof Interface) {
			return Activator.getPluginIconImage(Activator.ID, ICON_INTERFACE);
		} else if(element instanceof Class) {
			if(org.eclipse.papyrus.diagram.common.util.Util.isMetaclass((Type)element)) {
				return Activator.getPluginIconImage(Activator.ID, ICON_METACLASS);
			} else {
				return Activator.getPluginIconImage(Activator.ID, ICON_CLASS);
			}
		} else if(element instanceof DataType) {
			return Activator.getPluginIconImage(Activator.ID, ICON_DATATYPE);
		} else if(element instanceof Profile) {
			return Activator.getPluginIconImage(Activator.ID, ICON_PROFILE);
		} else if(element instanceof Model) {
			return Activator.getPluginIconImage(Activator.ID, ICON_MODEL);
		} else if(element instanceof Package) {
			return Activator.getPluginIconImage(Activator.ID, ICON_PACKAGE);
		} else if(element instanceof BasicCompartment) {
			return Activator.getPluginIconImage(Activator.ID, ICON_COMPARTMENT);
		} else if(element instanceof Reception) {
			return Activator.getPluginIconImage(Activator.ID, ICON_RECEPTION);
		} else if(element instanceof Port) {
			return Activator.getPluginIconImage(Activator.ID, ICON_PORT);
		} else if(element instanceof Property) {
			return Activator.getPluginIconImage(Activator.ID, ICON_PROPERTY);
		} else if(element instanceof Operation) {
			return Activator.getPluginIconImage(Activator.ID, ICON_OPERATION);
		} else if(element instanceof BasicCompartment) {
			return Activator.getPluginIconImage(Activator.ID, ICON_COMPARTMENT);
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	public String getText(Object element) {
		if(element instanceof EditPart) {
			element = ((View)((EditPart)element).getModel()).getElement();
		}
		if(element instanceof NamedElement) {
			return ((NamedElement)element).getName();
		}
		return Messages.ShowHideAction_No_Name;
	}
}
