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
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.activitygroup.functions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.editpolicy.notifiers.IGroupNotifier;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * Transform an IGroupNotifier to an EObject they reference
 * 
 * @author adaussy
 * 
 */
public class FromIGroupNotifierToEObject implements Function<IGroupNotifier, EObject> {

	FromIGroupNotifierToEObject() {
	}

	/**
	 * @author adaussy
	 * 
	 */
	private static class SingletonHolder {

		public static final FromIGroupNotifierToEObject INSTANCE = new FromIGroupNotifierToEObject();
	}

	/**
	 * Get the singleton object
	 * 
	 * @return
	 */
	public static FromIGroupNotifierToEObject getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public static Iterable<EObject> transform(Iterable<IGroupNotifier> from) {
		return Iterables.transform(from, FromIGroupNotifierToEObject.getInstance());
	}

	public EObject apply(IGroupNotifier from) {
		return from.getEObject();
	}
}
