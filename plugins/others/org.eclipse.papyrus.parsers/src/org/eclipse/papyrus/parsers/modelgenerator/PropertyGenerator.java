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
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers.modelgenerator;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.RecognitionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.parsers.PapyrusParsersPlugin;
import org.eclipse.papyrus.parsers.antlr.PropertyLabelLexer;
import org.eclipse.papyrus.parsers.antlr.PropertyLabelParser;
import org.eclipse.papyrus.parsers.util.SimpleStringErrorReporter;
import org.eclipse.papyrus.parsers.util.TypeRecognitionException;
import org.eclipse.papyrus.parsers.util.UnboundTemplateRecognitionException;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TemplateableElement;

/**
 * 
 * 
 * @author Remi SCHNEKENBURGER CEA-List
 */
public class PropertyGenerator {

	/**
	 * 
	 */
	private Property property;

	/** Error reporter for lexer and parser generated by antlr */
	private SimpleStringErrorReporter reporter;

	/**
	 * Default Constructor.
	 * 
	 * @param property
	 *        the property to modify
	 */
	public PropertyGenerator(Property property) {
		this.property = property;
		this.reporter = new SimpleStringErrorReporter();
	}

	/**
	 * Parse the label of the property and modify property attributes.
	 * 
	 * @param label
	 *        the label that defines the property
	 */
	public void parseAndModifyProperty(String label) {
		try {
			PropertyLabelLexer lexer = new PropertyLabelLexer(new ANTLRStringStream(label));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			PropertyLabelParser parser = new PropertyLabelParser(tokens, property, new SimpleStringErrorReporter());
			parser.label();
		} catch (RecognitionException e) {
			PapyrusParsersPlugin.getDefault().getLog().log(
					new Status(IStatus.ERROR, PapyrusParsersPlugin.PLUGIN_ID, IStatus.OK,
					"could not parse the property label: " + label, e));
		} catch (RuntimeException e) {
			PapyrusParsersPlugin.getDefault().getLog().log(
					new Status(IStatus.ERROR, PapyrusParsersPlugin.PLUGIN_ID, IStatus.OK,
					"could not parse the property label: " + label, e));
		}
	}

	/**
	 * Parse the label of the property and validate it.
	 * 
	 * @param label
	 *        the label that defines the property
	 * 
	 * @return null if label is valid, else return the message that describes the error.
	 */
	public String parseAndValidateProperty(String label) {
		// to validate the message : parse it. If no errors, it is ok. If exceptions : not ok.
		// Returns the exception message
		PropertyLabelLexer lexer = new PropertyLabelLexer(new ANTLRStringStream(label));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		PropertyLabelParser parser = new PropertyLabelParser(tokens, property, reporter);
		parser.setValidation(true);
		try {
			parser.label();
		} catch (MismatchedTokenException e) {
			//System.err.println("context:" + parser.getContext());
		} catch (RecognitionException e) {
			reporter.setMessage(e.getLocalizedMessage());
		} catch (RuntimeException e) {
			reporter.setMessage(e.getLocalizedMessage());
		}
		return reporter.getMessage();
	}

	/**
	 * Parse the label of the property, and generates an exception if does not validate.
	 * 
	 * @param label
	 *        the label that defines the property
	 * 
	 * @return null if label is valid, else return the message that describes the error.
	 */
	public String parseUndefinedPropertyType(String label) {

		// to validate the message : parse it. If no errors, it is ok. If exceptions : not ok.
		// Returns the exception message
		PropertyLabelLexer lexer = new PropertyLabelLexer(new ANTLRStringStream(label));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		PropertyLabelParser parser = new PropertyLabelParser(tokens, property, new SimpleStringErrorReporter());
		parser.setValidation(true);
		try {
			parser.label();
		} catch (RecognitionException re) {

		} catch (RuntimeException tse) {
			if(tse instanceof TypeRecognitionException)
				return ((TypeRecognitionException)tse).getTypeName();
		}
		return null;
	}

	/**
	 * Parse the label of the property, and generates an exception if does not validate.
	 * 
	 * @param label
	 *        the label that defines the property
	 * 
	 * @return null if label is valid, else return the message that describes the error.
	 */
	public TemplateableElement parseUnboundPropertyType(String label) {

		// to validate the message : parse it. If no errors, it is ok. If exceptions : not ok.
		// Returns the exception message
		PropertyLabelLexer lexer = new PropertyLabelLexer(new ANTLRStringStream(label));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		PropertyLabelParser parser = new PropertyLabelParser(tokens, property, new SimpleStringErrorReporter());
		parser.setValidation(true);
		try {
			parser.label();
		} catch (RecognitionException re) {

		} catch (RuntimeException re) {
			if(re instanceof UnboundTemplateRecognitionException)
				return ((UnboundTemplateRecognitionException)re).getTemplate();
		}
		return null;
	}
}