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
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.GraphicalEditPolicyEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.infra.emf.appearance.commands.AddMaskManagedLabelDisplayCommand;
import org.eclipse.papyrus.infra.emf.appearance.helper.AppearanceHelper;
import org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants;
import org.eclipse.papyrus.infra.emf.commands.RemoveEAnnotationCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.uml2.uml.Element;

/**
 * Default Abstract implementation of the {@link IMaskManagedLabelEditPolicy}.
 */
@SuppressWarnings("restriction")
public abstract class AbstractMaskManagedEditPolicy extends GraphicalEditPolicyEx implements NotificationListener, IPapyrusListener, IMaskManagedLabelEditPolicy {

	/**
	 * Stores the semantic element related to the edit policy. If
	 * resolveSemanticElement is used, there are problems when the edit part is
	 * getting destroyed, i.e. the link to the semantic element is removed, but
	 * the listeners should still be removed
	 */
	protected Element hostSemanticElement;

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if(view == null) {
			return;
		}
		hostSemanticElement = initSemanticElement();
		if(hostSemanticElement != null) {

			// adds a listener on the view and the element controlled by the
			// editpart
			getDiagramEventBroker().addNotificationListener(view, this);
			getDiagramEventBroker().addNotificationListener(hostSemanticElement, this);

			addAdditionalListeners();

			refreshDisplay();
		} else {
			Activator.log.error("No semantic element was found during activation of the mask managed label edit policy", null);
		}
	}

	/**
	 * Sets the semantic element which is linked to the edit policy
	 * 
	 * @return the element linked to the edit policy
	 */
	protected Element initSemanticElement() {
		return (Element)getView().getElement();
	}

	/**
	 * Adds more listeners upon activation
	 */
	protected void addAdditionalListeners() {
		// default implementation does nothing
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void refresh() {
		super.refresh();
		refreshDisplay();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void deactivate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if(view == null) {
			return;
		}
		// remove notification on element and view
		getDiagramEventBroker().removeNotificationListener(view, this);

		if(hostSemanticElement != null) {
			getDiagramEventBroker().removeNotificationListener(hostSemanticElement, this);
			removeAdditionalListeners();
		}

		// removes the reference to the semantic element
		hostSemanticElement = null;
	}

	/**
	 * Remove additional listeners that were added during activation of the edit
	 * policy
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
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		if(theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}

	/**
	 * Returns the {@link Element} managed by this edit part.
	 * 
	 * @return the {@link Element} managed by this edit part.
	 */
	public Element getUMLElement() {
		return hostSemanticElement;
	}

	/**
	 * Returns the view controlled by the host edit part
	 * 
	 * @return the view controlled by the host edit part
	 */
	protected View getView() {
		return (View)getHost().getModel();
	}

	/**
	 * Returns <code>true</code> if the specified object is the annotation in
	 * charge of the mask managed label.
	 * 
	 * @param object
	 *        the object to be checked
	 * @return <code>true</code> if the object is an {@link EAnnotation} and its
	 *         source is the correct one.
	 */
	protected boolean isMaskManagedAnnotation(Object object) {
		// check the notifier is an annotation
		if((object instanceof EAnnotation)) {

			// notifier is the eannotation. Check this is the annotation in
			// charge of the property
			// label display
			if(VisualInformationPapyrusConstants.CUSTOM_APPEARENCE_ANNOTATION.equals(((EAnnotation)object).getSource())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns <code>true</code> if the the annotation in charge of the mask
	 * managed label is removed from the given object which should be a View.
	 * 
	 * @param object
	 *        the object to be checked
	 * @param notification
	 *        the notification passed to the policy (which is a listener)
	 * @return <code>true</code> if the object is an {@link EAnnotation} and its
	 *         source is the correct one.
	 */
	protected boolean isRemovedMaskManagedLabelAnnotation(Object object, Notification notification) {
		// object is a model element, that means it has EAnnotations
		if(object instanceof EModelElement) {

			// something was removed.
			if(notification.getEventType() == Notification.REMOVE) {
				Object oldValue = notification.getOldValue();

				// this is an annotation which is returned
				if(oldValue instanceof EAnnotation) {
					// returns true if the annotation has the correct source
					return VisualInformationPapyrusConstants.CUSTOM_APPEARENCE_ANNOTATION.equals(((EAnnotation)oldValue).getSource());
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
	 * @see org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 * 
	 * @param notification
	 *        the notification object
	 */
	public void notifyChanged(Notification notification) {
		Object object = notification.getNotifier();
		if(object != null && object.equals(getView())) {
			refreshDisplay();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void setDefaultDisplayValue() {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		if(editingDomain != null) {
			editingDomain.getCommandStack().execute(new RemoveEAnnotationCommand(editingDomain, (EModelElement)getHost().getModel(), VisualInformationPapyrusConstants.CUSTOM_APPEARENCE_ANNOTATION));
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void updateDisplayValue(int newValue) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		if(editingDomain != null) {
			editingDomain.getCommandStack().execute(new AddMaskManagedLabelDisplayCommand(editingDomain, (EModelElement)getHost().getModel(), newValue));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public int getCurrentDisplayValue() {
		if(getHost().getModel() instanceof View) {
			View view = (View)getHost().getModel();
			//Delegate to AppearanceHelper (May delegate to either e.g. Notation EAnnotations or CSS)
			return AppearanceHelper.getLabelDisplay(view);
		}
		return getDefaultDisplayValue();
	}

}
