/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.providers;

import javax.swing.text.Element;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.EditPartService;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.types.NotationTypesMap;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.NamedElement;

/**
 * A Label Provider for GMF Notation model
 */
public class NotationLabelProvider extends EMFLabelProvider {

	/** icon for a compartment */
	public static final String ICON_COMPARTMENT = "/icons/none_comp_vis.gif"; //$NON-NLS-1$

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public Image getImage(Object element) {
		EObject eObject = EMFHelper.getEObject(element);
		if (eObject != null) {
			return getImage(eObject);
		}
		return super.getImage(element);
	}

	@Override
	protected Image getImage(EObject element) {
		if(element instanceof Diagram) {
			ViewPrototype proto = DiagramUtils.getPrototype((Diagram)element);
			if (proto == null)
				return null;
			return proto.getIcon();
		}

		// if the element is a compartment
		if(element instanceof BasicCompartment || element instanceof DecorationNode) {
			return org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.ID, ICON_COMPARTMENT);
		}

		return super.getImage(element);
	}

	/**
	 *
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 *
	 * @param element
	 * @return <ul>
	 *         <li>if element is a {@link NamedElement}, we return its name</li>
	 *         <li>else if element is a {@link Element}, we return its type + a index</li>
	 *         <li>else return Messages#EditorLabelProvider_No_name</li>
	 *         </ul>
	 */
	@Override
	protected String getText(EObject element) {
		if(element instanceof Diagram) {
			return ((Diagram)element).getName();
		}

		if(element instanceof View) { // maybe it is a view of a compartment
			String humanType = NotationTypesMap.instance.getHumanReadableType((View)element);
			if(humanType != null) {
				return humanType;
			}

			EditPart dummyEP = EditPartService.getInstance().createGraphicEditPart((View)element);
			if(dummyEP instanceof ResizableCompartmentEditPart) {
				return ((ResizableCompartmentEditPart)dummyEP).getCompartmentName();
			}
		}

		return super.getText(element);
	}
}
