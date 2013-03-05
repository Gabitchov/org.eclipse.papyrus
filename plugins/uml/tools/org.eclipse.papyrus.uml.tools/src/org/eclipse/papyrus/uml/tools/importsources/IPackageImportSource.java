/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.importsources;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.uml2.uml.Package;

/**
 * This is the IPackageImportSource type. Enjoy.
 */
public interface IPackageImportSource {

	boolean canImportInto(Collection<?> selection);
	
	void initialize(Collection<?> selection);

	/**
	 * Obtains a content provider for the model hierarchy content that I
	 * contribute.
	 * 
	 * @return my content provider
	 */
	IStaticContentProvider getModelHierarchyContentProvider();

	/**
	 * Obtains a label provider for the model hierarchy content that I
	 * contribute. As a special case, it may be asked for a label for the
	 * {@code IPackageImportSource}, itself. In this case, a label should be
	 * provided that suitably represents "my kind of content."
	 * 
	 * @return my label provider
	 */
	ILabelProvider getModelHierarchyLabelProvider();

	List<Package> getPackages(ResourceSet resourceSet, Object model)
			throws CoreException;

	/**
	 * Clean up any resources that I allocated that are no longer required.
	 * Invoked after completion of the import interaction. This includes at
	 * least the {@linkplain #getModelHierarchyContentProvider() content
	 * provider} and {@linkplain #getModelHierarchyLabelProvider() label
	 * provider} that I create.
	 */
	void dispose();
}
