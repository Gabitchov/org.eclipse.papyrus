/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.infra.emf.compare.ui.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.ui.ModelCompareInput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.validation.internal.modeled.model.validation.Parameter;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;


/**
 * 
 * This class provides useful methods for the papyrus Viewer for EMF-Compare
 * 
 */
public class Utils {

	private Utils() {
		//nothing to do
	}

	//	//FIXME refactore this class in an upper plugin
	public static final IEditorPart getCurrentEditor() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if(workbench != null) {
			final IWorkbenchWindow activeWorkbench = workbench.getActiveWorkbenchWindow();
			if(activeWorkbench != null) {
				final IWorkbenchPage activePage = activeWorkbench.getActivePage();
				if(activePage != null) {
					return activePage.getActiveEditor();
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @param input
	 *        an input
	 * @param metamodels
	 *        the list of the referenced metamodels
	 * @return
	 *         if the parameter metamodels is <code>null</code>, this method initialied it
	 *         it returns the parameter metamodels filled with the metamodels referenced in the input
	 */
	public static final Collection<EPackage> getMetamodelForCustomization(final Object input, Collection<EPackage> metamodels) {

		if(metamodels == null) {
			metamodels = new HashSet<EPackage>();
		}
		if(input != null) {
			Assert.isTrue(input instanceof ModelCompareInput);
			Resource res = ((ModelCompareInput)input).getLeftResource();
			metamodels.addAll(Utils.getMetamodels(res));
			res = ((ModelCompareInput)input).getRightResource();
			metamodels.addAll(Utils.getMetamodels(res));

			List<DiffElement> diffs = ((ModelCompareInput)input).getDiffAsList();
			for(DiffElement current : diffs) {
				metamodels.add(current.eClass().getEPackage());
			}
		}
		return metamodels;
	}

	/**
	 * 
	 * @param resource
	 *        a resource
	 * 
	 * @return
	 *         the list of the metamodel knows by the resource
	 */
	//FIXME move this method in an upper package
	public static Set<EPackage> getMetamodels(final Resource resource) {
		Set<EPackage> metamodels = new HashSet<EPackage>();
		if(resource != null) {
			final List<EObject> contents = new ArrayList<EObject>(resource.getContents());
			for(final EObject current : contents) {
				metamodels.add(current.eClass().getEPackage());
			}
		}
		return metamodels;
	}
}
