package com.oile.plugins.action;

import com.intellij.database.psi.DbTable;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiElement;
import com.oile.plugins.ui.MainUI;
import org.jetbrains.annotations.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: Nie Xianglin
 * Date: 2019/4/16
 * Time: 13:16
 * Desc:
 */
public class MusicAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        new MainUI(e);
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        super.update(e);
    }
}
