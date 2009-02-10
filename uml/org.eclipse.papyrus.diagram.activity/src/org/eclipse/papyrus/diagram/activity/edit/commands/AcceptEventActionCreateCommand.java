/*
 * Copyright (c) 2007 Borland Software Corporation and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * @generated
 */
public class AcceptEventActionCreateCommand extends CreateElementCommand {

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
	public AcceptEventActionCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static AcceptEventActionCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new AcceptEventActionCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public AcceptEventActionCreateCommand(CreateElementRequest req) {
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
		// fjcano : we have to return the nearest Activity.
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
	 * Modified to initialize the <AcceptEventAction> with a <Trigger>.
	 * 
	 * @generated NOT
	 */
	@Override
	protected EObject doDefaultElementCreation() {
		AcceptEventAction newElement = (AcceptEventAction) super.doDefaultElementCreation();
		if (newElement != null) {
			ElementInitializers.init_AcceptEventAction_2007(newElement);
			Diagram diagram = getDiagramFromRequest();
			if (diagram != null) {
				MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram, newElement);
			} else {
				MultiDiagramUtil.addEAnnotationReferenceToDiagram(UMLDiagramEditorPlugin.getInstance(), newElement);
			}
		}
		// fjcano : initializing the AcceptEventAction with a Trigger.
		Trigger trigger = newElement.createTrigger("Trigger");
		Event event = (Event) UMLFactory.eINSTANCE.create(UMLPackage.eINSTANCE.getAnyReceiveEvent());
		event.setName("Event");
		trigger.setEvent(event);
		((Activity) getElementToEdit()).getNearestPackage().getPackagedElements().add(event);

		return newElement;
	}
}
