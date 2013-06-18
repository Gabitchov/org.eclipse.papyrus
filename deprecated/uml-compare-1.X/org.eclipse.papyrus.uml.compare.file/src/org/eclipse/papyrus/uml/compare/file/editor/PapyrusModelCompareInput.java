package org.eclipse.papyrus.uml.compare.file.editor;

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSetSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.DiffResourceSet;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.metamodel.MatchResourceSet;
import org.eclipse.emf.compare.ui.ICompareInputDetailsProvider;
import org.eclipse.emf.compare.ui.ModelCompareInput;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.compare.diff.service.TransactionalMergeService;

/**
 * 
 * This input allows to use the Papyrus TransactionalMergeService
 * 
 */
public class PapyrusModelCompareInput extends ModelCompareInput {

	private final TransactionalEditingDomain domain;

	public PapyrusModelCompareInput(MatchResourceSet matchResourceSet, DiffResourceSet diffResourceSet, TransactionalEditingDomain domain) {
		super(matchResourceSet, diffResourceSet);
		this.domain = domain;
	}

	public PapyrusModelCompareInput(ComparisonResourceSetSnapshot snapshot, TransactionalEditingDomain domain) {
		super(snapshot);
		this.domain = domain;
	}

	public PapyrusModelCompareInput(ComparisonResourceSnapshot snapshot, TransactionalEditingDomain domain) {
		super(snapshot);
		this.domain = domain;
	}

	public PapyrusModelCompareInput(MatchModel matchModel, DiffModel diffModel, ICompareInputDetailsProvider provider, TransactionalEditingDomain domain) {
		super(matchModel, diffModel, provider);
		this.domain = domain;
	}

	public PapyrusModelCompareInput(MatchResourceSet matchResourceset, DiffResourceSet diffResourceSet, ICompareInputDetailsProvider provider, TransactionalEditingDomain domain) {
		super(matchResourceset, diffResourceSet, provider);
		this.domain = domain;
	}

	public PapyrusModelCompareInput(MatchModel match, DiffModel diff, TransactionalEditingDomain domain) {
		super(match, diff);
		this.domain = domain;
	}

	/**
	 * Applies the changes implied by a given {@link DiffElement} in the
	 * direction specified by <code>leftToRight</code>.
	 * 
	 * @param element
	 *        {@link DiffElement} containing the copy information.
	 * @param leftToRight
	 *        <code>True</code> if the changes must be applied from the left
	 *        to the right model, <code>False</code> otherwise.
	 */
	protected void doCopy(DiffElement element, boolean leftToRight) {
		Command cmd = TransactionalMergeService.getMergeCommand(domain, element, leftToRight);
		domain.getCommandStack().execute(cmd);
	}

	/**
	 * Applies the changes implied by a list of {@link DiffElement} in the
	 * direction specified by <code>leftToRight</code>.
	 * 
	 * @param elements
	 *        {@link DiffElement}s containing the copy information.
	 * @param leftToRight
	 *        <code>True</code> if the changes must be applied from the left
	 *        to the right model, <code>False</code> otherwise.
	 */
	protected void doCopy(List<DiffElement> elements, boolean leftToRight) {
		Command cmd = TransactionalMergeService.getMergeCommand(domain, elements, leftToRight);
		domain.getCommandStack().execute(cmd);
	}

}
