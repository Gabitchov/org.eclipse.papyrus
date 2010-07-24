/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - Initial implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.navigator.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.papyrus.navigator.ModelNavigator;
import org.eclipse.ui.IPropertyListener;

/**
 * Action that toggles the grouping of children by type in the Model Explorer.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @see <a href=https://bugs.eclipse.org/bugs/show_bug.cgi?id=290422>Bug #290422</a>
 */
public class GroupChildrenAction extends Action implements IPropertyListener {

	private final ModelNavigator navigator;

	public GroupChildrenAction(ModelNavigator commonNavigator) {
		super("Group Childs");
		this.navigator = commonNavigator;
		this.setToolTipText("Group Childs");
		init();
	}

	private void init() {

		updateGroupingChildsProperty(navigator.isGroupingChildsEnabled());
		navigator.addPropertyListener(this);
	}

	@Override
	public void run() {
		navigator.setGroupChildsEnabled(!navigator.isGroupingChildsEnabled());
	}

	public void propertyChanged(Object source, int propId) {
		switch(propId) {
		case ModelNavigator.IS_GROUPINGCHILDS_ENABLED_PROPERTY:
			updateGroupingChildsProperty(((ModelNavigator)source).isGroupingChildsEnabled());
		}

	}

	private void updateGroupingChildsProperty(boolean groupingChildsEnabled) {
		setChecked(groupingChildsEnabled);

	}

}
