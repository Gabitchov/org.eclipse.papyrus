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
package org.eclipse.papyrus.diagram.common.editpolicies;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.papyrus.umlutils.ui.command.AddMaskManagedLabelDisplayCommand;
import org.eclipse.papyrus.umlutils.ui.command.RemoveEAnnotationCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;

/**
 * Default Abstract implementation of the {@link IMaskManagedLabelEditPolicy}.
 */
public abstract class AbstractMaskManagedEditPolicy extends GraphicalEditPolicy implements NotificationListener,
		IPapyrusListener, IMaskManagedLabelEditPolicy {

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if (view == null) {
			return;
		}
		Element element = getUMLElement();

		// adds a listener on the view and the element controlled by the editpart
		getDiagramEventBroker().addNotificationListener(view, this);
		getDiagramEventBroker().addNotificationListener(element, this);

		addAdditionalListeners();

		refreshDisplay();
	}

	/**
	 * Adds more listeners upon activation
	 */
	protected void addAdditionalListeners() {
		// default implementation does nothing
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void deactivate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if (view == null) {
			return;
		}
		Property property = (Property) getUMLElement();

		// remove notification on element and view
		getDiagramEventBroker().removeNotificationListener(view, this);

		if (property == null) {
			return;
		}
		getDiagramEventBroker().removeNotificationListener(property, this);

		removeAdditionalListeners();

	}

	/**
	 * 
	 */
	protected void removeAdditionalListeners() {
		// default implementation does nothing
	}

	/**
	 * Gets the diagram event broker from the editing domain.
	 * 
	 * @return the diagram event broker
	 */
	protected DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		if (theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}

	/**
	 * Returns the {@link Element} managed by this edit part.
	 * 
	 * @return
	 */
	public Element getUMLElement() {
		return (Element) getView().getElement();
	}

	/**
	 * Returns the view controlled by the host edit part
	 * 
	 * @return the view controlled by the host edit part
	 */
	protected View getView() {
		return (View) getHost().getModel();
	}

	/**
	 * Returns <code>true</code> if the specified object is the annotation in charge of the mask
	 * managed label.
	 * 
	 * @param object
	 *            the object to be checked
	 * @return <code>true</code> if the object is an {@link EAnnotation} and its source is the
	 *         correct one.
	 */
	protected boolean isMaskManagedAnnotation(Object object) {
		// check the notifier is an annotation
		if ((object instanceof EAnnotation)) {

			// notifier is the eannotation. Check this is the annotation in charge of the property
			// label display
			if (VisualInformationPapyrusConstant.CUSTOM_APPEARENCE_ANNOTATION
					.equals(((EAnnotation) object).getSource())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns <code>true</code> if the the annotation in charge of the mask managed label is
	 * removed from the given object which should be a View.
	 * 
	 * @param object
	 *            the object to be checked
	 * @param notification
	 *            the notification passed to the policy (which is a listener)
	 * @return <code>true</code> if the object is an {@link EAnnotation} and its source is the
	 *         correct one.
	 */
	protected boolean isRemovedMaskManagedLabelAnnotation(Object object, Notification notification) {
		// object is a model element, that means it has EAnnotations
		if (object instanceof EModelElement) {

			// something was removed.
			if (notification.getEventType() == Notification.REMOVE) {
				Object oldValue = notification.getOldValue();

				// this is an annotation which is returned
				if (oldValue instanceof EAnnotation) {
					// returns true if the annotation has the correct source
					return VisualInformationPapyrusConstant.CUSTOM_APPEARENCE_ANNOTATION
							.equals(((EAnnotation) oldValue).getSource());
				}
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	abstract public void refreshDisplay();

	/**
	 * {@inheritDoc}
	 */
	public void setDefaultDisplayValue() {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		if (editingDomain != null) {
			editingDomain.getCommandStack().execute(
					new RemoveEAnnotationCommand(editingDomain, (EModelElement) getHost().getModel(),
							VisualInformationPapyrusConstant.CUSTOM_APPEARENCE_ANNOTATION));
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void updateDisplayValue(int newValue) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		if (editingDomain != null) {
			editingDomain.getCommandStack()
					.execute(
							new AddMaskManagedLabelDisplayCommand(editingDomain, (EModelElement) getHost().getModel(),
									newValue));
		}
	}

}
