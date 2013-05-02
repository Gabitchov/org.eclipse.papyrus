/*******************************************************************************
 * Copyright (c) 2006 - 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.cpp.codegen.transformation;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.C_Cpp.CppRoot;
import org.eclipse.papyrus.C_Cpp.ExternClass;
import org.eclipse.papyrus.C_Cpp.Include;
import org.eclipse.papyrus.C_Cpp.ManualGeneration;
import org.eclipse.papyrus.C_Cpp.NoCodeGen;
import org.eclipse.papyrus.C_Cpp.Template;
import org.eclipse.papyrus.acceleo.AcceleoDriver;
import org.eclipse.papyrus.acceleo.ModelElementsCreator;
import org.eclipse.papyrus.cpp.codegen.preferences.CppCodeGenUtils;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;
import org.eclipse.papyrus.cpp.profile.StUtils;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;



/**
 * Main class of code generator
 */
public class CppModelElementsCreator extends ModelElementsCreator {

	public static final String ACCELEO_PREFIX = "org::eclipse::papyrus::cpp::codegen::acceleo::";

	public static final String CppClassBody = ACCELEO_PREFIX + "CppClassBody";

	public static final String CppClassHeader = ACCELEO_PREFIX + "CppClassHeader";

	public static final String CppBindBody = ACCELEO_PREFIX + "CppBindBody";

	public static final String CppBindHeader = ACCELEO_PREFIX + "CppBindHeader";

	public static final String CppPackageHeader = ACCELEO_PREFIX + "CppPackageHeader";

	/**
	 * 
	 * Constructor.
	 * 
	 * @param project
	 *        the project in which the generated code should be placed
	 */
	public CppModelElementsCreator(IProject project) {
		super(project, CppCodeGenUtils.getCommentHeader());
		hppExt = CppCodeGenUtils.getHeaderSuffix();
		cppExt = CppCodeGenUtils.getBodySuffix();
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param project
	 *        the project in which the generated code should be placed
	 * @param commentHeader
	 *        Custom prefix for each generated file
	 */
	public CppModelElementsCreator(IProject project, String commentHeader) {
		super(project, commentHeader);
		hppExt = CppCodeGenUtils.getHeaderSuffix();
		cppExt = CppCodeGenUtils.getBodySuffix();
	}


	protected String hppExt;

	protected String cppExt;


	/**
	 * Creates the files corresponding to the class. For a "simple" class
	 * generates 2 headers (one for the privates concrete operations and one for
	 * the attributes, public operations and virtual / abstract operations and
	 * one body file.
	 * 
	 * @param folder
	 * @param classifier
	 * @throws CoreException
	 */
	protected void createClassifierFiles(IContainer container, Classifier classifier) throws CoreException {

		// treat case of manual code generation
		if(GenUtils.hasStereotype(classifier, ManualGeneration.class)) {
			ManualGeneration mg = StUtils.getApplication(classifier, ManualGeneration.class);
			Include cppInclude = StUtils.getApplication(classifier, Include.class);
			String fileContent = commentHeader + cppInclude.getHeader();
			createFile(container, classifier.getName() + "." + hppExt, fileContent, true);

			String manualURI = "TODO"; // fileContent = AcceleoDriver.evaluateURI(new URI(CppPackageHeader)), classifier);

			fileContent = commentHeader + cppInclude.getPreBody() + GenUtils.NL + manualURI + GenUtils.NL + cppInclude.getBody();
			String ext = GenUtils.maskNull(mg.getExtensionBody());
			if(ext.length() == 0) {
				ext = cppExt;
			}
			createFile(container, classifier.getName() + "." + ext, fileContent, true);
		}

		// Only generate when no CppNoCodeGen stereotype is applied to the class
		else if((!GenUtils.hasStereotype(classifier, NoCodeGen.class)) && (!GenUtils.hasStereotype(classifier, ExternClass.class)) && (!GenUtils.hasStereotype(classifier, Template.class))) {

			// Template Bound Class
			if(GenUtils.isTemplateBoundElement(classifier)) {
				// TODO: Acceleo template is only defined for class (not for all classifiers)
				String fileContent = commentHeader + AcceleoDriver.evaluateURI(CppBindHeader, classifier);
				createFile(container, classifier.getName() + "." + hppExt, fileContent, true);

				fileContent = commentHeader + AcceleoDriver.evaluateURI(CppBindBody, classifier);
				createFile(container, classifier.getName() + "." + cppExt, fileContent, true);
			}
			else {
				// Header file generation
				String fileContent = commentHeader + AcceleoDriver.evaluateURI(CppClassHeader, classifier);
				createFile(container, classifier.getName() + "." + hppExt, fileContent, true);

				// Create class body
				if(classifier instanceof Class) {
					fileContent = commentHeader + AcceleoDriver.evaluateURI(CppClassBody, classifier);
					createFile(container, classifier.getName() + "." + cppExt, fileContent, true);
				}
			}
		}
	}


	protected void createPackageFiles(IContainer packageContainer, IProgressMonitor monitor, Package pkg) throws CoreException {
		// Creates the header for the package.
		String fileContent = commentHeader + AcceleoDriver.evaluateURI(CppPackageHeader, pkg);
		createFile(packageContainer, "Pkg_" + pkg.getName() + "." + hppExt, fileContent, true);
	}


	protected boolean isRoot(Namespace ns) {
		return GenUtils.hasStereotype(ns, CppRoot.class);
	}

	protected boolean noCodeGen(Element element) {
		return GenUtils.hasStereotype(element, NoCodeGen.class);
	}
}
