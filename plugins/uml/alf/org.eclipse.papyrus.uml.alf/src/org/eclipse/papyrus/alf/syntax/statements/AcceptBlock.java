package org.eclipse.papyrus.alf.syntax.statements;

import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.ElementReference;
import org.eclipse.papyrus.alf.syntax.common.SyntaxElement;

public class AcceptBlock extends SyntaxElement {

	// Synthesized Properties
	public Block block ;
	public String name ;
	public QualifiedNameList signalNames ;
	
	// Derived Properties
	public List<ElementReference> signal ;
	
	// Constraints
	
	/*
	 * The signals of an accept block are the referents of the signal names of the accept block.
	 */
	public void checkAcceptBlockSignalDerivation() {
		
	}
	
	/*
	 * All signal names in an accept block must resolve to signals.
	 */
	public void checkAcceptBlockSignalNames() {
		
	}
	
	
}
