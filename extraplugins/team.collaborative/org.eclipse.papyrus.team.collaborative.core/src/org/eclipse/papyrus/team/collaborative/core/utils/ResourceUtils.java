/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.core.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.resource.Resource;


/**
 * The Class ResourceUtils.
 * Utils class use to handle {@link Resource}
 */
public class ResourceUtils {


	/**
	 * Instantiates a new resource utils.
	 */
	protected ResourceUtils() {
	}

	//	/**
	//	 * Gets the list of non collab ancestor.
	//	 * 
	//	 * @param inputResources
	//	 *        the input resources
	//	 * @param resourceSet
	//	 *        the resource set
	//	 * @return the list of non collab ancestor
	//	 */
	//	public static List<IResource> getListOfNonCollabAncestor(Collection<? extends IResource> inputResources, ResourceSet resourceSet) {
	//		List<IResource> result = new ArrayList<IResource>();
	//		for(IResource f : inputResources) {
	//			if(!(f instanceof IProject) && (f instanceof IContainer || f instanceof IFile)) {
	//				getListOfNonCollabAncestor(Collections.singletonList(f.getParent()), resourceSet);
	//				if(!result.contains(f)) {
	//					if(!ICollaborativeManager.INSTANCE.isCollab(Collections.singleton(IResourceToExtendedURI.getInstance().apply(f)), resourceSet)) {
	//						result.add(f);
	//					}
	//				}
	//			}
	//		}
	//		return result;
	//	}


	/**
	 * Gets the list ancestors.
	 * 
	 * @param inputResources
	 *        the input resources
	 * @return the list ancestors
	 */
	public static List<IResource> getListAncestors(Collection<? extends IResource> inputResources) {
		List<IResource> result = new ArrayList<IResource>();
		for(IResource f : inputResources) {
			if(!(f instanceof IProject) && (f instanceof IContainer || f instanceof IFile)) {
				getListAncestors(Collections.singletonList(f.getParent()));
				if(!result.contains(f)) {
					result.add(f);
				}
			}
		}
		return result;
	}

}
