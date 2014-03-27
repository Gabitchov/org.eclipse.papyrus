/*
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
package org.eclipse.papyrus.uml.diagram.clazz.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.AssociationClassCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.AssociationNodeCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.ClassCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.CommentCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.ComponentCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.ConstraintCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.DataTypeCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.DefaultNamedElementCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.DependencyNodeCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.DurationObservationCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.EnumerationCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.InformationItemCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.InstanceSpecificationCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.InterfaceCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.ModelCreateCommandTN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.PackageCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.PrimitiveTypeCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.ShortCutDiagramCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.SignalCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.TimeObservationCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class ModelItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ModelItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
		if (requestElementType == null) {
			return super.getCreateCommand(req);
		}
		IElementType baseElementType = requestElementType;
		boolean isExtendedType = false;
		if (requestElementType instanceof IExtendedHintedElementType) {
			baseElementType = ElementTypeUtils.getClosestDiagramType(requestElementType);
			if (baseElementType != null) {
				isExtendedType = true;
			} else {
				// no reference element type ID. using the closest super element type to give more opportunities, but can lead to bugs.
				baseElementType = ElementTypeUtils.findClosestNonExtendedElementType((IExtendedHintedElementType) requestElementType);
				isExtendedType = true;
			}
		}

		if (UMLElementTypes.Dependency_2014 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new DependencyNodeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.AssociationClass_2013 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new AssociationClassCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Association_2015 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new AssociationNodeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.InstanceSpecification_2001 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new InstanceSpecificationCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Component_2002 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new ComponentCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Signal_2003 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new SignalCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Interface_2004 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new InterfaceCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Model_2005 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new ModelCreateCommandTN(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Enumeration_2006 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new EnumerationCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Package_2007 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new PackageCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.InformationItem_2099 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new InformationItemCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Class_2008 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new ClassCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.PrimitiveType_2009 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new PrimitiveTypeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.DataType_2010 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new DataTypeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Constraint_2011 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new ConstraintCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Comment_2012 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new CommentCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Diagram_2016 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new ShortCutDiagramCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.DurationObservation_2095 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new DurationObservationCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.TimeObservation_2096 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new TimeObservationCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.NamedElement_2097 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new DefaultNamedElementCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}

	}

}
