/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.policies;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GroupEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;

/**
 * This class provide customization of the CreationEditPolicy to support the
 * case where a Port is created in a Compartment. In such a case the Port should
 * be added to the compartment owner.
 * 
 * Class created from PinInCompartmentCreationEditPolicy (composite diagram)
 * TODO change extend CreationEditPolicy by CreateInReferencingGroupEditPolicy
 */
public class ActivityParameterNodeInCompartmentCreationEditPolicy extends DefaultCreationEditPolicy {

	@Override
	public EditPart getTargetEditPart(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			CreateUnspecifiedTypeRequest createUnspecifiedTypeRequest = (CreateUnspecifiedTypeRequest)request;
			if(understandsRequest(request)) {
				List<?> elementTypes = createUnspecifiedTypeRequest.getElementTypes();
				// Treat the case where only one element type is listed
				// Only take Port element type into account
				if((elementTypes.size() == 1) && ((IElementType)(elementTypes.get(0)) == UMLElementTypes.ActivityParameterNode_3059)) {
					// If the target is a compartment replace by its parent edit
					// part
					if((getHost() instanceof ShapeCompartmentEditPart)) {
						return getHost().getParent();
					}
				}
			}
		}
		return super.getTargetEditPart(request);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getReparentCommand(ChangeBoundsRequest request) {
		Iterator editParts = request.getEditParts().iterator();
		View container = (View)getHost().getAdapter(View.class);
		EObject context = container == null ? null : ViewUtil.resolveSemanticElement(container);
        CompositeCommand cc = new CompositeCommand(DiagramUIMessages.AddCommand_Label);
		while ( editParts.hasNext() ) {
			EditPart ep = (EditPart)editParts.next();
			if ( ep instanceof LabelEditPart ) {
				continue;
			}
			if (ep instanceof GroupEditPart) {
                cc.compose(getReparentGroupCommand((GroupEditPart) ep));
            }		
			View view = (View)ep.getAdapter(View.class);
			if ( view == null ) {
				continue;
			}
			
			EObject semantic = ViewUtil.resolveSemanticElement(view);
			if ( semantic == null ) {
				cc.compose(getReparentViewCommand((IGraphicalEditPart)ep));
			}
			else if ( context != null && shouldReparent(semantic, context)) {
				cc.compose(getReparentCommand((IGraphicalEditPart)ep));
			}
		}
		return cc.isEmpty() ? null : new ICommandProxy(cc.reduce());
	}
}
