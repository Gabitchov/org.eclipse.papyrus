package org.eclipse.papyrus.diagram.statemachine.custom.edit.part;

import static org.eclipse.papyrus.diagram.common.Activator.log;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.diagram.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.papyrus.diagram.statemachine.custom.figures.ChoiceStateNodeFigure;
import org.eclipse.papyrus.diagram.statemachine.custom.figures.DeepHistoryFigure;
import org.eclipse.papyrus.diagram.statemachine.custom.figures.InitialNodeFigure;
import org.eclipse.papyrus.diagram.statemachine.custom.figures.JoinForkNodeFigure;
import org.eclipse.papyrus.diagram.statemachine.custom.figures.JunctionStateNodeFigure;
import org.eclipse.papyrus.diagram.statemachine.custom.figures.ShallowHistoryFigure;
import org.eclipse.papyrus.diagram.statemachine.custom.helpers.Zone;
import org.eclipse.papyrus.diagram.statemachine.custom.locator.CustomLabelInRegionCompartmentLocator;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudoStateNodeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudoStateNodeLabelEditPart;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.UMLFactory;

public class CPseudoStateNodeEditPart extends PseudoStateNodeEditPart{

	public CPseudoStateNodeEditPart(View view) {
		super(view);
	}
	
	@Override
	protected void addBorderItem(IFigure borderItemContainer,
			IBorderItemEditPart borderItemEditPart) {
		if (borderItemEditPart instanceof PseudoStateNodeLabelEditPart) {
			IBorderItemLocator locator = new CustomLabelInRegionCompartmentLocator(
					getMainFigure(),Zone.getBounds((View)(this.getParent()).getParent().getModel()));
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	
	/**
	 * Used with the custom palette.
	 * The figure depends of the value of the PseudoStateKind property
	 */
	protected IFigure createNodeShape() {
		PseudostateKind pseudoStateKind = ((Pseudostate)((View)this.getModel()).getElement()).getKind();
		switch(pseudoStateKind){
		case SHALLOW_HISTORY_LITERAL:
			return primaryShape = new ShallowHistoryFigure();
		case INITIAL_LITERAL:
			return primaryShape = new InitialNodeFigure();
		case DEEP_HISTORY_LITERAL:
			return primaryShape = new DeepHistoryFigure();
		case FORK_LITERAL:
			return primaryShape = new JoinForkNodeFigure();
		case JOIN_LITERAL:
			return primaryShape = new JoinForkNodeFigure();
		case JUNCTION_LITERAL:
			return primaryShape = new JunctionStateNodeFigure();
		case CHOICE_LITERAL:
			return primaryShape = new ChoiceStateNodeFigure();
		}

		return null;

	}
	
	public IFigure getPrimaryShape() {
		return  (IFigure) primaryShape;
	}

	/**
	 *  Used to delete the default figure of the PseudoState and to create a new figure
	 *  corresponding to the value of the PseudoStateKind property
	 *  
	 */
	protected void handleNotificationEvent(Notification evt) {
		super.handleNotificationEvent(evt);
		if (UMLFactory.eINSTANCE.getUMLPackage().getPseudostate_Kind().equals(evt.getFeature())){	
			super.handleMajorSemanticChange();
		}
		}

}
