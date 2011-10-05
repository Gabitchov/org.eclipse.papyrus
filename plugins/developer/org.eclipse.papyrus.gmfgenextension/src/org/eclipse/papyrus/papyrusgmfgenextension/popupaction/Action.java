/*******************************************************************************
 * Copyright (c) 2009 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are property of the CEA, their use is subject to specific agreement 
 * with the CEA.
 * 
 * Contributors:
 *    CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.papyrusgmfgenextension.popupaction;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.Behaviour;
import org.eclipse.gmf.codegen.gmfgen.CustomBehaviour;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public abstract class Action implements IObjectActionDelegate {

	private List<EObject> selectedListEObject;

	/**
	 * Convert each selected elements from the explorer menu, or modeling view to an EObject and add it to a list
	 * 
	 * @return list of EObject
	 */
	public void updateSelectedEObject(IStructuredSelection selection) {

		List<EObject> selectedCurrentListEObjects = new LinkedList<EObject>();

		Iterator<Object> eltIt = selection.iterator();
		while(eltIt.hasNext()) {

			Object currentObject = eltIt.next();
			if(currentObject instanceof EObject) {
				selectedCurrentListEObjects.add((EObject)currentObject);
			}
		}
		selectedListEObject = selectedCurrentListEObjects;
	}

	public List<EObject> getSelectedEObject() {
		return selectedListEObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		// Convert selection into EObject list
		updateSelectedEObject((IStructuredSelection)selection);
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// NO OP.
	}

	/**
	 * Check if the CustomBehavior for policyKey is already added
	 * 
	 * @param genlink
	 *        the GenLink to test
	 * @param policyKey
	 *        that we look for
	 * @return true if the behavior with correct key already exists
	 */
	protected boolean hasCustomBehavior(GenCommonBase genCommonBase, String policyKey) {

		boolean hasCustomBehavior = false;

		Iterator<Behaviour> it = genCommonBase.getBehaviour().iterator();
		while(it.hasNext() && !(hasCustomBehavior)) {
			Behaviour behaviour = it.next();

			if(behaviour instanceof CustomBehaviour) {
				CustomBehaviour customBehavior = (CustomBehaviour)behaviour;
				if(policyKey.equals(customBehavior.getKey())) {
					hasCustomBehavior = true;
				}
			}
		}

		return hasCustomBehavior;
	}

	/**
	 * Add the CustomBehavior for Applied Stereotype label display to the GenLink node given as
	 * parameter
	 * 
	 * @param genCommonBase
	 *        where the CustomBehavior is added
	 */
	protected void addCustomBehavior(GenCommonBase genCommonBase, String policyKey, String policyValue) {

		CustomBehaviour behavior = GMFGenFactory.eINSTANCE.createCustomBehaviour();
		behavior.setKey(policyKey);
		behavior.setEditPolicyQualifiedClassName(policyValue);

		genCommonBase.getBehaviour().add(behavior);
	}

	/**
	 * Find the GenClass node with specified name in the resource model (GenModel expected here)
	 * 
	 * @param resource
	 *        the genmodel
	 * @param name
	 *        of the searched GenClass
	 * @return genClass with chosen name or null
	 */
	protected GenClass findGenClass(Resource resource, String name) {

		GenClass genClass = null;
		Iterator<EObject> it = resource.getAllContents();
		while(it.hasNext() && (genClass == null)) {
			EObject eobject = it.next();

			if(eobject instanceof GenClass) {
				GenClass current = (GenClass)eobject;
				if(name.equals(current.getName())) {
					genClass = current;
				}
			}
		}
		return genClass;
	}

	/**
	 * Finds a GenFeature owned by a specified GenClass in the resource (genmodel)
	 * 
	 * @param resource
	 *        the genmodel
	 * @param genClassName
	 *        the name of GenClass owning the searched feature
	 * @param genFeatureName
	 *        the name of the GenFeature
	 * @return the found GenFeature node or null
	 */
	protected GenFeature findGenFeature(Resource resource, String genClassName, String genFeatureName) {

		GenFeature genFeature = null;

		Iterator<EObject> it = resource.getAllContents();
		while(it.hasNext() && (genFeature == null)) {
			EObject eobject = it.next();

			if(eobject instanceof GenClass) {
				GenClass genClass = (GenClass)eobject;

				if(genClassName.equals(genClass.getName())) {

					Iterator<GenFeature> itGF = genClass.getAllGenFeatures().iterator();
					while(itGF.hasNext() && (genFeature == null)) {
						GenFeature currentGenFeature = itGF.next();

						if(genFeatureName.equals(currentGenFeature.getEcoreFeature().getName())) {
							genFeature = currentGenFeature;
						}
					}
				}
			}
		}
		return genFeature;
	}
}
