/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.commands;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.commands.CreateEAnnotationCommand;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The Class AddAppliedStereotypeToDisplayCommand used to set the list of
 * applied stereotype to display
 */
public class DefferedAppliedStereotypeToDisplayCommand extends CreateEAnnotationCommand {

	/** The qualified names' stereotypes list . */
	protected String stereotypeList;

	/** the presentation kind of applied stereotypes */
	protected String appliedStereotypePresentationKind;

	/** adapter on which to apply stereotypes */
	protected IAdaptable adapter;

	/**
	 * Instantiates a new sets the applied stereotype to display command.
	 * 
	 * @param domain
	 *        the domain
	 * @param object
	 *        the object
	 * @param stereotypeList
	 *        the stereotype list
	 */
	public DefferedAppliedStereotypeToDisplayCommand(TransactionalEditingDomain domain, IAdaptable adapter, String stereotypeList, String appliedStereotypepresentationKind) {
		super(domain, null, UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);
		this.adapter = adapter;
		this.stereotypeList = stereotypeList;
		this.appliedStereotypePresentationKind = appliedStereotypepresentationKind;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canUndo() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doExecute() {
		View view = (View)adapter.getAdapter(View.class);
		EObject view_element = view.getElement();
		Element element = (Element)view_element;
		Iterator<Stereotype> listStereotype = element.getAppliedStereotypes().iterator();
		StringBuffer buffer = new StringBuffer();
		while(listStereotype.hasNext()) {
			Stereotype stereotypec = listStereotype.next();
			String stereotype_string = stereotypec.getQualifiedName();
			buffer.append(stereotype_string);
			if(listStereotype.hasNext()) {
				buffer.append(",");
			}
		}
		stereotypeList = buffer.toString();

		String stereoList = AppliedStereotypeHelper.getStereotypesToDisplay(view);
		if(!"".equals(stereoList)) {
			stereoList = stereoList + ",";
		}
		stereoList = stereoList + stereotypeList;
		EAnnotation oldAnnotation = view.getEAnnotation(UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);
		if(oldAnnotation == null) {
			oldAnnotation = createEAnnotation();
			attachEannotation(oldAnnotation, view);
		}
		replaceEntry(oldAnnotation, UMLVisualInformationPapyrusConstant.STEREOTYPE_WITHQN_LIST, AppliedStereotypeHelper.getStereotypesQNToDisplay(view));
		replaceEntry(oldAnnotation, UMLVisualInformationPapyrusConstant.STEREOTYPE_LIST, stereoList);
		replaceEntry(oldAnnotation, UMLVisualInformationPapyrusConstant.STEREOTYPE_PRESENTATION_KIND, appliedStereotypePresentationKind);
		replaceEntry(oldAnnotation, UMLVisualInformationPapyrusConstant.PROPERTY_STEREOTYPE_DISPLAY, AppliedStereotypeHelper.getAppliedStereotypesPropertiesToDisplay(view));
		replaceEntry(oldAnnotation, UMLVisualInformationPapyrusConstant.STEREOTYPE_PROPERTY_LOCATION, AppliedStereotypeHelper.getAppliedStereotypesPropertiesLocalization(view));
		replaceEannotation(view.getEAnnotation(UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION), view);

	}

}
