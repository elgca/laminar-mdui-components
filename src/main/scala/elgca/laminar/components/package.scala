package elgca.laminar

package object components {
  inline def codeFileName: String = {
    Thread
      .currentThread()
      .getStackTrace()
      .drop(1)                     // 跳过第一个元素，它是getStackTrace()方法本身的调用
      .find(_.getFileName != null) // 查找第一个具有非空文件名的堆栈帧
      .map(_.getFileName)          // 获取文件名
      .getOrElse("")
  }
}
