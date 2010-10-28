package org.eclipse.papyrus.marte.vsl.scoping.visitors;

import java.util.List;

public interface Visitor<ReturnType, VisitedKind> {
	public List<ReturnType> visit(VisitedKind visited) ;
}
