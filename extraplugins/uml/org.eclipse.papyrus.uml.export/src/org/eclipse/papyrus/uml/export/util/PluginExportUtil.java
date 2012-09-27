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
package org.eclipse.papyrus.uml.export.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.build.IBuildEntry;
import org.eclipse.pde.core.build.IBuildModel;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginModel;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.build.IBuildPropertiesConstants;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.PDECoreMessages;
import org.eclipse.pde.internal.core.PluginModelManager;
import org.eclipse.pde.internal.core.build.WorkspaceBuildModel;
import org.eclipse.pde.internal.core.exports.FeatureExportInfo;
import org.eclipse.pde.internal.core.exports.PluginExportOperation;
import org.eclipse.pde.internal.core.feature.WorkspaceFeatureModel;
import org.eclipse.pde.internal.core.plugin.WorkspacePluginModelBase;
import org.eclipse.pde.internal.core.project.PDEProject;
import org.eclipse.pde.internal.ui.IPreferenceConstants;
import org.eclipse.pde.internal.ui.PDELabelProvider;
import org.eclipse.pde.internal.ui.PDEPlugin;
import org.eclipse.pde.internal.ui.PDEPluginImages;
import org.eclipse.pde.internal.ui.PDEUIMessages;
import org.eclipse.pde.internal.ui.build.RuntimeInstallJob;
import org.eclipse.pde.internal.ui.wizards.IProjectProvider;
import org.eclipse.pde.internal.ui.wizards.plugin.NewProjectCreationOperation;
import org.eclipse.pde.internal.ui.wizards.plugin.PluginFieldData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressConstants;
import org.osgi.service.prefs.BackingStoreException;

import com.ibm.icu.text.MessageFormat;

// TODO: Auto-generated Javadoc
/**
 * The Class PluginExportUtil.
 */
@SuppressWarnings("restriction")
public class PluginExportUtil {


	/** The Constant MAX_RETRY. */
	protected static final int MAX_RETRY = 3;

	/** The Constant SrcFolderName. */
	private static final String SrcFolderName = "src";





