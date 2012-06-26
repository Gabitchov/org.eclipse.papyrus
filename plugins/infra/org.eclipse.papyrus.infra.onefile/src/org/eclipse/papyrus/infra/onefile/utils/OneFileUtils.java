/*****************************************************************************
 * Copyright (c) 2011 Atos Origin Integration.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin Integration) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.onefile.utils;

import java.util.ArrayList;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.onefile.Activator;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.PapyrusModelHelper;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;

/**
 * Utility methods
 * 
 * @author tristan.faure@atosorigin.com
 * 
 */
public class OneFileUtils {

	/**
	 * Determines if a di exist in the container from a file name
	 * 
	 * @param fileName
	 * @param parent
	 * @return
	 */
	public static boolean diExists(String fileName, IContainer parent) {
		return getDi(fileName, parent) != null;
	}

	/**
	 * Determines if a di exist in the container from a file name
	 * 
	 * @param fileName
	 * @param parent
	 * @return
	 */
	public static IFile getDi(String fileName, IContainer parent) {
		if(parent == null || parent.getType() == IResource.ROOT) {
			return null;
		}
		String substring = fileName;
		if(fileName.indexOf('.') > 0) {
			substring = fileName.substring(0, fileName.lastIndexOf('.'));
		}
		IFile file = parent.getFile(new Path(substring + "." + DiModel.DI_FILE_EXTENSION));
		if(file.exists()) {
			return file;
		}
		return null;
	}

	/**
	 * check if the element has children or not
	 * 
	 * @param element
	 * @return
	 */
	public static boolean hasChildren(Object element) {
		if(element instanceof IContainer) {
			IContainer container = (IContainer)element;
			try {
				return container.members().length > 0;
			} catch (CoreException e) {
			}
		}
		if(element instanceof IPapyrusFile) {
			IPapyrusFile iPapyrusFile = (IPapyrusFile)element;
			return iPapyrusFile.getMainFile() != null && iPapyrusFile.getAssociatedResources().length > 1;
		}
		return false;
	}

	/**
	 * Check if the element in parameter is visible or not
	 * 
	 * @param element
	 * @return
	 */
	public static boolean isVisible(Object element) {
		if(element instanceof IFile) {
			IFile file = (IFile)element;
			return !OneFileUtils.diExists(file.getName(), file.getParent());
		}
		return true; //Don't filter unknown types
	}

	/**
	 * Check if the resource is a Papyrus Di
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean isDi(IResource fileName) {
		return PapyrusModelHelper.getPapyrusModelFactory().isDi(fileName);
	}

	/**
	 * Returns the name without the extension of the file
	 * 
	 * @param res
	 * @return
	 */
	public static String withoutFileExtension(IResource res) {
		if(res.getFileExtension() != null && res.getFileExtension().length() > 0) {
			return res.getName().substring(0, res.getName().lastIndexOf('.'));
		} else {
			return res.getName();
		}
	}

