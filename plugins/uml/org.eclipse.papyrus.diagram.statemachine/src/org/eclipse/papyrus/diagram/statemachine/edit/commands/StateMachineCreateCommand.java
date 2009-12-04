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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.statemachine.providers.ElementInitializers;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class StateMachineCreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	private EClass eClass = null;

	/**
	 * @generated
	 */
	private EObject eObject = null;

	/**
	 * @generated
	 */
	public StateMachineCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static StateMachineCreateCommand create(CreateElementRequest req,
			EObject eObject) {
		return new StateMachineCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public StateMachineCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated
	 */
	@Override
	protected EObject getElementToEdit() {

		EObject container = ((CreateElementRequest)getRequest())
				.getContainer();
		if(container instanceof View) {
			container = ((View)container).getElement();
		}
		if(container != null) {
			return container;
		}
		return eObject;
	}

	/**
	 * @generated
	 */
	@Override
	protected EClass getEClassToEdit() {

		EObject eObject = getElementToEdit();
		if(eObject != null) {
			return eObject.eClass();
		}
		if(eClass != null) {
			return eClass;
		}
		return UMLPackage.eINSTANCE.getPackage();
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
	 * Modified to add <Region> element to the <Diagram>'s list of references.
	 * 
	 * @generated NOT
	 */
	@Override
	protected EObject doDefaultElementCreation() {
		StateMachine newElement = (StateMachine)super
				.doDefaultElementCreation();
		if(newElement != null) {
			ElementInitializers.init_StateMachine_1001(newElement);
			Diagram diagram = getDiagramFromRequest();
			if(diagram != null) {
				MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram,
						newElement);
			} else {
				MultiDiagramUtil.addEAnnotationReferenceToDiagram(
						UMLDiagramEditorPlugin.getInstance(), newElement);
			}
			// fjcano: add all initialized regions to the diagram list of
			// references
			if(newElement.getRegions().size() > 0) {
				for(EObject eObject : newElement.getRegions()) {
					if(diagram != null) {
						MultiDiagramUtil.AddEAnnotationReferenceToDiagram(
								diagram, eObject);
					} else {
						MultiDiagramUtil.addEAnnotationReferenceToDiagram(
								UMLDiagramEditorPlugin.getInstance(), eObject);
					}
				}
			}
		}
		return newElement;
	}
}
