/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.profile.ui.compositeforview;

import org.eclipse.jface.resource.JFaceColors;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.diagram.common.editparts.IUMLEditPart;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;

//TODO: Auto-generated Javadoc
/**
 * The Class ProfileComposite to apply or unapply profile only on model element withou view.
 */
public class ProfileCompositeWithView extends org.eclipse.papyrus.profile.ui.compositesformodel.ProfileCompositeOnModel {

	/**
	 * The selection.
	 */
	protected ISelection selection;

	/**
	 * The Constructor.
	 * 
	 * @param parent
	 *            the parent
	 * @param factory
	 *            the factory
	 */
	public ProfileCompositeWithView(Composite parent, TabbedPropertySheetWidgetFactory factory) {
		super(parent, factory);
		this.setBackground(JFaceColors.getBannerBackground(parent.getDisplay()));
	}

	/**
	 * Sets the selection.
	 * 
	 * @param selection
	 *            the selection
	 */
	public void setSelection(ISelection selection) {
		this.selection = selection;
	}

	/**
	 * Gets the selected.
	 * 
	 * @return the selected
	 */
	@Override
	public org.eclipse.uml2.uml.Package getSelected() {
		Object input = ((IStructuredSelection) selection).getFirstElement();
		if (input instanceof IUMLEditPart) {
			if (((IUMLEditPart) input).getUMLElement() instanceof org.eclipse.uml2.uml.Package)
				return ((org.eclipse.uml2.uml.Package) ((IUMLEditPart) input).getUMLElement());
			else
				return null;
		} else
			return null;
	}

	/**
	 * Touch model.
	 * 
	 * @param elt
	 *            the elt
	 */
	protected void touchModel(Element elt) {
		if (elt instanceof NamedElement) {
			((NamedElement) elt).setName(((NamedElement) elt).getName());
		} else {
			if (elt.getNearestPackage() != null) {
				elt.getNearestPackage().setName(elt.getNearestPackage().getName());
			}
		}
	}

	/**
	 * Adds the reg button pressed.
	 */
	@Override
	protected void addRegButtonPressed() {
		super.addRegButtonPressed();
		touchModel(getSelected());
	}

	/**
	 * Rem button pressed.
	 */
	@Override
	protected void remButtonPressed() {
		// refreshGraphicalStereotypesdisplay((Profile) getProfiles().getData(getProfiles().getItem(getProfiles().getSelectionIndex())));
		removeProfileDisplaying();
		super.remButtonPressed();
		synchroniseGraphicalStereotypesdisplay();
		touchModel(getSelected());
	}

	/**
	 * Adds the button pressed.
	 */
	@Override
	protected void addButtonPressed() {
		super.addButtonPressed();
		// refreshGraphicalStereotypesdisplay(super.profiletoApply);
		synchroniseGraphicalStereotypesdisplay();
		touchModel(getSelected());
	}

