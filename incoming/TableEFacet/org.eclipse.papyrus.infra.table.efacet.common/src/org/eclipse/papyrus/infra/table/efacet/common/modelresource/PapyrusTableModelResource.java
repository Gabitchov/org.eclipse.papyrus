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

package org.eclipse.papyrus.infra.table.efacet.common.modelresource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Table;
import org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;



/**
 * A model used to save data from the {@link DefaultNattableEditor}
 * 
 * @author cedric dumoulin
 * 
 */
public class PapyrusTableModelResource extends AbstractModelWithSharedResource<Table> implements IModel {

	/*
	 * To save in a new file :
	 * the class should extends AbstractBaseModel and NOTATION_FILE_EXTENSION = "nattable" for example
	 */


	/**
	 * File extension used for notation.
	 */
	//	public static final String NOTATION_FILE_EXTENSION = "nattable"; //$NON-NLS-1$

	public static final String NOTATION_FILE_EXTENSION = "notation"; //$NON-NLS-1$

	/**
	 * Model ID.
	 */
	public static final String MODEL_ID = "org.eclipse.papyrus.infra.table.efacet.common.modelresource.PapyrusTableModelResource"; //$NON-NLS-1$


	/**
	 * 
	 * Constructor.
	 * 
	 */
	public PapyrusTableModelResource() {

	}

	// Initialize stuff in the model.
	@Override
	public void init(final ModelSet modelManager) {
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
	 * Add a new initialized {@link PapyrusTable} to the model.
	 * 
	 * @param papyrusTable
	 *        The tableInstance to add.
	 */
	public void addPapyrusTable(final PapyrusTable papyrusTable) {
		getResource().getContents().add(papyrusTable);
	}

	/**
	 * Add a new initialized {@link PapyrusTable} to the model.
	 * 
	 * @param papyrusTable
	 *        The tableInstance to add.
	 */
	public void removePapyrusTable(final PapyrusTable papyrusTable) {
		getResource().getContents().remove(papyrusTable);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource#isModelRoot(org.eclipse.emf.ecore.EObject)
	 * 
	 * @param object
	 * @return
	 */
	@Override
	protected boolean isModelRoot(final EObject object) {
		return false;
	}

}
