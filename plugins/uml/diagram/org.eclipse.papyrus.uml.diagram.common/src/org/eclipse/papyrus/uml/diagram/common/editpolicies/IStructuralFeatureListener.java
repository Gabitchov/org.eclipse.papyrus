/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Arthur Daussy (Atos) arthur.daussy@atos.net - Bug 249786: [General] drag'n'drop does not work for elements stored in nested classifier compartment
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationPreCommitListener;

import com.google.common.collect.ImmutableSet;
/**
 * This interface is used in order to listen some structural feature with a specific event.
 * @author arthur daussy
 *
 */
public interface IStructuralFeatureListener extends NotificationPreCommitListener {
	/**
	 * Set of all structural feature to listen
	 * @return
	 */
	ImmutableSet<EStructuralFeature> getEStructuralFeaturesToListen();
	/**
	 * Event type to listen
	 * @param type
	 * @return
	 */
	boolean handleNotificationType(int type);
	
	
}
