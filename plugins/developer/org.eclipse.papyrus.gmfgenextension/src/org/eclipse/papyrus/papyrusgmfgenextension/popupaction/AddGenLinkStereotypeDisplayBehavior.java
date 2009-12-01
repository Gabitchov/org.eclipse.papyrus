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

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.Behaviour;
import org.eclipse.gmf.codegen.gmfgen.CustomBehaviour;
import org.eclipse.gmf.codegen.gmfgen.CustomParser;
import org.eclipse.gmf.codegen.gmfgen.FeatureLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.GenParserImplementation;
import org.eclipse.gmf.codegen.gmfgen.LabelOffsetAttributes;
import org.eclipse.gmf.codegen.gmfgen.LinkLabelAlignment;
import org.eclipse.gmf.codegen.gmfgen.ParentAssignedViewmap;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IViewPart;

/**
 * Implementation class for AddGenLinkStereotypeDisplayBehavior action
 */
public class AddGenLinkStereotypeDisplayBehavior extends Action {

	public static final String STEREOTYPE_LABEL_POLICY_KEY = "org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLinkLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY"; //$NON-NLS-1$

	public static final String STEREOTYPE_LABEL_POLICY_CLASS = "org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLinkLabelDisplayEditPolicy"; //$NON-NLS-1$

	public static final String DEFAULT_GETTER_NAME = "getAppliedStereotypeLabel"; //$NON-NLS-1$

	public static final String DEFAULT_EDITPART_NAME_SUFFIX = "AppliedStereotypeEditPart"; //$NON-NLS-1$

	public static final String DEFAULT_EDITPOLICY_NAME_SUFFIX = "AppliedStereotypeItemSemanticEditPolicy"; //$NON-NLS-1$

	public static final String DEFAULT_WRAPPING_LABEL_CLASS = "org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel"; //$NON-NLS-1$

	public static final int DEFAULT_OFFSET_X = 0;

	public static final int DEFAULT_OFFSET_Y = 60;

	public static final String DEFAULT_PARSER_PATTERN = "<<{0}>>"; //$NON-NLS-1$

	public static final String APPLIED_STEREOTYPE_CUSTOM_PARSER_CLASS = "org.eclipse.papyrus.diagram.common.parser.stereotype.AppliedStereotypeParser"; //$NON-NLS-1$

	public static final String GEN_CLASS_RT_CLASS = "Node"; //$NON-NLS-1$

	public static final String GEN_CLASS_FACET_META_FEATURE = "NamedElement"; //$NON-NLS-1$

	public static final String GEN_FEATURE_FACET_META_FEATURE = "name"; //$NON-NLS-1$

	public static final String URI_NOTATION_GENMODEL = "org.eclipse.gmf.runtime.notation/model/notation.genmodel"; //$NON-NLS-1$

	public static final String URI_UML_GENMODEL = "org.eclipse.uml2.uml/model/UML.genmodel"; //$NON-NLS-1$

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IViewActionDelegate#init(org.eclipse.ui.IViewPart)
	 */
	public void init(IViewPart view) {
		// NO OP
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {

		// Parse selected GenLink(s) and add the desired CustomBehavior
		Iterator<EObject> it = getSelectedEObject().iterator();
		while (it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof GenLink) {

				// Create the behavior required by stereotype management (if not already created)
				if (!hasCustomBehavior(((GenLink) eObject), STEREOTYPE_LABEL_POLICY_KEY)) {
					addCustomBehavior((GenLink) eObject, STEREOTYPE_LABEL_POLICY_KEY, STEREOTYPE_LABEL_POLICY_CLASS);
				}

				// Create the GenLinkLabel used for stereotypes (if not already created)
				if (!hasCustomLabel((GenLink) eObject)) {
					addCustomLabel((GenLink) eObject);
				}
			}
		}
	}


	

