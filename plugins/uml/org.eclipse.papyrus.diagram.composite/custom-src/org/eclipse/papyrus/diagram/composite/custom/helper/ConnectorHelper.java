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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.custom.helper;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.CommonDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.diagram.common.helper.ElementHelper;
import org.eclipse.papyrus.diagram.composite.providers.UMLElementTypes;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Property;

/**
 * Helper class containing the specific behavior for drag and drop of Connector
 */
public class ConnectorHelper extends ElementHelper {

	/**
	 * Constructor
	 * 
	 * @param editDomain
	 *        the editing domain
	 */
	public ConnectorHelper(TransactionalEditingDomain editDomain) {
		super();
		this.editDomain = editDomain;
	}

	/**
	 * This method returns the drop command to use for Connector links. Mainly based on
	 * 
	 * @param connector
	 *        the connector to drop
	 * @param linkVisualID
	 *        the visual identifier of the EditPart of the dropped Connector
	 * @param viewer
	 * @param host
	 *        the EditPart of the element where the Connector is drop
	 * @param diagramPreferencesHint
	 * @param location
	 *        the location where the Connector is dropped
	 * @param containerView
	 * @return the drop command for Connector
	 */
	public CompositeCommand dropConnector(Connector connector, int linkVisualID, EditPartViewer viewer, EditPart host, PreferencesHint diagramPreferencesHint, Point location, View containerView) {

		CompositeCommand cc = new CompositeCommand("drop Connector");

		//
		ConnectableElement sourceRole = connector.getEnds().get(0).getRole();
		ConnectableElement targetRole = connector.getEnds().get(1).getRole();
		Property sourcePartWithPort = connector.getEnds().get(0).getPartWithPort();
		Property targetPartWithPort = connector.getEnds().get(1).getPartWithPort();

		// look for editpart
		GraphicalEditPart sourceEditPart = resolveRoleEditPart(sourceRole, sourcePartWithPort, viewer);
		GraphicalEditPart targetEditPart = resolveRoleEditPart(targetRole, targetPartWithPort, viewer);

		// descriptor of the link
		CreateConnectionViewRequest.ConnectionViewDescriptor linkdescriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(UMLElementTypes.getElementType(linkVisualID), ((IHintedType)UMLElementTypes.getElementType(linkVisualID)).getSemanticHint(), diagramPreferencesHint);

		IAdaptable sourceAdapter = null;
		IAdaptable targetAdapter = null;
		if(sourceEditPart == null) {
			// creation of the node
			ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(sourceRole), Node.class, null, ViewUtil.APPEND, false, ((IGraphicalEditPart)host).getDiagramPreferencesHint());

			// get the command and execute it.
			CreateCommand nodeCreationCommand = new CreateCommand(((IGraphicalEditPart)host).getEditingDomain(), descriptor, ((View)host.getModel()));
			cc.compose(nodeCreationCommand);
			SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue(), new Point(location.x, location.y + 100));
			cc.compose(setBoundsCommand);

			sourceAdapter = (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue();
		} else {
			sourceAdapter = new SemanticAdapter(null, sourceEditPart.getModel());
		}
		if(targetEditPart == null) {
			// creation of the node
			ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(targetRole), Node.class, null, ViewUtil.APPEND, false, ((IGraphicalEditPart)host).getDiagramPreferencesHint());

			// get the command and execute it.
			CreateCommand nodeCreationCommand = new CreateCommand(((IGraphicalEditPart)host).getEditingDomain(), descriptor, ((View)host.getModel()));
			cc.compose(nodeCreationCommand);
			SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue(), new Point(location.x, location.y - 100));
			cc.compose(setBoundsCommand);
			targetAdapter = (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue();

		} else {
			targetAdapter = new SemanticAdapter(null, targetEditPart.getModel());
		}

		CommonDeferredCreateConnectionViewCommand aLinkCommand = new CommonDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)UMLElementTypes.getElementType(linkVisualID)).getSemanticHint(), sourceAdapter, targetAdapter, viewer, diagramPreferencesHint, linkdescriptor, null);
		aLinkCommand.setElement(connector);
		cc.compose(aLinkCommand);
		return cc;
	}

	/**
	 * This method resolve the EditPart of the GraphicalElement attached to a ConnectorEnd.
	 * 
	 * @param role
	 *        the role of the considered ConnectorEnd
	 * @param partWithPort
	 *        the partWithPort feature of the considered ConnectorEnd
	 * @param viewer
	 * @return the searched EditPart or null
	 */
	private ShapeNodeEditPart resolveRoleEditPart(ConnectableElement role, Property partWithPort, EditPartViewer viewer) {
		Collection<?> editPartSet = viewer.getEditPartRegistry().values();
		Iterator<?> editPartIterator = editPartSet.iterator();
		EditPart foundEditPart = null;
		while(editPartIterator.hasNext() && foundEditPart == null) {

			EditPart currentEditPart = (EditPart)editPartIterator.next();

			if((currentEditPart instanceof ShapeNodeEditPart) && (role.equals(((ShapeNodeEditPart)currentEditPart).resolveSemanticElement()))) {

				if(partWithPort == null) {

					foundEditPart = currentEditPart;

				} else { // (partWithPort != null

					ShapeNodeEditPart graphicalParent = (ShapeNodeEditPart)currentEditPart.getParent();
					if(partWithPort.equals(graphicalParent.resolveSemanticElement())) {

						foundEditPart = currentEditPart;

					}
				}
			}
		}
		return (ShapeNodeEditPart)foundEditPart;
	}
}
