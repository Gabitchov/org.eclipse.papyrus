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
package org.eclipse.papyrus.cdo.core.util;

import java.util.Collections;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.cdo.internal.core.Activator;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * This is the CDOFunctions type. Enjoy.
 */
public class CDOFunctions {

	// Not instantiable by clients.
	private CDOFunctions() {
		super();
	}

	public static <F, T> Function<F, T> adapt(Class<? extends T> adapterType) {
		return new AdaptFunction<F, T>(adapterType);
	}

	public static <T> Function<Resource, T> getRoot(Class<? extends T> rootElementType) {
		return new ResourceRootFunction<T>(rootElementType);
	}

	public static Function<CDOResourceNode, Iterable<CDOResourceNode>> getFolderContents() {
		return new FolderContentsFunction<CDOResourceNode>(CDOResourceNode.class);
	}

	public static <T extends CDOResourceNode> Function<CDOResourceNode, Iterable<T>> getFolderContents(Class<T> nodeType) {
		return new FolderContentsFunction<T>(nodeType);
	}

	public static Function<CDOObject, EObject> getEObject() {
		return GetEObjectFunction.INSTANCE;
	}

	//
	// Nested types
	//

	private static final class AdaptFunction<F, T> implements Function<F, T> {

		private final Class<? extends T> adapterType;

		AdaptFunction(Class<? extends T> adapterType) {
			this.adapterType = adapterType;
		}

		public T apply(F input) {
			return CDOUtils.adapt(input, adapterType);
		}

		@Override
		public String toString() {
			return String.format("adapt(%s)", adapterType.getName()); //$NON-NLS-1$
		}

		@Override
		public int hashCode() {
			return adapterType.hashCode();
		}

		@Override
		public boolean equals(Object other) {
			return (other instanceof AdaptFunction<?, ?>) && (((AdaptFunction<?, ?>)other).adapterType == adapterType);
		}
	}

	private static final class ResourceRootFunction<T> implements Function<Resource, T> {

		private final Class<? extends T> rootElementType;

		ResourceRootFunction(Class<? extends T> rootElementType) {
			this.rootElementType = rootElementType;
		}

		public T apply(Resource input) {
			if(!input.isLoaded()) {
				try {
					input.load(null);
				} catch (Exception e) {
					Activator.log.error(e);
				}
			}

			return Iterables.getFirst(Iterables.filter(input.getContents(), rootElementType), null);
		}

		@Override
		public String toString() {
			return String.format("getRoot(%s)", rootElementType.getName()); //$NON-NLS-1$
		}

		@Override
		public int hashCode() {
			return rootElementType.hashCode();
		}

		@Override
		public boolean equals(Object other) {
			return (other instanceof ResourceRootFunction<?>) && (((ResourceRootFunction<?>)other).rootElementType == rootElementType);
		}
	}

	private static final class FolderContentsFunction<T extends CDOResourceNode> implements Function<CDOResourceNode, Iterable<T>> {

		private final Class<T> nodeType;

		FolderContentsFunction(Class<T> nodeType) {
			this.nodeType = nodeType;
		}

		public Iterable<T> apply(CDOResourceNode input) {
			Iterable<T> result;

			if(input instanceof CDOResourceFolder) {
				result = Iterables.filter(((CDOResourceFolder)input).getNodes(), nodeType);
			} else if(input.isRoot()) {
				result = Iterables.filter(((CDOResource)input).getContents(), nodeType);
			} else {
				result = Collections.emptyList();
			}

			return result;
		}

		@Override
		public String toString() {
			return String.format("getFolderContents(%s)", nodeType.getName()); //$NON-NLS-1$
		}

		@Override
		public int hashCode() {
			return nodeType.hashCode();
		}

		@Override
		public boolean equals(Object other) {
			return (other instanceof FolderContentsFunction<?>) && (((FolderContentsFunction<?>)other).nodeType == nodeType);
		}
	}

	private static final class GetEObjectFunction implements Function<CDOObject, EObject> {

		static final GetEObjectFunction INSTANCE = new GetEObjectFunction();

		private GetEObjectFunction() {
			super();
		}

		public EObject apply(CDOObject input) {
			return CDOUtil.getEObject(input);
		}

		@Override
		public String toString() {
			return "getEObject()"; //$NON-NLS-1$
		}
	}
}
