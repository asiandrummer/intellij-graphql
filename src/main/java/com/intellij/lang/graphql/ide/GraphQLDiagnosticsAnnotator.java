package com.intellij.lang.graphql.ide;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.ExternalAnnotator;
import com.intellij.lang.graphql.psi.GraphQLFile;
import com.intellij.lang.graphql.service.GraphQLLanguageServiceClient;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiFile;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class GraphQLDiagnosticsAnnotator extends ExternalAnnotator<List<Diagnostic>, List<Diagnostic>> {
  private GraphQLLanguageServiceClient client;

  @Nullable
  @Override
  public List<Diagnostic> collectInformation(@NotNull PsiFile file, @NotNull Editor editor, boolean hasErrors) {
    if (file instanceof GraphQLFile) {
      if (this.client == null) {
        this.client = new GraphQLLanguageServiceClient(file.getProject());
      }
      return this.client.getDiagnosticList();
    }
    return null;
  }

  @Nullable
  @Override
  public List<Diagnostic> doAnnotate(List<Diagnostic> collectedInfo) {
    return collectedInfo;
  }

  private TextRange getTextRange(String text, Range range) {
    Position start = range.getStart();
    Position end = range.getEnd();
    String[] lines = text.split("\n");
    int startRange = 0;
    int endRange = 0;
    for (int i = 0; i <= end.getLine(); i++) {
      if (i < start.getLine()) {
        startRange += lines[i].length() + 1;
        endRange += lines[i].length() + 1;
      } else if (i == start.getLine() || i == end.getLine()) {
        startRange += start.getCharacter();
        if (i == end.getLine()) {
          endRange += end.getCharacter();
        } else {
          endRange += lines[i].length() + 1;
        }
      } else if (i < end.getLine()) {
        endRange += lines[i].length() + 1;
      }
    }
    return new TextRange(startRange, endRange);
  }

  @Override
  public void apply(@NotNull PsiFile file, List<Diagnostic> annotationResult, @NotNull AnnotationHolder holder) {
    if (annotationResult != null) {
      if (annotationResult.size() == 0) {
        // There might be a slight delay within the event loop, therefore diagnostic list may not be available yet.
        // Try getting directly from the client.
        annotationResult = this.client.getDiagnosticList();
      }
      for (int i = 0; i < annotationResult.size(); i++) {
        Diagnostic diagnostic = annotationResult.get(i);
        TextRange range = this.getTextRange(file.getText(), diagnostic.getRange());
        String diagnosticMessage = diagnostic.getMessage();
        if (
          diagnostic.getSource().compareTo("GraphQL: Validation") == 0 ||
          diagnostic.getSource().compareTo("GraphQL: Deprecation") == 0
        ) {
          diagnosticMessage = diagnostic.getSource() + " " + diagnostic.getMessage();
        }
        holder.createErrorAnnotation(range, diagnosticMessage);
      }
    }

    System.out.println("annotating");
  }
}
