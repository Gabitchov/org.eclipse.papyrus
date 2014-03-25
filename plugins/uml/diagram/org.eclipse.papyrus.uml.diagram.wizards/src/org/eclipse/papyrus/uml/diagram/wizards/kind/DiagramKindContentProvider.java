/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards.kind;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.viewpoints.configuration.Category;
import org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The ContentProvider for DiagramCategory table.
 * Returns available diagram kinds for the given diagram category(ies).
 */
public class DiagramKindContentProvider implements IStructuredContentProvider {

	private final Map<String, Collection<ViewPrototype>> prototypes;
	
	/**
	 * Instantiates a new diagram kind content provider.
	 *
	 */
	public DiagramKindContentProvider() {
		Collection<ViewPrototype> vps = PolicyChecker.getCurrent().getAllPrototypes();
		this.prototypes = new HashMap<String, Collection<ViewPrototype>>();
		for (ViewPrototype vp : vps)
			for (Category category : vp.getCategories())
				cache(category.getName(), vp);
	}
	
	/**
	 * Stores the given diagram prototype in the cache
	 * @param prototype The prototype to cache
	 */
	private void cache(String category, ViewPrototype prototype) {
		if (!prototypes.containsKey(category))
			prototypes.put(category, new ArrayList<ViewPrototype>());
		prototypes.get(category).add(prototype);
	}


	/**
	 * Dispose.
	 *
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		prototypes.clear();
	}

	/**
	 * Input changed.
	 *
	 * @param viewer the viewer
	 * @param oldInput the old input
	 * @param newInput the new input
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	/**
	 * Gets the elements.
	 *
	 * @param inputElement the input element
	 * @return the elements
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof Object[]) {
			List<ViewPrototype> result = new ArrayList<ViewPrototype>();
			for (Object next: (Object[])inputElement) {
				if (next instanceof String) {
					String diagramCategory = (String)next;
					result.addAll(getPrototypes(diagramCategory));
				}
			}
			Collections.sort(result, new ViewPrototype.Comp());
			return result.toArray(new Object[result.size()]);
		}
		if(inputElement instanceof String) {
			String diagramCategory = (String)inputElement;
			List<ViewPrototype> result = getPrototypes(diagramCategory);
			return result.toArray(new Object[result.size()]);
		}
		return null;
	}

	/**
	 * Gets the creation commands.
	 *
	 * @param diagramCategory the diagram category
	 * @return the creation commands
	 */
	protected List<ViewPrototype> getPrototypes(String diagramCategory) {
		List<ViewPrototype> result = new ArrayList<ViewPrototype>();
		// Add the category-specific views
		if (prototypes.containsKey(diagramCategory)) {
			EClass rootType = getExpectedRootType(diagramCategory);
			for (ViewPrototype proto : prototypes.get(diagramCategory))
				if (isAllowedOn(proto, rootType))
					result.add(proto);
		}
		return result;
	}
	
	private EClass getExpectedRootType(String category) {
		if ("profile".equals(category))
			return UMLPackage.eINSTANCE.getProfile();
		return UMLPackage.eINSTANCE.getModel();
	}
	
	private boolean isAllowedOn(ViewPrototype prototype, EClass clazz)  {
		PapyrusView current = prototype.getConfiguration();
		while (current != null) {
			for (ModelRule rule : current.getModelRules()) {
				int result = allows(rule, clazz);
				if (result == -1)
					return false;
				if (result == 1)
					return true;
			}
			current = current.getParent();
		}
		return false;
	}
	
	private int allows(ModelRule rule, EClass owner) {
		EClass c = rule.getElement();
		if (c == null || c.isSuperTypeOf(owner)) {
			// matching type => check the application of the required stereotypes
			return rule.isPermit() ? 1 : -1;
		} else {
			// type is not matching => unknown
			return 0;
		}
	}
}