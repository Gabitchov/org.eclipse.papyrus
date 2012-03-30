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


import java.util.LinkedList;
import java.util.List;

import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.TagElement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.papyrus.java.generator.jdtsynchronizer.GeneratorPreference;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethodBody;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitorException;


/**
 * Allow to generate Method in a IType
 * 
 * @author Deblock Nicolas & Manuel Giles
 * 
 */
public class SynchJDTMethod extends SynchJDTCommentable {

	protected IType itype;

	private JDTMethod method;

	private GeneratorPreference preference;

	/**
	 * Constructor
	 * 
	 * @param itype
	 *        the type parent
	 */
	public SynchJDTMethod(IType itype, GeneratorPreference preference) {
		super();
		this.itype = itype;
		this.preference = preference;
	}



	public void visit(JDTJavaElement element) throws JDTVisitorException {
		// if element can't be generated, we stop all
		if(!element.isGenerated())
			return;

		method = (JDTMethod)element;
		//IntroduceParameterObjectDescript
		IMethod imethod = null;

		try {
			// See if the method exist
			boolean createMethod = true;

			for(IMethod m : itype.getMethods()) {
				// if it's the same name, and the same parameterTypes, the method exist 
				if(m.getElementName().equals(method.getElementName()) && m.getSignature().equals(method.getJDTSignature())) {
					// stop all
					createMethod = false;
					imethod = m;
					break;
				}
			}

			if(createMethod) {
				StringBuffer methodStr = new StringBuffer("\n");

				// visibility
				if(itype.isInterface()) // for a interface, there are only public method!
					methodStr.append("public ");
				else
					methodStr.append(SynchTools.getVisibility(method).toString());

				// if method is a constructor, no return Type, and name is class name
				if(method.isConstructor()) {
					methodStr.append(itype.getElementName() + "(");
				}
				else {
					// return type
					if(method.getReturnType() != null)
						methodStr.append(method.getReturnType().getType().getElementName() + " ");
					else
						methodStr.append("void ");
					// method name
					methodStr.append(method.getElementName() + "(");
				}
				// parameters
				//System.out.println(method.getParam() + " " + method.getParameterTypes());
				int nbParam = 0;
				for(JDTParameter p : method.getParameters()) {
					String typeName = p.getElementName();
					String type = "Undefined";
					if(p.getType() != null) {
						type = null;
						if(p.isMultiValued())
							type = SynchTools.getMultiValued(itype, p.getType().getElementName(), preference);
						else
							type = p.getType().getElementName();
						// put the import package	
						SynchTools.createImport(itype, method.getOwner(), p.getType());
					}


					if(nbParam > 0)
						methodStr.append(", ");
					methodStr.append(type + " " + typeName);
					nbParam++;
				}

				// close
				methodStr.append(")");

				// throws				
				if(method.getExceptions() != null && method.getExceptions().size() > 0) {
					methodStr.append(" throws ");
					int nbExc = 0;
					for(JDTType exception : method.getExceptions()) {
						if(nbExc > 0)
							methodStr.append(", ");
						methodStr.append(exception.getElementName());
						if(!SynchTools.isPrimiveType(exception.getQualifiedName()) && exception.getQualifiedName().contains("."))
							itype.getCompilationUnit().createImport(exception.getQualifiedName(), null, null);
						nbExc++;
					}
				}


				// Do we need a body ?
				if(itype.isInterface() || Flags.isAbstract(method.getFlags())) {
					methodStr.append(";");
				}
				else {
					// Generate Body. Open the body
					methodStr.append(" {");
					// If there is a declared body, use it. Otherwise, use the default body.
					if( method.getBodies().size() >0) {

						for( JDTMethodBody body : method.getBodies()) {
							methodStr.append("\n\t");
							methodStr.append(body.asText());
						}
//						methodStr.append("\n");
					} 
					else {
						// Default body
						methodStr.append(" \n\t// TODO Auto-generated method");
						if(method.getReturnType() != null)
							methodStr.append("\n\treturn " + SynchTools.defaultReturn(method.getReturnType().getType().getElementName()) + ";");

					}
					// Close the body
					methodStr.append("\n }");
				}

				// create the method
				imethod = itype.createMethod(methodStr.toString(), null, true, null);
			}

			// add javadoc to method			
			createJavaDocFor(imethod, imethod.getCompilationUnit(), method.getComment(), "");
		} catch (JavaModelException e) {
			e.printStackTrace();
			throw new JDTVisitorException(e.getMessage(), e.getCause());
		} catch (Exception e) {
			e.printStackTrace();
			throw new JDTVisitorException(e.getMessage(), e.getCause());
		}


	}




	/** *************** methods override by SynchJDTCommentable ************** */


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
					if(m.parameters() != null && m.parameters().size() == 0 && this.method.getParameters().size() == 0)
						return m;
					if(m.parameters().size() == this.method.getParameters().size()) {
						int numParam = 0;
						boolean goodSignature = true;
						for(Object paramObj : m.parameters()) {
							if(paramObj instanceof SingleVariableDeclaration) {
								SingleVariableDeclaration param = (SingleVariableDeclaration)paramObj;
								if(!param.getType().toString().equals(this.method.getParameters().get(numParam).getType().getElementName()))
									goodSignature = false;

								numParam++;
							}
						}
						if(goodSignature)
							return m;
					}
				}
		}

		return null;
	}

	@Override
	protected List<String> getJavadocTags() {
		List<String> lst = new LinkedList<String>();
		if(method == null)
			return lst;

		// parameters
		for(JDTParameter param : method.getParameters()) {
			String comment = param.getComment();
			if(comment == null)
				comment = "";
			lst.add(TagElement.TAG_PARAM + " " + param.getElementName() + " " + comment);
		}

		// return
		if(method.getReturnType() != null) {
			String comment = method.getReturnType().getComment();
			if(comment == null)
				comment = "";
			lst.add(TagElement.TAG_RETURN + " " + comment);
		}

		// exception
		// TODO prendre en compte notion de commentaire		
		if(method.getExceptions() != null) {
			for(JDTType exception : method.getExceptions()) {
				//String comment = exception.getComment();
				//if(comment == null) comment = "";
				lst.add(TagElement.TAG_THROWS + " " + exception.getElementName());
			}
		}



		return lst;
	}

}
