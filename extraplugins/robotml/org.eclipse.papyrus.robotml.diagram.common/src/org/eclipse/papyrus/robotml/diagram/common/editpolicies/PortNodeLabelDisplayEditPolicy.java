/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.diagram.common.editpolicies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.communication.custom.helper.RotationHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Stereotype;



public class PortNodeLabelDisplayEditPolicy extends StereotypeNodeLabelDisplayEditPolicy {



	@Override
	public void notifyChanged(Notification notification) {
		final Object feature = notification.getFeature();
		if(feature == NotationPackage.eINSTANCE.getLocation_X() || feature == NotationPackage.eINSTANCE.getLocation_Y()) {
			Display.getDefault().asyncExec(new Runnable() {

				public void run() {
					refreshStereotypeDisplay();
				}
			});
		}
		super.notifyChanged(notification);
	}



	@Override
	public Image stereotypeIconToDisplay() {

		// retrieve the first stereotype in the list of displayed stereotype

		//String firstStereotypeName = tokenizer.nextToken();
		EList<Stereotype> stereotype_list = getUMLElement().getAppliedStereotypes();
		if(stereotype_list.size() != 0) {
			Stereotype stereotype = stereotype_list.get(0);
			if(stereotype.getName().equals("DataFlowPort") || stereotype.getName().equals("ServicePort")) {
				Image icon = Activator.getIconElement(getUMLElement(), stereotype, false);

				IFigure portView = getHostFigure();
				IFigure parentView = portView.getParent().getParent();

				Rectangle parentBounds = parentView.getBounds();
				Rectangle portBounds = portView.getBounds();

				if(portBounds.x() <= parentBounds.x()) {
					//left
					return icon;
				} else if(portBounds.x() >= (parentBounds.right() - portBounds.width())) {
					//right

					return new Image(icon.getDevice(), RotationHelper.rotateImage(icon, 180), SWT.IMAGE_COPY);
				} else if(portBounds.y() <= parentBounds.y()) {
					//top
					return new Image(icon.getDevice(), RotationHelper.rotateImage(icon, 90), SWT.IMAGE_COPY);
				} else if(portBounds.y() >= parentBounds.bottom() - portBounds.height()) {
					//bottom
					return new Image(icon.getDevice(), RotationHelper.rotateImage(icon, -90), SWT.IMAGE_COPY);
				} else {
					return null;
				}
			}
			return Activator.getIconElement(getUMLElement(), stereotype, false);

		}
		return null;

	}
}
