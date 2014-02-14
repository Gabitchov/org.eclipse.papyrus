/*******************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Vincent Lorenzo (CEA-LIST) - Bug 351931 - Use local cell editor in table
 *  Gregoire Dupe (Mia-Software) - Bug 351931 - Use local cell editor in table
 */
 package org.eclipse.emf.facet.widgets.celleditors;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor;
import org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorDeclarations;

/**
 * @since 0.1.1
 * @author gdupe
 *
 */
public final class CellEditorsUtils {
	
	private static final String FILE_EXTENSION = "modelcelleditors"; //$NON-NLS-1$

	private CellEditorsUtils() {
		// This is an utility class which must not be instantiated
	}
	
	/**
	 * This method allows to find the bundle name for an editor
	 * 
	 * @param editor
	 *            an editor
	 * @return the bundle name for this editor
	 */
	public static String getBundleNameFor(final AbstractModelCellEditor editor, final ResourceSet resourceSet) {
		for (Resource ressource : resourceSet.getResources()) {
			if (CellEditorsUtils.FILE_EXTENSION.equals(ressource.getURI().fileExtension())) { 
				Iterator<EObject> allContents = ressource.getContents().iterator();
				while (allContents.hasNext()) {
					EObject currentContent = allContents.next();
					if (currentContent instanceof ModelCellEditorDeclarations) {
						if (((ModelCellEditorDeclarations) currentContent).getModelCellEditors()
								.contains(editor)) {
							URI uri = ressource.getURI();
							if (uri.isPlatformPlugin()) {
								List<String> list = uri.segmentsList();
								return list.get(1);
							}
						}
					}
				}
			}
		}

		return null;
	}
}
