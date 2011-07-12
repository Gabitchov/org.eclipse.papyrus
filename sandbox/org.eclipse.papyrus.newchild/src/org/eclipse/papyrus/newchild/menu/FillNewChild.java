package org.eclipse.papyrus.newchild.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.eclipse.papyrus.newchild.Menu;
import org.eclipse.papyrus.newchild.MenuGroup;
import org.eclipse.papyrus.newchild.action.CreateChildAction;
import org.eclipse.papyrus.newchild.runtime.DisabledContributionItem;
import org.eclipse.papyrus.newchild.util.EMFHelper;
import org.eclipse.papyrus.newchild.util.MenuHelper;
import org.eclipse.papyrus.newchild.util.Util;



public class FillNewChild extends FillMenu implements FillElement {

	protected EObject selectedEObject;

	public FillNewChild(MenuGroup parentGroup, Menu menu, Object selectedObject) {
		super(parentGroup, menu, selectedObject);

		this.selectedEObject = EMFHelper.getEObject(selectedObject);
	}

	@Override
	public void fill(IMenuManager menuManager) {

		if(selectedEObject == null || EMFHelper.isReadOnly(selectedEObject)) {
			MenuHelper.add(parentGroup, menuManager, new DisabledContributionItem(menu.getName(), Util.getImage(menu), menu.getId()));
			return;
		}

		MenuManager createChildMenu = new MenuManager(menu.getName(), Util.getImage(menu), menu.getId());
		MenuHelper.add(parentGroup, menuManager, createChildMenu);

		Map<EStructuralFeature, List<EClass>> instantiableClasses = new HashMap<EStructuralFeature, List<EClass>>();

		for(EStructuralFeature feature : selectedEObject.eClass().getEAllStructuralFeatures()) {
			if(feature instanceof EReference && ((EReference)feature).isContainment()) {
				EClass type = (EClass)feature.getEType();
				instantiableClasses.put(feature, EMFHelper.getSubclassesOf(type, true));
			}
		}

		for(EStructuralFeature feature : instantiableClasses.keySet()) {
			IMenuManager subMenu = createChildMenu;
			if(instantiableClasses.size() > 1) {
				subMenu = new MenuManager(feature.getName());
				createChildMenu.add(subMenu);
			}

			for(EClass eClass : instantiableClasses.get(feature)) {
				addCreateActionToMenu(subMenu, selectedEObject, eClass, (EReference)feature);
			}
		}
	}

	private void addCreateActionToMenu(IMenuManager menuManager, EObject parent, EClass createAs, EReference createIn) {
		menuManager.add(getCreateChildAction(parent, createAs, createIn));
	}

	private Action getCreateChildAction(EObject parent, EClass createAs, EReference createIn) {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(parent);
		CreateChildAction action = new CreateChildAction(domain, parent, createIn, createAs);
		IStructuredSelection selection = new StructuredSelection(parent);
		action.configureAction(selection);
		return action;
	}

}
