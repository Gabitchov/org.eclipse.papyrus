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
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.policy;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;


/**
 * Represents a view prototype that is not available in the current viewpoints configuration
 * 
 * @author Laurent Wouters
 */
public class UnavailableViewPrototype extends ViewPrototype {

	private String name;

	private String icon;

	/**
	 * Constructor.
	 */
	protected UnavailableViewPrototype(String name, String icon) {
		super(null);
		this.name = name;
		this.icon = icon;
	}

	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype#isNatural()
	 */
	@Override
	public boolean isNatural() {
		return true;
	}

	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype#getImplementation()
	 */
	@Override
	public String getImplementation() {
		return "PapyrusUnavailableView";
	}

	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype#getLabel()
	 */
	@Override
	public String getLabel() {
		return "Unavailable " + name;
	}

	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype#getQualifiedName()
	 */
	@Override
	public String getQualifiedName() {
		return "Default Papyrus Viewpoint :: " + getLabel();
	}

	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype#getIconURI()
	 */
	@Override
	public String getIconURI() {
		return "platform:/plugin/org.eclipse.papyrus.infra.viewpoints.policy/icons/Unavailable" + icon + ".gif";
	}

	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype#isOwnerReassignable()
	 */
	@Override
	public boolean isOwnerReassignable() {
		return false;
	}

	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype#instantiateOn(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean instantiateOn(EObject owner) {
		return false;
	}

	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype#instantiateOn(org.eclipse.emf.ecore.EObject, java.lang.String)
	 */
	@Override
	public boolean instantiateOn(EObject owner, String name) {
		return false;
	}

	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype#getCommandChangeOwner(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public Command getCommandChangeOwner(EObject view, EObject target) {
		return null;
	}

	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype#getCommandChangeRoot(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public Command getCommandChangeRoot(EObject view, EObject target) {
		return null;
	}

	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype#getOwnerOf(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public EObject getOwnerOf(EObject view) {
		return null;
	}

	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype#getRootOf(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public EObject getRootOf(EObject view) {
		return null;
	}
}
