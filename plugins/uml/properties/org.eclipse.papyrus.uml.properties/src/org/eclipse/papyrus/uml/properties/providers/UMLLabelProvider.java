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
package org.eclipse.papyrus.uml.properties.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelLabelProvider;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ITreeElement;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.widgets.providers.IDetailLabelProvider;
import org.eclipse.papyrus.uml.diagram.common.providers.EditorLabelProvider;
import org.eclipse.papyrus.views.modelexplorer.Activator;
import org.eclipse.papyrus.views.properties.providers.IFilteredLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Element;

/**
 * The Modisco customizable label provider doesn't handle standard EObjects,
 * while standard EMF label providers don't handle MoDisco elements.
 * 
 * This label provider aggregates both a MoDisco label provider and an
 * EMF Label Provider.
 * 
 * @author Camille Letavernier
 */
public class UMLLabelProvider extends LabelProvider implements IDetailLabelProvider, IFilteredLabelProvider {

	private ILabelProvider modiscoLabelProvider;

	private ILabelProvider eObjectLabelProvider;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public UMLLabelProvider() {
		//		modiscoLabelProvider = new MoDiscoLabelProvider();
		modiscoLabelProvider = new CustomizableModelLabelProvider(Activator.getDefault().getCustomizationManager());
		eObjectLabelProvider = new EditorLabelProvider();
	}

	@Override
	public String getText(Object inputObject) {
		inputObject = getInput(inputObject);
		return getProviderFor(inputObject).getText(inputObject);
	}

	@Override
	public Image getImage(Object inputObject) {
		inputObject = getInput(inputObject);
		return getProviderFor(inputObject).getImage(inputObject);
	}

	/**
	 * Returns the right object to be displayed : if the input is a selection,
	 * returns the selected element.
	 * 
	 * @param inputObject
	 * @return
	 */
	protected Object getInput(Object inputObject) {
		if(inputObject instanceof IStructuredSelection) {
			Object input = ((IStructuredSelection)inputObject).getFirstElement();
			if(input instanceof EObject) {
				return input;
			}
			if(input instanceof ITreeElement) {
				return input;
			}
			if(input instanceof IAdaptable) {
				EObject eObject = (EObject)((IAdaptable)input).getAdapter(EObject.class);
				if(eObject != null) {
					return eObject;
				}
			}
			return input;
		}
		return inputObject;
	}

	/**
	 * @param inputObject
	 * @return the ILabelProvider for input object
	 */
	protected ILabelProvider getProviderFor(Object inputObject) {
		if(inputObject == null || inputObject instanceof EObject) {
			return eObjectLabelProvider;
		}

		return modiscoLabelProvider;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDetail(Object object) {
		return getText(object);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean accept(IStructuredSelection selection) {
		if(selection.isEmpty()) {
			return false;
		}
		Object element = selection.getFirstElement();
		EObject eObject = null;
		if(element instanceof EObject) {
			eObject = (EObject)element;
		} else if(element instanceof IAdaptable) {
			eObject = (EObject)((IAdaptable)element).getAdapter(EObject.class);
		}

		if(eObject == null) {
			return false;
		}

		if(eObject instanceof Element) {
			return true;
		}
		if(eObject instanceof Diagram) {
			return true;
		}

		return false;
	}

}
