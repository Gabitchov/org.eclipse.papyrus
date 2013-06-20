package org.eclipse.papyrus.qompass.designer.cpp;

import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.cdt.core.settings.model.CIncludePathEntry;
import org.eclipse.cdt.core.settings.model.CMacroEntry;
import org.eclipse.cdt.core.settings.model.ICConfigurationDescription;
import org.eclipse.cdt.core.settings.model.ICFolderDescription;
import org.eclipse.cdt.core.settings.model.ICLanguageSetting;
import org.eclipse.cdt.core.settings.model.ICLanguageSettingEntry;
import org.eclipse.cdt.core.settings.model.ICProjectDescription;
import org.eclipse.cdt.core.settings.model.ICProjectDescriptionManager;
import org.eclipse.cdt.core.settings.model.ICSettingEntry;
import org.eclipse.cdt.managedbuilder.core.IConfiguration;
import org.eclipse.cdt.managedbuilder.core.IOption;
import org.eclipse.cdt.managedbuilder.core.ITool;
import org.eclipse.cdt.managedbuilder.core.ManagedBuildManager;
import org.eclipse.cdt.ui.wizards.CCProjectWizard;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.C_Cpp.ExternLibrary;
import org.eclipse.papyrus.FCM.OperatingSystem;
import org.eclipse.papyrus.FCM.Target;
import org.eclipse.papyrus.cpp.codegen.transformation.CppModelElementsCreator;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepUtils;
import org.eclipse.papyrus.qompass.designer.core.extensions.ILangSupport;
import org.eclipse.papyrus.qompass.designer.core.preferences.QompassPreferenceConstants;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;

/**
 * C/C++ language support
 * 
 * @author ansgar
 */
public class CppLanguageSupport implements ILangSupport {

