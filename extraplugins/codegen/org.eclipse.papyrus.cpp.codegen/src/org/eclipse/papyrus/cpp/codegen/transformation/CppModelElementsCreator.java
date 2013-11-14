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

import org.eclipse.cdt.core.CCorePlugin;
import org.eclipse.cdt.core.ToolFactory;
import org.eclipse.cdt.core.formatter.CodeFormatter;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.papyrus.C_Cpp.CppRoot;
import org.eclipse.papyrus.C_Cpp.ExternLibrary;
import org.eclipse.papyrus.C_Cpp.External;
import org.eclipse.papyrus.C_Cpp.Include;
import org.eclipse.papyrus.C_Cpp.ManualGeneration;
import org.eclipse.papyrus.C_Cpp.NoCodeGen;
import org.eclipse.papyrus.C_Cpp.Template;
import org.eclipse.papyrus.acceleo.AcceleoDriver;
import org.eclipse.papyrus.acceleo.GenUtils;
import org.eclipse.papyrus.acceleo.ModelElementsCreator;
import org.eclipse.papyrus.cpp.codegen.Activator;
import org.eclipse.papyrus.cpp.codegen.preferences.CppCodeGenUtils;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.util.UMLUtil;



/**
 * Main class of code generator
 */
public class CppModelElementsCreator extends ModelElementsCreator {

	public static final String ACCELEO_PREFIX = "org::eclipse::papyrus::cpp::codegen::acceleo::"; //$NON-NLS-1$

	public static final String CppClassBody = ACCELEO_PREFIX + "CppClassBody"; //$NON-NLS-1$

	public static final String CppClassHeader = ACCELEO_PREFIX + "CppClassHeader"; //$NON-NLS-1$

	public static final String CppBindBody = ACCELEO_PREFIX + "CppBindBody"; //$NON-NLS-1$

	public static final String CppBindHeader = ACCELEO_PREFIX + "CppBindHeader"; //$NON-NLS-1$

	public static final String CppPackageHeader = ACCELEO_PREFIX + "CppPackageHeader"; //$NON-NLS-1$

	public static final String DOT = "."; //$NON-NLS-1$
	
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
			ManualGeneration mg = UMLUtil.getStereotypeApplication(classifier, ManualGeneration.class);
			Include cppInclude = UMLUtil.getStereotypeApplication(classifier, Include.class);
			String fileContent = commentHeader + cppInclude.getHeader();
			createFile(container, classifier.getName() + DOT + hppExt, fileContent, true);

			String manualURI = "TODO"; // fileContent = AcceleoDriver.evaluateURI(new URI(CppPackageHeader)), classifier);

			fileContent = commentHeader + cppInclude.getPreBody() + GenUtils.NL + manualURI + GenUtils.NL + cppInclude.getBody();
			String ext = GenUtils.maskNull(mg.getExtensionBody());
			if(ext.length() == 0) {
				ext = cppExt;
			}
			createFile(container, classifier.getName() + DOT + ext, fileContent, true);
		}

		// Only generate when no CppNoCodeGen stereotype is applied to the class
		else if((!noCodeGen(classifier)) &&
				(!GenUtils.hasStereotype(classifier, Template.class))) {

			// Template Bound Class
			if(GenUtils.isTemplateBoundElement(classifier)) {
				// TODO: Acceleo template is only defined for class (not for all classifiers)
				String fileContent = commentHeader + AcceleoDriver.evaluateURI(CppBindHeader, classifier);
				createFile(container, classifier.getName() + DOT + hppExt, fileContent, true);

				fileContent = commentHeader + AcceleoDriver.evaluateURI(CppBindBody, classifier);
				createFile(container, classifier.getName() + DOT + cppExt, fileContent, true);
			}
			else {
				// Header file generation
				String fileContent = commentHeader + AcceleoDriver.evaluateURI(CppClassHeader, classifier);
				createFile(container, classifier.getName() + DOT + hppExt, fileContent, true);

				// Create class body
				if(classifier instanceof Class) {
					fileContent = commentHeader + AcceleoDriver.evaluateURI(CppClassBody, classifier);
					createFile(container, classifier.getName() + DOT + cppExt, fileContent, true);
				}
			}
		}
	}

	@Override
	protected void createFile(IFile file, String content, boolean force) throws CoreException {
		String formatted = format(content);
		super.createFile(file, formatted, force);
	}

	/**
	 * Apply the user's currently selected formatting options to the input content.  Return the
	 * input String in case of error.
	 */
	private static String format(String content) {

		// do nothing if the CDT plugin is not loaded
		if (Platform.getBundle(CCorePlugin.PLUGIN_ID) == null)
			return content;

		CodeFormatter codeFormatter = ToolFactory.createCodeFormatter(null);
		IDocument doc = new Document(content);

		TextEdit edit = codeFormatter.format(CodeFormatter.K_TRANSLATION_UNIT, doc.get(), 0, doc.get().length(), 0, null);

		if (edit == null) {
			Activator.log.debug("Cannot format content");
			return content;
		}

		try {
			edit.apply(doc);
			return doc.get();
		} catch (MalformedTreeException e) {
			Activator.log.error(e);
		} catch (BadLocationException e) {
			Activator.log.error(e);
		}

		return content;
	}

	@Override
	protected void createPackageFiles(IContainer packageContainer, IProgressMonitor monitor, Package pkg) throws CoreException {
		// Creates the header for the package.
		String fileContent = commentHeader + AcceleoDriver.evaluateURI(CppPackageHeader, pkg);
		createFile(packageContainer, "Pkg_" + pkg.getName() + DOT + hppExt, fileContent, true); //$NON-NLS-1$
	}


	protected boolean isRoot(Namespace ns) {
		return GenUtils.hasStereotype(ns, CppRoot.class);
	}

	protected boolean noCodeGen(Element element) {
		return
			GenUtils.hasStereotype(element, NoCodeGen.class) ||
			GenUtils.hasStereotype(element, External.class) ||
			GenUtils.hasStereotypeTree(element, ExternLibrary.class);
	}
}
