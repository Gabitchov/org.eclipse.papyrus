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
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.papyrus.resource.ModelSet;

/**
 * The Command to create a new Papyrus Model.
 */
public class NewPapyrusModelCommand extends RecordingCommand {

	/** The my model set. */
	private final ModelSet myModelSet;

	/** The my file. */
	private final IFile myFile;

	/**
	 * Instantiates a new new papyrus model command.
	 *
	 * @param modelSet the di resource set
	 * @param newFile the new file
	 */
	public NewPapyrusModelCommand(ModelSet modelSet, IFile newFile) {
		super(modelSet.getTransactionalEditingDomain());
		myModelSet = modelSet;
		myFile = newFile;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	@Override
	protected void doExecute() {
		myModelSet.createsModels(myFile);
	}

}