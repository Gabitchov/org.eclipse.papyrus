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

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.papyrus.java.generator.jdtsynchronizer.GeneratorPreference;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.TrueFalseDefault;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitorException;

public class SynchJDTGetterSetter extends SynchJDTMethod {

	private JDTField field;

	private GeneratorPreference preference;

	public SynchJDTGetterSetter(IType it, GeneratorPreference preference) {
		super(it, preference);
		this.preference = preference;
	}


	@Override
	public void visit(JDTJavaElement element) throws JDTVisitorException {
		this.field = (JDTField)element;
		// error if field.getType() == null. indicate in console only
		if(field.getType() == null) {
			System.err.println("l31 SunchJDTGetterSetter : field.getType() est null pour " + field.getElementName() + " dans " + field.getOwner().getElementName());
			return;
		}


		try {
			// name of field
			String fieldNameCap = field.getElementName().replaceFirst(".", (field.getElementName().charAt(0) + "").toUpperCase());

			// generate getter
			if(field.getGenerateGetter() == TrueFalseDefault.TRUE || // user demand generate getter
			field.getGenerateGetter() == TrueFalseDefault.DEFAULT && preference.generateGetters()) { // or no demand, look at preferences
				StringBuffer bufferGet = new StringBuffer();

				bufferGet.append("public ");

				// handle MultiValued
				if(field.isMultiValued()) {
					bufferGet.append(SynchTools.getMultiValued(itype, field.getType().getElementName(), preference));
				} else {
					bufferGet.append(field.getType().getElementName());
				}


				bufferGet.append(" get" + fieldNameCap + "() {\n "
						+ "\t return " + field.getElementName() + "; \n} \n");




				IMethod imethod = SynchTools.searchIJavaElement(itype.getMethods(), "get" + fieldNameCap);
				if(imethod == null) {
					IMethod methodGet = itype.createMethod(bufferGet.toString(), null, true, null);
					createJavaDocFor(methodGet, itype.getCompilationUnit(), "Getter of " + field.getElementName(), "");
				}
			}


			// generate setter
			if(field.getGenerateSetter() == TrueFalseDefault.TRUE || // user demand generate setter
			field.getGenerateSetter() == TrueFalseDefault.DEFAULT && preference.generateSetters()) { // or no demand, look at preferences				
				StringBuffer bufferSet = new StringBuffer();

				bufferSet.append("public void set" + fieldNameCap + "(");

				// handle MultiValued
				if(field.isMultiValued()) {
					bufferSet.append(SynchTools.getMultiValued(itype, field.getType().getElementName(), preference));
				} else {
					bufferSet.append(field.getType().getElementName());
				}

				bufferSet.append(" " + field.getElementName() + ") { \n"
						+ "\t this." + field.getElementName() + " = " + field.getElementName() + "; \n} \n ");




				IMethod imethod = SynchTools.searchIJavaElement(itype.getMethods(), "set" + fieldNameCap);
				if(imethod == null) {
					IMethod methodSet = itype.createMethod(bufferSet.toString(), null, true, null);
					createJavaDocFor(methodSet, itype.getCompilationUnit(), "Setter of " + field.getElementName(), "");
				}
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
			throw new JDTVisitorException(e.getMessage(), e.getCause());
		} catch (Exception e) {
			e.printStackTrace();
			throw new JDTVisitorException(e.getMessage(), e.getCause());
		}
	}


	@Override
	// search the method to insert Javadoc
	protected BodyDeclaration searchElementToInsert(CompilationUnit cu,
			IJavaElement method) {

		// search Itype parent
		if(method.getParent() instanceof IType) {
			IType itype = (IType)method.getParent();
			// find the good type
			TypeDeclaration type = searchType((TypeDeclaration)cu.types().get(0), itype.getElementName());

			// search the method. Fortunately, there are no method getSignature() for the type MethodDeclaration.
			// So, we search manually
			for(MethodDeclaration m : type.getMethods())
				if(m.getName().toString().equals(method.getElementName())) {
					// verify the signature	
					return m;
					/*
					 * TODO
					 * if(m.parameters() !=null && m.parameters().size() == 0 && this.method.getParameters().size() == 0)
					 * return m;
					 * if(m.parameters().size() == this.method.getParameters().size()) {
					 * int numParam = 0;
					 * boolean goodSignature = true;
					 * for(Object paramObj : m.parameters()) {
					 * if(paramObj instanceof SingleVariableDeclaration) {
					 * SingleVariableDeclaration param = (SingleVariableDeclaration) paramObj;
					 * if(!param.getType().toString().equals(this.method.getParameters().get(numParam).getType().getElementName()))
					 * goodSignature = false;
					 * 
					 * numParam++;
					 * }
					 * }
					 * if(goodSignature)
					 * return m;
					 * }
					 */
				}
		}

		return null;
	}

}
