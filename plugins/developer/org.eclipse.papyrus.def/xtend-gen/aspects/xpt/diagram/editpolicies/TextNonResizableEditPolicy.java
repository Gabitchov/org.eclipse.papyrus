package aspects.xpt.diagram.editpolicies;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common;

/**
 * FIXME: [MG] - reverse the calls? call common code from here and TextelectionEP and not vice versa
 */
@Singleton
@SuppressWarnings("all")
public class TextNonResizableEditPolicy extends xpt.diagram.editpolicies.TextNonResizableEditPolicy {
  @Inject
  @Extension
  private Common _common;
  
  public CharSequence TextNonResizableEditPolicy_createSelectionHandles(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected java.util.List<?> createSelectionHandles() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gef.handles.MoveHandle moveHandle =");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new org.eclipse.gef.handles.MoveHandle((org.eclipse.gef.GraphicalEditPart) getHost());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("moveHandle.setBorder(null);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("moveHandle.setDragTracker(new org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx(getHost()));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return java.util.Collections.singletonList(moveHandle);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