	/**
	 * Creates the plugin.
	 * 
	 * @param progressMonitor
	 *        the progress monitor
	 * @param pluginName
	 *        the plugin name
	 * @param executionEnvironment
	 *        the execution environment
	 * @param pluginVersion
	 *        the plugin version
	 * @param provider
	 *        the provider
	 * @return the i project
	 */
	public IProject createPlugin(IProgressMonitor progressMonitor, final String pluginName, String executionEnvironment, String pluginVersion, String provider) {


		PluginFieldData fPluginData = new PluginFieldData();
		fPluginData.setProvider(provider);
		fPluginData.setId(pluginName);
		fPluginData.setName(pluginName);
		fPluginData.setSourceFolderName(SrcFolderName);
		fPluginData.setVersion(pluginVersion);
		fPluginData.setWorkingSets(null);
		fPluginData.setClassname(pluginName + ".Activator");
		fPluginData.setDoGenerateClass(true);
		fPluginData.setExecutionEnvironment(executionEnvironment);
		fPluginData.setOSGiFramework(null);
		fPluginData.setHasBundleStructure(true);
		fPluginData.setUIPlugin(true);
		fPluginData.setLegacy(false);
		fPluginData.setLibraryName(null);
		fPluginData.setOutputFolderName("bin");
		fPluginData.setRCPApplicationPlugin(false);
		fPluginData.setEnableAPITooling(false);
		fPluginData.setSimple(false);
		fPluginData.setTargetVersion("3.7");
		IWorkingSet[] workingSets = {};
		fPluginData.setWorkingSets(workingSets);




		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		final IProject project = root.getProject(pluginName);



		IProjectProvider fProjectProvider = new IProjectProvider() {

			public String getProjectName() {
				// TODO Auto-generated method stub
				return pluginName;
			}

			public IProject getProject() {
				// TODO Auto-generated method stub
				return project;
			}

			public IPath getLocationPath() {
				// TODO Auto-generated method stub
				return ResourcesPlugin.getWorkspace().getRoot().getLocation();
			}
		};

		NewProjectCreationOperation op = new NewProjectCreationOperation(fPluginData, fProjectProvider, null);

		try {

			op.run(progressMonitor);
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return project;

	}

	/**
	 * Export profile plugin.
	 * 
	 * @param shell
	 *        the shell
	 * @param object
	 *        the object
	 * @param installationDirectory
	 *        the installation directory
	 * @param installedProfilesUri
	 *        the installed profiles uri
	 * @return true, if successful
	 */
	public boolean exportProfilePlugin(Shell shell, Object object, String installationDirectory, List<InstalledProfileURI> installedProfilesUri) {

		if(!PlatformUI.getWorkbench().saveAllEditors(true)) {
			return false;
		}

		if(!performPreliminaryChecks(shell, object)) {
			return false;
		}

		scheduleExportJob(object, installationDirectory, installedProfilesUri);

		return true;

	}


	/**
	 * Schedule export job.
	 * 
	 * @param object
	 *        the object
	 * @param installationDirectory
	 *        the installation directory
	 * @param installedProfilesUri
	 *        the installed profiles uri
	 */
	protected void scheduleExportJob(Object object, String installationDirectory, final List<InstalledProfileURI> installedProfilesUri) {
		Object obj[] = new Object[1];
		obj[0] = object;
		final FeatureExportInfo info = new FeatureExportInfo();
		info.toDirectory = true;
		info.useJarFormat = true;
		info.exportSource = true;
		info.exportSourceBundle = false;
		info.allowBinaryCycles = true;
		info.useWorkspaceCompiledClasses = false;
		info.destinationDirectory = installationDirectory;

		info.zipFileName = null;
		info.items = obj;
		info.signingInfo = null;
		info.qualifier = null;

		final boolean installAfterExport = true;
		if(installAfterExport) {
			RuntimeInstallJob.modifyInfoForInstall(info);
		}

		final PluginExportOperation job = new PluginExportOperation(info, PDEUIMessages.PluginExportJob_name);
		job.setUser(true);
		job.setRule(ResourcesPlugin.getWorkspace().getRoot());
		job.setProperty(IProgressConstants.ICON_PROPERTY, PDEPluginImages.DESC_PLUGIN_OBJ);
		job.addJobChangeListener(new JobChangeAdapter() {

			@Override
			public void done(IJobChangeEvent event) {
				if(job.hasAntErrors()) {
					// If there were errors when running the ant scripts, inform the user where the logs can be found.
					final File logLocation = new File(info.destinationDirectory, "logs.zip"); //$NON-NLS-1$
					if(logLocation.exists()) {
						PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {

							public void run() {
								ExportErrorDialog dialog = new ExportErrorDialog(logLocation);
								dialog.open();
							}
						});
					}
				} else if(event.getResult().isOK() && installAfterExport) {
					// Install the export into the current running platform
					RuntimeInstallJob installJob = new RuntimeInstallJob(PDEUIMessages.PluginExportWizard_InstallJobName, info);
					installJob.setUser(true);
					installJob.setProperty(IProgressConstants.ICON_PROPERTY, PDEPluginImages.DESC_FEATURE_OBJ);
					//add preferences that contain the information about the correspondence between the installed and the local profiles
					editPreferences(installedProfilesUri);
					installJob.schedule();
				}
			}
		});
		job.schedule();
	}

	/**
	 * Edits the preferences.
	 * 
	 * @param installedProfilesUri
	 *        the installed profiles uri
	 */
	private void editPreferences(List<InstalledProfileURI> installedProfilesUri) {
		// TODO Auto-generated method stub
		IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode("org.eclipse.papyrus.uml.export");
		org.osgi.service.prefs.Preferences node = preferences.node("installedProfilesUriCorrespondance");
		for(InstalledProfileURI p : installedProfilesUri) {
			node.put(p.getUri_local(), p.getUri_installed());


			try {
				// Forces the application to save the preferences
				preferences.flush();
			} catch (BackingStoreException e2) {
				e2.printStackTrace();
			}
		}

	}

