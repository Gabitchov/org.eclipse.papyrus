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


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.filebuffers.FileBuffers;
import org.eclipse.core.filebuffers.ITextFileBuffer;
import org.eclipse.core.filebuffers.ITextFileBufferManager;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.FindReplaceDocumentAdapter;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.uml.export.Activator;
import org.eclipse.papyrus.uml.export.dialog.ProfilesToExportSelectionDialog;
import org.eclipse.papyrus.uml.export.messages.Messages;
import org.eclipse.papyrus.uml.export.util.ProfileUtil;
import org.eclipse.papyrus.uml.export.util.WSFileUtil;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;
import org.eclipse.uml2.uml.Profile;


// TODO: Auto-generated Javadoc
/**
 * The Class EditProfileApplicationAction.
 */
public class EditProfileApplicationAction extends ActionDelegate implements IActionDelegate {


	/**
	 * Selected model files.
	 */
	protected List<IFile> files;

	/**
	 * Gets the i file.
	 * 
	 * @param selectedObj
	 *        the selected obj
	 * @return the i file
	 */
	public static IFile getIFile(Object selectedObj) {
		IFile result = null;
		if(selectedObj instanceof IFile) {
			result = (IFile)selectedObj;
		}
		// Try to adapt
		if(result == null && selectedObj instanceof IAdaptable) {
			result = (IFile)((IAdaptable)selectedObj).getAdapter(IFile.class);
		}
		// adapt in ifile
		if(result == null) {
			result = (IFile)Platform.getAdapterManager().getAdapter(selectedObj, IFile.class);
		}
		if(result == null) {
			// try to check if it is a collection
			Collection<?> collec = (Collection<?>)Platform.getAdapterManager().getAdapter(selectedObj, Collection.class);
			if(collec != null) {
				for(Object o : collec) {
					if(o instanceof IFile) {
						IFile f = (IFile)o;
						if("uml".equals(f.getFileExtension())) {
							result = f;
							break;
						}
					}
				}
			}
		}
		return result != null && "uml".equals(result.getFileExtension()) ? result : null;
	}

	/**
	 * Checks if is profile application is editable.
	 * 
	 * @param selectedObj
	 *        the selected obj
	 * @return true, if is profile application editable
	 */
	public static boolean isProfileApplicationEditable(Object selectedObj) {
		IFile file = getIFile(selectedObj);
		if(file != null) {
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource umlResource = WSFileUtil.loadResource(file.getFullPath().toString(), resourceSet);
			if(umlResource.getContents().isEmpty()) {
				// The root doesn't exist.
				return false;
			}
			EObject root = umlResource.getContents().get(0);
			Object[] appliedProfiles = ProfileUtil.getAppliedProfilesFromWS(root);
			if(appliedProfiles != null) {
				for(int i = 0; i < appliedProfiles.length; i++) {
					String installedProfileURI = findCorrespondingInstalledProfile((Profile)appliedProfiles[i]);
					if(installedProfileURI != null) {
						return true;
					}

				}
			}
		}
		return false;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.actions.ActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public void selectionChanged(IAction action, ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			files = ((IStructuredSelection)selection).toList();
		}
	}

	/**
	 * Run.
	 * 
	 * @param action
	 *        the action
	 * @see org.eclipse.ui.actions.ActionDelegate#run(org.eclipse.jface.action.IAction)
	 */

