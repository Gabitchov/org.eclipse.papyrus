/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *  Christian W. Damus (CEA) - Support creating models in repositories (CDO)
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards.category;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

/**
 * The Command to create a new Papyrus Model.
 */
public class NewPapyrusModelCommand extends RecordingCommand {

	/** The my model set. */
	private final ModelSet myModelSet;

	/** The URI of the model to create. */
	private final URI myURI;

	/**
	 * Instantiates a new new papyrus model command.
	 *
	 * @param modelSet the di resource set
	 * @param newURI the URI of the new model's principal resource
	 */
	public NewPapyrusModelCommand(ModelSet modelSet, URI newURI) {
		super(modelSet.getTransactionalEditingDomain());
		myModelSet = modelSet;
		myURI = newURI;
	}

	@Override
	protected void doExecute() {
		myModelSet.createModels(myURI);
	}

}