/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.junit.utils;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.utils.DiResourceSet;

/**
 * Helper class for manipulating Papyrus ModelSets
 * 
 * @author Camille Letavernier
 * 
 */
public class ModelUtils {

	/**
	 * Loads a ModelSet and associates a TransactionalEditingDomain to it
	 * 
	 * Use {@link #getEditingDomain(ModelSet)} to retrieve the EditingDomain
	 * 
	 * @param uri
	 * @param resolveAll
	 * @return
	 * @throws ModelMultiException
	 */
	public static ModelSet loadModelSet(URI uri, boolean resolveAll) throws ModelMultiException {
		ModelSet modelSet = new DiResourceSet();
		TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(modelSet);

		modelSet.loadModels(uri);

		if(resolveAll) {
			EcoreUtil.resolveAll(modelSet);
		}

		return modelSet;
	}

	public static ModelSet loadModelSet(IPath workspacePath, boolean resolveAll) throws ModelMultiException {
		URI workspaceURI = URI.createPlatformResourceURI(workspacePath.toString(), true);
		return loadModelSet(workspaceURI, resolveAll);
	}

	public static TransactionalEditingDomain getEditingDomain(ModelSet modelSet) {
		return TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(modelSet);
	}

}
