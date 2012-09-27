/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia DHOUIB (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.export.handlers;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.ui.util.DisplayUtils;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.papyrus.eclipse.project.editors.file.ManifestEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.resource.uml.UmlModel;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.widgets.util.FileUtil;
import org.eclipse.papyrus.uml.export.dialog.ExportProfilesParametersDialog;
import org.eclipse.papyrus.uml.export.dialog.ProfilesToExportSelectionDialog;
import org.eclipse.papyrus.uml.export.messages.Messages;
import org.eclipse.papyrus.uml.export.util.BuildProperties;
import org.eclipse.papyrus.uml.export.util.ExportProfilesUserParameters;
import org.eclipse.papyrus.uml.export.util.ImportedLibrary;
import org.eclipse.papyrus.uml.export.util.InstalledProfileURI;
import org.eclipse.papyrus.uml.export.util.PluginExportUtil;
import org.eclipse.papyrus.uml.export.util.ProfileUtil;
import org.eclipse.papyrus.uml.export.util.WSFileUtil;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModel;
import org.eclipse.pde.internal.core.plugin.WorkspacePluginModel;
import org.eclipse.pde.internal.core.plugin.WorkspacePluginModelBase;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.xml.sax.SAXException;




// TODO: Auto-generated Javadoc
/**
 * The Class ExportProfilesCommand.
 */
@SuppressWarnings("restriction")
public class ExportProfilesCommand extends AbstractTransactionalCommand {

	/**
	 * Instantiates a new export profiles command.
	 * 
	 * @param domain
	 *        the domain
	 * @param label
	 *        the label
	 * @param affectedFiles
	 *        the affected files
	 */
	public ExportProfilesCommand(TransactionalEditingDomain domain, String label, @SuppressWarnings("rawtypes") List affectedFiles) {
		super(domain, label, affectedFiles);
		// TODO Auto-generated constructor stub
	}

	/** The resources folder name. */
	private String resourcesFolderName = Messages.ExportProfilesCommand_0;

	/** The plugin provider. */
	String pluginProvider = Messages.ExportProfilesCommand_1;

	/** The plugin to install name. */
	String pluginToInstallName = Messages.ExportProfilesCommand_2;

	/** The plugin version. */
	String pluginVersion = Messages.ExportProfilesCommand_3;

	/** The exec environment. */
	String execEnvironment = Messages.ExportProfilesCommand_4;



	/**
	 * Do execute with result.
	 * 
	 * @param monitor
	 *        the monitor
	 * @param info
	 *        the info
	 * @return the command result
	 * @throws ExecutionException
	 *         the execution exception
	 * @see org.eclipse.core.commands.operations.AbstractOperation#canExecute()
	 */



	/**
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param monitor
	 * @param info
	 * @return
	 * @throws org.eclipse.core.commands.ExecutionException
	 */

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, org.eclipse.core.runtime.IAdaptable info) throws org.eclipse.core.commands.ExecutionException {


		ServiceUtilsForActionHandlers serviceUtils = new ServiceUtilsForActionHandlers();
		UmlModel openedModel;

		try {
			openedModel = (UmlModel)serviceUtils.getModelSet().getModel(UmlModel.MODEL_ID);
			if(openedModel != null) {

				EObject root = openedModel.lookupRoot();



				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();


				ProfilesToExportSelectionDialog dialog = new ProfilesToExportSelectionDialog(shell, true, ProfileUtil.getAppliedProfilesFromWS(root), Messages.ExportProfilesCommand_6);

				dialog.open();
				if(Dialog.OK == dialog.getReturnCode()) {
					// get the result, which is the set of libraries to export 
					//then export the result
					//launch a window to set the user specified export parameters:
					// * name of the plugin that will contain the exported profiles and will be installed in the environement
					// * version of the plugin
					// * Provider of the plugin
					// * Execution Environment						


					Object[] profiles = dialog.getResult();
					for(int i = 0; i < profiles.length; i++) {
						pluginToInstallName += ((Profile)profiles[i]).getName();

					}
					ExportProfilesParametersDialog paramDialog = new ExportProfilesParametersDialog(DisplayUtils.getDefaultShell(), pluginToInstallName, pluginProvider, pluginVersion, execEnvironment, dialog.getResult());

					if(paramDialog.open() == Dialog.OK) {
						ExportProfilesUserParameters param = new ExportProfilesUserParameters(paramDialog.getPluginName(), paramDialog.getPluginProvider(), paramDialog.getPluginVersion(), paramDialog.getPluginExecEnvironment());

						exportProfiles(shell, dialog.getResult(), param, paramDialog.getProfilesIcons());
						return CommandResult.newOKCommandResult();


					}



				}
			} else
				return CommandResult.newErrorCommandResult(Messages.ExportProfilesCommand_7);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return CommandResult.newErrorCommandResult(Messages.ExportProfilesCommand_8);





	}

	/**
	 * Export profiles.
	 * 
	 * @param shell
	 *        the shell
	 * @param appliedProfilesFromWS
	 *        the applied profiles from ws
	 * @param param
	 *        User defined paprameters for the generation
	 * @param profilesIcons
	 * @throws ParserConfigurationException
	 *         the parser configuration exception
	 * @throws SAXException
	 *         the sAX exception
	 * @throws IOException
	 *         Signals that an I/O exception has occurred.
	 * @throws CoreException
	 *         the core exception
	 */
	protected void exportProfiles(final Shell shell, final Object[] appliedProfilesFromWS, final ExportProfilesUserParameters param, final String[] profilesIcons) throws ParserConfigurationException, SAXException, IOException, CoreException {


		final ProgressMonitorDialog monitordialog = new ProgressMonitorDialog(shell);
		try {
			monitordialog.run(true, true, new IRunnableWithProgress() {


				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

					//Construct the profile
					String profilesConcatName = ""; //$NON-NLS-1$

					for(int i = 0; i < appliedProfilesFromWS.length; i++) {

						profilesConcatName += ((Profile)appliedProfilesFromWS[i]).getName();;
					}

					String localPluginName = param.getPluginName();

					//this variable will store the imported libraries from WS, it will be used for the extensions generation in the manifest
					ArrayList<ImportedLibrary> importedLibrariesFromWS = new ArrayList<ImportedLibrary>();

					IProject project = null;
					final PluginExportUtil pluginCreator = new PluginExportUtil();
					monitor.beginTask(Messages.ExportProfilesCommand_10, 100);

					//****************************************************************
					//1. Generating a Plugin in the WS that encapsulated the applied profiles
					//****************************************************************
					monitor.subTask(Messages.ExportProfilesCommand_11);
					project = pluginCreator.createPlugin(monitor, param.getPluginName(), param.getPluginExecEnvironment(), param.getPluginVersion(), param.getPluginProvider());
					monitor.worked(1);
					try {
						monitor.subTask(Messages.ExportProfilesCommand_12);
						//****************************************************************
						//1.0 Plugin customization: adding dependencies to Manifest
						//****************************************************************
						ManifestEditor editor = new ManifestEditor(project);
						editor.init();
						editor.setSingleton(true);//we are going to add extensions to manifest, singleton must be set to true			
						editor.save();




						//***********************************************************************************
						// 1.1 Plugin customization: adding model directory and copying the profiles resources
						//************************************************************************************

						for(int i = 0; i < appliedProfilesFromWS.length; i++) {




							ModelSet modelset = ServiceUtilsForResource.getInstance().getModelSet(((Profile)appliedProfilesFromWS[i]).eResource());
							String umlFileName = WSFileUtil.getFileName((Profile)appliedProfilesFromWS[i], "uml"); //$NON-NLS-1$

							Resource umlProfile = modelset.getAssociatedResource((Profile)appliedProfilesFromWS[i], "uml"); //$NON-NLS-1$


							//Visits all proxies in the model set and tries to resolve them.
							EcoreUtil.resolveAll(modelset);





							//copy the uml profile in the created plugin (xmi ids will be copied)
							URI umlFilenewURI = URI.createPlatformResourceURI(localPluginName + resourcesFolderName + umlFileName, true);
							URI umlFileoldURI = umlProfile.getURI();
							umlProfile.setURI(umlFilenewURI);
							umlProfile.save(null);

							//resave the resource with the original uri
							umlProfile.setURI(umlFileoldURI);
							umlProfile.save(null);

							ResourceSet resourceSet = new ResourceSetImpl();
							Resource newUmlProfileResource = resourceSet.getResource(umlFilenewURI, true);
							EcoreUtil.resolveAll(resourceSet);
							//Verify that the uml model does not import packages. If it is the case, create the imported resources in the generated plugin and export them as well
							for(EObject obj : newUmlProfileResource.getContents()) {
								if(obj instanceof Profile) {

									EList<Package> importedPackages = ((Profile)obj).getImportedPackages();
									for(Package pack : importedPackages) {

										//if the package is stored in the workspace, export it in the resource directory of the created profile plugin 
										if(pack.eResource() != null)
											if(pack.eResource().getURI().isPlatformResource()) {
												String umlPackageFileName = WSFileUtil.getFileName(pack, "uml"); //$NON-NLS-1$

												//Create the uml file that contain the library 
												URI uri = pack.eResource().getURI();
												URI newURI = URI.createPlatformResourceURI(localPluginName + resourcesFolderName + umlPackageFileName, true);
												pack.eResource().setURI(newURI);
												pack.eResource().save(null);


												//set the uri to the platform/plugin URI
												pack.eResource().setURI(URI.createURI("platform:/plugin/" + localPluginName + resourcesFolderName + umlPackageFileName)); //$NON-NLS-1$
												//redefine the profile
												((Profile)obj).define();

												//The variable importedLibrariesFromWS is used to store the libraries that will be declared in the extensions of plugin.xml 
												importedLibrariesFromWS.add(new ImportedLibrary(pack, "platform:/plugin/" + localPluginName + resourcesFolderName + umlPackageFileName, uri, pack.getName())); //$NON-NLS-1$


											}
									}

								}
							}
							newUmlProfileResource.save(null);

						}



						//****************************************************************
						//1.2 Plugin customization: adding extension points in plugin.xml
						//****************************************************************
						final WorkspacePluginModelBase model = new WorkspacePluginModel(project.getProject().getFile("plugin.xml"), false); //$NON-NLS-1$
						IPluginBase base = model.getPluginBase();
						//****************************************************************
						//1.2.1 Adding extension "org.eclipse.emf.ecore.uri_mapping"
						//****************************************************************
						IPluginExtension uri_mapping_ext = model.createExtension();
						base.add(uri_mapping_ext);
						uri_mapping_ext.setPoint("org.eclipse.emf.ecore.uri_mapping"); //$NON-NLS-1$
						IPluginElement uri_mapping_elem = model.createElement(uri_mapping_ext);
						uri_mapping_ext.add(uri_mapping_elem);


						uri_mapping_elem.setName("mapping"); //$NON-NLS-1$
						uri_mapping_elem.setAttribute("source", "pathmap://EXPORTED_" + profilesConcatName + "PROFILES/"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						uri_mapping_elem.setAttribute("target", "platform:/plugin/" + localPluginName + resourcesFolderName); //$NON-NLS-1$ //$NON-NLS-2$
						model.setDirty(true);
						model.save();
						//**********************************************************************
						//1.2.2Adding Extension "org.eclipse.papyrus.uml.extensionpoints.UMLProfile"
						//**********************************************************************
						final List<InstalledProfileURI> installedProfilesUri = new ArrayList<InstalledProfileURI>();
						for(int i1 = 0; i1 < appliedProfilesFromWS.length; i1++) {

							IPluginExtension ext = model.createExtension();
							base.add(ext);
							ext.setPoint("org.eclipse.papyrus.uml.extensionpoints.UMLProfile"); //$NON-NLS-1$
							IPluginElement elem = model.createElement(ext);
							ext.add(elem);

							Profile profile = (Profile)appliedProfilesFromWS[i1];

							String umlFileName = WSFileUtil.getFileName(profile, "uml"); //$NON-NLS-1$
							elem.setName("profile"); //$NON-NLS-1$
							//mandatory attributes
							elem.setAttribute("name", profile.getName()); //$NON-NLS-1$
							elem.setAttribute("path", "platform:/plugin/" + localPluginName + resourcesFolderName + umlFileName); //$NON-NLS-1$ //$NON-NLS-2$
							//optional attributes
							elem.setAttribute("description", "UML Profile " + profile.getName()); //$NON-NLS-1$ //$NON-NLS-2$
							elem.setAttribute("provider", param.getPluginProvider()); //$NON-NLS-1$ //$NON-NLS-2$
							if(!(profilesIcons[i1] == null) && !(profilesIcons[i1].length() == 0)) {
								File icon = FileUtil.getFile(profilesIcons[i1]);
								String iconName = getFSFileName(icon.getAbsolutePath());
								elem.setAttribute("iconpath", "icons/" + iconName);
								//copying icon file into created project
								WSFileUtil.copyFile(project, icon, "icons/", iconName);

							}



							installedProfilesUri.add(new InstalledProfileURI("platform:/plugin/" + localPluginName + resourcesFolderName + umlFileName, profile.eResource().getURI().toString())); //$NON-NLS-1$

							model.setDirty(true);
							model.save();
						}
						//**********************************************************************
						//1.2.3 Adding Extension "org.eclipse.papyrus.uml.extensionpoints.UMLLibrary"
						//**********************************************************************
						if(!importedLibrariesFromWS.isEmpty()) {
							for(ImportedLibrary importedLibrary : importedLibrariesFromWS) {
								IPluginExtension ext = model.createExtension();
								base.add(ext);
								ext.setPoint("org.eclipse.papyrus.uml.extensionpoints.UMLLibrary"); //$NON-NLS-1$
								IPluginElement elem = model.createElement(ext);
								ext.add(elem);

								elem.setName("library"); //$NON-NLS-1$
								//mandatory attributes
								elem.setAttribute("name", importedLibrary.getName()); //$NON-NLS-1$
								elem.setAttribute("path", importedLibrary.getUri()); //$NON-NLS-1$
								//optional attributes
								elem.setAttribute("description", "UML Library " + importedLibrary.getName()); //$NON-NLS-1$ //$NON-NLS-2$
								elem.setAttribute("provider", param.getPluginProvider()); //$NON-NLS-1$ //$NON-NLS-2$

								model.setDirty(true);
								model.save();

							}
						}

						// Refresh workspace files
						project.refreshLocal(IResource.DEPTH_INFINITE, null);


						monitor.worked(1);

						//****************************************************************
						//1.3 Plugin customization: adding build properties to Manifest
						//****************************************************************
						monitor.subTask("Plugin customization: adding build properties to Manifest ..."); //$NON-NLS-1$
						BuildProperties buildproperties = new BuildProperties(project);
						buildproperties.addBuildEntry("bin.includes", "META-INF/,.,plugin.xml,build.properties,model/,icons/"); //$NON-NLS-1$ //$NON-NLS-2$
						monitor.worked(1);
						//****************************************************************
						//2. Export the plugin and install it
						//****************************************************************
						monitor.subTask(Messages.ExportProfilesCommand_5);
						final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

						final IPluginModel pluginModel = PluginExportUtil.getPluginModelForProject(project);
						Display.getDefault().asyncExec(new Runnable() {

							public void run() {

								pluginCreator.exportProfilePlugin(shell, pluginModel, root.getLocation().toString() + "/.metadata/.plugins/org.eclipse.pde.core/install/", installedProfilesUri); //$NON-NLS-1$


							}


						});

						monitor.worked(1);
						monitor.done();




					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ServiceException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}





				}




			});

		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	/**
	 * Gets the fS file name.
	 * 
	 * @param path
	 *        the path
	 * @return the fS file name
	 */
	public static String getFSFileName(String path) {

		String fileName;
		if(path.indexOf("\\") < 0) { //$NON-NLS-1$
			fileName = path;
		} else {
			fileName = path.substring(path.lastIndexOf("\\") + 1, path.length()); //$NON-NLS-1$
		}
		return fileName;
	}

}
