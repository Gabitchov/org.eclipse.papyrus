/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.providers;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.papyrus.uml.tools.utils.ProfileUtil;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;


public class AppliedProfileContentProvider extends AbstractStaticContentProvider implements ITreeContentProvider {

	protected Package rootPackage;

	public AppliedProfileContentProvider(Package rootPackage) {
		this.rootPackage = rootPackage;
	}

	public Object[] getElements() {
		return new Package[]{ rootPackage };
	}

	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof Profile) {
			return new Object[0];
		}

		if(parentElement instanceof Package) {
			Package parentPackage = (Package)parentElement;
			List<Package> children = new LinkedList<Package>();
			children.addAll(parentPackage.getNestedPackages());

			List<Profile> appliedProfiles = new LinkedList<Profile>(parentPackage.getAppliedProfiles());
			for(Profile profile : appliedProfiles) {
				if(ProfileUtil.isDirty(parentPackage, profile)) {
					children.add(profile);
				}
			}

			return children.toArray();
		}
		return new Object[0];
	}

	public Object getParent(Object element) {
		if(element instanceof Profile) {
			return null;
		}

		if(element instanceof Package) {
			return ((Package)element).getNestingPackage();
		}

		return null;
	}

	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}


}
