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
package org.eclipse.papyrus.infra.emf.compare.ui.viewer;

import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.emf.compare.ui.viewer.content.part.diff.ModelContentMergeDiffTab;
import org.eclipse.swt.widgets.Composite;


/**
 * The Structure Tab in the Merge Viewer.
 */
//duplicate code from tatiana
//TODO : verify the super class

//TODO : useful?
public class TransactionalModelContentMergeDiffTab extends ModelContentMergeDiffTab {

	/**
	 * Instantiates a new uML model content merge diff tab.
	 * 
	 * @param parentComposite
	 *        the parent composite
	 * @param side
	 *        the side
	 * @param parentFolder
	 *        the parent folder
	 */
	public TransactionalModelContentMergeDiffTab(Composite parentComposite, int side, ModelContentMergeTabFolder parentFolder) {
		super(parentComposite, side, parentFolder);
	}
}
