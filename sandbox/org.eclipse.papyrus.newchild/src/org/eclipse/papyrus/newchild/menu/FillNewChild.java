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
package org.eclipse.papyrus.newchild.menu;

import java.io.IOException;
import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.newchild.Activator;
import org.eclipse.papyrus.newchild.MenuGroup;
import org.eclipse.papyrus.newchild.NewchildConfiguration;
import org.eclipse.papyrus.newchild.action.CreateChildAction;
import org.eclipse.papyrus.newchild.ncpolicy.CreateIn;
import org.eclipse.papyrus.newchild.ncpolicy.Layout;
import org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicySet;
import org.eclipse.papyrus.newchild.ncpolicy.NewEMFChildMenu;
import org.eclipse.papyrus.newchild.policies.NewChildFillPolicy;
import org.eclipse.papyrus.newchild.policies.PolicyManager;
import org.eclipse.papyrus.newchild.policies.PolicyMatcher;
import org.eclipse.papyrus.newchild.runtime.DisabledContributionItem;
import org.eclipse.papyrus.newchild.util.EMFHelper;
import org.eclipse.papyrus.newchild.util.MenuHelper;
import org.eclipse.papyrus.newchild.util.Util;



public class FillNewChild extends FillMenu implements FillElement {

	protected EObject selectedEObject;

	protected NewEMFChildMenu menu;

	//private static PolicyManager policyManager;

	private PolicyManager policyManager;

	public FillNewChild(FillMenuGroup parentGroup, NewEMFChildMenu menu, Object selectedObject) {
		super(parentGroup, menu, selectedObject);
		this.menu = menu;
		this.selectedEObject = EMFHelper.getEObject(selectedObject);

		//TODO : Extract that to a static instance, and load with extension point
		policyManager = new PolicyManager();
		try {
			NewchildConfiguration configuration = (NewchildConfiguration)EMFHelper.loadEMFModel(null, URI.createPlatformPluginURI("org.eclipse.papyrus.newchild/Model/NewchildConfiguration.xmi", true));
			policyManager.addConfiguration(configuration);
		} catch (IOException ex) {
			Activator.log.error(ex);
		}
	}

	@Override
	public void fill(IMenuManager menuManager) {
		EObject parentEObject = selectedEObject;
		if(menu.getCreateIn() == CreateIn.PARENT) {
			if(selectedEObject != null) {
				parentEObject = selectedEObject.eContainer();
			}
		}

		if(parentEObject == null) {
			return;
		}

		if(EMFHelper.isReadOnly(parentEObject)) {
			DisabledContributionItem disabledItem = new DisabledContributionItem(menu.getName(), Util.getImage(menu), menu.getId());
			disabledItem.setMenuStyle(true);
			MenuHelper.add(parentGroup, menuManager, disabledItem);
			return;
		}

		IMenuManager createChildMenu = getSubMenu(menuManager);

		Map<EStructuralFeature, List<EClass>> instantiableClasses = new LinkedHashMap<EStructuralFeature, List<EClass>>();

		List<EStructuralFeature> features = new LinkedList<EStructuralFeature>(parentEObject.eClass().getEAllStructuralFeatures());
		Collections.sort(features, new Comparator<EStructuralFeature>() {

			public int compare(EStructuralFeature feature1, EStructuralFeature feature2) {
				if(feature1 == null) {
					if(feature2 == null) {
						return 0;
					}
					return -1;
				}

				return Collator.getInstance().compare(feature1.getName(), feature2.getName());
			}

		});

		for(EStructuralFeature feature : features) {
			if(feature instanceof EReference && ((EReference)feature).isContainment()) {
				EClass type = (EClass)feature.getEType();
				List<EClass> eClasses = EMFHelper.getSubclassesOf(type, true);
				Collections.sort(eClasses, new Comparator<EClass>() {

					public int compare(EClass class1, EClass class2) {
						if(class1 == null) {
							if(class2 == null) {
								return 0;
							}
							return -1;
						}

						return Collator.getInstance().compare(class1.getName(), class2.getName());
					}

				});

				instantiableClasses.put(feature, eClasses);
			}
		}

		Layout layout = getLayout(instantiableClasses);

		Set<NewChildPolicySet> policySets = policyManager.getDisplayUnits(new StructuredSelection(parentEObject));
		PolicyMatcher matcher = new PolicyMatcher();
		matcher.setPolicies(policySets);

		if(layout == Layout.FLAT) {
			for(EStructuralFeature feature : instantiableClasses.keySet()) {
				for(EClass eClass : instantiableClasses.get(feature)) {
					addActionToMenu(matcher, createChildMenu, parentEObject, eClass, feature);
				}
			}
		} else { //Hierarchical
			for(EStructuralFeature feature : instantiableClasses.keySet()) {
				IMenuManager subMenu = new MenuManager(feature.getName());
				createChildMenu.add(subMenu);

				for(EClass eClass : instantiableClasses.get(feature)) {
					addActionToMenu(matcher, subMenu, parentEObject, eClass, feature);
				}
			}
		}

		super.fill(menuManager);

		for(MenuGroup group : menu.getGroups()) {
			FillerFactory.instance.getFiller(group, selectedObject).fill(createChildMenu);
		}
	}

	protected void addActionToMenu(PolicyMatcher matcher, IMenuManager menu, EObject parentEObject, EClass eClass, EStructuralFeature feature) {
		eClass = (EClass)eClass.getEPackage().getEClassifier(eClass.getName()); //Loads the EClass from the static resourceSet

		List<NewChildFillPolicy> matchingPolicies = matcher.getMatchingPolicies(eClass, feature);
		if(matchingPolicies.isEmpty()) {
			addCreateActionToMenu(menu, parentEObject, eClass, (EReference)feature);
		} else {
			for(NewChildFillPolicy policy : matchingPolicies) {
				policy.fill(menu, parentEObject, eClass, feature, parentEObject);
			}
		}
	}

	@Override
	protected IMenuManager getSubMenu(IMenuManager menuManager) {
		return super.getSubMenu(menuManager);
	}

	private Layout getLayout(Map<EStructuralFeature, List<EClass>> instantiableClasses) {
		if(menu.getLayout() != Layout.AUTO) {
			return menu.getLayout();
		}

		if(instantiableClasses.size() < 2) {
			return Layout.FLAT;
		}

		if(instantiableClasses.size() > 5) {
			return Layout.HIERARCHICAL;
		}

		for(List<EClass> eClasses : instantiableClasses.values()) {
			if(eClasses.size() > 5) {
				return Layout.HIERARCHICAL;
			}
		}

		return Layout.FLAT;
	}

	private void addCreateActionToMenu(IMenuManager menuManager, EObject parent, EClass createAs, EReference createIn) {
		menuManager.add(getCreateChildAction(parent, createAs, createIn));
	}

	private Action getCreateChildAction(EObject parent, EClass createAs, EReference createIn) {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(parent);
		CreateChildAction action = new CreateChildAction(domain, parent, createIn, createAs);
		IStructuredSelection selection = new StructuredSelection(parent);
		action.configureAction(selection);
		action.setId(createIn.getName() + "#" + createAs.getName());
		return action;
	}

}
