/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.navigation.provider.impl;

import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.services.navigation.provider.NavigationTargetProvider;
import org.eclipse.papyrus.infra.widgets.util.IRevealSemanticElement;
import org.eclipse.papyrus.infra.widgets.util.NavigationTarget;
import org.eclipse.papyrus.infra.widgets.util.RevealSemanticElementWrapper;
import org.eclipse.ui.IEditorPart;

/**
 * A NavigationTargetProvider to navigate in the current nested active editor
 * 
 * @author Camille Letavernier
 * 
 */
public class ActiveEditorNavigationTargetProvider implements NavigationTargetProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * Returns the current active nestedEditor
	 */
	public NavigationTarget getNavigationTarget(ServicesRegistry registry) {
		IMultiDiagramEditor editor;
		try {
			editor = registry.getService(IMultiDiagramEditor.class);
			if(editor == null) {
				return null;
			}
		} catch (ServiceException ex) {
			//We're not in the context of the multi diagram editor. We have nothing to contribute.
			//Ignore the exception and do not do anything.
			return null;
		}

		IEditorPart activeEditor = editor.getActiveEditor();
		if(activeEditor instanceof NavigationTarget) {
			return (NavigationTarget)activeEditor;
		} else if(activeEditor instanceof IRevealSemanticElement) {
			return new RevealSemanticElementWrapper((IRevealSemanticElement)activeEditor);
		}

		return null;
	}

}
