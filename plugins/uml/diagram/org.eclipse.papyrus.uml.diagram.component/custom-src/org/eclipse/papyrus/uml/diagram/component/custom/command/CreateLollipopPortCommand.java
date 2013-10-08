package org.eclipse.papyrus.uml.diagram.component.custom.command;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.EObjectValueStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PortEditPart;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLViewProvider;
import org.eclipse.uml2.uml.Interface;


public class CreateLollipopPortCommand extends RecordingCommand {

	protected  ArrayList<Interface> providedInterface= new ArrayList<Interface>();
	protected  ArrayList<Interface> requiredInterface= new ArrayList<Interface>();
	protected PortEditPart porteditPart=null;

	public CreateLollipopPortCommand(TransactionalEditingDomain domain, Collection<Interface> provided, Collection<Interface> required, PortEditPart portEditpart ) {
		super(domain,"Creation of lollipop for ports");
		providedInterface.addAll(provided);
		requiredInterface.addAll(required);
		this.porteditPart= portEditpart;
	}

	@Override
	protected void doExecute() {
		UMLViewProvider umlViewProvider= new UMLViewProvider();
		//take the great parent of the port
		EditPart componentEditPart=porteditPart.getParent();
		EditPart container= componentEditPart.getParent();
		for(Interface currentRequired : requiredInterface) {
			Node node=umlViewProvider.createNamedElement_2003(currentRequired,(View) container.getModel(), -1, true, porteditPart.getDiagramPreferencesHint());
			((Bounds)node.getLayoutConstraint()).setWidth(20);
			((Bounds)node.getLayoutConstraint()).setHeight(20);
			
			Edge edge=umlViewProvider.createLink_4016(((View)porteditPart.getModel()).getDiagram(), -1, true, porteditPart.getDiagramPreferencesHint());

			IdentityAnchor anchor = NotationFactory.eINSTANCE.createIdentityAnchor();
			edge.setSourceAnchor(anchor);
			anchor = NotationFactory.eINSTANCE.createIdentityAnchor();
			edge.setTargetAnchor(anchor);
			edge.setSource((View)porteditPart.getModel());
			edge.setTarget(node);
			edge.setElement(null);

		}

		for(Interface currentprovided : providedInterface) {
			Node node=umlViewProvider.createNamedElement_2003(currentprovided,(View) container.getModel(), -1, true, porteditPart.getDiagramPreferencesHint());
			((Bounds)node.getLayoutConstraint()).setWidth(20);
			((Bounds)node.getLayoutConstraint()).setHeight(20);
			
			Edge edge=umlViewProvider.createLink_4016(((View)porteditPart.getModel()).getDiagram(), -1, true, porteditPart.getDiagramPreferencesHint());


			IdentityAnchor anchor = NotationFactory.eINSTANCE.createIdentityAnchor();
			edge.setSourceAnchor(anchor);
			anchor = NotationFactory.eINSTANCE.createIdentityAnchor();
			edge.setTargetAnchor(anchor);
			edge.setSource((View)porteditPart.getModel());
			edge.setTarget(node);
			edge.setElement(null);
		}
	}
}
