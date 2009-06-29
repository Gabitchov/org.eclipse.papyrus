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

	private static String STEREOTYPE_LABEL_POLICY_KEY = "org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY"; //$NON-NLS-1$

	private static String STEREOTYPE_LABEL_POLICY_CLASS = "org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy"; //$NON-NLS-1$

	private static String DEFAULT_GETTER_NAME = "getAppliedStereotypeLabel"; //$NON-NLS-1$

	private static String DEFAULT_WRAPPING_LABEL_CLASS = "org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel"; //$NON-NLS-1$

	private static int DEFAULT_OFFSET_X = 0;

	private static int DEFAULT_OFFSET_Y = 60;

	private static String DEFAULT_PARSER_PATTERN = "<<{0}>>"; //$NON-NLS-1$

	private static String APPLIED_STEREOTYPE_CUSTOM_PARSER_CLASS = ".custom.parsers.AppliedStereotypeParser"; //$NON-NLS-1$

	private static String GEN_CLASS_RT_CLASS = "Node"; //$NON-NLS-1$

	private static String GEN_CLASS_FACET_META_FEATURE = "NamedElement"; //$NON-NLS-1$

	private static String GEN_FEATURE_FACET_META_FEATURE = "name"; //$NON-NLS-1$

	private static String URI_NOTATION_GENMODEL = "org.eclipse.gmf.runtime.notation/model/notation.genmodel"; //$NON-NLS-1$

	private static String URI_UML_GENMODEL = "org.eclipse.uml2.uml/model/UML.genmodel"; //$NON-NLS-1$

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
				if (!hasCustomBehavior((GenLink) eObject)) {
					addCustomBehavior((GenLink) eObject);
				}

				// Create the GenLinkLabel used for stereotypes (if not already created)
				if (!hasCustomLabel((GenLink) eObject)) {
					addCustomLabel((GenLink) eObject);
				}
			}
		}
	}

	/**
	 * Add the CustomBehavior for Applied Stereotype label display to the GenLink node given as parameter
	 * 
	 * @param genlink
	 *            where the CustomBehavior is added
	 */
	private void addCustomBehavior(GenLink genlink) {

		CustomBehaviour behavior = GMFGenFactory.eINSTANCE.createCustomBehaviour();
		behavior.setKey(STEREOTYPE_LABEL_POLICY_KEY);
		behavior.setEditPolicyQualifiedClassName(STEREOTYPE_LABEL_POLICY_CLASS);

		genlink.getBehaviour().add(behavior);
	}

	/**
	 * Check if the CustomBehavior for Applied Stereotype label display is already added
	 * 
	 * @param genlink
	 *            the GenLink to test
	 * @return true if the behavior with correct key already exists
	 */
	private boolean hasCustomBehavior(GenLink genlink) {

		boolean hasCustomBehavior = false;

		Iterator<Behaviour> it = genlink.getBehaviour().iterator();
		while (it.hasNext() && !(hasCustomBehavior)) {
			Behaviour behaviour = it.next();

			if (behaviour instanceof CustomBehaviour) {
				CustomBehaviour customBehavior = (CustomBehaviour) behaviour;
				if (STEREOTYPE_LABEL_POLICY_KEY.equals(customBehavior.getKey())) {
					hasCustomBehavior = true;
				}
			}
		}

		return hasCustomBehavior;
	}

	/**
	 * Add the CustomBehavior for Applied Stereotype label display to the GenLink node given as parameter
	 * 
	 * @param genlink
	 *            where the CustomBehavior is added
	 */
	private void addCustomLabel(GenLink genlink) {

		// Create a GenLinkLabel
		GenLinkLabel label = GMFGenFactory.eINSTANCE.createGenLinkLabel();
		label.setEditPartClassName("AppliedStereotype" + genlink.getEditPartClassName());
		label.setItemSemanticEditPolicyClassName(genlink.getClassNamePrefix() + "ItemSemanticEditPolicy");
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
		String expectedName = "AppliedStereotype" + genlink.getEditPartClassName();

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
	 * Finds the custom parser used for stereotype display. Creates the parser if not already existing
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
				if (current.getQualifiedName().endsWith(name)) {
					customParser = current;
				}
			}
		}

		if (customParser == null) {
			customParser = GMFGenFactory.eINSTANCE.createCustomParser();
			customParser.setQualifiedName(genEditor.getPackageNamePrefix() + APPLIED_STEREOTYPE_CUSTOM_PARSER_CLASS);
			customParser.setGenerateBoilerplate(false);

			genEditor.getLabelParsers().getImplementations().add(customParser);
		}

		return customParser;
	}

	/**
	 * Find the GenClass node with specified name in the resource model (GenModel expected here)
	 * 
	 * @param resource
	 *            the genmodel
	 * @param name
	 *            of the searched GenClass
	 * @return genClass with chosen name or null
	 */
	private GenClass findGenClass(Resource resource, String name) {

		GenClass genClass = null;
		Iterator<EObject> it = resource.getAllContents();
		while (it.hasNext() && (genClass == null)) {
			EObject eobject = it.next();

			if (eobject instanceof GenClass) {
				GenClass current = (GenClass) eobject;
				if (name.equals(current.getName())) {
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
	 *            the genmodel
	 * @param genClassName
	 *            the name of GenClass owning the searched feature
	 * @param genFeatureName
	 *            the name of the GenFeature
	 * @return the found GenFeature node or null
	 */
	private GenFeature findGenFeature(Resource resource, String genClassName, String genFeatureName) {

		GenFeature genFeature = null;

		Iterator<EObject> it = resource.getAllContents();
		while (it.hasNext() && (genFeature == null)) {
			EObject eobject = it.next();

			if (eobject instanceof GenClass) {
				GenClass genClass = (GenClass) eobject;

				if (genClassName.equals(genClass.getName())) {

					Iterator<GenFeature> itGF = genClass.getAllGenFeatures().iterator();
					while (itGF.hasNext() && (genFeature == null)) {
						GenFeature currentGenFeature = itGF.next();

						if (genFeatureName.equals(currentGenFeature.getEcoreFeature().getName())) {
							genFeature = currentGenFeature;
						}
					}
				}
			}
		}
		return genFeature;
	}
}
