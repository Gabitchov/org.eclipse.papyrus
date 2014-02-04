/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.engine;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.DiagramHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.Activator;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.swt.widgets.Display;

/**
 * A CSS Engine for the current Eclipse Project
 * 
 * Note: Some models are not necessarily stored in a Project (e.g. CDO Models)
 * 
 * @author Camille Letavernier
 * 
 */
public class ProjectCSSEngine extends ExtendedCSSEngineImpl {

	private IResourceChangeListener resourceListener = new IResourceChangeListener() {

		public void resourceChanged(IResourceChangeEvent event) {
			if(project != null) {
				try {
					if(event != null && event.getDelta() != null) {
						event.getDelta().accept(new IResourceDeltaVisitor() {

							public boolean visit(IResourceDelta delta) throws CoreException {
								if(delta.getResource().equals(stylesheetPreferences)) {
									ProjectCSSEngine.this.reset();
									DiagramHelper.setNeedsRefresh();
									Display.getDefault().asyncExec(new Runnable() {

										public void run() {
											DiagramHelper.refreshDiagrams();
										}
									});

									return false;
								}

								return true;
							}

						});
					}
				} catch (CoreException ex) {
					Activator.log.error(ex);
				}
			}
		}
	};

	/**
	 * The file name of the EMF Model containing the {@link StyleSheet}s.
	 * It will be stored in the project's preferences scope (Typically the .settings folder)
	 * 
	 * @see {@link ProjectScope}
	 */
	public static String PROJECT_STYLESHEETS = "stylesheets.xmi"; //$NON-NLS-1$

	/**
	 * The Engine's project. May be null or closed, or may not exist
	 */
	protected IProject project;

	protected IFile stylesheetPreferences;

	public ProjectCSSEngine(Resource modelResource) {
		super(WorkspaceCSSEngine.instance);

		URI resourceURI = modelResource.getURI();
		if(resourceURI.isPlatformResource()) {
			String platformString = resourceURI.toPlatformString(true);
			try {
				IPath workspacePath = new Path(platformString);
				this.project = ResourcesPlugin.getWorkspace().getRoot().getFile(workspacePath).getProject();
				IPath preferencesAbsolutePath = new ProjectScope(project).getLocation().append(PROJECT_STYLESHEETS);
				IPath projectRelativePath = preferencesAbsolutePath.makeRelativeTo(project.getLocation());
				stylesheetPreferences = project.getFile(projectRelativePath);
				ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceListener);
			} catch (Exception ex) {
				Activator.log.error(ex);
			}
		}
	}

	@Override
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceListener);
		super.dispose();
	}

	@Override
	protected void reloadStyleSheets() {
		styleSheets.clear();
		if(project == null || !project.exists() || !project.isOpen()) {
			return;
		}

		if(stylesheetPreferences == null || !stylesheetPreferences.exists()) {
			return;
		}

		IPath workspacePath = stylesheetPreferences.getFullPath();

		URI workspaceURI = URI.createPlatformResourceURI(workspacePath.toString(), true);

		ResourceSet resourceSet = new ResourceSetImpl();
		try {
			Resource stylesheetsResource = resourceSet.getResource(workspaceURI, true);
			for(EObject rootElement : stylesheetsResource.getContents()) {
				if(rootElement instanceof StyleSheet) {
					//Do not call super#addStyleSheet(styleSheet) to avoid a StackOverFlow
					styleSheets.add((StyleSheet)rootElement);
				}
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	@SuppressWarnings("restriction")
	@Override
	protected void parseStyleSheet(StyleSheetReference styleSheet) throws IOException {
		String path = styleSheet.getPath();
		if(path.startsWith("/")) { //$NON-NLS-1$
			super.parseStyleSheet(styleSheet);
		} else {
			//Parse relative paths from the Project
			if(project != null && project.exists() && project.isOpen()) {
				IFile file = project.getFile(path);

				if(file.exists()) {
					try {
						parseStyleSheet(file.getContents());
					} catch (CoreException ex) {
						Activator.log.error(ex);
					}
				}
			}
		}
	}
}
