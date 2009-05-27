/****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.codegen;

import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.MetamodelType;
import org.eclipse.gmf.codegen.util.Generator;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.papyrus.codegen.utils.PapyrusGenConstants;

/**
 * The papyrus GMF generator.
 * 
 * @author tlandre
 */
public class PapyrusGenerator extends Generator {

	private final GenDiagram diagram;

	private final PapyrusCodegenEmitters emitters;

	private final static String PREFERENCE_PAGE = "PreferencePage";

	/**
	 * Default constructor
	 * 
	 * @param genModel
	 *            the genmodel to use
	 * @param emitters
	 *            the Papyrus codegen emitters
	 */
	public PapyrusGenerator(GenEditorGenerator genModel, PapyrusCodegenEmitters emitters) {
		super(genModel, emitters);
		this.diagram = genModel.getDiagram();
		this.emitters = emitters;
	}

	@Override
	protected void customRun() throws InterruptedException, UnexpectedBehaviourException {
		super.customRun();

		// Generate IDiagramPreferenceConstant
		generateIDiagramPreferenceConstant();

		// Generate DiagramPreferencePage
		generateDiagramPreferencePage();

		// Generate NodePreferencePage
		for (GenNode node : diagram.getTopLevelNodes()) {
			generateNodePreferencePage(node, node.getElementType().getDisplayName());
		}

		// Generate LinkPreferencePage
		for (GenLink link : diagram.getLinks()) {
			if (link.getElementType() instanceof MetamodelType) {
				MetamodelType metamodelType = (MetamodelType) link.getElementType();
				generateLinkPreferencePage(link, metamodelType.getDisplayName());
			}
		}

	}

	private void generateDiagramPreferencePage() throws InterruptedException, UnexpectedBehaviourException {
		doGenerateJavaClass(emitters.getDiagramPreferencePageEmitter(), diagram.getPreferencesPackageName(), PapyrusGenConstants.getDiagramPreferencePageJavaClassName(diagram.getEditorGen()
				.getModelID()), diagram);
	}

	private void generateIDiagramPreferenceConstant() throws InterruptedException, UnexpectedBehaviourException {
		doGenerateJavaClass(emitters.getIDiagramPreferenceConstantEmitter(), diagram.getPreferencesPackageName(), PapyrusGenConstants.getIDiagramPreferenceConstantJavaClassName(), diagram);
	}

	private void generateNodePreferencePage(GenNode node, String elementName) throws InterruptedException, UnexpectedBehaviourException {
		doGenerateJavaClass(emitters.getNodePreferencePageEmitter(), diagram.getPreferencesPackageName(), elementName + PREFERENCE_PAGE, node);
	}

	private void generateLinkPreferencePage(GenLink link, String elementName) throws InterruptedException, UnexpectedBehaviourException {
		doGenerateJavaClass(emitters.getLinkPreferencePageEmitter(), diagram.getPreferencesPackageName(), elementName + PREFERENCE_PAGE, link);
	}
}
