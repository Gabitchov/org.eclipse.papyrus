package org.eclipse.papyrus.uml.diagram.sequence.tests.bug;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.infra.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestLink;
import org.junit.Test;


/**
All lifelines (except lifelines that are result of a create message) should be
aligned vertically and must remain aligned.
https://bugs.eclipse.org/bugs/show_bug.cgi?id=364688
 *
 */
public class TestLifelineAlignment_364688 extends TestLink{
	
	protected ICreationCommand getDiagramCommandCreation() {
		return  new CreateSequenceDiagramCommand();
	}
	
	@Test
	public void testAlignment() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(20,20), new Dimension(62,200));
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100,100), new Dimension(62,200));
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(150,150), new Dimension(62,200));
	 
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		final LifelineEditPart lifeline2 = (LifelineEditPart)getRootEditPart().getChildren().get(1);
		final LifelineEditPart lifeline3 = (LifelineEditPart)getRootEditPart().getChildren().get(2);
		
		assertTrue("Lifeline vertical: " , getAbsoluteBounds(lifeline1).y == getAbsoluteBounds(lifeline2).y);
		assertTrue("Lifeline vertical: " , getAbsoluteBounds(lifeline3).y == getAbsoluteBounds(lifeline2).y);
		waitForComplete();
		 
		createLink(UMLElementTypes.Message_4006, lifeline2, lifeline3 );
		assertTrue("Lifeline vertical: " , getAbsoluteBounds(lifeline1).y == getAbsoluteBounds(lifeline2).y);
		assertTrue("Lifeline vertical: " , getAbsoluteBounds(lifeline3).y > getAbsoluteBounds(lifeline2).y);
	}
	
	public void createLink(IElementType linkType,EditPart source, EditPart target) {				
		CreateConnectionViewRequest req = createConnectionViewRequest(linkType, source, target);
		Command command = target.getCommand(req);
		assertNotNull(CREATION+COMMAND_NULL,command);
		assertTrue(CONTAINER_CREATION+TEST_IF_THE_COMMAND_CAN_BE_EXECUTED,command.canExecute()==true);
		
		getDiagramCommandStack().execute(command);		
	}
	
	public CreateConnectionViewRequest createConnectionViewRequest(IElementType type , EditPart source, EditPart target){
		CreateConnectionViewRequest connectionRequest = CreateViewRequestFactory.getCreateConnectionRequest(type,((IGraphicalEditPart) getDiagramEditPart())
			.getDiagramPreferencesHint());

		Point c = getAbsoluteCenter((IGraphicalEditPart)source);//provider.getConnectionSourceLocation(source);		
		connectionRequest.setLocation(c);
		
		connectionRequest.setSourceEditPart(null);
		connectionRequest.setTargetEditPart(source);
		connectionRequest.setType(RequestConstants.REQ_CONNECTION_START);
		Command cmd = source.getCommand(connectionRequest);
		// Now, setup the request in preparation to get the
		// connection end
		// command.
		connectionRequest.setSourceEditPart(source);
		connectionRequest.setTargetEditPart(target);
		connectionRequest
		.setType(RequestConstants.REQ_CONNECTION_END);
		
		
		Point t = getAbsoluteCenter((IGraphicalEditPart)target); //provider.getConnectionTargetLocation(target);		
		connectionRequest.setLocation(t);
		
		EObject container = getRootEditPart().resolveSemanticElement();
		connectionRequest.getExtendedData().put(SOURCE_MODEL_CONTAINER, container);
		connectionRequest.getExtendedData().put(TARGET_MODEL_CONTAINER, container);
		
		return connectionRequest;
	}
	
	public void createNode(IElementType type, GraphicalEditPart parent, Point location, Dimension size) {
		//CREATION
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getRootEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(location);
		requestcreation.setSize(size);
		Command command = parent.getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getDiagramCommandStack().execute(command);
	}
		
	
	/**
	 * Get the bounds of an edit part
	 * 
	 * @param part
	 *        edit part to find bounds
	 * @return part's bounds in absolute coordinates
	 */
	public static Rectangle getAbsoluteBounds(IGraphicalEditPart part) {
		// take bounds from figure
		Rectangle bounds = part.getFigure().getBounds().getCopy();

		if(part.getNotationView() instanceof Node) {
			// rather update with up to date model bounds
			Node node = (Node)part.getNotationView();
			LayoutConstraint cst = node.getLayoutConstraint();
			if(cst instanceof Bounds) {
				Bounds b = (Bounds)cst;
				Point parentLoc = part.getFigure().getParent().getBounds().getLocation();
				if(b.getX() > 0) {
					bounds.x = b.getX() + parentLoc.x;
				}
				if(b.getY() > 0) {
					bounds.y = b.getY() + parentLoc.y;
				}
				if(b.getHeight() != -1) {
					bounds.height = b.getHeight();
				}
				if(b.getWidth() != -1) {
					bounds.width = b.getWidth();
				}
			}
		}

		part.getFigure().getParent().translateToAbsolute(bounds);
		return bounds;
	}

}
