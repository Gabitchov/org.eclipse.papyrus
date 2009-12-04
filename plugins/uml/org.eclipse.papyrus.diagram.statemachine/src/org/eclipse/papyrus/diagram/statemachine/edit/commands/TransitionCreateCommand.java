/*
 * Copyright (c) 2007 Borland Software Corporation
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Copyright (c) of modifications Conselleria de Infraestructuras y
 * Transporte, Generalitat de la Comunitat Valenciana. All rights reserved.
 * Modifications are made available under the terms of the Eclipse Public
 * License v1.0.
 *
 * Contributors:
 *  Sergey Gribovsky (Borland) - initial API and implementation
 *  Francisco Javier Cano Mu�oz (Prodevelop)
 *  Marc Gil Sendra (Prodevelop)
 */
package org.eclipse.papyrus.diagram.statemachine.edit.commands;

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
import org.eclipse.papyrus.diagram.statemachine.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;

/**
 * @generated
 */
public class TransitionCreateCommand extends CreateElementCommand {

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
	private Region container;

	/**
	 * @generated NOT
	 */
	public TransitionCreateCommand(CreateRelationshipRequest request,
			EObject source, EObject target) {
		super(request);
		this.source = source;
		this.target = target;

		if(request.getContainmentFeature() == null) {
			setContainmentFeature(UMLPackage.eINSTANCE.getRegion_Transition());
		}

		// Find container element for the new link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null; element = element
				.eContainer()) {
			if(element instanceof Region) {
				container = (Region)element;
				super.setElementToEdit(container);
				break;
			}
		}

		//add container if it's a Region
		if(request.getContainer() instanceof Region)
			this.container = (Region)request.getContainer();
		//end
	}

	/**
	 * @generated
	 */
	@Override
	public boolean canExecute() {
		if(source == null && target == null) {
			return false;
		}
		if(source != null && false == source instanceof Vertex) {
			return false;
		}
		if(target != null && false == target instanceof Vertex) {
			return false;
		}
		if(getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if(getContainer() == null) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateTransition_3001(getContainer(), getSource(),
				getTarget());
	}

	/**
	 * @generated
	 */
	protected Diagram getDiagramFromRequest() {

		if(getRequest().getParameters().get(
				MultiDiagramUtil.BelongToDiagramSource) != null) {
			Object parameter = getRequest().getParameters().get(
					MultiDiagramUtil.BelongToDiagramSource);
			if(parameter instanceof Diagram) {
				return (Diagram)parameter;
			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	protected EObject doDefaultElementCreation() {
		Transition newElement = UMLFactory.eINSTANCE.createTransition();
		getContainer().getTransitions().add(newElement);
		newElement.setSource(getSource());
		newElement.setTarget(getTarget());

		Diagram diagram = getDiagramFromRequest();
		if(diagram != null) {
			MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram,
					newElement);
		} else {
			MultiDiagramUtil.addEAnnotationReferenceToDiagram(
					UMLDiagramEditorPlugin.getInstance(), newElement);
		}
		return newElement;
	}

	/**
	 * @generated
	 */
	@Override
	protected EClass getEClassToEdit() {
		return UMLPackage.eINSTANCE.getRegion();
	}

	/**
	 * @generated
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}
		return super.doExecuteWithResult(monitor, info);
	}

	/**
	 * @generated
	 */
	@Override
	protected ConfigureRequest createConfigureRequest() {
		ConfigureRequest request = super.createConfigureRequest();
		request.setParameter(CreateRelationshipRequest.SOURCE, getSource());
		request.setParameter(CreateRelationshipRequest.TARGET, getTarget());
		return request;
	}

	/**
	 * @generated
	 */
	@Override
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @generated
	 */
	protected Vertex getSource() {
		return (Vertex)source;
	}

	/**
	 * @generated
	 */
	protected Vertex getTarget() {
		return (Vertex)target;
	}

	/**
	 * @generated
	 */
	public Region getContainer() {
		return container;
	}
}
