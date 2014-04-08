/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.emf.readonly;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.core.resource.AbstractReadOnlyHandler;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler2;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.papyrus.infra.emf.readonly.internal.messages.Messages;
import org.eclipse.swt.widgets.Display;

import com.google.common.base.Objects;
import com.google.common.base.Optional;


/**
 * A {@linkplain IReadOnlyHandler2 read-only handler} for objects in referenced models, which by default shouldn't be editable in the context of the
 * model referencing them.  This is a discretion-based handler.
 */
public class ReferencedModelReadOnlyHandler extends AbstractReadOnlyHandler {

	private final ControlledResourceTracker controlledResourceTracker;

	private final Set<URI> readableReferencedModels = new HashSet<URI>();

	private boolean interactive = true;
	
	public ReferencedModelReadOnlyHandler(EditingDomain editingDomain) {
		super(editingDomain);

		controlledResourceTracker = ControlledResourceTracker.getInstance(editingDomain);
	}

	/**
	 * Queries whether I interact with the user to confirm making resources writable. I am interactive by default.
	 * 
	 * @return whether I am interactive
	 */
	public boolean isInteractive() {
		return interactive;
	}
	
	/**
	 * Sets whether I interact with the user to confirm making resources writable.
	 * 
	 * @param interactive
	 *        whether I am interactive
	 */
	public void setInteractive(boolean interactive) {
		this.interactive = interactive;
	}
	
	public Optional<Boolean> anyReadOnly(Set<ReadOnlyAxis> axes, URI[] uris) {
		Optional<Boolean> result = Optional.absent();

		if(axes.contains(ReadOnlyAxis.DISCRETION)) {
			final URIConverter converter = getEditingDomain().getResourceSet().getURIConverter();
			
			for(int i = 0; i < uris.length; i++) {
				// Clients may pass object URIs (including fragments), so trim to a resource URI because we operate on the resource level
				URI next = uris[i].trimFragment();
				
				// If the resource doesn't exist, then it can't be opened in some other editor, so
				// we needn't be concerned about editing it in the context of a referencing model
				if(!readableReferencedModels.contains(next.trimFileExtension()) && isNotModelSetMainModel(next) && converter.exists(next, null)) {
					result = Optional.of(true);
					break;
				}
			}
		}
		
		return result;
	}

	@Override
	public Optional<Boolean> canMakeWritable(Set<ReadOnlyAxis> axes, URI[] uris) {
		Optional<Boolean> result = Optional.absent();

		if(axes.contains(ReadOnlyAxis.DISCRETION)) {
			for(int i = 0; i < uris.length; i++) {
				// Clients may pass object URIs (including fragments), so trim to a resource URI because we operate on the resource level
				URI next = uris[i].trimFragment();
				
				if(isNotModelSetMainModel(next)) {
					result = Optional.of(true);
				} else {
					// If it's not something I handle, then bomb
					result = Optional.of(false);
					break;
				}
			}
		}
		
		return result;
	}

	public Optional<Boolean> makeWritable(Set<ReadOnlyAxis> axes, URI[] uris) {
		Optional<Boolean> result = Optional.absent();

		if(axes.contains(ReadOnlyAxis.DISCRETION)) {
			final List<URI> toMakeWritable = new ArrayList<URI>(uris.length);
	
			for(int i = 0; i < uris.length; i++) {
				// Clients may pass object URIs (including fragments), so trim to a resource URI because we operate on the resource level
				URI next = uris[i].trimFragment();
	
				if(isNotModelSetMainModel(next)) {
					toMakeWritable.add(next);
				}
			}
	
			if(!toMakeWritable.isEmpty()) {
				final boolean[] enableWrite = { !isInteractive() };
				
				if(isInteractive()) {
					Display currentDisplay=Display.getCurrent();
					if(currentDisplay==null){
						currentDisplay=Display.getDefault();
					}
					currentDisplay.syncExec(new Runnable() {
	
						public void run() {
							StringBuilder message = new StringBuilder(Messages.ReferencedModelReadOnlyHandler_promptMsg);
							for(URI uri : toMakeWritable) {
								String path;
								if(uri.isPlatformResource()) {
									path = uri.toPlatformString(true);
								} else if(uri.isFile()) {
									path = uri.toFileString();
								} else {
									path = uri.toString();
								}
	
								message.append(path);
								message.append("\n"); //$NON-NLS-1$
							}
							enableWrite[0] = MessageDialog.openConfirm(Display.getCurrent().getActiveShell(), Messages.ReferencedModelReadOnlyHandler_promptTitle, message.toString());
						}
					});
				}
	
				if(enableWrite[0]) {
					for(URI next : toMakeWritable) {
						readableReferencedModels.add(next.trimFileExtension());
						fireReadOnlyStateChanged(ReadOnlyAxis.DISCRETION, next, true);
					}
				}
	
				result = Optional.of(enableWrite[0]);
			}
		}
		
		return result;
	}

	protected boolean isNotModelSetMainModel(URI uri) {
		// Default to false result because, if the context is not a ModelSet, the question doesn't make sense and we should not restrict editing
		boolean result = false;

		ResourceSet rset = getEditingDomain().getResourceSet();
		if(rset instanceof ModelSet) {
			ModelSet modelSet = (ModelSet)rset;
			uri = resolveRootResourceURI(modelSet, uri);

			result = modelSet.isUserModelResource(uri) && !Objects.equal(modelSet.getURIWithoutExtension(), uri.trimFileExtension());
		}

		return result;
	}

	/**
	 * Trace a potential controlled unit's root resource.
	 * 
	 * @param modelSet
	 *        the contextual model-set
	 * @param uri
	 *        a resource URI
	 * 
	 * @return the corresponding root resource URI, which is just the original {@code uri} if either it isn't a controlled unit or we cannot tell
	 */
	protected URI resolveRootResourceURI(ModelSet modelSet, URI uri) {
		return controlledResourceTracker.getRootResourceURI(uri);
	}

}
