package org.eclipse.papyrus.infra.widgets.editors;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.infra.widgets.selectors.NullSelector;
import org.eclipse.papyrus.infra.widgets.util.FileUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;

/**
 * A Widget for editing multi-valued Strings with File paths
 * The file paths may be absolute (FileSystem paths) or relative to the workspace (Workspace paths)
 * 
 * @author Camille Letavernier
 */
public class MultipleStringFileEditor extends MultipleValueEditor {

	protected boolean allowBrowseWorkspace = true;

	protected boolean allowBrowseFileSystem = true;

	protected Button browseFileSystem;

	protected Button browseWorkspace;

	protected final List<String> filterNames;

	protected final List<String> filterExtensions;

	public static final String browseWorkspaceIcon = "icons/browse-workspace_12x12.png"; //$NON-NLS-1$

	public static final String browseFileSystemIcon = "icons/browse-filesystem_12x12.png"; //$NON-NLS-1$

	public MultipleStringFileEditor(Composite parent, int style) {
		super(parent, style, NullSelector.instance);
		setDirectCreation(true);

		filterNames = new LinkedList<String>();
		filterExtensions = new LinkedList<String>();
	}

	@Override
	protected void createListControls() {
		super.createListControls();
		add.dispose();
		edit.dispose();

		browseFileSystem = createButton(Activator.getDefault().getImageFromPlugin(browseFileSystemIcon), "Browse file system");
		browseWorkspace = createButton(Activator.getDefault().getImageFromPlugin(browseWorkspaceIcon), "Browse workspace");

		browseWorkspace.moveAbove(remove);
		browseFileSystem.moveAbove(remove);
	}

	@Override
	public void setDirectCreation(boolean directCreation) {
		super.setDirectCreation(true); //Always true
	}

	@Override
	protected void updateControls() {
		remove.setEnabled(!readOnly);
		up.setEnabled(ordered && !readOnly);
		down.setEnabled(ordered && !readOnly);

		browseWorkspace.setEnabled(allowBrowseWorkspace);
		browseFileSystem.setEnabled(allowBrowseFileSystem);
	}

	public void allowBrowseWorkspace(boolean allowBrowseWorkspace) {
		this.allowBrowseWorkspace = allowBrowseWorkspace;
	}

	public void allowBrowseFileSystem(boolean allowBrowseFileSystem) {
		this.allowBrowseFileSystem = allowBrowseFileSystem;
	}

	/**
	 * Handle events occuring on controls
	 * 
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 * 
	 * @param e
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {
		super.widgetSelected(e);
		if(e.widget == browseFileSystem) {
			browseFileSystem();
		} else if(e.widget == browseWorkspace) {
			browseWorkspace();
		}
	}

	protected void browseFileSystem() {
		//		File file = FileUtil.getFile(text.getText());

		FileDialog dialog = new FileDialog(getShell(), SWT.MULTI | SWT.OPEN);
		dialog.setFilterExtensions(filterExtensions.toArray(new String[filterExtensions.size()]));
		dialog.setFilterNames(filterNames.toArray(new String[filterNames.size()]));
		if(dialog.open() != null) {
			List<String> filePathList = new ArrayList<String>(modelProperty.size() + dialog.getFileNames().length);
			filePathList.addAll(modelProperty);

			for(String fileName : dialog.getFileNames()) {
				filePathList.add(dialog.getFilterPath() + File.separator + fileName);
			}

			modelProperty.clear();
			modelProperty.addAll(filePathList);
			commit();
		}
	}

	protected void browseWorkspace() {
		IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();

		ResourceSelectionDialog dialog = new ResourceSelectionDialog(getShell(), workspace, ""); //$NON-NLS-1$

		//		IStructuredSelection currentSelection = (IStructuredSelection)this.treeViewer.getSelection();
		//		if(!currentSelection.isEmpty()) {
		//			List<IFile> selectedFiles = new LinkedList<IFile>();
		//			for(Object selection : currentSelection.toArray()) {
		//				if(selection instanceof String) {
		//					IFile currentFile = FileUtil.getIFile((String)selection);
		//					if(currentFile != null) {
		//						selectedFiles.add(currentFile);
		//					}
		//				}
		//			}
		//			dialog.setInitialSelections(selectedFiles.toArray(new IFile[selectedFiles.size()]));
		//		}

		int code = dialog.open();
		if(code == Window.OK) {
			Object[] result = dialog.getResult();
			if(result.length > 0) {
				List<String> filePathResult = new ArrayList<String>(result.length + modelProperty.size());
				filePathResult.addAll(modelProperty);
				for(Object file : result) {
					if(file instanceof IFile) {
						filePathResult.add(FileUtil.getPath((IFile)file, false));
					}
				}
				modelProperty.clear();
				modelProperty.addAll(filePathResult);
				commit();
			}
		}
	}

}
