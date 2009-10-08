/*******************************************************************************
 * Copyright (c) 2009 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial API 
 * implementation.
 *
 ******************************************************************************/
package org.eclipse.papyrus.navigator.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.papyrus.navigator.ModelNavigator;
import org.eclipse.ui.IPropertyListener;

/**
 * Action that removes the prefix that shows the type of the element.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
// fjcano #291192
public class RemoveTypePrefixAction extends Action implements IPropertyListener {

	/**
	 * The {@link MOSKittModelNavigator} this action is attached to.
	 */
	private final ModelNavigator navigator;

	/**
	 * Constructor with {@link MOSKittModelNavigator} parameter.
	 * 
	 * @param commonNavigator
	 */
	public RemoveTypePrefixAction(ModelNavigator commonNavigator) {
		super("Remove type prefix");
		this.navigator = commonNavigator;
		this.setToolTipText("Remove type name prefix");
		init();
	}

	/**
	 * Initializing means setting the initial state of the {@link Action} and
	 * adding the action as an {@link IPropertyListener} to the
	 * {@link MOSKittModelNavigator}.
	 */
	private void init() {
		updateRemovePrefixTypesProperty(navigator.isRemovePrefixTypeEnabled());
		navigator.addPropertyListener(this);
	}

	/**
	 * Sets the navigator property to remove the prefix of the types.
	 */
	@Override
	public void run() {
		navigator.setRemovePrefixTypeEnabled(!navigator
				.isRemovePrefixTypeEnabled());
	}

	/**
	 * Upon a MOSKittModelNavigator.IS_REMOVEPREFIXTYPE_ENABLED_PROPERTY
	 * property change, update the model explorer.
	 */
	public void propertyChanged(Object source, int propId) {
		switch (propId) {
		case ModelNavigator.IS_REMOVEPREFIXTYPE_ENABLED_PROPERTY:
			updateRemovePrefixTypesProperty(((ModelNavigator) source)
					.isRemovePrefixTypeEnabled());
		}
	}

	/**
	 * Update this model explorer.
	 * 
	 * @param removePrefixTypesEnabled
	 */
	private void updateRemovePrefixTypesProperty(
			boolean removePrefixTypesEnabled) {
		setChecked(removePrefixTypesEnabled);
	}
}