	/**
	 * Caller should test before calling, whether the project exists already
	 * 
	 * @param projectName
	 * @return
	 */
	public IProject createProject(String projectName, InstanceSpecification node) throws TransformationException
	{
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		IProject project = root.getProject(projectName);
		try {
			IWorkbench wb = PlatformUI.getWorkbench();

			final CCProjectWizard wiz = new CCNamedProjectWizard(projectName);
			// use general selection dialog instead

			wiz.setWindowTitle("create project " + projectName);
			wiz.init(wb, null);

			Display.getDefault().syncExec(new Runnable() {

				public void run() {
					Shell shell = new Shell();
					WizardDialog wizDiag = new WizardDialog(shell, wiz);

					wizDiag.create();
					wizDiag.open();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			project = null;
		}
		if((project == null) || !project.exists()) {
			throw new TransformationException("could not create CDT project ...");
		}
		setProject(project);
		setSettings(node);
		return project;
	}

	public void setProject(IProject project) {
		m_project = project;
		IPreferenceStore store = org.eclipse.papyrus.qompass.designer.core.Activator.getDefault().getPreferenceStore();
		String prefix = store.getString(QompassPreferenceConstants.P_CODE_GEN_PREFIX) + "\n\n";
		creator = new CppModelElementsCreator(project, prefix);
	}

	public void setSettings(InstanceSpecification node) throws TransformationException
	{
		try {
			// ((CProject) project).
			IProjectDescription desc = m_project.getDescription();
			for(ICommand ic : desc.getBuildSpec()) {
				Log.log(Log.INFO_MSG, Log.CODEGEN, "CppLanguageSupport - read build spec: " + ic);
			}
			ICProjectDescriptionManager mngr =
				CoreModel.getDefault().getProjectDescriptionManager();
			ICProjectDescription cdesc = mngr.getProjectDescription(m_project, true);

			// loop over all configurations
			for(ICConfigurationDescription configDescr : cdesc.getConfigurations()) {

				ICFolderDescription folderDescription =
					configDescr.getRootFolderDescription();

				ICLanguageSetting[] languageSettings = folderDescription.getLanguageSettings();

				// copy string array into ICLanguageSetting array
				ICLanguageSettingEntry[] icIncludePaths = new ICLanguageSettingEntry[includePaths.size()];
				for(int i = 0; i < includePaths.size(); i++) {
					icIncludePaths[i] = new CIncludePathEntry(includePaths.get(i), CIncludePathEntry.VALUE_WORKSPACE_PATH);
				}

				// define name of used operating system from model (attribute of "Target" stereotype)
				// and add it to list of macros
				Target target = StUtils.getApplication(node, Target.class);
				if(target == null) {
					// get information from node referenced by the instance
					target = StUtils.getApplication(DepUtils.getClassifier(node), Target.class);
				}
				if(target != null) {
					OperatingSystem os = target.getUsedOS();
					if(os != null) {
						macros.add("OS_" + os.getBase_Class().getName());
					}
				}

				// define macros
				EList<ICLanguageSettingEntry> icMacros =
					new BasicEList<ICLanguageSettingEntry>();
				for(int i = 0; i < macros.size(); i++) {
					// TODO: need to define values for macros as well?
					icMacros.add(new CMacroEntry(macros.get(i), "", 0));
				}

				// now set include path and preprocessor code
				for(ICLanguageSetting lang : languageSettings) {
					// selection better via ID? (instead of extension)
					Log.log(Log.INFO_MSG, Log.CODEGEN, "CppLanguageSupport: lang.getID: " + lang.getId() + " lang.getLanguageID: " + lang.getLanguageId());
					for(String ext : lang.getSourceExtensions()) {
						if(ext.equals("cpp") || ext.equals("c")) {
							lang.setSettingEntries(ICSettingEntry.INCLUDE_PATH, icIncludePaths);
							ICLanguageSettingEntry icOldMacros[] =
								lang.getSettingEntries(ICSettingEntry.MACRO);
							for(ICLanguageSettingEntry entry : icOldMacros) {
								icMacros.add(entry);
							}
							lang.setSettingEntries(ICSettingEntry.MACRO, icMacros);
							break;
						}
					}
				}
				IConfiguration main = ManagedBuildManager.getConfigurationForDescription(configDescr);
				// change artifact name
				// main.setArtifactName(main.getArtifactName () + ".bin");

				// add to -l (libraries)
				ITool cfTool = main.calculateTargetTool();

				// IOption libOption = cfTool.getOptionBy(IOption.TYPE_LIB);

				for(IOption opt : cfTool.getOptions()) {
					if(opt.getValueType() == IOption.LIBRARIES) {
						main.setOption(cfTool, opt, libs.toArray(new String[0]));
					} else if(opt.getValueType() == IOption.LIBRARY_PATHS) {
						main.setOption(cfTool, opt, libPaths.toArray(new String[0]));
					}
				}
				mngr.setProjectDescription(m_project, cdesc, true, null);
			}
			ManagedBuildManager.saveBuildInfo(m_project, true);
		} catch (Exception e) {
			throw new TransformationException(e.getMessage());
		}
	}

	public void generateCode(IProgressMonitor monitor, PackageableElement element)
		throws TransformationException
	{
		try {
			creator.createPackageableElement(monitor, element);
		} catch (CoreException exception) {
			throw new TransformationException("Exception during C/C++ code generation: " + exception.toString());
		}
	}

	public void cleanCode(IProgressMonitor monitor, PackageableElement element)
		throws TransformationException
	{
		try {
			creator.removePackageableElement(monitor, element);
		} catch (CoreException exception) {
			throw new TransformationException("Exception during C/C++ code generation: " + exception.toString());
		}
	}

	public void resetConfigurationData() {
		includePaths = new UniqueEList<String>();
		// include project directory (all paths are relative to it => ".")
		includePaths.add(".");
		// include also "root" (relative path) 
		includePaths.add("root");

		libs = new UniqueEList<String>();
		libPaths = new UniqueEList<String>();
		macros = new UniqueEList<String>();
	}

	public void gatherConfigData(Class implementation) {
		Element owner = implementation.getOwner();
		while(owner instanceof Package) {
			ExternLibrary cppLibrary = StUtils.getApplication(owner, ExternLibrary.class);
			if(cppLibrary != null) {
				includePaths.addAll(cppLibrary.getIncludes());
				for(String libPath : cppLibrary.getLibPaths()) {
					if(libPath.startsWith("/")) {
						// libPaths starting with a slash are relative to workspace location
						// TODO: need to support absolute paths (host file system?) as well?
						// (additional prefix. Eclipse standards?) Problem: workspace_loc is added
						// automatically for absolute includePaths 
						libPaths.add("${workspace_loc:" + libPath + "}");
					} else {
						// relative to project root, otherwise
						libPaths.add(libPath);
					}
				}
				libs.addAll(cppLibrary.getLibs());
				macros.addAll(cppLibrary.getMacros());
			}
			owner = owner.getOwner();
		}
	}

	static EList<String> includePaths;

	static EList<String> libs;

	static EList<String> libPaths;

	static EList<String> macros;

	static CppModelElementsCreator creator;

	static IProject m_project;
}
