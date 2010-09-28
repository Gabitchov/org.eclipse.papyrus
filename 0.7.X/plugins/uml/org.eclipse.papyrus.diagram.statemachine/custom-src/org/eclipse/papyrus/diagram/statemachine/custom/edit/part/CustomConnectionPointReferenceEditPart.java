package org.eclipse.papyrus.diagram.statemachine.custom.edit.part;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.statemachine.custom.figures.ConnectionPointReferenceFigure;
import org.eclipse.papyrus.diagram.statemachine.custom.figures.StateFigure;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReferenceEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.State;


public class CustomConnectionPointReferenceEditPart extends ConnectionPointReferenceEditPart {

	public CustomConnectionPointReferenceEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleNotificationEvent(Notification event) {
		// TODO Auto-generated method stub
		super.handleNotificationEvent(event);
		
		refreshVisuals();
	}
	
	@Override
	protected void refreshVisuals() {
		// TODO Auto-generated method stub
		super.refreshVisuals();
		
		ConnectionPointReferenceFigure connPtRefFigure = getPrimaryShape();
		ConnectionPointReference connPtRef = (ConnectionPointReference)((View)getModel()).getElement();
		
		if (connPtRef.getEntries().isEmpty() && connPtRef.getExits().isEmpty())
			connPtRefFigure.setKind(0);
		else if (!connPtRef.getEntries().isEmpty())
			connPtRefFigure.setKind(1);
		else if (!connPtRef.getExits().isEmpty())
			connPtRefFigure.setKind(2);


	}
}
