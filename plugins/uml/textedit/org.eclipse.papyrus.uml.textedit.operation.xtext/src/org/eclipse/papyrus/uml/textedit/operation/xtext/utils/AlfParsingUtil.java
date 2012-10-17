/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.textedit.operation.xtext.utils;

import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.uml.textedit.operation.xtext.OperationStandaloneSetupGenerated;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Injector;


public class AlfParsingUtil {

	private Injector injector;

	private static final String SYNTHETIC_SCHEME = "synthetic";


	/**
	 * Parses an Alf representation of an operation signature/body and returns an xtext resource (conforming to Operation.ecore). Users should check for parsing
	 * errors (getErrors). The resulting set of eObjects is available via the getContents
	 * operations.
	 * 
	 * @param textualRepresentation
	 *        an Alf textual representation of an operation signature/body
	 * @return a resource relating to the textual representation.
	 */
	public XtextResource getXtextResource(String textualRepresentation) {
		if(injector == null) {
			OperationStandaloneSetupGenerated setup = new OperationStandaloneSetupGenerated();
			injector = setup.createInjectorAndDoEMFRegistration();
		};
		IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
		IGrammarAccess grammarAccess = injector.getInstance(IGrammarAccess.class);

		XtextResource xtextResource = (XtextResource)resourceFactory.createResource(
			URI.createURI(SYNTHETIC_SCHEME + ":/" + grammarAccess.getGrammar().getName() + ".operation"));
		
		try {
			xtextResource.load(new StringInputStream(textualRepresentation, xtextResource.getEncoding()), Collections.emptyMap());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return xtextResource;
	}

	/**
	 * test procedure
	 * 
	 * @param textualRepresentation
	 *        Alf textual representation of an operation signature/body
	 */
	public static void parseTest(String textualRepresentation) {
		AlfParsingUtil parseAlf = new AlfParsingUtil();
		
		String actualRepresentation = "" + textualRepresentation ; 
		
		// In this version of the Alf editor, the stereotype <<TextualRepresentation>> is not implemented yet
		// The serialization prefixes the textual representation with the string "<<TextualRepresentation>>"
		// It must be removed before creating the resource
		if (actualRepresentation.startsWith("<<TextualRepresentation>>")) {
			actualRepresentation = actualRepresentation.substring("<<TextualRepresentation>>".length()) ;
		}
		
		XtextResource xtextResource = parseAlf.getXtextResource(actualRepresentation);
		
		System.out.println("///////////////////////// Test begin") ;
		
		// Display parsing errors
		if(xtextResource.getErrors().size() > 0) {
			for(Resource.Diagnostic error : xtextResource.getErrors()) {
				System.err.println(error);
			}
			return;
		}
		else {
			System.out.println("No parsing errors") ;
		}
		
		// Navigate through eobjects
		EList<EObject> contents = xtextResource.getContents();
		System.out.println("contents.size: " + contents.size());
		// contents normally contains only one eObject of type OperationDefinitionOrStub (i.e. root of the grammar)
		for (EObject o : contents) {
			System.out.println(o) ;
		}
		
		System.out.println("///////////////////////// Test end") ;
	}

}
