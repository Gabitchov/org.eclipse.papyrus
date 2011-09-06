/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Initial API and implementation
 * 	Manuel Giles	 giles.manu@live.fr		 - Initial API and implementation
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Idea of the java generator project & help for the conception 
 *
 *****************************************************************************/

package org.eclipse.papyrus.java.generator.jdtsynchronizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContext;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.papyrus.java.generator.jdtsynchronizer.impl.SynchJDTJavaModel;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaModel;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitor;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitorException;
import org.eclipse.papyrus.java.generator.transfo.umltojdt.UmltojdtActivator;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * Class to Run the QVT Transformation, and then the Java generation
 */
public class RunGenerator {

	/**
	 * This is the metamodele
	 */
	private EList<EObject> inObjects;

	/**
	 * Constructor of RunGenerator using .uml file
	 * 
	 * @param UMLFileUrl
	 *        the '.uml' file's url
	 * @throws FileNotFoundException
	 */
	public RunGenerator(String umlFileUrl) throws FileNotFoundException {

		// charge the model of the '.uml' file
		inObjects = loadUmlModel(umlFileUrl);
	}

	/**
	 * Constructor of RunGenerator using EList<EObject> metamodel
	 * 
	 * @param UMLFileUrl
	 *        the '.uml' file's url
	 */
	public RunGenerator(EList<EObject> inObjects) {
		this.inObjects = inObjects;
	}

	/**
	 * run code generation using QVTo transformation
	 * 
	 * @throws JDTVisitorException
	 */
	public void runGeneration(GeneratorPreference preference) throws JDTVisitorException {
		// Refer to an existing transformation via URI
		final URI scriptUri =
				URI.createURI("platform:/plugin/" + UmltojdtActivator.PLUGIN_ID + UmltojdtActivator.PATH_QVT_FILE);

		List<EObject> outObjects = runTransformation(scriptUri, inObjects);

		if(outObjects.size() == 0) {
			throw new JDTVisitorException("No classes or packages produced from the transformation. Nothing is generated.");
		}

		if(outObjects.size() > 1) {
			System.err.println("Warning, JDT modele has more one root");
			for(EObject el : outObjects)
				System.err.println(((JDTJavaElement)el).getElementName());
		}

		//finally, we synchronize the JDT model with org.eclipse.jdt.core
		if(outObjects.size() > 0) {
			/*
			 * TODO : if metamodel have some root node, we make a loop
			 * JDTJavaElement proj = (JDTJavaElement) outObjects.get(0);
			 * 
			 * JDTVisitor visitor = new SynchJDTJavaModel();
			 * proj.accept(visitor);
			 */
			for(Object o : outObjects) {
				if(o instanceof JDTJavaModel) {
					JDTJavaElement proj = (JDTJavaElement)o;
					JDTVisitor visitor = new SynchJDTJavaModel(preference);
					proj.accept(visitor);
				}

			}
		}
	}

	/**
	 * Run QVTo transformation using the scriptUri and the inObjects model
	 * 
	 * @param scriptUri
	 *        The script QVTo
	 * @param inObjects
	 *        The entry model
	 * @return The output model
	 */
	private List<EObject> runTransformation(URI scriptUri, EList<EObject> inObjects) {
		// initialise the transformation		
		//First, you need to instantiate a Registry:
		EPackage.Registry registry = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);

		//which is used to register the meta-models in E:\workspace\modelesUML\org.eclipse.papyrus.java.javagen.mmJDT\metaModel

		JdtmmPackage mm1 = (JdtmmPackage)JdtmmPackage.eINSTANCE;
		registry.put(mm1.getNsURI(), mm1);

		// class which allow to execute the transformation
		TransformationExecutor t = new TransformationExecutor(scriptUri, registry);
		ExecutionContext executionContext = new ExecutionContextImpl();

		// allow to contains the model uml
		ModelExtent input = new BasicModelExtent(inObjects);
		ModelExtent output = new BasicModelExtent();
		// make the transformation
		ExecutionDiagnostic executionDiagnostic = t.execute(executionContext, input, output);

		// the errors
		System.out.println(executionDiagnostic.getMessage());
		for(Diagnostic d : executionDiagnostic.getChildren())
			System.out.println(d.getMessage());


		// we take the out JDT model in a list		
		return output.getContents();
	}


	/**
	 * Allow to charge the uml model in a list
	 * 
	 * @param url
	 *        the '.uml' file's url
	 * @return the charge model
	 * @throws FileNotFoundException
	 */
	private EList<EObject> loadUmlModel(String url) throws FileNotFoundException {

		ResourceSet resourceSet = new ResourceSetImpl();

		// charge the metamodel util for read the model
		resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		//Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap( ).put( "uml", new UMLResourceFactoryImpl());

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		URIConverter.URI_MAP.put(URI.createURI("pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml"), URI.createFileURI(System.getProperty("user.dir") + "/Model_Libs/UMLPrimitiveTypes.library.uml"));

		// the '.uml' file's url
		File file = new File(url);
		if(!file.exists())
			throw new FileNotFoundException("File " + new File(url).getAbsolutePath() + " not found");
		URI fileURI = URI.createFileURI(new File(url).getAbsolutePath());

		// demand load the resource for this file.
		Resource resource = resourceSet.getResource(fileURI, true);

		return resource.getContents();
	}
}
