/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.common.modelresource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance;


public class EMFCompareEditorModel extends AbstractModelWithSharedResource<PapyrusEMFCompareInstance> implements IModel {

	/*
	 * To save in a new file :
	 * the class should extends AbstractBaseModel and NOTATION_FILE_EXTENSION = "nattable" for example
	 */


	/**
	 * File extension used for notation.
	 */
	public static final String NOTATION_FILE_EXTENSION = "notation"; //$NON-NLS-1$

	/**
	 * Model ID.
	 */
	public static final String MODEL_ID = "org.eclipse.papyrus.emf.compare.resource.EMFCompareEditorModel"; //$NON-NLS-1$


	/**
	 * 
	 * Constructor.
	 * 
	 */
	public EMFCompareEditorModel() {

	}


	/**
	 * Get the file extension used for this model.
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#getModelFileExtension()
	 * 
	 * @return
	 */
	@Override
	protected String getModelFileExtension() {
		return NOTATION_FILE_EXTENSION;
	}

	/**
	 * Get the identifier used to register this model.
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#getIdentifier()
	 * 
	 * @return
	 */
	@Override
	public String getIdentifier() {
		return MODEL_ID;
	}


	/**
	 * Add a new initialized {@link PapyrusEMFCompareInstance} to the model.
	 * 
	 * @param compareInstance
	 *        The compareInstance to add.
	 */
	public void addEMFCompareEditorInstance(PapyrusEMFCompareInstance compareInstance) {
		getResource().getContents().add(compareInstance);
	}

	/**
	 * Add a new initialized {@link PapyrusEMFCompareInstance} to the model.
	 * 
	 * @param compareInstance
	 *        The compareInstance to add.
	 */
	public void removeEMFCompareEditorInstance(PapyrusEMFCompareInstance compareInstance) {
		getResource().getContents().remove(compareInstance);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource#isModelRoot(org.eclipse.emf.ecore.EObject)
	 * 
	 * @param object
	 * @return
	 */
	@Override
	protected boolean isModelRoot(EObject object) {
		return false;
	}

}
