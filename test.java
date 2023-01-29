public class SubThreadTryCatchRule extends AbstractAliRule {
    private static final String THREAD_XPATH = ".//Statement/StatementExpression//PrimaryPrefix/Name[(matches(@Image,'.*?\\.runAsync.*'))]";
    private static final String TRY_XPATH2 = ".//Statement/TryStatement";
    private static final String MESSAGE_KEY = "java.extension.SubThreadTryCatchRule.violation.msg";

    @Override
    public Object visit(ASTBlockStatement node, Object data) {
        if ((node.hasDescendantMatchingXPath(THREAD_XPATH) && !node.hasDescendantMatchingXPath(TRY_XPATH2))) {
            ViolationUtils.addViolationWithPrecisePosition(this, node, data,
                    I18nResources.getMessage(MESSAGE_KEY));
        }
        return super.visit(node, data);
    }


}
