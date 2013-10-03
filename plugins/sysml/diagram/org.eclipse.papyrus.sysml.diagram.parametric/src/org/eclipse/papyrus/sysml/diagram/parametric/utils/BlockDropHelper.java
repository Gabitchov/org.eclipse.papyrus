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
package org.eclipse.papyrus.sysml.diagram.parametric.utils;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ViewDescriptorUtil;
import org.eclipse.papyrus.infra.services.edit.commands.ConfigureFeatureCommandFactory;
import org.eclipse.papyrus.infra.services.edit.commands.IConfigureCommandFactory;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.helper.ElementHelper;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This class provides convenience methods to create Block specific drop action (Part or Reference creation).
 */
public class BlockDropHelper extends ElementHelper {

	public BlockDropHelper(TransactionalEditingDomain editDomain) {
		this.editDomain = editDomain;
	}

	public Command getDropAsStructureItemOnPart(DropObjectsRequest request, GraphicalEditPart host, IElementType elementType) {
		Object droppedEObject = request.getObjects().get(0);
		String label = "";
		if(elementType == SysMLElementTypes.PART_PROPERTY) {
			label = "Create a new Part";
			// Exclude ConstraintProperty
			if (droppedEObject instanceof Type) {
				if (((ISpecializationType)SysMLElementTypes.CONSTRAINT_BLOCK).getMatcher().matches((Type)droppedEObject)) {
					return UnexecutableCommand.INSTANCE;
				}
			}
			// Exclude reference drop in diagram owned by a ConstraintBlock
			Element editPartOwner = (Element)host.resolveSemanticElement();
			if (editPartOwner instanceof Property) {
				editPartOwner = ((Property) editPartOwner).getType();
			}
			if (editPartOwner != null && ((ISpecializationType)SysMLElementTypes.CONSTRAINT_BLOCK).getMatcher().matches(editPartOwner)) {
				return UnexecutableCommand.INSTANCE;
			}
		}
		if(elementType == SysMLElementTypes.REFERENCE_PROPERTY) {
			label = "Create a new Reference";
			// Exclude ConstraintProperty
			if (droppedEObject instanceof Type) {
				if (((ISpecializationType)SysMLElementTypes.CONSTRAINT_BLOCK).getMatcher().matches((Type)droppedEObject)) {
					return UnexecutableCommand.INSTANCE;
				}
			}
			// Exclude reference drop in diagram owned by a ConstraintBlock
			Element editPartOwner = (Element)host.resolveSemanticElement();
			if (editPartOwner instanceof Property) {
				editPartOwner = ((Property) editPartOwner).getType();
			}
			if (editPartOwner != null && ((ISpecializationType)SysMLElementTypes.CONSTRAINT_BLOCK).getMatcher().matches(editPartOwner)) {
				return UnexecutableCommand.INSTANCE;
			}
		}
		if(elementType == SysMLElementTypes.ACTOR_PART_PROPERTY) {
			label = "Create a new ActorPart";
		}
		if(elementType == SysMLElementTypes.VALUE_PROPERTY) {
			label = "Create a new Value";
		}
		if(elementType == UMLElementTypes.PROPERTY) {
			label = "Create a new Property";
		}
		// New kind of element
		if(elementType == SysMLElementTypes.CONSTRAINT_PROPERTY) {
			label = "Create a new ConstraintProperty";
			// Constraint Property on ConstraintBlock strictly
			if (droppedEObject instanceof Type) {
				if (!((ISpecializationType)SysMLElementTypes.CONSTRAINT_BLOCK).getMatcher().matches((Type)droppedEObject)) {
					return UnexecutableCommand.INSTANCE;
				}
			}
		}
		
		CompoundCommand cc = new CompoundCommand(label);

		if(!isValidStructureItemType(droppedEObject, elementType)) {
			return UnexecutableCommand.INSTANCE;
		}

		// Verify target nature
		EObject target = getHostEObject(host);
		if((!(target instanceof TypedElement)) || (((TypedElement)target).getType() == null)) {
			return UnexecutableCommand.INSTANCE;
		}

		// The target type has to be a Block (will hold the created Port)
		Type targetType = ((TypedElement)target).getType();
		if(!((ISpecializationType)SysMLElementTypes.BLOCK).getMatcher().matches(targetType)) {
			return UnexecutableCommand.INSTANCE;
		}

		// Prepare a command for the element creation and the drop in diagram

		// 1. Prepare creation command
		ICommand createElementCommand = null;
		CreateElementRequest createElementRequest = new CreateElementRequest(getEditingDomain(), targetType, elementType);
		createElementRequest.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new ConfigureFeatureCommandFactory(UMLPackage.eINSTANCE.getTypedElement_Type(), request.getObjects().get(0)));
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetType);
		if(provider != null) {
			createElementCommand = provider.getEditCommand(createElementRequest);
		}
		IAdaptable createElementRequestAdapter = new CreateElementRequestAdapter(createElementRequest);

		// 2. Prepare the drop command
		ViewDescriptor descriptor = new ViewDescriptor(createElementRequestAdapter, Node.class, /* explicit semantic hint is mandatory */ null, ViewDescriptorUtil.PERSISTED, host.getDiagramPreferencesHint());
		CreateViewRequest createViewRequest = new CreateViewRequest(descriptor);
		createViewRequest.setLocation(request.getLocation().getCopy());
		Command viewCreateCommand = host.getCommand(createViewRequest);

		// 3. Create the compound command
		cc.add(new ICommandProxy(createElementCommand));
		cc.add(viewCreateCommand);

		return cc;
	}

	public Command getDropAsStructureItem(DropObjectsRequest request, GraphicalEditPart host, IElementType elementType) {
		Object droppedEObject = request.getObjects().get(0);
		String label = "";
		
		// Filter part/reference : a property type by a ConstraintBlock MUST be a ConstraintProperty
		if(elementType == SysMLElementTypes.PART_PROPERTY) {
			label = "Create a new Part";
			// Exclude ConstraintProperty
			if (droppedEObject instanceof Type) {
				if (((ISpecializationType)SysMLElementTypes.CONSTRAINT_BLOCK).getMatcher().matches((Type)droppedEObject)) {
					return UnexecutableCommand.INSTANCE;
				}
			}
			// Exclude reference drop in diagram owned by a ConstraintBlock
			Element diagramOwner = getDiagramOwner(host);
			if (diagramOwner != null && ((ISpecializationType)SysMLElementTypes.CONSTRAINT_BLOCK).getMatcher().matches(diagramOwner)) {
				return UnexecutableCommand.INSTANCE;
			}
		}
		if(elementType == SysMLElementTypes.REFERENCE_PROPERTY) {
			label = "Create a new Reference";
			// Exclude ConstraintProperty
			if (droppedEObject instanceof Type) {
				if (((ISpecializationType)SysMLElementTypes.CONSTRAINT_BLOCK).getMatcher().matches((Type)droppedEObject)) {
					return UnexecutableCommand.INSTANCE;
				}
			}
			// Exclude reference drop in diagram owned by a ConstraintBlock
			Element diagramOwner = getDiagramOwner(host);
			if (diagramOwner != null && ((ISpecializationType)SysMLElementTypes.CONSTRAINT_BLOCK).getMatcher().matches(diagramOwner)) {
				return UnexecutableCommand.INSTANCE;
			}
		}
		if(elementType == SysMLElementTypes.ACTOR_PART_PROPERTY) {
			label = "Create a new ActorPart";
		}
		if(elementType == SysMLElementTypes.VALUE_PROPERTY) {
			label = "Create a new Value";
		}
		if(elementType == UMLElementTypes.PROPERTY) {
			label = "Create a new Property";
		}
		
		// New kind of element
		if(elementType == SysMLElementTypes.CONSTRAINT_PROPERTY) {
			label = "Create a new ConstraintProperty";
			// Constraint Property on ConstraintBlock strictly
			if (droppedEObject instanceof Type) {
				if (!((ISpecializationType)SysMLElementTypes.CONSTRAINT_BLOCK).getMatcher().matches((Type)droppedEObject)) {
					return UnexecutableCommand.INSTANCE;
				}
			}
		}
		CompoundCommand cc = new CompoundCommand(label);

		if(!isValidStructureItemType(droppedEObject, elementType)) {
			return UnexecutableCommand.INSTANCE;
		}

		// Prepare a command for the element creation and the drop in diagram

		// 1. Prepare creation command
		ICommand createElementCommand = null;
		CreateElementRequest createElementRequest = new CreateElementRequest(getEditingDomain(), getHostEObject(host), elementType);
		createElementRequest.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new ConfigureFeatureCommandFactory(UMLPackage.eINSTANCE.getTypedElement_Type(), request.getObjects().get(0)));
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getHostEObject(host));
		if(provider != null) {
			createElementCommand = provider.getEditCommand(createElementRequest);
		}
		IAdaptable createElementRequestAdapter = new CreateElementRequestAdapter(createElementRequest);

		// 2. Prepare the drop command
		ViewDescriptor descriptor = new ViewDescriptor(createElementRequestAdapter, Node.class, /* explicit semantic hint is mandatory */ null, ViewDescriptorUtil.PERSISTED, host.getDiagramPreferencesHint());
		CreateViewRequest createViewRequest = new CreateViewRequest(descriptor);
		createViewRequest.setLocation(request.getLocation().getCopy());
		Command viewCreateCommand = host.getCommand(createViewRequest);

		// 3. Create the compound command
		cc.add(new ICommandProxy(createElementCommand));
		cc.add(viewCreateCommand);

		return cc;
	}

	private Element getDiagramOwner(GraphicalEditPart host) {
		Object model = host.getRoot().getContents().getModel();
		if (model instanceof View) {
			return (Element)((View) model).getElement();
		}
		return null;
	}

	private boolean isValidStructureItemType(Object object, IElementType elementType) {
		boolean isValid = false;

		if((object != null) && (object instanceof Type) && !(object instanceof Association)) {

			Type type = (Type)object;
			if((elementType == SysMLElementTypes.PART_PROPERTY) || (elementType == SysMLElementTypes.REFERENCE_PROPERTY)) {
				if(((ISpecializationType)SysMLElementTypes.BLOCK).getMatcher().matches(type)) {
					isValid = true;
				}
			}
			if(elementType == SysMLElementTypes.ACTOR_PART_PROPERTY) {
				if(type instanceof Actor) {
					isValid = true;
				}
			}
			if(elementType == SysMLElementTypes.VALUE_PROPERTY) {
				if(((ISpecializationType)SysMLElementTypes.VALUE_TYPE).getMatcher().matches(type) || (type instanceof DataType)) {
					isValid = true;
				}
			}
			if((elementType == SysMLElementTypes.CONSTRAINT_PROPERTY)) {
				if(((ISpecializationType)SysMLElementTypes.BLOCK).getMatcher().matches(type)) {
					isValid = true;
				}
			}
			if(elementType == UMLElementTypes.PROPERTY) {
				if(!((ISpecializationType)SysMLElementTypes.BLOCK).getMatcher().matches(type)
						&& !(type instanceof Actor)
						&& !(type instanceof DataType)
						&& !((ISpecializationType)SysMLElementTypes.VALUE_TYPE).getMatcher().matches(type)) {
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
