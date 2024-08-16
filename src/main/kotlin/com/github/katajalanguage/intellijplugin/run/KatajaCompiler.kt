package com.github.katajalanguage.intellijplugin.run

import com.github.katajalanguage.intellijplugin.KatajaIcons
import com.intellij.openapi.projectRoots.*
import org.jdom.Element
import java.io.File
import java.util.jar.JarFile
import javax.swing.Icon

class KatajaCompiler: SdkType("Kataja Compiler"){

    override fun getPresentableName(): String = "Kataja Compiler"

    override fun suggestHomePath(): String? = null

    override fun getDownloadSdkUrl(): String = "https://github.com/KatajaLanguage/Compiler/tree/master/releases"

    override fun getIcon(): Icon = KatajaIcons.FILE

    override fun getVersionString(sdk: Sdk): String? = sdk.homePath?.let { getVersionString(it) }

    override fun getVersionString(sdkHome: String): String? {
        if(!isValidSdkHome(sdkHome)) return null

        var name = File(sdkHome).listFiles().get(0).name.substring(0, File(sdkHome).listFiles().get(0).name.lastIndexOf('.'))
        if(name.last().isDigit()){
            val version = StringBuilder()

            while(name.last().isDigit() || name.last() == '.'){
                if(name.last() == '.'){
                    name = name.substring(0, name.length - 1)
                    if(!name.last().isDigit()) break
                    version.append('.')
                }

                version.append(name.last())
                name = name.substring(0, name.length - 1)
            }

            return version.reverse().toString()
        }

        return null
    }

    override fun saveAdditionalData(data: SdkAdditionalData, element: Element) {}

    override fun isValidSdkHome(path: String): Boolean{
        val folder = File(path)

        if(folder.exists() && folder.isDirectory && folder.listFiles().size == 1){
            val file = folder.listFiles().get(0)

            if(file.isFile && file.name.split(".")[file.name.split(".").size - 1] == "jar"){
                val jar = JarFile(file)

                try {
                    jar.getJarEntry("com/github/ktj/compiler/Compiler.class")
                }catch(e: Exception){
                    return false
                }
                return true
            }
        }

        return false
    }

    override fun suggestSdkName(p0: String?, path: String): String{
        var result = "Kataja Compiler"

        var name = File(path).listFiles().get(0).name.substring(0, File(path).listFiles().get(0).name.lastIndexOf('.'))
        if(name.last().isDigit()){
            val version = StringBuilder()

            while(name.last().isDigit() || name.last() == '.'){
                if(name.last() == '.'){
                    name = name.substring(0, name.length - 1)
                    if(!name.last().isDigit()) break
                    version.append('.')
                }

                version.append(name.last())
                name = name.substring(0, name.length - 1)
            }

            result = "Kataja-"+version.reverse()
        }

        return result
    }

    override fun createAdditionalDataConfigurable(model: SdkModel, modificator: SdkModificator): AdditionalDataConfigurable? = null
}