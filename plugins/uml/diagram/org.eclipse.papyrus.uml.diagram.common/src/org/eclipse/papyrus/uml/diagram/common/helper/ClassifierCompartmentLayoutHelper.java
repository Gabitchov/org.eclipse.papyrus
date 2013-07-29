/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.helper;

import java.util.HashMap;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.infra.emf.appearance.commands.SetLayoutKindCommand;
import org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants;
import org.eclipse.papyrus.uml.diagram.common.figure.layout.ILayoutToolBox;

/**
 * The Class ClassifierCompartmentLayoutHelper.
 */
public abstract class ClassifierCompartmentLayoutHelper implements ICompartmentLayoutHelper {

	protected HashMap<String, ILayoutToolBox> layoutToolBoxList = null;

	/**
	 * Instantiates a new classifier compartment layout helper.
	 */
	public ClassifierCompartmentLayoutHelper() {
		layoutToolBoxList = new HashMap<String, ILayoutToolBox>();
	}

	/**
	 * {@inheritDoc}
	 */
	public void applyLayout(AbstractGraphicalEditPart compartmentEditPart) {
		EditPart containerEditPart = compartmentEditPart.getParent();
		IFigure fig = (IFigure)(((IGraphicalEditPart)containerEditPart).getFigure().getChildren().get(0));
		IFigure primaryfig = (IFigure)(fig.getChildren().get(0));
		String layoutKind = getLayoutKindFromView(((EModelElement)containerEditPart.getModel()));
		ILayoutToolBox currentLayoutToolBox = layoutToolBoxList.get(layoutKind);
		if(currentLayoutToolBox != null) {
			compartmentEditPart.installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, currentLayoutToolBox.getEditPolicy());
			primaryfig.setLayoutManager(currentLayoutToolBox.getFigureLayout());
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public String getLayoutKindFromView(EModelElement modelElement) {
		EAnnotation layoutAnnotation = modelElement.getEAnnotation(VisualInformationPapyrusConstants.LAYOUTFIGURE);
		if(layoutAnnotation != null) {
			EMap<String, String> entries = layoutAnnotation.getDetails();

			if(entries != null) {
				String gradientvalueString = entries.get(VisualInformationPapyrusConstants.LAYOUTFIGURE_VALUE);
				return gradientvalueString;
			}
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 */
	public SetLayoutKindCommand setLayoutKindOnView(TransactionalEditingDomain domain, EModelElement view, String layoutKind) {
		return new SetLayoutKindCommand(domain, view, layoutKind);
	}

}
