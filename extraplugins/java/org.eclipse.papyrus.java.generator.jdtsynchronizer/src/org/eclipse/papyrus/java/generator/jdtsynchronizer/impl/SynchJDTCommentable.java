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

package org.eclipse.papyrus.java.generator.jdtsynchronizer.impl;

import java.util.List;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.TagElement;
import org.eclipse.jdt.core.dom.TextElement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitor;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;

/**
 * Useful for class who have to generate Javadoc comment.
 * 
 * @author Deblock Nicolas & Manuel Giles
 * 
 */
public abstract class SynchJDTCommentable implements JDTVisitor {


	/**
	 * search the element to insert the Javadoc in compilation unit
	 * 
	 * @param cu
	 * @param typeName
	 * @return
	 */
	protected abstract BodyDeclaration searchElementToInsert(CompilationUnit cu, IJavaElement elementName);

	/**
	 * return javaDoc tag to add. Call in function createJavaDocFor()
	 * 
	 * @return javaDoc tag to add in a List<String> with String = "@tag comment"
	 */
	protected abstract List<String> getJavadocTags();

	/**
	 * Reads a ICompilationUnit and creates the AST DOM for manipulating the
	 * Java source file
	 * 
	 * @param unit
	 * @return
	 */
	private static CompilationUnit parse(ICompilationUnit unit) {
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(unit);
		parser.setResolveBindings(true);
		return (CompilationUnit)parser.createAST(null); // parse
	}


	/**
	 * Create a JavaDoc for a a objet who extends IJavaElement and IMethod
	 * (IType or IMethod by example)
	 * 
	 * @param ielement
	 *        the element you want add javadoc
	 * @param icu
	 *        the compilation unit of ielement
	 * @param comment
	 *        body of the comment
	 * @param auteur
	 *        author of the compilation unit
	 * @throws JavaModelException
	 * @throws BadLocationException
	 * @throws MalformedTreeException
	 */
	protected <U extends IJavaElement> void createJavaDocFor(U ielement, ICompilationUnit icu, String comment, String author) throws JavaModelException, MalformedTreeException, BadLocationException {

		CompilationUnit cu = parse(icu);
		// Authorize modification
		cu.recordModifications();
		// create document
		Document document = new Document(icu.getBuffer().getContents());

		// Creating the new JavaDoc node 
		AST ast = cu.getAST();
		Javadoc jc = ast.newJavadoc();

		TagElement tag = ast.newTagElement();
		if(comment != null) {
			TextElement te = ast.newTextElement();
			tag.fragments().add(te);
			te.setText(comment);
		}
		jc.tags().add(tag);

		List<String> javadocTags = getJavadocTags();
		if(javadocTags != null) {
			for(String s : javadocTags) {
				tag = ast.newTagElement();
				tag.setTagName(s);
				jc.tags().add(tag);
			}
		}
		// add javadoc to type
		BodyDeclaration classType = searchElementToInsert(cu, ielement);
		if(classType != null) {
			classType.setJavadoc(jc);
		}

		// Applying changes
		TextEdit text = cu.rewrite(document, icu.getJavaProject().getOptions(true));
		text.apply(document);

		// set buffer of compilation unit
		icu.getBuffer().setContents(document.get());

	}

	/**
	 * search type in type declaration
	 * 
	 * @param classType
	 *        type declaration
	 * @param typeName
	 *        typeName type name research
	 * @return
	 */
	protected TypeDeclaration searchType(TypeDeclaration classType, String typeName) {
		if(classType.getName().toString().equals(typeName))
			return classType;

		for(Object objct : classType.getTypes()) {
			TypeDeclaration ct = (TypeDeclaration)objct;
			if(ct.getName().toString().equals(typeName))
				return ct;
			searchType(ct, typeName);
		}
		return null;
	}
}
