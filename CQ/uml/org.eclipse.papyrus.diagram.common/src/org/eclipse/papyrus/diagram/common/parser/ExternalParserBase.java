/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */
package org.eclipse.papyrus.diagram.common.parser;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.diagram.common.parser.lookup.Lookup;
import org.eclipse.papyrus.diagram.common.parser.lookup.LookupResolveRequest;
import org.eclipse.papyrus.diagram.common.parser.lookup.LookupResolver;
import org.eclipse.papyrus.diagram.common.parser.lookup.LookupSuite;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

public abstract class ExternalParserBase {

	private LookupSuite myLookups = LookupSuite.NULL_SUITE;

	private LookupResolver myLookupResolver = LookupResolver.NULL;

	private EObject myContext;

	public abstract EClass getSubjectClass();

	public abstract void parse(EObject target, String text) throws ExternalParserException;

	public final EObject parseNewObject(EObject context, String text) throws ExternalParserException {
		myContext = context;
		try {
			EObject result = createSubjectPrototype();
			parse(result, text);
			return result;
		} finally {
			myContext = null;
		}
	}

	public final void parse(EObject target, String text, EObject context) throws ExternalParserException {
		myContext = context;
		try {
			parse(target, text);
		} finally {
			myContext = null;
		}
	}

	public final void setLookupSuite(LookupSuite suite) {
		myLookups = suite;
		if (myLookups == null) {
			myLookups = LookupSuite.NULL_SUITE;
		}
	}

	public final void setLookupResolver(LookupResolver lookupResolver) {
		myLookupResolver = lookupResolver;
		if (myLookupResolver == null) {
			myLookupResolver = LookupResolver.NULL;
		}
	}

	public final LookupSuite getLookupSuite() {
		return myLookups;
	}

	public final <T> T lookup(Class<T> clazz, String name) {
		Lookup<T> lookup = getLookupSuite().getLookup(clazz);
		return lookup.lookup(name, getContext());
	}

	public EObject createSubjectPrototype() {
		EClass subjectClass = getSubjectClass();
		return subjectClass.getEPackage().getEFactoryInstance().create(subjectClass);
	}

	protected final EObject getContext() {
		return myContext;
	}

	protected final void checkContext() {
		if (getContext() == null) {
			throw new IllegalStateException("I need context element to perform lookups");
		}
	}

	protected <T extends NamedElement> void applyLookup(Class<T> clazz, String name, LookupResolver.Callback callback) {
		Lookup<T> lookup = getLookupSuite().getLookup(clazz);
		T result = lookup.lookup(name, getContext());
		if (result != null) {
			callback.lookupResolved(result);
			return;
		}
		List<IElementType> allowedTypes = lookup.getResolutionElementTypes();
		if (allowedTypes.isEmpty()) {
			return;
		}
		LookupResolveRequest request = new LookupResolveRequest(allowedTypes, UMLPackage.eINSTANCE.getNamedElement_Name(), name);
		myLookupResolver.addLookupResolveRequest(request, callback);
	}

}
