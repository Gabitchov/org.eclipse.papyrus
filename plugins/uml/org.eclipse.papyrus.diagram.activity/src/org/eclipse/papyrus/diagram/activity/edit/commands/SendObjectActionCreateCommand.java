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
package org.eclipse.papyrus.diagram.activity.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.commands.helpers.ActivityPartitionActivity;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.activity.providers.ElementInitializers;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.SendObjectAction;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * @generated
 */
public class SendObjectActionCreateCommand extends CreateElementCommand {

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
	public SendObjectActionCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static SendObjectActionCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new SendObjectActionCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public SendObjectActionCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * Modified to return the nearest <Activity>.
	 * 
	 * @generated NOT
	 */
	@Override
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest) getRequest()).getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		// fjcano : we have to return the nearest activity
		if (container instanceof ActivityPartition) {
			return ActivityPartitionActivity.getActivityPartitionActivity((ActivityPartition) container);
		}

		return container;
	}

	/**
	 * @generated
	 */
	@Override
	protected EClass getEClassToEdit() {

		EObject eObject = getElementToEdit();
		if (eObject != null) {
			return eObject.eClass();
		}
		if (eClass != null) {
			return eClass;
		}
		return UMLPackage.eINSTANCE.getActivity();
	}

	/**
	 * @generated
	 */
	protected Diagram getDiagramFromRequest() {
		if (getRequest().getParameters().get(MultiDiagramUtil.BelongToDiagramSource) != null) {
			Object parameter = getRequest().getParameters().get(MultiDiagramUtil.BelongToDiagramSource);
			if (parameter instanceof Diagram) {
				return (Diagram) parameter;
			}
		}
		return null;
	}

	/**
	 * Modified to initialize the <SendObjectAction> with request and target pins.
	 * 
	 * @generated NOT
	 */
	@Override
	protected EObject doDefaultElementCreation() {
		SendObjectAction newElement = (SendObjectAction) super.doDefaultElementCreation();
		if (newElement != null) {
			ElementInitializers.init_SendObjectAction_2001(newElement);
			Diagram diagram = getDiagramFromRequest();
			if (diagram != null) {
				MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram, newElement);
			} else {
				MultiDiagramUtil.addEAnnotationReferenceToDiagram(UMLDiagramEditorPlugin.getInstance(), newElement);
			}
		}
		// fjcano : initializing the SendObjectAction with request and target
		// pins.
		Diagram diagram = getDiagramFromRequest();
		if (diagram != null) {
			MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram, newElement.createRequest("Request", null));
		} else {
			MultiDiagramUtil.addEAnnotationReferenceToDiagram(UMLDiagramEditorPlugin.getInstance(), newElement.createRequest("Request", null));
		}
		if (diagram != null) {
			MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram, newElement.createTarget("Target", null));
		} else {
			MultiDiagramUtil.addEAnnotationReferenceToDiagram(UMLDiagramEditorPlugin.getInstance(), newElement.createTarget("Target", null));
		}

		return newElement;
	}
}
