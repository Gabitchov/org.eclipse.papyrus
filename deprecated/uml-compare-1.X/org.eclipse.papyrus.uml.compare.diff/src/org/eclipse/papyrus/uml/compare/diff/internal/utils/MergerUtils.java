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
package org.eclipse.papyrus.uml.compare.diff.internal.utils;

import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IMultiPageEditorPart;
import org.eclipse.papyrus.infra.tools.util.EditorHelper;
import org.eclipse.ui.IEditorPart;

/**
 * 
 * This class provides useful method for the mergers
 * 
 */
//TODO used?
public final class MergerUtils {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	private MergerUtils() {
		//nothing to do
	}

	/**
	 * 
	 * @return
	 *         <code>true</code> if we can use the Papyrus Mergers
	 */
	public static boolean usePapyrusMerger() {
		return getEditingDomain() != null;
	}

	/**
	 * 
	 * @return
	 *         the {@link TransactionalEditingDomain} to use for the merge action, or <code>null</code> if not found
	 */
	public static TransactionalEditingDomain getEditingDomain() {
		IEditorPart editor = EditorHelper.getCurrentEditor();
		if(editor instanceof IMultiPageEditorPart) {
			editor = ((IMultiPageEditorPart)editor).getActiveEditor();
		}
		if(editor instanceof IEditingDomainProvider) {
			return (TransactionalEditingDomain)((IEditingDomainProvider)editor).getEditingDomain();
		}
		return null;
	}
}
