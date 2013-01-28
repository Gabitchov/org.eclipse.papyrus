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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.cpp.codegen.jet.CppBindBody;
import org.eclipse.papyrus.cpp.codegen.jet.CppBindHeader;
import org.eclipse.papyrus.cpp.codegen.jet.CppClassBody;
import org.eclipse.papyrus.cpp.codegen.jet.CppClassHeader;
import org.eclipse.papyrus.cpp.codegen.jet.CppInterfaceHeader;
import org.eclipse.papyrus.cpp.codegen.jet.CppPackageHeader;
import org.eclipse.papyrus.cpp.codegen.jet.CppTemplateHeader;
import org.eclipse.papyrus.cpp.codegen.jet.util.CppClassIncludeDeclaration;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;
import org.eclipse.papyrus.cpp.profile.StUtils;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Usage;

import Cpp.CppExternClass;
import Cpp.CppInclude;
import Cpp.CppNoCodeGen;
import Cpp.CppRoot;
import Cpp.CppTemplate;
import Cpp.ManualGeneration;



/**
 * Main class of code generator
 */
public class ModelElementsCreator {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param project
	 *        the project in which the generated code should be placed
	 * @param hppExt
	 *        The file suffix for c++ header files
	 * @param cppExt
	 *        The file suffix for c++ implementation files
	 * @param headerComment
	 *        Prefix for each generated file
	 */
	public ModelElementsCreator(IProject project, String hppExt, String cppExt, String headerComment) {
		this.hppExt = hppExt;
		this.cppExt = cppExt;
		this.headerComment = headerComment;
		this.project = project;
	}

	private String hppExt;

	private String cppExt;

	private String headerComment;

	private IProject project;

	/**
	 * Main function for user calls. Creates code for a packageable element.
	 * 
	 * @param monitor
	 *        a progress monitor
	 * @param element
	 *        the element for which code should be generated
	 * @throws CoreException
	 */
	public void createPackageableElement(IProgressMonitor monitor, PackageableElement element) throws CoreException {
		IContainer packageContainer = getContainer(element);
		createPackageableElement(packageContainer, monitor, element);
	}

	/**
	 * Variant of main function: user may supply explicit container (also used by internal function to avoid
	 * re-calculating the entry container for each element).
	 * 
	 * @param packageContainer
	 *        The container (directory), in which code should be created
	 * @param monitor
	 *        a progress monitor
	 * @param element
	 *        the element for which code should be generated
	 * @throws CoreException
	 */
	public void createPackageableElement(IContainer packageContainer, IProgressMonitor monitor, PackageableElement element) throws CoreException {
		if(element instanceof Package) {
			createPackage(packageContainer, monitor, (Package)element);
		} else if(element instanceof Class) {
			createClassFiles(packageContainer, (Class)element);
		} else if(element instanceof Interface) {
			createInterfaceFile(packageContainer, (Interface)element);
		} else if((element instanceof PrimitiveType) || (element instanceof Enumeration) || (element instanceof Usage)) {
			// do nothing, included in package
		} else if(element instanceof DataType) {
			createDataTypeFiles(packageContainer, (DataType)element);
		} else if(element instanceof Relationship) {
			// no code generation for relationships
		} else {
			System.err.println("C++ code generator: unsupported model element " + element);
		}
	}

	public void removePackageableElement(IProgressMonitor monitor, PackageableElement element) throws CoreException {
		IContainer packageContainer = getContainer(element);
		if(packageContainer instanceof IFolder) {
			if(element instanceof Package) {
				IFolder folder = ((IFolder)packageContainer).getFolder(element.getName());
				folder.delete(true, null);
			} else if(element instanceof Classifier) {
				IFile file = ((IFolder)packageContainer).getFile(element.getName());
				file.delete(true, null);
			}
		}
	}

