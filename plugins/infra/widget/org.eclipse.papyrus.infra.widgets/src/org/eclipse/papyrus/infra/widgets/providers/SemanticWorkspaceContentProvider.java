/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.providers;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.infra.tools.util.ListHelper;
import org.eclipse.papyrus.infra.widgets.Activator;

import com.ibm.icu.text.Collator;

/**
 * A ContentProvider for resources located in the current workspace
 * 
 * @author Camille Letavernier
 */
public class SemanticWorkspaceContentProvider extends AbstractStaticContentProvider implements IHierarchicContentProvider {

	/**
	 * Constructor
	 */
	public SemanticWorkspaceContentProvider() {

	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getElements() {
		try {
			return filterAccessibleElements(ResourcesPlugin.getWorkspace().getRoot().members());
		} catch (Exception ex) {
			Activator.log.error(ex);
			return new Object[0];
		}
	}

	protected Object[] filterAccessibleElements(IResource[] members) {
		List<IResource> accessibleElements = ListHelper.asList(members);

		Iterator<IResource> resourceIterator = accessibleElements.iterator();
		while(resourceIterator.hasNext()) {
			IResource resource = resourceIterator.next();
			if(!resource.isAccessible()) {
				resourceIterator.remove();
			}
		}

		Collections.sort(accessibleElements, resourceComparator);

		return accessibleElements.toArray();
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof IContainer) {
			try {
				IResource[] members = ((IContainer)parentElement).members();

				return filterAccessibleElements(members);
			} catch (CoreException ex) {
				Activator.log.error(ex);
			}
		}
		return new Object[0];
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getParent(Object element) {
		if(element instanceof IContainer) {
			return ((IContainer)element).getParent();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isValidValue(Object element) {
		return !(element instanceof IWorkspaceRoot);
	}

	/**
	 * Compares two resources (IResource)
	 */
	private static final Comparator<IResource> resourceComparator = createComparator();

	private static Comparator<IResource> createComparator() {
		final int folderTypes = IResource.FOLDER | IResource.PROJECT | IResource.ROOT;
		return new Comparator<IResource>() {

			public int compare(IResource resource1, IResource resource2) {
				int typeCompare = compareType(resource1, resource2);
				if(typeCompare == 0) {
					return compareName(resource1, resource2);
				}
				return typeCompare;
			}

			private int compareType(IResource resource1, IResource resource2) {
				if(resource1.getType() == resource2.getType()) {
					return 0;
				}
				if((resource1.getType() & folderTypes) > (resource2.getType() & folderTypes)) {
					return -1;
				} else {
					return 1;
				}
			}

			private int compareName(IResource resource1, IResource resource2) {
				return Collator.getInstance().compare(resource1.getName(), resource2.getName());
			}

		};
	}
}
