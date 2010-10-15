/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.policies.ClassDiagramDragDropEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.BlockDefinitionDiagramElementTypes;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

/** Customization of the DND edit policy for the Internal Block Diagram */
public class CustomDragDropEditPolicy extends ClassDiagramDragDropEditPolicy {
	
	private static final String QN_BLOCK_STEREOTYPE = "SysML::Blocks::Block";
	
	@Override
	protected IUndoableOperation getDropObjectCommand(
			DropObjectsRequest dropRequest, EObject droppedObject,
			Point location) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) getHost();
		
		IHintedType type = getHintedType(targetEditPart.getNotationView(),
				droppedObject);
		if (type == null) {
			return super.getDropObjectCommand(dropRequest, droppedObject, location);
		}

		if (targetEditPart.getModel() instanceof Diagram) {
			return getDefaultDropNodeCommand(type, location, droppedObject);
		}
		EObject graphicalParent = targetEditPart.resolveSemanticElement();
		if ((graphicalParent instanceof Element)
				&& ((Element) graphicalParent).getOwnedElements().contains(
						droppedObject)) {
			return getDefaultDropNodeCommand(type, location, droppedObject);
		}
		return super.getDropObjectCommand(dropRequest, droppedObject, location);
	}

	public IHintedType getHintedType(View containerView, EObject domainElement) {
		if (containerView instanceof Diagram) { // Top Nodes
			if (isBlock(domainElement)) {
				return BlockDefinitionDiagramElementTypes.BLOCK;
			}

		}
		if (domainElement instanceof Port) {
			return BlockDefinitionDiagramElementTypes.PORT_CN;
		}
		if (domainElement instanceof Property) {
			// semanticHint =
			// BlockDefinitionDiagramElementTypes.PROPERTY_CN.getSemanticHint();
		}
		return null;
	}

	private boolean isBlock(EObject domainElement) {
		return domainElement instanceof org.eclipse.uml2.uml.Class
				&& ((org.eclipse.uml2.uml.Class) domainElement)
						.getAppliedStereotype(QN_BLOCK_STEREOTYPE) != null;
	}

	private CompositeCommand getDefaultDropNodeCommand(IHintedType type,
			Point location, EObject droppedObject) {
		CompositeCommand cc = new CompositeCommand("Drop"); //$NON-NLS-1$
		IAdaptable elementAdapter = new EObjectAdapter(droppedObject);

		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter,
				Node.class, type.getSemanticHint(), ViewUtil.APPEND, false,
				getDiagramPreferencesHint());
		CreateCommand createCommand = new CreateCommand(getEditingDomain(),
				descriptor, ((View) (getHost().getModel())));
		cc.compose(createCommand);

		SetBoundsCommand setBoundsCommand = new SetBoundsCommand(
				getEditingDomain(),
				"move", (IAdaptable) createCommand.getCommandResult().getReturnValue(), location); //$NON-NLS-1$
		cc.compose(setBoundsCommand);
		return cc;
	}

}