	/**
	 * Creates the files corresponding to the class. For a "simple" class
	 * generates 2 headers (one for the privates concrete operations and one for
	 * the attributes, public operations and virtual / abstract operations and
	 * one body file.
	 * 
	 * @param folder
	 * @param classObject
	 * @throws CoreException
	 */
	protected void createClassFiles(IContainer container, Class classObject) throws CoreException {

		// treat case of manual code generation
		if(GenUtils.hasStereotype(classObject, ManualGeneration.class)) {
			ManualGeneration mg = StUtils.getApplication(classObject, ManualGeneration.class);
			CppInclude cppInclude = StUtils.getApplication(classObject, CppInclude.class);
			String fileContent = headerComment + cppInclude.getHeader();
			createFile(container, classObject.getName() + "." + hppExt, fileContent, true);

			CppClassIncludeDeclaration jetIDecl = new CppClassIncludeDeclaration();
			String include = jetIDecl.generate(classObject);

			fileContent = headerComment + cppInclude.getPreBody() + GenUtils.NL + include + GenUtils.NL + cppInclude.getBody();
			String ext = GenUtils.maskNull(mg.getExtensionBody());
			if(ext.length() == 0) {
				ext = cppExt;
			}
			createFile(container, classObject.getName() + "." + ext, fileContent, true);
		}

		// Only generate when no CppNoCodeGen stereotype is applied to the class
		else if((!GenUtils.hasStereotype(classObject, CppNoCodeGen.class)) && (!GenUtils.hasStereotype(classObject, CppExternClass.class)) && (!GenUtils.hasStereotype(classObject, CppTemplate.class))) {

			CppClassHeader headerGenerator = new CppClassHeader();
			CppClassBody bodyGenerator = new CppClassBody();

			// Template Bound Class
			if(GenUtils.isTemplateBoundElement(classObject)) {
				CppBindHeader templateBindingGenerator = new CppBindHeader();
				CppBindBody bodyBindingGenerator = new CppBindBody();
				String fileContent = headerComment + templateBindingGenerator.generate(classObject);
				createFile(container, classObject.getName() + "." + hppExt, fileContent, true);

				fileContent = headerComment + bodyBindingGenerator.generate(classObject);
				createFile(container, classObject.getName() + "." + cppExt, fileContent, true);
			} else {
				if(classObject.isTemplate()) {
					CppTemplateHeader templateGenerator = new CppTemplateHeader();
					String fileContent = headerComment + templateGenerator.generate(classObject);
					createFile(container, classObject.getName() + "." + hppExt, fileContent, true);
				} else {

					// The class is actually a class.

					// Header file generation
					String fileContent = headerComment + headerGenerator.generate(classObject);
					createFile(container, classObject.getName() + "." + hppExt, fileContent, true);

					// "Traditional" code generation : one body file for all
					// operations.
					fileContent = headerComment + bodyGenerator.generate(classObject);
					createFile(container, classObject.getName() + "." + cppExt, fileContent, true);
				}
			}
		}
	}

	/**
	 * Creates the files corresponding to data types.
	 * 
	 * @param container
	 * @param dataTypeObject
	 * @throws CoreException
	 */
	protected void createDataTypeFiles(IContainer container, DataType dataTypeObject) throws CoreException {

		CppClassHeader headerGenerator = new CppClassHeader();
		CppClassBody bodyGenerator = new CppClassBody();

		String fileContent = "";

		// Only generate when no CppNoCodeGen stereotype is applied to the class
		if((!GenUtils.hasStereotype(dataTypeObject, CppNoCodeGen.class)) && (!GenUtils.hasStereotype(dataTypeObject, CppExternClass.class)) && (!GenUtils.hasStereotype(dataTypeObject, CppTemplate.class))) {

			// Template Bound Class
			// templates for data types currently not supported
			/*
			 * if(dataTypeObject.isTemplateBoundElement())
			 * {
			 * CppBindHeader templateBindingGenerator = new CppBindHeader();
			 * CppBindBody bodyBindingGenerator = new CppBindBody();
			 * fileContent = headerComment
			 * + templateBindingGenerator.generate(dataTypeObject);
			 * createFile(container, dataTypeObject.getName() + "." + hpp,
			 * fileContent, true);
			 * 
			 * fileContent = headerComment
			 * + bodyBindingGenerator.generate(dataTypeObject);
			 * createFile(container, dataTypeObject.getName() + "." + cpp,
			 * fileContent, true);
			 * } else {
			 */

			// Header file generation
			fileContent = headerComment + headerGenerator.generate(dataTypeObject);
			createFile(container, dataTypeObject.getName() + "." + hppExt, fileContent, true);

			// "Traditional" code generation : one body file for all
			// operations.
			fileContent = headerComment + bodyGenerator.generate(dataTypeObject);
			createFile(container, dataTypeObject.getName() + "." + cppExt, fileContent, true);
		}
	}

	/**
	 * Creates a <em>text</em> file in an eclipse container (either IFolder or
	 * IProject). If this file already exists it is replaced.
	 * 
	 * @param owner
	 *        the container that will contain the file.
	 * @param filename
	 *        The name of the file to create.
	 * @param content
	 *        Te text content of the file.
	 * @throws CoreException
	 */
	protected void createFile(IContainer owner, String filename, String content, boolean force) throws CoreException {
		IFile file = null;
		if(owner instanceof IProject) {
			file = ((IProject)owner).getFile(filename);
		} else if(owner instanceof IFolder) {
			file = ((IFolder)owner).getFile(filename);
		} else {
			// undefined
		}
		if(file != null) {
			createFile(file, content, force);
		}
	}

