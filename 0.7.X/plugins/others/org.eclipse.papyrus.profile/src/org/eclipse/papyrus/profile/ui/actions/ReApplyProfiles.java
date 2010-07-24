/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.ui.actions;

import java.util.Iterator;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IViewPart;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

// TODO: Auto-generated Javadoc
/**
 * The Class ImportFromFile.
 */
public class ReApplyProfiles extends AbstractViewActionDelegate {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(IViewPart view) {
		// do nothing particular
	}

	/**
	 * Run.
	 * 
	 * @param action
	 *        the action
	 */
	@Override
	public void run(IAction action) {

		if(selectedElement == null) { // Cancel was selected
			return;
		}

		if(selectedElement instanceof Package) {
			Package pack = (Package)selectedElement;
			Iterator<Profile> profilesIt = pack.getAllAppliedProfiles().iterator();
			while(profilesIt.hasNext()) {
				Profile prof = profilesIt.next();
				EPackage ep = prof.getDefinition();
				pack.applyProfile(prof);
				ep = prof.getDefinition();
			}
		} else {
			IllegalArgumentException e = new IllegalArgumentException("Selected element should be a profile.");
			e.printStackTrace();
		}
	}
}
