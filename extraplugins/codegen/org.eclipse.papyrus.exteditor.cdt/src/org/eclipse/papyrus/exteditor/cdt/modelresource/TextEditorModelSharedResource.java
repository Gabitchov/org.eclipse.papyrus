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
package org.eclipse.papyrus.exteditor.cdt.modelresource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrusTextInstance;


public class TextEditorModelSharedResource extends AbstractModelWithSharedResource<PapyrusTextInstance> implements IModel {


	/**
	 * File extension used for notation.
	 */
	public static final String NOTATION_FILE_EXTENSION = "notation"; //$NON-NLS-1$

	/**
	 * Model ID.
	 */
	public static final String MODEL_ID = "org.eclipse.papyrus.example.text.TextEditorModelSharedResource"; //$NON-NLS-1$


	/**
	 * 
	 * Constructor.
	 * 
	 */
	public TextEditorModelSharedResource() {

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
	 * Add a new initialized {@link PapyrusTextInstance} to the model.
	 * 
	 * @param textInstance
	 *        The textInstance to add.
	 */
	public void addPapyrusTextInstance(PapyrusTextInstance textInstance) {
		getResource().getContents().add(textInstance);
	}

	/**
	 * Add a new initialized {@link PapyrustextInstance} to the model.
	 * 
	 * @param textInstance
	 *        The textInstance to add.
	 */
	public void removePapyrusTextInstance(PapyrusTextInstance textInstance) {
		getResource().getContents().remove(textInstance);
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
