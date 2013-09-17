/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.configmodel.layersconfig;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Folder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.Folder#getFolderElements <em>Folder Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getFolder()
 * @model
 * @generated
 */
public interface Folder extends FolderElement {
	/**
	 * Returns the value of the '<em><b>Folder Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.layers.configmodel.layersconfig.FolderElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Folder Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Folder Elements</em>' containment reference list.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getFolder_FolderElements()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<FolderElement> getFolderElements();

} // Folder
