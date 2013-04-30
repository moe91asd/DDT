package dtool.ast.definitions;

import java.util.Iterator;

import melnorme.utilbox.tree.TreeVisitor;
import dtool.ast.ASTCodePrinter;
import dtool.ast.ASTNeoNode;
import dtool.ast.DeclList;
import dtool.ast.IASTVisitor;
import dtool.ast.expressions.Expression;
import dtool.ast.statements.IStatement;
import dtool.refmodel.IScopeNode;
import dtool.refmodel.pluginadapters.IModuleResolver;
import dtool.util.ArrayView;
import dtool.util.NewUtils;

/**
 * A definition of a aggregate. 
 */
public abstract class DefinitionAggregate extends Definition implements IScopeNode, IStatement {
	
	public final ArrayView<TemplateParameter> tplParams;
	public final Expression tplConstraint;
	public final DeclList decls;
	
	public DefinitionAggregate(ProtoDefSymbol defId, ArrayView<TemplateParameter> tplParams,
		Expression tplConstraint, DeclList decls) {
		super(defId);
		this.tplParams = parentize(tplParams);
		this.tplConstraint = parentize(tplConstraint);
		this.decls = parentize(decls);
	}
	
	protected void acceptNodeChildren(IASTVisitor visitor, boolean children) {
		if (children) {
			TreeVisitor.acceptChildren(visitor, defname);
			TreeVisitor.acceptChildren(visitor, tplParams);
			TreeVisitor.acceptChildren(visitor, tplConstraint);
			TreeVisitor.acceptChildren(visitor, decls);
		}
	}
	
	public void aggregateToStringAsCode(ASTCodePrinter cp, String keyword, boolean printDecls) {
		cp.append(keyword);
		cp.appendNode(defname, " ");
		cp.appendNodeList("(", tplParams, ",", ") ");
		DefinitionTemplate.tplConstraintToStringAsCode(cp, tplConstraint);
		if(printDecls) {
			cp.appendNode("{\n", decls, "}");
		}
	}
	
	@Override
	public IScopeNode getMembersScope(IModuleResolver moduleResolver) {
		return this;
	}
	
	@Override
	public Iterator<? extends ASTNeoNode> getMembersIterator(IModuleResolver moduleResolver) {
		return NewUtils.getChainedIterator(decls.nodes /*NPE BUG here*/, tplParams); 
	}
	
	@Override
	public boolean hasSequentialLookup() {
		return false;
	}
	
	@Override
	public String toStringForHoverSignature() {
		ASTCodePrinter cp = new ASTCodePrinter();
		cp.appendStrings(getModuleScope().toStringAsElement(), ".", getName());
		cp.append(ASTCodePrinter.toStringParamListAsElements(tplParams));
		return cp.toString();
	}
	
	@Override
	public String toStringForCodeCompletion() {
		return getName() + " - " + getModuleScope().toStringAsElement();
	}
	
}