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
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */

package org.eclipse.papyrus.diagram.common.parser;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.PackageableElement;

public class ElementProvider {

	private final SortedMap<String, PackageableElement> myNamesMap;

	private final SortedSet<String> myCaseInsensitiveNames;

	private final SortedSet<String> myCaseInsensitiveNamesRO;

	private ResourceSet myResourceSet;

	private EObject myContext;

	private boolean myIsCaching;

	public ElementProvider() {
		this(false);
	}

	public ElementProvider(boolean isCaching) {
		myIsCaching = isCaching;
		myNamesMap = new TreeMap<String, PackageableElement>();
		myCaseInsensitiveNames = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		myCaseInsensitiveNamesRO = Collections.unmodifiableSortedSet(myCaseInsensitiveNames);
	}

	public Iterable<PackageableElement> getElements(EObject eObject) {
		setContext(eObject);
		return myNamesMap.values();
	}

	public SortedSet<String> getElementNames(EObject eObject) {
		setContext(eObject);
		return myCaseInsensitiveNamesRO;
	}

	public PackageableElement findElement(EObject context, String name) {
		setContext(context);
		return myNamesMap.get(name.trim());
	}

	protected void setContext(EObject context) {
		myContext = context;
		ResourceSet resourceSet = context.eResource().getResourceSet();
		if (myIsCaching && myResourceSet != null && myResourceSet.equals(resourceSet) && !moreResourcesWereLoaded(resourceSet)) {
			return;
		}

		myNamesMap.clear();
		myCaseInsensitiveNames.clear();
		myResourceSet = resourceSet;

		for (PackageableElement element : loadAllElements(resourceSet)) {
			String displayName = getDisplayProposal(element);
			if (displayName == null) {
				continue;
			}
			myCaseInsensitiveNames.add(displayName);
			myNamesMap.put(displayName, element);
		}
	}

	protected String getDisplayProposal(PackageableElement element) {
		return element.getName();
	}

	protected List<PackageableElement> loadAllElements(ResourceSet resourceSet) {
		EList<Resource> resources = resourceSet.getResources();
		List<PackageableElement> allElements = new LinkedList<PackageableElement>();
		for (Resource metamodel : resources) {
			for (Iterator<EObject> contents = metamodel.getAllContents(); contents.hasNext();) {
				EObject next = contents.next();
				if (isSuitable(next)) {
					allElements.add((PackageableElement) next);
				}
			}
		}
		return allElements;
	}

	protected boolean isSuitable(Object object) {
		return object instanceof PackageableElement && ((PackageableElement) object).getName() != null;
	}

	protected EObject getContext() {
		return myContext;
	}

	private boolean moreResourcesWereLoaded(ResourceSet resourceSet) {
		return !myResourceSet.getResources().equals(resourceSet.getResources());
	}

}