	/**
	 * Add the CustomBehavior for Applied Stereotype label display to the GenLink node given as
	 * parameter
	 * 
	 * @param genlink
	 *            where the CustomBehavior is added
	 */
	private void addCustomLabel(GenLink genlink) {

		// Create a GenLinkLabel
		GenLinkLabel label = GMFGenFactory.eINSTANCE.createGenLinkLabel();
		label.setEditPartClassName(genlink.getClassNamePrefix() + DEFAULT_EDITPART_NAME_SUFFIX);
		label.setItemSemanticEditPolicyClassName(genlink.getClassNamePrefix() + DEFAULT_EDITPOLICY_NAME_SUFFIX);
		label.setAlignment(LinkLabelAlignment.MIDDLE_LITERAL);
		label.setReadOnly(true);

		// Set GenLinkLabel VisualID with new unique ID
		int visualID = SetVisualIDWithUnusedValue.getNewVisualID(genlink.eResource(), GenLinkLabel.class);
		label.setVisualID(visualID);

		// Retrieve DiagramRunTimeClass in notation.genmodel (Node -> View)
		URI uri_notation = URI.createPlatformPluginURI(URI_NOTATION_GENMODEL, false);
		Resource notation = genlink.eResource().getResourceSet().getResource(uri_notation, true);
		label.setDiagramRunTimeClass(findGenClass(notation, GEN_CLASS_RT_CLASS));

		// Create Viewmap
		ParentAssignedViewmap viewmap = GMFGenFactory.eINSTANCE.createParentAssignedViewmap();
		viewmap.setGetterName(DEFAULT_GETTER_NAME);
		viewmap.setFigureQualifiedClassName(DEFAULT_WRAPPING_LABEL_CLASS);

		LabelOffsetAttributes offset = GMFGenFactory.eINSTANCE.createLabelOffsetAttributes();
		offset.setX(DEFAULT_OFFSET_X);
		offset.setY(DEFAULT_OFFSET_Y);

		// Create FeatureLabelModelFacet
		FeatureLabelModelFacet facet = GMFGenFactory.eINSTANCE.createFeatureLabelModelFacet();
		facet.setEditPattern(DEFAULT_PARSER_PATTERN);
		facet.setEditorPattern(DEFAULT_PARSER_PATTERN);
		facet.setViewPattern(DEFAULT_PARSER_PATTERN);
		// Select NamedElement::name property in UML.genmodel for MetaFeatures
		URI uri_uml = URI.createPlatformPluginURI(URI_UML_GENMODEL, false);
		Resource uml = genlink.eResource().getResourceSet().getResource(uri_uml, true);
		facet.getMetaFeatures().add(findGenFeature(uml, GEN_CLASS_FACET_META_FEATURE, GEN_FEATURE_FACET_META_FEATURE));
		facet.setParser(findCustomParser(genlink.getDiagram().getEditorGen(), APPLIED_STEREOTYPE_CUSTOM_PARSER_CLASS));

		// Attach created element one to another in the model
		viewmap.getAttributes().add(offset);
		label.setViewmap(viewmap);
		label.setModelFacet(facet);

		genlink.getLabels().add(label);
	}

	/**
	 * Check if the CustomBehavior for Applied Stereotype label display is already added
	 * 
	 * @param genlink
	 *            the GenLink to test
	 * @return true if the behavior with correct key already exists
	 */
	private boolean hasCustomLabel(GenLink genlink) {

		boolean hasCustomLabel = false;
		String expectedName = genlink.getClassNamePrefix() + DEFAULT_EDITPART_NAME_SUFFIX;

		Iterator<GenLinkLabel> it = genlink.getLabels().iterator();
		while (it.hasNext() && !(hasCustomLabel)) {
			GenLinkLabel genLinkLabel = it.next();

			if (expectedName.equals(genLinkLabel.getEditPartClassName())) {
				hasCustomLabel = true;
			}
		}

		return hasCustomLabel;
	}

	/**
	 * Finds the custom parser used for stereotype display. Creates the parser if not already
	 * existing
	 * 
	 * 
	 * @param gmfgen
	 *            the model owning the parser
	 * @param name
	 *            the parser qualified name
	 * @return the parser node
	 */
	private CustomParser findCustomParser(GenEditorGenerator genEditor, String name) {

		CustomParser customParser = null;

		Iterator<GenParserImplementation> it = genEditor.getLabelParsers().getImplementations().iterator();
		while (it.hasNext() && (customParser == null)) {
			GenParserImplementation parserImpl = it.next();

			if (parserImpl instanceof CustomParser) {
				CustomParser current = (CustomParser) parserImpl;
				if (name.equals(current.getQualifiedName())) {
					customParser = current;
				}
			}
		}

		if (customParser == null) {
			customParser = GMFGenFactory.eINSTANCE.createCustomParser();
			customParser.setQualifiedName(APPLIED_STEREOTYPE_CUSTOM_PARSER_CLASS);
			customParser.setGenerateBoilerplate(false);

			genEditor.getLabelParsers().getImplementations().add(customParser);
		}

		return customParser;
	}


}
