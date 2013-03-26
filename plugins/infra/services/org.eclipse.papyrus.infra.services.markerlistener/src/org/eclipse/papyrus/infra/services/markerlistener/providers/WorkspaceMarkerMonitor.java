/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.markerlistener.providers;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.ui.resources.FileChangeManager;
import org.eclipse.gmf.runtime.common.ui.resources.IFileObserver;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.services.markerlistener.PapyrusMarkerAdapter;
import org.eclipse.papyrus.infra.services.markerlistener.util.MarkerListenerUtils;


/**
 * This is the WorkspaceMarkerMonitor type.  Enjoy.
 */
public class WorkspaceMarkerMonitor
		extends AbstractMarkerMonitor {

	/** The file observer. */
	private MarkerObserver fileObserver;

	public WorkspaceMarkerMonitor() {
		super();
	}

	@Override
	public void initialize(ModelSet modelSet) {
		super.initialize(modelSet);
		
		this.fileObserver = new MarkerObserver(modelSet.getTransactionalEditingDomain());
		
		//Start Listening
		FileChangeManager.getInstance().addFileObserver(this.fileObserver);
	}

	@Override
	public void dispose() {
		//Stop Listening
		FileChangeManager.getInstance().removeFileObserver(this.fileObserver);
		
		super.dispose();
	}

	// 	File Listening Functions

	/**
	 * An asynchronous update interface for receiving notifications
	 * about Marker information as the Marker is constructed.
	 */
	class MarkerObserver implements IFileObserver {

		/** The domain. */
		private final TransactionalEditingDomain domain;
		
		/**
		 * This method is called when information about an Marker
		 * which was previously requested using an asynchronous
		 * interface becomes available.
		 * 
		 * @param domain
		 *        the domain
		 */
		public MarkerObserver(TransactionalEditingDomain domain) {
			this.domain = domain;
		}

		/**
		 * handle changes of file name.
		 * 
		 * @param oldFile
		 *        the old file
		 * @param file
		 *        the file
		 */
		public void handleFileRenamed(IFile oldFile, IFile file) {
		}

		/**
		 * @see org.eclipse.gmf.runtime.common.ui.resources.IFileObserver#handleFileMoved(org.eclipse.core.resources.IFile,
		 *      org.eclipse.core.resources.IFile)
		 * 
		 * @param oldFile
		 * @param file
		 */

		public void handleFileMoved(IFile oldFile, IFile file) {
		}

		/**
		 * @see org.eclipse.gmf.runtime.common.ui.resources.IFileObserver#handleFileDeleted(org.eclipse.core.resources.IFile)
		 * 
		 * @param file
		 */

		public void handleFileDeleted(IFile file) {
		}

		/**
		 * @see org.eclipse.gmf.runtime.common.ui.resources.IFileObserver#handleFileChanged(org.eclipse.core.resources.IFile)
		 * 
		 * @param file
		 */

		public void handleFileChanged(IFile file) {
		}

		/**
		 * A marker has been added, treat as change.
		 * 
		 * @param marker
		 *        the marker
		 */
		public void handleMarkerAdded(IMarker marker) {
			handleMarkerChanged(marker);
		}

		/**
		 * A marker has been deleted. Need to treat separately from change, since old values are not stored in
		 * marker, but in attribute map
		 * 
		 * @param marker
		 *        the marker
		 * @param attributes
		 *        the attributes
		 */
		public void handleMarkerDeleted(IMarker marker, @SuppressWarnings("rawtypes") Map attributes) {
			EObject eObjectFromMarker = MarkerListenerUtils.eObjectFromMarkerOrMap(null, attributes, domain);
			if(eObjectFromMarker != null) {
				Resource resource = eObjectFromMarker.eResource();
				fireMarkerRemoved(PapyrusMarkerAdapter.wrap(resource, marker, attributes));
			}
		}

		/**
		 * A marker has changed.
		 * 
		 * @param marker
		 *        the marker
		 */
		public void handleMarkerChanged(IMarker marker) {
			EObject eObjectFromMarker = MarkerListenerUtils.eObjectFromMarkerOrMap(marker, null, domain);
			if(eObjectFromMarker != null) {
				Resource resource = eObjectFromMarker.eResource();
				fireMarkerAdded(PapyrusMarkerAdapter.wrap(resource, marker));
			}
		}
	}

}
