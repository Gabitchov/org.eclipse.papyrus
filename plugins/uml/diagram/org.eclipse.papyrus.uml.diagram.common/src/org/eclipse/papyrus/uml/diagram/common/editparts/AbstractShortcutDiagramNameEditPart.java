/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier(CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editparts;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.PapyrusLabelEditPart;
import org.eclipse.papyrus.uml.diagram.common.Activator;

/**
 * this edit part has in charge to display the name of a diagram for a short cut
 * 
 */
public abstract class AbstractShortcutDiagramNameEditPart extends PapyrusLabelEditPart implements Adapter {

	public AbstractShortcutDiagramNameEditPart(View view) {
		super(view);
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#activate()
	 * 
	 */
	@Override
	public void activate() {
		// TODO Auto-generated method stub
		super.activate();
		EObject eObject = resolveSemanticElement();
		resourceToListen = eObject.eResource();
		resourceToListen.eAdapters().add(this);

	}

	/**
	 * the resouce that contains the diagram
	 */
	protected Resource resourceToListen;

	/**
	 * notifier
	 */
	private Notifier target;

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 * 
	 * @param notification
	 */
	@Override
	public void notifyChanged(Notification notification) {
		// TODO Auto-generated method stub
		super.notifyChanged(notification);
		refreshVisuals();
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#deactivate()
	 * 
	 */
	@Override
	public void deactivate() {
		// TODO Auto-generated method stub
		super.deactivate();
		resourceToListen.eAdapters().remove(this);
	}

	/**
	 * 
	 * @see org.eclipse.emf.common.notify.Adapter#setTarget(org.eclipse.emf.common.notify.Notifier)
	 * 
	 */
	public void setTarget(Notifier target) {
		this.target = target;
	}

	/**
	 * 
	 * @see org.eclipse.emf.common.notify.Adapter#getTarget()
	 * 
	 */
	public Notifier getTarget() {
		return target;
	}

	/**
	 * 
	 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 * 
	 */
	public boolean isAdapterForType(Object type) {
		Activator.log.debug(type.toString());
		return (getModel().getClass() == type);
	}

}