	/**
	 * Refresh graphical stereotypesdisplay.
	 */
	protected void synchroniseGraphicalStereotypesdisplay() {

		// /* profile to unapply */
		// // Profile profileToUnapply = (Profile) getProfiles().getData(getProfiles().getItem(getProfiles().getSelectionIndex()));
		// /** update stereotype display list ************************************/
		// // set of uml elements of the package
		// Set<Element> umlElements = PackageUtil.getAllNestedElements((org.eclipse.uml2.uml.Package) getSelected());
		// // add the package to this set
		// umlElements.add(getSelected());
		//
		// // set of diagrams
		// Iterator<Diagram> diagramIter = modelManager.getDiagrams().iterator();
		//
		// // set of graphElements associated to uml elements that are nested
		// // in the package we unapply the profile from
		// ArrayList<GraphElement> filteredGraphElements = new ArrayList<GraphElement>();
		//
		// while (diagramIter.hasNext()) {
		// Diagram diag = diagramIter.next();
		//
		// // list of graphElements of a diagram
		// ArrayList<GraphElement> diagramGraphElements = new ArrayList<GraphElement>();
		// diagramGraphElements = LookForElement.getAllGraphElements(diag, diagramGraphElements);
		//
		// // filter diagramsGraphElements in order to hold graphElements associated to uml elements
		// // of the package which we unapply profile from
		// Iterator<GraphElement> geIter = diagramGraphElements.iterator();
		// while (geIter.hasNext()) {
		// GraphElement ge = geIter.next();
		//
		// // if the diagram element property list is empty, it has not have any stereotype
		// if (ge.getProperty().size() != 0) {
		// if (umlElements.contains(((Uml1SemanticModelBridge) ge.getSemanticModel()).getElement())) {
		// filteredGraphElements.add(ge);
		// }
		// }
		// }
		// }
		//
		// // look for each stereotyped graphElement
		// Iterator<GraphElement> stereotypedGE = filteredGraphElements.iterator();
		// while (stereotypedGE.hasNext()) {
		// GraphElement stGE = stereotypedGE.next();
		// // tempProp contains list of property element of a stereotyped GraphElement
		// ArrayList tempProp = new ArrayList();
		// EList tpList = stGE.getProperty();
		// for (int i = 0; i < tpList.size(); i++) {
		// tempProp.add(tpList.get(i));
		// }
		//
		// Iterator propIter = tempProp.iterator();
		// while (propIter.hasNext()) {
		// com.cea.papyrus.diagraminterchange2.di2.Property prop = (com.cea.papyrus.diagraminterchange2.di2.Property) propIter.next();
		// // This is a Property to display a stereotype?
		// if (prop.getKey().equals(ModelerHelper.PROPERTY_STEREOTYPE_DISPLAY)) {
		// String stName = prop.getValue();
		// // test if the stereotype is not applied
		// if (((Uml1SemanticModelBridge) stGE.getSemanticModel()).getElement().getAppliedStereotype(stName) == null) {
		// stGE.getProperty().remove(prop);
		// }
		// }
		// // remove properties
		// if (prop.getKey().equals(ModelerHelper.PROPERTY_STEREOTYPE_PROPERTY_VALUES_DISPLAY)) {
		// String propName = prop.getValue();
		// // stereotype name
		// String stereoName = propName.substring(0, propName.lastIndexOf("::"));
		// // test if the stereotype is applied
		// if (((Uml1SemanticModelBridge) stGE.getSemanticModel()).getElement().getAppliedStereotype(stereoName) == null) {
		// stGE.getProperty().remove(prop);
		// } else {
		// Stereotype stereo = ((Uml1SemanticModelBridge) stGE.getSemanticModel()).getElement().getAppliedStereotype(stereoName);
		// String simplePropName = propName.replaceAll(stereoName + "::", "");
		// Iterator iterPro = stereo.getAllAttributes().iterator();
		// boolean found = false;
		// while (iterPro.hasNext()) {
		// org.eclipse.uml2.uml.Property tmpProperty = (org.eclipse.uml2.uml.Property) iterPro.next();
		// if (tmpProperty.getName().equals(simplePropName)) {
		// found = true;
		// }
		// }
		//
		// if (found == false) {
		// stGE.getProperty().remove(prop);
		// }
		// }
		// /***** Remove properties display if there is no more properties to display after unapplying this profile *****/
		// // count the number of stereotype properties to display
		// Iterator<com.cea.papyrus.diagraminterchange2.di2.Property> iterProp = stGE.getProperty().iterator();
		// int count = 0;
		// while (iterProp.hasNext()) {
		// com.cea.papyrus.diagraminterchange2.di2.Property diProp = iterProp.next();
		// if (diProp.getKey().equals(ModelerHelper.PROPERTY_STEREOTYPE_PROPERTY_VALUES_DISPLAY)) {
		// count++;
		// }
		// }
		//
		// // is there some properties to display?
		// if (count == 0) {
		// org.eclipse.gef.commands.Command command = DiagramElementDeleteCommandFactory.eINSTANCE.createCommand((GraphNode) LookForElement
		// .getSemanticChildWithoutUmlSemanticAndNoContent(stGE));
		//
		// // getCommandStack
		// CommandStack stack = CommandStackUtils.getCommandStack();
		//
		// Assert.isNotNull(stack, "Impossible to adapt current editor into a CommandStackUtils");
		// stack.execute(command);
		//
		// /*************************************************************************************************************/
		//
		// }
		// }
		// }
		// }
	}

	public void removeProfileDisplaying() {
		// Retrieve indices of selected profiles to unapply
		int[] selectionIndices = getProfiles().getSelectionIndices();
		if ((selectionIndices == null) || (selectionIndices.length == 0)) {
			return;
		}

		// Parse selection
		for (int i = 0; i < selectionIndices.length; i++) {
			int currentIndex = selectionIndices[i];
			// Remove TAG_PROFILE_CHANGED when it exists
			String itemName = getProfiles().getItem(currentIndex).replace(TAG_PROFILE_CHANGED, "");
			Profile profileToUnapply = (Profile) getProfiles().getData(itemName);
			// set of diagrams
			// Iterator<Diagram> diagramIter = modelManager.getDiagrams().iterator();
			// while (diagramIter.hasNext()) {
			// ArrayList found = LookForElement.lookForGraphElement(profileToUnapply, diagramIter.next(), new ArrayList());
			// Iterator founditer = found.iterator();
			// while (founditer.hasNext()) {
			// Command cmd = DiagramElementDeleteCommandFactory.eINSTANCE.createCommand((GraphElement) founditer.next());
			// CommandStackUtils.getCommandStack().execute(cmd);
			// }
			// }
		}

	}
}
