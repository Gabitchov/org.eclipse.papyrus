/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ViewDescriptorUtil;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.common.helper.ElementHelper;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;

/**
 * This class provides convenience methods to create Type specific drop action (Show BlockProperty on BlockPropertyComposite).
 */
public class PartDropHelper extends ElementHelper {

	public PartDropHelper(TransactionalEditingDomain editDomain) {
		this.editDomain = editDomain;
	}

	public Command getDropPartOnPart(DropObjectsRequest request, GraphicalEditPart host) {

		Object droppedEObject = request.getObjects().get(0);
		if(!isValidPart(droppedEObject, getHostEObject(host))) {
			return UnexecutableCommand.INSTANCE;
		}

		// Prepare the view creation command
		ViewDescriptor descriptor = new ViewDescriptor(new SemanticAdapter((EObject)droppedEObject, null), Node.class, /* explicit semantic hint is mandatory */ null, ViewDescriptorUtil.PERSISTED, host.getDiagramPreferencesHint());
		CreateViewRequest createViewRequest = new CreateViewRequest(descriptor);
		createViewRequest.setLocation(request.getLocation().getCopy());
		Command viewCreateCommand = host.getCommand(createViewRequest);

		return viewCreateCommand;
	}

	private boolean isValidPart(Object object, EObject dropTarget) {
		boolean isValid = false;

		// The drop object is supposed to be a Property
		if((object != null) && (object instanceof Property) && !(object instanceof Port)) {

			// The dropTarget has to be a TypedElement with a non-null Type
			if((dropTarget != null) && (dropTarget instanceof TypedElement) && (((TypedElement)dropTarget).getType() != null)) {

				Type targetType = ((TypedElement)dropTarget).getType();
				// The dropped object is owned by the target type 
				if(((Property)object).eContainer() == targetType) {
					isValid = true;
				}
			}
		}

		return isValid;
	}

	/**
	 * return the host Edit Part's semantic element, if the semantic element
	 * is <code>null</code> or unresolvable it will return <code>null</code>
	 * 
	 * @return EObject
	 */
	protected EObject getHostEObject(GraphicalEditPart host) {
		return ViewUtil.resolveSemanticElement((View)host.getModel());
	}
}
