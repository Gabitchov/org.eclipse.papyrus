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

import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.common.util.URI;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

/**
 * This is the CDOPredicates type. Enjoy.
 */
public class CDOPredicates {

	// Not instantiable by clients.
	private CDOPredicates() {
		super();
	}

	public static <T> Predicate<T> adaptsTo(Class<?> adapterType) {
		return Predicates.<T, Object> compose(Predicates.notNull(), CDOFunctions.<T, Object> adapt(adapterType));
	}

	public static Predicate<CDOResourceNode> hasExtension(String fileExtension) {
		return (fileExtension == null) ? new HasNoExtension() : new HasExtension(fileExtension);
	}

	public static Predicate<CDOResourceNode> hasURIPrefix(URI prefix) {
		if(!prefix.isPrefix()) {
			throw new IllegalArgumentException("not a URI prefix");
		}

		return new HasURIPrefix(prefix);
	}

	//
	// Nested types
	//

	private static final class HasExtension implements Predicate<CDOResourceNode> {

		private final String fileExtension;

		HasExtension(String fileExtension) {
			this.fileExtension = fileExtension;
		}

		public boolean apply(CDOResourceNode input) {
			return fileExtension.equals(input.getURI().fileExtension());
		}

		@Override
		public String toString() {
			return String.format("hasExtension(%s)", fileExtension); //$NON-NLS-1$
		}

		@Override
		public int hashCode() {
			return fileExtension.hashCode();
		}

		@Override
		public boolean equals(Object other) {
			return (other instanceof HasExtension) && ((HasExtension)other).fileExtension.equals(fileExtension);
		}
	}

	private static final class HasNoExtension implements Predicate<CDOResourceNode> {

		HasNoExtension() {
			super();
		}

		public boolean apply(CDOResourceNode input) {
			return input.getURI().fileExtension() == null;
		}

		@Override
		public String toString() {
			return "hasNoExtension()"; //$NON-NLS-1$
		}

		@Override
		public int hashCode() {
			return HasNoExtension.class.hashCode();
		}

		@Override
		public boolean equals(Object other) {
			return (other instanceof HasNoExtension);
		}
	}

	private static final class HasURIPrefix implements Predicate<CDOResourceNode> {

		private final URI prefix;

		HasURIPrefix(URI prefix) {
			this.prefix = prefix;
		}

		public boolean apply(CDOResourceNode input) {
			return input.getURI().toString().startsWith(prefix.toString());
		}

		@Override
		public String toString() {
			return String.format("hasURIPrefix(%s)", prefix); //$NON-NLS-1$
		}

		@Override
		public int hashCode() {
			return prefix.hashCode();
		}

		@Override
		public boolean equals(Object other) {
			return (other instanceof HasURIPrefix) && ((HasURIPrefix)other).prefix.equals(prefix);
		}
	}
}
