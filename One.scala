import processing.core
import processing.core.*
import processing.core.PApplet
import scala.math.Pi

class One extends PApplet:
  // The actual size of our canvas
  val Width = 1000
  val Height = 1000

  // The actual size we'll work with for our flows with extra margin
  val leftX = (Width * -0.5).toInt
  val rightX = (Width * 1.5).toInt
  val topY = (Height * -0.5).toInt
  val bottomY = (Height * 1.5).toInt

  // The resolution, which will impact how many cols and rows are on the canvas
  val resolution = (Width * 0.01).toInt

  val numCols = (rightX - leftX) / resolution
  val numRows = (bottomY - topY) / resolution
  val grid = Array.ofDim[Double](numCols, numRows)

  override def settings(): Unit =
    size(Width, Height)

  override def draw(): Unit =
    background(255)

    // Drawing out all the arrows in the grid
    for col <- 0 until numCols do
      for row <- 0 until numRows do
        val x = (col * resolution)
        val y = (row * resolution)
        val angle = Pi * 0.25
        drawArrow(x, y, angle, resolution - 2)

  /** Given x and y coordinates we "GOTO" that part of the grid and then draw an
    * arrow showing the given angle.
    */
  def drawArrow(x: Double, y: Double, angle: Double, len: Double): Unit =
    // To better understand what is going on here with push/popMatrix,
    // check out https://processing.org/tutorials/transform2d.
    pushMatrix()

    translate(x.toFloat, y.toFloat)
    rotate(angle.toFloat)

    val arrowSize = 2
    val lineLength = len.toFloat - arrowSize

    line(0, 0, lineLength, 0)

    triangle(
      lineLength,
      0,
      lineLength - arrowSize,
      (arrowSize / 2).toFloat,
      lineLength - arrowSize,
      (-arrowSize / 2).toFloat
    )

    popMatrix()
end One
