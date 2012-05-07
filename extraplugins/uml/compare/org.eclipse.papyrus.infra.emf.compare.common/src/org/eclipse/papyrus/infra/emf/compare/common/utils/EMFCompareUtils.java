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
package org.eclipse.papyrus.infra.emf.compare.common.utils;

import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.emf.compare.common.messages.Messages;
import org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance;
import org.eclipse.papyrus.infra.emf.compare.ui.provider.EMFCompareLabelProvider;
import org.eclipse.papyrus.infra.emf.compare.ui.utils.ICustomizableEditor;
import org.eclipse.ui.IEditorPart;



public class EMFCompareUtils {

	private EMFCompareUtils() {
		//nothing to do
	}


	/**
	 * 
	 * @param editor
	 *        the editor
	 * @param rawModel
	 *        the raw model
	 * @return
	 *         the name for the editor
	 */
	public static String getCompareEditorTitle(final IEditorPart editor, final PapyrusEMFCompareInstance rawModel) {
		if(editor instanceof ICustomizableEditor) {
			EMFCompareLabelProvider labelProvider = (EMFCompareLabelProvider)((ICustomizableEditor)editor).getLabelProvider();
			String leftLabel = labelProvider.getText(rawModel.getLeft());
			String rightLabel = labelProvider.getText(rawModel.getRight());
			String title = NLS.bind(Messages.EMFCompareUtils_CompareTitle, leftLabel, rightLabel);
			return title;
		}
		return "";

	}

}
