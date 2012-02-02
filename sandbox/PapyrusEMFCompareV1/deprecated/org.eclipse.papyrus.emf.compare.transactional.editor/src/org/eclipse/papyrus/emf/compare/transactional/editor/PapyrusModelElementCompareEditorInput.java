package org.eclipse.papyrus.emf.compare.transactional.editor;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.CompareViewerPane;
import org.eclipse.compare.IViewerCreator;
import org.eclipse.compare.Splitter;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSetSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.ui.ModelCompareInput;
import org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.structure.ModelStructureMergeViewer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.emf.compare.transactional.editor.sphinx.EcoreResourceUtil;
import org.eclipse.papyrus.uml.compare.ui.merge.viewer.PapyrusContentMergeViewerCreator;
import org.eclipse.papyrus.uml.compare.ui.structure.viewer.UMLStructureMergeViewerCreator;
import org.eclipse.sphinx.emf.compare.ui.ModelElementCompareInput;
import org.eclipse.sphinx.emf.compare.ui.editor.ModelCompareEditor;
import org.eclipse.sphinx.emf.compare.ui.internal.Activator;
import org.eclipse.sphinx.emf.compare.ui.internal.messages.Messages;
import org.eclipse.sphinx.emf.compare.ui.viewer.content.ModelElementContentMergeViewer;
import org.eclipse.sphinx.emf.resource.ExtendedResource;
import org.eclipse.sphinx.emf.workspace.saving.ModelSaveManager;
import org.eclipse.sphinx.emf.workspace.ui.saving.BasicModelSaveablesProvider;
import org.eclipse.sphinx.platform.util.PlatformLogUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.ISaveablesLifecycleListener;
import org.eclipse.ui.ISaveablesSource;
import org.eclipse.ui.Saveable;
import org.eclipse.ui.navigator.SaveablesProvider;

/**
 * Duplicate code from ModelElementCompareEditorInput
 */
public class PapyrusModelElementCompareEditorInput extends ModelCompareEditorInput implements ISaveablesSource {

	/**
	 * The two {@linkplain EObject}s that are currently being compared.
	 * <p>
	 * <code>modelRoots[0]</code> is the <b>left</b> model root object;<br>
	 * <code>modelRoots[1]</code> is the <b>right</b> model root object.
	 */
	private EObject[] modelRoots;

	protected SaveablesProvider modelSaveablesProvider;

	/**
	 * This is a temporary editing domain used to load distant files.
	 */
	protected TransactionalEditingDomain editingDomain;

	/**
	 * This constructor takes a {@link ModelInputSnapshot} as input.
	 * 
	 * @param snapshot
	 *        The {@link ComparisonSnapshot} loaded from an emfdiff.
	 */
	public PapyrusModelElementCompareEditorInput(ComparisonSnapshot snapshot) {
		super(snapshot);
	}

	/**
	 * Internal convenient method allowing to easily retrieve the match model for this compare editor input.
	 * 
	 * @return The {@linkplain MatchModel match model} provided by the {@linkplain ModelCompareInput} encapsulated in
	 *         this {@linkplain ModelCompareEditorInput compare editor input}.
	 */
	protected MatchModel getMatchModel() {
		Object matchModel = null;
		if(preparedInput != null) {
			matchModel = preparedInput.getMatch();
		} else if(inputSnapshot != null) {
			if(inputSnapshot instanceof ComparisonResourceSnapshot) {
				matchModel = ((ComparisonResourceSnapshot)inputSnapshot).getMatch();
			} else if(inputSnapshot instanceof ComparisonResourceSetSnapshot) {
				matchModel = ((ComparisonResourceSetSnapshot)inputSnapshot).getMatchResourceSet();
			}
		} else {
			IStatus warning = new Status(IStatus.WARNING, Activator.getPlugin().getSymbolicName(), Messages.warning_inputsNull, new NullPointerException());
			PlatformLogUtil.logAsWarning(Activator.getPlugin(), warning);
		}
		return matchModel instanceof MatchModel ? (MatchModel)matchModel : null;
	}

	/**
	 * Returns the save options to consider while saving the underlying model being edited. Default implementation
	 * returns the default save options provided by the Sphinx EMF platform utility {@linkplain EcoreResourceUtil}.
	 * Clients may override this method in order to specify custom options.
	 * 
	 * @return The save options to consider while saving the underlying model being edited.
	 */
	protected Map<?, ?> getSaveOptions() {
		return EcoreResourceUtil.getDefaultSaveOptions();
	}

	@Override
	public boolean isDirty() {
		boolean isDirty = false;
		for(Object modelRoot : getModelRoots()) {
			if(modelRoot instanceof EObject) {
				// Return true if the model, this editor or both are dirty
				isDirty = isDirty || ModelSaveManager.INSTANCE.isDirty(((EObject)modelRoot).eResource());
			}
		}
		return isDirty;
	}

