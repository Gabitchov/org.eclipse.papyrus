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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TagElement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.papyrus.java.generator.jdtsynchronizer.GeneratorPreference;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitor;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitorException;


/**
 * Synchronize a JDTType with JDT.
 * Can create a type to a ICompilationUnit or to a IType (useful for intern class).
 * 
 * @author Deblock Nicolas & Giles Manuel
 * 
 */
public class SynchJDTType extends SynchJDTCommentable {

	/**
	 * Useful to create a type in a ICompilationUnit
	 * If icu is null, itype can't be null
	 */
	private ICompilationUnit icu;

	private GeneratorPreference preference;

	/**
	 * Useful to create a type in a IType
	 * If itype is null, icu can't be null
	 */
	private IType itype;

	/**
	 * Create a type to a ICompilationUnit
	 * 
	 * @param icu
	 */
	public SynchJDTType(ICompilationUnit icu, GeneratorPreference preference) {
		super();
		this.icu = icu;
		this.preference = preference;
	}

	/**
	 * Create a type to a IType (useful for intern class)
	 * 
	 * @param itype
	 */
	public SynchJDTType(IType itype, GeneratorPreference preference) {
		super();
		this.itype = itype;
		this.preference = preference;
	}



	public void visit(JDTJavaElement element) throws JDTVisitorException {
		// if element can't be generated, we stop all
		if(!element.isGenerated())
			return;
		if(SynchTools.isPrimiveType(element.getElementName()) && !element.getElementName().equals("String"))
			return;

		JDTType type = (JDTType)element;

		try {
			IType it = SynchTools.searchIJavaElement(getTypes(), type.getElementName());

			// generate type
			if(it == null) {
				StringBuffer buffer = new StringBuffer();

				buffer.append(SynchTools.getVisibility(type));

				//System.out.println("\n\n \t \t ####### " + type.isEnum());

				if(type.isClass())
					buffer.append("class ");
				else if(type.isInterface())
					buffer.append("interface ");
				else if(type.isEnum()) {

					//System.out.println( type.getFields());

					// generate the field
					StringBuffer fieldStr = new StringBuffer();
					int i = 0;
					for(JDTField field : type.getFields()) {
						if(i > 0)
							fieldStr.append(",\n");
						fieldStr.append("\t" + field.getElementName());
						i++;
					}
					if(!type.getFields().isEmpty())
						fieldStr.append(";\n\n");

					it = createType("public enum " + type.getElementName() + " { \n" + fieldStr + " \n } ", null, true, null);
					return;
					/*
					 * it = createType("public enum " + type.getElementName() + " { \n" +
					 * fieldStr +
					 * "\tprivate final int value;\n\n"+
					 * 
					 * "\tprivate "+ type.getElementName() +"(int value) {\n"+
					 * "\t\tthis.value = value;\n"+
					 * "\t}\n\n"+
					 * 
					 * "\tpublic int getValue() {\n" +
					 * "\t\treturn this.value;\n" +
					 * "\t}\n" +
					 * "\n}", null, true, null);
					 * return;
					 */

				}
				// else, generate nothing
				else
					return;

				buffer.append(type.getElementName());

				if(type.getSuperClass() != null) {
					buffer.append(" extends ");
					buffer.append(type.getSuperClass().getElementName());

				}

				if(type.getSuperInterfaces() != null && type.getSuperInterfaces().size() > 0) {
					if(type.isInterface())
						buffer.append(" extends ");
					else
						buffer.append(" implements ");

					int i = 0;
					for(JDTType superInterface : type.getSuperInterfaces()) {
						if(i != 0)
							buffer.append(", ");
						buffer.append(superInterface.getElementName());
						i++;
					}
				}

				it = createType(buffer.toString() + " { \n\n}", null, true, null);
			}

			// add imports
			if(type.getSuperClass() != null)
				SynchTools.createImport(it, type, type.getSuperClass());

			if(type.getSuperInterfaces() != null)
				for(JDTType superInterface : type.getSuperInterfaces())
					SynchTools.createImport(it, type, superInterface);



			// add javaDoc comment			
			if(type.getComment() != null && !type.getComment().isEmpty()) {
				createJavaDocFor(it, it.getCompilationUnit(), type.getComment(), "");
			}


			// generate field
			if(!type.isEnum()) {
				JDTVisitor visitor = new SynchJDTField(it, preference);
				for(JDTField field : type.getFields())
					field.accept(visitor);
			}

			// generate getters and setters
			JDTVisitor vgettersetter = new SynchJDTGetterSetter(it, preference);
			if(type.isClass()) {
				for(JDTField field : type.getFields()) {
					field.accept(vgettersetter);
				}
			}


			// generate method	
			JDTVisitor vmethod = new SynchJDTMethod(it, preference);
			for(JDTMethod method : type.getMethods()) {
				method.accept(vmethod);
			}

			// The class implements interface methods only if it's not an abstract class
			if(!Flags.isAbstract(type.getFlags())) {

				// recover the superclass
				JDTType superClass = type.getSuperClass();

				// recover the interfaces
				List<JDTType> allSuperInterfaces = getAllSuperInterfaces(type);

				// Implement the abstract methods of the superClass (recursive method)
				if(preference.implementMethodsOfAbstractClass())
					implementSuperClassAbstractMethods(it, superClass);

				// implements interfaces methods of the super-interfaces
				if(preference.implementMethodsOfIntefaces()) {
					for(JDTType superInterface : allSuperInterfaces) {
						for(JDTMethod superInterfaceMethod : superInterface.getMethods()) {
							superInterfaceMethod.accept(vmethod);
						}
					}
				}
			}


			// generate nested class
			JDTVisitor vClass = new SynchJDTType(it, preference);
			for(JDTType child : type.getTypes()) {
				child.accept(vClass);
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
			throw new JDTVisitorException(e.getMessage(), e.getCause());
		} catch (Exception e) {
			e.printStackTrace();
			throw new JDTVisitorException(e.getMessage(), e.getCause());
		}


	}

	/**
	 * get current type
	 * 
	 * @return
	 * @throws JavaModelException
	 */
	private IType[] getTypes() throws JavaModelException {
		if(icu != null)
			return icu.getTypes();
		return itype.getTypes();
	}

	/**
	 * create type for a element 'sibling'
	 * 
	 * @param contents
	 *        the source contents of the type declaration to add
	 * @param sibling
	 *        the existing element which the type will be inserted immediately before (if null, then this type will be inserted as the last type
	 *        declaration
	 * @param force
	 *        a flag in case the same name already exists in this type
	 * @param monitor
	 *        the progress monitor to notify
	 * @return the newly inserted type
	 * @throws JavaModelException
	 */
	private IType createType(String contents, IJavaElement sibling, boolean force, IProgressMonitor monitor) throws JavaModelException
	{
		if(icu != null)
			return icu.createType(contents, sibling, force, monitor);

		return itype.createType(contents, sibling, force, monitor);
	}


	@Override
	protected TypeDeclaration searchElementToInsert(CompilationUnit cu, IJavaElement typeName) {
		if(!(cu.types().get(0) instanceof TypeDeclaration))
			return null;
		TypeDeclaration classType = (TypeDeclaration)cu.types().get(0);
		return searchType(classType, typeName.getElementName());

	}

	@Override
	protected List<String> getJavadocTags() {
		List<String> lst = new LinkedList<String>();
		lst.add(TagElement.TAG_AUTHOR);
		return lst;
	}

	/**
	 * Collect all super interfaces from the super class and the super interfaces (JDTType). Recursive method.
	 * 
	 * @param superClass
	 * @return List of all super interfaces
	 */
	public List<JDTType> getAllSuperInterfaces(JDTType _type) {
		List<JDTType> superInterfaces = new LinkedList<JDTType>();

		// recover its own interfaces
		superInterfaces.addAll(_type.getSuperInterfaces());

		// add interfaces of the super class if it's abstract
		if(_type.getSuperClass() != null && _type.getSuperClass().isAbstract()) {
			superInterfaces.addAll(getAllSuperInterfaces(_type.getSuperClass()));
		}

		// add interfaces of the super interfaces
		for(JDTType superInterface : _type.getSuperInterfaces()) {
			superInterfaces.addAll(getAllSuperInterfaces(superInterface));
		}

		return superInterfaces;
	}

	/**
	 * Implement the abstract methods of the superClass if the superClass is abstract. It's a recursive method on the super class of the super class.
	 * 
	 * @param it
	 * @param superClass
	 * @throws JDTVisitorException
	 */
	public void implementSuperClassAbstractMethods(IType it, JDTType superClass) throws JDTVisitorException {
		if(superClass == null)
			return;

		JDTVisitor vmethod = new SynchJDTMethod(it, preference);

		if(Flags.isAbstract(superClass.getFlags())) {
			for(JDTMethod superClassAbstractMethod : superClass.getMethods()) {
				// Remove the abstract flag to not generate the method with the keyword "abstract"
				superClassAbstractMethod.setAbstract(false);
				superClassAbstractMethod.accept(vmethod);
				superClassAbstractMethod.setAbstract(true);
			}

			// Recursive call on the super class of superClass
			JDTType superClassSuperClass = superClass.getSuperClass();
			if(superClassSuperClass != null)
				implementSuperClassAbstractMethods(it, superClassSuperClass);
		}
	}
}
