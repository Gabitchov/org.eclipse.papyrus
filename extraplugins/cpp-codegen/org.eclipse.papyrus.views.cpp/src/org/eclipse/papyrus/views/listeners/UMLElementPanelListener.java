/*******************************************************************************
 * Copyright (c) 2006 - 2007 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.views.listeners;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.papyrus.views.panels.CppAbstractPanel;



/**
 * Listener for a uml element, for a given AccordCppAbstractPanel.
 */
public class UMLElementPanelListener implements Adapter {

	/** element listened */
	private Notifier target;

	/** panel that listens to this element */
	protected CppAbstractPanel panel;

	/**
	 * Creates a new UMLElementListener for the given panel.
	 * @param panel the panel that describes this element 
	 */
	public UMLElementPanelListener(CppAbstractPanel panel){	
		this.panel=panel;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void notifyChanged(Notification notification) {
		if( notification.getEventType()!=Notification.REMOVING_ADAPTER ){
			panel.reset();	// equivalent to a refresh
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#getTarget()
	 */
	public Notifier getTarget() {
		return this.target;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#setTarget(org.eclipse.emf.common.notify.Notifier)
	 */
	public void setTarget(Notifier newTarget) {
		this.target = newTarget;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 */
	public boolean isAdapterForType(Object type) {
		Class<? extends Notifier> class_ = target.getClass();
		// if class is not null
		if(class_!=null) {
			return class_.equals(type);
		}
		//default case: it is not an adapter
		return false;
	}
}