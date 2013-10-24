/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.utils;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ViewDescriptorUtil;
import org.eclipse.papyrus.sysml.constraints.ConstraintBlock;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.common.helper.ElementHelper;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This class provides convenience methods to create Type specific drop action (Show Port on BlockPropertyComposite).
 */public class ConstraintParameterDropHelper extends ElementHelper {

	public ConstraintParameterDropHelper(TransactionalEditingDomain editDomain) {
		this.editDomain = editDomain;
	}

	public Command getDropConstraintParameter(Property droppedConstraintParameter, Point location, GraphicalEditPart host) {
		return getDropConstraintParameterOnPart(droppedConstraintParameter, location, host);
	}

	public Command getDropConstraintParameterOnPart(Property droppedConstraintParameter, Point location, GraphicalEditPart host) {

		if(!isValidConstraintParameter(droppedConstraintParameter, getHostEObject(host))) {
			return UnexecutableCommand.INSTANCE;
		}

		// Prepare the view creation command
		ViewDescriptor descriptor = new ViewDescriptor(new SemanticAdapter((EObject)droppedConstraintParameter, null), Node.class, /* explicit semantic hint is mandatory */ null, ViewDescriptorUtil.PERSISTED, host.getDiagramPreferencesHint());
		CreateViewRequest createViewRequest = new CreateViewRequest(descriptor);
		createViewRequest.setLocation(location);
		Command viewCreateCommand = host.getCommand(createViewRequest);

		return viewCreateCommand;
	}

	private boolean isValidConstraintParameter(Object object, EObject dropTarget) {
		// check if not a Port/FlowPort ...
		if (object instanceof Port) {
			return false;
		}
		// drop on a Block/ConstraintBlock
		if (dropTarget instanceof Class && UMLUtil.getStereotypeApplication((Class)dropTarget, ConstraintBlock.class) != null) {
			return ((Class)dropTarget).getOwnedAttributes().contains(object);
		}
		// drop on a part
		if (dropTarget instanceof Property && UMLUtil.getStereotypeApplication((Property)dropTarget, ConstraintProperty.class) != null) {
			Type type = ((Property)dropTarget).getType();
			if (type instanceof Class && UMLUtil.getStereotypeApplication((Class)type, ConstraintBlock.class) != null) {
				return ((Class)type).getOwnedAttributes().contains(object);
			}
		}
		return false;
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