	/**
	 * Perform preliminary checks.
	 * 
	 * @param shell
	 *        the shell
	 * @param object
	 *        the object
	 * @return true, if successful
	 */
	@SuppressWarnings("unchecked")
	protected boolean performPreliminaryChecks(Shell shell, Object object) {
		// Check if we are going to overwrite an existing build.xml file
		if(!MessageDialogWithToggle.ALWAYS.equals(PDEPlugin.getDefault().getPreferenceStore().getString(IPreferenceConstants.OVERWRITE_BUILD_FILES_ON_EXPORT))) {

			@SuppressWarnings("rawtypes")
			List problemModels = new ArrayList();

			String installLocation = null;
			IResource underlyingResource = null;
			if(object instanceof WorkspacePluginModelBase) {
				installLocation = ((WorkspacePluginModelBase)object).getInstallLocation();
				underlyingResource = ((WorkspacePluginModelBase)object).getUnderlyingResource();
			} else if(object instanceof WorkspaceFeatureModel) {
				installLocation = ((WorkspaceFeatureModel)object).getInstallLocation();
				underlyingResource = ((WorkspaceFeatureModel)object).getUnderlyingResource();
			}
			if(installLocation != null && underlyingResource != null) {
				File file = new File(installLocation, "build.xml"); //$NON-NLS-1$
				if(file.exists()) {
					try {
						IFile buildFile = PDEProject.getBuildProperties(underlyingResource.getProject());
						IBuildModel buildModel = new WorkspaceBuildModel(buildFile);
						buildModel.load();
						if(buildModel != null) {
							IBuildEntry entry = buildModel.getBuild().getEntry(IBuildPropertiesConstants.PROPERTY_CUSTOM);
							if(entry == null || !entry.contains(IBuildPropertiesConstants.TRUE)) {
								problemModels.add(object);
							}
						}
					} catch (CoreException e) {
						PDEPlugin.log(e);
					}
				}
			}

			if(problemModels.size() > 0) {
				StringBuffer buf = new StringBuffer();
				PDELabelProvider labelProvider = new PDELabelProvider();
				int maxCount = 10;
				for(Iterator<Object> iterator = problemModels.iterator(); iterator.hasNext();) {
					buf.append(labelProvider.getText(iterator.next()));
					buf.append('\n');
					maxCount--;
					if(maxCount <= 0) {
						buf.append(Dialog.ELLIPSIS);
						break;
					}
				}

				MessageDialogWithToggle dialog = MessageDialogWithToggle.openOkCancelConfirm(shell, PDEUIMessages.AntGeneratingExportWizard_0, MessageFormat.format(PDEUIMessages.AntGeneratingExportWizard_1, buf.toString()), PDEUIMessages.AntGeneratingExportWizard_2, false, PDEPlugin.getDefault().getPreferenceStore(), IPreferenceConstants.OVERWRITE_BUILD_FILES_ON_EXPORT);
				if(dialog.getReturnCode() == Window.CANCEL) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * The Class ExportErrorDialog.
	 */
	protected class ExportErrorDialog extends MessageDialog {

		/** The log location. */
		private File fLogLocation;

		/**
		 * Instantiates a new export error dialog.
		 * 
		 * @param logLocation
		 *        the log location
		 */
		public ExportErrorDialog(File logLocation) {
			super(PlatformUI.getWorkbench().getDisplay().getActiveShell(), PDECoreMessages.FeatureBasedExportOperation_ProblemDuringExport, null, null, MessageDialog.ERROR, new String[]{ IDialogConstants.OK_LABEL }, 0);
			fLogLocation = logLocation;
		}

		/**
		 * Creates the message area.
		 * 
		 * @param composite
		 *        the composite
		 * @return the control
		 * @see org.eclipse.jface.dialogs.IconAndMessageDialog#createMessageArea(org.eclipse.swt.widgets.Composite)
		 */

		@Override
		protected Control createMessageArea(Composite composite) {
			Link link = new Link(composite, SWT.WRAP);
			try {
				link.setText(NLS.bind(PDEUIMessages.PluginExportWizard_Ant_errors_during_export_logs_generated, "<a>" + fLogLocation.getCanonicalPath() + "</a>")); //$NON-NLS-1$ //$NON-NLS-2$
			} catch (IOException e) {
				PDEPlugin.log(e);
			}
			GridData data = new GridData();
			data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
			link.setLayoutData(data);
			link.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					try {
						Program.launch(fLogLocation.getCanonicalPath());
					} catch (IOException ex) {
						PDEPlugin.log(ex);
					}
				}
			});
			return link;
		}
	}

