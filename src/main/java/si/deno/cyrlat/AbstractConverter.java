package si.deno.cyrlat;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;

/**
 * Implementation of a converter action.
 *
 * @version 1.0
 * @author: Denis Žganec
 */
public abstract class AbstractConverter extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        //Get all the required data from data keys
        final Editor editor = anActionEvent.getRequiredData(CommonDataKeys.EDITOR);
        final Project project = anActionEvent.getRequiredData(CommonDataKeys.PROJECT);

        //Access document, caret, and selection
        final Document document = editor.getDocument();
        final SelectionModel selectionModel = editor.getSelectionModel();

        final String selectedText = selectionModel.getSelectedText();
        final int start = selectionModel.getSelectionStart();
        final int end = selectionModel.getSelectionEnd();

        //Making the replacement
        if (selectedText != null && selectedText.length() > 0) {
            WriteCommandAction.runWriteCommandAction(project, new Runnable() {
                @Override
                public void run() {
                    document.replaceString(start, end, convert(selectedText));
                }
            });
            selectionModel.removeSelection();
        }
    }

    protected abstract String convert(String text);
}
