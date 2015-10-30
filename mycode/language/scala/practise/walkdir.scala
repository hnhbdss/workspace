object Main extends App {
    import java.io.File
    def subdir(dir : File) : Iterator[File] = {
    	var curDirs = dir.listFiles.filter(_.isDirectory).toIterator
	curDirs ++ curDirs.flatMap(subdir _)
    }

    for (d <- subdir(new File("."))) { println(d) }
}  