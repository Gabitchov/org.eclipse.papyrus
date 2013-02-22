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

package org.eclipse.papyrus.infra.table.common.modelresource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource;
import org.eclipse.papyrus.infra.core.resource.IModel;



/**
 * A model used to save data from the {@link DefaultNattableEditor}
 * 
 * @author cedric dumoulin
 * 
 */
public class EMFFacetNattableModel extends /* AbstractBaseModel */AbstractModelWithSharedResource<TableInstance> implements IModel {

	/*
	 * To save in a new file :
	 * the class should extends AbstractBaseModel and NOTATION_FILE_EXTENSION = "nattable" for example
	 */


	/**
	 * File extension used for notation.
	 */
	//	public static final String NOTATION_FILE_EXTENSION = "nattable"; //$NON-NLS-1$

	public static final String NOTATION_FILE_EXTENSION = "di"; //$NON-NLS-1$

	/**
	 * Model ID.
	 */
	public static final String MODEL_ID = "org.eclipse.papyrus.emf.facet.nattable.resource.NattableModel"; //$NON-NLS-1$


	/**
	 * 
	 * Constructor.
	 * 
	 */
	public EMFFacetNattableModel() {

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
	 * Add a new initialized {@link Diagram} to the model.
	 * 
	 * @param newDiagram
	 *        The diagram to add.
	 */
	public void addTableInstance(TableInstance tableInstance) {
		getResource().getContents().add(tableInstance);
	}

	/**
	 * Add a new initialized {@link Diagram} to the model.
	 * 
	 * @param newDiagram
	 *        The diagram to add.
	 */
	public void removeTableInstance(TableInstance tableInstance) {
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