	/**
	 * Creates a <em>text</em> file in an eclipse folder. If this file already
	 * exists it is replaced.
	 * 
	 * @param folder
	 *        The folder that will contain the file.
	 * @param filename
	 *        The name of the file to create.
	 * @param content
	 *        Te text content of the file.
	 * @throws CoreException
	 */
	protected void createFile(IFile file, String content, boolean force) throws CoreException {
		if(file.exists() && force) {
			// file.delete(true,true,null);
			// YT - deleting files produce inconsistency in SVN working copies
			final URI locationURI = file.getLocationURI();
			if(locationURI != null) {
				IFileStore store = EFS.getStore(locationURI);
				OutputStream os = store.openOutputStream(0, null);
				try {
					os.write(content.getBytes());
				} catch (IOException e) {
					System.err.println(e);
				}
			}
			// file.setContents(new ByteArrayInputStream(content.getBytes()),
			// true, true, null);
		} else if(file.exists() && !(force)) {
			// the file is not updated
		} else {
			// the file does not exists
			file.create(new ByteArrayInputStream(content.getBytes()), true, null);
		}
	}

	/**
	 * Creates the header file corresponding to the interface
	 * 
	 * @param folder
	 * @param interfaceObject
	 * @throws CoreException
	 */
	protected void createInterfaceFile(IContainer container, Interface interfaceObject) throws CoreException {
		if(!GenUtils.hasStereotype(interfaceObject, CppNoCodeGen.class)) {

			CppInterfaceHeader headerGenerator = new CppInterfaceHeader();
			String fileContent = "";

			fileContent = headerComment + headerGenerator.generate(interfaceObject);
			createFile(container, interfaceObject.getName() + "." + hppExt, fileContent, true);
		}
	}

	/**
	 * Recursively creates folders for a given package
	 * 
	 * @param packageContainer
	 *        The folder where the folder hierarchy for this package will be
	 *        created.
	 * @param monitor
	 *        a progress monitor
	 * @param pkg
	 *        the package for which code should be created
	 * @throws CoreException
	 */
	protected void createPackage(IContainer packageContainer, IProgressMonitor monitor, Package pkg) throws CoreException {
		monitor.subTask("generate package " + pkg.getQualifiedName());

		if(!GenUtils.hasStereotype(pkg, CppRoot.class) && !GenUtils.hasStereotype(pkg, CppNoCodeGen.class)) {

			String fileContent = "";

			packageContainer = (packageContainer instanceof IProject) ? ((IProject)packageContainer).getFolder(pkg.getName()) : ((IFolder)packageContainer).getFolder(pkg.getName());

			// Create a new folder corresponding to the package if it does not exist
			if(!packageContainer.exists()) {
				// if packageContainer is a Project, it necessarily exists
				((IFolder)packageContainer).create(false, true, null);
			}

			// Creates the header for the package.
			CppPackageHeader pkgHeaderGenerator = new CppPackageHeader();
			fileContent = "";
			fileContent = headerComment + pkgHeaderGenerator.generate(pkg);
			createFile(packageContainer, "Pkg_" + pkg.getName() + "." + hppExt, fileContent, true);

			// Continue generation parsing package content
			// If CppNoCodeGen on package, it applies to its content

			for(PackageableElement currentElement : pkg.getPackagedElements()) {
				createPackageableElement(packageContainer, monitor, currentElement);
			}
		}
	}

	/**
	 * Return a container (folder) for a given named element. The folder is embedded into a set
	 * of folders that correspond to the namespaces of the element. These folders will be
	 * created, if the do not exist (comparable to "mkdir -p" in Unix).
	 * 
	 * @param element
	 *        a named element
	 * @return folder for this element
	 */
	public IContainer getContainer(NamedElement element) {
		try {
			IContainer packageContainer = project;
			EList<Namespace> namespaces = element.allNamespaces();
			for(int i = namespaces.size() - 1; i >= 0; i--) {
				Namespace ns = namespaces.get(i);
				if(GenUtils.hasStereotype(ns, CppRoot.class)) {
					// TODO: not very clean. Is this stereotype still used?
					packageContainer = project;
				} else if(packageContainer instanceof IFolder) {
					packageContainer = ((IFolder)packageContainer).getFolder(ns.getName());
				} else if(packageContainer instanceof IProject) {
					packageContainer = ((IProject)packageContainer).getFolder(ns.getName());
				}
				if(!packageContainer.exists()) {
					// if packageContainer is a Project, it necessarily exists
					((IFolder)packageContainer).create(false, true, null);
				}
			}
			return packageContainer;
		} catch (CoreException e) {
			e.printStackTrace();
			return null;
		}
	}
}
