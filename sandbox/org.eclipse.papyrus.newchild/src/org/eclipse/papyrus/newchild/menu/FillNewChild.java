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
import org.eclipse.papyrus.newchild.ElementPosition;
import org.eclipse.papyrus.newchild.MenuGroup;
import org.eclipse.papyrus.newchild.NewChildKind;
import org.eclipse.papyrus.newchild.NewChildMenu;
import org.eclipse.papyrus.newchild.action.CreateChildAction;
import org.eclipse.papyrus.newchild.runtime.DisabledContributionItem;
import org.eclipse.papyrus.newchild.util.EMFHelper;
import org.eclipse.papyrus.newchild.util.MenuHelper;
import org.eclipse.papyrus.newchild.util.Util;



public class FillNewChild extends FillMenu implements FillElement {

	protected EObject selectedEObject;

	protected NewChildMenu menu;

	public FillNewChild(MenuGroup parentGroup, NewChildMenu menu, Object selectedObject) {
		super(parentGroup, menu, selectedObject);
		this.menu = menu;
		this.selectedEObject = EMFHelper.getEObject(selectedObject);
	}

	@Override
	public void fill(IMenuManager menuManager) {

		EObject parentEObject = selectedEObject;
		if(menu.getPosition() == ElementPosition.SIBLING) {
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

		MenuManager createChildMenu = new MenuManager(menu.getName(), Util.getImage(menu), menu.getId());
		MenuHelper.add(parentGroup, menuManager, createChildMenu);

		Map<EStructuralFeature, List<EClass>> instantiableClasses = new HashMap<EStructuralFeature, List<EClass>>();

		for(EStructuralFeature feature : parentEObject.eClass().getEAllStructuralFeatures()) {
			if(feature instanceof EReference && ((EReference)feature).isContainment()) {
				EClass type = (EClass)feature.getEType();
				instantiableClasses.put(feature, EMFHelper.getSubclassesOf(type, true));
			}
		}

		NewChildKind kind = getKind(instantiableClasses);

		if(kind == NewChildKind.FLAT) {
			for(EStructuralFeature feature : instantiableClasses.keySet()) {
				for(EClass eClass : instantiableClasses.get(feature)) {
					addCreateActionToMenu(createChildMenu, parentEObject, eClass, (EReference)feature);
				}
			}
		} else { //Hierarchical
			for(EStructuralFeature feature : instantiableClasses.keySet()) {
				IMenuManager subMenu = new MenuManager(feature.getName());
				createChildMenu.add(subMenu);

				for(EClass eClass : instantiableClasses.get(feature)) {
					addCreateActionToMenu(subMenu, parentEObject, eClass, (EReference)feature);
				}
			}
		}
	}

	private NewChildKind getKind(Map<EStructuralFeature, List<EClass>> instantiableClasses) {
		if(menu.getKind() != NewChildKind.AUTO) {
			return menu.getKind();
		}

		if(instantiableClasses.size() < 2) {
			return NewChildKind.FLAT;
		}

		if(instantiableClasses.size() > 5) {
			return NewChildKind.HIERARCHICAL;
		}

		for(List<EClass> eClasses : instantiableClasses.values()) {
			if(eClasses.size() > 5) {
				return NewChildKind.HIERARCHICAL;
			}
		}

		return NewChildKind.FLAT;
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
