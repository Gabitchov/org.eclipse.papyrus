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
package org.eclipse.papyrus.uml.importt.handlers;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler;
import org.eclipse.uml2.common.edit.command.ChangeCommand;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.UMLFactory;


public abstract class AbstractImportHandler extends AbstractCommandHandler {

	protected abstract class AbstractImportCommand extends ChangeCommand {

		protected AbstractImportCommand(Runnable runnable, String label, String description) {
			super(AbstractImportHandler.this.getEditingDomain(), runnable, label, description);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.common.command.AbstractCommand#canExecute()
		 * 
		 * @return
		 */
		@Override
		public boolean canExecute() {
			if(getSelectedElements().size() == 1) {
				return (getSelectedElement() instanceof Package);
			}
			return false;
		}

	}

	/**
	 * Creates a PackageImport in the current package, which refers to the
	 * selected package
	 * 
	 * @param _package
	 */
	protected void handleImportPackage(Package _package) {
		PackageImport ei = UMLFactory.eINSTANCE.createPackageImport();

		Package importedPackage = EMFHelper.reloadIntoContext(_package, getSelectedElement());

		((Package)getSelectedElement()).getPackageImports().add(ei);
		ei.setImportedPackage(importedPackage);
	}

	/**
	 * Creates a copy of the selected package in the current package
	 * 
	 * @param _package
	 */
	protected void handleCopyPackage(Package _package) {
		//FIXME: Stereotype applications are not copied
		((Package)getSelectedElement()).getNestedPackages().add(EcoreUtil.copy(_package));
	}

}
