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
package org.eclipse.papyrus.uml.diagram.statemachine.custom.policies;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.commands.CustomFirstRegionInStateMachineCreateElementCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.helpers.Zone;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes;

public class CustomStateMachineCompartmentCreationEditPolicy extends CreationEditPolicy {
	IFigure sizeOnDropFeedback = null;
	String dropLocation = Zone.RIGHT;

	@Override
	public Command getCommand(Request request) {
		// CHECK THIS
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(editingDomain, DiagramUIMessages.AddCommand_Label);
		if (understandsRequest(request)) {
			if (request instanceof CreateUnspecifiedTypeRequest) {
				CreateUnspecifiedTypeRequest unspecReq = (CreateUnspecifiedTypeRequest) request;
				for (Iterator<?> iter = unspecReq.getElementTypes().iterator(); iter.hasNext();) {
					IElementType elementType = (IElementType) iter.next();
					if (((IHintedType) elementType).getSemanticHint().equals(((IHintedType) UMLElementTypes.Region_3000).getSemanticHint())) {
						// starting point is the existing region compartment on
						// which mouse was moving
						View existingRegionCompartmentView = (View) getHost().getModel();
						// the existing region view
						View existingRegionView = (View) existingRegionCompartmentView.eContainer();
						// get and adaptable for it, to pass on to commands
						IAdaptable adaptableForExistingRegionView = (IAdaptable) new SemanticAdapter(null, existingRegionView);
						// do the whole job
						CustomFirstRegionInStateMachineCreateElementCommand createNewRegion = new CustomFirstRegionInStateMachineCreateElementCommand(adaptableForExistingRegionView, null, ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint(),
								editingDomain, DiagramUIMessages.CreateCommand_Label, dropLocation);
						cc.compose(createNewRegion);
						return new ICommandProxy(cc.reduce());
					}
				}
			}
			else if (request instanceof ChangeBoundsRequest) {
				return getReparentCommand((ChangeBoundsRequest) request);
			}
			return super.getCommand(request);
		}
		return null;
	}
}
