/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.common.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.core.utils.PapyrusTrace;

/**
 * Connection tool that adds stereotype application after creation actions.
 */
public class AspectUnspecifiedTypeConnectionTool extends UnspecifiedTypeConnectionTool {

	/** List of element types of which one will be created (of type <code>IElementType</code>). */
	protected List elementTypes;

	/** list of stereotypes to apply, identified by their qualified names */
	protected List<String> stereotypesToApply;

	/**
	 * Creates an AspectUnspecifiedTypeCreationTool
	 * 
	 * @param elementTypes
	 *            List of element types of which one will be created (of type
	 *            <code>IElementType</code>).
	 */
	public AspectUnspecifiedTypeConnectionTool(List elementTypes) {
		super(elementTypes);
		this.elementTypes = elementTypes;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean handleCreateConnection() {
		// When a connection is to be created, a dialog box may appear which
		// will cause this tool to be deactivated and the feedback to be
		// erased. This behavior is overridden by setting the avoid
		// deactivation flag.
		setAvoidDeactivation(true);

		// inits the listener
		View eObject = (View) getTargetEditPart().getAdapter(View.class);
		DiagramEventBroker eventBroker = null;
		NotificationListener listener = null;
		boolean requiresPostAction = requiresPostAction();

		// adds the listener
		if (requiresPostAction) {
			// register a listener to have information about element creation
			// retrieves editing domain
			TransactionalEditingDomain domain;
			try {
				domain = EditorUtils.getServiceRegistry().getService(TransactionalEditingDomain.class);
				eventBroker = DiagramEventBroker.getInstance(domain);

				if (eventBroker == null) {
					return false;
				}
				listener = new NotificationListener() {

					public void notifyChanged(Notification notification) {
						Connector newValue = (Connector) notification.getNewValue();
						EditPart editPart = (EditPart) getCurrentViewer().getEditPartRegistry().get(newValue);
						ApplyStereotypeRequest request = new ApplyStereotypeRequest(stereotypesToApply);
						request.getExtendedData().put(ApplyStereotypeRequest.NEW_EDIT_PART_NAME, "NEW");
						editPart.performRequest(request);
					}
				};

				eventBroker.addNotificationListener(eObject, listener);
			} catch (ServiceException e) {
				PapyrusTrace.log(e);
			}
		}

		EditPartViewer viewer = getCurrentViewer();
		Command endCommand = getCommand();
		setCurrentCommand(endCommand);

		executeCurrentCommand();

		if (requiresPostAction) {
			if (eventBroker != null) {
				eventBroker.removeNotificationListener(eObject, listener);
			}
		}

		selectAddedObject(viewer, DiagramCommandStack.getReturnValues(endCommand));

		setAvoidDeactivation(false);
		eraseSourceFeedback();
		deactivate();

		return true;
	}

	/**
	 * checks if this tool realizes post actions
	 * 
	 * @return <code>true</code> if post actions must be executed
	 */
	protected boolean requiresPostAction() {
		return stereotypesToApply != null && !stereotypesToApply.isEmpty();
	}

	/**
	 * Action realized after the stereotype application
	 * 
	 * @param viewer
	 *            the edit part viewer that manages the created edit parts
	 * @param returnValues
	 *            the collection of objects created by the creation action
	 */
	protected void postAction(EditPartViewer viewer, Collection returnValues) {
		// retrieves the list of created edit parts
		final List editparts = new ArrayList();
		for (Iterator i = returnValues.iterator(); i.hasNext();) {
			Object object = i.next();
			if (object instanceof IAdaptable) {
				Object editPart = viewer.getEditPartRegistry().get(((IAdaptable) object).getAdapter(View.class));
				if (editPart != null)
					editparts.add(editPart);
			}
		}

		// if edit part were created, apply the stereotypes on these edit parts
		if (!editparts.isEmpty()) {
			// apply the stereotype on the first edit part.
			ApplyStereotypeRequest request = new ApplyStereotypeRequest(stereotypesToApply);

			// adds metadata to the request to change the name of the element, according to the
			// first stereotype to apply
			// we are in post action, the list has been checked to be not null nor empty.
			// stereotypes.get(0) should never cause problem
			request.getExtendedData().put(ApplyStereotypeRequest.NEW_EDIT_PART_NAME, "NEW");

			((EditPart) editparts.get(0)).performRequest(request);

			// modify name if possible

		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void applyProperty(Object key, Object value) {
		if (IPapyrusPaletteConstant.STEREOTYPES_TO_APPLY_KEY.equals(key)) {
			if (value instanceof List<?>)
				stereotypesToApply = (List<String>) value;
			return;
		}
		super.applyProperty(key, value);
	}

	/**
	 * Returns the element types created by this tool
	 * 
	 * @return the element types created by this tool
	 */
	public List<IElementType> getElementTypes() {
		return elementTypes;
	}
}
