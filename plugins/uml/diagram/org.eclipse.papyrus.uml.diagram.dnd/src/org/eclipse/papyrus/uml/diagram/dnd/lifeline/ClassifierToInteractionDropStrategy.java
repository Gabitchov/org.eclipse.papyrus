/*
 * 
 */
package org.eclipse.papyrus.uml.diagram.dnd.lifeline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalDropStrategy;
import org.eclipse.papyrus.uml.diagram.dnd.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.Classifier;

public class ClassifierToInteractionDropStrategy extends TransactionalDropStrategy {

	public String getLabel() {
		return "Create a Lifeline";
	}

	public String getDescription() {
		return "Drop a classifier on an interaction , create the lifeline and type it. This will create a new lifeline, a new Property in the interaction, typed by the dropped classifier. The Lifeline will represent this property." + "It is also possible to drop directly an already existing Property to the lifeline.";
	}

	public Image getImage() {
		return null;
	}

	public String getID() {
		return Activator.PLUGIN_ID + ".ClassifierToLifeline.represents";
	}

	@Deprecated
	public int getPriority() {
		return 0;
	}

	@Override
	protected Command doGetCommand(Request request, EditPart targetEditPart) {
		EObject targetElement = getTargetSemanticElement(targetEditPart);
		final Point location;
		if(!(targetElement instanceof Interaction)) {
			return null;
		}
		if( request instanceof DropObjectsRequest){
			location=((DropObjectsRequest)request).getLocation();
		}
		else{
			location=new Point(100, 100);
		}
		final EditPart interactionEditPart= targetEditPart;
		final Interaction targetInteraction = (Interaction)targetElement;

		List<EObject> sourceElements = getSourceEObjects(request);

		//The only supported case is "Drop a single classifier on an interaction"
		if(sourceElements.size() != 1) {
			return null;
		}

		EObject sourceElement = sourceElements.get(0);
		if(sourceElement instanceof Type) {
			final Type sourceType = (Type)sourceElement;

			Command resultCommand = new Command(getLabel()) {

				@Override
				public void execute() {
					Lifeline lifeline= targetInteraction.createLifeline("");
					Property property = targetInteraction.createOwnedAttribute("", sourceType);
					lifeline.setRepresents(property);
					ArrayList<Lifeline> droppedLifelines= new ArrayList<Lifeline>();
					droppedLifelines.add(lifeline);
					DropObjectsRequest dropRequest= new DropObjectsRequest();
					dropRequest.setObjects(droppedLifelines);
					dropRequest.setLocation(location);
					Command cmd=interactionEditPart.getCommand(dropRequest);
					cmd.execute();
					
					
				}
			};

			return resultCommand;
		} 

		return null;
	}

}
