package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.UMLEdgeFigure;
import org.eclipse.uml2.uml.Message;

public abstract class AbstractMessageEditPart extends ConnectionNodeEditPart {
	
	private List messageEventParts;
	
	public AbstractMessageEditPart(View view) {
		super(view);
	}
	
	@Override
	protected void reorderChild(EditPart child, int index) {
		if(!(child instanceof MessageEndEditPart))
			super.reorderChild(child, index);		
	}
	
 
	public View findChildByModel(EObject model) {
		List list = getModelChildren();
		if(list != null && list.size() > 0) {
			for(Object o : list) {
				if(!(o instanceof View) )
					continue;
				
				View view = (View) o;
				if(view.getElement() == model){
					return view;
				}
			}
		}
		return null;
	}
	
	@Override
	public List getChildren() {
		if (messageEventParts == null) {
			initMessageEventPart();
		}
		return messageEventParts;
	}

	protected void initMessageEventPart() {
		messageEventParts = new ArrayList();

		EObject element = this.resolveSemanticElement();
		if (!(element instanceof Message))
			return;
		Message message = (Message) element;
		UMLEdgeFigure edgeFigure = (UMLEdgeFigure) this.getFigure();
		final MessageEndEditPart sendEventPart = new MessageEndEditPart(
				message.getSendEvent(), this, new ConnectionLocator(edgeFigure,
						ConnectionLocator.SOURCE));
		messageEventParts.add(sendEventPart);

		final MessageEndEditPart receiveEventPart = new MessageEndEditPart(
				message.getReceiveEvent(), this, new ConnectionLocator(
						edgeFigure, ConnectionLocator.TARGET));
		messageEventParts.add(receiveEventPart);

		Diagram diagram = ((View) this.getModel()).getDiagram();
		sendEventPart.rebuildLinks(diagram);
		receiveEventPart.rebuildLinks(diagram);
	}
}