	protected void init() {
		if(modelSaveablesProvider == null) {
			modelSaveablesProvider = createModelSaveablesProvider();
			if(getWorkbenchPart() instanceof PapyrusCompareEditor) {
				ISaveablesLifecycleListener modelSaveablesLifecycleListener = ((PapyrusCompareEditor)getWorkbenchPart()).createModelSaveablesLifecycleListener();
				modelSaveablesProvider.init(modelSaveablesLifecycleListener);
			} else {
				if(getWorkbenchPart() == null) {
					PlatformLogUtil.logAsWarning(Activator.getPlugin(), new NullPointerException(Messages.warning_workbenchPartNull));
				} else {
					PlatformLogUtil.logAsWarning(Activator.getPlugin(), new RuntimeException(Messages.warning_workbenchPartInstanceofModelCompareEditor));
				}
			}
		}
	}

	/**
	 * @return The root object of the model part that is currently being edited in this editor or <code>null</code> if
	 *         no such is available.
	 */
	public EObject[] getModelRoots() {
		if(modelRoots == null) {
			modelRoots = new EObject[2];
		}

		MatchModel matchModel = getMatchModel();

		if(matchModel != null) {
			if(modelRoots[0] == null || modelRoots[0].eIsProxy() || modelRoots[0].eResource() == null || !modelRoots[0].eResource().isLoaded()) {
				EList<EObject> leftRoots = matchModel.getLeftRoots();
				modelRoots[0] = leftRoots.get(0);
			}
			if(modelRoots[1] == null || modelRoots[1].eIsProxy() || modelRoots[1].eResource() == null || !modelRoots[1].eResource().isLoaded()) {
				EList<EObject> rightRoots = matchModel.getRightRoots();
				modelRoots[1] = rightRoots.get(0);
			}
		} else {
			IStatus warning = new Status(IStatus.WARNING, Activator.getPlugin().getSymbolicName(), Messages.warning_inputMatchModelNull, new NullPointerException());
			PlatformLogUtil.logAsWarning(Activator.getPlugin(), warning);
		}
		return modelRoots;
	}

	@Override
	protected ModelContentMergeViewer createMergeViewer(CompareViewerPane pane, CompareConfiguration compareConfig) {
//		return super.createMergeViewer(pane, compareConfig);
//we provide a Papyrus ContentMergeViewer
		IViewerCreator creator = new PapyrusContentMergeViewerCreator();
		return (ModelContentMergeViewer)creator.createViewer(pane, compareConfig);
//		return new ModelElementContentMergeViewer(pane, compareConfig);
	}

	@Override
	protected ModelCompareInput createModelCompareInput(ComparisonSnapshot snap) {
		if(snap instanceof ComparisonResourceSetSnapshot) {
			return new ModelElementCompareInput(((ComparisonResourceSetSnapshot)snap).getMatchResourceSet(), ((ComparisonResourceSetSnapshot)snap).getDiffResourceSet());
		}
		return new ModelElementCompareInput(((ComparisonResourceSnapshot)snap).getMatch(), ((ComparisonResourceSnapshot)snap).getDiff());
	}

	protected SaveablesProvider createModelSaveablesProvider() {
		return new BasicModelSaveablesProvider();
	}

	/**
	 * @see Bug 892 - Indicate files being compared in compare editor tab title
	 * @see #setTitle(String)
	 */
	@Override
	protected Object prepareInput(IProgressMonitor monitor) {
		init();
		String title;
		Object input = super.prepareInput(monitor);
		String leftLabel = getLeftLabel();
		String rightLabel = getRightLabel();
		String ancestorLabel = getAncestorLabel();
		if(ancestorLabel == null) {
			title = NLS.bind(Messages.twoWay_title, leftLabel, rightLabel);
		} else {
			title = NLS.bind(Messages.threeWay_title, new String[]{ ancestorLabel, leftLabel, rightLabel });
		}
		setTitle(title);
		return input;
	}

	/**
	 * Returns the label of the left compared object to use it in the title and the tool tip of the compare editor.
	 * 
	 * @return As specified above.
	 */
	protected String getRightLabel() {
		String rightLabel;
		EObject rightRoot = getModelRoots()[1];
		Resource rightResource = preparedInput.getRightResource();
		EObject rightModelRoot = EcoreResourceUtil.getModelRoot(rightResource);
		rightLabel = rightResource.getURI().toPlatformString(true);
		if(rightRoot != rightModelRoot) {
			String fragment = rightResource.getURIFragment(rightRoot);
			fragment = fragment.lastIndexOf(ExtendedResource.URI_QUERY_SEPARATOR) == -1 ? "" : fragment.substring(0, fragment.lastIndexOf(ExtendedResource.URI_QUERY_SEPARATOR)); //$NON-NLS-1$
			rightLabel = rightLabel.concat(ExtendedResource.URI_FRAGMENT_SEPARATOR + fragment);
		}
		return rightLabel;
	}

