/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.AcceptEventActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.helper.AcceptEventActionSwitchHelper;
import org.eclipse.uml2.uml.AcceptEventAction;


/**
 * This editpart extends the generated controller in order to add specific behavior
 *
 */
public class CustomAcceptEventActionEditPart extends AcceptEventActionEditPart{

	public CustomAcceptEventActionEditPart(View view) {
		super(view);
	}
	
	/**
	 * Notifier for listening and stop listening model element.
	 * 
	 */
	private AcceptEventActionSwitchHelper notifier = new AcceptEventActionSwitchHelper(this);


	/**
	 * Deactivate listeners to handle notification in the message occurence
	 * specification
	 * 
	 */
	@Override
	public void deactivate() {
		notifier.unlistenAll();
		super.deactivate();
	}

	/**
	 * Remove listeners to handle notification in the message occurence specification
	 * 
	 */
	@Override
	public void removeNotify() {
		notifier.unlistenAll();
		super.removeNotify();
	}
	
	
	
	/**
	 * Activate a listener for to Handle notification for new owned YYY
	 * 
	 */
	public void activate() {
		super.activate();
		EObject action = resolveSemanticElement();
		if(action instanceof AcceptEventAction) {
			notifier.listenObject(action);
			// ensure representation is correctly initialized.
			boolean useHourglassFigure = org.eclipse.papyrus.uml.diagram.activity.helper.CustomAcceptEventActionEditHelper.isAcceptTimeEventAction((AcceptEventAction)action);
			getPrimaryShape().useTemplateForAcceptTimeEventAction(useHourglassFigure);
		}
	}
}