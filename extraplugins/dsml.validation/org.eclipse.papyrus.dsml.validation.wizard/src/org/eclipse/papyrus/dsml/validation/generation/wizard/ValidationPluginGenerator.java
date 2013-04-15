/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ernest Wozniak (CEA LIST) ernest.wozniak@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - modification
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.generation.wizard;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.customization.plugin.PluginEditor;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.Category;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintProvider;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintsCategory;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintsManager;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IValidationRule;
import org.eclipse.papyrus.dsml.validation.model.profilenames.Utils;
import org.eclipse.pde.internal.ui.wizards.plugin.NewPluginProjectWizard;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * This is the main class that generates the EMF Validation plugin. It creates
 * extension points and adds required dependencies.
 * 
 * 
 */
public class ValidationPluginGenerator {

	private static final String SEPARATOR = ".";

	private static final String SINGLETON_TRUE = ";singleton := true";

	private static final String EMF_VALIDATION_CONSTRAINT_CHILD = "constraint";

	private static final String ID = "id";

	private static final String OCL_LANGUAGE = "OCL";

	private static final String EMF_VALIDATION_CONSTRAINT_PROVIDERS_EXTENSIONPOINT = "org.eclipse.emf.validation.constraintProviders";

	private static final String UML_PLUGIN = "org.eclipse.uml2.uml";

	private static final String EMF_VALIDATION_PLUGIN = "org.eclipse.emf.validation";

	private static final String UML_URL = "http://www.eclipse.org/uml2/4.0.0/UML";

	//	private final static String contextPrefix = "org.eclipse.papyrus.validation.generation.context";

	/**
	 * singleton
	 */
	public static ValidationPluginGenerator instance = new ValidationPluginGenerator();

	private final static String PLUGIN_NATURE_ID = "org.eclipse.pde.PluginNature"; //$NON-NLS-1$

	private IConstraintsManager constraintsManager;

