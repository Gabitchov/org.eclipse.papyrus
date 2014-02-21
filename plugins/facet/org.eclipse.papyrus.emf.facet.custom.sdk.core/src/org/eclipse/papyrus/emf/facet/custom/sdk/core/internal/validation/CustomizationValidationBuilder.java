/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 375054 - Add validation warning for overlay on EClass
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.custom.sdk.core.internal.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.marker.MarkerUtil;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.papyrus.emf.facet.common.sdk.core.internal.exported.IEmfFacetProjectBuilder;
import org.eclipse.papyrus.emf.facet.custom.core.internal.exported.Constants;

/** A builder that validates customization model files. */
public class CustomizationValidationBuilder implements IEmfFacetProjectBuilder, IResourceDeltaVisitor, IResourceVisitor {

	public IProject[] build(final IncrementalProjectBuilder builder, final int kind, final Map<?, ?> args, final IProgressMonitor monitor) throws CoreException {
		if (kind == IncrementalProjectBuilder.FULL_BUILD) {
			fullBuild(builder);
		} else {
			final IResourceDelta delta = builder.getDelta(builder.getProject());
			if (delta == null) {
				fullBuild(builder);
			} else {
				incrementalBuild(delta);
			}
		}
		return new IProject[0];
	}

	public void clean(final IncrementalProjectBuilder builder, final IProgressMonitor monitor) throws CoreException {
		builder.getProject().accept(new IResourceVisitor() {
			public boolean visit(final IResource resource) throws CoreException {
				if (isCustomizationFile(resource)) {
					resource.deleteMarkers(MarkerUtil.VALIDATION_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
				}
				return true;
			}
		});
	}

	private void incrementalBuild(final IResourceDelta delta) throws CoreException {
		delta.accept(this);
	}

	private void fullBuild(final IncrementalProjectBuilder builder) throws CoreException {
		builder.getProject().accept(this);
	}

	protected static boolean isCustomizationFile(final IResource resource) {
		return resource.getType() == IResource.FILE
				&& Constants.CUSTOM_FILE_EXT
						.equals(resource.getFileExtension());
	}

	public boolean visit(final IResourceDelta delta) throws CoreException {
		if (isCustomizationFile(delta.getResource())) {
			validate(delta.getResource());
		}
		return true;
	}

	public boolean visit(final IResource resource) throws CoreException {
		if (Constants.CUSTOM_FILE_EXT.equals(resource.getFileExtension())) {
			validate(resource);
		}
		return true;
	}

	protected static void validate(final IResource resource) throws CoreException {
		if (resource.exists()) {
			final IBatchValidator validator = (IBatchValidator) ModelValidationService.getInstance()
					.newValidator(EvaluationMode.BATCH);
			validator.setOption(IBatchValidator.OPTION_TRACK_RESOURCES, Boolean.TRUE);
			final IStatus multiStatus = validator.validate(getAllContents(resource));
			MarkerUtil.updateMarkers(multiStatus);
		}
	}

	/** @return all the model elements contained in the given platform resource. */
	public static List<EObject> getAllContents(final IResource resource) {
		final List<EObject> result = new ArrayList<EObject>();
		final ResourceSetImpl resourceSet = new ResourceSetImpl();
		final Resource modelResource = resourceSet.getResource(URI.createPlatformResourceURI(resource.getFullPath().toString(), true), true);
		final TreeIterator<EObject> allContents = EcoreUtil.getAllContents(modelResource, true);
		while (allContents.hasNext()) {
			result.add(allContents.next());
		}
		return result;
	}
}