	public void run(IAction action) {
		if(files != null) {
			Iterator<IFile> filesIt = files.iterator();
			IFile file = (IFile)filesIt.next();
			ResourceSet resourceSet = new ResourceSetImpl();
			ITextFileBufferManager manager = FileBuffers.getTextFileBufferManager();
			try {
				manager.connect(file.getFullPath(), null);
			} catch (CoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			final ITextFileBuffer buffer = manager.getTextFileBuffer(file.getFullPath());
			final IDocument doc = buffer.getDocument();
			final FindReplaceDocumentAdapter adapter = new FindReplaceDocumentAdapter(doc);
			final MultiTextEdit multiEdit = new MultiTextEdit();
			Resource umlResource = WSFileUtil.loadResource(file.getFullPath().toString(), resourceSet);
			if(umlResource.getContents().isEmpty()) {
				// The root doesn't exist.
				try {
					throw new NotFoundException(Messages.EditProfileApplicationAction_0);
				} catch (NotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			EObject root = umlResource.getContents().get(0);
			Object[] appliedProfiles = ProfileUtil.getAppliedProfilesFromWS(root);
			ArrayList<Object> appliedLocalProfiles = new ArrayList<Object>();
			for(int i = 0; i < appliedProfiles.length; i++) {
				String installedProfileURI = findCorrespondingInstalledProfile((Profile)appliedProfiles[i]);
				if(installedProfileURI != null) {
					appliedLocalProfiles.add(appliedProfiles[i]);
				}

			}
			if(appliedLocalProfiles != null && !appliedLocalProfiles.isEmpty()) {
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				final ProfilesToExportSelectionDialog dialog = new ProfilesToExportSelectionDialog(shell, true, appliedLocalProfiles.toArray(), "Change profile application from local to installed");

				dialog.open();
				if(Dialog.OK == dialog.getReturnCode()) {

					IRunnableWithProgress operation = new IRunnableWithProgress() {


						public void run(IProgressMonitor monitor) {
							Object[] profiles = dialog.getResult();
							for(int i = 0; i < profiles.length; i++) {
								if(profiles[i] instanceof Profile) {
									// TODO Auto-generated method stub

									String localProfileURI = ((Profile)profiles[i]).eResource().getURI().toString();


									//the applied local profile in the xmi file has an uri that is relative to the workspace, 
									//so adapt the uri that is in the preferences to fit in this format
									localProfileURI = localProfileURI.replace("platform:/resource/", "../"); //$NON-NLS-1$ //$NON-NLS-2$											

									String installedProfileURI = findCorrespondingInstalledProfile((Profile)profiles[i]);
									if(installedProfileURI != null) {

										try {
											WSFileUtil.replaceString(localProfileURI, installedProfileURI, adapter, doc, 0, multiEdit);
										} catch (BadLocationException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}

									}
								}


							}
							if(multiEdit.hasChildren()) {
								try {
									multiEdit.apply(doc);
								} catch (MalformedTreeException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (BadLocationException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								try {
									buffer.commit(null, true);
								} catch (CoreException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}


							}
						};
					};
					try {
						PlatformUI.getWorkbench().getProgressService().run(true, true, operation);
					} catch (InvocationTargetException e) {
						IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
						org.eclipse.papyrus.uml.export.Activator.getDefault().getLog().log(status);
					} catch (InterruptedException e) {
						IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
						org.eclipse.papyrus.uml.export.Activator.getDefault().getLog().log(status);
					}
				}
			} else {
				//launch an error message
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				MessageDialog.openError(shell, "Error", "No profile application to edit");
			}
		}


	}





	/**
	 * Find corresponding installed profile.
	 * 
	 * @param profile
	 *        the profile
	 * @return the corresponding installed profile uri
	 */
	public static String findCorrespondingInstalledProfile(Profile profile) {
		// TODO Auto-generated method stub
		IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode("org.eclipse.papyrus.uml.export"); //$NON-NLS-1$
		org.osgi.service.prefs.Preferences node = preferences.node("installedProfilesUriCorrespondance");
		String installedProfileURI = node.get(profile.eResource().getURI().toString(), "default"); //$NON-NLS-1$
		if((!installedProfileURI.equals("default"))) {
			URI uri = URI.createURI(installedProfileURI);
			try {
				ResourceSet resourceSet = new ResourceSetImpl();
				Resource resource = resourceSet.getResource(uri, true);
				//verify that the profile is indeed installed in the platform before replacing the uri
				if((resource.isLoaded()) && (!(resource.getContents().isEmpty()))) //$NON-NLS-1$
				{
					//System.err.println(installedProfileURI);
					return installedProfileURI;
				}
			} catch (WrappedException ex) {
				ex.printStackTrace();
			}
		} else
			return null;
		return null;

	}



}
