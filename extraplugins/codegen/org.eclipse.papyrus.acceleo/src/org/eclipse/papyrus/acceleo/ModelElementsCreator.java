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

package org.eclipse.papyrus.acceleo;

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
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Usage;


/**
 * Main class of code generator. This is an abstract class that is supposed to be overriden by language specific code generators
 */
abstract public class ModelElementsCreator {

	/**
	 * Creates the files corresponding to the class. For a "simple" class
	 * generates 2 headers (one for the privates concrete operations and one for
	 * the attributes, public operations and virtual / abstract operations and
	 * one body file.
	 * 
	 * @param folder
	 * @param classifier
	 * @throws CoreException
	 */
	abstract protected void createClassifierFiles(IContainer container, Classifier classifier) throws CoreException;

	/**
	 * Create the files for a package
	 * 
	 * @param packageContainer
	 * @param monitor
	 * @param pkg
	 * @throws CoreException
	 */
	abstract protected void createPackageFiles(IContainer packageContainer, IProgressMonitor monitor, Package pkg) throws CoreException;

	/**
	 * Boolean that returns whether a namespace is a root element. This function is currently not well supported, return false, if in doubt
	 * 
	 * @param ns
	 * @return
	 */
	abstract protected boolean isRoot(Namespace ns);

	/**
	 * Return true, if no code should be generated for a certain element
	 * 
	 * @param element
	 * @return
	 */
	abstract protected boolean noCodeGen(Element element);

	/**
	 * 
	 * Constructor.
	 * 
	 * @param project
	 *        the project in which the generated code should be placed
	 * @param headerComment
	 *        Prefix for each generated file
	 */
	public ModelElementsCreator(IProject project, String headerComment) {
		this.project = project;
		this.commentHeader = headerComment;
	}

	protected String commentHeader;

	protected IProject project;

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
		}
		else if((element instanceof PrimitiveType) || (element instanceof Enumeration) || (element instanceof Usage)) {
			// do nothing, included in package
		}
		else if(element instanceof Classifier) {
			createClassifierFiles(packageContainer, (Classifier)element);
		}
		else if(element instanceof Relationship) {
			// no code generation for relationships
		} else {
			System.err.println("C++ code generator: unsupported model element " + element);
		}
	}


	/**
	 * Remove elements (used for differential code generation)
	 * 
	 * @param monitor
	 * @param element
	 * @throws CoreException
	 */
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

		if(!isRoot(pkg) && !noCodeGen(pkg)) {

			String fileContent = "";

			packageContainer = (packageContainer instanceof IProject) ? ((IProject)packageContainer).getFolder(pkg.getName()) : ((IFolder)packageContainer).getFolder(pkg.getName());

			// Create a new folder corresponding to the package if it does not exist
			if(!packageContainer.exists()) {
				// if packageContainer is a Project, it necessarily exists
				((IFolder)packageContainer).create(false, true, null);
			}

			createPackageFiles(packageContainer, monitor, pkg);

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
				if(isRoot(ns)) {
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
