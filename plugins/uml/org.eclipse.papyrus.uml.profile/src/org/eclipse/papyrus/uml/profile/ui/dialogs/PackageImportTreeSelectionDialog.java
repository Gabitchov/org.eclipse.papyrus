/*****************************************************************************
 * Copyright (c) 2008, 2013 CEA LIST.
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
 *  Christian W. Damus (CEA) - Refactoring package/profile import/apply UI for CDO
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.ui.dialogs;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;

/**
 *
 */
public class PackageImportTreeSelectionDialog extends ElementImportTreeSelectionDialog<Package> {


	/**
	 *
	 *
	 * @param model
	 * @param parent
	 */
	public PackageImportTreeSelectionDialog(Shell parent, Package model) {
		super(parent, EnumSet.of(ImportAction.IMPORT, ImportAction.COPY, ImportAction.LOAD), Package.class, model);
	}

	public PackageImportTreeSelectionDialog(Shell parent, Collection<? extends Package> models) {
		super(parent, EnumSet.of(ImportAction.IMPORT, ImportAction.COPY, ImportAction.LOAD), Package.class, models);
	}

	@Override
	protected Collection<? extends Element> getChildren(Package package_) {
		Collection<Package> result = new java.util.ArrayList<Package>();

		Iterator<PackageableElement> elemIter = package_.getPackagedElements().iterator();
		while(elemIter.hasNext()) {
			Element elem = elemIter.next();
			if(elem instanceof Package) {
				result.add((Package)elem);
			}
		}

		return result;
	}
}
