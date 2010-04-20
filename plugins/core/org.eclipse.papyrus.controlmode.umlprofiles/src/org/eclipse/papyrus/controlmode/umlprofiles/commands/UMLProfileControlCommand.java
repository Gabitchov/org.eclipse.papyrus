/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.controlmode.umlprofiles.commands;

import java.util.Iterator;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.controlmode.commands.IControlCommand;
import org.eclipse.uml2.common.edit.command.ChangeCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 * The Class UMLProfileControlCommand is custom command to manage UML profiles and stereotypes when control action is performed
 */
public class UMLProfileControlCommand implements IControlCommand {

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(EObject selection, STATE_CONTROL state, Resource source, Resource target) {
		return selection instanceof Package;
	}

	/**
	 * {@inheritDoc}
	 */
	public void control(EditingDomain domain, final EObject selection, STATE_CONTROL state, Resource source, final Resource target, CompoundCommand commandToModify) {
		switch(state) {
		case PRE_MODEL:
			commandToModify.append(new ChangeCommand(domain, new Runnable() {

				public void run() {
					duplicateAppliedProfiles(selection);
				}
			}));
			break;
		case POST_MODEL:
			commandToModify.append(new ChangeCommand(domain, new Runnable() {

				public void run() {
					relocateStereotypeApplications(selection, target);
				}
			}));
			break;
		default:
		}
	}

	/**
	 * Duplicate all applied profiles from the package on the root element of the controlled resource
	 * 
	 * @param selection
	 */
	private void duplicateAppliedProfiles(final EObject selection) {
		Package _package = (Package)selection;
		for(Profile profile : _package.getAllAppliedProfiles()) {
			if(!_package.isProfileApplied(profile)) {
				_package.applyProfile(profile);
			}
		}
	}

	/**
	 * Relocate stereotype applications for the nested elements of the selection in the controlled resource
	 * 
	 * @param selection
	 * @param target
	 *        the target controlled resource
	 */
	private void relocateStereotypeApplications(final EObject selection, final Resource target) {
		Package pack = (Package)selection;
		for(Iterator<EObject> i = EcoreUtil.getAllProperContents(pack, false); i.hasNext();) {
			EObject current = i.next();
			if(current instanceof Element) {
				Element element = (Element)current;
				EList<EObject> stereotypeApplications = element.getStereotypeApplications();
				if(!stereotypeApplications.isEmpty()) {
					for(EObject e : stereotypeApplications) {
						int size = target.getContents().size();
						target.getContents().add(size, e);
					}
				}
			}
		}
	}

}