	/**
	 * generate the java code form constraints contained in the profile
	 * @param project the project eclipse
	 * @param wizard the ref to to wizard
	 * @param constraintsManager the class in charge to collect all information from the model
	 * @throws CoreException
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public void generate(IProject project, NewPluginProjectWizard wizard, IConstraintsManager constraintsManager, EPackage definition) throws CoreException,
	IOException, SAXException, ParserConfigurationException {
		PluginEditor editor;

		String packageName= "org.eclipse.papyrus.validation";
		this.constraintsManager = constraintsManager;

		//prepare the plugin
		editor = new PluginEditor(project);
		editor.setBundleName(editor.getSymbolicBundleName()+SINGLETON_TRUE);

		Set<String> natures = new HashSet<String>();
		natures.add(PLUGIN_NATURE_ID);
		editor.addNatures(natures);

		editor.getManifestEditor().addDependency(EMF_VALIDATION_PLUGIN);
		editor.getManifestEditor().addDependency(UML_PLUGIN);

		Element extension = editor.getPluginEditor().addExtension(EMF_VALIDATION_CONSTRAINT_PROVIDERS_EXTENSIONPOINT);

		//creation of categories extension point
		//that correspond to sub-profiles and stereotypes
		this.createHierarchyOfCategories(packageName,this.constraintsManager.getPrimeCategory(), extension, editor);

		//add the constraint provider extension point, normally it exist only one
		for (IConstraintProvider constraintProvider : constraintsManager.getConstraintsProviders()) {
			//create the extension point for the provider
			Element extElForConstraintsProvider = createExtensionForConstraintsProvider(constraintProvider, extension, editor, definition);
			// go though category  (profile+ stereotype)
			for (IConstraintsCategory constraintCategory : constraintProvider.getConstraintsCategories()) {

				//create the extension point validationRule for category
				Element extElForConstraintsCategory = createExtensionForConstraintsCategory(packageName,
					constraintCategory, extElForConstraintsProvider, editor);

				for (IValidationRule constraint : constraintCategory.getConstraints()) {

					//this is a java constraint?
					if (Utils.hasSpecificationForJava(constraint.getConstraint())) {
						createExtensionForConstraint(packageName,constraint,extElForConstraintsCategory, editor);
					}

					//this is an OCL constraint?
					if (Utils.hasSpecificationForOCL(constraint.getConstraint())) {
						createOCLExtensionForConstraint(constraint,extElForConstraintsCategory, editor);
					}
					//((ValidationRuleImpl) constraint).setParentID();

				}

			}
		}

		generateCommonExtension2(packageName,editor);

		editor.getProject().refreshLocal(0, null);

		try {
			editor.save();
		} catch (Throwable ex) {

			return;
		}
	}

	private Element createExtensionForConstraint(String projectName,IValidationRule constraint,
		Element parentElement, PluginEditor editor) {

		Element extElForConstraint = editor.getPluginEditor().addChild(
			parentElement, EMF_VALIDATION_CONSTRAINT_CHILD);

		extElForConstraint.setAttribute(ID, constraint.getID());
		extElForConstraint.setAttribute("name", constraint.getName());
		extElForConstraint.setAttribute("lang", "Java");
		extElForConstraint.setAttribute("statusCode", constraint.getStatusCode().toString());
		extElForConstraint.setAttribute("severity", constraint.getSeverity().name());

		extElForConstraint.setAttribute("class",projectName+SEPARATOR+constraint.getImplementingClass());

		extElForConstraint.setAttribute("mode", constraint.getMode().name());
		extElForConstraint.setAttribute("isEnabledByDefault",
			String.valueOf(constraint.isEnabledByDefault()));

		if (constraint.getTargets() != null) {
			for (String target : constraint.getTargets()) {
				Element targetExtension = editor.addChild(extElForConstraint,"target");
				targetExtension.setAttribute("class", target);
			}
		}

		if (constraint.getMessage() != null) {
			Element message = editor.addChild(extElForConstraint, "message");
			message.setTextContent(constraint.getMessage());
		}
		else{
			Element message = editor.addChild(extElForConstraint, "message");
			message.setTextContent(constraint.getName() +" not validated");
		}

		if (constraint.getDescription() != null) {
			Element description = editor.addChild(extElForConstraint,
				"description");
			description.setTextContent(constraint.getDescription());
		}

		return extElForConstraint;

	}

	/**
	 * create the extension point for constraint of emf validation
	 * @param validation the validation rule
	 * @param parentElement
	 * @param editor
	 * @return the extension point
	 */
	private Element createOCLExtensionForConstraint(IValidationRule validation,
		Element parentElement, PluginEditor editor) {

		Element extElForConstraint = editor.getPluginEditor().addChild(
			parentElement, EMF_VALIDATION_CONSTRAINT_CHILD);

		extElForConstraint.setAttribute(ID, validation.getID() + OCL_LANGUAGE);
		extElForConstraint.setAttribute("name", validation.getName() + OCL_LANGUAGE);
		extElForConstraint.setAttribute("lang", OCL_LANGUAGE);
		extElForConstraint.setAttribute("statusCode", validation
			.getStatusCode().toString());
		extElForConstraint.setAttribute("severity", validation.getSeverity()
			.name());

		extElForConstraint.setAttribute("mode", validation.getMode().name());
		extElForConstraint.setAttribute("isEnabledByDefault",
			String.valueOf(validation.isEnabledByDefault()));

		if (validation.getTargets() != null) {
			for (String target : validation.getTargets()) {
				Element targetExtension = editor.addChild(extElForConstraint,
					"target");
				targetExtension.setAttribute("class", target);
			}
		}

		if (validation.getMessage() != null) {
			Element message = editor.addChild(extElForConstraint, "message");
			message.setTextContent(validation.getMessage());
		}

		if (validation.getDescription() != null) {
			Element description = editor.addChild(extElForConstraint,
				"description");
			description.setTextContent(validation.getDescription());
		}

		if (Utils.getOCLConstraintBody(validation.getConstraint()) != null) {
			Document doc = editor.getDocument();

			CDATASection cdata = doc.createCDATASection(Utils
				.getOCLConstraintBody(validation.getConstraint()));
			extElForConstraint.appendChild(cdata);
		}

		parentElement.appendChild(extElForConstraint);

		return extElForConstraint;

	}

