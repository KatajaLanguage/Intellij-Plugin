package com.github.katajalanguage.intellijplugin.parser

import com.github.katajalanguage.intellijplugin.file.KatajaFile
import com.github.katajalanguage.intellijplugin.language.KatajaLanguage
import com.github.katajalanguage.intellijplugin.lexer.KatajaLexer
import com.github.katajalanguage.intellijplugin.lexer.KatajaTokenTypes
import com.github.katajalanguage.intellijplugin.psi.KatajaTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class KatajaParserDefinition: ParserDefinition {

    companion object{
        private val FILE = IFileElementType(KatajaLanguage)
    }

    override fun createLexer(project: Project?): Lexer = KatajaLexer()

    override fun createParser(project: Project?): PsiParser =
        KatajaParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = TokenSet.create(KatajaTokenTypes.COMMENT)

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun createElement(node: ASTNode?): PsiElement = KatajaTypes.Factory.createElement(node)

    override fun createFile(fileViewProvider: FileViewProvider): PsiFile = KatajaFile(fileViewProvider)
}