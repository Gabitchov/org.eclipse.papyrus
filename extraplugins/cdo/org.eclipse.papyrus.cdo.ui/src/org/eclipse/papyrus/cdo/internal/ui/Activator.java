package org.eclipse.papyrus.cdo.internal.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.cdo.admin.CDOAdminClientManager;
import org.eclipse.emf.cdo.dawn.editors.IDawnEditor;
import org.eclipse.emf.cdo.dawn.helper.DawnEditorHelper;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.ui.util.DialogCredentialsProviderFactory;
import org.eclipse.papyrus.cdo.internal.ui.util.UIUtil;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

	public static final String ICON_ADD_REPOSITORY = "add_repository"; //$NON-NLS-1$

	public static final String ICON_OPEN_REPOSITORY = "open_repository"; //$NON-NLS-1$

	public static final String ICON_CLOSED_REPOSITORY = "closed_repository"; //$NON-NLS-1$

	public static final String ICON_CONNECT_REPOSITORY_ENABLED = "connect_repo_ena"; //$NON-NLS-1$

	public static final String ICON_CONNECT_REPOSITORY_DISABLED = "connect_repo_dis"; //$NON-NLS-1$

	public static final String ICON_DISCONNECT_REPOSITORY_ENABLED = "disconnect_repo_ena"; //$NON-NLS-1$

	public static final String ICON_DISCONNECT_REPOSITORY_DISABLED = "disconnect_repo_dis"; //$NON-NLS-1$

	public static final String ICON_CONFLICTED_OVERLAY24 = "conflicted_ovr24"; //$NON-NLS-1$

	public static final String ICON_CONFLICTED_OVERLAY16 = "conflicted_ovr16"; //$NON-NLS-1$

	public static final String ICON_OTHER_LOCKED_OVERLAY24 = "other_locked_ovr24"; //$NON-NLS-1$

	public static final String ICON_OTHER_LOCKED_OVERLAY16 = "other_locked_ovr16"; //$NON-NLS-1$

	public static final String ICON_SELF_LOCKED_OVERLAY24 = "self_locked_ovr24"; //$NON-NLS-1$

	public static final String ICON_SELF_LOCKED_OVERLAY16 = "self_locked_ovr16"; //$NON-NLS-1$

	public static final String ICON_PAPYRUS_MODEL = "papyrus_model"; //$NON-NLS-1$

	public static final String ICON_CREATE_FOLDER = "create_folder"; //$NON-NLS-1$

	public static final String ICON_DEPENDENT_OVERLAY16 = "dependent_ovr16"; //$NON-NLS-1$

	public static final String ICON_LINK_WITH_EDITOR = "link_editor"; //$NON-NLS-1$

	public static final String ICON_PAPYRUS_CDO_WIZARD = "cdo_wizard"; //$NON-NLS-1$

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.cdo.ui"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/** Logging helper */
	public static LogHelper log = new LogHelper();

	/**
	 * The constructor
	 */
	public Activator() {
		super();
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		// register the log helper
		log.setPlugin(plugin);

		CDOUtils.setBroadcastExecutor(UIUtil.uiSafeExecutor());

		PapyrusRepositoryManager.INSTANCE.setCredentialsProviderFactory(new DialogCredentialsProviderFactory());
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		log = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	protected ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, "$nl$/icons/" + path); //$NON-NLS-1$
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		super.initializeImageRegistry(reg);

		reg.put(ICON_ADD_REPOSITORY, getImageDescriptor("full/ctool16/add_repo.gif")); //$NON-NLS-1$

		reg.put(ICON_OPEN_REPOSITORY, getImageDescriptor("full/obj16/repo_open.gif")); //$NON-NLS-1$

		reg.put(ICON_CLOSED_REPOSITORY, getImageDescriptor("full/obj16/repo_closed.gif")); //$NON-NLS-1$

		reg.put(ICON_CONNECT_REPOSITORY_ENABLED, getImageDescriptor("full/elcl16/connect_co.gif")); //$NON-NLS-1$

		reg.put(ICON_CONNECT_REPOSITORY_DISABLED, getImageDescriptor("full/dlcl16/connect_co.gif")); //$NON-NLS-1$

		reg.put(ICON_DISCONNECT_REPOSITORY_ENABLED, getImageDescriptor("full/elcl16/disconnect_co.gif")); //$NON-NLS-1$

		reg.put(ICON_DISCONNECT_REPOSITORY_DISABLED, getImageDescriptor("full/dlcl16/disconnect_co.gif")); //$NON-NLS-1$

		reg.put(ICON_CONFLICTED_OVERLAY24, getImageDescriptor("full/ovr24/conflicted.gif")); //$NON-NLS-1$

		reg.put(ICON_CONFLICTED_OVERLAY16, getImageDescriptor("full/ovr16/conflicted.gif")); //$NON-NLS-1$

		reg.put(ICON_OTHER_LOCKED_OVERLAY24, getImageDescriptor("full/ovr24/other_locked.gif")); //$NON-NLS-1$

		reg.put(ICON_OTHER_LOCKED_OVERLAY16, getImageDescriptor("full/ovr16/other_locked.gif")); //$NON-NLS-1$

		reg.put(ICON_SELF_LOCKED_OVERLAY24, getImageDescriptor("full/ovr24/self_locked.gif")); //$NON-NLS-1$

		reg.put(ICON_SELF_LOCKED_OVERLAY16, getImageDescriptor("full/ovr16/self_locked.gif")); //$NON-NLS-1$

		reg.put(ICON_PAPYRUS_MODEL, getImageDescriptor("full/obj16/papyrus_model.gif")); //$NON-NLS-1$

		reg.put(ICON_CREATE_FOLDER, getImageDescriptor("full/elcl16/newfolder_co.gif")); //$NON-NLS-1$

		reg.put(ICON_DEPENDENT_OVERLAY16, getImageDescriptor("full/ovr16/dependent.gif")); //$NON-NLS-1$

		reg.put(ICON_LINK_WITH_EDITOR, getImageDescriptor("full/ctool16/link_editor.gif")); //$NON-NLS-1$

		reg.put(ICON_PAPYRUS_CDO_WIZARD, getImageDescriptor("full/wizban/Papyrus_CDO.png")); //$NON-NLS-1$
	}

	public static ImageDescriptor getIcon(String key) {
		return getDefault().getImageRegistry().getDescriptor(key);
	}

	public static IDawnEditor getActiveDawnEditor() {
		IDawnEditor result = null;
		IEditorPart editor = DawnEditorHelper.getActiveEditor();

		if(editor instanceof IDawnEditor) {
			result = (IDawnEditor)editor;
		} else {
			result = (IDawnEditor)editor.getAdapter(IDawnEditor.class);
		}

		return result;
	}

	public static IStatus error(String message) {
		return error(message, null);
	}

	public static IStatus error(String message, Throwable exception) {
		return new Status(IStatus.ERROR, PLUGIN_ID, message, exception);
	}

	@SuppressWarnings("restriction")
	public static CDOAdminClientManager getCDOAdminClientManager() {
		return org.eclipse.emf.cdo.ui.internal.admin.bundle.OM.getAdminManager();
	}
}
