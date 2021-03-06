/*
 * Scala (https://www.scala-lang.org)
 *
 * Copyright EPFL and Lightbend, Inc.
 *
 * Licensed under Apache License 2.0
 * (http://www.apache.org/licenses/LICENSE-2.0).
 *
 * See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 */

package scala.tools.nsc

import interpreter._
import java.io._

/** A compatibility stub for sbt.
 */
@deprecated("Use scala.tools.nsc.interpreter.ILoop.", "2.9.0")
class InterpreterLoop(in0: Option[BufferedReader], out: PrintWriter) extends ILoop(in0, out) {
  def this(in0: BufferedReader, out: PrintWriter) = this(Some(in0), out)
  def this() = this(None, new PrintWriter(scala.Console.out))

  override protected final val isSbt = true

  @deprecated("use `process` instead", "2.9.0")
  def main(settings: Settings): Unit = process(settings) //used by sbt
}
