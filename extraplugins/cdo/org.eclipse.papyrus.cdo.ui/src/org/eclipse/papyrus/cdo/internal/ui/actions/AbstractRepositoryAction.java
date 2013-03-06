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
package org.eclipse.papyrus.cdo.internal.ui.actions;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import com.google.common.collect.Iterators;

/**
 * This is the AbstractRepositoryAction type. Enjoy.
 */
public abstract class AbstractRepositoryAction
		extends BaseSelectionListenerAction {

	private IPapyrusRepository repository;

	private IWorkbenchPart part;

	public AbstractRepositoryAction(String text, ImageDescriptor enabledIcon,
			ImageDescriptor disabledIcon, IWorkbenchPart part) {
		super(text);

		this.part = part;

		setImageDescriptor(enabledIcon);
		setDisabledImageDescriptor(disabledIcon);
	}

	public AbstractRepositoryAction(String text, String sharedEnabledIcon,
			String sharedDisabledIcon, IWorkbenchPart part) {
		this(text, getSharedImage(part, sharedEnabledIcon), getSharedImage(
			part, sharedDisabledIcon), part);
	}

	public AbstractRepositoryAction(String text, IWorkbenchPart part) {
		this(text, (ImageDescriptor) null, null, part);
	}

	static ImageDescriptor getSharedImage(IWorkbenchPart part, String imageKey) {
		return ImageDescriptor.createFromImage(part.getSite()
			.getWorkbenchWindow().getWorkbench().getSharedImages()
			.getImage(imageKey));
	}

	@Override
	protected boolean updateSelection(IStructuredSelection selection) {
		boolean result = super.updateSelection(selection);

		repository = Iterators.getNext(
			Iterators.filter(selection.iterator(), IPapyrusRepository.class),
			null);
		result = result && (repository != null) && isEnabledFor(repository);

		return result;
	}

	protected IWorkbenchPart getPart() {
		return part;
	}

	protected abstract boolean isEnabledFor(IPapyrusRepository repository);

	protected abstract void run(IPapyrusRepository repository);

	@Override
	public void run() {
		if (repository != null) {
			run(repository);
		}
	}
}
