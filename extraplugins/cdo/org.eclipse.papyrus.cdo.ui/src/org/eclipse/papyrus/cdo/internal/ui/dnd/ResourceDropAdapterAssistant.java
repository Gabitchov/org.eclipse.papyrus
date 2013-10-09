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
package org.eclipse.papyrus.cdo.internal.ui.dnd;

import static com.google.common.collect.Iterables.transform;

import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.cdo.core.util.CDOFunctions;
import org.eclipse.papyrus.cdo.core.util.CDOPredicates;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.handlers.ExportModelHandler;
import org.eclipse.papyrus.cdo.internal.ui.views.DIModel;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.eclipse.ui.navigator.CommonDropAdapterAssistant;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


/**
 * Drop-adapter assistant for dropping CDO resources into the Project Explorer to export them.
 */
public class ResourceDropAdapterAssistant extends CommonDropAdapterAssistant {

	private static final IStatus INVALID_DROP = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Invalid drop."); //$NON-NLS-1$

	private static final IStatus VALID_DROP = Status.OK_STATUS;

	public ResourceDropAdapterAssistant() {
		super();
	}

	@Override
	public IStatus validateDrop(Object target, int operation, TransferData transferType) {
		IStatus result = INVALID_DROP;

		// we can drop a local-selection transfer consisting of DI models onto a workspace container (project or folder)
		if(LocalSelectionTransfer.getTransfer().isSupportedType(transferType) && CDOPredicates.adaptsTo(IContainer.class).apply(target)) {
			IStructuredSelection sel = CDOUtils.tryCast(LocalSelectionTransfer.getTransfer().getSelection(), IStructuredSelection.class);
			if((sel != null) && !sel.isEmpty() && Iterables.all((List<?>)sel.toList(), CDOPredicates.adaptsTo(DIModel.class))) {
				result = VALID_DROP;
			}
		}

		return result;
	}

	@Override
	public IStatus handleDrop(CommonDropAdapter aDropAdapter, DropTargetEvent aDropTargetEvent, Object aTarget) {
		IStatus result = INVALID_DROP;

		IStructuredSelection sel = CDOUtils.tryCast(LocalSelectionTransfer.getTransfer().getSelection(), IStructuredSelection.class);
		if((sel != null) && !sel.isEmpty()) {
			IContainer container = CDOUtils.adapt(aTarget, IContainer.class);
			if(container != null) {
				Function<Object, URI> uriFunction = Functions.compose(new Function<DIModel, URI>() {

					@Override
					public URI apply(DIModel input) {
						return input.getResource().getURI();
					}
				}, CDOFunctions.adapt(DIModel.class));

				List<URI> uris = Lists.newArrayList(transform((List<?>)sel.toList(), uriFunction));
				ExportModelHandler.exportModels(container, uris);
				result = VALID_DROP;
			}
		}

		return result;
	}

	//
	// Nested types
	//

	/**
	 * Navigator content extensions require a content provider even if they have no content to provide, only a drop assistant.
	 * So, this makes the <i>Common Navigator</i> happy.
	 */
	public static final class DummyContent implements ICommonContentProvider {

		private static final Object[] NOTHING = {};

		@Override
		public Object[] getElements(Object inputElement) {
			return NOTHING;
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			return NOTHING;
		}

		@Override
		public Object getParent(Object element) {
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			return false;
		}

		@Override
		public void dispose() {
			// pass
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// pass
		}

		@Override
		public void restoreState(IMemento aMemento) {
			// pass
		}

		@Override
		public void saveState(IMemento aMemento) {
			// pass
		}

		@Override
		public void init(ICommonContentExtensionSite aConfig) {
			// pass
		}

	}

	/**
	 * Navigator content extensions require a label provider even if they have no content to provide, only a drop assistant.
	 * So, this makes the <i>Common Navigator</i> happy.
	 */
	public static final class DummyLabels extends LabelProvider implements ICommonLabelProvider {

		@Override
		public void restoreState(IMemento aMemento) {
			// pass
		}

		@Override
		public void saveState(IMemento aMemento) {
			// pass
		}

		@Override
		public String getDescription(Object anElement) {
			return null;
		}

		@Override
		public void init(ICommonContentExtensionSite aConfig) {
			// pass
		}

	}
}
