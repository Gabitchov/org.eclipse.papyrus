/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.compare.element;

import static org.eclipse.papyrus.compare.Activator.log;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareUI;
import org.eclipse.compare.CompareViewerPane;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.compare.EMFCompareException;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.engine.GenericMatchScopeProvider;
import org.eclipse.emf.compare.match.engine.IMatchEngine;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.util.AdapterUtils;
import org.eclipse.emf.compare.util.EMFCompareMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.papyrus.compare.ui.viewer.content.UMLModelContentMergeViewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.team.internal.ui.actions.TeamAction;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class CompareTwoElementsAction extends TeamAction {

	protected void execute(IAction action) throws InvocationTargetException, InterruptedException {

		Object[] selectedElements = getSelection().toArray();
		if(selectedElements.length != 2) {
			log.info("Cannot compare elements: 2 elements should be selected, but only " + selectedElements.length + " is selected");
			return;
		}

		EObject left = getElementFor(selectedElements[0]);
		EObject right = getElementFor(selectedElements[1]);
		if(left == null) {
			log.info("Cannot compare elements: left element is null");
			return;
		}

		if(right == null) {
			log.info("Cannot compare elements: right element is null");
			return;
		}

		ComparisonResourceSnapshot snapshot = doContentCompare(left, right);
		openInCompare(snapshot);
	}

	public boolean isEnabled() {
		Object[] selectedElements = getSelection().toArray();
		if(selectedElements.length != 2) {
			return false;
		}
		EObject left = getElementFor(selectedElements[0]);
		EObject right = getElementFor(selectedElements[1]);
		return left != null && right != null;
	}

	private void openInCompare(ComparisonSnapshot snapshot) {
		CompareUI.openCompareEditor(new ModelCompareEditorInput(snapshot) {

			@Override
			protected ModelContentMergeViewer createMergeViewer(CompareViewerPane pane, CompareConfiguration config) {
				return new UMLModelContentMergeViewer(pane, config);
			}

			@Override
			public Control createOutlineContents(Composite parent, int direction) {
				Control result = super.createOutlineContents(parent, direction);
				structureMergeViewer.setLabelProvider(new PapyrusStyledadapterProvider());
				return result;
			}

		});
	}

	protected ComparisonResourceSnapshot doContentCompare(final EObject left, final EObject right) {
		final ComparisonResourceSnapshot snapshot = DiffFactory.eINSTANCE.createComparisonResourceSnapshot();

		try {
			PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor) throws InterruptedException {
					final MatchModel match = contentMatch(left, right, monitor);
					final DiffModel diff = contentDiff(left, right, match);

					snapshot.setDiff(diff);
					snapshot.setMatch(match);
				}

			});
		} catch (final InterruptedException e) {
			log.error(e);
		} catch (final EMFCompareException e) {
			log.error(e);
		} catch (final InvocationTargetException e) {
			e.printStackTrace();
		}
		return snapshot;
	}

	protected DiffModel contentDiff(final EObject left, final EObject right, final MatchModel match) {
		ElementContentDiffEngine engine = new ElementContentDiffEngine(left, right);
		final DiffModel diff = engine.doDiff(match);
		final Collection<AbstractDiffExtension> extensions = DiffService.getCorrespondingDiffExtensions(match);
		for(final AbstractDiffExtension ext : extensions) {
			if(ext != null) {
				ext.visit(diff);
			}
		}

		engine.reset();
		return diff;
	}

	protected MatchModel contentMatch(final EObject left, final EObject right, IProgressMonitor monitor) throws InterruptedException {
		final Map<String, Object> options = new EMFCompareMap<String, Object>();
		options.put(MatchOptions.OPTION_PROGRESS_MONITOR, monitor);
		options.put(MatchOptions.OPTION_MATCH_SCOPE_PROVIDER, new GenericMatchScopeProvider(left.eResource(), right.eResource()));
		options.put(MatchOptions.OPTION_IGNORE_ID, Boolean.TRUE);
		options.put(MatchOptions.OPTION_IGNORE_XMI_ID, Boolean.TRUE);

		final IMatchEngine matchEngine = new ElementContentMatchEngine(left, right);
		final MatchModel match = matchEngine.contentMatch(left, right, options);
		return match;
	}

	protected EObject getElementFor(Object object) {
		if(object instanceof IAdaptable) {
			return (EObject)((IAdaptable)object).getAdapter(EObject.class);
		}

		if(object instanceof EObject) {
			return (EObject)object;
		}
		return null;
	}

	private class UMLModelStructureLabelProvider extends LabelProvider {

		/**
		 * We use this generic label provider, but we want to customize some aspects that's why we choose to
		 * aggregate it.
		 */
		/* package */AdapterFactoryLabelProvider adapterProvider;

		/**
		 * Default constructor.
		 */
		public UMLModelStructureLabelProvider() {
			adapterProvider = new AdapterFactoryLabelProvider(AdapterUtils.getAdapterFactory());

		}

		/**
		 * Returns the platform icon for a given {@link IFile}. If not an {@link IFile}, delegates to the {@link AdapterFactoryLabelProvider} to get
		 * the {@link Image}.
		 * 
		 * @param object
		 *        Object to get the {@link Image} for.
		 * @return The platform icon for the given object.
		 * @see AdapterFactoryLabelProvider#getImage(Object)
		 */
		@Override
		public Image getImage(Object object) {
			Image image = null;
			if(object instanceof AbstractDiffExtension) {
				image = (Image)((AbstractDiffExtension)object).getImage();
			}
			if(object instanceof IFile) {
				image = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
			} else {
				if(image == null) {
					image = adapterProvider.getImage(object);
				}
			}
			return image;
		}

		/**
		 * Returns the name of the given {@link IFile}, delegates to {@link AdapterFactoryLabelProvider#getText(Object)} if not an {@link IFile}.
		 * 
		 * @param object
		 *        Object we seek the name for.
		 * @return The name of the given object.
		 * @see AdapterFactoryLabelProvider#getText(Object)
		 */
		@Override
		public String getText(Object object) {
			String text = null;
			if(object instanceof AbstractDiffExtension) {
				text = ((AbstractDiffExtension)object).getText();
			} else {
				if(object instanceof IFile) {
					text = ((IFile)object).getName();
				} else if(object instanceof Resource) {
					text = ((Resource)object).getURI().lastSegment();
				} else {
					text = adapterProvider.getText(object);
				}
			}
			return text;
		}
	}

	public class PapyrusStyledadapterProvider extends StyledCellLabelProvider implements ILabelProvider {

		UMLModelStructureLabelProvider delegate;

		public PapyrusStyledadapterProvider() {
			delegate = new UMLModelStructureLabelProvider();
		}

		public Image getImage(Object element) {
			return delegate.getImage(element);
		}

		public String getText(Object element) {
			return getStyledText(element).getString();
		}

		public void update(ViewerCell cell) {
			StyledString string = getStyledText(cell.getElement());
			cell.setText(string.getString());
			cell.setStyleRanges(string.getStyleRanges());
			cell.setImage(getImage(cell.getElement()));
			super.update(cell);
		}

		private StyledString getStyledText(Object element) {
			StyledString styledString = new StyledString();
			styledString.append(delegate.getText(element));
			styledString.append(' ');
			styledString.append('(', StyledString.QUALIFIER_STYLER);
			styledString.append("bla-bla", StyledString.QUALIFIER_STYLER);
			styledString.append(')', StyledString.QUALIFIER_STYLER);
			return styledString;
		}

	}


}
