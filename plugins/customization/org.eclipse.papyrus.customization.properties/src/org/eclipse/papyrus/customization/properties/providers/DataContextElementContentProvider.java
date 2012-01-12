/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.providers;

import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.papyrus.infra.widgets.providers.AbstractFilteredContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.contexts.DataContextPackage;
import org.eclipse.papyrus.views.properties.contexts.DataContextRoot;

/**
 * A ContentProvider for retrieving the available DataContextElements
 * 
 * @author Camille Letavernier
 */
public class DataContextElementContentProvider extends AbstractFilteredContentProvider implements IStaticContentProvider {

	private List<DataContextElement> elements;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param element
	 */
	public DataContextElementContentProvider(DataContextElement element) {
		Context context = findContext(element);

		Set<Context> allContexts = new HashSet<Context>();

		if(context != null) {
			getAllContexts(context, allContexts);
		}

		Set<DataContextElement> allElements = new HashSet<DataContextElement>();
		for(Context ctx : allContexts) {
			for(DataContextRoot root : ctx.getDataContexts()) {
				getAllElements(root, allElements);
			}
		}

		elements = new LinkedList<DataContextElement>(allElements);
		Collections.sort(elements, new Comparator<DataContextElement>() {

			private Collator collator = RuleBasedCollator.getInstance();

			public int compare(DataContextElement element1, DataContextElement element2) {
				String name1 = element1.getName();
				String name2 = element2.getName();
				if(name1 == null && name2 == null) {
					return 0;
				}
				if(name1 == null) {
					return -1;
				}
				if(name2 == null) {
					return 1;
				}
				return collator.compare(name1, name2);
			}

		});

		showIfHasVisibleParent = true;
	}

	private void getAllElements(DataContextElement fromElement, Collection<DataContextElement> result) {
		if(result.contains(fromElement)) {
			return;
		}

		result.add(fromElement);
		if(fromElement instanceof DataContextPackage) {
			DataContextPackage fromPackage = (DataContextPackage)fromElement;
			for(DataContextElement element : fromPackage.getElements()) {
				getAllElements(element, result);
			}
		}
	}

	private void getAllContexts(Context fromContext, Collection<Context> result) {
		if(result.contains(fromContext)) {
			return;
		}

		result.add(fromContext);
		for(Context context : fromContext.getDependencies()) {
			getAllContexts(context, result);
		}
	}

	private Context findContext(DataContextElement element) {
		if(element.getPackage() == null) {
			return (Context)element.eContainer();
		}
		return findContext(element.getPackage());
	}

	public Object[] getElements() {
		return elements.toArray(new DataContextElement[elements.size()]);
	}

	public Object[] getElements(Object inputElement) {
		return getElements();
	}

}
