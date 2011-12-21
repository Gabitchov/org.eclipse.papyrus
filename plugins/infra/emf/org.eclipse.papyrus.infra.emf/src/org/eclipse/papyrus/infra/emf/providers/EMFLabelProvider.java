/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.providers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelLabelProvider;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ITreeElement;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.widgets.providers.IDetailLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * This class handles labels for EMF Objects
 * The class can handle the following cases :
 * - An EObject (Which can be resolved with {@link EMFHelper#getEObject(Object)})
 * - A IStructuredSelection containing EObject(s)
 * 
 * @author Camille Letavernier
 */
public class EMFLabelProvider extends CustomizableModelLabelProvider implements IDetailLabelProvider {

	protected ILabelProvider baseEMFLabelProvider;

	/**
	 * Creates a new EMFObjectLabelProvider.
	 */
	public EMFLabelProvider() {
		super(Activator.getDefault().getCustomizationManager());
		baseEMFLabelProvider = new StandardEMFLabelProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if(element == null) {
			return ""; //$NON-NLS-1$
		}

		if(element instanceof ITreeElement) {
			return super.getText(element);
		}

		EObject eObject = EMFHelper.getEObject(element);
		if(eObject != null) {
			return getText(eObject);
		}

		if(element instanceof IStructuredSelection) {
			return getText((IStructuredSelection)element);
		}

		return element.toString();
	}

	protected String getText(EObject element) {
		return baseEMFLabelProvider.getText(element);
	}

	protected String getText(IStructuredSelection selection) {
		if(selection.isEmpty()) {
			return ""; //$NON-NLS-1$
		}

		//TODO : Implement a multi-selection label, instead of just the first element's label
		Object element = selection.getFirstElement();
		return getText(element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		if(element instanceof ITreeElement) {
			return super.getImage(element);
		}

		EObject eObject = EMFHelper.getEObject(element);
		if(eObject != null) {
			return getImage(eObject);
		}

		if(element instanceof IStructuredSelection) {
			return getImage((IStructuredSelection)element);
		}

		return null;
	}

	protected Image getImage(EObject eObject) {
		return baseEMFLabelProvider.getImage(eObject);
	}

	protected Image getImage(IStructuredSelection selection) {
		if(selection.isEmpty()) {
			return null;
		}

		//TODO : Implement a multi-selection label, instead of just the first element's label
		Object element = selection.getFirstElement();
		return getImage(element);
	}

	public String getDetail(Object object) {
		object = EMFHelper.getEObject(object);
		return getText(object) + " - " + getQualifiedClassName(object); //$NON-NLS-1$
	}

	/**
	 * Returns the qualified Class name of the given EObject, or an
	 * empty String if the object is not an EObject
	 * 
	 * @param object
	 * @return The qualified name of this object's class, or an empty
	 *         String if the object is not an EObject
	 */
	protected String getQualifiedClassName(Object object) {
		if(object instanceof EObject) {
			EObject eObject = (EObject)object;
			EClass eClass = eObject.eClass();
			return EMFHelper.getQualifiedName(eClass, "::"); //$NON-NLS-1$
		}
		return ""; //$NON-NLS-1$
	}

}
