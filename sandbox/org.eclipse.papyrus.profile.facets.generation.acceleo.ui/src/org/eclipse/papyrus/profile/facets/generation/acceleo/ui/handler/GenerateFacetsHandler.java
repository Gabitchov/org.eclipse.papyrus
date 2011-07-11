/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.facets.generation.acceleo.ui.handler;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.eclipse.project.editors.file.ManifestEditor;
import org.eclipse.papyrus.eclipse.project.editors.project.EMFFacetProjectEditor;
import org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfiguration;
import org.eclipse.papyrus.profile.facets.generation.acceleo.ui.Activator;
import org.eclipse.papyrus.profile.facets.generation.acceleo.ui.messages.Messages;
import org.eclipse.papyrus.properties.util.EMFHelper;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Profile;
import org.xml.sax.SAXException;

/**
 * 
 * This handler provides the action to generate the facet from a UML Profile
 * 
 */
public class GenerateFacetsHandler extends AbstractHandler {


	/** the extension of the configuration file */
	public static final String CONFIGURATION_FILE_EXTENSION = "profiletofacetsconfiguration"; //$NON-NLS-1$

	/** the Java Source Folder for generated code */
	private static final String JAVA_SOURCE_FOLDER = "src-gen"; //$NON-NLS-1$

	/** the name of the extension point for the facet registration */
	private static final String FACET_REGISTRATION = "org.eclipse.emf.facet.infra.facet.registration"; //$NON-NLS-1$

	/** the name of the extension point for the query registration */
	private static final String QUERY_REGISTRATION = "org.eclipse.emf.facet.infra.query.registration"; //$NON-NLS-1$

	/** the image used for the dialog */
	private static Image im = org.eclipse.papyrus.diagram.common.Activator.getImage("/icons/papyrus/PapyrusLogo16x16.gif"); //$NON-NLS-1$

	/** a space */
	private static final String SPACE_WITH_DASH = "  -"; //$NON-NLS-1$

	private static final String FACET_SET = "facetset"; //$NON-NLS-1$

	private static final String FILE = "file"; //$NON-NLS-1$

	private static final String QUERY_SET = "modelqueryset"; //$NON-NLS-1$

	/** the configuration for the generator */
	private ProfileToFacetsConfiguration configuration = null;

	/** the project owning the configuration */
	private IProject project = null;

