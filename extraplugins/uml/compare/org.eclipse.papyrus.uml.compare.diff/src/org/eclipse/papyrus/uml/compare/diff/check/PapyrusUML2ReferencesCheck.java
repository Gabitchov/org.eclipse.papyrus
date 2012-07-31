package org.eclipse.papyrus.uml.compare.diff.check;

import java.io.IOException;
import java.util.Properties;

import org.eclipse.emf.compare.diff.engine.IMatchManager;
import org.eclipse.emf.compare.uml2.diff.UML2DiffEngine;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.infra.emf.compare.diff.check.FeaturesCheck;
import org.eclipse.papyrus.infra.emf.compare.diff.check.PapyrusReferencesCheck;

//adapted code from EMF-Compare UML2ReferencesCheck
public class PapyrusUML2ReferencesCheck extends PapyrusReferencesCheck {



	/**
	 * Parameters.
	 */
	private static final String SUBSETS_OF_CONTAINMENT_PROPERTIES = "/org/eclipse/emf/compare/uml2/diff/internal/subsets.of.containment.properties"; //$NON-NLS-1$

	/**
	 * Properties for parameters.
	 */
	private static final Properties SUBSETS_OF_CONTAINMENT = new Properties();

	static {
		try {
			SUBSETS_OF_CONTAINMENT.load(UML2DiffEngine.class.getResourceAsStream(SUBSETS_OF_CONTAINMENT_PROPERTIES));
		} catch (IOException e) {
			// ignore
		}
	}

	/**
	 * Constructor.
	 * 
	 * @param matchManager
	 *        {@link IMatchManager}
	 */
	public PapyrusUML2ReferencesCheck(final IMatchManager matchManager, final FeaturesCheck checker) {
		super(matchManager, checker);
	}

	@Override
	protected boolean shouldBeIgnored(EReference reference) {
		final String fqn = fqn(reference);
		boolean answer = super.shouldBeIgnored(reference) || SUBSETS_OF_CONTAINMENT.getProperty(fqn) != null;
		return super.shouldBeIgnored(reference) || SUBSETS_OF_CONTAINMENT.getProperty(fqn) != null;
	}

	/**
	 * Transforms the {@link EReference} to a string.
	 * 
	 * @param reference
	 *        The {@link EReference}
	 * @return The string.
	 */
	private String fqn(EReference reference) {
		final StringBuilder fqn = new StringBuilder(reference.getEContainingClass().getName());
		fqn.append('.').append(reference.getName());
		return fqn.toString();
	}
}