	public static Document parseXmlFile(String filename, boolean validating) {
		try {
			// Create a builder factory
			DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();
			factory.setValidating(validating);

			// Create the builder and parse the file
			Document doc = factory.newDocumentBuilder().parse(
				new File(filename));
			return doc;
		} catch (SAXException e) {
			// A parsing error occurred; the xml input is not valid
		} catch (ParserConfigurationException e) {
		} catch (IOException e) {
		}
		return null;
	}

	private Element createExtensionForCategory(String projectName, Category category,
		Element parentElement, PluginEditor editor) {

		Element extElForCategory = editor.getPluginEditor().addChild(
			parentElement, "category");

		extElForCategory.setAttribute(ID, projectName+SEPARATOR+category.getID());

		extElForCategory.setAttribute("name",projectName+SEPARATOR+ category.getName());

		extElForCategory.setAttribute("mandatory",String.valueOf(category.isMandatory()));

		return extElForCategory;

	}

	/**
	 * create the constraint provider extension point
	 * @param constraintProvider
	 * @param parentElement
	 * @param editor
	 * @return the extension point
	 */
	private Element createExtensionForConstraintsProvider(
		IConstraintProvider constraintProvider, Element parentElement,
		PluginEditor editor, EPackage definition) {

		Element extElForConstraintsProvider = editor.getPluginEditor().addChild(parentElement, "constraintProvider");

		extElForConstraintsProvider.setAttribute("mode", constraintProvider.getMode().name());

		extElForConstraintsProvider.setAttribute("cache",String.valueOf(constraintProvider.getCache()));

		Element pcg = editor.addChild(extElForConstraintsProvider, "package");
		
		if(definition==null){
			pcg.setAttribute("namespaceUri",UML_URL);
		}
		else{
			pcg.setAttribute("namespaceUri",definition.getNsURI());
			
		}

		return extElForConstraintsProvider;

	}

	private Element createExtensionForConstraintsCategory(
		String projectName,IConstraintsCategory constraintsCategory, Element parentElement,
		PluginEditor editor) {

		Element extElForConstraintsCategory = editor.getPluginEditor()
			.addChild(parentElement, "constraints");
		String list=constraintsCategory.getCategoriesList();
		list= list.replace(", " , ", "+projectName+SEPARATOR);
		list= list.trim();
		list= projectName+SEPARATOR+list;
		extElForConstraintsCategory.setAttribute("categories",list);

		return extElForConstraintsCategory;

	}

	private void generateCommonExtension2(String projectName,PluginEditor editor) {

		Element extension = editor.getPluginEditor().addExtension(
			"org.eclipse.emf.validation.constraintBindings");

		extension.setAttribute(ID,	ValidationPluginGenerator.getContextprefix());

		Element element = editor.getPluginEditor().addChild(extension,"clientContext");
		element.setAttribute(ID,ValidationPluginGenerator.getContextprefix());

		element = editor.getPluginEditor().addChild(element, "selector");
		element.setAttribute("class",projectName+SEPARATOR+"ValidationDelegateClientSelector");

		element = editor.getPluginEditor().addChild(extension, "binding");
		element.setAttribute("context",	ValidationPluginGenerator.getContextprefix());

		this.createCategoriesForBinding(projectName,this.constraintsManager.getPrimeCategory(), element, editor);
	}


	/**
	 * create the extension point categories
	 * @param projectName the name of the project
	 * @param category a category
	 * @param parentElement 
	 * @param editor
	 */
	private void createHierarchyOfCategories(String projectName, Category category,Element parentElement, PluginEditor editor) {

		Element subElement = this.createExtensionForCategory(projectName, category,parentElement, editor);

		for (Category subCategory : category.getSubcategories()) {
			this.createHierarchyOfCategories(projectName,subCategory, subElement, editor);
		}

	}

	private void createCategoriesForBinding(String projectName,Category category,	Element parentElement, PluginEditor editor) {

		Element subElement = editor.addChild(parentElement, "category");
		subElement.setAttribute("ref",projectName+SEPARATOR+ category.getID());

		for (Category subCategory : category.getSubcategories()) {
			this.createCategoriesForBinding(projectName,subCategory, parentElement, editor);
		}

	}

	public static String getContextprefix() {
		return "";
	}
}