	/**
	 * Check if the resource has a DI inside it
	 * 
	 * @param resource
	 * @return
	 */
	public static boolean containsModelFiles(IResource resource) {
		if(resource instanceof IContainer) {
			IContainer container = (IContainer)resource;
			try {
				for(IResource m : container.members()) {
					if(isDi(m)) {
						return true;
					}
				}
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * Check if the object is in an already opened editor
	 * 
	 * @param inputElement
	 * @return
	 */
	public static IEditorPart isOpenInEditor(Object inputElement) {
		IEditorPart editor = findEditor(inputElement, false);
		if(editor != null) {
			return editor;
		}
		IEditorInput input = getEditorInput(inputElement);
		if(input != null) {

			IWorkbenchPage p = getActivePage();
			if(p != null) {
				return p.findEditor(input);
			}
		}
		return null;
	}

	/**
	 * Find an editor opening the input element
	 * 
	 * @param inputElement
	 * @param activate
	 *        , if activate is true, once the editor is found it is
	 *        activated
	 * @return null if no editor is found
	 */
	private static IEditorPart findEditor(Object inputElement, boolean activate) {
		if(inputElement instanceof IPapyrusFile) {
			IPapyrusFile cu = (IPapyrusFile)inputElement;
			if(cu != null) {
				IWorkbenchPage page = getActivePage();
				for(IEditorReference ref : page.getEditorReferences()) {
					IEditorPart editor = ref.getEditor(false);
					if(editor != null) {
						IEditorInput editorInput;
						editorInput = editor.getEditorInput();
						if(cu.getMainFile().equals(editorInput.getAdapter(IFile.class))) {
							if(activate && page.getActivePart() != editor) {
								page.activate(editor);
							}
							return editor;
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Open the editor corresponding to the inpur element
	 * 
	 * @param inputElement
	 * @param activate
	 * @return
	 * @throws PartInitException
	 */
	public static IEditorPart openInEditor(Object inputElement, boolean activate) throws PartInitException {

		if(inputElement instanceof IFile) {
			return openInEditor((IFile)inputElement, activate);
		}
		IEditorPart editor = findEditor(inputElement, activate);
		if(editor != null) {
			return editor;
		}
		IEditorInput input = getEditorInput(inputElement);
		if(input == null) {
			throw new PartInitException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "not found"));
		}
		return openInEditor(input, getEditorID(input), activate);
	}

	/**
	 * Get the editor input for the given element
	 * 
	 * @param inputElement
	 * @return
	 */
	private static IEditorInput getEditorInput(Object inputElement) {
		if(inputElement instanceof IFile) {
			IFile file = (IFile)inputElement;
			return new FileEditorInput(file);
		}
		return null;
	}

	/**
	 * Get the editor id for an editor input
	 * 
	 * @param input
	 * @return
	 * @throws PartInitException
	 */
	public static String getEditorID(IEditorInput input) throws PartInitException {

		Assert.isNotNull(input);

		IEditorDescriptor editorDescriptor;

		if(input instanceof IFileEditorInput) {
			editorDescriptor = IDE.getEditorDescriptor(((IFileEditorInput)input).getFile());
		} else {
			editorDescriptor = IDE.getEditorDescriptor(input.getName());
		}
		return editorDescriptor.getId();

	}

	/**
	 * @param file
	 * @param activate
	 * @return
	 * @throws PartInitException
	 */
	private static IEditorPart openInEditor(IFile file, boolean activate) throws PartInitException {

		if(file == null) {
			throw new PartInitException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "not found"));
		}

		IWorkbenchPage p = getActivePage();

		if(p == null) {
			throw new PartInitException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "not found"));
		}

		IEditorPart editorPart = IDE.openEditor(p, file, activate);

		return editorPart;

	}

	/**
	 * Get the active Page
	 * 
	 * @return
	 */
	public static IWorkbenchPage getActivePage() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		if(workbench == null) {
			return null;
		}
		IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
		if(activeWorkbenchWindow == null) {
			return null;
		}
		return activeWorkbenchWindow.getActivePage();
	}

	private static IEditorPart openInEditor(IEditorInput input, String editorID, boolean activate) throws PartInitException {
		Assert.isNotNull(input);
		Assert.isNotNull(editorID);
		IWorkbenchPage p = getActivePage();
		if(p == null) {
			throw new PartInitException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "not found"));
		}
		IEditorPart editorPart = p.openEditor(input, editorID, activate);
		return editorPart;

	}

	public static IFile[] getAssociatedFiles(IPapyrusFile papyrusFile) {
		ArrayList<IFile> files = new ArrayList<IFile>();
		for(IResource res : papyrusFile.getAssociatedResources()) {
			if(res instanceof IFile) {
				files.add((IFile)res);
			}
		}
		return files.toArray(new IFile[files.size()]);
	}
}
