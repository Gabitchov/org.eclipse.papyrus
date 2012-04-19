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
package org.eclipse.papyrus.uml.compare.editor;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareViewerPane;
import org.eclipse.compare.contentmergeviewer.IMergeViewerContentProvider;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.EMFCompareException;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.engine.GenericMatchScopeProvider;
import org.eclipse.emf.compare.match.engine.IMatchEngine;
import org.eclipse.emf.compare.match.engine.IMatchScopeProvider;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeContentProvider;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.emf.compare.util.EMFCompareMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.compare.common.editor.EMFCompareEditor;
import org.eclipse.papyrus.infra.emf.compare.common.utils.PapyrusModelCompareEditorInput;
import org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance;
import org.eclipse.papyrus.infra.emf.compare.ui.content.transactional.viewer.PapyrusTransactionalModelContentMergeViewer;
import org.eclipse.papyrus.infra.emf.compare.ui.utils.LabelProviderUtil;
import org.eclipse.papyrus.uml.compare.Activator;
import org.eclipse.papyrus.uml.compare.content.viewer.UMLModelContentMergeTabFolder;
import org.eclipse.papyrus.uml.compare.utils.RootObject;
import org.eclipse.papyrus.uml.compare.utils.UMLDiffService;
import org.eclipse.papyrus.uml.compare.utils.UMLMatchEngine;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.NamedElement;



public class UMLCompareEditor extends EMFCompareEditor {

	/** the type of the editor */
	public static final String EDITOR_TYPE = "PapyrusUMLCompare"; //$NON-NLS-1$

	private static final String LEFT_OBJECT_KEY = "leftObject"; //TODO useful ?

	private static final String RIGHT_OBJECT_KEY = "rightObject"; //TODO useful ?

	/**
	 * @param servicesRegistry
	 * @param rawModel
	 * 
	 */
	public UMLCompareEditor(final ServicesRegistry servicesRegistry, final PapyrusEMFCompareInstance rawModel) {
		super(servicesRegistry, rawModel);
	}

	//TODO : should be set in the super class too!
	protected Map<String,Object> getComparisonOptions(final IProgressMonitor monitor){
		final Map<String, Object> options = new EMFCompareMap<String, Object>();
		options.put(MatchOptions.OPTION_PROGRESS_MONITOR, monitor); //TODO remove it?
		options.put(MatchOptions.OPTION_MATCH_SCOPE_PROVIDER, getMatchScopeProvider(rawModel.getLeft(), rawModel.getRight()));
		options.put(MatchOptions.OPTION_IGNORE_ID, Boolean.TRUE);
		options.put(MatchOptions.OPTION_IGNORE_XMI_ID, Boolean.TRUE);
		return options;
	}
	
	//TODO : should be set in the super class too!
	protected IMatchScopeProvider getMatchScopeProvider(final EObject left, final EObject right){
		return 	new GenericMatchScopeProvider(left, right);
	}
	//TODO : should be set in the super class too!
	protected IMatchEngine getMatchEngine(){
		return new UMLMatchEngine();
	}
	
	@Override
	protected ComparisonSnapshot doContentCompare(final EObject left, final EObject right) {
		final ComparisonResourceSnapshot snapshot = DiffFactory.eINSTANCE.createComparisonResourceSnapshot();

		try {
			PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor) throws InterruptedException {
					final Map<String, Object> options = getComparisonOptions(monitor);
					final IMatchEngine engine = getMatchEngine();
					MatchModel match = engine.contentMatch(left, right, options);
					final DiffModel diff = doDiff(left, right, match);

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
		cleanSnapshot(snapshot);
		return snapshot;
	}
	
	//TODO should be in the super class
	//TODO remove unecessary paramter
	/**
	 * A part of this method is duplicated from DiffService#doDiff
	 * @param left
	 * @param right
	 * @param match
	 * @return
	 */
	protected DiffModel doDiff(EObject left, EObject right,MatchModel match) {
		return UMLDiffService.doDiff(match, false);
	}

	/**
	 * This method allows to remove unnecessary differences : 
	 * 	we don't show element move from the root element (see bug 377143)
	 * 
	 * @param snapshot
	 *        the snapshot
	 */
	private void cleanSnapshot(final ComparisonSnapshot snapshot) {
		final EList<EObject> contents = snapshot.eContents();
		final DiffModel root = (DiffModel)contents.get(0);
		final EList<DiffElement> differences = root.getDifferences();
		final List<DiffElement> toRemove = new ArrayList<DiffElement>();
		for(DiffElement current : differences){
			if(current instanceof MoveModelElement){
				EObject leftTarget = ((MoveModelElement)current).getLeftTarget();
				EObject rightTarget = ((MoveModelElement)current).getRightTarget();
				if(leftTarget==null && rightTarget==null){
					toRemove.add(current);
				}
			}
		}
		for(DiffElement current : toRemove){
			EcoreUtil.remove(current);
		}
	}

	@Override
	protected ModelCompareEditorInput createModelCompareEditorInput(ComparisonSnapshot snapshot) {

		PapyrusModelCompareEditorInput input = new PapyrusModelCompareEditorInput(snapshot, this) {

			@Override
			protected ModelContentMergeViewer createMergeViewer(CompareViewerPane pane, CompareConfiguration config) {
				return new PapyrusTransactionalModelContentMergeViewer(pane, config, editor) {

					protected IMergeViewerContentProvider createMergeViewerContentProvider() {
						return new ModelContentMergeContentProvider(configuration) {

							@Override
							public Object getLeftContent(Object element) {
								if(element != null) {
									return new RootObject(configuration.getProperty(UMLCompareEditor.LEFT_OBJECT_KEY));
								}
								return null;
							}

							@Override
							public Object getRightContent(Object element) {
								if(element != null) {
									return new RootObject(configuration.getProperty(UMLCompareEditor.RIGHT_OBJECT_KEY));
								}
								return null;
							}
						};

					}

					/**
					 * 
					 * {@inheritDoc}
					 * 
					 * @param composite
					 * @param side
					 * @return
					 */
					@Override
					protected ModelContentMergeTabFolder createModelContentMergeTabFolder(final Composite composite, final int side) {
						return new UMLModelContentMergeTabFolder(this, composite, side);
					}
				};
			}

		};

		//TODO : manage the Element which are not NamedElement
		//TODO : warning if we use a label provider, warnign to the stereotype use 
		CompareConfiguration cc = input.getCompareConfiguration();
		LabelProvider prov = (LabelProvider)LabelProviderUtil.INSTANCE.getLabelProviderFor(this);
		String leftQName = null;
		String rightQName = null;
		EObject left = this.rawModel.getLeft();
		if(left instanceof NamedElement) {
			leftQName = ((NamedElement)left).getQualifiedName();
		}
		EObject right = this.rawModel.getRight();
		if(right instanceof NamedElement) {
			rightQName = ((NamedElement)right).getQualifiedName();
		}

		cc.setLeftLabel(leftQName);
		cc.setRightLabel(rightQName);
		cc.setLeftImage(prov.getImage(left));
		cc.setRightImage(prov.getImage(right));
		cc.setProperty(LEFT_OBJECT_KEY, rawModel.getLeft());
		cc.setProperty(RIGHT_OBJECT_KEY, rawModel.getRight());
		return input;
	}

}
