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
import org.eclipse.papyrus.controlmode.commands.IUncontrolCommand;
import org.eclipse.uml2.common.edit.command.ChangeCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;


/**
 * The Class UMLProfileUncontrolCommand is custom command to manage UML profiles and stereotypes when uncontrol action is performed
 */
public class UMLProfileUncontrolCommand implements IUncontrolCommand {

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(EObject selection, STATE_CONTROL state, Resource source, Resource target) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public void uncontrol(EditingDomain domain, final EObject selection, STATE_CONTROL state, Resource source, final Resource target, CompoundCommand commandToModify) {
		switch(state) {
		case PRE_MODEL:
			commandToModify.append(new ChangeCommand(domain, new Runnable() {

				public void run() {
					unapplyDuplicateProfiles(selection, target);
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
	 * Unapply profiles duplicated for control action
	 * @param selection
	 * @param the resource target 
	 */
	private void unapplyDuplicateProfiles(final EObject selection, Resource target) {
		Package _package = (Package)selection;
		EList<Profile> allAppliedProfiles = _package.getAllAppliedProfiles();
		if (!allAppliedProfiles.isEmpty()) {
			for(Profile profile : _package.getAppliedProfiles()) {
				if (allAppliedProfiles.contains(profile)) {
					// profile is duplicate, unapply it
					_package.unapplyProfile(profile);
				}
			}
			
		}
	}

	/**
	 * Relocate stereotype applications for the nested elements of the selection in the parent resource
	 * 
	 * @param selection
	 * @param target
	 *        the parent resource
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
