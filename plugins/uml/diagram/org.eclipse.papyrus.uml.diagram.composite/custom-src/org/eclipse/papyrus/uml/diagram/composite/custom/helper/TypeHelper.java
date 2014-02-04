/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - customization for CollaborationUse
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.helper;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.common.helper.ElementHelper;
import org.eclipse.papyrus.uml.diagram.composite.custom.edit.command.CreateViewCommand;
import org.eclipse.papyrus.uml.diagram.composite.custom.edit.command.PropertyPartFromTypeCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.custom.utils.CompositeEditPartUtil;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.PropertyPartEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLPackage;

public class TypeHelper extends ElementHelper {

	public TypeHelper(TransactionalEditingDomain editDomain) {
		this.editDomain = editDomain;
	}

	public CompoundCommand dropTypeAsTypedProperty(GraphicalEditPart graphicalTarget, Type semanticElement, Point location) {
		CompoundCommand cc = new CompoundCommand("Drop type as typed property");

		EObject graphicalParentObject = graphicalTarget.resolveSemanticElement();

		IHintedType elementType = (IHintedType)UMLElementTypes.getElementType(PropertyPartEditPartCN.VISUAL_ID);

		if(graphicalParentObject instanceof StructuredClassifier) {

			SemanticAdapter semanticAdapter = new SemanticAdapter(null, null);

			// Prepare a command for the Property creation and the drop in diagram
			// 1. Prepare creation command
			CreateElementRequest req = new CreateElementRequest(getEditingDomain(), graphicalParentObject, elementType);
			PropertyPartFromTypeCreateCommand propertyCreateCommand = new PropertyPartFromTypeCreateCommand(req, (StructuredClassifier)graphicalParentObject, semanticElement, semanticAdapter);

			if(reTarget(graphicalTarget) != null) { // might be null, if composite compartment is not shown 
				// 2. Prepare the drop command
				ViewDescriptor descriptor = new ViewDescriptor((IAdaptable)propertyCreateCommand.getCommandResult().getReturnValue(), Node.class, elementType.getSemanticHint(), ViewUtil.APPEND, true, graphicalTarget.getDiagramPreferencesHint());
				CreateViewCommand viewCreateCommand = new CreateViewCommand(getEditingDomain(), descriptor, ((View)(reTarget(graphicalTarget).getModel())));
				SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)viewCreateCommand.getCommandResult().getReturnValue(), location);

				// 3. Create the compound command
				cc.add(new ICommandProxy(propertyCreateCommand));
				cc.add(new ICommandProxy(viewCreateCommand));
				cc.add(new ICommandProxy(setBoundsCommand));
			}
		}

		return cc;
	}

	public CompoundCommand dropTypeOnTypedElement(GraphicalEditPart graphicalTarget, Type semanticElement, Point location) {
		CompoundCommand cc = new CompoundCommand("Drop type on property");

		EObject graphicalParentObject = graphicalTarget.resolveSemanticElement();
		if(graphicalParentObject instanceof TypedElement) {
			SetRequest req = new SetRequest(graphicalParentObject, UMLPackage.eINSTANCE.getTypedElement_Type(), semanticElement);
			// Set type with confirmation dialog is currently disabled as it causes transaction issue (transaction is
			// never committed) in case of a DND from the diagram to the diagram (is work well from Explorer to Diagram).
			// The command is temporary replaced by a basic set value command without confirmation dialog.
			// SetTypeWithDialogCommand setTypeCommand = new SetTypeWithDialogCommand(req);
			//			SetValueCommand setTypeCommand = new SetValueCommand(req);
			//			cc.add(new ICommandProxy(setTypeCommand));

			// Drop type result in Property set with the dropped type.
			// The element edit service is use to retrieve the set command, specific diagram
			// advice is used to delete views that would become inconsistent after drop.
			EObject selectedEObject = req.getElementToEdit();
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(selectedEObject);
			if(provider != null) {
				ICommand setCommand = provider.getEditCommand(req);

				if(setCommand != null && setCommand.canExecute()) {
					cc.add(new ICommandProxy(setCommand));
				}
			}
			//			return UnexecutableCommand.INSTANCE;

		}

		return cc;
	}

	/**
	 * Drop a nested classifier into the structure compartment (added in context of bug 402717)
	 * 
	 * @param graphicalTarget
	 *        the edit part of the target element
	 * @param semanticElement
	 *        the element to drop
	 * @param location
	 *        its position.
	 * @return
	 */
	public CompoundCommand dropTypeOnClassifier(GraphicalEditPart graphicalTarget, Type semanticElement, Point location) {
		CompoundCommand cc = new CompoundCommand("Drop nested type on classifier");

		EObject semanticParentObject = graphicalTarget.resolveSemanticElement();
		if(semanticParentObject instanceof StructuredClassifier) {

			if(reTarget(graphicalTarget) != null) { // might be null, if composite compartment is not shown
				View parentView = (View)reTarget(graphicalTarget).getModel();
				IHintedType elementType = (IHintedType)UMLElementTypes.getElementType(UMLVisualIDRegistry.getNodeVisualID(parentView, semanticElement));

				if(elementType != null) {
					ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(semanticElement), Node.class, elementType.getSemanticHint(), ViewUtil.APPEND, false, graphicalTarget.getDiagramPreferencesHint());
					CreateViewCommand viewCreateCommand = new CreateViewCommand(getEditingDomain(), descriptor, parentView);
					SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)viewCreateCommand.getCommandResult().getReturnValue(), location);

					cc.add(new ICommandProxy(viewCreateCommand));
					cc.add(new ICommandProxy(setBoundsCommand));
				}
			}
		}

		return cc;
	}

	/**
	 * Re-target the target EditPart to the real expected target (e.g.: one of its compartment)
	 * 
	 * @param initialTarget
	 *        The original target
	 * @return the real expected target edit part (can return null)
	 */
	protected IGraphicalEditPart reTarget(IGraphicalEditPart initialTarget) {
		IGraphicalEditPart newTarget = null;

		if(!(initialTarget instanceof ShapeCompartmentEditPart)) {
			newTarget = CompositeEditPartUtil.getCompositeCompartmentEditPart(initialTarget);
		} else {
			// No need to re-target here
			newTarget = initialTarget;
		}

		return newTarget;
	}
}