	//	public  void createJarFromPlugin(final IProject project, Shell parentShell){
	//		JarPackageData description= new JarPackageData();
	//		IPath location= new Path("projectDir+File.separator+jarFileName");
	//		description.setJarLocation(location);
	//		description.setManifestMainClass(mainType);
	//		description.setExportClassFiles(true);
	//		description.setExportOutputFolders(false);
	//		description.setExportErrors(true);
	//		description.setExportWarnings(true);
	//		description.setOverwrite(true);
	//		description.setGenerateManifest(true);
	//		description.setElements(filestoExport);
	//		IJarExportRunnable runnable= description.createJarExportRunnable(parentShell);
	//		try {
	//		new ProgressMonitorDialog(parentShell).run(true,true, runnable);S
	//		} catch (InvocationTargetException e) {
	//		} catch (InterruptedException e) {
	//		} 
	//		return;
	//	}


	/**
	 * Delete.
	 * 
	 * @param project
	 *        the project to delete.
	 * @throws CoreException
	 *         the core exception
	 */
	public void delete(final IProject project) throws CoreException {
		IWorkspaceRunnable runnable = new IWorkspaceRunnable() {

			public void run(IProgressMonitor monitor) throws CoreException {
				//				jproject.setRawClasspath(new IClasspathEntry[0], jproject
				//						.getProject().getFullPath(), null);
				for(int i = 0; i < MAX_RETRY; i++) {
					try {
						IProject tmpProject = project.getProject();
						synchronized(tmpProject) {
							if(tmpProject.exists()) {
								tmpProject.delete(true, true, null);
							}
						}
						i = MAX_RETRY;
					} catch (CoreException e) {
						if(i == MAX_RETRY - 1) {

							throw e;
						}
						try {
							Thread.sleep(1000); // sleep a second
						} catch (InterruptedException e1) {
						}
					}
				}
			}
		};
		ResourcesPlugin.getWorkspace().run(runnable, null);
	}

	/**
	 * Gets the plugin model for project.
	 * 
	 * @param project
	 *        the project
	 * @return the plugin model for project
	 */
	public static IPluginModel getPluginModelForProject(final IProject project) {

		PluginModelManager pmm = PDECore.getDefault().getModelManager();
		IPluginModelBase[] wsPlugins = pmm.getWorkspaceModels();

		if(wsPlugins.length == 0) {
			//ErrorHandler.reportError("Project " + project.getName() + " is not a plugin project (no plugin projects)?", false);
			return null;
		}
		for(int i = 0; i < wsPlugins.length; i++) {
			IPluginModelBase wsPlugin = wsPlugins[i];



			// May get both workspace and project plugin models
			// (although only the latter are of interest)
			IPluginBase pmBase = wsPlugin.getPluginBase();
			if(pmBase == null) {
				continue;
			}
			String id = pmBase.getId();
			if(id == null) {
				continue;
			}
			String projName = project.getName();
			if(projName == null) {
				continue;
			}


			String resourceLocation = pmBase.getModel().getUnderlyingResource().getLocation().toString();
			if(resourceLocation.endsWith(projName + "/META-INF/MANIFEST.MF")) {
				return (IPluginModel)wsPlugin;
			}

		}
		//ErrorHandler.reportError("Could not find plugin for project " + project.getName(), false);
		return null;
	}

}
