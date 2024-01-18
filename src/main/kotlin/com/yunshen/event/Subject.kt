package com.yunshen.event

import com.yunshen.data.QMessage
import com.yunshen.entity.BotPlugin
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

class Subject(json :QMessage) {
    init {
        val classes = scanClasses()
        for (clazz in classes) {
            if(clazz.java.isAnnotationPresent(BotPlugin::class.java)){
                val createInstance: MessageEvent = clazz.createInstance() as MessageEvent
                CoroutineScope(Dispatchers.Default).launch {
                    if(createInstance.sendMessage(json)){
                        return@launch
                    }
                }
            }
            }
        }
    }

    private fun scanClasses(): List<KClass<*>> {
        val packageName = "com.yunshen.event.plugin" // 指定包名
        val classes: MutableList<KClass<*>> = ArrayList()
        val packagePath = packageName.replace(".", "/")
        val packageDir = File(ClassLoader.getSystemResource(packagePath).path)
        scanClasses(packageDir, packageName, classes)
        return classes
    }

    private fun scanClasses(dir: File, packageName: String, classes: MutableList<KClass<*>>) {
        if (!dir.exists() || !dir.isDirectory) {
            return
        }

        val files = dir.listFiles()
        for (file in files!!) {
            if (file.isDirectory) {
                scanClasses(file, packageName + "." + file.name, classes)
            } else if (file.name.endsWith(".class")) {
                val className = packageName + "." + file.name.replace(".class", "")
                try {
                    val clazz = Class.forName(className).kotlin
                    classes.add(clazz)
                } catch (e: ClassNotFoundException) {
                    e.printStackTrace()
                }
            }
        }
    }