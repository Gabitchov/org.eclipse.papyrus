/**
 * 
 */
package org.eclipse.papyrus.java.reverse.ui;

import java.io.StringReader;
import java.util.List;

import javagen.umlparser.CompilationUnitAnalyser;
import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.uml2.uml.Package;

/**
 * @author dumoulin
 * 
 */
public class JavaCodeReverse {

	CompilationUnitAnalyser javaAnalyser;

	/**
	 * Constructor.
	 * 
	 * @param model
	 */
	public JavaCodeReverse(Resource model) {
		javaAnalyser = new CompilationUnitAnalyser(model);
	}

	/**
	 * Constructor.
	 * 
	 * @param model
	 */
	public JavaCodeReverse(Package rootPackage, String generatedPackageName, List<String> searchPaths) {
		javaAnalyser = new CompilationUnitAnalyser(rootPackage, generatedPackageName, searchPaths);
	}


	/**
	 * @throws CoreException
	 * @throws ParseException
	 * 
	 */
	public void reverseResource(IResource resource) throws ParseException, CoreException {
		System.out.println("reverseResource(" + resource.getName() + ")");

		if(resource instanceof IFile) {
			reverseFile((IFile)resource);
		} else if(resource instanceof IFolder) {
			reverseFolder((IFolder)resource);
		} else if(resource instanceof IProject) {
			reverseProject((IProject)resource);
		}

	}

	/**
	 * Walk throw each file in folder
	 * 
	 * @param resource
	 * @param model
	 * @throws CoreException
	 * @throws ParseException
	 */
	private void reverseFolder(IFolder folder) throws CoreException, ParseException {

		for(IResource resource : folder.members()) {
			reverseResource(resource);
		}

	}

	/**
	 * Walk throw each file in folder
	 * 
	 * @param resource
	 * @param model
	 * @throws CoreException
	 * @throws ParseException
	 */
	private void reverseProject(IProject folder) throws CoreException, ParseException {

		for(IResource resource : folder.members()) {
			reverseResource(resource);
		}

	}

	/**
	 * Reverse a file
	 * 
	 * @param resource
	 * @throws CoreException
	 * @throws ParseException
	 */
	private void reverseFile(IFile file) throws ParseException, CoreException {
		System.out.println("try to reverseFile(" + file.getName() + ")");
		if(!"java".equals(file.getFileExtension())) {
			return;
		}

		System.out.println("reverseFile(" + file.getName() + ")");

		CompilationUnit cu = JavaParser.parse(file.getContents());
		javaAnalyser.processCompilationUnit(cu);
	}
	
	/**
	 * @throws CoreException 
	 * @throws ParseException 
	 * 
	 */
	public void reverseJavaElement( IJavaElement element) throws ParseException, CoreException
	{
		System.out.println("reverseJavaElement("+element.getElementName()+")");

		if(element instanceof ITypeRoot)
		{
			reverseCompilationUnit((ITypeRoot)element);
		}
		else if(element instanceof IPackageFragment)
		{
			reversePackageFragment((IPackageFragment)element);
		}
		else if(element instanceof IPackageFragmentRoot)
		{
			reversePackageFragmentRoot((IPackageFragmentRoot)element);
		}
		else
		{
			System.err.println("Can't reverse Java Element " + element);
		}
		
	}

	/**
	 * 
	 * @param element
	 * @throws ParseException
	 * @throws CoreException
	 */
	private void reversePackageFragmentRoot(IPackageFragmentRoot element) throws ParseException, CoreException {

		System.out.println("reversePackageFragmentRoot("+element.getElementName()+")");

		IJavaElement[] children = element.getChildren();
		for( IJavaElement child : children) {
			reverseJavaElement(child);
		}
		
	}

	/**
	 * 
	 * @param element
	 * @throws ParseException
	 * @throws CoreException
	 */
	private void reversePackageFragment(IPackageFragment element) throws ParseException, CoreException {
		
		System.out.println("reversePackageFragment("+element.getElementName()+")");

		IJavaElement[] children = element.getChildren();
		for( IJavaElement child : children) {
			reverseJavaElement(child);
		}
	}

	/**
	 * Reverse a file
	 * @param resource
	 * @throws CoreException 
	 * @throws ParseException 
	 */
	private void reverseCompilationUnit(ITypeRoot unit) throws ParseException, CoreException {
		System.out.println("try to reverseUnit("+unit.getElementName()+")");
		System.out.println("file type=("+unit.getElementType()+")");
		
		String source = unit.getSource();
		if( source == null)
		{
			System.err.println("No source attached to unit '" + unit.getElementName() + "'");
			return;
		}
		
		
		CompilationUnit cu = JavaParser.parse(new StringReader(source));
		javaAnalyser.processCompilationUnit(cu);
	}


}
