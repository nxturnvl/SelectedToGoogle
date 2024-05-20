import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.ui.Messages;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;

public class SearchSelectedAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        Editor editor = anActionEvent.getRequiredData(CommonDataKeys.EDITOR);
        SelectionModel selectionModel = editor.getSelectionModel();
        String selectedText = selectionModel.getSelectedText();
        String googleSearchBody = "https://www.google.com/search?q=";
        if(!StringUtils.isEmpty(selectedText)){
            selectedText = StringProcessor.Process(selectedText);
            //concatenate processed selected text and query URL starting part
            String searchAddress = googleSearchBody + selectedText;
            //open browser with Google search results
            BrowserUtil.browse(searchAddress);
        }
        else{
            Messages.showMessageDialog("No text selected","Error Message",Messages.getInformationIcon());
        }
    }
}