	/**
	 * Initialize the field {@link #project} and {@link #configuration}
	 * 
	 * @param file
	 *        the configuration file
	 */
	private void init(final IFile file) {
		this.project = file.getProject();
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		try {
			this.configuration = (ProfileToFacetsConfiguration)EMFHelper.loadEMFModel(null, uri);
		} catch (IOException e) {
			Activator.log.error(uri.toString() + "not found", e); //$NON-NLS-1$
		}
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 *      {@inheritDoc}
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if(!selection.isEmpty() && selection instanceof IStructuredSelection) {
			Object firstElement = ((IStructuredSelection)selection).getFirstElement();
			IFile file = null;
			if(firstElement instanceof IFile) {
				file = (IFile)firstElement;
				if(file.getFileExtension().equals(CONFIGURATION_FILE_EXTENSION)) {
					init(file);
					Assert.isNotNull(this.project);
					Assert.isNotNull(this.configuration);


					EMFFacetProjectEditor editor = null;
					try {
						editor = new EMFFacetProjectEditor(this.project);
						editor.init();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (CoreException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (ParserConfigurationException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (SAXException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if(editor != null) {
						Set<String> missingNatures = editor.getMissingNature();
						Set<String> missingFiles = editor.getMissingFiles();
						Set<String> missingBuildCommand = editor.getMissingBuildCommand();
						int result = Dialog.OK;
						//TODO : ask for the build command
						if(missingNatures.size() != 0 || missingFiles.size() != 0 || missingBuildCommand.size() != 0) {
							String message = "The current project doesn't allow to generate the required files. \n We need to transform your project in EMF-Facet Project : ";
							message += "The following natures will be added to your project :\n";
							Iterator<String> iter = missingNatures.iterator();
							while(iter.hasNext()) {
								message += SPACE_WITH_DASH + iter.next() + "\n";
							}
							message += "\n\n";
							message += "The following files will be created :\n";

							iter = missingFiles.iterator();
							while(iter.hasNext()) {
								message += SPACE_WITH_DASH + iter.next() + "\n";
							}

							MessageDialog dialog = new MessageDialog(Display.getCurrent().getActiveShell(), "Change the project configuration", im, message, MessageDialog.QUESTION_WITH_CANCEL, new String[]{ "Accept", "Cancel" }, Dialog.OK);
							result = dialog.open();
							if(result != Dialog.OK) {
								return null; //nothing to do
							}
							editor.create();
							try {
								editor.save();
							} catch (Throwable e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

						/*
						 * we prepare the generation
						 */
						editor.addToBuild(getModelTargetFolderName() + "/");
						editor.addJavaSourceFolder(getJavaSourceFolderName());

						try {
							editor.save();
						} catch (Throwable e2) {
							Activator.log.error(e2);
						}
						/*
						 * we generate the files
						 */
						FacetGenerator gen = new FacetGenerator(this.configuration.getProfile(), this.configuration.getBasePackage());
						gen.setQVTTransformationParameters(getModelTargetURI());
						gen.setAcceleoTransformationParameter(this.configuration.getHeader(), getJavaSourceFolderPath());
						gen.generate();
						//
						//
						editor.registerFacetSets(gen.getGeneratedFacetSet());
						editor.registerQuerySets(gen.getGeneratedQuerySet());
						gen.repairURI2();
						//we refresh the workspace
						try {
							this.project.refreshLocal(IProject.DEPTH_INFINITE, new NullProgressMonitor());
						} catch (CoreException e) {
							Activator.log.error(e);
						}
						//						ManifestEditor manEditor = null;
						//						try {
						//							//							manEditor = new ManifestEditor(this.project);
						//							//							manEditor.init();
						//						} catch (IOException e2) {
						//							// TODO Auto-generated catch block
						//							e2.printStackTrace();
						//						} catch (CoreException e2) {
						//							// TODO Auto-generated catch block
						//							e2.printStackTrace();
						//						}
						//						if(!manEditor.exists()){
						//							//							manEditor.create();
						//						}
						Set<String> dependencies = getDependencies();
						Iterator<String> iter = dependencies.iterator();
						while(iter.hasNext()) {
							//							break;
							editor.addDependency(iter.next());
							//							manEditor.addDependency(iter.next());
						}


						try {

							editor.save();
							//							manEditor.save();
						} catch (Throwable e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						//we refresh the workspace
						try {
							this.project.refreshLocal(IProject.DEPTH_INFINITE, new NullProgressMonitor());
						} catch (CoreException e) {
							Activator.log.error(e);
						}
						manageDatatypes();
					}
				}
			}
		}


		return null;
	}

	//	private boolean isEMFFacetProject(final IProject project) {
	//		ProjectEditor editor = new ProjectEditor(project);
	//		return editor.hasNature(EMF_FACET_NATURE);
	//	}
	private void registerDependencies(final ManifestEditor manifestEditor) {
		//register the dependencies
		IJavaProject proj = JavaCore.create(this.project);
		IJavaElement[] children = null;
		try {
			children = proj.getChildren();
		} catch (JavaModelException e1) {
			Activator.log.error(e1);
			e1.printStackTrace();
		}
		IPackageFragmentRoot sourceFolder=null;
		//we look for the source folder
		String sourceFolderName = getJavaSourceFolderName();
		for(int i = 0; i < children.length; i++) {
			IJavaElement el = children[i];
			if(el instanceof IPackageFragmentRoot && el.getElementName().equals(sourceFolderName)) {
				sourceFolder = (IPackageFragmentRoot)el;
				break;	
			}
		}

		if(sourceFolder!=null){
			try {
				children = sourceFolder.getChildren();
				List<IImportDeclaration> iImportDeclaration = new ArrayList<IImportDeclaration>();
				for(int i = 0; i < children.length; i++) {
					if(children[i] instanceof IPackageFragment) {
						ICompilationUnit[] units;
						units = ((IPackageFragment)children[i]).getCompilationUnits();
						for(int j = 0; j < units.length; j++) {
							ICompilationUnit unit = units[j];
							iImportDeclaration.addAll(Arrays.asList(unit.getImports()));
						}
					}
				}

				Iterator<IImportDeclaration> iter = iImportDeclaration.iterator();
				while(iter.hasNext()) {
					manifestEditor.addDependency(iter.next().getElementName());
				}
			} catch (JavaModelException e) {
				Activator.log.error(e);
			}
		}
	}

	/**
	 * 
	 * @return
	 *         the dependencies to register
	 */
	private Set<String> getDependencies() {
		//register the dependencies
		Set<String> dependencies = new HashSet<String>();
		IJavaProject proj = JavaCore.create(this.project);
		IJavaElement[] children = null;
		try {
			children = proj.getChildren();
		} catch (JavaModelException e1) {
			Activator.log.error(e1);
		}
		IPackageFragmentRoot sourceFolder = null;
		//we look for the source folder
		String sourceFolderName = getJavaSourceFolderName();
		for(int i = 0; i < children.length; i++) {
			IJavaElement el = children[i];
			if(el instanceof IPackageFragmentRoot && el.getElementName().equals(sourceFolderName)) {
				sourceFolder = (IPackageFragmentRoot)el;
				break;
			}
		}

		if(sourceFolder != null) {
			try {
				children = sourceFolder.getChildren();
				List<IImportDeclaration> iImportDeclaration = new ArrayList<IImportDeclaration>();
				for(int i = 0; i < children.length; i++) {
					if(children[i] instanceof IPackageFragment) {
						ICompilationUnit[] units;
						units = ((IPackageFragment)children[i]).getCompilationUnits();
						for(int j = 0; j < units.length; j++) {
							ICompilationUnit unit = units[j];
							iImportDeclaration.addAll(Arrays.asList(unit.getImports()));
						}
					}
				}

				Iterator<IImportDeclaration> iter = iImportDeclaration.iterator();
				while(iter.hasNext()) {
					dependencies.add(iter.next().getElementName());
				}
			} catch (JavaModelException e) {
				Activator.log.error(e);
			}
		}
		return dependencies;
	}




	private String getJavaSourceFolderName() {
		String folderName = this.configuration.getJavaFolder();
		if(folderName.equals("")) { //$NON-NLS-1$
			folderName = JAVA_SOURCE_FOLDER;
		}


		if(folderName.charAt(0) == '/') {
			folderName = folderName.substring(1);
		}
		if(folderName.charAt(folderName.length() - 1) == '/') {
			folderName = folderName.substring(0, folderName.length() - 1);
		}

		return folderName;
	}

	///**
	// * Register the FacetSets if they are not already registered
	// * 
	// * @param editor
	// *        the plugin editor
	// * @param facetSets
	// *        the querySets to register
	// */
	//private void registerFacetSets(final PluginEditor pluginEditor, final List<FacetSet> facetSets) {
	//	for(int i = 0; i < facetSets.size(); i++) {
	//		FacetSet set = facetSets.get(i);
	//		String filepath = this.configuration.getModelFolder() + "/" + "facets" + "/";
	//		filepath += set.getName() + ".facetSet"; //$NON-NLS-1$
	//		boolean registered = false;
	//		//we test if the file is already registered
	//		List<Node> extensions = pluginEditor.getExtensions(FACET_REGISTRATION);
	//		Iterator<Node> iter = extensions.iterator();
	//		while(iter.hasNext()) {
	//			Node current = iter.next();
	//			Node child = current.getFirstChild();
	//			if(child != null) {
	//				NamedNodeMap attributes = child.getAttributes();
	//				Node node = attributes.getNamedItem(FILE);
	//				if(node != null) {
	//					String path = node.getNodeValue();
	//					registered = filepath.equals(path);
	//
	//				}
	//			}
	//		}
	//
	//		if(!registered) {
	//			Element extension = pluginEditor.addExtension(FACET_REGISTRATION);
	//			Element facetSet = pluginEditor.addChild(extension, FACET_SET);
	//			pluginEditor.setAttribute(facetSet, FILE, filepath);
	//		}
	//	}
	//}

	///**
	// * Register the QuerySet if they are not already registered
	// * 
	// * @param editor
	// *        the plugin editor
	// * @param querySets
	// *        the querySets to register
	// */
	//private void registerQuerySets(final PluginEditor editor, final List<EObject> querySets) {
	//	for(int i = 0; i < querySets.size(); i++) {
	//		ModelQuerySet set = (ModelQuerySet)querySets.get(i);
	//		String filepath = this.configuration.getModelFolder() + "/" + "queries" + "/";//TODO is there another way to find the path of the query? //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	//		filepath += set.getName() + ".querySet"; //$NON-NLS-1$
	//		boolean registered = false;
	//		//we test if the file is already registered
	//		List<Node> extensions = editor.getExtensions(QUERY_REGISTRATION);
	//		Iterator<Node> iter = extensions.iterator();
	//		while(iter.hasNext() && registered == false) {
	//			Node current = iter.next();
	//			Node child = current.getFirstChild();
	//			if(child != null) {
	//				NamedNodeMap attributes = child.getAttributes();
	//				Node node = attributes.getNamedItem(FILE);
	//				if(node != null) {
	//					String path = node.getNodeValue();
	//					registered = filepath.equals(path);
	//
	//				}
	//			}
	//		}
	//
	//		if(!registered) {
	//			Element extension = editor.addExtension(QUERY_REGISTRATION);
	//			Element queySet = editor.addChild(extension, QUERY_SET);
	//			editor.setAttribute(queySet, FILE, filepath);
	//		}
	//	}
	//}


	/**
	 * This method open a dialog to inform the user that the datatype are not handled by the generator
	 */
	private void manageDatatypes() {
		List<DataType> datatypes = new ArrayList<DataType>();
		Profile profile = this.configuration.getProfile();
		if(profile != null) {
			TreeIterator<Object> contents = UML2Util.getAllContents(profile, true, false);
			while(contents.hasNext()) {
				Object next = contents.next();
				if(next instanceof DataType) {
					datatypes.add((DataType)next);
				}
			}
		}
		if(datatypes.isEmpty()) {
			String message = Messages.GenerateFacetsHandler_message_datatype_are_not_handled;
			for(int i = 0; i < datatypes.size(); i++) {
				message += SPACE_WITH_DASH + datatypes.get(i).getName() + "\n"; //$NON-NLS-1$ 
			}
			MessageDialog dialog = new MessageDialog(Display.getCurrent().getActiveShell(), Messages.GenerateFacetsHandler_Title_Problem_during_facets_generation, im, message, MessageDialog.INFORMATION, new String[]{ IDialogConstants.OK_LABEL }, 0);
			dialog.open();
		}
	}


	//		/**
	//		 * Returns the missing nature for the project
	//		 * 
	//		 * @param project
	//		 *        the project
	//		 * @return
	//		 *         the missing natures of the project
	//		 */
	//		private String[] getMissingNatures(final IProject project) {
	//			ProjectEditor editor = new ProjectEditor(project);
	//			List<String> missingNatures = new ArrayList<String>();
	//			for(int i = 0; i < REQUIRED_NATURES.length; i++) {
	//				if(!editor.hasNature(REQUIRED_NATURES[i])) {
	//					missingNatures.add(REQUIRED_NATURES[i]);
	//				}
	//			}
	//			return missingNatures.toArray(new String[missingNatures.size()]);
	//		}

	//	/**
	//	 * Adds the missing natures to the project
	//	 * 
	//	 * @param project
	//	 *        the project
	//	 * @param missingNature
	//	 *        the natures to add to the project
	//	 */
	//	private void addRequiredNatures(final IProject project, final String[] missingNature) {
	//		ProjectEditor editor = new ProjectEditor(project);
	//		for(int i = 0; i < missingNature.length; i++) {
	//			editor.addNature(missingNature[i]);
	//			//the associated build command seems to be automatically added!
	//		}
	//		try {
	//			editor.save();
	//		} catch (Exception e) {
	//			Activator.log.error(e);
	//		}
	//
	//	}

	/**
	 * 
	 * 
	 * @return the path for the java source folder
	 */
	private String getJavaSourceFolderPath() {
		String folder = getJavaSourceFolderName();

		//we create the wanted source folder
		IFolder iFolder = this.project.getFolder(folder);
		if(!iFolder.exists()) {
			try {
				iFolder.create(true, false, new NullProgressMonitor());
			} catch (CoreException e) {
				Activator.log.error(e);
			}
		}
		//		//TODO change that!
		//		JavaProjectEditor javaEditor = new JavaProjectEditor(this.project);
		//		javaEditor.addJavaSourceFolder(folder);
		//		try {
		//			javaEditor.save();
		//		} catch (Exception e) {
		//			Activator.log.error(e);
		//		} catch (Throwable e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		String path = iFolder.getLocation().toOSString();

		String basePackage = this.configuration.getBasePackage();
		basePackage = basePackage.replace(".", "/"); //$NON-NLS-1$ //$NON-NLS-2$
		path += "/" + basePackage; //$NON-NLS-1$
		return path;

	}

	//	private String getJavaSourceFolder() {
	//		String folder = getJavaSourceFolderName();
	//
	//		if(folder.charAt(0) == '/') {
	//			folder = folder.substring(1);
	//		}
	//		if(folder.charAt(folder.length() - 1) == '/') {
	//			folder = folder.substring(0, folder.length() - 1);
	//		}
	//		return folder;
	//	}
	/**
	 * 
	 * @return the URI for the target model folder
	 */
	private URI getModelTargetURI() {
		String folder = this.configuration.getModelFolder();
		java.net.URI uri1 = this.project.getLocationURI();
		String path = uri1.getPath();

		path += getModelTargetFolder();
		return URI.createFileURI(path);
	}

	private String getModelTargetFolder() {
		String folder = this.configuration.getModelFolder();
		if(folder.charAt(0) != '/') {
			folder = "/" + folder; //$NON-NLS-1$
		}
		if(folder.charAt(folder.length() - 1) != '/') {
			folder = folder + "/"; //$NON-NLS-1$
		}
		return folder;
	}

	private String getModelTargetFolderName() {
		String folder = this.configuration.getModelFolder();
		if(folder.charAt(0) == '/') {
			folder = folder.substring(0);
		}
		if(folder.charAt(folder.length() - 1) == '/') {
			folder = folder.substring(0, folder.length() - 2);
		}
		return folder;
	}

	//	/**
	//	 * 
	//	 * @param project
	//	 *        the current project
	//	 * @return
	//	 *         <code>true</code> if the current project is a JavaProject
	//	 */
	//	private boolean isJavaProject(final IProject project) {
	//		IJavaProject javaProject = JavaCore.create(project);
	//		return javaProject.exists();
	//	}


	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		ISelection selection = selectionService.getSelection();
		if(selection instanceof IStructuredSelection && ((IStructuredSelection)selection).size() == 1) {
			Object firstElement = ((IStructuredSelection)selection).getFirstElement();
			if(firstElement instanceof IFile) {
				IFile file = (IFile)firstElement;
				String fileExtension = file.getFileExtension();
				return CONFIGURATION_FILE_EXTENSION.equals(fileExtension);
			}
		}
		return false;
	}


}