	/**
	 * Returns the label of the right compared object to use it in the title and the tool tip of the compare editor.
	 * 
	 * @return As specified above.
	 */
	protected String getLeftLabel() {
		String leftLabel;
		EObject leftRoot = getModelRoots()[0];
		Resource leftResource = preparedInput.getLeftResource();
		EObject leftModelRoot = EcoreResourceUtil.getModelRoot(leftResource);
		leftLabel = leftResource.getURI().toPlatformString(true);
		if(leftRoot != leftModelRoot) {
			String fragment = leftResource.getURIFragment(leftRoot);
			fragment = fragment.lastIndexOf(ExtendedResource.URI_QUERY_SEPARATOR) == -1 ? "" : fragment.substring(0, fragment.lastIndexOf(ExtendedResource.URI_QUERY_SEPARATOR)); //$NON-NLS-1$
			leftLabel = leftLabel.concat(ExtendedResource.URI_FRAGMENT_SEPARATOR + fragment);
		}
		return leftLabel;
	}

	/**
	 * Returns the label of the ancestor object in case of three way comparison.
	 * 
	 * @return As specified above.
	 */
	// TODO aakar We should handle three way comparison
	protected String getAncestorLabel() {
		Resource ancestorResource = preparedInput.getAncestorResource();
		if(ancestorResource != null) {
			return ancestorResource.getURI().toString();
		}
		return null;
	}

	@Override
	public String getToolTipText() {
		if(preparedInput != null) {
			String leftLabel = getLeftLabel();
			String rightLabel = getRightLabel();
			String ancestorLabel = getAncestorLabel();
			if(ancestorLabel == null) {
				return NLS.bind(Messages.twoWay_tooltip, leftLabel, rightLabel);
			} else {
				return NLS.bind(Messages.threeWay_tooltip, new Object[]{ ancestorLabel, leftLabel, rightLabel });
			}
		}
		// Fall back
		return super.getToolTipText();
	}

	@Override
	public void saveChanges(IProgressMonitor monitor) {
		for(Object modelRoot : getModelRoots()) {
			if(modelRoot instanceof EObject) {
				// Save the all dirty resources of underlying model
				ModelSaveManager.INSTANCE.saveModel(((EObject)modelRoot).eResource(), getSaveOptions(), false, monitor);
			}
		}
	}

	public Saveable[] getActiveSaveables() {
		return getSaveables();
	}

	public Saveable[] getSaveables() {
		Set<Saveable> saveables = new HashSet<Saveable>();
		if(modelSaveablesProvider != null) {
			Saveable leftSaveable = modelSaveablesProvider.getSaveable(getModelRoots()[0].eResource());
			if(leftSaveable != null) {
				saveables.add(leftSaveable);
			}
			Saveable rightSaveable = modelSaveablesProvider.getSaveable(getModelRoots()[1].eResource());
			if(rightSaveable != null) {
				saveables.add(rightSaveable);
			}
		}
		return saveables.toArray(new Saveable[saveables.size()]);

	}

	public TransactionalEditingDomain getEditingDomain() {
		return editingDomain;
	}

	public TransactionalEditingDomain setEditingDomain(TransactionalEditingDomain editingDomain) {
		return this.editingDomain = editingDomain;
	}

	@Override
	protected void finalize() throws Throwable {
		if(modelSaveablesProvider != null) {
			modelSaveablesProvider.dispose();
			modelSaveablesProvider = null;
		}
		if(editingDomain != null) {
			editingDomain.dispose();
		}
		super.finalize();
	}

	//TODO
	@Override
	public void setDirty(boolean dirty) {
		// TODO Auto-generated method stub
		super.setDirty(dirty);
	}
	
	
	//we override this method to provide the Papyrus Structural Viewer
	/**
	 * {@inheritDoc}
	 * 
	 * @see CompareEditorInput#createOutlineContents(Composite, int)
	 */
	@Override
	public Control createOutlineContents(Composite parent, int direction) {
		

		final Splitter splitter = new Splitter(parent, direction);

		final CompareViewerPane pane = new CompareViewerPane(splitter, SWT.NONE);
		IViewerCreator creator = new UMLStructureMergeViewerCreator();
		//structureMergeViewer = new ModelStructureMergeViewer(pane, getCompareConfiguration());
		structureMergeViewer = (ModelStructureMergeViewer)creator.createViewer(pane, getCompareConfiguration());
		pane.setContent(structureMergeViewer.getTree());

		structureMergeViewer.setInput(preparedInput);

		return splitter;
	}
}
