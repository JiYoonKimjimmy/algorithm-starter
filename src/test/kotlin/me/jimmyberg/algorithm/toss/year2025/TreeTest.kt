package me.jimmyberg.algorithm.toss.year2025

import org.junit.jupiter.api.Test

class Tree {

    companion object {
        val rootDir = Directory(name = "root", depth = 0)
    }

    data class Directory(
        val name: String,
        val depth: Int,
        val files: MutableList<File> = mutableListOf()
    ) {
        val children: MutableList<Directory> = mutableListOf()
    }

    data class File(
        val name: String
    )

    val directories = mutableListOf(rootDir)

    fun addFile(path: String) {
        var parent = rootDir
        path.split('/').forEachIndexed { depth, name ->
            if (isDirectory(name)) {
                parent = createDirectory(name, depth + 1, parent)
            } else {
                parent.files += File(name)
            }
        }

    }

    fun addDirectory(path: String) {
        var parent = rootDir
        path.split("/").forEachIndexed { depth, name ->
            if (isDirectory(name)) {
                parent = createDirectory(name, depth + 1, parent)
            }
        }
    }

    fun print(
        depth: Int = 0,
        onlyDir: Boolean = false
    ) {
        directories
            .filter { it.depth == depth }
            .forEach { print(directory = it, onlyDir = onlyDir) }
    }

    private fun isDirectory(name: String): Boolean {
        return name.contains('.').not()
    }

    private fun createDirectory(name: String, depth: Int, parent: Directory): Directory {
        val dir = directories.find { it.name == name && it.depth == depth }
        return if (dir == null) {
            val newDir = Directory(name, depth)
            directories += newDir
            parent.children += newDir
            newDir
        } else {
            dir
        }
    }

    private fun print(directory: Directory, onlyDir: Boolean = false) {
        val name = directory.name
        val depth = directory.depth
        val files = directory.files
        val children = directory.children

        println("${"-".repeat(depth)}$name")
        if (!onlyDir) {
            files.forEach {
                println("${"-".repeat(depth + 1)}${it.name}")
            }
        }
        children.forEach { print(directory = it, onlyDir = onlyDir) }
    }

}

class TreeTest {

    private val tree = Tree()

    @Test
    fun test() {
        tree.addFile("README.md")

        tree.addDirectory("docs")
        tree.addDirectory("docs/images")

        tree.addFile("docs/images/hello.png")
        tree.addFile("docs/hello.txt")

        tree.addFile("src/kotlin/Hello.kt")
        tree.addFile("src/kotlin/me/jimmyberg/Test.kt")

        println("===== tree.print() =====")
        tree.print()

        println("===== tree.print(depth = 1) =====")
        tree.print(depth = 1)

        println("===== tree.print(depth = 2, onlyDir = true) =====")
        tree.print(depth = 2, onlyDir = true)

        println("===== tree.print(onlyDir = true) =====")
        tree.print(onlyDir = true)
    }

}