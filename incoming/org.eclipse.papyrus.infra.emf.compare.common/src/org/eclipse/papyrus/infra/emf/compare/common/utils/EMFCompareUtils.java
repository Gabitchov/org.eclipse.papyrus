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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.compare.EMFCompareException;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.engine.GenericMatchScopeProvider;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.compare.util.EMFCompareMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.emf.compare.common.Activator;
import org.eclipse.papyrus.infra.emf.compare.common.messages.Messages;
import org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance;
import org.eclipse.papyrus.infra.emf.compare.ui.provider.EMFCompareLabelProvider;
import org.eclipse.papyrus.infra.emf.compare.ui.utils.LabelProviderUtil;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;


public class EMFCompareUtils {

	private EMFCompareUtils() {
		//nothing to do
	}

	public static ComparisonResourceSnapshot doContentCompare(final EObject left, final EObject right) {
		final ComparisonResourceSnapshot snapshot = DiffFactory.eINSTANCE.createComparisonResourceSnapshot();

		try {
			PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor) throws InterruptedException {
					final Map<String, Object> options = new EMFCompareMap<String, Object>();
					options.put(MatchOptions.OPTION_PROGRESS_MONITOR, monitor);
					options.put(MatchOptions.OPTION_MATCH_SCOPE_PROVIDER, new GenericMatchScopeProvider(left.eResource(), right.eResource()));
					options.put(MatchOptions.OPTION_IGNORE_ID, Boolean.TRUE);
					options.put(MatchOptions.OPTION_IGNORE_XMI_ID, Boolean.TRUE);

					final MatchModel match = MatchService.doContentMatch(left, right, options);
					DiffModel diff = DiffService.doDiff(match);
					//						final MatchModel match = contentMatch(left, right, monitor);
					//						final DiffModel diff = contentDiff(left, right, match);

					snapshot.setDiff(diff);
					snapshot.setMatch(match);

				}

			});
		} catch (final InterruptedException e) {
			Activator.log.error(e);
		} catch (final EMFCompareException e) {
			Activator.log.error(e);
		} catch (final InvocationTargetException e) {
			Activator.log.error(e);
		}

		return snapshot;
	}

	/**
	 * 
	 * @param editor
	 *        the editor
	 * @param rawModel
	 *        the raw model
	 * @return
	 *         the name for the editor
	 */
	public static String getCompareEditorTitle(final IEditorPart editor, final PapyrusEMFCompareInstance rawModel) {
		EMFCompareLabelProvider labelProvider = (EMFCompareLabelProvider)LabelProviderUtil.INSTANCE.getLabelProviderFor(editor);
		String leftLabel = labelProvider.getText(rawModel.getLeft());
		String rightLabel = labelProvider.getText(rawModel.getRight());
		String title = NLS.bind(Messages.EMFCompareUtils_CompareTitle, leftLabel, rightLabel);
		return title;
	}

}
