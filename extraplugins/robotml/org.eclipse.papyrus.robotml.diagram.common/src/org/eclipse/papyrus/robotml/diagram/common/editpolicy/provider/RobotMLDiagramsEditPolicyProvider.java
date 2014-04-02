/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.diagram.common.editpolicy.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.robotml.diagram.common.editpolicies.PortNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CompositeStructureDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.PortEditPart;
import org.eclipse.uml2.uml.Element;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class RobotMLDiagramsEditPolicyProvider extends AbstractProvider
		implements IEditPolicyProvider {

	public static String ROBOTML_ID = "RobotML";

	public boolean provides(IOperation operation) {
		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation) operation;
		if (!(epOperation.getEditPart() instanceof GraphicalEditPart)) {
			return false;
		}
		GraphicalEditPart gep = (GraphicalEditPart) epOperation.getEditPart();
		String diagramType = gep.getNotationView().getDiagram().getType();
		if (!CompositeStructureDiagramEditPart.MODEL_ID.equals(diagramType)) {
			return false;
		}

		if (gep instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.PortEditPart) {
			return true;
		}

		return false;
	}

	public void createEditPolicies(EditPart editPart) {

		if (editPart.getModel() instanceof View) {
			EObject element = ((View) editPart.getModel()).getElement();
			if (element instanceof Element) {
				if (((Element) element).getNearestPackage().getAppliedProfile(
						ROBOTML_ID) != null)

					// System.err.println(list.get(i).getProfile().getName());
					if (editPart instanceof PortEditPart) {
						NotificationListener editPolicy = new PortNodeLabelDisplayEditPolicy();
						editPart.installEditPolicy(
								AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY,
								(EditPolicy) editPolicy);
						Object model = editPart.getModel();
						LayoutConstraint notifier = ((Shape) model)
								.getLayoutConstraint();
						if (model instanceof Shape) {
							// to force refreshing the port icon when the
							// diagram is opening
							Notification notification = new ENotificationImpl(
									(InternalEObject) notifier,
									Notification.SET,
									NotationPackage.eINSTANCE.getLocation_X(),
									0, 0);
							editPolicy.notifyChanged(notification);
						}
					}
			}
		}
	}

}
