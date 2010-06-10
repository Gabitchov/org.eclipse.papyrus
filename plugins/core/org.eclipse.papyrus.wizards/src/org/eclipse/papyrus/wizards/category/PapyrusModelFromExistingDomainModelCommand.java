/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.wizards.category;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.resource.IModel;
import org.eclipse.papyrus.resource.notation.NotationModel;
import org.eclipse.papyrus.resource.sasheditor.DiModel;
import org.eclipse.papyrus.resource.uml.UmlModel;

/**
 * The Class PapyrusModelFromExistingDomainModelCommand.
 */
public class PapyrusModelFromExistingDomainModelCommand extends RecordingCommand {

	private final DiResourceSet myDiResourceSet;

	private final IPath myFileNameWithoutExtension;

	private final EObject myRoot;

	/**
	 * Instantiates a new papyrus model from existing domain model command.
	 *
	 * @param diResourceSet the di resource set
	 * @param newFile the new file
	 * @param root the root
	 */
	public PapyrusModelFromExistingDomainModelCommand(DiResourceSet diResourceSet, IFile newFile, EObject root) {
		super(diResourceSet.getTransactionalEditingDomain());
		myDiResourceSet = diResourceSet;
		myFileNameWithoutExtension = newFile.getFullPath().removeFileExtension();
		myRoot = root;
	}

	@Override
	protected void doExecute() {
		IModel model = myDiResourceSet.getModel(DiModel.MODEL_ID);
		model.createModel(myFileNameWithoutExtension);
		model = myDiResourceSet.getModel(NotationModel.MODEL_ID);
		model.createModel(myFileNameWithoutExtension);
		// START OF WORKAROUND for #315083 
		IModel umlModel = new UmlModel() {

			public void createModel(IPath fullPath) {
				try {
					resourceURI = myRoot.eResource().getURI();
					// as resource already exists, use rs.getResource() not rs.createResource() here
					resource = getResourceSet().getResource(resourceURI, true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		};
		myDiResourceSet.registerModel(umlModel);
		umlModel.createModel(null);

		//					// call snippets to allow them to do their stuff
		//					snippets.performStart(this);
		// END OF WORKAROUND for #315083 
	}

}