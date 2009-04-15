/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
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
package org.eclipse.papyrus.diagram.usecase.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.papyrus.diagram.usecase.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.usecase.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.usecase.providers.ElementInitializers;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class AssociationCreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	private final EObject source;

	/**
	 * @generated
	 */
	private final EObject target;

	/**
	 * @generated
	 */
	private Package container;

	/**
	 * @generated
	 */
	public AssociationCreateCommand(CreateRelationshipRequest request,
			EObject source, EObject target) {
		super(request);
		this.source = source;
		this.target = target;
		if (request.getContainmentFeature() == null) {
			setContainmentFeature(UMLPackage.eINSTANCE
					.getPackage_PackagedElement());
		}

		// Find container element for the new link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null; element = element
				.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
				super.setElementToEdit(container);
				break;
			}
		}
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null && false == source instanceof Type) {
			return false;
		}
		if (target != null && false == target instanceof Type) {
			return false;
		}
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if (getContainer() == null) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateAssociation_4004(getContainer(), getSource(),
						getTarget());
	}

	/**
	 * @generated NOT
	 */
	protected Diagram getDiagramFromRequest() {
		if (getRequest().getParameters().get(
				MultiDiagramUtil.BelongToDiagramSource) != null) {
			Object parameter = getRequest().getParameters().get(
					MultiDiagramUtil.BelongToDiagramSource);
			if (parameter instanceof Diagram) {
				return (Diagram) parameter;
			}
		}
		return null;
	}

	/**
	 * Ddue to association end conventions the member end of type SourceType must be the first one created thus, we are calling UML2 createAssociation() in opposite order
	 * 
	 * @generated NOT
	 */
	@Override
	protected EObject doDefaultElementCreation() {
		Type sourceType = getSource();
		Type targetType = getTarget();

		Association result = targetType.createAssociation(false,
				AggregationKind.NONE_LITERAL, "src", 1, 1, sourceType, false,
				AggregationKind.NONE_LITERAL, "dst", 1, 1);

		ElementInitializers.init_Association_4004(result);
		Diagram diagram = getDiagramFromRequest();
		if (diagram != null) {
			MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram, result);
		} else {
			MultiDiagramUtil.addEAnnotationReferenceToDiagram(
					UMLDiagramEditorPlugin.getInstance(), result);
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected EClass getEClassToEdit() {
		return UMLPackage.eINSTANCE.getPackage();
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException(
					"Invalid arguments in create link command"); //$NON-NLS-1$
		}
		return super.doExecuteWithResult(monitor, info);
	}

	/**
	 * @generated
	 */
	protected ConfigureRequest createConfigureRequest() {
		ConfigureRequest request = super.createConfigureRequest();
		request.setParameter(CreateRelationshipRequest.SOURCE, getSource());
		request.setParameter(CreateRelationshipRequest.TARGET, getTarget());
		return request;
	}

	/**
	 * @generated
	 */
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @generated
	 */
	protected Type getSource() {
		return (Type) source;
	}

	/**
	 * @generated
	 */
	protected Type getTarget() {
		return (Type) target;
	}

	/**
	 * @generated
	 */
	public Package getContainer() {
		return container;
	}
}
