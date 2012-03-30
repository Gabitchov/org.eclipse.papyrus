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

import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.papyrus.java.generator.jdtsynchronizer.GeneratorPreference;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitorException;

/**
 * Allow to generate field in a type
 * 
 * @author Deblock Nicolas & Manuel Giles
 * 
 */
public class SynchJDTField extends SynchJDTCommentable {

	private IType itype;

	private JDTField field;

	private GeneratorPreference preference;

	/**
	 * Constructor
	 * 
	 * @param itype
	 *        the type parent
	 */
	public SynchJDTField(IType itype, GeneratorPreference preference) {
		super();
		this.itype = itype;
		this.preference = preference;
	}

	public void visit(JDTJavaElement element) throws JDTVisitorException {
		// if element can't be generated, we stop all
		if(!element.isGenerated())
			return;

		field = (JDTField)element;

		StringBuffer buffer = new StringBuffer();
		try {
			IField ifield = SynchTools.searchIJavaElement(itype.getFields(), field.getElementName());
			if(ifield == null && field.getType() != null) {
				// first : find the import package
				// create import when it's not a primitive type
				SynchTools.createImport(itype, field.getOwner(), field.getType());


				// visibility
				buffer.append("\n" + SynchTools.getVisibility(field).toString());

				// // if it's an association *
				if(field.isMultiValued())
					buffer.append(SynchTools.getMultiValued(itype, field.getType().getElementName(), preference));
				else
					buffer.append(field.getType().getElementName());


				// create type				
				buffer.append(" " + field.getElementName());

				if(field.getValue() != null) {
					buffer.append(" = ");
					if(field.getType().getElementName().equals("char"))
						buffer.append("'" + field.getValue().toString() + "'");
					else if(field.getType().getElementName().equals("String"))
						buffer.append("\"" + field.getValue().toString() + "\"");
					else
						buffer.append(field.getValue().toString());
				}

				buffer.append(";");

				// create type
				ifield = itype.createField(buffer.toString(), null, true, null);

				// add javadoc to method			
				createJavaDocFor(ifield, ifield.getCompilationUnit(), field.getComment(), "");
			}
			else if(field.getType() == null) {
				System.err.println("No type specified for "
						+ field.getOwner().getQualifiedName()
						+ "." + field.getElementName() );
			}



		} catch (JavaModelException e) {
			e.printStackTrace();
			String msg = "Can't generate field (class='"
					+ field.getOwner().getQualifiedName()
					+ "', msg= " + e.getMessage()
					+ ", buffer=" + buffer.toString()
					+ ")";
			System.err.println(msg);
			throw new JDTVisitorException( msg, e.getCause());
		} catch (Exception e) {
			e.printStackTrace();
			throw new JDTVisitorException(e.getMessage(), e.getCause());
		}
	}

	@Override
	protected BodyDeclaration searchElementToInsert(CompilationUnit cu,
			IJavaElement field) {

		// search Itype parent
		if(field.getParent() instanceof IType) {
			IType itype = (IType)field.getParent();
			// find the good type
			TypeDeclaration type = searchType((TypeDeclaration)cu.types().get(0), itype.getElementName());

			// search the method. Fortunately, there are no method getSignature() for the type FieldDeclaration.
			// So, we search manually
			for(FieldDeclaration fs : type.getFields()) {
				if(fs.toString().contains((field.getElementName())))
					return fs;
			}
		}
		return null;
	}

	@Override
	protected List<String> getJavadocTags() {
		// any javadoc tag
		return null;
	}
}
