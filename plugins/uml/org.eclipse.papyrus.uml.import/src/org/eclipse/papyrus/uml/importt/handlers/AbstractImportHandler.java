/*****************************************************************************
 * Copyright (c) 2012, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 323802
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.importt.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.UMLFactory;


public abstract class AbstractImportHandler extends AbstractCommandHandler {

	protected abstract class AbstractImportCommand extends AbstractTransactionalCommand {

		private final Runnable runnable;
		
		private final String description;
		
		protected AbstractImportCommand(Runnable runnable, String label, String description) {
			super(AbstractImportHandler.this.getEditingDomain(), label, computeAffectedFiles(getSelectedElements()));
			
			this.runnable = runnable;
			this.description = description;
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

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			runnable.run();
			return CommandResult.newOKCommandResult();
		}
		
		String getDescription() {
			return description;
		}
	}

	static List<IFile> computeAffectedFiles(Collection<?> selected) {
		Set<IFile> unique = new LinkedHashSet<IFile>();
		
		for (Object next : selected) {
			EObject object = (next instanceof EObject) ? (EObject)next : null;
			Resource resource = (object == null) ? null : object.eResource();
			if (resource != null) {
				IFile file = WorkspaceSynchronizer.getFile(resource);
				if (file != null) {
					unique.add(file);
				}
			}
		}
		
		return new ArrayList<IFile>(unique);
	}
	
	protected Command getCommand() {
		ICommand command = getGMFCommand();
		GMFtoEMFCommandWrapper result = new GMFtoEMFCommandWrapper(command);
		
		if (command instanceof AbstractImportCommand) {
			result.setDescription(((AbstractImportCommand)command).getDescription());
		}
		
		return result;
	}
	
	protected abstract ICommand getGMFCommand();
	
	/**
	 * Loads the Package resource into the current resource set
	 * 
	 * @param _package
	 */
	protected void handleLoadPackage(Package _package) {
		EMFHelper.reloadIntoContext(_package, getSelectedElement());
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
