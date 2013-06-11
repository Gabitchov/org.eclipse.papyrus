/*****************************************************************************
 * Copyright (c) 2011 LIFL & CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.common.modelresource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;



/**
 * A model used to save data from the {@link DefaultNattableEditor}
 * 
 * @author cedric dumoulin
 * 
 */
public class PapyrusNattableModel extends AbstractModelWithSharedResource<Table> implements IModel {

	/**
	 * Model ID.
	 */
	public static final String MODEL_ID = "org.eclipse.papyrus.infra.nattable.resource.NattableModel"; //$NON-NLS-1$

	/**
	 * the file extension where table are stored
	 */
	public static final String TABLE_MODEL_FILE_EXTENSION = NotationModel.NOTATION_FILE_EXTENSION;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public PapyrusNattableModel() {

	}

	// Initialize stuff in the model.
	@Override
	public void init(ModelSet modelManager) {
		super.init(modelManager);
		// nothing to do now
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
		return TABLE_MODEL_FILE_EXTENSION;
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
	 * Add a new initialized {@link PapyrusTableInstance} to the model.
	 * 
	 * @param tableInstance
	 *        The tableInstance to add.
	 */
	public void addPapyrusTable(Table tableInstance) {
		getResource().getContents().add(tableInstance);
	}

	/**
	 * Add a new initialized {@link PapyrusTableInstance} to the model.
	 * 
	 * @param tableInstance
	 *        The tableInstance to add.
	 */
	public void removeTable(Table tableInstance) {
		getResource().getContents().remove(tableInstance);
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
