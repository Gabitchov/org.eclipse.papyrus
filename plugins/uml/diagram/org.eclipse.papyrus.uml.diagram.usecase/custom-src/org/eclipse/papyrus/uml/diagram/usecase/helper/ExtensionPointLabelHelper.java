/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.helper;

import java.util.Collection;
import java.util.jar.Attributes.Name;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.helper.StereotypedElementLabelHelper;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

/**
 * The Class ExtensionPointLabelHelper to display label on extension point
 * 
 * @author eperico
 */
public class ExtensionPointLabelHelper extends StereotypedElementLabelHelper {

	private static ExtensionPointLabelHelper labelHelper;

	public static ExtensionPointLabelHelper getInstance() {
		if(labelHelper == null) {
			labelHelper = new ExtensionPointLabelHelper();
		}
		return labelHelper;
	}

	/**
	 * Refreshes the label of the figure associated to the specified edit part
	 * 
	 * @param editPart
	 *        the edit part managing the refreshed figure
	 */
	public void refreshEditPartDisplay(GraphicalEditPart editPart) {
		IFigure figure = editPart.getFigure();
		// computes the icon to be displayed
		final Collection<Image> imageToDisplay = stereotypeIconsToDisplay(editPart);
		// for each element in the list of stereotype icon, adds it to the icons list of the
		// wrapping label
		// TODO (RS - CEA LIST): more icons were displayed before refresh: has to clean
		// TODO (RS - CEA LIST): how many icons were displayed => should fix a max number
		// solution: set all images to null, and then add the correct icons
		int i = 0;
		while(((WrappingLabel)figure).getIcon(i) != null) {
			((WrappingLabel)figure).setIcon(null, i);
			i++;
		}
		i = 0;
		for(Image image : imageToDisplay) {
			((WrappingLabel)figure).setIcon(image, i);
			i++;
		}
		((WrappingLabel)figure).setText(labelToDisplay(editPart));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NamedElement getUMLElement(GraphicalEditPart editPart) {
		EObject element = super.getUMLElement(editPart);
		if(element instanceof NamedElement) {
			return (NamedElement)element;
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String elementLabel(GraphicalEditPart editPart) {
		NamedElement element = getUMLElement(editPart);
		if(element != null) {
			return getUMLElement(editPart).getName();
		}
		return null;
		
	}
}
