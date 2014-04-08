/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.edit.part;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.figures.ConnectionPointReferenceFigure;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ConnectionPointReferenceEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ConnectionPointReferenceNameEditPart;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Pseudostate;


public class CustomConnectionPointReferenceNameEditPart extends ConnectionPointReferenceNameEditPart {

	public CustomConnectionPointReferenceNameEditPart(View view) {
		super(view);
	}

	@Override
	protected void handleNotificationEvent(Notification event) {
		// TODO Auto-generated method stub
		super.handleNotificationEvent(event);

		refreshVisuals();
	}

	public String getLinks(ConnectionPointReference ref) {
		String label = "";
		if(!ref.getEntries().isEmpty()) {
			boolean first = true;
			for(Pseudostate p : ref.getEntries()) {
				if(!first) {
					label += ", ";
				} else {
					first = false;
				}
				label += p.getName();
			}
		} else if(!ref.getExits().isEmpty()) {
			boolean first = true;
			for(Pseudostate p : ref.getExits()) {
				if(!first) {
					label += ", ";
				} else {
					first = false;
				}
				label += p.getName();
			}
		}
		return label;
	}

	@Override
	protected void refreshVisuals() {
		// TODO Auto-generated method stub
		super.refreshVisuals();

		ConnectionPointReferenceFigure connPtRefFigure = ((ConnectionPointReferenceEditPart)getParent()).getPrimaryShape();
		ConnectionPointReference connPtRef = (ConnectionPointReference)((View)getModel()).getElement();

		if(connPtRef.getEntries().isEmpty() && connPtRef.getExits().isEmpty())
			connPtRefFigure.setKind(0);
		else {
			setLabelText(getLinks(connPtRef));
			if(!connPtRef.getEntries().isEmpty()) {
				connPtRefFigure.setKind(1);

			} else if(!connPtRef.getExits().isEmpty()) {
				connPtRefFigure.setKind(2);
			}
		}

	}

}
